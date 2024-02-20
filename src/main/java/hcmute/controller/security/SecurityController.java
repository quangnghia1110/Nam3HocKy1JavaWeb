package hcmute.controller.security;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import hcmute.entity.MilkTeaEntity;
import hcmute.entity.UserEntity;
import hcmute.model.AuthProvider;
import hcmute.repository.UserRepository;
import hcmute.service.IForgotPasswordService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IUserService;
import hcmute.service.impl.CookieServiceImpl;
import hcmute.service.impl.ParamServiceImpl;
import hcmute.service.impl.SessionServiceImpl;
import hcmute.utils.CommonUtils;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("security")
public class SecurityController {
	@Autowired
	IUserService userService;
	@Autowired
	UserRepository repo;
	@Autowired
	IForgotPasswordService passService;

	@Autowired
	ParamServiceImpl paramService;
	@Autowired
	CookieServiceImpl cookieService;
	@Autowired
	SessionServiceImpl sessionService;
	
//////////////Forgot-password//////////////
	@GetMapping("forgot-password")
	public String IndexForgotPassword() {
		return "security/forgot-password/forgot-password";
	}
	
	@GetMapping("forgot-password-success")
	public String IndexForgotPasswordSuccess(ModelMap model) {
		model.addAttribute("message", "Chúng tôi đã gửi liên kết đặt lại mật khẩu đến email của bạn. Vui lòng dành thời gian để kiểm tra.");
		return "security/forgot-password/forgot-password";
	}
	
	@PostMapping("forgot-password")
	public ModelAndView postsend(ModelMap model, HttpServletRequest req) throws MessagingException {
		String email = req.getParameter("forgotEmail");
		String token = RandomString.make(30);
		UserEntity user = repo.findByEmail(email).orElse(null);
		if (!repo.existsUserByEmail(email)) {
			model.addAttribute("message", "Email không tồn tại!!");
			return new ModelAndView("security/forgot-password/forgot-password", model);
		}
		if (user.getProvider() != AuthProvider.DATABASE) {
			model.addAttribute("message", "Không thể khôi phục tài khoản!!");
			return new ModelAndView("security/forgot-password/forgot-password", model);
		}

		try {
			passService.updateResetPasswordToken(token, email);
			String resetPasswordLink = CommonUtils.getSiteURL(req) + "/security/change-password?token=" + token;
			passService.sendEmail(email, resetPasswordLink);
		} catch (Exception e) {
			model.addAttribute("message", "Có gì đó không ổn. Vui lòng thử lại sau.");
		}
		return new ModelAndView("redirect:/security/forgot-password-success", model);
	}
	
	
//////////////Login//////////////
	@GetMapping("login")
	public String IndexLogin(ModelMap model) {
		 model.addAttribute("username", cookieService.getValue("username"));
         model.addAttribute("password", cookieService.getValue("password"));
		return "security/login/login";
	}
	
//	@PostMapping("login")
//	public String login(ModelMap model, HttpServletRequest req) throws MessagingException {
//	    String username = paramService.getString("username", "");
//	    String password = paramService.getString("password", "");
//	    
//	    Optional<UserEntity> userOptional = userService.findByUsername(username);
//	    
//	    if (userOptional.isPresent()) {
//	        UserEntity user = userOptional.get();
//	        
//	        if (user.getUsername().equals(username) && user.getPassword().equalsIgnoreCase(password)) {
//	            // Correct username and password
//	            sessionService.setAttribute("username", username);
//	            cookieService.Add("username", username, 1);
//	            cookieService.Add("password", password, 1);
//	            model.addAttribute("username", cookieService.getValue("username"));
//	            model.addAttribute("password", cookieService.getValue("password"));
//	            return "redirect:/home";
//	        }
//	    }
//	    
//	    // Incorrect username or password, handle accordingly (e.g., show error message)
//	    model.addAttribute("loginError", "Invalid credentials");
//	    return "loginPage"; // Adjust the view name accordingly
//	}


	
//////////////Register//////////////
	@GetMapping("register")
	public String IndexRegister(ModelMap model) {
		return "security/register/register";
	}

	@PostMapping("register")
	public String register(Model model, @ModelAttribute UserEntity user, HttpServletRequest req)
			throws MessagingException {
		Optional<UserEntity> existUserByEmail = userService.findByEmail(user.getEmail());
		Optional<UserEntity> existUserByUsername = userService.findByUsername(user.getUsername());
		if (existUserByEmail.isPresent()) {
			model.addAttribute("message", "Người dùng với email " + user.getEmail() + " đã được đăng ký trước đó");
			return "security/register/register";
		}
		if (existUserByUsername.isPresent()) {
			model.addAttribute("message", "Người dùng với username " + user.getUsername() + " đã được đăng ký trước đó");
			return "security/register/register";
		}
		userService.register(user, CommonUtils.getSiteURL(req));
		model.addAttribute("message", "Vui lòng kiếm tra email để xác nhận tại khoản của bạn");
		return "security/register/register";
	}
//////////////Change-Password//////////////
	@GetMapping("change-password")
    public String showResetPassword(@RequestParam("token") String token, ModelMap model) {
        UserEntity user = passService.getByResetPasswordToken(token);
        model.addAttribute("token", token);
        if (user == null) {
            model.addAttribute("message", "Mã Token không hợp lệ, vui lòng thử lại.");
        }
        return "security/change-password/change-password";
    }
	
    @PostMapping("change-password")
    public ModelAndView processResetPassword(HttpServletRequest request, ModelMap model) {
        String token = request.getParameter("token");
        System.out.println(token);
        String password = request.getParameter("password");
        UserEntity user = passService.getByResetPasswordToken(token);
        if (user == null) {
            return new ModelAndView("redirect:/", model);
        } else {
            passService.updatePassword(user, password);
        }
        return new ModelAndView("redirect:/", model);
    }
//////////////Logout//////////////
    @GetMapping("logout")
	public String logoffSuccess(Model model, HttpSession session) {
		session.removeAttribute("username");
		return "security/login/login";
	}
	@GetMapping("logout/success")
	public String logoutSuccess(Model model) {
	    model.addAttribute("message", "Bạn vừa mới đăng xuất thành công");
	    return "security/login/login";
	}
	
//////////////Khi tài khoản không có quyền truy cập//////////////
	@GetMapping("unauthorized")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Truy cập bị từ chối, bạn không có đủ quyền, vui lòng liên hệ quản trị viên để được cấp quyền!");
		return "error/403";
	}

//////////////Kiểm tra xác nhận email//////////////
	@GetMapping("verify")
	public String verifyAcc(Model model, @RequestParam String code) {
		if (userService.verify(code)) {
			model.addAttribute("message", "Xác thực thành công");
			return "redirect:/security/login";
		} else {
			model.addAttribute("message", "Xác thực thất bại");
			return "security/security/login";
		}
	}
}

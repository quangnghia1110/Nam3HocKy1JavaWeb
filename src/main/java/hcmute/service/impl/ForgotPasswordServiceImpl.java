package hcmute.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hcmute.entity.UserEntity;
import hcmute.exception.ResourceNotFoundException;
import hcmute.repository.UserRepository;
import hcmute.service.IForgotPasswordService;


@Service
public class ForgotPasswordServiceImpl implements IForgotPasswordService {

    @Autowired
    UserRepository repo;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void updateResetPasswordToken(String token, String email) throws Exception {
        UserEntity user = repo.findByEmail(email).orElse(null);
        if (user != null) {
            user.setReset_pwd_token(token);
            repo.save(user);
        } else {
            throw new ResourceNotFoundException("User", "Email", email);
        }
    }

    @Override
    public UserEntity getByResetPasswordToken(String token) {
        return repo.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(UserEntity user, String newPass) {
        String encodedPass = passwordEncoder.encode(newPass);
        user.setPassword(encodedPass);
        user.setReset_pwd_token(null);
        repo.save(user);

    }

    @Override
    public void sendEmail(String recipientEmail, String link) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        try {
            helper.setTo(recipientEmail);
            helper.setSubject("MilkTea - Reset password");

            String content = "<html><body>"
                    + "<p>Xin chào bạn,</p>"
                    + "<p>Bạn đã yêu cầu đặt lại mật khẩu của mình.</p>"
                    + "<p>Vui lòng nhấp vào liên kết bên dưới để thay đổi mật khẩu của bạn:</p>"
                    + "<p><a href=\"" + link + "\">Change my password</a></p>"
                    + "<br>"
                    + "<p>Bỏ qua email này nếu bạn đã nhớ mật khẩu của mình hoặc bạn chưa thực hiên yêu cầu. </p"
                    + "<p>Trân trọng!.</p>"
                    + "</body></html>";

            helper.setText(content, true); // Set the content as HTML

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
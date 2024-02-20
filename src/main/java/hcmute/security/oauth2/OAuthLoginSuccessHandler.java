package hcmute.security.oauth2;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import hcmute.entity.CartEntity;
import hcmute.entity.UserEntity;
import hcmute.service.ICartService;
import hcmute.service.IUserService;

@Component
public class OAuthLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private IUserService userService;

    @Autowired
	ICartService cartService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
        String oauth2ClientName = oauth2User.getOauth2ClientName();
        String username = oauth2User.getName();
        String email = oauth2User.getEmail();

        // Retrieve the user ID from the database
        Optional<UserEntity> userOptional = userService.getUserByEmail(email);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Long userId = (long) user.getId();

            // Process OAuth post-login actions in the service
            userService.processOAuthPostLogin(username, email, oauth2ClientName);
            userService.updateAuthenticationTypeOAuth(email, oauth2ClientName);

            // Set the user ID as a cookie
            Optional<CartEntity> cartOpt = cartService.findCartsByUserId(userId.intValue());
            if (cartOpt.isEmpty()) {
                CartEntity entity = new CartEntity();
                entity.setTotalPrice(0);
                entity.setTotalProduct(0);
                entity.setCustomerByCart(user);
                cartService.save(entity);
            }
            saveUserIdToCookie(request, response, String.valueOf(userId));
        }

        // Redirect to the home page
        getRedirectStrategy().sendRedirect(request, response, "/home");
    }

    private void saveUserIdToCookie(HttpServletRequest request, HttpServletResponse response, String userId) {
        Cookie userIdCookie = new Cookie("USER_ID", String.valueOf(userId));
        userIdCookie.setMaxAge(86400); // Cookie lasts for 24 hours
        userIdCookie.setPath("/");
        response.addCookie(userIdCookie);
    }
}

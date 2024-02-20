package hcmute.security.oauth2;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
//Bao bọc thông tin người dùng từ đối tượng OAuth2User
public class CustomOAuth2User implements OAuth2User {
    private OAuth2User oauth2User;
    private String oauth2ClientName;

    public CustomOAuth2User(OAuth2User oauth2User, String oauth2ClientName) {
        this.oauth2User = oauth2User;
        this.oauth2ClientName = oauth2ClientName;
    }
    
    //Trả về các thuộc tính của người dùng
    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    //Trả về danh sách các quyền
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    public String getId() {
    	return oauth2User.getAttribute("id");
    }
    public String getName() {
        return oauth2User.getAttribute("name");
    }

    public String getEmail() {
        return oauth2User.<String>getAttribute("email");
    }

    public String getOauth2ClientName() {
        return this.oauth2ClientName;
    }

}

package hcmute.security.oauth2.user;

import java.util.Map;

public abstract class OAuth2UserInfo {
    //Chứa thông tin người dùng được trả về từ OAuth2
	protected Map<String, Object> attributes;
	//Constructor 
    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    //Phương thức trả về Map
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    //Phương thức trừu tượng
    public abstract String getId();
    public abstract String getName();
    public abstract String getEmail();
}
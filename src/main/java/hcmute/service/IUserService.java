package hcmute.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import hcmute.entity.UserEntity;

public interface IUserService {

    Optional<UserEntity> findById(Integer id);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    UserEntity update(UserEntity user);

    void deleteByUsername(String id);

    List<UserEntity> findAll();

    List<UserEntity> getAdministators();

    void register(UserEntity user, String url) throws MessagingException;

    void sendVerifyEmail(UserEntity user, String url) throws MessagingException;

    boolean verify(String verifyCode);

    //Set thông tin xuống cơ sở dữ liệu cho OAuth
    void processOAuthPostLogin(String username, String email, String oauth2ClientName);

    //Update thông tin theo OAuth
    void updateAuthenticationTypeOAuth(String username, String oauth2ClientName);

    //Update thông tin theo DB
    void updateAuthenticationTypeDB(String username, String oauth2ClientName);
    

	Optional<UserEntity> getUserById(int userId);

	Optional<UserEntity> getUserByEmail(String email);
    <S extends UserEntity> S save(S entity);
}

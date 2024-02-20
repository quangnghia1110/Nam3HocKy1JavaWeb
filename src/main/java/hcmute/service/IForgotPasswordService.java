package hcmute.service;

import hcmute.entity.UserEntity;

public interface IForgotPasswordService {
    void updateResetPasswordToken(String token, String email) throws Exception;

    UserEntity getByResetPasswordToken(String token);

    void updatePassword(UserEntity account, String newPass);

    void sendEmail(String recipientEmail, String link);
}

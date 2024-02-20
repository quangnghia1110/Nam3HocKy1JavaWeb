package hcmute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hcmute.entity.UserEntity;
import hcmute.model.AuthProvider;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    public Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
    public Optional<UserEntity> findByEmail(String email);

    @Query("SELECT DISTINCT ur.user FROM UserRoleEntity ur WHERE ur.role.id IN ('ADMIN', 'USER', 'MANAGER')")
    public List<UserEntity> getAdministrators();

    @Query("SELECT u FROM UserEntity u WHERE u.reset_pwd_token = ?1")
    public UserEntity findByResetPasswordToken(String token);

    @Query("SELECT o FROM UserEntity o WHERE verify_code=?1")
    public UserEntity findByVerifyCode(String code);

    // Derived Query - for checking if User exist by email
    public boolean existsUserByEmail(String email);

    // Derived Query - for checking if User exist by id
    public boolean existsUserById(String id);

    // @Query("SELECT o FROM User o WHERE username=?1")
    @Modifying
    @Query("DELETE FROM UserEntity WHERE username=?1")
    public void deleteByUsername(String username);


    @Modifying
    @Query("UPDATE UserEntity u SET u.provider = ?2 WHERE u.email = ?1")
    public void updateAuthenticationTypeOAuth(String email, AuthProvider provider);

    @Modifying
    @Query("UPDATE UserEntity u SET u.provider = ?2 WHERE u.username = ?1")
    public void updateAuthenticationTypeDB(String username, AuthProvider provider);

}

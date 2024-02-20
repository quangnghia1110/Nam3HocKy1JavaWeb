package hcmute.service;
import java.util.List;
import java.util.Optional;

import hcmute.entity.UserEntity;
import hcmute.entity.UserRoleEntity;

public interface IUserRoleService {
    List<UserRoleEntity> findRolesOfAdministrators();

    List<UserRoleEntity> findAll();

    UserRoleEntity create(UserRoleEntity auth);

    void delete(Integer id);
    
    int countUser();
    
    List<UserRoleEntity> findByRoleId(String name);
    
    Optional<UserRoleEntity> findById(Integer id);
    
    <S extends UserRoleEntity> S save(S entity);
}

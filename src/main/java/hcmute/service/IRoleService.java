package hcmute.service;




import java.util.List;
import java.util.Optional;

import hcmute.entity.RoleEntity;

public interface IRoleService {
    public List<RoleEntity> findAll() ;
    Optional<RoleEntity> findById(String id);
}

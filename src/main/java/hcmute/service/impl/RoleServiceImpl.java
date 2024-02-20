package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.RoleEntity;
import hcmute.repository.RoleRepository;
import hcmute.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleRepository repo;

    @Override
    public List<RoleEntity> findAll() {
        return repo.findAll();
    }
    
    @Override
	public Optional<RoleEntity> findById(String id) {
		return repo.findById(id);
	}
}

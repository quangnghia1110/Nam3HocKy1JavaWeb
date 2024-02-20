package hcmute.security;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hcmute.entity.UserEntity;
import hcmute.repository.UserRepository;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Thực hiện truy vấn dựa theo từng username
    	Optional<UserEntity> user = userRepo.findByUsername(username);
        //Đưa ra thông báo lỗi khi không thấy username
    	user.orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));
        //Ánh xạ UserEntity sang CustomUserDetails
    	return user.map(CustomUserDetails::new).get();
    }


}
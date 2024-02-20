package hcmute.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import hcmute.entity.UserEntity;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String userId;
	private UserEntity user;

	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String userId) {
		// Khởi tạo các thuộc tính khác
		this.userId = userId;
	}
	
	 public CustomUserDetails(UserEntity user) {
	        this.user = user;
	    }

	// Các phương thức khác của UserDetails

	public String getUserId() {
		return userId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities().stream().map(au -> new SimpleGrantedAuthority(au.getRole().getId()))
				.peek(System.out::println).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}
}
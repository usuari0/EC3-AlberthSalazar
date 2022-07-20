package com.idat.hospital.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		if( "profesor".equals(username)){
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority grantes = new SimpleGrantedAuthority("USER");
			listGranted.add(grantes);
			
			return new User("profesor",new BCryptPasswordEncoder().encode("123456") , listGranted);
		}if( "alumno".equals(username)){
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority grantes = new SimpleGrantedAuthority("USER");
			listGranted.add(grantes);
			
			return new User("alumno",new BCryptPasswordEncoder().encode("123456") , listGranted);
		}if( "desconocido".equals(username)){
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority grantes = new SimpleGrantedAuthority("USER");
			listGranted.add(grantes);
			
			return new User("desconocido",new BCryptPasswordEncoder().encode("123456") , listGranted);
		}
		else
			throw new UsernameNotFoundException("Usuario no existe " + username);
	}
}

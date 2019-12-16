package com.cabinetmedical.pfa.security;


import com.cabinetmedical.pfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.cabinetmedical.pfa.classe.User user = userService.loadUserByUsername(username);
        if( user == null )throw new UsernameNotFoundException("User not found");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( r->{
            authorities.add(new SimpleGrantedAuthority(r.getLibelle()));
        });
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}

package MyProject.webapp.service;


import MyProject.webapp.modle.entity.AuthLoginEntity;
import MyProject.webapp.repository.AuthJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class AuthConfig implements UserDetailsService {
    @Autowired
    private AuthJPARepository authJPARepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthLoginEntity> login = authJPARepository.findByUserName(username);
        if (login.isEmpty()) {
            throw new UsernameNotFoundException("user name or password not exits");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(login.get().getUserName(), login.get().getPassword(), authorities);
    }

    public UserDetails loadUserById(int id) throws UsernameNotFoundException {
        Optional<AuthLoginEntity> login = authJPARepository.findById(id);
        if (login.isEmpty()) {
            throw new UsernameNotFoundException("user name or password not exits");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(login.get().getUserName(), login.get().getPassword(), authorities);
    }
}

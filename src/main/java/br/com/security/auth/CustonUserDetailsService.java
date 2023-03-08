package br.com.security.auth;

import br.com.security.model.User;
import br.com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustonUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existsUser = repository.findByUsernameFecthRoles(username);

        if(existsUser == null){
            throw  new Error("User does not exists");
        }
        return UserPrincipal.create(existsUser);

    }
}

package br.com.security.resource;

import br.com.security.model.Role;
import br.com.security.model.User;
import br.com.security.repository.RoleRepository;
import br.com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        List<Role> roles = new ArrayList<>();
        for(Role r: user.getRoles()){
            roles.add(roleRepository.findById(r.getId()).get());
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return repository.save(user);
    }
}

package br.com.security.resource;

import br.com.security.model.Role;
import br.com.security.model.User;
import br.com.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleResource {

    @Autowired
    RoleRepository repository;

    @PostMapping("/create")
    public Role create(@RequestBody Role role){
        return repository.save(role);
    }
}

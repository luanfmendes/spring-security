package br.com.security.resource;

import br.com.security.model.User;
import br.com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserRepository repository;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return repository.save(user);
    }
}

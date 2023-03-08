package br.com.security.resource;

import br.com.security.model.Product;
import br.com.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    ProductRepository repository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public List<Product> listar(){
        return repository.findAll();
    }
}

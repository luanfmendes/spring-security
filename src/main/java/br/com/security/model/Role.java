package br.com.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    public Role(UUID id){
        this.id = id;
    }

}

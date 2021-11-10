package com.lenaHelen17.project;

import lombok.*;

import javax.management.relation.Role;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String email;
    
    private String firstName;

    private String lastName;

    private String password;

    private Set<Role> roles;
}


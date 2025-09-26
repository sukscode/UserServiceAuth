package dev.sukriti.userserviceauth.Models;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class User extends BaseModel {
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
}

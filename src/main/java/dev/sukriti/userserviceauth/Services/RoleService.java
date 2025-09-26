package dev.sukriti.userserviceauth.Services;

import dev.sukriti.userserviceauth.Models.Role;
import dev.sukriti.userserviceauth.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name) {
        Role role = new Role();
//        role.setRole(name);

        return roleRepository.save(role);
    }
}

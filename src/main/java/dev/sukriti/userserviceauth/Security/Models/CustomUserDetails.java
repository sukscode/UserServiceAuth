package dev.sukriti.userserviceauth.Security.Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.sukriti.userserviceauth.Models.Role;
import dev.sukriti.userserviceauth.Models.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
public class CustomUserDetails implements UserDetails {
    private final List<GrantedAuthority> grantedAuthorities;
    private final String username;
    private final String password;
    @Getter
    private final Long userId;
    private final boolean AccountNonExpired;
    private final boolean AccountNonLocked;
    private final boolean CredentialsNonExpired;
    private final boolean Enabled;


    //private final User user;
    public CustomUserDetails(User user, Long userId) {
        this.userId = userId;
        grantedAuthorities= new ArrayList<>();

        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new CustomGrantedAuthority(role));
        }
        this.password = user.getPassword();
        this.username = user.getEmail();
        this.AccountNonExpired = true;
        this.AccountNonLocked = true;
        this.CredentialsNonExpired = true;
        this.Enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        grantedAuthorities= new ArrayList<>();
//
//        for (Role role : user.getRoles()) {
//            grantedAuthorities.add(new CustomGrantedAuthority(role));
//        }
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.AccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.AccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.CredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.Enabled;
    }

}

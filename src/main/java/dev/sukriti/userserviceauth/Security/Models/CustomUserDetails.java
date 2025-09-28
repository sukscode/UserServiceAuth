package dev.sukriti.userserviceauth.Security.Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.sukriti.userserviceauth.Models.Role;
import dev.sukriti.userserviceauth.Models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    private  List<GrantedAuthority> authorities;
    private  String username;
    private  String password;
    @Getter
    @Setter
    private  Long userId;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;


    //private final User user;
    public CustomUserDetails(User user) {

//        this.user = user;
        authorities = new ArrayList<>();

        for (Role role: user.getRoles()) {
            authorities.add(new CustomGrantedAuthority(role));
        }

        this.password = user.getPassword();
        this.username = user.getEmail();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.userId = user.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        grantedAuthorities= new ArrayList<>();
//
//        for (Role role : user.getRoles()) {
//            grantedAuthorities.add(new CustomGrantedAuthority(role));
//        }
        return this.authorities;
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
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}

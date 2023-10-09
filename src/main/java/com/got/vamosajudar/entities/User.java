package com.got.vamosajudar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.got.vamosajudar.controllers.user.dto.RegisterDTO;
import com.got.vamosajudar.controllers.user.dto.UserDto;
import com.got.vamosajudar.entities.dao.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users_tbl")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    @JsonIgnore
    private String password;

    private String email;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String image;

    private Boolean active;

    @OneToOne()
    private Ong ong;

    public User(RegisterDTO registerDTO) {
        this.login = registerDTO.login();
        this.password = registerDTO.encryptedPassword();
        this.email = registerDTO.email();
        this.name = registerDTO.name();
        this.active = true;
        this.userRole = UserRole.USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.userRole == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserDto toDto() {
        return new UserDto(this);
    }
}

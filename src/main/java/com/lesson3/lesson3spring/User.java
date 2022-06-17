package com.lesson3.lesson3spring;

import lombok.AccessLevel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Table("users")
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String state;
    private String phone;
    @MappedCollection(idColumn = "user_id")
    private Set<RoleRef> roles = new HashSet<>();

//
    public User(String username, String password, String fullname, String state, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.state = state;
        this.phone = phone;
    }
    public void addRole(Role role){

        roles.add(new RoleRef(role.getId(), role.getName()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return username;
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
}

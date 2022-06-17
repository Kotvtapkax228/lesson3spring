package com.lesson3.lesson3spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;

@Table("USERS_ROLES")
@Data
@AllArgsConstructor
public class RoleRef implements GrantedAuthority {

    Integer roleId;
    String name;

//    public RoleRef(Integer roleId, String name) {
//        this.roleId = roleId;
//        this.name = name;
//    }

    @Override
    public String getAuthority() {
        return name;
    }
}

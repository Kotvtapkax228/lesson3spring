package com.lesson3.lesson3spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import java.util.Set;

@Data
@Table("roles")
@AllArgsConstructor
public class Role /*implements GrantedAuthority*/ {
    @Id
    private Integer id;
    private String name;

    //private Set<User> users;

//    public Role(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }


//    @Override
//    public String getAuthority() {
//        return name;
//    }
}

package com.lesson3.lesson3spring;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("people")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Person implements Persistable {
    @Id
    private Integer id;
    private String name;
    private String surname;

    @Override
    public boolean isNew() {
        return true;
    }
}

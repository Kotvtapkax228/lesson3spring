package com.lesson3.lesson3spring;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class SearchForm {
    private String title;
    private String author;
    private String genre;

}

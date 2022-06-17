package com.lesson3.lesson3spring;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table("books")
public class BookItem {
    @Id
    private Long id;
    private Integer room;
    private Integer stellage;
    private Integer shelve;
    private String title;
    private String author;
    private String genre;
    private Integer year;

    @Override
    public String toString() {
        return "BookItem{" +
                "room=" + room +
                ", stellage=" + stellage +
                ", shelve=" + shelve +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}

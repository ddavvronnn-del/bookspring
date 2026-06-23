package uz.imaan.bookspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private boolean available;


}

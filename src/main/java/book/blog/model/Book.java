package book.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String releaseYear;
    private int rating;
    private String language;

    @ManyToOne
    @JoinColumn(name = "category_id") // "category_id" veritabanı sütun adı, Category sınıfındaki id alanını gösterir
    private Category category;


}

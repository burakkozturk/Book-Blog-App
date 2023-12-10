package book.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "comments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Bir yorum bir kullanıcıya aittir.
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne // Bir yorum bir kitaba aittir.
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne // Bir yorum bir başka yoruma aittir.
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replies;


    private String content;

    private LocalDateTime createdAt;

}

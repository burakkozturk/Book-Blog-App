package book.blog.repository;

import book.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserId(Long userId);
    List<Comment> findByBookId(Long bookId);
    List<Comment> findByAuthorId(Long authorId);

}

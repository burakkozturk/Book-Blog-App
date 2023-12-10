package book.blog.repository;

import book.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserId(Long userId);
    List<Comment> findByBookId(Long bookId);
    List<Comment> findByAuthorId(Long authorId);

}

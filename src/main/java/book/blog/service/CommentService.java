package book.blog.service;


import book.blog.model.Comment;
import book.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        if (commentRepository.existsById(id)) {
            updatedComment.setId(id);
            return commentRepository.save(updatedComment);
        } else {
            // Handle error, comment not found
            return null;
        }
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getAllCommentsByUserId(Long userId){
        return commentRepository.findByUserId(userId);
    }

    public List<Comment> getAllCommentsByBookId(Long bookId){
        return commentRepository.findByUserId(bookId);
    }
    public List<Comment> getAllCommentsByAuthorId(Long authorId){
        return commentRepository.findByUserId(authorId);
    }

}

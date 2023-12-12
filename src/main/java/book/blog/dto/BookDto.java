package book.blog.dto;

import lombok.Data;

@Data
public class BookDto {

    private String name;
    private String releaseDate;
    private int rating;
    private Long authorId; // Yazarın kimliği

    // Gerekirse diğer alanları ekleyebilirsiniz, örneğin: private List<CommentDTO> comments;
}

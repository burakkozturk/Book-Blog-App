package book.blog.controller;

import book.blog.dto.CategoryDto;
import book.blog.model.Category;
import book.blog.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.getCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){

        Category category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDto updatedCategoryDto
    ) {
        Category updatedCategory = Category.builder()
                .name(updatedCategoryDto.getName())
                .build();

        // Kategori güncelleme işlemini gerçekleştir
        Category result = categoryService.updateCategory(id, updatedCategory);

        if (result != null) {
            // Kategori başarıyla güncellendiyse güncellenmiş kategoriyi ve HTTP 200 OK durumunu döndür
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            // Belirtilen ID'ye sahip kategori bulunamazsa HTTP 404 Not Found durumunu döndür
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);

        // Silme işlemi başarılı olduysa HTTP 204 No Content durumunu döndür
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

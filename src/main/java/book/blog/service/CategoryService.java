package book.blog.service;

import book.blog.dto.CategoryDto;
import book.blog.model.Category;
import book.blog.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);
    }

    public Category createCategory(CategoryDto categoryDto){

        String categoryName = categoryDto.getName();

        Category newCategory = Category.builder()
                .name(categoryName)
                .build();

        return categoryRepository.save(newCategory);
    }

    public Category updateCategory(Long categoryId, Category updatedCategory) {
        Optional<Category> existingCategoryOptional = categoryRepository.findById(categoryId);

        if (existingCategoryOptional.isPresent()) {
            Category existingCategory = existingCategoryOptional.get();

            existingCategory.setName(updatedCategory.getName());

            return categoryRepository.save(existingCategory);
        } else {
            return null;
        }
    }


    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}

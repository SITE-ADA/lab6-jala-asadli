package az.edu.ada.wm2.lab6.controller;

import az.edu.ada.wm2.lab6.model.dto.CategoryRequestDto;
import az.edu.ada.wm2.lab6.model.dto.CategoryResponseDto;
import az.edu.ada.wm2.lab6.model.dto.ProductResponseDto;
import az.edu.ada.wm2.lab6.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto dto) {
        CategoryResponseDto createdCategory = categoryService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<CategoryResponseDto> addProductToCategory(@PathVariable UUID categoryId,
                                                                    @PathVariable UUID productId) {
        try {
            CategoryResponseDto updatedCategory = categoryService.addProduct(categoryId, productId);
            return ResponseEntity.ok(updatedCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategory(@PathVariable UUID categoryId) {
        try {
            return ResponseEntity.ok(categoryService.getProducts(categoryId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
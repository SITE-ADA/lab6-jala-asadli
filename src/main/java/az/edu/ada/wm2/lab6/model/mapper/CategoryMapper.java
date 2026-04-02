package az.edu.ada.wm2.lab6.model.mapper;

import az.edu.ada.wm2.lab6.model.Category;
import az.edu.ada.wm2.lab6.model.dto.CategoryRequestDto;
import az.edu.ada.wm2.lab6.model.dto.CategoryResponseDto;

import java.util.ArrayList;
import java.util.UUID;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName(dto.getName());
        category.setProducts(new ArrayList<>());

        return category;
    }

    public static CategoryResponseDto toResponseDto(Category category) {
        if (category == null) {
            return null;
        }

        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }
}
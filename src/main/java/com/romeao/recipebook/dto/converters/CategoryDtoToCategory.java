package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoToCategory implements Converter<CategoryDto, Category> {
    @Override
    public Category convert(CategoryDto categoryDto) {
        if (categoryDto == null) { return null; } else {
            return Category.builder()
                    .id(categoryDto.getId())
                    .description(categoryDto.getDescription())
                    .build();
        }
    }
}

package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDto implements Converter<Category, CategoryDto> {
    @Override
    public CategoryDto convert(Category category) {
        if (category == null) { return null; }

        CategoryDto command = new CategoryDto();
        command.setId(category.getId());
        command.setDescription(category.getDescription());
        return command;
    }
}

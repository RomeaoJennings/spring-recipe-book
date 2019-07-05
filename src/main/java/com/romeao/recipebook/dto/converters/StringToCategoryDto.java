package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import com.romeao.recipebook.repositories.CategoryRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToCategoryDto implements Converter<String, CategoryDto> {

    private final CategoryRepository categoryRepository;

    public StringToCategoryDto(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto convert(String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(Long.valueOf(id));
        return CategoryConverter.toDto(categoryOptional.orElse(null));
    }
}

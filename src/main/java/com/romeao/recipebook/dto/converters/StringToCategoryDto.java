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
    private final CategoryToCategoryDto toCategoryDto;

    public StringToCategoryDto(CategoryRepository categoryRepository,
                               CategoryToCategoryDto toCategoryDto) {
        this.categoryRepository = categoryRepository;
        this.toCategoryDto = toCategoryDto;
    }

    @Override
    public CategoryDto convert(String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(Long.valueOf(id));
        return toCategoryDto.convert(categoryOptional.orElse(null));
    }
}

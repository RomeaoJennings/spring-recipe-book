package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.CategoryCommand;
import com.romeao.recipebook.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if (categoryCommand == null) { return null; } else {
            return Category.builder()
                    .id(categoryCommand.getId())
                    .description(categoryCommand.getDescription())
                    .build();
        }
    }
}

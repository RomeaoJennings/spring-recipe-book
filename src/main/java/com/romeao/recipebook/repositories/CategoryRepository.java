package com.romeao.recipebook.repositories;

import com.romeao.recipebook.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {}

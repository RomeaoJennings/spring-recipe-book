package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasure> getAllUnitsOfMeasure();

    UnitOfMeasure findById(Long id);
}

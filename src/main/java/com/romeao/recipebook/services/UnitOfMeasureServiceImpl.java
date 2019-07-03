package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository repository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<UnitOfMeasure> getAllUnitsOfMeasure() {
        Set<UnitOfMeasure> unitsOfMeasure = new HashSet<>();
        repository.findAll().forEach(unitsOfMeasure::add);
        return unitsOfMeasure;
    }
}

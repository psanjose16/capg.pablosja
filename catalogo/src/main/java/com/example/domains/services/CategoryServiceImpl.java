package com.example.domains.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.CategoryRepository;
import com.example.domains.contracts.services.CategoryService;
import com.example.domains.entities.Category;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAllByOrderByName();
    }

    @Override
    public Optional<Category> getOne(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Category add(Category item) throws DuplicateKeyException, InvalidDataException {
        if (item == null) {
            throw new InvalidDataException("Cannot be null");
        }
        if (item.isInvalid()) {
            throw new InvalidDataException(item.getErrorsMessage(), item.getErrorsFields());
        }
        if (item.getCategoryId() != 0 && repository.existsById(item.getCategoryId())) {
            throw new DuplicateKeyException("Already exists");
        }
        return repository.save(item);
    }

    @Override
    public Category modify(Category item) throws NotFoundException, InvalidDataException {
        if (item == null) {
            throw new InvalidDataException("Cannot be null");
        }
        if (item.isInvalid()) {
            throw new InvalidDataException(item.getErrorsMessage(), item.getErrorsFields());
        }
        if (!repository.existsById(item.getCategoryId())) {
            throw new NotFoundException();
        }
        return repository.save(item);
    }

    @Override
    public void delete(Category item) throws InvalidDataException {
        if (item == null) {
            throw new InvalidDataException("Cannot be null");
        }
        repository.delete(item);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> novedades(Date date) {
        return repository.findByLastUpdateGreaterThanEqualOrderByLastUpdate(date);
    }
}

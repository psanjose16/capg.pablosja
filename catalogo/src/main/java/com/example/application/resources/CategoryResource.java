package com.example.application.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.domains.contracts.services.CategoryService;
import com.example.domains.entities.Category;
import com.example.domains.entities.models.FilmShortDTO;
import com.example.exceptions.BadRequestException;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/categories/v1")
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public Category getOne(@PathVariable int id) throws NotFoundException {
        var category = service.getOne(id);
        if (category.isEmpty()) {
            throw new NotFoundException();
        } else {
            return category.get();
        }
    }

    @GetMapping(path = "/{id}/films")
    @Transactional
    public List<FilmShortDTO> getFilms(@PathVariable int id) throws NotFoundException {
        var category = service.getOne(id);
        if (category.isEmpty()) {
            throw new NotFoundException();
        } else {
            return category.get().getFilmCategories().stream()
                .map(item -> FilmShortDTO.from(item.getFilm()))
                .collect(Collectors.toList());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Category item) throws BadRequestException, DuplicateKeyException, InvalidDataException {
        if (item == null) {
            throw new BadRequestException("Missing data");
        }
        var newItem = service.add(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newItem.getCategoryId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable int id, @Valid @RequestBody Category item) throws BadRequestException, NotFoundException, InvalidDataException {
        if (item == null) {
            throw new BadRequestException("Missing data");
        }
        if (id != item.getCategoryId()) {
            throw new BadRequestException("Identifiers do not match");
        }
        return service.modify(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}

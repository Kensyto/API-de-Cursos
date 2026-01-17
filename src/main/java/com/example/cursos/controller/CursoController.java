package com.example.cursos.controller;

import com.example.cursos.model.Curso;
import com.example.cursos.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso create(@Valid @RequestBody Curso curso) {
        return service.create(curso);
    }

    @GetMapping
    public List<Curso> findAll(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String category) {
        return service.findAll(name, category);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable UUID id, @Valid @RequestBody Curso curso) {
        return service.update(id, curso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PatchMapping("/{id}/active")
    public Curso toggleActive(@PathVariable UUID id) {
        return service.toggleActive(id);
    }
}

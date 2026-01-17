package com.example.cursos.service;

import com.example.cursos.exception.ResourceNotFoundException;
import com.example.cursos.model.Curso;
import com.example.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso create(Curso curso) {
        return repository.save(curso);
    }

    public List<Curso> findAll(String name, String category) {
        if (name != null && category != null) {
            return repository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        } else if (name != null) {
            return repository.findByNameContainingIgnoreCase(name);
        } else if (category != null) {
            return repository.findByCategoryContainingIgnoreCase(category);
        }
        return repository.findAll();
    }

    public Curso findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
    }

    public Curso update(UUID id, Curso cursoDetails) {
        Curso curso = findById(id);
        curso.setName(cursoDetails.getName());
        curso.setCategory(cursoDetails.getCategory());
        curso.setProfessor(cursoDetails.getProfessor());
        // 'active' field is ignored as per requirement
        return repository.save(curso);
    }

    public void delete(UUID id) {
        Curso curso = findById(id);
        repository.delete(curso);
    }

    public Curso toggleActive(UUID id) {
        Curso curso = findById(id);
        curso.setActive(!curso.isActive());
        return repository.save(curso);
    }
}

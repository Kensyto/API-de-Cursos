package com.example.cursos.repository;

import com.example.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {
    List<Curso> findByNameContainingIgnoreCase(String name);
    List<Curso> findByCategoryContainingIgnoreCase(String category);
    List<Curso> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
}

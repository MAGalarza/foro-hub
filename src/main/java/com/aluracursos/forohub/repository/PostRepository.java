package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
package com.example.exam2ws.repository;

import com.example.exam2ws.entity.Editoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorasRepository extends JpaRepository<Editoras, Integer> {
}

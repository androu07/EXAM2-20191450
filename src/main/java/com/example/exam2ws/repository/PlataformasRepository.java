package com.example.exam2ws.repository;

import com.example.exam2ws.entity.Plataformas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformasRepository extends JpaRepository<Plataformas, Integer> {
}

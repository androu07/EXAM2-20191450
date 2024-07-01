package com.example.exam2ws.repository;

import com.example.exam2ws.entity.Distribuidoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidorasRepository extends JpaRepository<Distribuidoras, Integer> {
}

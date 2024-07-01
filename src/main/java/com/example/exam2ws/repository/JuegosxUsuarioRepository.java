package com.example.exam2ws.repository;

import com.example.exam2ws.entity.JuegosxUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegosxUsuarioRepository extends JpaRepository<JuegosxUsuario, Integer> {
}

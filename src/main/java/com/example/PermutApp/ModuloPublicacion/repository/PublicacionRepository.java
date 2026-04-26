package com.example.PermutApp.ModuloPublicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PermutApp.ModuloPublicacion.model.entities.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer>{
   
}

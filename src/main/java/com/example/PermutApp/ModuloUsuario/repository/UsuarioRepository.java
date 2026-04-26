package com.example.PermutApp.ModuloUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PermutApp.ModuloUsuario.model.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}

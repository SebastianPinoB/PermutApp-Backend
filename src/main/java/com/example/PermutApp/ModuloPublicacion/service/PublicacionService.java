package com.example.PermutApp.ModuloPublicacion.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PermutApp.ModuloPublicacion.model.entities.Publicacion;
import com.example.PermutApp.ModuloPublicacion.model.request.ActualizarPublicacion;
import com.example.PermutApp.ModuloPublicacion.model.request.CrearPublicacion;
import com.example.PermutApp.ModuloPublicacion.repository.PublicacionRepository;

@Service
public class PublicacionService {

   @Autowired
   public PublicacionRepository publicacionRepository;


   public List<Publicacion> obtenerTodos(){
      return publicacionRepository.findAll();
   }

   public Publicacion obtenerPorId(int idPublicacion){
      Publicacion publicacion = publicacionRepository.findById(idPublicacion).orElse(null);
      if(publicacion == null){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacion no encontrado");
      }
      return publicacion;
   }

   public Publicacion crearPublicacion(CrearPublicacion nueva){
      //Falta asignarle un creador
      Publicacion publicacion = new Publicacion();
      publicacion.setPubl_titulo(nueva.getPubl_titulo());
      publicacion.setPubl_descripcion(nueva.getPubl_descripcion());
      publicacion.setPubl_fech_creacion(new Date());
      publicacion.setPubl_activo(true);
      return publicacionRepository.save(publicacion);
   }

   public Publicacion actualizarPublicacion(Integer idPublicacion, ActualizarPublicacion nueva){
      Publicacion publicacion = publicacionRepository.findById(idPublicacion).orElse(null);
      if(publicacion == null){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacion no encontrada");
      }else{
         publicacion.setPubl_titulo(nueva.getPubl_titulo());
         publicacion.setPubl_descripcion(nueva.getPubl_descripcion());

         return publicacionRepository.save(publicacion);
      }
   }

   public String eliminarPublicacion(int idPublicacion){
      if(publicacionRepository.existsById(idPublicacion)){
         publicacionRepository.deleteById(idPublicacion);
         return "Publicacion eliminada correctamente";
      }else{
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacion no encontrada");
      }

   }

   public Publicacion cambiarEstadoPublicacion(int idPublicacion){
      Publicacion publicacion = publicacionRepository.findById(idPublicacion).orElse(null);
      if(publicacion == null){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacion no encontrada");
      }else{
         if(publicacion.getPubl_activo()==true) {
            publicacion.setPubl_activo(false);
         }else{
            publicacion.setPubl_activo(true);
         }
         return publicacionRepository.save(publicacion);
      }
   }

}

package com.examen.app_seguridad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.app_seguridad.Model.UsuarioModel;


@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioModel,Integer>{
    
}

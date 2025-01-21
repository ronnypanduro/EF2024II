package com.examenfinal.MsProducto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examenfinal.MsProducto.model.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Integer>{
    
}

package com.examenfinal.MsProducto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenfinal.MsProducto.model.ProductoModel;
import com.examenfinal.MsProducto.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository repository;
    @Override
    public List<ProductoModel> findAll() {
        return (List<ProductoModel>)repository.findAll();
    }

    @Override
    public ProductoModel findById(Integer id) {
        return (ProductoModel)repository.findById(id).get();
    }

    @Override
    public ProductoModel add(ProductoModel model) {
        return repository.save(model);
    }

    @Override
    public ProductoModel update(ProductoModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }
    
}

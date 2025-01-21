package com.examenfinal.MsProducto.service;

import java.util.List;

import com.examenfinal.MsProducto.model.ProductoModel;

public interface IProductoService {
    public List<ProductoModel> findAll();
    public ProductoModel findById(Integer id);
    public ProductoModel add(ProductoModel model);
    public ProductoModel update(ProductoModel model);
    public Boolean delete(Integer id);
}

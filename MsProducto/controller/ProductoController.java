package com.examenfinal.MsProducto.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenfinal.MsProducto.constanst.NoHardCodeo;
import com.examenfinal.MsProducto.model.ProductoModel;
import com.examenfinal.MsProducto.service.ProductoService;
@RestController
@RequestMapping(NoHardCodeo.PRODUCTO_BASE)
public class ProductoController {
    @Autowired
    ProductoService productoService;

    Logger logger = LoggerFactory.getLogger(ProductoController.class);
    @GetMapping(NoHardCodeo.GET_ALL)
    public List<ProductoModel> findAll() {
        try {
            List<ProductoModel> lista = productoService.findAll();
            System.out.println("\n             Entrando al listado                \n");
            return lista;
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al obtener la lista de productos: {}", e.getMessage(), e);
            System.out.println("\n             retorna lista vacia                \n");
            return new ArrayList<>(); // Retornar lista vacía en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo findAll ejecutado");
        }
    }

      /*@PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody PayRequest request) throws Exception {

                logger.info("Post: InvoiceId {} - Ammount {}", request.getId_invoice(), request.getAmount());
                ProductoModel payModel = new ProductoModel();
                payModel.setIdFactura(request.getId_invoice());
                payModel.setMonto(request.getAmount());

                //payModel.setId(request.getId_invoice());
                //payModel.setAmount(request.getAmount());
                payModel = productoService.add(payModel);
                logger.info("transactionModel {}", payModel);
                // messageEvent.sendDepositEvent(payModel);                
                return ResponseEntity.status(HttpStatus.CREATED).body(payModel);
        }*/

        @PostMapping(NoHardCodeo.CREATE)
    public ProductoModel create(@RequestBody ProductoModel model) {
        try {
            return productoService.add(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al crear el producto: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo create ejecutado");
        }
    }

        @GetMapping(NoHardCodeo.GET_BY_ID)
    public ProductoModel findById(@PathVariable Integer id) {
        try {
            return productoService.findById(id);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al buscar el producto con ID {}: {}", id, e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public ProductoModel update(@RequestBody ProductoModel model) {
        try {
            return productoService.update(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al actualizar el producto: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = productoService.delete(id);
            return isDeleted ? "Producto eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al eliminar el producto con ID {}: {}", id, e.getMessage(), e);
            return "Ocurrio un error al intentar eliminar el producto.";
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo delete ejecutado.");
        }
    }
    

}

package msventa.msventa.controller;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResquestMapping(NoHardCodeo.VENTA_BASE)
public class VentaController {
    private static final Logger log = LoggerFactory.getLogger(VentaController.class);

    @Autowired
    VentaService ventaService;

    @GetMapping(NoHardCodeo.GET_ALL)
    public List<Venta> findAll(){
        try {
            Lista<Venta> ventas = ventaService.findAll();
        System.out.println("\n Entrado al listado de ventas \n");
        return lista;
        } catch (Exception e) {
            logger.error(format("Error al listar las ventas %s", e.getMessage()));
            System.out.println("\n retorna listar vacia\n");
            return new ArrayList<>();
        } finally {

            logger.info("Metodo findAll ejecutado");
        }
    }
    
    @PostMapping(NoHardCodeo.CREATE)
    public Venta create(@RequestBody Venta venta){
        try {
            return ventaService.create(venta);
        } catch (Exception e) {
            logger.error(format("Error al crear la venta %s", e.getMessage()));
            return null;
        } finally {
            logger.info("Metodo create ejecutado");
        }
    }


    @GetMapping(NoHardCodeo.GET_BY_ID)
    public Venta findById(@PathVariable Integer id){
        try {
            return ventaService.findById(id);
        } catch (Exception e) {
            logger.error(format("Error al buscar la venta %s", e.getMessage()));
            return null;
        } finally {
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public Venta update(@RequestBody Venta venta){
        try {
            return ventaService.update(venta);
        } catch (Exception e) {
            logger.error(format("Error al actualizar la venta %s", e.getMessage()));
            return null;
        } finally {
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id){
        try {
            boolean isDeleted = ventaService.Deleted(id);
            return ventaService.delete(id);
        } catch (Exception e) {
            logger.error(format("Error al borrar la venta %s", e.getMessage()));
            return null;
        } finally {
            logger.info("Metodo delete ejecutado");
        }
    }



}

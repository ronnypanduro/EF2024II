package msventa.msventa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msventa.msventa.Model.VentaModel;
import msventa.msventa.repository.IVentaRespository;

@Service
public class VentaService implements IVentaService {
    @Autowired
    IVentaRespository repository;

    @Override
    public List<VentaModel> findAll() {
        return (List<VentaModel>)repository.findAll();
    }

    @Override
    public VentaModel findById(Integer id) {
        return (VentaModel)repository.findById(id).orElse(null);
    }

    @Override
    public Venta add(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public VentaModel update(VentaModel venta) {
        return repository.save(venta);
    }
    
    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }
}

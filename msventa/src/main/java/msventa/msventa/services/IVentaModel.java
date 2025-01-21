package msventa.msventa.services;

import java.util.List;

import msventa.msventa.Model.VentaModel;

public class IVentaModel {
    public List<VentaModel> findAll();
    public VentaModel findById(Integer id);
    public VentaModel add(VentaModel model);
    public VentaModel update(VentaModel model);
    public void delete(Integer id);
    
}

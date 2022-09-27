package com.OrgSolutionNet.Proyecto.Services;

import com.OrgSolutionNet.Proyecto.Entities.Empresa;
import com.OrgSolutionNet.Proyecto.Entities.Movimiento;
import com.OrgSolutionNet.Proyecto.Repositories.EmpresaRepository;
import com.OrgSolutionNet.Proyecto.Repositories.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovimientoService {
    private MovimientoRepository repository;

    public MovimientoService(MovimientoRepository repository){

        this.repository = repository;
    }

    public List<Movimiento> getlistaMovimiento(){
        return this.repository.findAll(); // Obtener informacion desde la base de datos
    }

    public Movimiento crearMovimiento (Movimiento nuevoMovimiento){
        return this.repository.save(nuevoMovimiento);
    }

    public Movimiento actualizarMovimiento (Movimiento nuevoMovimiento){
        return this.repository.saveAndFlush(nuevoMovimiento);
    }

    public Boolean deleteMovimiento(Long id){
        this.repository.deleteById(id);
        return true;
    }}

package com.OrgSolutionNet.Proyecto.Services;

import com.OrgSolutionNet.Proyecto.Entities.Empleado;
import com.OrgSolutionNet.Proyecto.Repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    private EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> getlistaEmpleado(){
        return this.repository.findAll(); // Obtener informacion desde la base de datos
    }

    public Empleado crearEmpleado (Empleado nuevoEmpleado){
        return this.repository.save(nuevoEmpleado);
    }

    public Empleado actualizarEmpleado (Empleado nuevoEmpleado){
        return this.repository.saveAndFlush(nuevoEmpleado);
    }

    public Boolean deleteEmpleado(Long id){
        this.repository.deleteById(id);
        return true;
    }
}

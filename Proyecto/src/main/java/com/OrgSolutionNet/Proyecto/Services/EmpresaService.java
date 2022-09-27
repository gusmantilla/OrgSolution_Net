package com.OrgSolutionNet.Proyecto.Services;

import com.OrgSolutionNet.Proyecto.Entities.Empresa;
//import com.OrgSolutionNet.Proyecto.Entities.ListaEmpresa;
import com.OrgSolutionNet.Proyecto.Repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){

        this.repository = repository;
    }

    public List<Empresa> getlistaEmpresa(){
        return this.repository.findAll(); // Obtener informacion desde la base de datos
    }

    public Empresa crearEmpresa (Empresa nuevaEmpresa){
        return this.repository.save(nuevaEmpresa);
    }

    public Empresa actualizarEmpresa (Empresa nuevaEmpresa){
        return this.repository.saveAndFlush(nuevaEmpresa);
    }

    public void eliminarEmpresa (Long id) {
       repository.deleteById(id);
    }

    public Boolean markEmpresaAsFinished(Long id){
        Optional<Empresa> empresa = this.repository.findById(id);
        if(empresa.isPresent()){
            empresa.get().setDone(true);
            this.repository.save(empresa.get());
            return true;
        }
        return false;

    }

    public Boolean deleteEmpresa(Long id){
        this.repository.deleteById(id);
        return true;
    }

}

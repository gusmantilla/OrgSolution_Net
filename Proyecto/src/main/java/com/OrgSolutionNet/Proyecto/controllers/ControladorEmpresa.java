package com.OrgSolutionNet.Proyecto.controllers;

import com.OrgSolutionNet.Proyecto.Entities.Empresa;
import com.OrgSolutionNet.Proyecto.Repositories.EmpresaRepository;
import com.OrgSolutionNet.Proyecto.Services.EmpresaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController //permite que springboot sepa que la funcion que se expone, se expone a los usuarios
public class ControladorEmpresa {
    EmpresaService service; //Propiedad para asceder al servicio
    //Constructor
    public ControladorEmpresa (EmpresaService service){

        this.service = service;
    }

  /* @GetMapping ("/empresa")
   public List<Empresa> obtenerDatosEmpresa(){
       return  this.service.getlistaEmpresa();
   }*/


    public List<Empresa> obtenerDatosEmpresa(@PathVariable ("id") long id){
        return  this.service.getlistaEmpresa();
    }
    /*@GetMapping ("/empresa")
    public List<Empresa> obtenerDatosEmpresa(@PathVariable ("id") long id){
        return  this.service.getlistaEmpresa();
    }*/
    @PostMapping ("/empresa")
    public RedirectView crearEmpresa(@ModelAttribute Empresa empresanew, Model model) {
        model.addAttribute(empresanew);

        this.service.crearEmpresa(empresanew);
        return new RedirectView("/empresa");
    }
    @PostMapping ("/empresa/creadores")
    public RedirectView crearEmpresa_image(@ModelAttribute Empresa empresaImage, Model model) {
        model.addAttribute(empresaImage);

//        this.service.crearEmpresa(empresaImage);
        return new RedirectView("/creadores");
    }

    @PatchMapping("/empresa/{id}")
    public RedirectView updateEmpresa(@PathVariable ("id") long id){
        this.service.markEmpresaAsFinished(id);
        return new RedirectView("/empresa");

    }

    @PutMapping ("/empresa")
    public void actualizarDatosEmpresa(@RequestBody Empresa empresanew){

        service.actualizarEmpresa(empresanew);
    }
    @DeleteMapping ("empresa/{id}")
    public RedirectView deleteEmpresa(@PathVariable ("id") long id){
        this.service.deleteEmpresa(id);
        return new RedirectView("/empresa");

    }



}

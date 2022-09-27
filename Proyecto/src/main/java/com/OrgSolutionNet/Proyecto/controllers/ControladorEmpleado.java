package com.OrgSolutionNet.Proyecto.controllers;

import com.OrgSolutionNet.Proyecto.Entities.Empleado;
import com.OrgSolutionNet.Proyecto.Services.EmpleadoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ControladorEmpleado {
    EmpleadoService service;

    public ControladorEmpleado(EmpleadoService service) {
        this.service = service;
    }

    public List<Empleado> obtenerDatosEmpleado(@PathVariable("id") long id){
        return  this.service.getlistaEmpleado();
    }
    /*@GetMapping ("/empresa")
    public List<Empresa> obtenerDatosEmpresa(@PathVariable ("id") long id){
        return  this.service.getlistaEmpresa();
    }*/
    @PostMapping("/empleado")
    public RedirectView crearEmpleado(@ModelAttribute Empleado empleadonew, Model model) {
        model.addAttribute(empleadonew);

        this.service.crearEmpleado(empleadonew);
        return new RedirectView("/empleado");
    }

    @PutMapping("/empleado")
    public void actualizarDatosEmpleado(@RequestBody Empleado empleadonew){

        service.actualizarEmpleado(empleadonew);
    }
    @DeleteMapping ("empleado/{id}")
    public RedirectView deleteEmpleado(@PathVariable ("id") long id){
        this.service.deleteEmpleado(id);
        return new RedirectView("/empleado");

    }
}

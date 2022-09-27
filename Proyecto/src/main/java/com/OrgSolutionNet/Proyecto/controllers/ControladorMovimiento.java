package com.OrgSolutionNet.Proyecto.controllers;

import com.OrgSolutionNet.Proyecto.Entities.Movimiento;
import com.OrgSolutionNet.Proyecto.Services.MovimientoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController //permite que springboot sepa que la funcion que se expone, se expone a los usuarios
public class ControladorMovimiento {
    MovimientoService service; //Propiedad para asceder al servicio
    //Constructor
    public ControladorMovimiento (MovimientoService service){
        this.service = service;
    }

  /* @GetMapping ("/empresa")
   public List<Empresa> obtenerDatosEmpresa(){
       return  this.service.getlistaEmpresa();
   }*/


    public List<Movimiento> obtenerDatosMovimiento(@PathVariable ("id") long id){
        return  this.service.getlistaMovimiento();
    }
    /*@GetMapping ("/empresa")
    public List<Empresa> obtenerDatosEmpresa(@PathVariable ("id") long id){
        return  this.service.getlistaEmpresa();
    }*/
    @PostMapping ("/movimiento")
    public RedirectView crearMovimiento(@ModelAttribute Movimiento movimientonew, Model model) {
        model.addAttribute(movimientonew);

        this.service.crearMovimiento(movimientonew);
        return new RedirectView("/movimiento");
    }

    @PutMapping ("/movimiento")
    public void actualizarDatosMovimiento(@RequestBody Movimiento movimientonew){

        service.actualizarMovimiento(movimientonew);
    }
    @DeleteMapping ("movimiento/{id}")
    public RedirectView deleteMovimiento(@PathVariable ("id") long id){
        this.service.deleteMovimiento(id);
        return new RedirectView("/movimiento");

    }
}

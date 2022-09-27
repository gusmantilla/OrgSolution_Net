package com.OrgSolutionNet.Proyecto.controllers;

import com.OrgSolutionNet.Proyecto.Entities.Empleado;
import com.OrgSolutionNet.Proyecto.Entities.Empresa;
import com.OrgSolutionNet.Proyecto.Entities.Movimiento;
import com.OrgSolutionNet.Proyecto.Entities.User;
import com.OrgSolutionNet.Proyecto.Services.EmpleadoService;
import com.OrgSolutionNet.Proyecto.Services.EmpresaService;
import com.OrgSolutionNet.Proyecto.Services.MovimientoService;
import com.OrgSolutionNet.Proyecto.Services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontControllers {

    EmpresaService service; //Propiedad para asceder al servicio
    //Constructor
    EmpleadoService empleadoService;
    MovimientoService movimientoService;

    UserService userService;
    public FrontControllers (EmpresaService service, UserService userService, EmpleadoService empleadoService, MovimientoService movimientoService){

        this.service = service;
        this.userService = userService;
        this.empleadoService = empleadoService;
        this.movimientoService = movimientoService;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/empresa")

    public String empresa(Model model){
        List<Empresa> empresa = this.service.getlistaEmpresa();
        model.addAttribute("empresa", empresa);
        return "empresa";
    }

    @GetMapping("/empleado")

    public String empleado(Model model){
        List<Empleado> empleado = this.empleadoService.getlistaEmpleado();
        model.addAttribute("empleado", empleado);
        return "empleado";
    }

    @GetMapping("/movimiento")

    public String movimiento(Model model){
        List<Movimiento> movimiento = this.movimientoService.getlistaMovimiento();
        model.addAttribute("movimiento", movimiento);
        return "movimiento";
    }

    @GetMapping("/empresa/new")
    public String newEmpresa(Model model){
        model.addAttribute("Empresa", new Empresa());
        return "new-empresa";
    }

    @GetMapping("/empresa/creadores")
    public String newEmpresa_image(Model model){
//        model.addAttribute("Empresa", new Empresa());
        return "creadores";
    }

    @GetMapping("/empleado/new")
    public String newEmpleado(Model model){
        model.addAttribute("Empleado", new Empleado());
        return "new-empleado";
    }

    @GetMapping("/movimiento/new")
    public String newMovimiento(Model model){
        model.addAttribute("Movimiento", new Movimiento());
        return "new-movimiento";
    }
}

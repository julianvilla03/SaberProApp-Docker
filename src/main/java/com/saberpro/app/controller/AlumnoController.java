package com.saberpro.app.controller;

import com.saberpro.app.model.Alumno;
import com.saberpro.app.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String usuario, @RequestParam String clave) {
        if (usuario.equals("didier") && clave.equals("didier123")) {
            return "redirect:/listar";
        } else {
            return "login";
        }
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alumnos", service.listar());
        return "list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Alumno alumno) {
        service.guardar(alumno);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("alumno", service.obtenerPorId(id));
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "redirect:/listar";
    }
}

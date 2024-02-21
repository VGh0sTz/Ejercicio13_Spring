package com.ejercicio13_spring.Controller;

import com.ejercicio13_spring.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class MiControlador {
    @GetMapping("")
    public String index(Map<String ,Object> map) {
        //model.addAttribute("hora", LocalDateTime.now());
        //model.addAttribute("titulo", "Programa de prueba");
        map.put("titulo", "Programa de prueba");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario("Fran", "García", "fran@iessanvicente.com");
        model.addAttribute("titulo", "Pagina del perfil");
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @RequestMapping(value = "/listar")
    public String listar(Model model) {
        /*
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Fran", "García", "fran@fran.com"));
        usuarios.add(new Usuario("Pepe", "García", "pepegarcia@pepe.com"));
        usuarios.add(new Usuario("Luis", "García", "Luisgarcia@l.com"));
        model.addAttribute("usuarios", usuarios);
        */
        model.addAttribute("titulo", "Listado de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Fran", "García", "fran@fran.com"));
        usuarios.add(new Usuario("Pepe", "García", "pepegarcia@pepe.com"));
        usuarios.add(new Usuario("Luis", "García", "Luisgarcia@l.com"));
        return usuarios;
    }


}
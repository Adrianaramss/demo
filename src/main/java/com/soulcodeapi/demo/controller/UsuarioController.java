package com.soulcodeapi.demo.controller;

import com.soulcodeapi.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.soulcodeapi.demo.models.Usuario;

import java.util.List;
import java.util.Optional;


@RestController
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping(value = "/cadusuario", method = RequestMethod.POST)
    public Usuario save(){
        Usuario u = new Usuario();
        u.setNome("Rafael");
        u = this.usuarioRepository.save(u);
        return u;
    }


    @RequestMapping(value = "/mostrausuarios", method = RequestMethod.GET)
    public List<Usuario> findAll(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios;
    }

    @RequestMapping(value = "/mostrarusuarios/{id}" , method =  RequestMethod.GET)
    public Usuario findById(@PathVariable long id) {
        Optional<Usuario> resultado = this.usuarioRepository.findById(id);
        if(resultado.isEmpty()) {
            throw  new RuntimeException("Usuario não encontrado");
    }else{
        return resultado.get();
    }
}
}
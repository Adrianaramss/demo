package com.soulcodeapi.demo.controller;

import com.soulcodeapi.demo.repositories.UsuarioRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.soulcodeapi.demo.models.Usuario;

import java.util.List;
import java.util.Optional;


@RestController
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping(value = "/cadusuario", method = RequestMethod.POST)
    public Usuario save() {
        Usuario u = new Usuario();
        u.setNome("Rafael");
        u = this.usuarioRepository.save(u);
        return u;
    }


    @RequestMapping(value = "/mostrausuario", method = RequestMethod.GET)
    public List<Usuario> findAll() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios;
    }

    @RequestMapping(value = "/mostrarusuario/{id}", method = RequestMethod.GET)
    public Usuario findById(@PathVariable long id) {
        Optional<Usuario> resultado = this.usuarioRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Usuario não encontrado");
        } else {
            return resultado.get();
        }
    }

    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
    public Usuario deletebyId(@PathVariable long id) {
        Usuario usuario = findById(id);
        this.usuarioRepository.deleteById(id);
        return usuario;
    }


    @RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT)
    public Usuario updateById(@PathVariable long id, @RequestBody Usuario usuario) {
        this.findById(id);
        usuario.setId(id);
        usuario = this.usuarioRepository.save(usuario);
        return usuario;
    }
}
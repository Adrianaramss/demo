package com.soulcodeapi.demo.repositories;
import com.soulcodeapi.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}

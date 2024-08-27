package com.fundacao.ponto.repository;

import com.fundacao.ponto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Usuario findByEmail(String email);
}

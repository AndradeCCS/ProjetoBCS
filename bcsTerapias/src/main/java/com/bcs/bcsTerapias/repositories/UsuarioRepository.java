package com.bcs.bcsTerapias.repositories;

import com.bcs.bcsTerapias.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuariosModel, UUID> {

}

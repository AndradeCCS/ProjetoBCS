package com.bcs.bcsTerapias.repositories;

import com.bcs.bcsTerapias.models.ProntuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProntuariosRepository extends JpaRepository<ProntuariosModel, UUID> {
}

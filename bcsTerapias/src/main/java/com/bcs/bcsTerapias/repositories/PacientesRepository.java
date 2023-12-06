package com.bcs.bcsTerapias.repositories;


import com.bcs.bcsTerapias.models.PacientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacientesRepository extends JpaRepository <PacientesModel, UUID> {
}

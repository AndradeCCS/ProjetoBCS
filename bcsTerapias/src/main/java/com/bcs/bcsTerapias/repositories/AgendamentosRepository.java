package com.bcs.bcsTerapias.repositories;

import com.bcs.bcsTerapias.models.AgendamentosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendamentosRepository extends JpaRepository<AgendamentosModel, UUID> {
}

package com.bcs.bcsTerapias.models;

import com.bcs.bcsTerapias.repositories.PacientesRepository;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "TB_AGENDAMENTOS")
public class AgendamentosModel extends RepresentationModel<AgendamentosModel> implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID idPaciente;
    private boolean convenio;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;

    public AgendamentosModel() {
    }

    public UUID getId() {
        return id;
    }

    public boolean isConvenio() {
        return convenio;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public UUID getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }

}

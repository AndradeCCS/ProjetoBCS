package com.bcs.bcsTerapias.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.awt.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PRONTUARIOS")
public class ProntuariosModel extends RepresentationModel<ProntuariosModel> implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProntuario;

    public UUID getIdProntuario() {
        return idProntuario;
    }

    private UUID idPaciente;
    private UUID idAgendamento;
    private String historico;

    public ProntuariosModel() {
    }

    public UUID getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }

    public UUID getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(UUID idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
}

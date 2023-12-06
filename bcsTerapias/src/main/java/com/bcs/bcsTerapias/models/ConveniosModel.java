package com.bcs.bcsTerapias.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CONVENIO")
public class ConveniosModel {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConvenio;
    private String empresa;
    private String observacoes;

    public ConveniosModel() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

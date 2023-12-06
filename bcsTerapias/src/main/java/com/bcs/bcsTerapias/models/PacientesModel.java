package com.bcs.bcsTerapias.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_PACIENTES")
public class PacientesModel extends RepresentationModel<PacientesModel> implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPaciente;
    private String nome;

    private LocalDate dataNascimento;
    private String sexo;
    private String tipoDocumento;
    private String documento;
    private String email;
    private BigInteger telefone;
    private BigInteger telefone2;
    private BigInteger cep;
    private String estado;
    private String cidade;

    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;
    private String anamenese;

    public UUID getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }

    public BigInteger getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(BigInteger telefone2) {
        this.telefone2 = telefone2;
    }

    public BigInteger getCep() {
        return cep;
    }

    public void setCep(BigInteger cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getAnamenese() {
        return anamenese;
    }

    public void setAnamenese(String anamenese) {
        this.anamenese = anamenese;
    }


}

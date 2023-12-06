package com.bcs.bcsTerapias.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

public record PacienteRecordDto(@NotBlank String nome, @NotBlank String sexo, LocalDate dataNascimento, @NotEmpty String tipoDocumento, @NotEmpty String documento,
                                @Valid String email, @Valid BigInteger telefone, @Valid BigInteger telefone2, BigInteger cep, String estado,
                                String cidade, String bairro, String rua, Integer numero, String complemento, String anamenese){
}

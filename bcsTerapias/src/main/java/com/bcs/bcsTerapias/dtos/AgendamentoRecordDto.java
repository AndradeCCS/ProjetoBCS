package com.bcs.bcsTerapias.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
public record AgendamentoRecordDto(@NotNull boolean convenio,@NotNull LocalDate dataConsulta,@NotNull LocalTime horaConsulta,@NotNull UUID idPaciente) {
}

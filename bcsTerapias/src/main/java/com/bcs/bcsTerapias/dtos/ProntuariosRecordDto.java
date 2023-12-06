package com.bcs.bcsTerapias.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProntuariosRecordDto(@Valid UUID idPaciente, @Valid UUID idAgendamento, String historico) {
}

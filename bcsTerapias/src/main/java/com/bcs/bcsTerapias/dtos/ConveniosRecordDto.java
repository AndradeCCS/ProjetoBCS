package com.bcs.bcsTerapias.dtos;

import jakarta.validation.constraints.NotBlank;

public record ConveniosRecordDto(@NotBlank String empresa, String observacoes) {
}

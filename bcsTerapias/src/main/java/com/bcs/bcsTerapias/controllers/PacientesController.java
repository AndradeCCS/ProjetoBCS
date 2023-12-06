package com.bcs.bcsTerapias.controllers;


import com.bcs.bcsTerapias.dtos.PacienteRecordDto;
import com.bcs.bcsTerapias.models.PacientesModel;
import com.bcs.bcsTerapias.repositories.PacientesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
public class PacientesController {

    @Autowired
    PacientesRepository pacientesRepository;

    @PostMapping("/pacientes")
    public ResponseEntity<PacientesModel> savePaciente(@RequestBody @Valid PacienteRecordDto pacienteRecordDto) {
        var pacientesModel = new PacientesModel();
        BeanUtils.copyProperties(pacienteRecordDto, pacientesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientesRepository.save(pacientesModel));
    }


    @GetMapping("/pacientes")
    public ResponseEntity<List<PacientesModel>> getAllPacientes(){
        List<PacientesModel> pacientesModelList = pacientesRepository.findAll();
        if(!pacientesModelList.isEmpty()){
            for (PacientesModel paciente: pacientesModelList
                 ) {
                UUID id = paciente.getIdPaciente();
                String nome = paciente.getNome();
                LocalDate dataNascimento = paciente.getDataNascimento();
                String sexo = paciente.getSexo();
                String tipoDocumento = paciente.getTipoDocumento();
                String documento = paciente.getDocumento();
                String email = paciente.getEmail();
                BigInteger telefone = paciente.getTelefone();
                BigInteger telefone2 = paciente.getTelefone2();
                BigInteger cep = paciente.getCep();
                String estado = paciente.getEstado();
                String cidade = paciente.getCidade();
                String bairro = paciente.getBairro();
                String rua = paciente.getRua();
                Integer numero = paciente.getNumero();
                String complemento = paciente.getComplemento();
                String anamenese = paciente.getAnamenese();
            }
    }
        return ResponseEntity.status(HttpStatus.OK).body(pacientesModelList);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") UUID id) {
        Optional<PacientesModel> pacientesModelOptional = pacientesRepository.findById(id);
        if(pacientesModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacientesModelOptional.get());
    }

    @PutMapping("pacientes/{id}")
    public  ResponseEntity<Object> updatePaciente(@PathVariable(value = "id") UUID id, @RequestBody @Valid PacienteRecordDto pacienteRecordDto) {
        Optional<PacientesModel> pacientesModelOptional = pacientesRepository.findById(id);
        if(pacientesModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        var pacientesModel = pacientesModelOptional.get();
        BeanUtils.copyProperties(pacienteRecordDto, pacientesModel);
        return ResponseEntity.status(HttpStatus.OK).body(pacientesRepository.save(pacientesModel));
    }

    @DeleteMapping("pacientes/{id}")
    public ResponseEntity<Object> deletepaciente(@PathVariable(value = "id") UUID id) {
        Optional<PacientesModel> pacientesModelOptional = pacientesRepository.findById(id);
        if (pacientesModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
        pacientesRepository.delete(pacientesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso!");
    }

}


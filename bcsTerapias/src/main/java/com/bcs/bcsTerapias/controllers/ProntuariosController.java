package com.bcs.bcsTerapias.controllers;

import com.bcs.bcsTerapias.dtos.ProntuariosRecordDto;
import com.bcs.bcsTerapias.models.ProntuariosModel;
import com.bcs.bcsTerapias.repositories.ProntuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProntuariosController {

    @Autowired
    ProntuariosRepository prontuariosRepository;

    @PostMapping("/prontuarios")
    public ResponseEntity<ProntuariosModel> saveProntuario(@RequestBody @Valid ProntuariosRecordDto prontuariosRecordDto){
        var prontuariosModel = new ProntuariosModel();
        BeanUtils.copyProperties(prontuariosRecordDto, prontuariosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(prontuariosRepository.save(prontuariosModel));
    }

    @GetMapping("/prontuarios")
    public ResponseEntity<List<ProntuariosModel>> getAllProntuarios(){
        List<ProntuariosModel> prontuariosModelList = prontuariosRepository.findAll();
        if (!prontuariosModelList.isEmpty()){
            for (ProntuariosModel prontuarios: prontuariosModelList
                 ) {
                UUID idProntuario = prontuarios.getIdProntuario();
                UUID idPaciente = prontuarios.getIdPaciente();
                UUID idAgendamento = prontuarios.getIdAgendamento();
                String historico = prontuarios.getHistorico();
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(prontuariosModelList);
    }

    @GetMapping("/prontuarios/{id}")
    public ResponseEntity<Object> getOneProntuarios (@PathVariable(value = "id") UUID id){
        Optional<ProntuariosModel> prontuariosModelOptional = prontuariosRepository.findById(id);
        if (prontuariosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prontuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(prontuariosModelOptional.get());
    }

    @PutMapping("/prontuarios/{id}")
    public ResponseEntity<Object> updateProntuarios(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProntuariosRecordDto prontuariosRecordDto){
        Optional<ProntuariosModel> prontuariosModelOptional = prontuariosRepository.findById(id);
        if (prontuariosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prontuario não encontrado");
        }
        var prontuarioModel = prontuariosModelOptional.get();
        BeanUtils.copyProperties(prontuariosRecordDto, prontuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(prontuariosRepository.save(prontuarioModel));
    }

    @DeleteMapping("/prontuarios/{id}")
    public ResponseEntity<Object> deleteprontuarios(@PathVariable(value= "id") UUID id) {
        Optional<ProntuariosModel> prontuariosModelOptional = prontuariosRepository.findById(id);
        if (prontuariosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prontuário não encontrado!");
        }
        prontuariosRepository.delete(prontuariosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Prontuário deletado com sucesso!");
    }

}

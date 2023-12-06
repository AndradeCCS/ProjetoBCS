package com.bcs.bcsTerapias.controllers;

import com.bcs.bcsTerapias.dtos.ConveniosRecordDto;
import com.bcs.bcsTerapias.models.ConveniosModel;
import com.bcs.bcsTerapias.repositories.ConveniosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ConveniosController {
    @Autowired
    ConveniosRepository conveniosRepository;

    @PostMapping("/convenios")
    public ResponseEntity<ConveniosModel> saveConvenios(@RequestBody @Valid ConveniosRecordDto conveniosRecordDto){
       var conveniosModel = new ConveniosModel();
        BeanUtils.copyProperties(conveniosRecordDto, conveniosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(conveniosModel);
    }

    @GetMapping("/convenios")
    public ResponseEntity<List<ConveniosModel>> getAllConvenios(){
        List<ConveniosModel> conveniosModelList = conveniosRepository.findAll();
            if(!conveniosModelList.isEmpty()){
                for (ConveniosModel convenios: conveniosModelList) {
                    String empresa = convenios.getEmpresa();
                    String observacoes = convenios.getObservacoes();
                }
            }
        return ResponseEntity.status(HttpStatus.OK).body(conveniosModelList);
    }

    @GetMapping("/convenios/{id}")
    public ResponseEntity<Object> getOneConvenios (@PathVariable(value = "id") UUID id) {
        Optional<ConveniosModel> conveniosModelOptional = conveniosRepository.findById(id);
        if (conveniosModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convenio não encontrado!");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(conveniosModelOptional.get());
    }

    @PutMapping("/convenios/{id}")
    public ResponseEntity<Object> updateConvenios (@PathVariable(value = "id") UUID id, @RequestBody @Valid ConveniosRecordDto conveniosRecordDto) {
        Optional<ConveniosModel> conveniosModelOptional = conveniosRepository.findById(id);
        if (conveniosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convenio não encontrado!");
        }
        var conveniosModel = new ConveniosModel();
        BeanUtils.copyProperties(conveniosRecordDto, conveniosModel);
        return ResponseEntity.status(HttpStatus.OK).body(conveniosRepository.save(conveniosModel));
    }

    @DeleteMapping("/convenios/{id}")
    public ResponseEntity<Object> deleteConvenios(@PathVariable(value = "id") UUID id) {
        Optional<ConveniosModel> conveniosModelOptional = conveniosRepository.findById(id);
        if (conveniosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convênio não encontrado!");
        }
        conveniosRepository.delete(conveniosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Convênio excluido com sucesso!");
    }

}

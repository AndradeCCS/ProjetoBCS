package com.bcs.bcsTerapias.controllers;

import com.bcs.bcsTerapias.dtos.AgendamentoRecordDto;
import com.bcs.bcsTerapias.models.AgendamentosModel;
import com.bcs.bcsTerapias.repositories.AgendamentosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class AgendamentosController {

    @Autowired
    AgendamentosRepository agendamentosRepository;

    @PostMapping("/agendamentos")
    public ResponseEntity<AgendamentosModel> saveAgendamento(@RequestBody @Valid AgendamentoRecordDto agendamentoRecordDto){
        var agendamentoModel = new AgendamentosModel();

        BeanUtils.copyProperties(agendamentoRecordDto, agendamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentosRepository.save(agendamentoModel));

    }


    @GetMapping("/agendamentos")
    public ResponseEntity<List<AgendamentosModel>> getAllAgendamentos (){
        List<AgendamentosModel> agendamentosModelList = agendamentosRepository.findAll();
            if(!agendamentosModelList.isEmpty()){
                for (AgendamentosModel agendamentos: agendamentosModelList) {
                    UUID id = agendamentos.getId();
                    UUID idPaciente = agendamentos.getIdPaciente();
                    boolean convenio = agendamentos.isConvenio();
                    LocalDate dataConsulta = agendamentos.getDataConsulta();
                    LocalTime horaConsulta = agendamentos.getHoraConsulta();
                }
            }
        return ResponseEntity.status(HttpStatus.OK).body(agendamentosModelList);
    }

    @GetMapping("/agendamentos/{id}")
    public ResponseEntity<Object>getOneAgendamentos(@PathVariable(value = "id") UUID id) {
        Optional<AgendamentosModel> agendamentosModelOptional = agendamentosRepository.findById(id);
        if (agendamentosModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(agendamentosModelOptional.get());
    }


    @PutMapping("/agendamentos/{id}")
    public ResponseEntity<Object> updateAgendamentos(@PathVariable(value = "id") UUID id, @RequestBody @Valid AgendamentoRecordDto agendamentoRecordDto) {
        Optional<AgendamentosModel> agendamentosModelOptional = agendamentosRepository.findById(id);
        if (agendamentosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado!");
        }
        var agendamentoModel = agendamentosModelOptional.get();
        BeanUtils.copyProperties(agendamentoRecordDto, agendamentoModel);
        return ResponseEntity.status(HttpStatus.OK).body(agendamentosRepository.save(agendamentoModel));

    }

    @DeleteMapping("/agendamentos/{id}")
    public ResponseEntity<Object> deleteAgendamento (@PathVariable(value = "id") UUID id) {
        Optional<AgendamentosModel> agendamentosModelOptional = agendamentosRepository.findById(id);
        if(agendamentosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado!");
        }
        agendamentosRepository.delete(agendamentosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento excluído com sucesso!");
    }
}

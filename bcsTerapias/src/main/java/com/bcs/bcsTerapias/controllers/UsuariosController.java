package com.bcs.bcsTerapias.controllers;

import com.bcs.bcsTerapias.dtos.UsuarioRecordDto;
import com.bcs.bcsTerapias.models.UsuariosModel;
import com.bcs.bcsTerapias.repositories.UsuarioRepository;
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
public class UsuariosController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuariosModel> saveUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        var usuarioModel = new UsuariosModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuariosModel>> getAllUsuarios(){
        List<UsuariosModel> usuariosList = usuarioRepository.findAll();
            if (!usuariosList.isEmpty()) {
                for (UsuariosModel usuario : usuariosList){
                    UUID id = usuario.getIdUsuario();
                    String nome = usuario.getNome();
                    String login = usuario.getLogin();
                    String senha = usuario.getSenha();
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(usuariosList);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> getOneUsuarios(@PathVariable(value = "id") UUID id){
        Optional<UsuariosModel> usuariosModelOptional = usuarioRepository.findById(id);
        if(usuariosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuariosModelOptional.get());
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") UUID id, @RequestBody @Valid UsuarioRecordDto usuarioRecordDto){
        Optional<UsuariosModel> usuariosModelOptional = usuarioRepository.findById(id);
        if (usuariosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        var usuarioModel = usuariosModelOptional.get();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));
    }


    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") UUID id) {
        Optional<UsuariosModel> usuariosModelOptional = usuarioRepository.findById(id);
        if(usuariosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        usuarioRepository.delete(usuariosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso!");
    }

}

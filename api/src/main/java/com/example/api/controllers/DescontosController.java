package com.example.api.controllers;

import com.example.api.models.DescontosModel;
import com.example.api.repositories.DescontosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/descontos")
public class DescontosController {

    @Autowired
    private DescontosRepository descontosRepository;

    @GetMapping
    public List<DescontosModel> buscarTodosDescontos() {
        return descontosRepository.findAll();
    }

    @PostMapping
    public DescontosModel salvarDesconto(@Validated @RequestBody DescontosModel descontosModel) {
        return descontosRepository.save(descontosModel);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<DescontosModel> atualizarDesconto(@PathVariable int id, @RequestBody DescontosModel descontoAtualizado) {
        Optional<DescontosModel> descontoExistente = descontosRepository.findById(id);

        if (descontoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DescontosModel desconto = descontoExistente.get();
        BeanUtils.copyProperties(descontoAtualizado, desconto);

        descontosRepository.save(desconto);

        return ResponseEntity.ok(desconto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarDesconto(@PathVariable int id) {
        Optional<DescontosModel> desconto = descontosRepository.findById(id);

        if (desconto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        descontosRepository.delete(desconto.get());
        return ResponseEntity.ok(desconto);
    }
}
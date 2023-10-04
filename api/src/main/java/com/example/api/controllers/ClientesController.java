package com.example.api.controllers;

import ch.qos.logback.core.net.server.Client;
import com.example.api.models.ClientesModel;
import com.example.api.models.ProdutosModel;
import com.example.api.repositories.ClientesRepository;
import com.example.api.services.ClientesService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ClientesService clientesService;

    @PersistenceContext
    private EntityManager entityManager;

    public ClientesController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping
    public ResponseEntity<List<ClientesModel>> listarClientes() {
        List clientes = clientesService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping
    public ClientesModel salvarCliente(@Validated @RequestBody ClientesModel clientesModel) {
       return clientesRepository.save(clientesModel);
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<ClientesModel> atualizarCliente(@PathVariable int id, @RequestBody ClientesModel clienteAtualizado) {
        Optional<ClientesModel> clienteExistente = clientesRepository.findById(id);

        if (clienteExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClientesModel cliente = clienteExistente.get();
        BeanUtils.copyProperties(clienteAtualizado, cliente);

        clientesRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable int id) {
        Optional<ClientesModel> cliente = clientesRepository.findById(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        clientesRepository.delete(cliente.get());
        return ResponseEntity.ok(cliente);
    }
}
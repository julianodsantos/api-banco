package com.example.api.controllers;

import com.example.api.models.ClientesModel;
import com.example.api.models.ProdutosModel;
import com.example.api.repositories.ProdutosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping
    public List<ProdutosModel> buscarTodosProdutos() {
        return produtosRepository.findAll();
    }

    @PostMapping
    public ProdutosModel salvarProdutos(@Validated @RequestBody ProdutosModel produtosModel) {
        return produtosRepository.save(produtosModel);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ProdutosModel> atualizarProduto(@PathVariable int id, @RequestBody ProdutosModel produtoAtualizado) {
        Optional<ProdutosModel> produtoExistente = produtosRepository.findById(id);

        if (produtoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProdutosModel produto = produtoExistente.get();
        BeanUtils.copyProperties(produtoAtualizado, produto);

        produtosRepository.save(produto);

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable int id) {
        Optional<ProdutosModel> produto = produtosRepository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produtosRepository.delete(produto.get());
        return ResponseEntity.ok(produto);
    }
}
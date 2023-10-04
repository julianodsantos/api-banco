package com.example.api.controllers;

import com.example.api.models.ComprasModel;
import com.example.api.repositories.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/compras")
@RestController
public class ComprasController {
    @Autowired
    private ComprasRepository comprasRepository;

    @GetMapping("/clientes/{comIdCliente}")
    public List<ComprasModel> buscarComprasPorCliente(@PathVariable int comIdCliente) {
        List<ComprasModel> compras = comprasRepository.findAllByCodigoCliente(comIdCliente);
        return compras;
    }

    @GetMapping("/{dataInicial}/{dataFinal}")
    public List<ComprasModel> buscarComprasPorPeriodo(@PathVariable("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial,
                                                      @PathVariable("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal) {
        List<ComprasModel> compras = comprasRepository.findAllByComDataBetween(dataInicial, dataFinal);
        return compras;
    }
}



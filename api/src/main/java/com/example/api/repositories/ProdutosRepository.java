package com.example.api.repositories;

import com.example.api.models.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Integer> {
}

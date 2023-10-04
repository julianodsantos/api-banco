package com.example.api.repositories;

import com.example.api.models.DescontosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescontosRepository extends JpaRepository<DescontosModel, Integer> {
}

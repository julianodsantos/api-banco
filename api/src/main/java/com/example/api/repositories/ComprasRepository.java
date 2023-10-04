package com.example.api.repositories;

import com.example.api.models.ComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ComprasRepository extends JpaRepository<ComprasModel, Integer> {
    @Query(value = "CALL BUSCAR_TODAS_AS_COMPRAS_DO_CLIENTE(:comIdCliente)", nativeQuery = true)
    List<ComprasModel> findAllByCodigoCliente(@Param("comIdCliente") int comIdCliente);

    @Query(value = "CALL BUSCAR_TODAS_AS_COMPRAS_DO_PERIODO(:dataInicial, :dataFinal)", nativeQuery = true)
    List<ComprasModel> findAllByComDataBetween(@Param("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial,
                                               @Param("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal);
}

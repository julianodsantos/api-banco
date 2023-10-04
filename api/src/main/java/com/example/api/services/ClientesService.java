package com.example.api.services;

import com.example.api.models.ClientesModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List listarClientes() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("BUSCAR_TODOS_OS_CLIENTES", ClientesModel.class);
        query.execute();
        return query.getResultList();
    }
}

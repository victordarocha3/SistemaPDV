package com.MaxiAtacado.pdv;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VendaRepository {

    private final JdbcTemplate jdbcTemplate;

    public VendaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(double total, String formaPagamento) {
        String sql = "INSERT INTO venda (total, forma_pagamento) VALUES (?, ?)";
        jdbcTemplate.update(sql, total, formaPagamento);
    }
}
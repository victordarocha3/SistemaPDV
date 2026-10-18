package com.MaxiAtacado.pdv;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Produtos produto) {
        String sql = "INSERT INTO produto (nome, codigo_barras, preco, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, produto.getNome_Produto(), produto.getCodigoBarras(), produto.getPreco(), produto.getEstoque());
    }

    public List<Produtos> listarTodos() {
        String sql = "SELECT * FROM produto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Produtos(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("codigo_barras"),
                rs.getBigDecimal("preco"),
                rs.getInt("estoque")
        ));
    }

    public Optional<Produtos> findById(Long id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        List<Produtos> resultado = jdbcTemplate.query(sql, (rs, rowNum) -> new Produtos(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("codigo_barras"),
                rs.getBigDecimal("preco"),
                rs.getInt("estoque")
        ), id);

        return resultado.stream().findFirst();
    }

    public void atualizarEstoque(Long id, int novoEstoque) {
        String sql = "UPDATE produto SET estoque = ? WHERE id = ?";
        jdbcTemplate.update(sql, novoEstoque, id);
    }
}
package com.MaxiAtacado.pdv;

import java.math.BigDecimal;

public class Produtos {
    private Long id;
    private String nome_Produto;
    private String codigoBarras;
    private BigDecimal preco;
    private Integer estoque;

    public Produtos() {
    }

    public Produtos(Long id, String nome_Produto, String codigoBarras, BigDecimal preco, Integer estoque) {
        this.id = id;
        this.nome_Produto = nome_Produto;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}

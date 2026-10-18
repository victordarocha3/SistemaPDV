package com.MaxiAtacado.pdv;

public class VendaDTO {

    private Long produtoId;
    private int quantidade;
    private String formaPagamento;

    public VendaDTO() {
    }

    public VendaDTO(Long produtoId, int quantidade, String formaPagamento) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
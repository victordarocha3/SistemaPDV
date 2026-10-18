package com.MaxiAtacado.pdv;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;

    public VendaController(ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    @PostMapping
    public ResponseEntity<?> realizarVenda(@RequestBody VendaDTO dadosVenda) {
        Produtos produto = produtoRepository.findById(dadosVenda.getProdutoId())
                .orElse(null);

        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Produto não encontrado!");
        }

        if (produto.getEstoque() < dadosVenda.getQuantidade()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: Estoque insuficiente! Disponível: " + produto.getEstoque());
        }

        int novoEstoque = produto.getEstoque() - dadosVenda.getQuantidade();
        produtoRepository.atualizarEstoque(produto.getId(), novoEstoque);

        double total = produto.getPreco().doubleValue() * dadosVenda.getQuantidade();
        vendaRepository.salvar(total, dadosVenda.getFormaPagamento());

        return ResponseEntity.ok("Venda realizada com sucesso! Total: R$ " + total);
    }
}
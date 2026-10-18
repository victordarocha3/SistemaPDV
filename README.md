# PDV Backend - Sistema de Ponto de Venda

API REST desenvolvida em Java com Spring Boot para gerenciamento de estoque e registro de vendas de um Ponto de Venda (PDV).

O objetivo deste projeto foi construir a camada de backend do zero, cobrindo desde o mapeamento das requisições até a persistência de dados em um banco de dados relacional rodando em ambiente containerizado.

---

## Mapeamento de Funcionalidades

- **Gerenciamento de Produtos:** Cadastro de novos itens garantindo a unicidade do código de barras e controle da quantidade inicial em estoque.
- **Consulta de Catálogo:** Endpoint para listagem de produtos com saldo atualizado.
- **Processamento de Vendas:**
    - Verificação de saldo de estoque antes do processamento.
    - Baixa automática no estoque após a confirmação da transação.
    - Registro da venda com cálculo de total e forma de pagamento.

---

## Tecnologias e Ferramentas

- **Linguagem:** Java 17
- **Framework:** Spring Boot
- **Acesso a Dados:** Spring JDBC (`JdbcTemplate`)
- **Banco de Dados:** PostgreSQL
- **Infraestrutura:** Docker e Docker Compose
- **Testes de API:** Postman

---

## Arquitetura do Projeto

```text
pdv/
├── src/main/java/com/MaxiAtacado/pdv/
│   ├── PdvApplication.java        # Inicialização do Spring Boot
│   ├── ProdutoController.java     # Endpoints HTTP de produtos
│   ├── ProdutoRepository.java     # Queries SQL de produtos (JdbcTemplate)
│   ├── Produtos.java              # Entidade/Modelo de Produto
│   ├── VendaController.java       # Endpoints HTTP de vendas
│   ├── VendaDTO.java              # DTO para recebimento dos dados da venda
│   └── VendaRepository.java       # Queries SQL de vendas e atualização de estoque
├── src/main/resources/
│   ├── application.properties    # Configurações do datasource
│   └── schema.sql                # Script de criação das tabelas
└── docker-compose.yml            # Definição do container PostgreSQL
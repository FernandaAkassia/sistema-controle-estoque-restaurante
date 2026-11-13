# Sistema de Controle de Estoque para Restaurante

## Sobre o projeto

Este projeto consiste no desenvolvimento de um banco de dados relacional para controle de estoque de um restaurante.

O sistema permite organizar produtos e categorias, registrar movimentações de entrada e saída, atualizar automaticamente as quantidades em estoque e identificar produtos que atingiram o nível mínimo.

## Objetivos

- Organizar o cadastro de produtos e categorias.
- Registrar entradas e saídas de mercadorias.
- Atualizar automaticamente o estoque.
- Impedir saídas superiores à quantidade disponível.
- Identificar produtos com estoque baixo.
- Consultar o histórico de movimentações.

## Funcionalidades implementadas

- Criação e relacionamento de tabelas.
- Chaves primárias e estrangeiras.
- Triggers para atualização automática do estoque.
- Validação de saídas conforme a disponibilidade.
- View para identificação de estoque baixo.
- Consultas SQL com JOIN e ordenação de resultados.
- Relatórios de produtos por categoria.

## Tecnologias utilizadas

- SQL
- MySQL
- MySQL Workbench

## Status do projeto

Banco de dados desenvolvido e testado. Próximas etapas: organização dos arquivos SQL, publicação da estrutura do banco e desenvolvimento da interface da aplicação.

## Estrutura do projeto

- `README.md`: documentação e apresentação do projeto.
- `restaurante_stock.sql`: estrutura do banco de dados, tabelas e view de alerta de estoque.
- `triggers.sql`: regras para validação de saídas e atualização automática do estoque.
- `consultas.sql`: consultas SQL para relatórios e análise das movimentações.

## Como executar o projeto

1. Instale o MySQL Server e o MySQL Workbench.
2. Abra o MySQL Workbench e conecte-se ao servidor.
3. Execute o arquivo `restaurante_stock.sql` para criar a estrutura do banco de dados.
4. Execute o arquivo `triggers.sql` para configurar as regras automáticas.
5. Execute as consultas disponíveis em `consultas.sql` para visualizar os relatórios.

## Autora

Projeto desenvolvido como prática de conhecimentos adquiridos na graduação em Análise e Desenvolvimento de Sistemas.

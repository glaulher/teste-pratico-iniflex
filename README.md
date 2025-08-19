# Desafio de Processo Seletivo - Projedata

Este é um projeto simples em Java criado como parte do processo seletivo para a Projedata. A aplicação gerencia uma lista de funcionários, realizando diversas operações e exibindo os resultados no console.

## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd seu-repositorio
   ```

3. **Compile o projeto usando o Maven:**
   ```bash
   mvn compile
   ```

4. **Execute a aplicação:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.iniflex.Principal"
   ```

## Tecnologias Utilizadas

- Java
- Maven

## Requisitos do Teste Prático

| Requisito | Atendido? | Onde é implementado |
| --- | --- | --- |
| 1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate). | Sim | `src/main/java/com/iniflex/Pessoa.java` |
| 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String). | Sim | `src/main/java/com/iniflex/Funcionario.java` |
| 3 – Deve conter uma classe Principal para executar as seguintes ações: | Sim | `src/main/java/com/iniflex/Principal.java` |
| 3.1 – Inserir todos os funcionários, na mesma ordem e informações solicitadas. | Sim | `Principal.java` no método `carregarFuncionarios` |
| 3.2 – Remover o funcionário “João” da lista. | Sim | `Principal.java` no método `main` e `removerFuncionario` |
| 3.3 – Imprimir todos os funcionários com todas suas informações. | Sim | `Principal.java` no método `imprimirFuncionarios` |
| 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor. | Sim | `Principal.java` no método `main` e `aumentarSalarios` |
| 3.5 – Agrupar os funcionários por função em um MAP. | Sim | `Principal.java` no método `main` e `agruparPorFuncao` |
| 3.6 – Imprimir os funcionários, agrupados por função. | Sim | `Principal.java` no método `main` e `imprimirFuncionariosAgrupados` |
| 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12. | Sim | `Principal.java` no método `main` e `imprimirAniversariantes` |
| 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade. | Sim | `Principal.java` no método `main` e `imprimirFuncionarioMaisVelho` |
| 3.10 – Imprimir a lista de funcionários por ordem alfabética. | Sim | `Principal.java` no método `main` e `imprimirOrdemAlfabetica` |
| 3.11 – Imprimir o total dos salários dos funcionários. | Sim | `Principal.java` no método `main` e `imprimirTotalSalarios` |
| 3.12 – Imprimir quantos salários mínimos ganha cada funcionário. | Sim | `Principal.java` no método `main` e `imprimirSalariosMinimos` |
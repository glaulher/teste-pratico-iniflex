package com.iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

  private static final String OPERADOR = "Operador";
  private static final DateTimeFormatter FORMATADOR_DATA =
      DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final NumberFormat FORMATADOR_MOEDA =
      NumberFormat.getCurrencyInstance(
          new Locale.Builder().setLanguage("pt").setRegion("BR").build());
  private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

  public static void main(String[] args) {
    List<Funcionario> funcionarios = carregarFuncionarios();

    removerFuncionario(funcionarios, "João");

    imprimirFuncionarios(funcionarios);

    aumentarSalarios(funcionarios);

    Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);

    imprimirFuncionariosAgrupados(funcionariosPorFuncao);

    imprimirAniversariantes(funcionarios);

    imprimirFuncionarioMaisVelho(funcionarios);

    imprimirOrdemAlfabetica(funcionarios);

    imprimirTotalSalarios(funcionarios);

    imprimirSalariosMinimos(funcionarios);
  }

  private static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
    funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
  }

  private static void aumentarSalarios(List<Funcionario> funcionarios) {
    funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.10"))));
  }

  private static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
    return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirFuncionariosAgrupados(Map<String, List<Funcionario>> mapa) {
    System.out.println("\n=== Funcionários por Função ===");
    mapa.forEach(
        (funcao, lista) -> {
          System.out.println(funcao + ":");
          lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {

    LocalDate dataMaisAntiga =
        funcionarios.stream().map(Funcionario::getDataNascimento).min(LocalDate::compareTo).get();

    List<Funcionario> maisVelhos =
        funcionarios.stream()
            .filter(f -> f.getDataNascimento().equals(dataMaisAntiga))
            .collect(Collectors.toList());

    System.out.println("\n=== Funcionário mais velho ===");

    maisVelhos.forEach(
        f -> {
          int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
          System.out.println(f.getNome() + " - " + idade + " anos");
        });
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
    System.out.println("\n=== Funcionários em Ordem Alfabética ===");
    funcionarios.stream()
        .sorted(Comparator.comparing(Funcionario::getNome))
        .forEach(f -> System.out.println(f.getNome()));
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
    BigDecimal totalSalarios =
        funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("\nTotal dos salários: " + FORMATADOR_MOEDA.format(totalSalarios));
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
    System.out.println("\n=== Salários Mínimos por Funcionário ===");

    System.out.printf("%-15s | %-20s%n ", "Nome", "Quantidade");
    System.out.println("---------------------------------------");

    funcionarios.forEach(
        f -> {
          BigDecimal qtd = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
          System.out.printf("%-15s | %-20s%n", f.getNome(), qtd + " salários mínimos");
        });
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirAniversariantes(List<Funcionario> funcionarios) {
    System.out.println("\n=== Aniversariantes Outubro e Dezembro ===");

    System.out.printf("%-15s | %-12s%n ", "Nome", "Data");
    System.out.println("----------------------------");

    funcionarios.stream()
        .filter(
            f ->
                f.getDataNascimento().getMonthValue() == 10
                    || f.getDataNascimento().getMonthValue() == 12)
        .forEach(
            f -> {
              String dataFormatada = f.getDataNascimento().format(FORMATADOR_DATA);

              System.out.printf("%-15s | %-12s%n", f.getNome(), dataFormatada);
            });
  }

  @SuppressWarnings("squid:S106")
  private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
    System.out.println("\n=== Lista de Funcionários ===");

    System.out.printf("%-15s | %-12s | %-15s | %-15s%n", "Nome", "Nascimento", "Salário", "Função");
    System.out.println("---------------------------------------------------------------");

    funcionarios.forEach(
        f -> {
          String dataFormatada = f.getDataNascimento().format(FORMATADOR_DATA);
          String salarioFormatado = FORMATADOR_MOEDA.format(f.getSalario());
          System.out.printf(
              "%-15s | %-12s | %-15s | %-15s%n",
              f.getNome(), dataFormatada, salarioFormatado, f.getFuncao());
        });
  }

  private static List<Funcionario> carregarFuncionarios() {
    return new ArrayList<>(
        Arrays.asList(
            new Funcionario(
                "Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), OPERADOR),
            new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), OPERADOR),
            new Funcionario(
                "Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario(
                "Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
            new Funcionario(
                "Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario(
                "Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), OPERADOR),
            new Funcionario(
                "Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
            new Funcionario(
                "Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario(
                "Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario(
                "Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")));
  }
}

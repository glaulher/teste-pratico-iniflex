package com.iniflex;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

  private BigDecimal salario;
  private String funcao;

  public String getFuncao() {
    return funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(nome, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  @Override
  public String toString() {
    return "Funcionario [salario="
        + salario
        + ", funcao="
        + funcao
        + ", getNome()="
        + getNome()
        + ", getDataNascimento()="
        + getDataNascimento()
        + "]";
  }
}

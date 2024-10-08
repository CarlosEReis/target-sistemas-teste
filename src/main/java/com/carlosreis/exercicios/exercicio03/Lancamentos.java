package com.carlosreis.exercicios.exercicio03;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lancamentos {
    private List<Lancamento> lancamentos;

    public Lancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public BigDecimal calcMenorFaturamento() {
        return lancamentos.stream()
            .map(Lancamento::valor)
            .filter(valor -> valor.compareTo(BigDecimal.ZERO) > 0)
            .min(BigDecimal::compareTo)
            .orElse(BigDecimal.ZERO);
    }

    public BigDecimal calcMaiorFaturamento() {
        return lancamentos.stream()
            .map(Lancamento::valor)
            .max(BigDecimal::compareTo)
            .orElse(BigDecimal.ZERO);
    }

    public long calcDiasFaturamentoAcimaMediaMensal() {
        var mediaMensal = calcMediaMensal();
        return lancamentos.stream()
            .filter(lancamento -> lancamento.valor().compareTo(mediaMensal) > 0)
            .count();
    }

    public void mostraLancamentosFatAcimaMediaMensal() {
        var mediaMensal = calcMediaMensal();
        lancamentos.stream()
            .filter(lancamento -> lancamento.valor().compareTo(mediaMensal) > 0)
            .forEach(System.out::println);
    }

    public BigDecimal calcMediaMensal() {
        var soma = lancamentos.stream()
            .map(Lancamento::valor)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        var contagem = lancamentos.stream()
            .map(Lancamento::valor)
            .filter(valor -> valor.compareTo(BigDecimal.ZERO) > 0)
            .count();
    
        return soma.divide(BigDecimal.valueOf(contagem), 2, RoundingMode.HALF_UP);
    }
}
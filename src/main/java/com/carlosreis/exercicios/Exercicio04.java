package com.carlosreis.exercicios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercicio04 {
    
    /*
     * 
    * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado: 
        •	SP – R$67.836,43 
        •	RJ – R$36.678,66 
        •	MG – R$29.229,88 
        •	ES – R$27.165,48 
        •	Outros – R$19.849,53 

        Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.
        
        RESPOSTA:
        SP: 37.53%
        RJ: 20.29%
        MG: 16.17%
        ES: 15.03%
        Outros: 10.98% 
     */

    public static void main(String[] args) {
        
        Map<String, BigDecimal> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", new BigDecimal("67836.43"));
        faturamentoPorEstado.put("RJ", new BigDecimal("36678.66"));
        faturamentoPorEstado.put("MG", new BigDecimal("29229.88"));
        faturamentoPorEstado.put("ES", new BigDecimal("27165.48"));
        faturamentoPorEstado.put("Outros", new BigDecimal("19849.53"));

        mostraPercentualFaturamentoPorEstado(faturamentoPorEstado);
    }

    static void mostraPercentualFaturamentoPorEstado(Map<String, BigDecimal> faturamentoPorEstado) {
            BigDecimal faturamentoTotal = calcularFaturamentoTotal(faturamentoPorEstado.values());
            for (Map.Entry<String, BigDecimal> entry : faturamentoPorEstado.entrySet()) {
                String estadoUf = entry.getKey();
                BigDecimal fatEstadoAtual = entry.getValue();

                BigDecimal percentual = getPercentual(faturamentoTotal, fatEstadoAtual);

                System.out.println(estadoUf + ": " + percentual + "%");
            }
    }

    private static BigDecimal getPercentual(BigDecimal faturamentoTotal, BigDecimal fatAtual) {
        return fatAtual
        .multiply(new BigDecimal(100))
        .divide(faturamentoTotal, 2, RoundingMode.HALF_UP);
    }

    private static BigDecimal calcularFaturamentoTotal(Collection<BigDecimal> valores) {
        return valores
            .stream()
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

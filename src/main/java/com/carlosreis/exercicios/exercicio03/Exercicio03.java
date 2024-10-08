package com.carlosreis.exercicios.exercicio03;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Exercicio03 {
    /*    
    3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne: 
    • O menor valor de faturamento ocorrido em um dia do mês; 
    • O maior valor de faturamento ocorrido em um dia do mês; 
    • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal. 

    IMPORTANTE: 
    a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal; 
    b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média; 
    */
    
     /*
    Resposta:
    O menor valor de faturamento: 373.7838
    O maior valor de faturamento: 48924.2448
    Número de dias que o valor de faturamento diário foi superior à média mensal: 10
    */

    private static Lancamentos lancamentos;

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

         List<Lancamento> lancamentosList = mapper.readValue(
            Exercicio03.class.getResourceAsStream("/dados.json"),
            mapper.getTypeFactory().constructCollectionType(List.class, Lancamento.class));

        lancamentos = new Lancamentos(lancamentosList);

        System.out.println("O menor valor de faturamento: " + lancamentos.calcMenorFaturamento());
        System.out.println("O maior valor de faturamento: " + lancamentos.calcMaiorFaturamento());
        System.out.println("Número de dias que o valor de faturamento diário foi superior à média mensal: " + lancamentos.calcDiasFaturamentoAcimaMediaMensal());

        System.out.println("\n\nMedia Mensal: " + lancamentos.calcMediaMensal());
        lancamentos.mostraLancamentosFatAcimaMediaMensal();

    }

}

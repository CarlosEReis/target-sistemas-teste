package com.carlosreis.exercicios;

public class Exercicio01 {

    /* @Description:
     * 1) Observe o trecho de código abaixo: 
     * 
     * int INDICE = 13, SOMA = 0, K = 0; 
     * Enquanto K < INDICE faça { 
     *      K = K + 1; SOMA = SOMA + K; 
     * }
     * Imprimir(SOMA);
     * 
     * Ao final do processamento, qual será o valor da variável SOMA? 
     *
     * RESPOSTA: 91
     * 
     * @Author: Carlos E. Reis
     * @Email: carlos@gmail.com
     */

    public static void main(String[] args) {

        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("O valor final da variável SOMA é: " + SOMA);

    }
}
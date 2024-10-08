package com.carlosreis.exercicios;

import java.util.Scanner;

public class Exercicio02 {
    
    /* @Description
     * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor
     * sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), 
     * escreva um programa na linguagem que desejar onde, informado um número, ele calcule a
     * sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence 
     * ou não a sequência. 
     * 
     * @Author: Carlos E. Reis
     * @Email: carlos@gmail.com
     */
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero = Integer.parseInt(sc.nextLine());
        sc.close();

        boolean possuiNumero = verificaNumero(numero);

        if (possuiNumero) {
            System.out.println("\nO número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("\nO número " + numero + " não pertence à sequência de Fibonacci.");
        }

    }


    /* @Description:
     * Este metodo verifica se um número pertence à sequência de Fibonacci.
     * 
     * @Param: int numero - O número a ser verificado.
     * 
     * @Author: Carlos E. Reis
     * @Email: carlos@gmail.com
     */

    private static boolean verificaNumero(int numero) {
        int proximo;
        int anterior = 0;
        int atual = 1;
        
        boolean possuiNumero = false;

        while (atual < numero) {
            System.out.print(anterior + " ");
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        if (atual == numero) 
            possuiNumero = true;
    
        return possuiNumero;
    }
}

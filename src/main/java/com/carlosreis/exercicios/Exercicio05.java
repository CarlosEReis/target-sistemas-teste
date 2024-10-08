package com.carlosreis.exercicios;

import java.util.Scanner;

public class Exercicio05 {

    /*
    @Description:
      5) Escreva um programa que inverta os caracteres de um string. 

        IMPORTANTE: 
        a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código; 
        b) Evite usar funções prontas, como, por exemplo, reverse; 
     
    * @Author: Carlos E. Reis
    * @Email: carlos@gmail.com
    */

    public static void main(String[] args) {
        
        var sc = new Scanner(System.in);
        var palavra = sc.nextLine();
        sc.close();

        StringBuilder palavraInvertida = new StringBuilder();

        for(int i = palavra.length()-1; i >= 0;i--) {
            palavraInvertida.append(palavra.charAt(i));
        }

        System.out.println("A string invertida é: " + palavraInvertida.toString());    
    }
}

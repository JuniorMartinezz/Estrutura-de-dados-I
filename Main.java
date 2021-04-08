package Estrutura_Ramon.AP1;

import java.util.Scanner;

public class Main {
    static Matriz matriz = new Matriz(100);

    static int[][] matrizPadrao = { { 1, 1 }, { 1, 0 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIniciando o programa...");

        matriz.preencheAuto();

        menu(sc);

        sc.close();

        System.out.println("\nPrograma concluído!");
    }

    private static void menu(Scanner sc) {
        System.out.println("\nDigite a opção desejada:\n\n1- Atualizar matriz principal \n2- Buscar matriz padrão \n3- Atualizar manualmente a matriz padrão \n4- Preencher com a matriz padrão \n0- Sair\n ");
        byte opcao = sc.nextByte();

        switch (opcao) {
            case 1:
                Cronometro.clearMedia();
                matriz.preencheAuto();
                break;
        
            case 2:
                Cronometro.clearMedia();
                System.out.println(matriz.buscaPadrao(matrizPadrao));
                break;

            case 3:
                Cronometro.clearMedia();
                mudaMatrizPadrao(sc);
                break;
            
            case 4:
                Cronometro.clearMedia();
                matriz.preencheMatriz(1);
                matriz.definePadrao();
                break;
        }

        if (opcao != 0) {
            menu(sc);
        }
    }

    public static void mudaMatrizPadrao(Scanner sc){
        System.out.println("\nDigite o tamanho da matriz padrão(limite: 4)");
        int tamanho = sc.nextInt();

        if(tamanho <= 4){
            matrizPadrao = new int[tamanho][tamanho];

            for(int i = 0; i < tamanho; i++){
                for(int j = 0; j < tamanho; j++){
                    System.out.println("\nDigite o valor para a posição [" + i + "][" + j + "] (apenas 0 e 1 permitidos)");
                    matrizPadrao[i][j] = sc.nextInt();
                    if(matrizPadrao[i][j] !=0 && matrizPadrao[i][j] !=1){
                        matrizPadrao[i][j] = 0;
                    }
                }
            }
        } else {
            System.out.println("\nValor inválido!");
        }
    }
}

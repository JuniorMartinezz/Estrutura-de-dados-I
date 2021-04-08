package Estrutura_Ramon.AP1;

import java.util.Scanner;

public class Matriz {

    int largura;
    int[][] matrizRef;

    public Matriz(int largura){
        this.largura = largura;
        this.matrizRef = new int[largura][largura];
    }
    
    public void preencheAuto() {
        System.out.println("\nMatriz principal preenchida!");
        // cria a matriz principal
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.largura; j++) {
                this.matrizRef[i][j] = (int) Math.round(Math.random() * 1);
            }
        }
    }

    public void preencheMatriz(int value){
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.largura; j++) {
                this.matrizRef[i][j] = (int) value;
            }
        }
    }

    public void definePadrao(){
        this.matrizRef[50][0] = 1; 
        this.matrizRef[50][1] = 1; 
        this.matrizRef[51][0] = 1; 
        this.matrizRef[51][1] = 0; 

        this.matrizRef[70][70] = 1; 
        this.matrizRef[70][71] = 1; 
        this.matrizRef[71][70] = 1; 
        this.matrizRef[71][71] = 0; 
    }

    public String buscaPadrao(int[][] m){
        int size = (int) m.length;
        int diferenca = this.largura - size;

        Cronometro.start();

        for(int l = 0; l < diferenca; l++){
            for(int c = 0; c < diferenca; c++){
                if(matrizRef[l][c] == m[0][0]){
                    if(busca(m, size, l, c) == 1){
                        Cronometro.stop();
                        return "Padrão encontrado!";
                    }
                }
            }
        }

        Cronometro.stop();
        return "Padrão não encontrado!";
    }

    public int busca(int[][] m, int size, int l, int c){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrizRef[l+i][c+j] != m[i][j]){
                    return 0;
                }
            }
        }
        return 1;
    }

}

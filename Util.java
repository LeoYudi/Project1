package main;

import java.util.*;
import javax.swing.*;

public abstract class Util {

    public static boolean isValid(int grafo, int restricao) {
        if (restricao != -1) { // O grafo nao pode ter a mesma chave do int "restricao"
            if (grafo < 0 || grafo > Funcionalidade.matriz.length || grafo == restricao) {
                JOptionPane.showMessageDialog(null, "O grafo inserido nao eh valido!");
                return false;
            } else
                return true;
        } else { // Nao ha nenhuma restricao
            if (grafo < 0 || grafo > Funcionalidade.matriz.length) {
                JOptionPane.showMessageDialog(null, "O grafo inserido nao eh valido!");
                return false;
            } else
                return true;
        }
    }

    public static int grafoInicial() {
        int ini;
        while (true) {
            try {
                do
                    ini = Integer.valueOf(JOptionPane.showInputDialog("             Insira o vertice inicial:"));
                while (!Util.isValid(ini, -1));
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "        Insira um vertice!");
            }
        }
        return ini;
    }

    public static void imprimirMatrizAdj(int[][] matriz) {
        int dim = matriz.length;
        System.out.printf("    0 ");
        for (int i=1; i<dim; i++)
            System.out.printf("%2d ", i);
        	
        System.out.println();
        for (int i=0; i<dim; i++) {
        System.out.printf("%2d ", i);
        for(int j=0; j<dim; j++)
            System.out.printf("%2d ", matriz[i][j]);
        System.out.println();
        }
    }
	
    public static void imprimirListaAdj(ArrayList<Aresta>[] lista) {
    	System.out.println("\n\n\n\n\n");
        for(int i=0; i<lista.length; i++) {
            System.out.printf("%d ", i);
            if(lista[i].isEmpty()) {
		System.out.println("-> null");
            }
				
            else {
		for(int j=0; j<lista[i].size(); j++) 
                    System.out.printf("-> %d ",lista[i].get(j).getChave());
                System.out.println("-> null");
            }
	    }
    }
	
    public static void exibirLargura(Grafo[] grafos, int noInicial) {	
        System.out.printf("\n\n\n\nGrafo raiz: %d\n\n", noInicial);
        for (int i=0; i<grafos.length; i++) {
            if(grafos[i].getChave() != noInicial) {
                System.out.printf("Grafo %d\nDistancia: %d\nCaminho: [%d] ", 
                        grafos[i].getChave(), 
                        grafos[i].getDistancia(), 
                        grafos[i].getChave());
                int j = grafos[i].getChave();
                while(j != noInicial) {
                    j = grafos[j].getPredecessor();
                    if (j == -1) {
                        System.out.printf("<-- null");
                        break;
                    }
                    else System.out.printf("<-- [%d] ", grafos[j].getChave());              
                }
                System.out.printf("\n\n");
            }
        }
        System.out.printf("\n\n\n");        
    }
    
    public static void exibirProfundidade(Grafo[] grafos, int noInicial) {
    	System.out.printf("\n\n\n\nGrafo inicial: %d\nTempo de chegada: %d\nTempo de saida: %d\n\n",
    			noInicial,
    			grafos[noInicial].getTempoChegada(),
    			grafos[noInicial].getTempoFim());
        for (int i=0; i<grafos.length; i++) 
            if(grafos[i].getChave() != noInicial) 
            	System.out.printf("Grafo %d\nTempo de chegada: %d\nTempo de saida: %d\n\n",
            			grafos[i].getChave(),
            			grafos[i].getTempoChegada(),
            			grafos[i].getTempoFim());
        System.out.printf("\n\n\n");
    }

    public static void bubbleSort(Aresta arestas[]) {
        boolean troca = true;
        Aresta aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < arestas.length - 1; i++) {
                if (arestas[i].getValor() > arestas[i + 1].getValor()) {
                    aux = arestas[i];
                    arestas[i] = arestas[i + 1];
                    arestas[i + 1] = aux;
                    troca = true;
                }
            }
        }
    }
    
    
}

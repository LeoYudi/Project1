package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import static main.Funcionalidade.verifCaminhoDijkstraL;
import static main.Funcionalidade.verifCaminhoDijkstraM;

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
        try {
            do
                ini = Integer.valueOf(JOptionPane.showInputDialog("             Insira o vertice inicial:"));
            while (!Util.isValid(ini, -1));
            } catch (NumberFormatException ex) {
                return -1;
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
        System.out.printf("Grafo raiz: %d\n\n", noInicial);
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
    }

    public static void bubbleSort(Aresta arestas[]){
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
    public static void inicializa(Grafo[] grafos, int noInicial) {
        for(int i = 0; i < grafos.length; i++) {
            grafos[i].setDistancia(Integer.MAX_VALUE);
        }
        grafos[noInicial].setDistancia(0);
    }
    
    public static void relaxa(Grafo u, Grafo v, int peso) {
        int soma = u.getDistancia() + peso;
        if(v.getDistancia() > soma) {
            v.setDistancia(soma);
            v.setPredecessor(u.getChave());
        }
    }
    
    public static Grafo extraiMinimo(Queue<Grafo> Q) {
        Grafo atual = null;
        int menor = Integer.MAX_VALUE;
        int flag = 0;
        
        LinkedList<Grafo> novaQ = new LinkedList<>(Q); /* cópia da fila */
        LinkedList<Grafo> aux = new LinkedList<>(); 
        aux = (LinkedList) novaQ.clone();
        
        while(!aux.isEmpty()) { /* procurando a menor distância */
            atual = aux.poll();
            if(atual.getDistancia() < menor) {
                menor = atual.getDistancia();
            }
        }
        
        aux = (LinkedList) novaQ.clone();
        while(!aux.isEmpty() && flag == 0) { /* procurando o vértive com a menor distância */
            atual = aux.poll();
            if(atual.getDistancia() == menor) {
                flag = 1;
            }
        }
        
        return atual;
    }
    
    public static int buscaNoS(Queue<Grafo> S, int valor) {
        Queue<Grafo> aux = S;
        Grafo atual;
        
        while(!aux.isEmpty()) {
            atual = aux.poll();
            if(atual.getChave() == valor) {
                return 1; /* encontrou o vértice em S */
            }
        }
        return 0; /* não encontrou o vértice em S */
    }
    
    public static void imprCaminhoDijkstraL(Grafo grafos[], int ini) {
        for(int i = 0; i < grafos.length; i++) {
            System.out.println("");
            verifCaminhoDijkstraL(ini, i);
            System.out.println("\nDistância = " + grafos[i].getDistancia());
        }
    }
    
    public static void imprCaminhoDijkstraM(Grafo grafos[], int ini) {
        for(int i = 0; i < grafos.length; i++) {
            System.out.println("");
            verifCaminhoDijkstraM(ini, i);
            System.out.println("\nDistância = " + grafos[i].getDistancia());
        }
    }
}

package main;

import java.util.*;
import javax.swing.*;

public abstract class Util {
  
    /* Metodo usado na interface para verificar se um grafo pode ou nao ser selecionado pelo usuario */
    public static boolean isValid(int grafo, int restricao) {
        if (restricao != -1) {  // O grafo nao pode ter a mesma chave do int "restricao"
            if (grafo < 0 || grafo > Funcionalidade.matriz.length || grafo == restricao) {
                JOptionPane.showMessageDialog(null, "O grafo inserido nao é valido!");
                return false;
            } else
                return true;
        } else {    // Nao ha nenhuma restricao, apenas deve ser valido
            if (grafo < 0 || grafo > Funcionalidade.matriz.length) {
                JOptionPane.showMessageDialog(null, "O grafo inserido nao é valido!");
                return false;
            } else
                return true;
        }
    }
    
    /* Metodo usado na interface para pedir um vertice inicial valido para o usuario */
    public static int grafoInicial() {
        int ini;
        try {
            do
                ini = Integer.valueOf(JOptionPane.showInputDialog("Insira o vertice inicial:"));
            while (!Util.isValid(ini, -1));
            } catch (NumberFormatException ex) {
                return -1;
            }
        return ini;
    }

    /* Metodo usado para exibir uma matriz de adjacencia */
    public static void imprMatrizAdj(int[][] matriz) {
        int dim = matriz.length;
        System.out.printf("Exibição de Matriz de Adjacencia:\n\n    0 ");
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
	
    /* Metodo usado para exibir uma lista de adjacencia */
    public static void imprListaAdj(ArrayList<Aresta>[] lista) {
        System.out.println("Exibição de Lista de Adjacencia:\n");
        for(int i=0; i<lista.length; i++) {
            System.out.printf("%d -> ", i);
            for(int j=0; j<lista[i].size(); j++) 
                System.out.printf("%d, ",lista[i].get(j).getChave2());
            System.out.println("null");
	}
    }    
   
    /* Metodo usado para imprimir o resultado de uma busca em profundidade */
    public static void imprProfundidade(Grafo[] grafos, int noInicial) {
    	System.out.printf("     Grafo inicial: %d\n     Tempo de chegada: %d\n     Tempo de saida: %d\n\n",
    			noInicial,
    			grafos[noInicial].getTempoChegada(),
    			grafos[noInicial].getTempoFim());
        
        for (int i=0; i<grafos.length; i++) 
            if(grafos[i].getChave() != noInicial) 
            	System.out.printf("     Grafo %d\n     Tempo de chegada: %d\n     Tempo de saida: %d\n\n",
            			grafos[i].getChave(),
            			grafos[i].getTempoChegada(),
            			grafos[i].getTempoFim());
    }
    
    /* Metodo usado para imprimir o resultado de uma busca em largura */
    public static void imprLargura(Grafo[] grafos, int noInicial) {	
        System.out.printf("     Grafo raiz: %d\n\n", noInicial);
        for (int i=0; i<grafos.length; i++) {
            if(grafos[i].getChave() != noInicial) {
                System.out.printf("     Grafo %d\n     Distância: %d\n     Caminho: [%d] ", 
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
    
    /* Metodo usado no algoritmo de Prim */
    public static Grafo removeMinimo(boolean[] Q) {
        int min = 30001, imin = -1;
        for (int i = 0; i < Q.length; i++) {
            if (Interface.grafos[i].getDistancia() < min && Q[i] == true) {
                imin = i;
                min = Interface.grafos[i].getDistancia();
            }
        }
        Q[imin] = false;
        return Interface.grafos[imin];
    }
    
    /* Metodo usado no algoritmo de Prim */
    public static boolean vazia (boolean[] Q){
        for (int i=0; i<Q.length; i++)
            if (Q[i] == true)
                return false;
        return true;
    }

    /* Metodo usado no algoritmo de Kruskal */
    public static void bubbleSort(Aresta arestas[], int numArestas) {
        boolean troca = true;
        Aresta aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < numArestas - 1; i++) {
                if (arestas[i].getValor() > arestas[i + 1].getValor()) {
                    aux = arestas[i];
                    arestas[i] = arestas[i + 1];
                    arestas[i + 1] = aux;
                    troca = true;
                }
            }
        }
    }
    
    /* Metodo usado no algoritmo de Dijkstra */
    public static void inicializa(Grafo[] grafos, int noInicial) {
        for(int i = 0; i < grafos.length; i++) 
            grafos[i].setDistancia(30000);
        grafos[noInicial].setDistancia(0);
    }
    
    /* Metodo usado no algoritmo de Dijkstra */
    public static void relaxa(Grafo u, Grafo v, int peso) {
        int soma = u.getDistancia() + peso;
        if(v.getDistancia() > soma) {
            v.setDistancia(soma);
            v.setPredecessor(u.getChave());
        }
    }
    
    /* Metodo usado no algoritmo de Dijkstra */
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
    
    /* Metodo usado no algoritmo de Dijkstra */
    public static int buscaNoS(Queue<Grafo> S, int valor) {
        Queue<Grafo> aux = S;
        Grafo atual;
        while(!aux.isEmpty()) {
            atual = aux.poll();
            if(atual.getChave() == valor)
                return 1; /* encontrou o vértice em S */
        }
        return 0; /* não encontrou o vértice em S */
    }
    
    /* Metodo usado para imprimir o resultado do algoritmo de Dijkstra usando matriz de adjacencia */
    public static void imprCaminhoDijkstraM(Grafo grafos[], int ini) {
        for(int i = 0; i < grafos.length; i++) {
            System.out.println("");
            if(Funcionalidade.verifCaminhoDijkstraM(ini, i))
                System.out.println("\nDistância = " + grafos[i].getDistancia());
        }
    }
    
    /* Metodo usado para imprimir o resultado do algoritmo de Dijkstra usando lista de adjacancia*/
    public static void imprCaminhoDijkstraL(Grafo grafos[], int ini) {
        for(int i = 0; i < grafos.length; i++) {
            System.out.println("");
            if(Funcionalidade.verifCaminhoDijkstraL(ini, i))
                System.out.println("\nDistância = " + grafos[i].getDistancia());
        }
    }

    /* Metodo usado para imprimir o resultado do algoritmo de Bellman-Ford usando matriz de adjacencia */
    public static void imprCaminhoBellmanM(Grafo grafos[], int ini) {
        for (int i = 0; i < grafos.length; i++) {
            System.out.println("");
            if(Funcionalidade.verifCaminhoBellmanM(ini, i))
                System.out.println("\nDistância = " + grafos[i].getDistancia());
        }
    }
    
    /* Metodo usado para imprimir o resultado do algoritmo de Bellman-Ford usando lista de adjacencia */
    public static void imprCaminhoBellmanL(Grafo grafos[], int ini) {
        for (int i = 0; i < grafos.length; i++) {
            System.out.println("");
            if(Funcionalidade.verifCaminhoBellmanL(ini, i))
                System.out.println("\nDistância = " + grafos[i].getDistancia());
        }
    }
}

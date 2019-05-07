package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public abstract class Util {

    public static int[][] matriz;
    public static ArrayList<Aresta> lista[];        

    public static int criarGrafos(String caminho) throws IOException {
        BufferedReader buffRead;
            buffRead = new BufferedReader(new FileReader(caminho.concat(".txt")));
        
        int numGrafos, aux;
        aux = Integer.parseInt(buffRead.readLine());	// Lendo primeira linha, grafo ou digrafo
        numGrafos = Integer.parseInt(buffRead.readLine()); // Lendo segunda linha, numero de grafos
        Interface.grafos = new Grafo[numGrafos];
        matriz = new int[numGrafos][numGrafos];
        lista = new ArrayList[numGrafos];
        for(int i=0; i<numGrafos; i++) {
            lista[i] = new ArrayList<>();
            for(int j=0; j<numGrafos; j++)
                matriz[i][j] = 0;
        }
        String linha;
        String[] numeros;
        int n1, n2, n3;
        linha = buffRead.readLine();
        Aresta aresta;
        while(linha != null) {                  // Lendo uma aresta (uma linha do arquivo)
            numeros = linha.split(" ");
            n1 = Integer.parseInt(numeros[0]);  // Vertice 1 da aresta
            n2 = Integer.parseInt(numeros[1]);  // Vertice 2 da aresta
            n3 = Integer.parseInt(numeros[2]);  // Valor da aresta
            linha = buffRead.readLine();
             
            if(aux == 0) {                      // Grafo
                aresta = new Aresta(n1,n2,n3);
                lista[n1].add(aresta);
                aresta = new Aresta(n2,n1,n3);
                lista[n2].add(aresta);
                    
                matriz[n1][n2] = n3;
                matriz[n2][n1] = n3;
            }      
                
            else {                              // Dígrafo
                aresta = new Aresta(n1,n2,n3);
                lista[n1].add(aresta);
                   
                matriz[n1][n2] = n3;
            }
        }
        buffRead.close();
        return aux;
    }
         
    public static boolean isValid(int grafo, int restricao) {
        if (restricao != -1) { // O grafo nao pode ter a mesma chave do int "restricao"
            if (grafo < 0 || grafo > Util.matriz.length || grafo == restricao) {
                JOptionPane.showMessageDialog(null, "O grafo inserido nao eh valido!");
                return false;
            } else
                return true;
        } else { // Nao ha nenhuma restricao
            if (grafo < 0 || grafo > Util.matriz.length) {
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
	
    public static Grafo[] buscaLarguraM(int noInicial) {	// Matriz de adjacencia
        Grafo[] grafos = new Grafo[Util.matriz.length];
        Queue<Grafo> fila = new LinkedList<>();
        Grafo atual;        
        for (int i=0; i<grafos.length; i++) {
            grafos[i] = new Grafo(i);
        }
        
        grafos[noInicial].setMarcador('c');
        grafos[noInicial].setDistancia(0);
        fila.add(grafos[noInicial]);
        while (!fila.isEmpty()) {
            atual = fila.remove();          
            for(int i=0; i<Util.matriz[atual.getChave()].length; i++) {
                if(Util.matriz[atual.getChave()][i] != 0) {
                    Grafo adj = grafos[i];
                    if (adj != null) {
                        if(adj.getMarcador() == 'b') {
                            adj.setMarcador('c');
                            adj.setDistancia(grafos[atual.getChave()].getDistancia()+1);
                            adj.setPredecessor(grafos[atual.getChave()].getChave());
                            fila.add(adj);
                        }
                    }
                }
            }
            grafos[atual.getChave()].setMarcador('p');            
        }
        return grafos;
    } 
    
    public static Grafo[] buscaLarguraL(int noInicial) {	// Lista de adjacencia
        Grafo[] grafos = new Grafo[Util.lista.length];
        Queue<Grafo> fila = new LinkedList<>();
        Grafo atual;        
        for (int i=0; i<grafos.length; i++) {
            grafos[i] = new Grafo(i);
        }
        
        grafos[noInicial].setMarcador('c');
        grafos[noInicial].setDistancia(0);
        fila.add(grafos[noInicial]);
        while (!fila.isEmpty()) {
            atual = fila.poll();
            for(int i=0; i<Util.lista[atual.getChave()].size(); i++) {
                Grafo adj = grafos[Util.lista[atual.getChave()].get(i).getChave()];
                if (adj != null) {
                    if(adj.getMarcador() == 'b') {
                        adj.setMarcador('c');
                        adj.setDistancia(grafos[atual.getChave()].getDistancia()+1);
                        adj.setPredecessor(grafos[atual.getChave()].getChave());
                        fila.add(adj);
                    }
                }
            }
            grafos[atual.getChave()].setMarcador('p');            
        }
        return grafos;
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
    
    public static Grafo[] buscaProfundidadeM(int noInicial){	// Matriz de adjacencia
        Grafo[] grafos = new Grafo[Util.matriz.length];
        for(int i=0; i<grafos.length; i++)
            grafos[i] = new Grafo(i);
        int tempo = 1;
        
        for(int i=noInicial; i<grafos.length; i++){				// Iniciando pelo no inicial
            if(grafos[i].getMarcador() == 'b'){
                tempo = grafos[i].visita(grafos, tempo, Util.matriz);
            }
        }
        for(int i=0; i<noInicial; i++) {						// Percorrendo os nos anteriores ao incial
            if(grafos[i].getMarcador() == 'b'){
                tempo = grafos[i].visita(grafos, tempo, Util.matriz);
            }
        }
        //System.out.printf("Retornou a raiz\n\n\n\n");
        return grafos;
    }
	
    public static Grafo[] buscaProfundidadeL(int noInicial){	// Lista de adjacencia
        Grafo[] grafos = new Grafo[Util.lista.length];
        for(int i=0; i<grafos.length; i++)
            grafos[i] = new Grafo(i);
        int tempo = 1;

        for(int i=noInicial; i<grafos.length; i++){				// Iniciando pelo no inicial
            if(grafos[i].getMarcador() == 'b'){
                tempo = grafos[i].visita(grafos, tempo, Util.lista);
            }
        }
        for(int i=0; i<noInicial; i++) {						// Percorrendo os nos anteriores ao incial
        	if(grafos[i].getMarcador() == 'b'){
                tempo = grafos[i].visita(grafos, tempo, Util.lista);
            }
        }
        //System.out.printf("Retornou a raiz\n\n\n\n");
        return grafos;
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
	
    public static void caminhoUVProfundidadeM(int u, int v){
        Grafo grafos[];
        grafos = Util.buscaProfundidadeM(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;
        
        for(i=0;i<grafos.length;i++)
            caminho[i] = -1;
        for(i=0;atual!=u;i++){
            caminho[i] = atual;
            if(grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if(caminho[i]!=u) 
            System.out.println("Não existe caminho entre "+u+" e "+v);
        else{
            for( ;i>0;i--)
                   System.out.printf(caminho[i]+" --> ");
            System.out.printf(caminho[i]+"");
        }
        System.out.println("");
            
    }

    public static void caminhoUVProfundidadeL(int u, int v){
        Grafo grafos[];
        grafos = Util.buscaProfundidadeL(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;
        
        for(i=0;i<grafos.length;i++)
            caminho[i] = -1;
        for(i=0;atual!=u;i++){
            caminho[i] = atual;
            if(grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if(caminho[i]!=u) 
            System.out.println("Não existe caminho entre "+u+" e "+v);
        else{
            for( ;i>0;i--)
                    System.out.printf(caminho[i]+" --> ");
            System.out.printf(caminho[i]+"");
        }
    }
    
    public static void caminhoUVLarguraM(int u, int v){
        Grafo grafos[];
        grafos = Util.buscaLarguraM(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;
        
        for(i=0;i<grafos.length;i++)
            caminho[i] = -1;
        for(i=0;atual!=u;i++){
            caminho[i] = atual;
            if(grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if(caminho[i]!=u) 
            System.out.println("Não existe caminho entre "+u+" e "+v);
        else{
            for( ;i>0;i--)
                   System.out.printf(caminho[i]+" --> ");
            System.out.printf(caminho[i]+"");
        }
        System.out.println("");
            
    }
    
    public static void caminhoUVLarguraL(int u, int v){
        Grafo grafos[];
        grafos = Util.buscaLarguraL(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;
        
        for(i=0;i<grafos.length;i++)
            caminho[i] = -1;
        for(i=0;atual!=u;i++){
            caminho[i] = atual;
            if(grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if(caminho[i]!=u) 
            System.out.println("Não existe caminho entre "+u+" e "+v);
        else{
            for( ;i>0;i--)
                    System.out.printf(caminho[i]+" --> ");
            System.out.printf(caminho[i]+"");
        }
    }
    
    public static boolean verificarConexo(Grafo[] grafos){
        
        
        
        
        return true;
    }

    public static void Kruskal(){
        ArrayList<ArrayList<Integer>> floresta;
        floresta = new ArrayList<>();
        ArrayList<Aresta> arestas;
        arestas = new ArrayList<>();
        int numArestas = 0;
        for(int i=0; i<Util.matriz.length; i++){
            floresta.add(new ArrayList<>());
            floresta.get(i).add(i);
        }
        for(int i=0;i<Util.matriz.length;i++){
            for(int j=0;j<Util.matriz.length;j++){
                if(Util.matriz[i][j] != 0)
                    arestas.set(numArestas++, new Aresta(i, j, Util.matriz[i][j])); 
            }
        }
        
    }
    
}

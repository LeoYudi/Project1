package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public abstract class Funcionalidade {

    public static int[][] matriz;
    public static ArrayList<Aresta> lista[];

    public static int criarGrafos(String caminho) throws IOException {
        BufferedReader buffRead;
        buffRead = new BufferedReader(new FileReader(caminho.concat(".txt")));

        int numGrafos, aux;
        aux = Integer.parseInt(buffRead.readLine()); // Lendo primeira linha, grafo ou digrafo
        numGrafos = Integer.parseInt(buffRead.readLine()); // Lendo segunda linha, numero de grafos
        Interface.grafos = new Grafo[numGrafos];
        matriz = new int[numGrafos][numGrafos];
        lista = new ArrayList[numGrafos];
        for (int i = 0; i < numGrafos; i++) {
            Interface.grafos[i] = new Grafo(i);
            lista[i] = new ArrayList<>();
            for (int j = 0; j < numGrafos; j++)
                matriz[i][j] = 0;
        }
        String linha;
        String[] numeros;
        int n1, n2, n3;
        linha = buffRead.readLine();
        Aresta aresta;
        while (linha != null) { // Lendo uma aresta (uma linha do arquivo)
            numeros = linha.split(" ");
            n1 = Integer.parseInt(numeros[0]); // Vertice 1 da aresta
            n2 = Integer.parseInt(numeros[1]); // Vertice 2 da aresta
            n3 = Integer.parseInt(numeros[2]); // Valor da aresta
            linha = buffRead.readLine();

            if (aux == 0) { // Grafo
                aresta = new Aresta(n1, n2, n3);
                lista[n1].add(aresta);
                aresta = new Aresta(n2, n1, n3);
                lista[n2].add(aresta);

                matriz[n1][n2] = n3;
                matriz[n2][n1] = n3;
            }

            else { // Dígrafo
                aresta = new Aresta(n1, n2, n3);
                lista[n1].add(aresta);

                matriz[n1][n2] = n3;
            }
        }
        buffRead.close();
        return aux;
    }

    public static Grafo[] buscaLarguraM(int noInicial) { // Matriz de adjacencia
        Grafo[] grafos = new Grafo[matriz.length];
        Queue<Grafo> fila = new LinkedList<>();
        Grafo atual;
        for (int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo(i);
        }

        grafos[noInicial].setMarcador('c');
        grafos[noInicial].setDistancia(0);
        fila.add(grafos[noInicial]);
        while (!fila.isEmpty()) {
            atual = fila.remove();
            for (int i = 0; i < matriz[atual.getChave()].length; i++) {
                if (matriz[atual.getChave()][i] != 0) {
                    Grafo adj = grafos[i];
                    if (adj != null) {
                        if (adj.getMarcador() == 'b') {
                            adj.setMarcador('c');
                            adj.setDistancia(grafos[atual.getChave()].getDistancia() + 1);
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

    public static Grafo[] buscaLarguraL(int noInicial) { // Lista de adjacencia
        Grafo[] grafos = new Grafo[lista.length];
        Queue<Grafo> fila = new LinkedList<>();
        Grafo atual;
        for (int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo(i);
        }

        grafos[noInicial].setMarcador('c');
        grafos[noInicial].setDistancia(0);
        fila.add(grafos[noInicial]);
        while (!fila.isEmpty()) {
            atual = fila.poll();
            for (int i = 0; i < lista[atual.getChave()].size(); i++) {
                Grafo adj = grafos[lista[atual.getChave()].get(i).getChave()];
                if (adj != null) {
                    if (adj.getMarcador() == 'b') {
                        adj.setMarcador('c');
                        adj.setDistancia(grafos[atual.getChave()].getDistancia() + 1);
                        adj.setPredecessor(grafos[atual.getChave()].getChave());
                        fila.add(adj);
                    }
                }
            }
            grafos[atual.getChave()].setMarcador('p');
        }
        return grafos;
    }

    public static Grafo[] buscaProfundidadeM(int noInicial) { // Matriz de adjacencia
        Grafo[] grafos = new Grafo[matriz.length];
        for (int i = 0; i < grafos.length; i++)
            grafos[i] = new Grafo(i);
        int tempo = 1;

        for (int i = noInicial; i < grafos.length; i++) { // Iniciando pelo no inicial
            if (grafos[i].getMarcador() == 'b') {
                tempo = grafos[i].visita(grafos, tempo, matriz);
            }
        }
        for (int i = 0; i < noInicial; i++) { // Percorrendo os nos anteriores ao incial
            if (grafos[i].getMarcador() == 'b') {
                tempo = grafos[i].visita(grafos, tempo, matriz);
            }
        }
        return grafos;
    }

    public static Grafo[] buscaProfundidadeL(int noInicial) { // Lista de adjacencia
        Grafo[] grafos = new Grafo[lista.length];
        for (int i = 0; i < grafos.length; i++)
            grafos[i] = new Grafo(i);
        int tempo = 1;

        for (int i = noInicial; i < grafos.length; i++) { // Iniciando pelo no inicial
            if (grafos[i].getMarcador() == 'b') {
                tempo = grafos[i].visita(grafos, tempo, lista);
            }
        }
        for (int i = 0; i < noInicial; i++) { // Percorrendo os nos anteriores ao inicial
            if (grafos[i].getMarcador() == 'b') {
                tempo = grafos[i].visita(grafos, tempo, lista);
            }
        }
        return grafos;
    }

    public static void verifCaminhoProfundidadeM(int u, int v) {
        Grafo grafos[];
        grafos = buscaProfundidadeM(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;

        for (i = 0; i < grafos.length; i++)
            caminho[i] = -1;
        for (i = 0; atual != u; i++) {
            caminho[i] = atual;
            if (grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if (caminho[i] != u)
            System.out.println("Não existe caminho entre " + u + " e " + v);
        else {
            for (; i > 0; i--)
                System.out.printf(caminho[i] + " --> ");
            System.out.printf(caminho[i] + "");
        }
    }

    public static void verifCaminhoProfundidadeL(int u, int v) {
        Grafo grafos[];
        grafos = buscaProfundidadeL(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;

        for (i = 0; i < grafos.length; i++)
            caminho[i] = -1;
        for (i = 0; atual != u; i++) {
            caminho[i] = atual;
            if (grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if (caminho[i] != u)
            System.out.println("Não existe caminho entre " + u + " e " + v);
        else {
            for (; i > 0; i--)
                System.out.printf(caminho[i] + " --> ");
            System.out.printf(caminho[i] + "");
        }
    }

    public static void verifCaminhoLarguraM(int u, int v) {
        Grafo grafos[];
        grafos = buscaLarguraM(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;

        for (i = 0; i < grafos.length; i++)
            caminho[i] = -1;
        for (i = 0; atual != u; i++) {
            caminho[i] = atual;
            if (grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if (caminho[i] != u)
            System.out.println("Não existe caminho entre " + u + " e " + v);
        else {
            for (; i > 0; i--)
                System.out.printf(caminho[i] + " --> ");
            System.out.printf(caminho[i] + "");
        }
        System.out.println("");

    }

    public static void verifCaminhoLarguraL(int u, int v) {
        Grafo grafos[];
        grafos = buscaLarguraL(u);
        int atual = v;
        int caminho[];
        caminho = new int[grafos.length];
        int i;

        for (i = 0; i < grafos.length; i++)
            caminho[i] = -1;
        for (i = 0; atual != u; i++) {
            caminho[i] = atual;
            if (grafos[atual].getPredecessor() != -1)
                atual = grafos[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if (caminho[i] != u)
            System.out.println("Não existe caminho entre " + u + " e " + v);
        else {
            for (; i > 0; i--)
                System.out.printf(caminho[i] + " --> ");
            System.out.printf(caminho[i] + "");
        }
    }

    public static ArrayList<Integer> verificarConexo() {
        ArrayList<Integer> desconexos = new ArrayList();
        for (int i=0; i<Interface.grafos.length; i++)
            if (Interface.grafos[i].getPredecessor() == -1)     // Encontrando os grafos sem predecessores, possivelmente desconexos
                desconexos.add(Interface.grafos[i].getChave());        
        if(desconexos.size() == 1)          // Apenas a raiz nao possui predecessor
            return null;
        else return desconexos;             // Mais de um grafo nao possui predecessor, portanto esta desconexo
    }

    public static boolean verificaArvore(ArrayList<ArrayList<Integer>> floresta, int a, int b) {
        int arvoreA=0, arvoreB=0;
        for(int i=0;i<floresta.size();i++){
            for(int j=0;j<floresta.get(i).size();j++){
                if(floresta.get(i).get(j) == a){
                    arvoreA = a;
                }
                if(floresta.get(i).get(j) == b)
                    arvoreB = b;
            }
        }
        for(int i=0;i<floresta.get(arvoreA).size();i++){
            if(floresta.get(arvoreA).get(i) == b)
                return false;
        }
        for(int i=0;i<floresta.get(arvoreA).size();i++){
            floresta.get(arvoreA).add(floresta.get(arvoreB).get(i));
            floresta.get(arvoreB).remove(i);
        }
        return true;
    }

    public static void KruskalMatriz() {
        ArrayList<ArrayList<Integer>> floresta;
        floresta = new ArrayList<>();
        Aresta[] arestas;
        arestas = new Aresta[100];
        ArrayList<Aresta> sol;
        sol = new ArrayList<>();
        int numArestas = 0;
        for (int i = 0; i < matriz.length; i++) {
            floresta.add(new ArrayList<>());
            floresta.get(i).add(i);
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != 0)
                    arestas[numArestas++] = new Aresta(i, j, matriz[i][j]);
            }
        }
        Util.bubbleSort(arestas);

        for (int i = 0; i < numArestas; i++) 
            if(verificaArvore(floresta, arestas[i].getChave(), arestas[i].getChave2()))
                sol.add(arestas[i]);
        System.out.println("\n\n"+sol);
    }
}

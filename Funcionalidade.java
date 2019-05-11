package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class Funcionalidade {

    public static int[][] matriz;
    public static ArrayList<Aresta> lista[];

    /* Metodo usado para ler o arquivo texto e construir os grafos */
    public static int criarGrafos(String caminho) throws IOException {
        BufferedReader buffRead;
        buffRead = new BufferedReader(new FileReader(caminho.concat(".txt")));
        int numGrafos, aux;
        aux = Integer.parseInt(buffRead.readLine());    /* Lendo primeira linha, grafo ou digrafo */
        numGrafos = Integer.parseInt(buffRead.readLine());      /* Lendo segunda linha, numero de grafos */
        Interface.grafos = new Grafo[numGrafos];
        matriz = new int[numGrafos][numGrafos];
        lista = new ArrayList[numGrafos];
        for (int i = 0; i < numGrafos; i++) {
            Interface.grafos[i] = new Grafo(i);
            lista[i] = new ArrayList<>();
            for (int j = 0; j < numGrafos; j++)
                matriz[i][j] = -1;
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

    /* Busca em largura utilizando matriz de adjacencia */
    public static Grafo[] buscaLarguraM(int noInicial) {
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
                if (matriz[atual.getChave()][i] != -1) {
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
    
    /* Busca em largura utilizando lista de adjacencia */
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

    /* Busca em profundidade utilizando matriz de adjacencia */
    public static Grafo[] buscaProfundidadeM(int noInicial) {
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

    /* Busca em profundidade utilizando lista de adjacencia */
    public static Grafo[] buscaProfundidadeL(int noInicial) {
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

    /* Verificar caminho entre 2 vertices utilizando busca em profundidade e matriz de adjacencia */
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

    /* Verificar caminho entre 2 vertices utilizando busca em profundidade e lista de adjacencia */
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

    /* Verificar caminho entre 2 vertices utilizando busca em largura e matriz de adjacencia */
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

    /* Verificar caminho entre 2 vertices utilizando busca em largura e lista de adjacencia */
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

    /* Verificar conexidade de um grafo */
    public static ArrayList<Integer> verificarConexo() {
        ArrayList<Integer> desconexos = new ArrayList<>();
        for (int i=0; i<Interface.grafos.length; i++)
            if (Interface.grafos[i].getPredecessor() == -1)     // Encontrando os grafos sem predecessores, possivelmente desconexos
                desconexos.add(Interface.grafos[i].getChave());        
        if(desconexos.size() == 1)          // Apenas a raiz nao possui predecessor
            return null;
        else return desconexos;             // Mais de um grafo nao possui predecessor, portanto esta desconexo
    }

    /* Metodo utilizado no algoritmo de Kruskal */
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
    
    /* Algoritmo Kruskal utilizando matriz de adjacencia */
    public static void KruskalM() {
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
                if (matriz[i][j] != -1)
                    arestas[numArestas++] = new Aresta(j, i, matriz[i][j]);
            }
        }
        Util.bubbleSort(arestas, numArestas);
        for (int i = 0; i < numArestas; i++){
            if (verificaArvore(floresta, arestas[i].getChave(), arestas[i].getChave2()))
                sol.add(arestas[i]);
        }
        System.out.println("A arvore geradora minima e composta pelas arestas : ");
        for (int i = 0; i < sol.size(); i++) {
            System.out.println(sol.get(i).getChave2() + " -> " + sol.get(i).getChave());
        }
    }
    
    /* Algoritmo Kruskal utilizando lista de adjacencia */
    public static void KruskalL() {
        
    }

    /* Algoritmo Prim utilizando matriz de adjacencia */
    public static ArrayList<Aresta> PrimM(int ini) {
        ArrayList<Aresta> sol = new ArrayList<>();
        ArrayList<Grafo> Q = new ArrayList<>();
        Grafo u, v;
        for (int i = 0; i < Interface.grafos.length; i++) {
            Q.add(Interface.grafos[i]);
            Q.get(i).setChave(30000);
            Q.get(i).setPredecessor(-1);
        }
        Q.get(ini).setChave(0);
        while (!Q.isEmpty()) {
            u = Util.removeMinimo(Q);
            if (u.getChave() == ini) {
                Aresta aux = new Aresta(u.getChave(), u.getPredecessor(), matriz[u.getChave()][u.getPredecessor()]);
                sol.add(aux);
            }
            for (int i = 0; i < Interface.grafos.length; i++) {
                if (matriz[u.getChave()][i] != -1 && matriz[u.getChave()][i] < Interface.grafos[i].getChave()
                        && Interface.grafos[i].pertence(Q)) {
                    Interface.grafos[i].setChave(matriz[u.getChave()][i]);
                    Interface.grafos[i].setPredecessor(u.getChave());
                }
            }
        }
        return sol;
    }
    
    /* Algoritmo Prim utilizando lista de adjacencia */
    public static ArrayList<Aresta> PrimL(int ini) {
        ArrayList<Aresta> sol = new ArrayList<>();
        ArrayList<Grafo> Q = new ArrayList<>();
        Grafo u, v;
        for (int i = 0; i < Interface.grafos.length; i++) {
            Q.add(Interface.grafos[i]);
            Q.get(i).setChave(30000);
            Q.get(i).setPredecessor(-1);
        }
        Q.get(ini).setChave(0);
        while (!Q.isEmpty()) {
            u = Util.removeMinimo(Q);
            if (u.getChave() == ini) {
                Aresta aux = new Aresta(u.getChave(), u.getPredecessor(), matriz[u.getChave()][u.getPredecessor()]);
                sol.add(aux);
            }
            for (int i = 0; i < Interface.grafos.length; i++) {
                if (matriz[u.getChave()][i] != 0 && matriz[u.getChave()][i] < Interface.grafos[i].getChave()
                        && Interface.grafos[i].pertence(Q)) {
                    Interface.grafos[i].setChave(matriz[u.getChave()][i]);
                    Interface.grafos[i].setPredecessor(u.getChave());
                }
            }
        }
        return sol;
    }
    
    /* Metodo utilizado no algoritmo de Dijkstra */
    public static void verifCaminhoDijkstraL(int u, int v) {
        Grafo grafos[];
        grafos = dijkstraL(u);
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
    
    /* Metodo usado no algoritmo de Djikstra */
    public static void verifCaminhoDijkstraM(int u, int v) {
        Grafo grafos[];
        grafos = dijkstraM(u);
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
    
    /* Algoritmo Dijkstra utilizando matriz de adjacencia */
    public static Grafo[] dijkstraM(int noInicial) { 
        Grafo[] grafos = new Grafo[matriz.length];
        Queue<Grafo> S = new LinkedList<>();
        Queue<Grafo> Q = new LinkedList<>();
        Grafo u;
        int cont;
        for(int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo(i);
            Q.add(grafos[i]);
        }
        Util.inicializa(grafos, noInicial);
        while(!Q.isEmpty()) {
            cont = -1;
            u = Util.extraiMinimo(Q);
            Q.remove(u);
            S.add(u);
            for(int i = 0; i < matriz[u.getChave()].length; i++) {
                if (matriz[u.getChave()][i] != -1) {
                    cont++;
                    Grafo v = grafos[i];
                    if(v != null) {
                        if(Util.buscaNoS(S, i) == 0) {
                            Util.relaxa(u, v, lista[u.getChave()].get(cont).getValor());
                        }
                    }
                }
            }
        }
        return grafos;
    }
    
    /* Algoritmo Dijkstra utilizando lista de adjacencia */
    public static Grafo[] dijkstraL(int noInicial) { 
        Grafo[] grafos = new Grafo[lista.length];
        Queue<Grafo> S = new LinkedList<>();
        Queue<Grafo> Q = new LinkedList<>();
        Grafo u;
        for(int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo(i);
            Q.add(grafos[i]);
        }
        Util.inicializa(grafos, noInicial);
        while(!Q.isEmpty()) {
            u = Util.extraiMinimo(Q);
            Q.remove(u);
            S.add(u);
            for(int i = 0; i < lista[u.getChave()].size(); i++) {
                Grafo v = grafos[lista[u.getChave()].get(i).getChave()];
                if(v != null) {
                    if(Util.buscaNoS(S, v.getChave()) == 0) {
                        Util.relaxa(u, v, lista[u.getChave()].get(i).getValor());
                    }
                }
            }
        }
        return grafos;
    }
    
    /* Metodo usado no algoritmo de Bellman-Ford */
    public static void verifCaminhoBellmanL(int u, int v) {
        Grafo grafos[];
        boolean cicloNeg = true;
        grafos = bellmanFordL(u, cicloNeg);
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
    
    /* Metodo usado no algoritmo de Bellman-Ford */
    public static void verifCaminhoBellmanM(int u, int v) {
        Grafo grafos[];
        boolean cicloNeg = true;
        grafos = bellmanFordM(u, cicloNeg);
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
    
    /* Algoritmo de Bellman-Ford utilizando matriz de adjacencia */
    public static Grafo[] bellmanFordM(int noInicial, boolean cicloNeg) {
        Grafo[] grafos = new Grafo[matriz.length];
        for(int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo(i);
        }
        int cont;
        Util.inicializa(grafos, noInicial);
        for(int i = 1; i <= Interface.grafos.length-1; i++) {
            for(int j = 0; j < matriz.length; j++) {        /*  para cada  */
                cont = -1;                                  /* aresta(u,v) */
                for(int k = 0; k < matriz[j].length; k++) { /*  do grafo   */
                    if(matriz[j][k] != -1) {
                        cont++;
                        Grafo v = grafos[k];
                        if(v != null) {
                            Util.relaxa(grafos[j], v, lista[j].get(cont).getValor());
                        }
                    }
                }
            }
        }
        for(int j = 0; j < matriz.length; j++) {        /*  para cada  */
            cont = -1;                                  /* aresta(u,v) */
            for(int k = 0; k < matriz[j].length; k++) { /*  do grafo   */
                if(matriz[j][k] != -1) {
                    cont++;
                    Grafo v = grafos[k];
                    if(v != null) {
                        if(v.getDistancia() > grafos[j].getDistancia() + lista[j].get(cont).getValor()) {
                            cicloNeg = false;
                        }
                    }
                }
            }
        }
        return grafos;
    }
    
    /* Algoritmo de Bellman-Ford utilizando lista de adjacencia */
    public static Grafo[] bellmanFordL(int noInicial, boolean cicloNeg) {
        Grafo[] grafos = new Grafo[lista.length];
        for(int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo(i);
        }
        Util.inicializa(grafos, noInicial);
        for(int i = 1; i <= Interface.grafos.length-1; i++) {
            for(int j = 0; j < lista.length; j++) {        /* para cada aresta */
                for(int k = 0; k < lista[j].size(); k++) { /*  (u,v) do grafo  */
                    Util.relaxa(grafos[j], grafos[lista[j].get(k).getChave()], lista[j].get(k).getValor());
                }
            }
        }
        for(int j = 0; j < lista.length; j++) {            /* para cada aresta */
            for(int k = 0; k < lista[j].size(); k++) {     /*  (u,v) do grafo  */
                if(grafos[lista[j].get(k).getChave()].getDistancia() > grafos[j].getDistancia() + lista[j].get(k).getValor()) {
                    cicloNeg = false;
                }
            }
        }
        return grafos;
    }
}

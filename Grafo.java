package main;

import java.util.ArrayList;

public class Grafo {
    
    private char marcador;
    private int chave;
    private int predecessor;
    private int distancia;
    private int tempoChegada;
    private int tempoFim;	
	
    public int getMarcador(){
        return marcador;
    }
	
    public void setMarcador(char marcador) {
        this.marcador = marcador;
    }
    
    public int getChave() {
        return chave;
    }
	
    public void setChave(int chave) {
        this.chave = chave;
    }
    
    public int getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(int predecessor) {
        this.predecessor = predecessor;
    }
		
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getTempoFim() {
        return tempoFim;
    }

    public void setTempoFim(int tempoFim) {
        this.tempoFim = tempoFim;
    }

    public Grafo(int chave) {
        this.marcador = 'b';
        this.distancia = -1;
        this.predecessor = -1;
        this.tempoChegada = 0;
        this.tempoFim = 0;
        this.chave = chave;
    }
	
    /* Metodo pertencente a busca de profundidade com lista de adjacencia */
    public int visitaL(Grafo grafos[], int tempo){
        this.setMarcador('c');
        this.setTempoChegada(tempo++);
        int prox = -1;
        for(int i=0;i<Funcionalidade.lista[this.getChave()].size();i++){
            prox = Funcionalidade.lista[this.getChave()].get(i).getChave2();
            if(grafos[prox].getMarcador() == 'b'){
                grafos[prox].setPredecessor(this.chave);
                tempo = grafos[prox].visitaL(grafos, tempo);
            }
        }
        this.setMarcador('p');
        this.setTempoFim(tempo++);
        return tempo;
    }
    
    /* Metodo pertencente a busca de profundidade com matriz de adjacencia */
    public int visitaM(Grafo grafos[], int tempo){
        this.setMarcador('c');
        this.setTempoChegada(tempo++);
        for(int i=0;i<Funcionalidade.matriz.length;i++){
            if(Funcionalidade.matriz[this.getChave()][i] != -1){
                if(grafos[i].getMarcador() == 'b'){
                    grafos[i].setPredecessor(this.chave);
                    tempo = grafos[i].visitaM(grafos, tempo);
                }
            }
        }
        this.setMarcador('p');
        this.setTempoFim(tempo++);
        return tempo;
    }
}

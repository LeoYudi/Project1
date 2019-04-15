package main;

import java.util.ArrayList;

public class Grafo {
	private char marcador;
	private int chave;
	private int predecessor;
	private int distancia;
        private int tempoChegada;
	private int tempoFim;	
	
	public int getChave() {
            return chave;
	}
	
	public void setChave(int chave) {
            this.chave = chave;
	}
		
	public int getDistancia() {
            return distancia;
	}

	public void setDistancia(int distancia) {
            this.distancia = distancia;
	}

	public int getPredecessor() {
            return predecessor;
	}

	public void setPredecessor(int predecessor) {
            this.predecessor = predecessor;
	}

	public int getMarcador(){
            return marcador;
	}
	
	public void setMarcador(char marcador) {
            this.marcador = marcador;
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
	
    public int visita(Grafo grafos[], int tempo, ArrayList<Aresta> arestas[]){
        this.setMarcador('c');
        this.setTempoChegada(tempo++);
        //System.out.println("Cheguei no vertice "+this.chave+" no tempo "+this.tempoChegada);
        int atual = -1;
        for(int i=0;i<arestas[this.getChave()].size();i++){
            grafos[arestas[this.getChave()].get(i).getChave()].setPredecessor(atual);
            atual = arestas[this.getChave()].get(i).getChave();
            if(grafos[atual].getMarcador() == 'b'){
                tempo = grafos[atual].visita(grafos, tempo, arestas);
            }
        }
        this.setMarcador('p');
        this.setTempoFim(tempo++);
        //System.out.println("Saida do vertice "+this.chave+" no tempo "+this.tempoFim);
        return tempo;
    }
    
    public int visita(Grafo grafos[], int tempo, int arestas[][]){
        this.setMarcador('c');
        this.setTempoChegada(tempo++);
        //System.out.println("Cheguei no vertice "+this.chave+" no tempo "+this.tempoChegada);

        for(int i=0;i<arestas.length;i++){
            if(arestas[this.getChave()][i] != 0){
                if(grafos[i].getMarcador() == 'b'){
                    if(tempo == 1)
                        this.setPredecessor(-1);
                    else{
                        for(int j=0;j<grafos.length;j++){
                            if(grafos[j].getTempoChegada() == tempo-1){
                                grafos[i].setPredecessor(grafos[j].getChave());
                                break;
                            }
                        }
                    }
                    tempo = grafos[i].visita(grafos, tempo, arestas);
                }
            }
        }
        this.setMarcador('p');
        this.setTempoFim(tempo++);
        //System.out.println("Saida do vertice "+this.chave+" no tempo "+this.tempoFim);
        return tempo;
    }

	
}

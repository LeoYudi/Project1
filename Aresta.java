package main;

public class Aresta {
    
    private int chave;      // Chave do primeiro vertice da aresta
    private int chave2;     // Chave do segundo vertice da aresta
    private int valor;      // Valor ponderado da aresta
    
    public Aresta(int chave, int chave2, int valor) {
        this.chave = chave;
        this.chave2 = chave2;
        this.valor = valor;
    }
    
    public int getChave() {
        return chave;
    }
    
    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getChave2() {
        return chave2;
    }

    public void setChave2(int chave2) {
        this.chave2 = chave2;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

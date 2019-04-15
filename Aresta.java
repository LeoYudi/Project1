package main;

public class Aresta {
    private int chave;
    private int valor;

    public Aresta(int chave, int valor) {
        this.chave = chave;
        this.valor = valor;
    }
    
    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

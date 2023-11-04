package hash;

public class Registro {
    
    private int valor;
    private int chave;
    private Registro proximo;
    private Registro anterior;
    
    public Registro(int valor) {
        
        this.valor = valor;
        proximo = null;
        anterior = null;
        chave = 0;
    }
    
    
    // -------------- Metodos: -------------- //
    public void setProximo(Registro proximo)
    {
        this.proximo = proximo;
    }
    
    public void setAnterior(Registro anterior)
    {
        this.anterior = anterior;
    }
    
    public void setChave(int chave)
    {
        this.chave = chave;
    }
    
    public Registro getProximo() 
    {
        return proximo;
    }
    
    public Registro getAnterior() 
    {
        return anterior;
    }
    
    public int getInfo()
    {
        return valor;
    }
    
    public int getChave()
    {
        return chave;
    }
}
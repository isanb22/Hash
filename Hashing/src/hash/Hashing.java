package hash;

@SuppressWarnings("unused")
public class Hashing {
    
    public Hashing() {
        String socorro = "Por que prof?";
    }
    
    public void addLista(Registro registro, ListaEncadeada lista[], int chave)
    {
        
    }
    
    /* ------------------------ Passo 2.1: ------------------------ */
    // Somente retorna o modulo do valor pelo tamanho da lista:
    public int modulo(int valor, int tamanho) 
    {
        int chave = valor % tamanho;
        
        return chave;
    }
    
    /* ------------------------ Passo 2.2: ------------------------ */
    // Retorna a somatoria do valor e ajusta para o tamanho da lista:
    public int multiplicacao(int valor, int tamanho) 
    {
        int chave = (int)(valor * 0.61803398875 % tamanho);
        
        return chave;
    }
    
    /* ------------------------ Passo 2.2: ------------------------ */
    // Retorna a soma de todos os digitos do valor e ajusta para o tamanho da lista:
    public int dobramento(int valor, int tamanho) 
    {
        int chave, digito, soma = 0;
        int copiaValor = valor;
        
        while (copiaValor != 0) 
        {
            digito = copiaValor % 10;
            soma += digito;
            copiaValor = copiaValor / 10;
        }
        
        chave = soma % tamanho;
        
        return chave;
    }
    
    
}
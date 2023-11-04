package hash;

public class ListaEncadeada {
    
    private Registro Lista;
    private Registro Final;
    private int colisoes;
    
    public ListaEncadeada() 
    {
        Lista = null;
    }
    
    // Adicionar um novo Node:
    public void novoRegistro(Registro registro) 
    {        
        // Checa se a lista ainda esta vazia
        if (Lista == null) 
        {
            Lista = registro;
        }
        
        /* Sempre pega o proximo node caso ele exista, ate chegar
        no node com o endereco do proximo sendo vazio. */
        else 
        {
            Registro atual = Lista;
            
            while(atual.getProximo() != null) 
            {
                atual = atual.getProximo();
            }

            atual.setProximo(registro);
            registro.setAnterior(atual);
        }

        Final = registro;
    }
    
    // Buscar um registro:
    public void buscar(int valor)
    {
        Registro atual = Lista;
        
        while (true) 
        {
            if (atual.getProximo() == null)
            {
                System.out.println("Não encontrou");
                break;
            }
            if (atual.getInfo() == valor)
            {
                System.out.println("Encontrou! Registro " + atual);
                break;
            }
            
            atual = atual.getProximo();
        }
    }
    
    public void bateu()
    {
        this.colisoes++;
    }
    
    public int getColisoes()
    {
        return colisoes;
    }
    
    
    public Registro getRegistroFinal()
    {
        return Final;
    }
}
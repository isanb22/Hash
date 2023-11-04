package hash;

import java.util.Random;

public class mainHashing 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{		
		// Passo 1, tamanhos de vetores:
		int sizeVetores[] = {10, 100, 1000, 10000, 100000};
		
		// Passo 2, os Hashing:
		Hashing hash = new Hashing();
		
		// Passo 3, os dados:   
		// Quantidade de elementos:   20mil, 100mil, 500mil, 1milhão, 5milhões
		//int sizeElementos[]     =    {20000, 100000, 500000, 1000000, 5000000}; 
		int sizeElementos[]     =    {10, 100, 1000, 10000, 100000, 200000}; 
		
		Registro exemplo = new Registro(numAleatorio());
		Random random = new Random();
		
		// Passo 4, inserção:
		int chave = 0;
		int valor = 0;
		int busca;
		
		long tempoTotalInicio;
		long tempoTotalFim;
		long tempoTotalTotal;
		
		long tempoInicio;
		long tempoFim;
		long tempoTotal = 0;
		
		// For para cada tamanho de vetor hash (sizeVetores[i]):
		tempoTotalInicio = System.currentTimeMillis();
		for (int i = 0; i < tamanho(sizeVetores); i++) 
		{
			System.out.println("==============================================");
			System.out.println("=== Para array de " + sizeVetores[i] + " de tamanho === \n");
			
			// For para quantidade de possibilidade de registros (sizeElementos[i]):
			for (int j = 0; j < tamanho(sizeElementos); j++) 
			{
				System.out.println(" ==> Com " + sizeElementos[j] + " registros: ");
				
				tempoTotal = 0;
				
				ListaEncadeada arrayHash1[] = new ListaEncadeada[sizeVetores[i]];
				ListaEncadeada arrayHash2[] = new ListaEncadeada[sizeVetores[i]];
				ListaEncadeada arrayHash3[] = new ListaEncadeada[sizeVetores[i]];
				
				// ------------- Para a tabela 1 (hash de modulo): ------------- //
				// Inserção:
				tempoInicio = System.currentTimeMillis();
				for (int t1 = 0; t1 < sizeElementos[j]; t1++) 
				{
					chave = 0;
					valor = numAleatorio();
					
					Registro registro1 = new Registro(valor);
					chave = hash.modulo(valor, sizeVetores[i]);
					
					arrayHash1[chave] = addLista(arrayHash1[chave], registro1);
					
				}
				tempoFim = System.currentTimeMillis();
				tempoTotal = tempoFim - tempoInicio;
				
				relatorio("Hash de modulos", tempoTotal, totalColisoes(arrayHash1, sizeVetores[i]));
				
				// Passo 4 para busca:
				for (int tb1 = 0; tb1 < 5; tb1++)
				{
					busca = 100000000 + random.nextInt(899999999);
					System.out.print("Número " + busca + ": ");
					tempoInicio = System.currentTimeMillis();
					
					chave = hash.modulo(busca, sizeVetores[i]);
					buscar(arrayHash1, chave, busca);

					tempoFim = System.currentTimeMillis();
					tempoTotal = tempoFim - tempoInicio;
					
					System.out.println("Tempo decorrido de busca: " + tempoTotal + " milissegundos \n");
				}
				
				
				
				
				// ------------- Para a tabela 2 (hash de somatoria): ------------- //
				tempoInicio = System.currentTimeMillis();
				for (int t2 = 0; t2 < sizeElementos[j]; t2++) 
				{
					chave = 0;
					valor = numAleatorio();
					
					Registro registro2 = new Registro(valor);
					chave = hash.multiplicacao(valor, sizeVetores[i]);
					
					arrayHash2[chave] = addLista(arrayHash2[chave], registro2);
				
				}
				tempoFim = System.currentTimeMillis();
				tempoTotal = tempoFim - tempoInicio;
				
				relatorio("Hash de multiplicacao", tempoTotal, totalColisoes(arrayHash2, sizeVetores[i]));
				
				// Passo 4 para busca:
				for (int tb2 = 0; tb2 < 5; tb2++)
				{
					busca = 100000000 + random.nextInt(899999999);
					System.out.print("Número " + busca + ": ");
					tempoInicio = System.currentTimeMillis();
					
					chave = hash.modulo(busca, sizeVetores[i]);
					buscar(arrayHash2, chave, busca);

					tempoFim = System.currentTimeMillis();
					tempoTotal = tempoFim - tempoInicio;
					
					System.out.println("Tempo decorrido de busca: " + tempoTotal + " milissegundos \n");
				}
				
				
				// ------------- Para a tabela 3 (hash de dobramento): ------------- //
				tempoInicio = System.currentTimeMillis();
				for (int t3 = 0; t3 < sizeElementos[j]; t3++) 
				{
					chave = 0;
					valor = numAleatorio();
					
					Registro registro3 = new Registro(valor);
					chave = hash.dobramento(valor, sizeVetores[i]);
					
					arrayHash3[chave] = addLista(arrayHash3[chave], registro3);
					
				}
				tempoFim = System.currentTimeMillis();
				tempoTotal = tempoFim - tempoInicio;
								
				relatorio("Hash de dobramento", tempoTotal, totalColisoes(arrayHash3, sizeVetores[i]));
				
				// Passo 4 para busca:
				for (int tb3 = 0; tb3 < 5; tb3++)
				{
					busca = 100000000 + random.nextInt(899999999);
					System.out.print("Número " + busca + ": ");
					tempoInicio = System.currentTimeMillis();
					
					chave = hash.modulo(busca, sizeVetores[i]);
					buscar(arrayHash3, chave, busca);

					tempoFim = System.currentTimeMillis();
					tempoTotal = tempoFim - tempoInicio;
					
					System.out.println("Tempo decorrido de busca: " + tempoTotal + " milissegundos \n");
				}

				System.out.println();
				
			}
			
			
			
		}
		tempoTotalFim = System.currentTimeMillis();
		tempoTotalTotal = tempoTotalFim - tempoTotalInicio;
		
		System.out.println("################### FIM ###################");
		System.out.println("Tempo total: " + tempoTotalTotal + " milissegundos");
		System.out.println("Ou " + tempoTotalTotal / 1000 + " segundos");
	}
	
	// Passo 3.1, gerando o numero de 9 digitos:
	public static int numAleatorio() 
	{
		Random random = new Random();
		
		int num = 100000000;
		num += random.nextInt(899999999);
		
		//System.out.print("Numero gerado: " + num);
		
		return num;
	}
	
	// Passo 4.1 para inserção:
	public static ListaEncadeada addLista(ListaEncadeada lista, Registro registro)
	{
		if (lista == null)
		{
			lista = new ListaEncadeada();
		}
		else
		{
			lista.bateu();
		}
		
		lista.novoRegistro(registro);
		
		return lista;
	}
	
	// Passo 5.1 para busca:
	public static void buscar(ListaEncadeada lista[], int chave, int valor)
	{
		ListaEncadeada listaCorreta = lista[chave];
		
		if (listaCorreta == null)
		{
			System.out.println("Não encontrou");
			return;
		}
		
		listaCorreta.buscar(valor);
	}
	
	/* ---------- Funções extras: ---------- */
	// Tamanho das listas inteiras:
	public static int tamanho(int lista[]) {
		int tam = 0;
		for(@SuppressWarnings("unused") int i: lista) {
			tam++;
		}
		return tam;
	}
	
	// Total de colisões de cada array:
	public static int totalColisoes(ListaEncadeada matriz[], int tam)
	{
		int total = 0;
		
		for (int i = 0; i < tam; i++)
		{
			if (matriz[i] != null)
			{
				total += matriz[i].getColisoes();
			}
		}
		
		return total;
	}
	
	// Menus bonitos para printar:
	public static void relatorio(String hash, long tempo, int colisoes)
	{
		System.out.println("--------------------------------------------");
		System.out.println(" - Média com matriz " + hash + ": ");
		System.out.println("Colisões: " + colisoes + " batidas");
		System.out.println("Tempo: " + tempo + " milissegundos");
		System.out.println();
	}

}

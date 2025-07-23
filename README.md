# Projeto de Estudos: Estruturas de Dados e Algoritmos em Java

Este repositório documenta uma jornada de aprendizado em Estruturas de Dados e Algoritmos com Java, servindo como um guia pessoal e um portfólio técnico sobre fundamentos da ciência da computação.

## 🚀 O que você vai encontrar aqui

O projeto está organizado em seis trilhas de conhecimento, progredindo do básico ao avançado:

### TRILHA 1 – Fundamentos & Configuração
- Anatomia de projetos Java modernos
- Estruturas de classes e uso de Generics

### TRILHA 2 – Análise de Algoritmos & Big-O
- Medição e análise de complexidade (tempo e espaço)
- Notações Big-O explicadas com exemplos práticos

### TRILHA 3 – Estruturas Lineares
- Arrays, LinkedList, Queue e Stack implementados do zero
- Uso prático das coleções do Java

### TRILHA 4 – Estruturas Não Lineares
- Árvores Binárias de Busca
- Heaps (MinHeap/MaxHeap)
- Tabelas Hash

### TRILHA 5 – Teoria dos Grafos
- Representações computacionais de grafos
- Algoritmos de caminho mínimo

### TRILHA 6 – Algoritmos Clássicos
- Algoritmos de ordenação e busca
- Problemas computacionais clássicos

## 📁 Estrutura do Projeto

```
/
├── src/
│   └── main/
│       └── java/
│           ├── trilha1_fundamentos/
│           ├── trilha2_bigo/
│           ├── trilha3_estruturas_lineares/
│           ├── trilha4_estruturas_nao_lineares/
│           ├── trilha5_grafos/
│           └── trilha6_algoritmos/
└── README.md
```

## 🛠️ Como Utilizar este Repositório

1. **Clone o projeto:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Abra em sua IDE preferida:**
   Importe o projeto em uma IDE como IntelliJ IDEA ou Eclipse.

3. **Execute os exemplos:**
   Cada classe possui um método `main()` para demonstração do conceito.

## 📚 Guia de Estudo Detalhado

### Trilha 1: Fundamentos Java
Revisamos conceitos essenciais para construir uma base sólida:

```java
// Exemplo de uso de Generics
public class Par<K, V> {
    private K chave;
    private V valor;
    
    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }
    
    public K getChave() { return chave; }
    public V getValor() { return valor; }
}
```

### Trilha 2: Análise de Algoritmos
Entenda como a eficiência dos algoritmos é medida:

```java
// Exemplo de algoritmo O(1) - tempo constante
public boolean isPrimeiroElementoPar(int[] array) {
    if (array.length > 0)
        return array[0] % 2 == 0;
    return false;
}

// Exemplo de algoritmo O(n) - tempo linear
public int somaElementos(int[] array) {
    int soma = 0;
    for (int elemento : array) {
        soma += elemento;
    }
    return soma;
}

// Exemplo de algoritmo O(n²) - tempo quadrático
public void imprimeParesDeElementos(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```

### Trilha 3: Estruturas Lineares
Implementações práticas das estruturas fundamentais:

```java
// Implementação simplificada de uma LinkedList
public class ListaLigada<T> {
    private No<T> inicio;
    private int tamanho;
    
    private static class No<T> {
        T valor;
        No<T> proximo;
        
        No(T valor) {
            this.valor = valor;
        }
    }
    
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }
    
    public int tamanho() {
        return tamanho;
    }
}
```

### Trilha 4: Estruturas Não Lineares
Explorando árvores e tabelas hash:

```java
// Implementação básica de uma Árvore Binária de Busca
public class ArvoreBinariaBusca<T extends Comparable<T>> {
    private No<T> raiz;
    
    private static class No<T> {
        T valor;
        No<T> esquerda;
        No<T> direita;
        
        No(T valor) {
            this.valor = valor;
        }
    }
    
    public void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
    }
    
    private No<T> inserirRecursivo(No<T> no, T valor) {
        if (no == null) {
            return new No<>(valor);
        }
        
        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserirRecursivo(no.direita, valor);
        }
        
        return no;
    }
    
    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(No<T> no, T valor) {
        if (no == null) {
            return false;
        }
        
        if (valor.equals(no.valor)) {
            return true;
        }
        
        return valor.compareTo(no.valor) < 0
                ? buscarRecursivo(no.esquerda, valor)
                : buscarRecursivo(no.direita, valor);
    }
}
```

### Trilha 5: Teoria dos Grafos
Representações e algoritmos fundamentais:

```java
// Representação de Grafo usando Lista de Adjacência
public class Grafo {
    private int vertices;
    private List<Integer>[] listaAdj;
    
    @SuppressWarnings("unchecked")
    public Grafo(int vertices) {
        this.vertices = vertices;
        listaAdj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            listaAdj[i] = new ArrayList<>();
        }
    }
    
    public void adicionarAresta(int origem, int destino) {
        listaAdj[origem].add(destino);
        // Para grafo não direcionado: listaAdj[destino].add(origem);
    }
    
    public void imprimirGrafo() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vértice " + i + " está conectado a: ");
            for (Integer vizinho : listaAdj[i]) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }
}
```

### Trilha 6: Algoritmos Clássicos
Implementações de algoritmos fundamentais:

```java
// Implementação do QuickSort
public class Ordenacao {
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    
    private void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particionar(array, inicio, fim);
            quickSort(array, inicio, posicaoPivo - 1);
            quickSort(array, posicaoPivo + 1, fim);
        }
    }
    
    private int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = inicio - 1;
        
        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
                i++;
                trocar(array, i, j);
            }
        }
        
        trocar(array, i + 1, fim);
        return i + 1;
    }
    
    private void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
```

## 📖 Dicas de Estudo

1. **Aprenda fazendo**: Execute e modifique os exemplos para entender cada conceito.
2. **Pratique diariamente**: A compreensão das estruturas de dados exige prática constante.
3. **Visualize os algoritmos**: Desenhe o funcionamento dos algoritmos para melhor compreensão.
4. **Resolva problemas**: Aplique as estruturas aprendidas em problemas reais ou plataformas de desafios como LeetCode.

## 🤝 Contribuindo

Sinta-se à vontade para contribuir com este projeto, seja adicionando novos exemplos, melhorando explicações ou corrigindo erros. Abra uma issue ou envie um pull request!


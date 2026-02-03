# 🌳 TRILHA 4: Estruturas de Dados Não-Lineares
## Guia Didático Completo - Árvores, Heaps e Hash Tables

---

## 📑 ÍNDICE

1. [Visão Geral e Objetivos](#visão-geral)
2. [Teoria Fundamental](#teoria)
3. [Nível Iniciante - Exercícios](#nivel-iniciante)
4. [Nível Intermediário - Exercícios](#nivel-intermediario)
5. [Nível Avançado - Exercícios](#nivel-avancado)
6. [Projetos Integradores](#projetos)
7. [Recursos de Estudo](#recursos)
8. [Checklist de Avaliação](#checklist)

---

## 🎯 VISÃO GERAL E OBJETIVOS {#visão-geral}

### Por que estruturas não-lineares são revolucionárias?

**Estruturas lineares**: Sequências (A→B→C→D)  
**Estruturas não-lineares**: Hierarquias e relações complexas

**Impacto Real**:
- 🗂️ **Sistemas de Arquivos**: Diretórios = árvore
- 🔍 **Bancos de Dados**: Índices B-Tree = busca O(log n)
- 🌐 **DNS**: Hierarquia de domínios = árvore
- 📊 **Compressão**: Huffman coding = árvore binária
- 🎮 **IA em Jogos**: Árvore de decisões (minimax)
- 💾 **Hash Tables**: Dicionários, caches = O(1) em média

### O que você dominará

| Estrutura | Complexidade | Força | Quando Usar |
|-----------|--------------|-------|-------------|
| **Árvore Binária** | Varies | Organização hierárquica | Expressões, parsing |
| **BST** | O(log n) avg | Busca, ordem mantida | Dicionários ordenados |
| **AVL** | O(log n) always | Balanceamento garantido | Apps críticas |
| **Red-Black** | O(log n) always | Inserção mais rápida | Java TreeMap |
| **Heap** | O(log n) insert/delete, O(1) min | Priority queue | Scheduling, Dijkstra |
| **Hash Table** | O(1) average | Acesso instantâneo | Caches, dicionários |

### Cronograma Sugerido

**Tempo Total**: 80-100 horas (7-9 semanas)

- **Semana 1-2** (Iniciante): Árvores binárias, BST básica - 20h
- **Semana 3-4** (Intermediário): Percursos, rotações, Heap - 25h
- **Semana 5-6** (Avançado): AVL, Red-Black, Hash avançado - 30h
- **Semana 7-9** (Projetos): Banco de dados, indexação - 25h

---

## 📖 TEORIA FUNDAMENTAL {#teoria}

### 1. ÁRVORES BINÁRIAS - FUNDAMENTOS

#### Conceito Central

**Árvore Binária** = Estrutura hierárquica onde cada nó tem até 2 filhos

**Analogia**: Árvore genealógica
- **Raiz**: Ancestral comum
- **Folhas**: Descendentes sem filhos
- **Altura**: Gerações da raiz até folha mais distante
- **Profundidade**: Gerações da raiz até nó específico

#### Terminologia Essencial

```
              A (raiz)           Nível 0
             / \
            B   C                Nível 1
           / \   \
          D   E   F              Nível 2
         /
        G                        Nível 3

Altura da árvore: 3
Profundidade de E: 2
Grau de B: 2 (2 filhos)
Folhas: G, E, F
Nós internos: A, B, C, D
```

#### Tipos de Árvores Binárias

1. **Completa (Complete)**
    - Todos níveis cheios exceto último
    - Último nível preenchido da esquerda
    - Usada em heaps

2. **Cheia (Full)**
    - Todo nó tem 0 ou 2 filhos
    - Nunca 1 filho só

3. **Perfeita (Perfect)**
    - Todos níveis completamente cheios
    - Todas folhas na mesma profundidade
    - 2^h - 1 nós (h = altura)

4. **Degenerada**
    - Cada nó tem no máximo 1 filho
    - Vira lista ligada
    - Pior caso O(n)

#### Propriedades Matemáticas

- **Nós em árvore perfeita de altura h**: 2^(h+1) - 1
- **Folhas em árvore perfeita**: 2^h
- **Altura de árvore com n nós**: log₂(n) (melhor) a n (pior)
- **Máximo de nós no nível i**: 2^i

---

### 2. BINARY SEARCH TREE (BST)

#### Conceito Central

**BST** = Árvore binária com propriedade de ordenação:
- Subárvore esquerda: valores < raiz
- Subárvore direita: valores > raiz
- Propriedade vale recursivamente

**Analogia**: Biblioteca organizada por assunto
- Livros de ciência à esquerda
- Livros de história à direita
- Dentro de ciência, subdivide igual

#### Propriedade BST

```
        50
       /  \
     30    70
    / \   / \
  20  40 60  80

Para qualquer nó X:
- Tudo à esquerda < X
- Tudo à direita > X
```

#### Operações Principais

1. **Busca (Search)**
    - Começa na raiz
    - valor < raiz? vai esquerda : vai direita
    - Repete até achar ou chegar em null
    - **Complexidade**: O(h) onde h = altura

2. **Inserção (Insert)**
    - Busca posição correta (como search)
    - Insere como nova folha
    - **Complexidade**: O(h)

3. **Remoção (Delete)** - 3 casos:
    - **Folha**: Simplesmente remove
    - **1 filho**: Substitui por filho
    - **2 filhos**: Substitui por sucessor in-order
    - **Complexidade**: O(h)

#### Sucessor In-order

**Sucessor** = Próximo elemento maior na ordenação

Para nó com 2 filhos:
1. Vai para filho direito
2. Vai sempre à esquerda até não poder
3. Esse é o sucessor (menor da direita)

```
        50
       /  \
     30    70
          / \
        60   80
       /
      55

Remover 50:
Sucessor = 55 (menor da direita)
```

#### Percursos (Traversals)

1. **In-Order (Esq → Raiz → Dir)**
    - Visita em ordem crescente
    - Usado para BST ordenada
    - Recursão: inOrder(esq), visita(raiz), inOrder(dir)

2. **Pre-Order (Raiz → Esq → Dir)**
    - Raiz antes dos filhos
    - Usado para copiar árvore
    - Recursão: visita(raiz), preOrder(esq), preOrder(dir)

3. **Post-Order (Esq → Dir → Raiz)**
    - Raiz depois dos filhos
    - Usado para deletar árvore
    - Recursão: postOrder(esq), postOrder(dir), visita(raiz)

4. **Level-Order (Por níveis)**
    - Nível 0, depois nível 1, etc
    - Usa fila (BFS)
    - Não-recursivo geralmente

#### Complexidade BST

| Operação | Melhor | Médio | Pior |
|----------|--------|-------|------|
| **Search** | O(log n) | O(log n) | O(n) |
| **Insert** | O(log n) | O(log n) | O(n) |
| **Delete** | O(log n) | O(log n) | O(n) |

**Pior caso**: Árvore degenerada (inserção em ordem crescente/decrescente)

---

### 3. ÁRVORES BALANCEADAS - AVL

#### Por que Balanceamento?

**Problema**: BST pode degenerar em lista (O(n))
**Solução**: Garantir altura sempre O(log n)

**AVL Tree** = BST auto-balanceada

#### Fator de Balanceamento

**Balance Factor (BF)** = altura(subárvore esq) - altura(subárvore dir)

**Propriedade AVL**: Para todo nó, |BF| ≤ 1

```
       5 (BF=0)          Balanceada
      / \
     3   7 (BF=1)        BF de 7 = 0-1 = -1 ✅
      \
       4

       5 (BF=2)          Desbalanceada!
      /
     3 (BF=1)            BF de 5 = 2-0 = 2 ❌
    /
   2
```

#### Rotações AVL

4 casos de desbalanceamento:

1. **Left-Left (LL)**: Rotação Simples à Direita
```
      z (BF=2)              y
     /                     / \
    y        →            x   z
   /
  x
```

2. **Right-Right (RR)**: Rotação Simples à Esquerda
```
  z (BF=-2)                y
   \                      / \
    y        →           z   x
     \
      x
```

3. **Left-Right (LR)**: Rotação Dupla (Esq + Dir)
```
    z (BF=2)              z              x
   /                     /              / \
  y         →           x      →       y   z
   \                   /
    x                 y
```

4. **Right-Left (RL)**: Rotação Dupla (Dir + Esq)
```
  z (BF=-2)            z                x
   \                    \              / \
    y        →           x      →     z   y
   /                      \
  x                        y
```

#### Garantias AVL

- **Altura**: Sempre O(log n)
- **Busca**: Sempre O(log n)
- **Inserção/Remoção**: O(log n) + rotações
- **Máximo rotações por inserção**: 2
- **Máximo rotações por remoção**: O(log n)

---

### 4. RED-BLACK TREES

#### Conceito

**Red-Black Tree** = BST balanceada com cores

**Propriedades**:
1. Todo nó é vermelho ou preto
2. Raiz é sempre preta
3. Folhas (NIL) são pretas
4. Nó vermelho → filhos pretos (não pode ter 2 vermelhos seguidos)
5. Todos caminhos raiz→folha têm mesmo número de nós pretos

#### AVL vs Red-Black

| Aspecto | AVL | Red-Black |
|---------|-----|-----------|
| **Balanceamento** | Mais rígido | Mais relaxado |
| **Altura** | Menor | Maior (mas ainda O(log n)) |
| **Busca** | Mais rápida | Levemente mais lenta |
| **Inserção/Remoção** | Mais lenta | Mais rápida |
| **Rotações** | Mais rotações | Menos rotações |
| **Uso** | Leituras intensas | Escr/Leitura balanceadas |

**Java TreeMap/TreeSet**: Usam Red-Black Tree

#### Garantias

- **Altura máxima**: 2 × log₂(n+1)
- **Operações**: O(log n) garantido
- **Inserção**: Máximo 2 rotações + recolorações

---

### 5. HEAPS - FILAS DE PRIORIDADE

#### Conceito Central

**Heap** = Árvore binária completa com propriedade de heap

**Min-Heap**: pai ≤ filhos (menor na raiz)  
**Max-Heap**: pai ≥ filhos (maior na raiz)

**NÃO é BST**: Não tem propriedade esquerda < direita

#### Propriedade Visual

```
Max-Heap:              Min-Heap:
       50                    1
      /  \                  / \
    30    40               3   2
   / \   /                / \
  10 20 15               5   4
```

#### Representação em Array

**Vantagem**: Heap completo cabe perfeitamente em array

**Índices** (0-based):
- **Pai de i**: (i-1)/2
- **Filho esq de i**: 2i+1
- **Filho dir de i**: 2i+2

```
Array: [50, 30, 40, 10, 20, 15]
Índice:  0   1   2   3   4   5

Árvore:
       50 (0)
      /     \
   30 (1)   40 (2)
   /  \      /
10(3) 20(4) 15(5)
```

#### Operações

1. **Insert (O(log n))**
    - Adiciona no fim do array
    - Bubble up (sift up): troca com pai se violar propriedade
    - Repete até achar posição correta

2. **Extract-Min/Max (O(log n))**
    - Remove raiz (índice 0)
    - Move último elemento para raiz
    - Bubble down (sift down): troca com menor/maior filho
    - Repete até restaurar heap

3. **Peek (O(1))**
    - Retorna raiz sem remover

4. **Heapify (O(n))**
    - Constrói heap de array não-ordenado
    - Começa do último nó interno
    - Faz sift-down em cada um

#### Aplicações

1. **Priority Queue**: Processos, eventos
2. **Heap Sort**: Ordenação O(n log n)
3. **Dijkstra**: Menor caminho em grafos
4. **Mediana em Stream**: 2 heaps (max + min)
5. **Top K elementos**: Min-heap de tamanho K

---

### 6. HASH TABLES - ACESSO INSTANTÂNEO

#### Conceito Central

**Hash Table** = Array + Função Hash

**Ideia**: Transformar chave em índice do array

**Função Hash**: chave → índice (0 a tamanho-1)

#### Função Hash Ideal

Características:
1. **Determinística**: Mesma chave → mesmo índice
2. **Uniforme**: Distribui chaves uniformemente
3. **Rápida**: O(1) para calcular
4. **Minimiza colisões**: Chaves diferentes → índices diferentes

#### Exemplo Simples

```java
// Hash para strings (simplificado)
int hash(String key) {
    int h = 0;
    for (char c : key.toCharArray()) {
        h = h * 31 + c;  // 31 = primo pequeno
    }
    return Math.abs(h) % tableSize;
}
```

**Por que 31?**
- Primo: melhor distribuição
- Pequeno: cálculo rápido
- Potência de 2 próxima: otimização do compilador (31 = 32-1)

#### Colisões - Problema Inevitável

**Colisão**: 2 chaves diferentes → mesmo índice

**Princípio do Pombal**: Se n > m (chaves > índices), colisões são inevitáveis

#### Resolução de Colisões - Chaining

**Chaining**: Cada posição do array = lista ligada

```
Array:
[0] → null
[1] → "Alice"→"Ana"→null
[2] → "Bob"→null
[3] → null
[4] → "Charlie"→"Carol"→null
```

**Complexidade**:
- **Melhor (uniforme)**: O(1)
- **Pior (tudo numa lista)**: O(n)
- **Média**: O(1 + α) onde α = n/m (load factor)

**Load Factor (α)**: n chaves / m slots
- α < 0.75: Boa performance
- α > 1: Muitas colisões

#### Resolução - Open Addressing

**Open Addressing**: Tudo no array (sem listas)

Quando colide, procura próximo slot vazio:

1. **Linear Probing**
    - Tenta: i, i+1, i+2, i+3, ...
    - Simples, mas clustering

2. **Quadratic Probing**
    - Tenta: i, i+1², i+2², i+3², ...
    - Reduz clustering primário

3. **Double Hashing**
    - Tenta: i, i+h₂(k), i+2h₂(k), ...
    - Melhor distribuição
    - h₂(k) deve ser coprimo com m

#### Redimensionamento

**Quando?** Load factor > 0.75 (Java HashMap)

**Como?**
1. Cria array 2x maior
2. Reinsere todos elementos (rehash)
3. Atualiza referência

**Complexidade**: O(n) mas amortizado O(1)

#### HashMap vs TreeMap (Java)

| Aspecto | HashMap | TreeMap |
|---------|---------|---------|
| **Estrutura** | Hash Table | Red-Black Tree |
| **Ordem** | Não mantém | Mantém (sorted) |
| **get()** | O(1) | O(log n) |
| **put()** | O(1) | O(log n) |
| **Uso** | Quando ordem não importa | Quando precisa ordem |

---

## 🌱 NÍVEL INICIANTE - EXERCÍCIOS {#nivel-iniciante}

### 📋 EXERCÍCIO 1: Árvore Binária Básica

**Objetivo**: Implementar estrutura fundamental

**Requisitos**:
1. Classe `Node<T>`:
    - dados: T
    - left, right: Node<T>

2. Classe `ArvoreBinaria<T>`:
    - Referência root
    - Métodos de inserção básicos

3. Métodos:
    - `inserir(T valor)`: insere como BST
    - `buscar(T valor)`: retorna nó ou null
    - `altura()`: altura da árvore
    - `contar()`: total de nós
    - `contarFolhas()`: conta folhas

**Teste com**:
- Inserir 10 números aleatórios
- Buscar existentes e inexistentes
- Calcular altura e quantidade de nós

**Aprenda**: Estrutura básica, recursão em árvores

---

### 📋 EXERCÍCIO 2: Percursos de Árvore

**Objetivo**: Implementar travesals

**Requisitos**:
1. Para árvore do exercício anterior, adicione:
    - `inOrder()`: retorna lista in-order
    - `preOrder()`: retorna lista pre-order
    - `postOrder()`: retorna lista post-order
    - `levelOrder()`: retorna lista por níveis (usa fila)

2. Versões:
    - Recursiva (in/pre/post)
    - Iterativa com stack (in/pre/post)
    - BFS com queue (level)

**Teste com**:
```
        5
       / \
      3   7
     / \   \
    2   4   8

In-order: 2, 3, 4, 5, 7, 8
Pre-order: 5, 3, 2, 4, 7, 8
Post-order: 2, 4, 3, 8, 7, 5
Level-order: 5, 3, 7, 2, 4, 8
```

**Aprenda**: Diferentes formas de percorrer árvores

---

### 📋 EXERCÍCIO 3: BST - Busca e Inserção

**Objetivo**: Implementar BST corretamente

**Requisitos**:
1. Classe `BST<T extends Comparable<T>>`:
    - Mantém propriedade BST
    - Inserção em ordem correta

2. Métodos:
    - `inserir(T valor)`: mantém propriedade
    - `buscar(T valor)`: O(log n) em média
    - `min()`: menor valor (mais à esquerda)
    - `max()`: maior valor (mais à direita)
    - `verificarBST()`: valida propriedade

3. Teste de propriedade:
    - In-order deve ser ordenado crescente

**Teste com**:
- Inserir [50, 30, 70, 20, 40, 60, 80]
- Verificar que in-order = ordenado
- Buscar min (20) e max (80)

**Aprenda**: Propriedade BST, busca eficiente

---

### 📋 EXERCÍCIO 4: Remoção em BST

**Objetivo**: Caso mais complexo

**Requisitos**:
1. Implemente `remover(T valor)` em BST
2. Trate 3 casos:
    - **Folha**: Remove diretamente
    - **1 filho**: Substitui por filho
    - **2 filhos**: Substitui por sucessor in-order

3. Método auxiliar:
    - `sucessorInOrder(Node nó)`: menor da direita

**Teste com**:
```
        50
       /  \
     30    70
    / \   / \
  20  40 60  80

Remover 50 (2 filhos) → substitui por 60
Remover 30 (2 filhos) → substitui por 40
Remover 20 (folha) → remove direto
```

**Aprenda**: Remoção complexa, sucessor

---

### 📋 EXERCÍCIO 5: Heap Básico

**Objetivo**: Implementar min-heap

**Requisitos**:
1. Classe `MinHeap<T extends Comparable<T>>`:
    - ArrayList interno
    - Índices: pai=(i-1)/2, filhos=2i+1, 2i+2

2. Métodos:
    - `inserir(T valor)`: adiciona + bubble up
    - `extrairMin()`: remove raiz + bubble down
    - `peek()`: retorna min sem remover
    - `size()`: quantidade

3. Operações auxiliares:
    - `bubbleUp(int i)`: sobe elemento
    - `bubbleDown(int i)`: desce elemento

**Teste com**:
- Inserir [5, 3, 7, 1, 9, 2]
- Extrair min repetidamente (deve sair 1,2,3,5,7,9)

**Aprenda**: Heap, priorização

---

### 📋 EXERCÍCIO 6: Hash Table com Chaining

**Objetivo**: Implementar hash básico

**Requisitos**:
1. Classe `HashTable<K, V>`:
    - Array de LinkedList
    - Tamanho inicial: 16

2. Métodos:
    - `put(K key, V value)`: adiciona par
    - `get(K key)`: retorna valor
    - `remove(K key)`: remove par
    - `contains(K key)`: verifica existência

3. Função hash:
    - Use `key.hashCode() % tamanho`
    - Trate valores negativos

**Teste com**:
- put("Alice", 25), put("Bob", 30)
- Hash colide? Trata corretamente?
- get, remove e verificar

**Aprenda**: Hashing, colisões

---

## 🌿 NÍVEL INTERMEDIÁRIO - EXERCÍCIOS {#nivel-intermediario}

### 📋 EXERCÍCIO 7: AVL Tree - Rotações

**Objetivo**: Implementar árvore auto-balanceada

**Requisitos**:
1. Classe `AVLNode<T>`:
    - dados, left, right, altura

2. Classe `AVLTree<T extends Comparable<T>>`:
    - Mantém propriedade AVL (|BF| ≤ 1)

3. Métodos:
    - `inserir(T valor)`: insere + balanceia
    - `altura(Node n)`: altura do nó
    - `balanceFactor(Node n)`: BF do nó
    - `rotateLeft(Node y)`: rotação esquerda
    - `rotateRight(Node z)`: rotação direita

4. Balanceamento após inserção:
    - Calcula BF
    - Identifica caso (LL, LR, RR, RL)
    - Aplica rotação apropriada

**Teste com**:
- Inserir em ordem: 1,2,3,4,5,6,7
- Verificar que altura = O(log n)
- Sem AVL seria degenerada (altura=n)

**Aprenda**: Balanceamento, rotações

---

### 📋 EXERCÍCIO 8: Heap Sort

**Objetivo**: Ordenação com heap

**Requisitos**:
1. Método `void heapSort(T[] array)`:
    - Constrói max-heap in-place
    - Extrai máximo repetidamente

2. Algoritmo:
    - **Heapify**: O(n) - constrói heap
    - **Extract max**: O(log n) × n vezes
    - **Total**: O(n log n)

3. Passos:
    - Transforma array em max-heap
    - Troca raiz (max) com último
    - Reduce heap size
    - Heapify raiz
    - Repete

**Teste com**:
- [5, 2, 8, 1, 9, 3, 7]
- Deve ordenar in-place
- Verificar que complexidade = O(n log n)

**Aprenda**: Heap sort, heapify

---

### 📋 EXERCÍCIO 9: Priority Queue com Heap

**Objetivo**: Fila de prioridade eficiente

**Requisitos**:
1. Classe `PriorityQueue<T extends Comparable<T>>`:
    - Usa min-heap internamente
    - Elementos com menor valor = maior prioridade

2. Métodos:
    - `add(T elemento)`: O(log n)
    - `poll()`: remove min O(log n)
    - `peek()`: retorna min O(1)
    - `size()`, `isEmpty()`

3. Aplicação prática:
    - Simulador de eventos
    - Eventos ordenados por tempo

**Teste com**:
- Adicionar eventos: (tempo=5, "A"), (tempo=2, "B"), (tempo=8, "C")
- Poll deve retornar B, A, C (ordem de tempo)

**Aprenda**: Priority queue, aplicação real

---

### 📋 EXERCÍCIO 10: Hash com Open Addressing

**Objetivo**: Implementar linear probing

**Requisitos**:
1. Classe `OpenAddressHashTable<K, V>`:
    - Array de pares (K, V)
    - Marca deletados com TOMBSTONE

2. Métodos:
    - `put(K, V)`: insere com probing
    - `get(K)`: busca com probing
    - `remove(K)`: marca TOMBSTONE

3. Probing:
    - Colide em i → tenta i+1, i+2, ...
    - Continua até achar vazio ou chave

4. Redimensionamento:
    - Load factor > 0.75 → dobra tamanho
    - Reinsere tudo (sem tombstones)

**Teste com**:
- put 100 elementos
- Verificar que resize acontece
- Remover e verificar que get ainda funciona

**Aprenda**: Open addressing, tombstones

---

### 📋 EXERCÍCIO 11: LRU Cache com Hash + Lista

**Objetivo**: Combinar estruturas

**Requisitos**:
1. Classe `LRUCache<K, V>`:
    - Capacidade limitada
    - Remove menos recentemente usado

2. Estruturas internas:
    - HashMap<K, Node>: acesso O(1)
    - Lista duplamente ligada: ordem de uso

3. Operações:
    - `get(K)`: move para início (mais recente)
    - `put(K, V)`: adiciona/atualiza + move para início
    - Se cheio: remove fim da lista (LRU)

4. Ambas O(1):
    - Hash: acesso rápido
    - Lista: mover/remover rápido

**Teste com**:
- Capacidade 3: put(1,a), put(2,b), put(3,c)
- get(1) - move 1 para início
- put(4,d) - remove 2 (LRU)
- Verificar ordem: [4, 1, 3]

**Aprenda**: Estruturas combinadas, LRU

---

### 📋 EXERCÍCIO 12: Árvore de Expressões

**Objetivo**: Parsing com árvore

**Requisitos**:
1. Construir árvore de expressão matemática:
    - Folhas: números
    - Internos: operadores (+, -, *, /)

2. Métodos:
    - `construir(String posfixa)`: cria árvore de RPN
    - `avaliar()`: calcula resultado
    - `infixa()`: retorna expressão normal
    - `prefixa()`: retorna notação polonesa
    - `posfixa()`: retorna RPN

**Teste com**:
```
Entrada: "3 4 + 2 *"
Árvore:
       *
      / \
     +   2
    / \
   3   4

avaliar() → 14
infixa() → "((3 + 4) * 2)"
```

**Aprenda**: Árvores para parsing

---

## 🌳 NÍVEL AVANÇADO - EXERCÍCIOS {#nivel-avancado}

### 📋 EXERCÍCIO 13: Red-Black Tree

**Objetivo**: Implementar RB-Tree completo

**Requisitos**:
1. Classe `RBNode<T>`:
    - dados, left, right, parent
    - color: RED ou BLACK

2. Propriedades:
    - Raiz preta
    - Folhas (NIL) pretas
    - Vermelho → filhos pretos
    - Caminhos com mesmo nº de pretos

3. Métodos:
    - `inserir(T valor)`: insere + corrige cores
    - `fixInsert(Node z)`: corrige violações
    - `rotateLeft()`, `rotateRight()`

4. Casos de correção:
    - Tio vermelho: recolore
    - Tio preto: rotações

**Teste com**:
- Inserir 1-10 em sequência
- Verificar propriedades mantidas
- Comparar altura com AVL

**Aprenda**: RB-Tree, recoloração

---

### 📋 EXERCÍCIO 14: B-Tree (Ordem 3)

**Objetivo**: Árvore multi-way

**Requisitos**:
1. Classe `BNode`:
    - Array de chaves (max 2 para ordem 3)
    - Array de filhos (max 3)

2. Propriedades:
    - Raiz: 1-2 chaves
    - Internos: 1-2 chaves
    - Todas folhas no mesmo nível

3. Operações:
    - `inserir(int chave)`: insere + split se necessário
    - `split(Node cheio)`: divide nó cheio
    - `buscar(int chave)`: busca recursiva

**Teste com**:
- Inserir 1-20
- Verificar splits
- Árvore baixa e balanceada

**Aprenda**: Árvores para bancos de dados

---

### 📋 EXERCÍCIO 15: Trie (Prefix Tree)

**Objetivo**: Árvore para strings

**Requisitos**:
1. Classe `TrieNode`:
    - Map<Character, TrieNode> filhos
    - boolean isEndOfWord

2. Classe `Trie`:
    - TrieNode raiz

3. Métodos:
    - `inserir(String palavra)`: adiciona caractere por caractere
    - `buscar(String palavra)`: verifica existência
    - `comecaCom(String prefixo)`: lista palavras com prefixo
    - `deletar(String palavra)`: remove palavra

**Teste com**:
- Inserir: ["cat", "cats", "dog", "door"]
- comecaCom("ca") → ["cat", "cats"]
- comecaCom("do") → ["dog", "door"]

**Aprenda**: Trie, autocomplete

---

### 📋 EXERCÍCIO 16: Segment Tree

**Objetivo**: Árvore para queries de range

**Requisitos**:
1. Construir segment tree para:
    - Range sum query
    - Range minimum query

2. Operações:
    - `build(int[] arr)`: constrói árvore O(n)
    - `query(int l, int r)`: soma/min de [l, r] O(log n)
    - `update(int i, int val)`: atualiza índice O(log n)

3. Estrutura:
    - Folhas: elementos originais
    - Internos: agregação (soma, min, etc)

**Teste com**:
- Array: [1, 3, 5, 7, 9, 11]
- query(1, 4) → soma de [3,5,7,9] = 24
- update(2, 10) → muda 5 para 10
- query(1, 4) → agora soma = 29

**Aprenda**: Range queries eficientes

---

### 📋 EXERCÍCIO 17: Persistent Data Structure

**Objetivo**: Árvore com histórico

**Requisitos**:
1. Implementar BST persistente:
    - Cada versão mantida
    - Copia apenas caminho modificado (path copying)
    - Compartilha resto da árvore

2. Métodos:
    - `inserir(T valor)`: retorna nova raiz
    - `versao(int v)`: acessa versão antiga

3. Estrutura:
    - Nós imutáveis
    - Cada inserção cria nova "versão"
    - Versões antigas acessíveis

**Teste com**:
- v0: Vazia
- v1: Insere 5
- v2: Insere 3
- v3: Insere 7
- Acessar v1 ainda tem só 5

**Aprenda**: Estruturas persistentes, funcional

---

### 📋 EXERCÍCIO 18: Consistent Hashing

**Objetivo**: Hash distribuído

**Requisitos**:
1. Implementar consistent hashing:
    - Anel de hash (0 a 2^32-1)
    - Servidores e chaves no anel
    - Chave vai para próximo servidor clockwise

2. Métodos:
    - `addServer(String nome)`: adiciona servidor
    - `removeServer(String nome)`: remove servidor
    - `getServer(String chave)`: retorna servidor responsável

3. Virtual nodes:
    - Cada servidor = múltiplos pontos no anel
    - Melhor distribuição

**Teste com**:
- 3 servidores
- 1000 chaves
- Remover 1 servidor - apenas ~1/3 redistribui

**Aprenda**: Hashing em sistemas distribuídos

---

## 🚀 PROJETOS INTEGRADORES {#projetos}

### PROJETO 1: Mini Banco de Dados (60-80h)

**Descrição**: DB simples com indexação

**Componentes**:

1. **Storage Engine**:
    - Tabelas = arquivos
    - Registros = linhas
    - B-Tree para índices

2. **Indexação**:
    - Primary key: B-Tree
    - Secondary indexes: B-Tree
    - Busca O(log n)

3. **Query Processor**:
    - SELECT com WHERE
    - INSERT, UPDATE, DELETE
    - Usa índices quando possível

4. **Cache**:
    - LRU cache para páginas
    - Hash table para registros recentes

5. **Funcionalidades**:
    - CREATE TABLE
    - CREATE INDEX
    - SELECT * FROM ... WHERE ...
    - JOIN (bonus)

**Exemplo**:
```sql
CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR, age INT);
CREATE INDEX idx_age ON users(age);
INSERT INTO users VALUES (1, 'Alice', 25);
SELECT * FROM users WHERE age > 20;
```

**Aprenda**: B-Trees, indexação, cache

---

### PROJETO 2: Sistema de Autocompletar (50-70h)

**Descrição**: Autocomplete como Google

**Componentes**:

1. **Trie para Palavras**:
    - Armazena dicionário
    - Busca por prefixo O(k) k=tamanho prefixo

2. **Ranking**:
    - Cada palavra tem score (frequência)
    - Heap para top-K sugestões
    - Atualiza scores com uso

3. **Fuzzy Search**:
    - Tolera erros de digitação
    - Distância de Levenshtein
    - Sugestões aproximadas

4. **Persistência**:
    - Serializa Trie para disco
    - Carrega sob demanda

5. **Otimizações**:
    - Cache de prefixos comuns (hash)
    - Compressão de nós (prefix tree)

**Funcionalidades**:
- Adicionar palavras
- Buscar por prefixo
- Top 10 sugestões
- Correção de erros

**Teste com**:
- Dicionário de 100k palavras
- Latência < 10ms
- Fuzzy: "progarm" → "program"

**Aprenda**: Trie, ranking, fuzzy matching

---

## 📚 RECURSOS DE ESTUDO {#recursos}

### 📖 Livros

1. **"Introduction to Algorithms" - CLRS**
    - Capítulos: 10-14 (Trees, Hash)
    - Matemática rigorosa
    - Provas de complexidade

2. **"The Algorithm Design Manual" - Skiena**
    - Capítulos: 3-4 (Trees, Sorting)
    - War stories
    - Quando usar cada estrutura

3. **"Advanced Data Structures" - Brass**
    - B-Trees, Tries, Segment Trees
    - Estruturas especializadas

### 🎓 Cursos

1. **Princeton - Algorithms Part I**
    - Weeks 4-6: BST, Heaps, Hash
    - Implementações Java

2. **MIT 6.006**
    - Lectures 4-7
    - AVL, Hashing

3. **UC Berkeley CS61B**
    - Árvores balanceadas
    - Projetos práticos

### 🎥 YouTube

1. **Abdul Bari** - Trees playlist
2. **William Fiset** - AVL, RB-Trees
3. **mycodeschool** - BST, Heap

### 🌐 Sites

1. **VisuAlgo** - Todas estruturas
2. **USFCA Visualizations**
3. **Data Structure Visualizer**

### 🏆 Prática

1. **LeetCode** - Tree, Heap, Hash tags
2. **HackerRank** - Trees, Advanced
3. **GeeksforGeeks** - Tutoriais + problemas

---

## ✅ CHECKLIST {#checklist}

### Iniciante
- [ ] Implemento árvore binária do zero
- [ ] Faço todos percursos (in/pre/post/level)
- [ ] Implemento BST com busca/inserção
- [ ] Implemento remoção em BST (3 casos)
- [ ] Implemento min-heap básico
- [ ] Implemento hash table com chaining

### Intermediário
- [ ] Implemento AVL com rotações
- [ ] Uso heap para heap sort
- [ ] Implemento priority queue
- [ ] Implemento hash com open addressing
- [ ] Combino estruturas (LRU cache)
- [ ] Construo árvore de expressões

### Avançado
- [ ] Implemento Red-Black Tree
- [ ] Implemento B-Tree
- [ ] Implemento Trie
- [ ] Implemento Segment Tree
- [ ] Entendo estruturas persistentes
- [ ] Implemento consistent hashing

---

## 🎯 PRÓXIMOS PASSOS

1. **Trilha 5**: Grafos
2. **Trilha 6**: Algoritmos Clássicos
3. **Sistemas Reais**: Contribua para OpenJDK

**Estruturas não-lineares são o coração da computação! 🌳**
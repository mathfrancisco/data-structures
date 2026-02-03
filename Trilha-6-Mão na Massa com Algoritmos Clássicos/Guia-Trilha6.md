# 🧮 TRILHA 6: Algoritmos Clássicos
## Guia Didático Completo - Ordenação, Busca, DP, Gulosos e Paradigmas

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

### Por que dominar algoritmos clássicos?

**Algoritmos clássicos** são **padrões de solução** testados e comprovados. Como um artesão que domina ferramentas fundamentais antes de criar obras complexas.

**Impacto no Mundo Real**:
- 🔍 **Buscadores**: Ordenação por relevância
- 📊 **Big Data**: Ordenação distribuída (MapReduce)
- 💰 **Trading**: Algoritmos em tempo real
- 🎮 **IA em Jogos**: Minimax, alpha-beta pruning
- 📱 **Compressão**: Huffman, LZ77 (ZIP, PNG)
- 🧬 **Bioinformática**: Alinhamento de sequências

### O que você dominará

| Paradigma | Técnica | Quando Usar |
|-----------|---------|-------------|
| **Busca** | Linear, Binária | Encontrar elementos |
| **Ordenação** | Comparison-based | Organizar dados |
| **Divisão e Conquista** | Merge Sort, Quick Sort | Quebrar em subproblemas |
| **Programação Dinâmica** | Memoização, Tabulação | Subproblemas sobrepostos |
| **Guloso** | Escolha local ótima | Propriedade gulosa |
| **Backtracking** | Tentativa e erro | Espaço de busca |
| **String Matching** | KMP, Boyer-Moore | Busca em texto |

### Cronograma Sugerido

**Tempo Total**: 90-110 horas (8-10 semanas)

- **Semana 1-2** (Iniciante): Busca, Ordenação Simples - 20h
- **Semana 3-5** (Intermediário): Merge/Quick/Heap Sort, DP - 30h
- **Semana 6-8** (Avançado): Backtracking, Strings, Compressão - 35h
- **Semana 9-10** (Projetos): Otimizador, Compressor - 25h

---

## 📖 TEORIA FUNDAMENTAL {#teoria}

### 1. ALGORITMOS DE BUSCA

#### Busca Linear

**Conceito**: Percorre array sequencialmente

**Complexidade**: O(n)

**Quando Usar**:
✅ Array não ordenado  
✅ Lista ligada  
✅ n pequeno (< 1000)

---

#### Busca Binária

**Conceito**: Divide pela metade repetidamente

**Pré-requisito**: Array **DEVE** estar ordenado

**Algoritmo**:
```
buscaBinaria(arr, x):
    left = 0, right = n-1
    
    enquanto left ≤ right:
        mid = (left + right) / 2
        
        se arr[mid] == x:
            retorna mid
        senão se arr[mid] < x:
            left = mid + 1
        senão:
            right = mid - 1
    
    retorna -1  // não encontrado
```

**Complexidade**: O(log n)

**Visualização**:
```
Array: [1, 3, 5, 7, 9, 11, 13, 15]
Buscar: 7

Iteração 1: mid=3 (7), arr[3]=7 ✅ Encontrou!

Buscar: 14

Iteração 1: mid=3 (7), 14>7, busca à direita [9,11,13,15]
Iteração 2: mid=5 (11), 14>11, busca à direita [13,15]
Iteração 3: mid=6 (13), 14>13, busca à direita [15]
Iteração 4: mid=7 (15), 14<15, busca à esquerda []
Retorna -1 (não encontrado)
```

---

### 2. ALGORITMOS DE ORDENAÇÃO SIMPLES

#### Bubble Sort

**Ideia**: Compara pares adjacentes e troca se fora de ordem

**Algoritmo**:
```
bubbleSort(arr):
    n = tamanho(arr)
    para i de 0 até n-1:
        trocou = falso
        para j de 0 até n-i-2:
            se arr[j] > arr[j+1]:
                troca(arr[j], arr[j+1])
                trocou = verdadeiro
        
        se não trocou:
            break  // já ordenado
```

**Complexidade**:
- Melhor: O(n) - já ordenado
- Médio: O(n²)
- Pior: O(n²) - ordem reversa

**Quando Usar**: Nunca em produção, só didático

---

#### Selection Sort

**Ideia**: Encontra mínimo e move para posição correta

**Algoritmo**:
```
selectionSort(arr):
    n = tamanho(arr)
    para i de 0 até n-1:
        min_idx = i
        para j de i+1 até n-1:
            se arr[j] < arr[min_idx]:
                min_idx = j
        troca(arr[i], arr[min_idx])
```

**Complexidade**: Sempre O(n²)

**Vantagem**: Apenas n-1 trocas (mínimo possível)

---

#### Insertion Sort

**Ideia**: Constrói array ordenado inserindo elementos na posição correta

**Algoritmo**:
```
insertionSort(arr):
    para i de 1 até n-1:
        chave = arr[i]
        j = i - 1
        
        enquanto j ≥ 0 e arr[j] > chave:
            arr[j+1] = arr[j]
            j--
        
        arr[j+1] = chave
```

**Complexidade**:
- Melhor: O(n) - já ordenado
- Médio: O(n²)
- Pior: O(n²)

**Quando Usar**:
✅ Arrays pequenos (< 50)  
✅ Dados quase ordenados  
✅ Stream de dados (online)

---

### 3. ORDENAÇÃO EFICIENTE

#### Merge Sort

**Paradigma**: Divisão e Conquista

**Ideia**: Divide array, ordena metades, mescla ordenadamente

**Algoritmo**:
```
mergeSort(arr, left, right):
    se left < right:
        mid = (left + right) / 2
        mergeSort(arr, left, mid)
        mergeSort(arr, mid+1, right)
        merge(arr, left, mid, right)

merge(arr, left, mid, right):
    copia arr[left..mid] para L
    copia arr[mid+1..right] para R
    
    i = j = 0, k = left
    enquanto i < tamanho(L) e j < tamanho(R):
        se L[i] ≤ R[j]:
            arr[k++] = L[i++]
        senão:
            arr[k++] = R[j++]
    
    copia resto de L ou R
```

**Complexidade**: **Sempre O(n log n)** ⭐

**Propriedades**:
✅ Estável  
✅ Previsível  
❌ O(n) espaço extra

---

#### Quick Sort

**Paradigma**: Divisão e Conquista

**Ideia**: Escolhe pivô, particiona, ordena recursivamente

**Algoritmo**:
```
quickSort(arr, low, high):
    se low < high:
        pi = partition(arr, low, high)
        quickSort(arr, low, pi-1)
        quickSort(arr, pi+1, high)

partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    
    para j de low até high-1:
        se arr[j] < pivot:
            i++
            troca(arr[i], arr[j])
    
    troca(arr[i+1], arr[high])
    retorna i+1
```

**Complexidade**:
- Melhor: O(n log n)
- Médio: O(n log n)
- Pior: O(n²) - pivô ruim (já ordenado)

**Otimizações**:
- Random pivot
- Median-of-three
- Hybrid com Insertion para pequenos

**Quando Usar**: Default em muitas linguagens (mais rápido na prática)

---

#### Heap Sort

**Ideia**: Constrói heap, extrai máximos repetidamente

**Complexidade**: **Sempre O(n log n)**, in-place

**Propriedades**:
✅ In-place  
✅ Pior caso garantido  
❌ Não estável

---

### 4. PROGRAMAÇÃO DINÂMICA

#### Conceito Central

**DP** = Resolver subproblemas e reutilizar soluções

**Requisitos**:
1. **Subestrutura Ótima**: Solução ótima usa soluções ótimas de subproblemas
2. **Subproblemas Sobrepostos**: Mesmos subproblemas resolvidos várias vezes

#### Abordagens

**Top-Down (Memoização)**:
- Recursão natural
- Cache de resultados
- Lazy (calcula só o necessário)

**Bottom-Up (Tabulação)**:
- Iterativo
- Preenche tabela
- Eager (calcula tudo)

---

#### Problema Clássico: Fibonacci

**Recursão Naive**: O(2ⁿ) - exponencial!
```
fib(n):
    se n ≤ 1: retorna n
    retorna fib(n-1) + fib(n-2)
```

**Memoização**: O(n)
```
memo = {}
fibMemo(n):
    se n em memo: retorna memo[n]
    se n ≤ 1: retorna n
    
    memo[n] = fibMemo(n-1) + fibMemo(n-2)
    retorna memo[n]
```

**Tabulação**: O(n), O(1) espaço otimizado
```
fibTab(n):
    se n ≤ 1: retorna n
    
    a, b = 0, 1
    para i de 2 até n:
        a, b = b, a+b
    
    retorna b
```

---

#### Problema da Mochila 0/1

**Problema**: n itens (valor, peso), capacidade W. Maximizar valor sem exceder peso.

**Recorrência**:
```
dp[i][w] = máximo valor usando itens 0..i-1 com capacidade w

dp[i][w] = max(
    dp[i-1][w],           // não pega item i
    dp[i-1][w-peso[i]] + valor[i]  // pega item i
)
```

**Complexidade**: O(n × W) - pseudo-polinomial

---

#### LCS (Longest Common Subsequence)

**Problema**: Maior subsequência comum entre duas strings

**Exemplo**: "AGGTAB" e "GXTXAYB" → "GTAB" (tamanho 4)

**Recorrência**:
```
lcs[i][j] = tamanho da LCS de A[0..i-1] e B[0..j-1]

se A[i-1] == B[j-1]:
    lcs[i][j] = lcs[i-1][j-1] + 1
senão:
    lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])
```

**Aplicações**:
- diff de arquivos
- Alinhamento de DNA
- Detecção de plágio

---

### 5. ALGORITMOS GULOSOS

#### Conceito Central

**Guloso** = Sempre faz escolha localmente ótima

**Quando Funciona**:
1. **Propriedade Gulosa**: Escolha local leva à solução global ótima
2. **Subestrutura Ótima**: Igual DP

**Diferença de DP**:
- DP: Considera **todas** opções
- Guloso: Apenas **uma** opção (a melhor local)

---

#### Problema do Troco

**Moedas Brasileiras**: [50, 25, 10, 5, 1]

**Guloso**: Sempre pega maior moeda possível
```
troco(valor, moedas):
    ordena moedas em ordem decrescente
    resultado = []
    
    para cada moeda:
        enquanto valor ≥ moeda:
            resultado.adiciona(moeda)
            valor -= moeda
    
    retorna resultado
```

**Funciona?** ✅ Sim para moedas brasileiras!

**Contra-exemplo**: Moedas [4, 3, 1], troco 6
- Guloso: 4 + 1 + 1 = 3 moedas
- Ótimo: 3 + 3 = 2 moedas ❌

---

#### Seleção de Atividades

**Problema**: n atividades (início, fim). Maximizar atividades sem sobreposição.

**Estratégia Gulosa**: Ordena por fim, escolhe primeira disponível

**Por que funciona**: Terminar cedo libera mais tempo para outras

**Complexidade**: O(n log n) - dominado pela ordenação

---

### 6. BACKTRACKING

#### Conceito Central

**Backtracking** = Tentativa e erro sistemático

**Padrão**:
1. Tenta opção
2. Verifica se válida
3. Recursão
4. Se falhar, desfaz (backtrack)

**Otimização**: **Poda** - elimina ramos impossíveis cedo

---

#### N-Rainhas

**Problema**: Colocar n rainhas em tabuleiro n×n sem se atacarem

**Algoritmo**:
```
solveNQueens(board, row, n):
    se row == n:
        adiciona solução
        retorna
    
    para col de 0 até n-1:
        se isSafe(board, row, col):
            coloca rainha em (row, col)
            solveNQueens(board, row+1, n)
            remove rainha  // backtrack
```

**Poda**: Não tenta colunas/diagonais atacadas

---

#### Sudoku

**Similar**: Tenta números 1-9, verifica regras, recursão

**Otimização**: Começa por células com menos opções (MRV heuristic)

---

### 7. ALGORITMOS DE STRING

#### Busca Ingênua

**Complexidade**: O(n × m) onde n=texto, m=padrão

**Simples mas lento**

---

#### KMP (Knuth-Morris-Pratt)

**Ideia**: Evita comparações desnecessárias usando informação do padrão

**LPS Array**: Longest Proper Prefix which is Suffix

**Exemplo**:
```
Padrão: "ABABAC"
LPS:    [0,0,1,2,3,0]

LPS[i] = tamanho do maior prefixo próprio de padrão[0..i]
         que também é sufixo
```

**Complexidade**: O(n + m) - linear!

---

#### Boyer-Moore

**Ideia**: Compara da direita para esquerda, pula quando possível

**Heurísticas**:
1. **Bad Character**: Se não casa, pula baseado em onde char aparece no padrão
2. **Good Suffix**: Usa informação de sufixo que casou

**Complexidade**: O(n/m) melhor caso - pode ser sublinear!

---

### 8. COMPRESSÃO

#### Huffman Coding

**Ideia**: Caracteres frequentes → códigos curtos

**Algoritmo**:
1. Conta frequências
2. Constrói árvore (heap de frequências)
3. Códigos = caminhos na árvore

**Propriedade**: Prefix-free (sem ambiguidade)

**Taxa**: Até H(X) bits/símbolo (entropia)

---

## 🌱 NÍVEL INICIANTE - EXERCÍCIOS {#nivel-iniciante}

### 📋 EXERCÍCIO 1: Busca Linear e Binária

**Objetivo**: Implementar e comparar

**Requisitos**:
1. `buscaLinear(arr, x)`: percorre sequencialmente
2. `buscaBinaria(arr, x)`: divide pela metade
3. Conte comparações em ambos
4. Teste com arrays de tamanhos: 100, 1K, 10K, 100K

**Aprenda**: O(n) vs O(log n) na prática

---

### 📋 EXERCÍCIO 2: Três Ordenações Simples

**Objetivo**: Bubble, Selection, Insertion

**Requisitos**:
1. Implemente os 3
2. Conte comparações e trocas
3. Teste com:
    - Array aleatório
    - Já ordenado
    - Ordem reversa

**Aprenda**: Algoritmos O(n²), casos especiais

---

### 📋 EXERCÍCIO 3: Fibonacci com Otimizações

**Objetivo**: Do exponencial ao linear

**Requisitos**:
1. Recursão ingênua
2. Memoização
3. Iterativo
4. Meça tempo para n=5, 10, 20, 30, 40

**Aprenda**: Impacto da otimização

---

### 📋 EXERCÍCIO 4: Problema do Troco Guloso

**Objetivo**: Algoritmo guloso básico

**Requisitos**:
1. Implemente para moedas brasileiras
2. Teste com vários valores
3. Compare com força bruta (DP) para moedas [4,3,1]
4. Quando guloso falha?

**Aprenda**: Guloso, quando não funciona

---

### 📋 EXERCÍCIO 5: Análise de Complexidade

**Objetivo**: Identificar Big-O

**Requisitos**:
Dado snippets de código, determine:
1. Complexidade de tempo
2. Complexidade de espaço
3. Justifique

**Aprenda**: Análise prática

---

### 📋 EXERCÍCIO 6: Busca em String Ingênua

**Objetivo**: Pattern matching básico

**Requisitos**:
1. Implementar busca ingênua
2. Retornar todas ocorrências
3. Contar comparações
4. Testar com textos longos

**Aprenda**: Base para algoritmos avançados

---

## 🌿 NÍVEL INTERMEDIÁRIO - EXERCÍCIOS {#nivel-intermediario}

### 📋 EXERCÍCIO 7: Merge Sort Completo

**Objetivo**: Implementar corretamente

**Requisitos**:
1. Versão recursiva
2. Conte operações (comparações, cópias)
3. Meça tempo vs Quick Sort
4. Verifique estabilidade

**Aprenda**: Merge Sort, divisão e conquista

---

### 📋 EXERCÍCIO 8: Quick Sort com Otimizações

**Objetivo**: Versão eficiente

**Requisitos**:
1. Quick Sort básico
2. Random pivot
3. Median-of-three
4. Hybrid com Insertion para n<10
5. Compare todas versões

**Aprenda**: Otimizações práticas

---

### 📋 EXERCÍCIO 9: Heap Sort

**Objetivo**: Ordenação com heap

**Requisitos**:
1. Construir heap in-place
2. Extract max repetidamente
3. Sem usar heap pronto
4. Compare com Merge e Quick

**Aprenda**: Heap, ordenação in-place

---

### 📋 EXERCÍCIO 10: Problema da Mochila 0/1

**Objetivo**: DP clássico

**Requisitos**:
1. Implementar com tabela 2D
2. Otimizar para 1D (rolling array)
3. Recuperar itens escolhidos, não só valor
4. Testar com casos reais

**Aprenda**: DP, reconstrução de solução

---

### 📋 EXERCÍCIO 11: LCS (Longest Common Subsequence)

**Objetivo**: Comparação de sequências

**Requisitos**:
1. Implementar LCS com DP
2. Recuperar a subsequência, não só tamanho
3. Aplicar em:
    - Diff de arquivos
    - Detecção de plágio

**Aprenda**: DP em strings

---

### 📋 EXERCÍCIO 12: Edit Distance (Levenshtein)

**Objetivo**: Distância entre strings

**Requisitos**:
1. DP para calcular distância
2. Operações: inserir, remover, substituir
3. Recuperar sequência de operações
4. Aplicação: corretor ortográfico

**Aprenda**: DP, aplicação real

---

## 🌳 NÍVEL AVANÇADO - EXERCÍCIOS {#nivel-avancado}

### 📋 EXERCÍCIO 13: N-Rainhas com Backtracking

**Objetivo**: Problema clássico

**Requisitos**:
1. Encontrar todas soluções para n=8
2. Otimizações:
    - Bit manipulation
    - Symmetry breaking
3. Meça quantidade de backtrack
4. Visualize soluções

**Aprenda**: Backtracking, otimizações

---

### 📋 EXERCÍCIO 14: Sudoku Solver

**Objetivo**: Resolver Sudoku

**Requisitos**:
1. Backtracking básico
2. Heurística MRV (Minimum Remaining Values)
3. Forward checking
4. Resolver puzzles difíceis (<17 pistas)

**Aprenda**: Backtracking avançado, heurísticas

---

### 📋 EXERCÍCIO 15: KMP (Knuth-Morris-Pratt)

**Objetivo**: Pattern matching eficiente

**Requisitos**:
1. Implementar construção do LPS array
2. Busca com KMP
3. Comparar com busca ingênua
4. Testar com textos grandes (>1MB)

**Aprenda**: KMP, string matching

---

### 📋 EXERCÍCIO 16: Boyer-Moore

**Objetivo**: Pattern matching ainda mais rápido

**Requisitos**:
1. Implementar bad character rule
2. Implementar good suffix rule
3. Comparar com KMP
4. Quando Boyer-Moore vence?

**Aprenda**: Boyer-Moore, heurísticas

---

### 📋 EXERCÍCIO 17: Huffman Coding

**Objetivo**: Compressão de texto

**Requisitos**:
1. Construir árvore Huffman
2. Gerar códigos
3. Comprimir texto
4. Descomprimir
5. Calcular taxa de compressão

**Aprenda**: Huffman, compressão

---

### 📋 EXERCÍCIO 18: Longest Increasing Subsequence

**Objetivo**: LIS com DP e Binary Search

**Requisitos**:
1. DP simples: O(n²)
2. DP + Binary Search: O(n log n)
3. Recuperar a subsequência
4. Comparar tempos

**Aprenda**: DP otimizado

---

## 🚀 PROJETOS INTEGRADORES {#projetos}

### PROJETO 1: Otimizador de Rotas de Entrega (70-90h)

**Descrição**: Sistema de logística

**Funcionalidades**:
1. **Entrada**:
    - Lista de endereços
    - Pesos/volumes
    - Janelas de tempo
    - Capacidade do veículo

2. **Algoritmos**:
    - TSP para ordem de visitas
    - Bin Packing para carregar veículos
    - Múltiplos veículos

3. **Otimizações**:
    - Heurísticas (nearest neighbor, 2-opt)
    - Metaheurísticas (Simulated Annealing, Genetic Algorithm)
    - DP para casos pequenos

4. **Visualização**:
    - Mapa com rota
    - Métricas (distância, tempo, custo)

5. **Comparações**:
    - Força bruta vs heurísticas
    - Qualidade vs tempo

**Aprenda**: TSP, otimização combinatória, trade-offs

---

### PROJETO 2: Compressor de Arquivos (60-80h)

**Descrição**: ZIP-like compressor

**Funcionalidades**:
1. **Algoritmos de Compressão**:
    - Huffman Coding
    - LZ77 (Lempel-Ziv)
    - RLE (Run-Length Encoding)

2. **Compressão**:
    - Escolhe algoritmo baseado em tipo de arquivo
    - Texto → Huffman
    - Binário → LZ77

3. **Descompressão**:
    - Lê header para saber algoritmo
    - Reconstrói arquivo original

4. **Métricas**:
    - Taxa de compressão
    - Tempo de compressão/descompressão
    - Comparar com ZIP real

5. **Extras**:
    - Múltiplos arquivos (tar-like)
    - Streaming (grandes arquivos)

**Aprenda**: Compressão, I/O, formato de arquivos

---

## 📚 RECURSOS DE ESTUDO {#recursos}

### 📖 Livros

1. **"Introduction to Algorithms" - CLRS**
    - Todos capítulos
    - Bíblia de algoritmos

2. **"The Algorithm Design Manual" - Skiena**
    - Perspectiva prática
    - War stories

3. **"Programming Pearls" - Bentley**
    - Técnicas de otimização
    - Pensamento algorítmico

### 🎓 Cursos

1. **MIT 6.006 + 6.046**
    - Teoria completa
    - Provas rigorosas

2. **Princeton Algorithms I + II**
    - Implementações Java
    - Prático

3. **Stanford CS161**
    - Algoritmos fundamentais

### 🎥 YouTube

1. **Abdul Bari** - Tudo
2. **MIT OCW** - Lectures
3. **William Fiset** - Implementações

### 🏆 Prática

1. **LeetCode** - 300+ problemas (75 essential)
2. **Codeforces** - Competitive
3. **Project Euler** - Matemáticos

### 📄 Papers Clássicos

1. **Dijkstra's Algorithm** (1959)
2. **Quicksort** - Hoare (1962)
3. **KMP** (1977)
4. **RSA** (1977) - criptografia

---

## ✅ CHECKLIST {#checklist}

### Iniciante
- [ ] Implemento busca linear e binária
- [ ] Implemento 3 algoritmos O(n²)
- [ ] Entendo quando usar cada busca
- [ ] Otimizo Fibonacci de 2ⁿ para O(n)
- [ ] Implemento algoritmo guloso simples
- [ ] Analiso complexidade de código

### Intermediário
- [ ] Implemento Merge Sort corretamente
- [ ] Implemento Quick Sort com otimizações
- [ ] Implemento Heap Sort
- [ ] Resolvo Mochila com DP
- [ ] Resolvo LCS e Edit Distance
- [ ] Entendo quando usar DP vs Guloso

### Avançado
- [ ] Resolvo N-Rainhas e Sudoku
- [ ] Implemento KMP e Boyer-Moore
- [ ] Implemento Huffman Coding
- [ ] Otimizo algoritmos (LIS O(n log n))
- [ ] Resolvo problemas NP com heurísticas
- [ ] Comparo algoritmos empiricamente

**Você dominou os algoritmos fundamentais! Continue praticando! 🧮**
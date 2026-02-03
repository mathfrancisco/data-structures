# 🕸️ TRILHA 5: Teoria dos Grafos
## Guia Didático Completo - Redes, Conexões e Algoritmos em Grafos

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

### Por que grafos são a estrutura mais versátil?

**Grafos** modelam **relações** entre entidades. Enquanto árvores são hierarquias, grafos representam **qualquer tipo de conexão**.

**Impacto no Mundo Real**:
- 🗺️ **GPS/Mapas**: Rotas, trânsito = grafo ponderado
- 👥 **Redes Sociais**: Amizades, seguidores = grafo direcionado
- 🌐 **Internet**: Páginas, links = grafo massivo
- 🧬 **Biologia**: Proteínas, interações = grafo complexo
- 💰 **Finanças**: Transações, riscos = grafo temporal
- 🎮 **IA em Jogos**: Estados, transições = grafo de jogo

### O que você dominará

| Conceito | Aplicação | Algoritmo Chave |
|----------|-----------|-----------------|
| **Representações** | Escolher estrutura eficiente | Matriz vs Lista |
| **Percursos** | Exploração, busca | DFS, BFS |
| **Caminhos** | Navegação, rotas | Dijkstra, Bellman-Ford |
| **Conectividade** | Análise de redes | Componentes, Pontes |
| **Árvores Geradoras** | Otimização de redes | Kruskal, Prim |
| **Fluxos** | Capacidade, distribuição | Ford-Fulkerson |
| **Coloração** | Alocação de recursos | Backtracking, Guloso |

### Cronograma Sugerido

**Tempo Total**: 70-90 horas (6-8 semanas)

- **Semana 1-2** (Iniciante): Representações, DFS, BFS - 20h
- **Semana 3-4** (Intermediário): Dijkstra, MST, Componentes - 25h
- **Semana 5-6** (Avançado): Fluxo, TSP, Coloração - 25h
- **Semana 7-8** (Projetos): GPS, Rede Social - 20h

---

## 📖 TEORIA FUNDAMENTAL {#teoria}

### 1. O QUE SÃO GRAFOS?

#### Definição Matemática

**Grafo G = (V, E)**
- **V** = Conjunto de vértices (nós)
- **E** = Conjunto de arestas (conexões)

**Exemplo**: Rede social simples
- V = {Alice, Bob, Carol}
- E = {(Alice, Bob), (Bob, Carol)}

#### Tipos de Grafos

1. **Direcionado vs Não-Direcionado**

| Tipo | Descrição | Exemplo | Aresta |
|------|-----------|---------|--------|
| **Não-Direcionado** | Relação simétrica | Facebook amizade | (A, B) = (B, A) |
| **Direcionado** | Relação assimétrica | Twitter seguidor | A→B ≠ B→A |

2. **Ponderado vs Não-Ponderado**

| Tipo | Descrição | Exemplo |
|------|-----------|---------|
| **Não-Ponderado** | Só conexão | Amizade (existe ou não) |
| **Ponderado** | Conexão com valor | Distância entre cidades |

3. **Cíclico vs Acíclico**

- **Cíclico**: Pode voltar ao ponto inicial
- **Acíclico (DAG)**: Sem ciclos - árvore de dependências

#### Terminologia Essencial

| Termo | Significado | Exemplo |
|-------|-------------|---------|
| **Vértice/Nó** | Entidade do grafo | Cidade, pessoa |
| **Aresta/Edge** | Conexão entre vértices | Estrada, amizade |
| **Grau** | Número de arestas de um vértice | 3 amigos = grau 3 |
| **Caminho** | Sequência de vértices conectados | A→B→C→D |
| **Ciclo** | Caminho que volta ao início | A→B→C→A |
| **Grafo Conexo** | Existe caminho entre todos pares | Mapa bem conectado |
| **Grafo Completo** | Todos vértices conectados | Kn tem n(n-1)/2 arestas |
| **Subgrafo** | Parte de um grafo | Uma região do mapa |

---

### 2. REPRESENTAÇÕES DE GRAFOS

#### Matriz de Adjacência

**Estrutura**: Array 2D de tamanho V×V

**Não-Ponderado**: `matrix[i][j] = 1` se existe aresta, 0 caso contrário  
**Ponderado**: `matrix[i][j] = peso` da aresta, ∞ se não existe

**Exemplo**:
```
Grafo: A→B(5), A→C(3), B→C(2)

     A  B  C
A  [ 0  5  3 ]
B  [ ∞  0  2 ]
C  [ ∞  ∞  0 ]
```

**Complexidades**:
- Espaço: **O(V²)** - sempre
- Verificar aresta: **O(1)**
- Listar vizinhos: **O(V)**
- Adicionar vértice: **O(V²)** - realoca matriz

**Quando Usar**:
✅ Grafo denso (muitas arestas: E ≈ V²)  
✅ Consultas frequentes "existe aresta (u,v)?"  
❌ Grafo esparso (desperdiça memória)  
❌ Grafos dinâmicos (adiciona/remove vértices)

---

#### Lista de Adjacência

**Estrutura**: Array de listas (ou HashMap)

**Implementação**:
- Array: `adj[i]` = lista de vizinhos de i
- HashMap: `adj.get(v)` = lista de vizinhos de v

**Exemplo**:
```
Grafo: A→B(5), A→C(3), B→C(2)

A: [(B,5), (C,3)]
B: [(C,2)]
C: []
```

**Complexidades**:
- Espaço: **O(V + E)** - proporcional às arestas
- Verificar aresta: **O(grau)** - percorre lista
- Listar vizinhos: **O(grau)** - direto
- Adicionar vértice: **O(1)**

**Quando Usar**:
✅ Grafo esparso (poucas arestas: E << V²)  
✅ Percursos (DFS, BFS) - itera vizinhos  
✅ Grafos dinâmicos  
❌ Consultas frequentes "existe aresta?"

---

#### Comparação Prática

| Aspecto | Matriz | Lista |
|---------|--------|-------|
| **Espaço (V=1000, E=5000)** | 1MB | 20KB |
| **Espaço (V=1000, E=500000)** | 1MB | 2MB |
| **Verificar aresta** | O(1) ⚡ | O(grau) |
| **Iterar vizinhos** | O(V) | O(grau) ⚡ |
| **Algoritmos típicos** | Floyd-Warshall | DFS, BFS, Dijkstra |

**Regra Geral**: Use lista de adjacência a menos que o grafo seja denso!

---

### 3. DFS (DEPTH-FIRST SEARCH)

#### Conceito Central

**DFS** = Vai fundo antes de explorar largura

**Analogia**: Explorar uma caverna
- Segue um túnel até o fim
- Quando beco sem saída, volta e tenta outro

#### Algoritmo

**Recursivo** (usa pilha implícita):
```
DFS(v):
    marca v como visitado
    para cada vizinho u de v:
        se u não visitado:
            DFS(u)
```

**Iterativo** (usa pilha explícita):
```
DFS(start):
    pilha = [start]
    enquanto pilha não vazia:
        v = pilha.pop()
        se v não visitado:
            marca v como visitado
            para cada vizinho u de v:
                pilha.push(u)
```

#### Ordem de Visitação

```
Grafo:  A―B―C
        │ │
        D―E

DFS(A): A → B → C → E → D
        (vai fundo por B antes de explorar D)
```

#### Complexidade

- **Tempo**: O(V + E)
    - Visita cada vértice: V
    - Explora cada aresta: E
- **Espaço**: O(V)
    - Recursão: profundidade da pilha
    - Iterativo: tamanho da pilha

#### Aplicações

1. **Detecção de Ciclos**: Back edge encontrado
2. **Ordenação Topológica**: Ordem de finalização reversa
3. **Componentes Conectados**: Conta DFS completas
4. **Encontrar Caminhos**: Rastreia predecessores
5. **Resolver Labirintos**: Backtracking

---

### 4. BFS (BREADTH-FIRST SEARCH)

#### Conceito Central

**BFS** = Explora por níveis (camadas)

**Analogia**: Ondas em lago
- Pedra cai (vértice inicial)
- Ondas se expandem em círculos
- Cada círculo = um nível

#### Algoritmo

```
BFS(start):
    fila = [start]
    marca start como visitado
    enquanto fila não vazia:
        v = fila.dequeue()
        para cada vizinho u de v:
            se u não visitado:
                marca u como visitado
                fila.enqueue(u)
```

#### Ordem de Visitação

```
Grafo:  A―B―C
        │ │
        D―E

BFS(A): A → B → D → C → E
        (explora nível 1 antes de nível 2)

Níveis:
Nível 0: A
Nível 1: B, D
Nível 2: C, E
```

#### Complexidade

- **Tempo**: O(V + E) - igual DFS
- **Espaço**: O(V) - tamanho da fila

#### Aplicações

1. **Menor Caminho (não-ponderado)**: BFS garante menor
2. **Distância entre vértices**: Níveis = distância
3. **Componentes Conectados**: Igual DFS
4. **Encontrar Vizinhança**: K níveis de distância
5. **Testes de Bipartição**: 2-coloração com BFS

#### DFS vs BFS

| Aspecto | DFS | BFS |
|---------|-----|-----|
| **Estrutura** | Pilha (stack) | Fila (queue) |
| **Exploração** | Profundidade | Largura |
| **Menor Caminho** | ❌ Não garante | ✅ Garante (não-ponderado) |
| **Memória** | Melhor (profundidade) | Pior (nível inteiro) |
| **Detecção Ciclos** | ✅ Sim | ✅ Sim |
| **Ordem Topológica** | ✅ Sim | ❌ Não |

---

### 5. ALGORITMO DE DIJKSTRA

#### Problema

Encontrar **menor caminho** de uma origem para todos os vértices em grafo **ponderado** com **pesos não-negativos**.

#### Ideia Central

**Greedy**: Sempre expande o vértice mais próximo conhecido

**Analogia**: Mancha de óleo se espalhando
- Óleo se espalha primeiro para pontos mais próximos
- Eventualmente cobre tudo, na ordem de distância

#### Algoritmo

```
Dijkstra(origem):
    dist[origem] = 0
    dist[outros] = ∞
    
    pq = priority_queue com (origem, 0)
    
    enquanto pq não vazia:
        (u, d) = pq.extractMin()
        
        se d > dist[u]:
            continua  // já processado com distância melhor
        
        para cada vizinho v de u com peso w:
            nova_dist = dist[u] + w
            se nova_dist < dist[v]:
                dist[v] = nova_dist
                pq.insert((v, nova_dist))
```

#### Exemplo Visual

```
Grafo:     5      1
       A ―――― B ―――― C
       │       │      │
     2 │       │ 3    │ 4
       │       │      │
       D ―――――― E ―――― F
           8        2

Dijkstra de A:
Passo 1: dist[A]=0, expande A
         → dist[B]=5, dist[D]=2

Passo 2: dist[D]=2, expande D (menor)
         → dist[E]=10

Passo 3: dist[B]=5, expande B
         → dist[C]=6, dist[E]=min(10,8)=8

Passo 4: dist[C]=6, expande C
         → dist[F]=10

Passo 5: dist[E]=8, expande E
         → dist[F]=min(10,10)=10

Resultado:
A→A: 0
A→B: 5
A→C: 6 (via B)
A→D: 2
A→E: 8 (via B)
A→F: 10 (via C ou E)
```

#### Complexidade

- **Com Priority Queue (Heap)**:
    - Tempo: **O((V + E) log V)**
    - Cada vértice: O(log V) para inserir
    - Cada aresta: O(log V) para decrease-key

- **Com Fibonacci Heap**:
    - Tempo: **O(E + V log V)** - teórico

#### Limitações

❌ **NÃO funciona com pesos negativos**
- Pode dar resposta errada
- Use Bellman-Ford para pesos negativos

---

### 6. ÁRVORE GERADORA MÍNIMA (MST)

#### Problema

Conectar todos os vértices com **menor custo total** usando subconjunto de arestas.

**Aplicações**:
- Rede elétrica: minimizar cabo
- Rede de computadores: minimizar latência
- Estradas: conectar cidades com menor asfalto

#### Propriedades MST

1. **Árvore**: V-1 arestas, sem ciclos
2. **Geradora**: Conecta todos os vértices
3. **Mínima**: Soma dos pesos é mínima

#### Algoritmo de Kruskal

**Ideia**: Ordena arestas, adiciona se não criar ciclo

**Algoritmo**:
```
Kruskal(G):
    Ordena arestas por peso crescente
    MST = conjunto vazio
    
    para cada aresta (u, v, w) em ordem:
        se u e v em componentes diferentes:
            adiciona (u,v) à MST
            une componentes de u e v
    
    retorna MST
```

**Estrutura de Dados**: Union-Find para detectar ciclos

**Complexidade**: O(E log E) - dominado pela ordenação

---

#### Algoritmo de Prim

**Ideia**: Começa com vértice, cresce árvore por aresta mínima

**Algoritmo**:
```
Prim(origem):
    MST = conjunto vazio
    visitados = {origem}
    
    pq = arestas saindo de origem
    
    enquanto |visitados| < V:
        (u, v, w) = pq.extractMin()
        
        se v não visitado:
            adiciona (u,v) à MST
            adiciona v aos visitados
            adiciona arestas de v à pq
    
    retorna MST
```

**Complexidade**: O(E log V) com heap binário

---

#### Kruskal vs Prim

| Aspecto | Kruskal | Prim |
|---------|---------|------|
| **Abordagem** | Global (ordena tudo) | Local (cresce árvore) |
| **Estrutura** | Union-Find | Priority Queue |
| **Melhor para** | Grafo esparso | Grafo denso |
| **Complexidade** | O(E log E) | O(E log V) |
| **Paralelização** | ✅ Fácil | ❌ Difícil |

---

### 7. COMPONENTES CONECTADOS

#### Grafo Não-Direcionado

**Componente**: Subgrafo onde existe caminho entre todos pares

**Algoritmo**: DFS ou BFS múltiplas vezes
```
contarComponentes():
    componentes = 0
    visitados = conjunto vazio
    
    para cada vértice v:
        se v não visitado:
            DFS(v)  // marca todos alcançáveis
            componentes++
    
    retorna componentes
```

**Complexidade**: O(V + E)

---

#### Grafo Direcionado - SCC

**Componente Fortemente Conectado (SCC)**: Subgrafo onde existe caminho em **ambas direções** entre todos pares

**Algoritmo de Kosaraju**:
1. DFS no grafo original → guarda ordem de finalização
2. Transpõe grafo (inverte arestas)
3. DFS no transposto, na ordem reversa do passo 1
4. Cada DFS do passo 3 = 1 SCC

**Complexidade**: O(V + E)

---

## 🌱 NÍVEL INICIANTE - EXERCÍCIOS {#nivel-iniciante}

### 📋 EXERCÍCIO 1: Implementar Grafo com Ambas Representações

**Objetivo**: Entender matriz vs lista

**Requisitos**:
1. Classe `GrafoMatriz`:
    - Array 2D para adjacência
    - Métodos: addAresta, removeAresta, temAresta, vizinhos

2. Classe `GrafoLista`:
    - HashMap ou Array de listas
    - Mesmos métodos

3. Compare:
    - Uso de memória
    - Tempo de operações

**Teste com**:
- Grafo esparso (10 vértices, 15 arestas)
- Grafo denso (10 vértices, 45 arestas)

**Aprenda**: Trade-offs de representação

---

### 📋 EXERCÍCIO 2: DFS Recursivo e Iterativo

**Objetivo**: Dominar DFS

**Requisitos**:
1. Implemente DFS recursivo
2. Implemente DFS iterativo (com stack)
3. Para ambos, retorne:
    - Ordem de visitação
    - Árvore DFS (predecessores)

**Teste com**:
```
Grafo:  0―1―2
        │ │
        3―4

DFS(0) deve visitar todos
```

**Aprenda**: DFS, recursão vs iteração

---

### 📋 EXERCÍCIO 3: BFS com Níveis

**Objetivo**: Implementar BFS correto

**Requisitos**:
1. BFS que retorna:
    - Ordem de visitação
    - Distância de cada vértice da origem
    - Predecessores (para reconstruir caminhos)

2. Método `menorCaminho(origem, destino)`:
    - Usa predecessores do BFS
    - Retorna lista de vértices no caminho

**Teste com**:
- Encontrar menor caminho entre vértices
- Verificar que BFS encontra caminho mínimo

**Aprenda**: BFS, menor caminho não-ponderado

---

### 📋 EXERCÍCIO 4: Detecção de Ciclos

**Objetivo**: Detectar ciclos em ambos tipos

**Requisitos**:
1. `temCicloNaoDirecionado()`:
    - DFS com controle de pai
    - Se encontrar vizinho visitado (não-pai) → ciclo

2. `temCicloDirecionado()`:
    - DFS com 3 cores (branco/cinza/preto)
    - Se encontrar vizinho cinza → ciclo

3. Retorne o ciclo encontrado, não só boolean

**Teste com**:
- Árvore (sem ciclos)
- Grafo com ciclo simples
- Grafo com múltiplos ciclos

**Aprenda**: Detecção de ciclos, cores em DFS

---

### 📋 EXERCÍCIO 5: Componentes Conectados

**Objetivo**: Analisar conectividade

**Requisitos**:
1. `contarComponentes()`: quantidade de componentes
2. `componenteDe(v)`: ID do componente de v
3. `mesmoCom ponente(u, v)`: verifica se estão conectados
4. `tamanhoComponente(id)`: vértices no componente

**Teste com**:
```
Grafo: 0―1   2―3―4
       Componente 1: {0,1}
       Componente 2: {2,3,4}
```

**Aprenda**: Componentes, DFS aplicado

---

### 📋 EXERCÍCIO 6: Verificar se é Árvore

**Objetivo**: Propriedades de árvore

**Requisitos**:
Método `ehArvore()` verifica:
1. Conexo (1 componente)
2. V-1 arestas
3. Sem ciclos

Implemente verificações eficientes

**Teste com**:
- Árvore válida
- Grafo desconexo
- Grafo com ciclo
- Grafo com muitas arestas

**Aprenda**: Propriedades de árvores em grafos

---

## 🌿 NÍVEL INTERMEDIÁRIO - EXERCÍCIOS {#nivel-intermediario}

### 📋 EXERCÍCIO 7: Dijkstra Completo

**Objetivo**: Implementar corretamente

**Requisitos**:
1. Dijkstra que retorna:
    - Array de distâncias
    - Array de predecessores
2. Método `menorCaminho(origem, destino)`:
    - Reconstrói caminho usando predecessores
3. Use Priority Queue (heap)

**Teste com**:
```
Grafo ponderado
Verificar que encontra caminhos mínimos
Testar com múltiplas origens
```

**Aprenda**: Dijkstra, menor caminho ponderado

---

### 📋 EXERCÍCIO 8: Bellman-Ford

**Objetivo**: Lidar com pesos negativos

**Requisitos**:
1. Implementar Bellman-Ford:
    - Relaxa todas arestas V-1 vezes
    - Detecta ciclos negativos

2. Se ciclo negativo:
    - Retorna null ou exceção
    - Informa quais vértices afetados

**Teste com**:
- Grafo sem ciclo negativo
- Grafo com ciclo negativo
- Comparar com Dijkstra onde ambos funcionam

**Aprenda**: Pesos negativos, ciclos negativos

---

### 📋 EXERCÍCIO 9: Floyd-Warshall

**Objetivo**: Todos os pares de caminhos mínimos

**Requisitos**:
1. Implementar Floyd-Warshall:
    - Matriz de distâncias V×V
    - DP: dist[i][j][k] = min via vértices 0..k

2. Retorna:
    - Matriz de distâncias
    - Matriz de predecessores (para caminhos)

3. Detecta ciclos negativos

**Teste com**:
- Grafo completo pequeno
- Recuperar caminhos entre pares
- Comparar com Dijkstra

**Aprenda**: DP em grafos, all-pairs shortest path

---

### 📋 EXERCÍCIO 10: Kruskal com Union-Find

**Objetivo**: MST eficiente

**Requisitos**:
1. Implementar Union-Find:
    - find com path compression
    - union by rank

2. Implementar Kruskal:
    - Ordena arestas
    - Usa Union-Find para ciclos

3. Retorna:
    - Conjunto de arestas da MST
    - Custo total

**Teste com**:
- Grafo não-conexo (deve detectar)
- Grafo conexo
- Verificar que MST tem V-1 arestas

**Aprenda**: MST, Union-Find

---

### 📋 EXERCÍCIO 11: Prim com Priority Queue

**Objetivo**: MST alternativo

**Requisitos**:
1. Implementar Prim:
    - Começa com vértice arbitrário
    - Priority queue de arestas

2. Compare com Kruskal:
    - Tempo de execução
    - Facilidade de implementação

**Teste com**:
- Grafos densos e esparsos
- Verificar que ambos dão mesmo custo

**Aprenda**: Prim, comparação de algoritmos

---

### 📋 EXERCÍCIO 12: Ordenação Topológica

**Objetivo**: DAG e dependências

**Requisitos**:
1. `ordenacaoTopologica()`:
    - DFS com ordem de finalização
    - Retorna ordem reversa

2. Detecta se grafo tem ciclo:
    - Se sim, retorna null

3. Aplicação:
    - Sistema de build (dependências)

**Teste com**:
- DAG válido (curso pré-requisitos)
- Grafo com ciclo (dependência circular)

**Aprenda**: Ordenação topológica, DAG

---

## 🌳 NÍVEL AVANÇADO - EXERCÍCIOS {#nivel-avancado}

### 📋 EXERCÍCIO 13: Ford-Fulkerson (Fluxo Máximo)

**Objetivo**: Rede de fluxo

**Requisitos**:
1. Implementar Ford-Fulkerson:
    - Grafo residual
    - BFS para caminho aumentante
    - Atualiza capacidades

2. Retorna:
    - Fluxo máximo
    - Grafo com fluxos em arestas

3. Aplicação:
    - Rede de distribuição

**Teste com**:
```
Rede com gargalos
Verificar corte mínimo = fluxo máximo
```

**Aprenda**: Fluxo em redes, max-flow min-cut

---

### 📋 EXERCÍCIO 14: TSP com Programação Dinâmica

**Objetivo**: Held-Karp algorithm

**Requisitos**:
1. TSP força bruta:
    - Só para n ≤ 10
    - Todas permutações

2. TSP com DP:
    - dp[mask][i] = menor custo para visitar vértices em mask terminando em i
    - O(n² × 2ⁿ)

3. Compare:
    - Qualidade (ambos ótimos)
    - Tempo

**Teste com**:
- 5, 8, 10, 12 cidades
- Medirque DP permite mais cidades

**Aprenda**: TSP, DP com bitmask

---

### 📋 EXERCÍCIO 15: Pontes e Pontos de Articulação

**Objetivo**: Vértices/arestas críticas

**Requisitos**:
1. `encontrarPontes()`:
    - Arestas cuja remoção desconecta grafo
    - Algoritmo de Tarjan

2. `encontrarArticulacoes()`:
    - Vértices cuja remoção desconecta

3. Aplicação:
    - Rede vulnerável

**Teste com**:
- Grafo com pontes
- Grafo 2-edge-connected (sem pontes)

**Aprenda**: Tarjan, conectividade

---

### 📋 EXERCÍCIO 16: Componentes Fortemente Conectados

**Objetivo**: SCCs em grafos direcionados

**Requisitos**:
1. Algoritmo de Kosaraju:
    - DFS no grafo original
    - Transpõe grafo
    - DFS no transposto

2. Retorna:
    - Lista de SCCs
    - Grafo condensado (SCCs como vértices)

3. Aplicação:
    - Análise de rede social

**Teste com**:
- Grafo com múltiplos SCCs
- Grafo fortemente conectado (1 SCC)

**Aprenda**: SCCs, Kosaraju

---

### 📋 EXERCÍCIO 17: Coloração de Grafos

**Objetivo**: Alocação de recursos

**Requisitos**:
1. Algoritmo guloso:
    - Ordena vértices
    - Atribui menor cor disponível

2. Backtracking:
    - Busca exaustiva para número cromático

3. Aplicação:
    - Agendamento de horários

**Teste com**:
- Grafo bipartido (2 cores)
- Grafo completo Kn (n cores)

**Aprenda**: Coloração, NP-completo

---

### 📋 EXERCÍCIO 18: Caminho Hamiltoniano

**Objetivo**: Visitar todos vértices uma vez

**Requisitos**:
1. Backtracking:
    - Tenta todos caminhos
    - Poda quando impossível

2. DP (para grafos pequenos):
    - Similar a TSP

3. Compare com Euleriano:
    - Caminho que usa todas arestas

**Teste com**:
- Grafos pequenos (≤10 vértices)
- Grafos que têm vs não têm caminho

**Aprenda**: Problemas NP, backtracking

---

## 🚀 PROJETOS INTEGRADORES {#projetos}

### PROJETO 1: Sistema de Navegação GPS (60-80h)

**Descrição**: App de rotas real

**Funcionalidades**:
1. **Mapa**:
    - Importar OSM (OpenStreetMap)
    - Grafo de ruas
    - Pesos = distância, tempo, trânsito

2. **Rotas**:
    - Dijkstra para menor caminho
    - A* com heurística (distância euclidiana)
    - Alternativas (2º e 3º melhores)

3. **Trânsito Dinâmico**:
    - Atualiza pesos em tempo real
    - Recalcula rota se necessário

4. **Visualização**:
    - Interface gráfica (JavaFX)
    - Desenha mapa e rota
    - Instruções turn-by-turn

5. **Otimizações**:
    - Contraction Hierarchies
    - Bidirectional search

**Tecnologias**:
- Java Core
- JavaFX para UI
- OSM para mapas
- JSON para dados

**Aprenda**: Grafos em app real, otimizações

---

### PROJETO 2: Análise de Rede Social (50-70h)

**Descrição**: Analisar grafo social

**Funcionalidades**:
1. **Construção**:
    - Importar rede (Twitter, Facebook API)
    - Grafo direcionado (seguidores)

2. **Métricas**:
    - Grau de centralidade
    - Betweenness centrality
    - PageRank
    - Clustering coefficient

3. **Comunidades**:
    - Detecção de comunidades (Louvain)
    - Visualização

4. **Caminhos**:
    - Menor caminho entre usuários
    - Grau de separação médio

5. **Influência**:
    - Usuários mais influentes
    - Propagação de informação

**Visualização**:
- GraphStream ou JGraphT
- Layout force-directed

**Aprenda**: Análise de redes, métricas sociais

---

## 📚 RECURSOS DE ESTUDO {#recursos}

### 📖 Livros

1. **"Introduction to Algorithms" - CLRS**
    - Capítulos: 22-26 (Grafos)
    - Teoria rigorosa

2. **"Algorithms" - Sedgewick**
    - Capítulos: 4.1-4.4
    - Implementações práticas

3. **"Networks, Crowds, and Markets" - Easley & Kleinberg**
    - Grafos em contexto social
    - Aplicações reais

### 🎓 Cursos

1. **Princeton - Algorithms Part II**
    - Weeks 1-3: Grafos
    - Assignments práticos

2. **Stanford CS161**
    - Grafos e algoritmos
    - Lectures online

### 🎥 YouTube

1. **William Fiset** - Graph Theory Playlist
2. **Abdul Bari** - Grafos
3. **MIT OCW 6.006**

### 🌐 Sites

1. **VisuAlgo** - Grafos
2. **Graph Online** - Desenhar e analisar
3. **OEIS** - Sequências em grafos

### 🏆 Prática

1. **LeetCode** - Graph tag
2. **Codeforces** - Graph problems
3. **SPOJ** - SHPATH, HIGHWAYS

---

## ✅ CHECKLIST {#checklist}

### Iniciante
- [ ] Implemento ambas representações
- [ ] Domino DFS e BFS
- [ ] Detecto ciclos
- [ ] Encontro componentes
- [ ] Verifico propriedades básicas

### Intermediário
- [ ] Implemento Dijkstra corretamente
- [ ] Entendo Bellman-Ford e pesos negativos
- [ ] Implemento MST (Kruskal e Prim)
- [ ] Faço ordenação topológica
- [ ] Analiso conectividade

### Avançado
- [ ] Implemento fluxo máximo
- [ ] Resolvo TSP com DP
- [ ] Encontro pontes e articulações
- [ ] Detecto SCCs
- [ ] Coloro grafos

**Grafos são fundamentais em CS - continue praticando! 🕸️**
# 🕸️ TRILHA 5: Teoria dos Grafos

## 🎯 **Analogia da Trilha**: O Mapa do Mundo

Grafos representam conexões no mundo real:
- **Redes sociais**: Pessoas conectadas por amizade
- **Mapas**: Cidades conectadas por estradas
- **Internet**: Computadores conectados por cabos
- **Moléculas**: Átomos conectados por ligações

---

## 🌱 **NÍVEL INICIANTE**

### 📋 **Exercício 1: O Mapa da Cidade (Representações)**

**🎭 Analogia**: Diferentes maneiras de desenhar um mapa da cidade - algumas mostram todas as conexões em uma tabela, outras mostram apenas as vizinhanças de cada local.

**🎨 Visualização**:
```
            🗺️ CIDADE COM 4 LOCAIS
    
    Grafo Visual:
         Casa ←→ Escola
          ↑       ↓
          ↓       ↓  
       Parque ←→ Shopping
    
    1. 📊 MATRIZ DE ADJACÊNCIA:
       Tabela mostrando todas conexões:
              Casa Escola Parque Shop
       Casa  [ 0     1      1     0  ]
      Escola [ 1     0      0     1  ]
      Parque [ 1     0      0     1  ]
       Shop  [ 0     1      1     0  ]
       
       ✅ Verificar conexão: O(1)
       ❌ Espaço: O(V²) - muito para grafos esparsos
    
    2. 📋 LISTA DE ADJACÊNCIA:
       Cada local lista seus vizinhos:
       Casa: [Escola, Parque]
       Escola: [Casa, Shopping]  
       Parque: [Casa, Shopping]
       Shopping: [Escola, Parque]
       
       ✅ Espaço: O(V + E) - eficiente
       ❌ Verificar conexão: O(grau)
```

**🛠️ Como Fazer**:
1. **Implemente matriz**: Array 2D booleano
2. **Implemente lista**: Array de listas
3. **Adicione vértices**: Expande estruturas
4. **Adicione arestas**: Atualiza ambas representações
5. **Compare uso memória**: Conte espaço usado vs número de conexões

### 📋 **Exercício 2: O Explorer da Cidade (Percursos)**

**🎭 Analogia**: Dois tipos de exploradores urbanos - um que vai sempre mais fundo (DFS) e outro que explora toda vizinhança antes de seguir adiante (BFS).

**🎨 Visualização**:
```
            🧭 EXPLORADORES DA CIDADE
    
    Mapa:    A ←→ B ←→ C
             ↕    ↕    ↕
             D ←→ E ←→ F
    
    🕳️ DFS - MERGULHADOR (vai fundo):
    Pilha de exploração:
    Início: [A]  
    1. A → visita B → [B, D]
    2. B → visita C → [C, E, D] 
    3. C → visita F → [F, D, E]
    4. F → visita E → [E, D]
    5. E → visita D → [D]
    6. D → fim → []
    
    Ordem visitação: A → B → C → F → E → D
    
    🌊 BFS - EXPANSOR (vai largo):
    Fila de exploração:
    Início: [A]
    1. A → adiciona vizinhos B,D → [B, D]
    2. B → adiciona vizinhos A,C,E → [D, C, E] (A já visitado)
    3. D → adiciona vizinho E → [C, E] (E duplicado, ignora)
    4. C → adiciona vizinho F → [E, F]
    5. E → sem novos → [F]  
    6. F → fim → []
    
    Ordem visitação: A → B → D → C → E → F
```

**🛠️ Como Fazer**:
1. **Implemente DFS recursivo**: Usa stack implícita
2. **Implemente DFS iterativo**: Usa stack explícita
3. **Implemente BFS**: Usa fila (queue)
4. **Marque visitados**: Evita ciclos infinitos
5. **Teste ambos**: Compare ordem de visitação

### 📋 **Exercício 3: O Detetive de Conexões (Detecção de Ciclos)**

**🎭 Analogia**: Um detetive que investiga se existe um caminho circular na cidade - você consegue sair de casa e voltar para casa sem repetir nenhuma rua?

**🎨 Visualização**:
```
            🕵️‍♂️ DETETIVE DE CICLOS
    
    Caso 1 - SEM CICLO (Árvore):
         A
        / \
       B   C
      /   / \
     D   E   F
    
    ✅ Não há caminho circular
    
    Caso 2 - COM CICLO:
         A ←→ B
         ↕    ↕
         D ←→ C
    
    🔄 Ciclo encontrado: A → B → C → D → A
    
    Algoritmo de Detecção (DFS):
    Cores dos nós:
    - ⚪ BRANCO: Não visitado
    - 🔵 AZUL: Visitando (na pilha DFS)  
    - ⚫ PRETO: Visitado completo
    
    Se durante DFS encontrar aresta para nó AZUL → CICLO!
    
    Para Grafos Não-Direcionados:
    Ciclo = encontrar aresta para nó já visitado
    (que não seja o pai direto)
```

**🛠️ Como Fazer**:
1. **Implemente para grafos direcionados**: 3 cores (branco/azul/preto)
2. **Implemente para não-direcionados**: Apenas visitado/não-visitado
3. **Use DFS modificado**: Detecta back-edges
4. **Teste casos**: Árvore, ciclo simples, múltiplos ciclos
5. **Retorne o ciclo**: Não só detecte, mas mostre qual é

---

## 🌿 **NÍVEL INTERMEDIÁRIO**

### 📋 **Exercício 1: O GPS Inteligente (Dijkstra)**

**🎭 Analogia**: Um GPS que sempre encontra o caminho mais rápido para qualquer destino, considerando trânsito, distância e velocidade das vias.

**🎨 Visualização**:
```
            🛣️ GPS INTELIGENTE (DIJKSTRA)
    
    Mapa com Tempos (minutos):
         A ──5── B ──1── C
         │       │       │
         2       3       4
         │       │       │  
         D ──8── E ──2── F
    
    Encontrar caminho mais rápido A → F:
    
    Passo a passo:
    1. Início: dist[A]=0, todos outros=∞
    2. Visita A: atualiza dist[B]=5, dist[D]=2
    3. Visita D (menor): dist[E]=2+8=10
    4. Visita B: dist[C]=5+1=6, dist[E]=min(10,5+3)=8
    5. Visita C: dist[F]=6+4=10
    6. Visita E: dist[F]=min(10,8+2)=10
    7. Chegou em F!
    
    Caminho ótimo: A → B → E → F (tempo: 10 min)
    
    📊 Estrutura de Dados:
    - Fila de prioridade: próximo nó a visitar
    - Array distâncias: menor tempo até cada nó
    - Array predecessores: para reconstruir caminho
```

**🛠️ Como Fazer**:
1. **Use fila de prioridade**: MinHeap para escolher próximo nó
2. **Mantenha distâncias**: Array com menor distância conhecida
3. **Relaxe arestas**: Atualiza distância se encontrou caminho melhor
4. **Reconstroi caminho**: Usa array de predecessores
5. **Teste casos**: Múltiplos caminhos, nós isolados

### 📋 **Exercício 2: A Rede Elétrica (Árvore Geradora Mínima)**

**🎭 Analogia**: Uma empresa elétrica quer conectar todas as casas de uma cidade gastando o mínimo de cabo possível. Precisa encontrar a rede mais econômica que conecte todos.

**🎨 Visualização**:
```
            ⚡ REDE ELÉTRICA MÍNIMA
    
    Cidade com custos de cabo (em km):
         A ──4── B ──8── C
         │   │   │       │
         2   1   2       7  
         │   │   │       │
         D ──5── E ──9── F
    
    🌲 ALGORITMO DE KRUSKAL:
    1. Ordena arestas por peso: 1,2,2,4,5,7,8,9
    2. A-D (custo 1): adiciona ✅
    3. B-E (custo 2): adiciona ✅  
    4. A-D (custo 2): adiciona ✅
    5. A-B (custo 4): adiciona ✅
    6. D-E (custo 5): criaria ciclo ❌
    7. C-F (custo 7): adiciona ✅
    8. Para quando tem V-1 arestas
    
    🌲 ALGORITMO DE PRIM:
    1. Começa com A
    2. Menor aresta conectada: A-E (2) → adiciona E
    3. Menor aresta A/E: E-B (2) → adiciona B  
    4. Menor aresta A/E/B: A-B (4) → adiciona
    5. Continua até conectar todos
    
    Resultado: Rede de custo mínimo = 15 km
```

**🛠️ Como Fazer**:
1. **Implemente Kruskal**: Ordena arestas + Union-Find para ciclos
2. **Implemente Prim**: Começa com vértice + cresce árvore
3. **Use Union-Find**: Estrutura para detectar ciclos eficientemente
4. **Compare algoritmos**: Quando usar cada um?
5. **Teste grafos grandes**: Performance em grafos densos vs esparsos

### 📋 **Exercício 3: As Comunidades (Componentes Conectados)**

**🎭 Analogia**: Analisar uma rede social para descobrir grupos de amigos que se conhecem entre si, mas não conhecem pessoas de outros grupos.

**🎨 Visualização**:
```
            👥 ANÁLISE DE COMUNIDADES
    
    Rede Social:
    Grupo 1: A ←→ B ←→ C     Grupo 2: E ←→ F
             ↕       ↕               ↕
             D ←───→ C               G
    
    🔍 ALGORITMO:
    1. DFS a partir de A: encontra {A,B,C,D}
    2. DFS a partir de E: encontra {E,F,G}  
    3. Todos visitados → 2 componentes
    
    Para Grafos Direcionados (Componentes Fortemente Conectados):
    Algoritmo de Kosaraju:
    1. DFS no grafo original → ordem de finalização
    2. DFS no grafo transposto (arestas invertidas)
    3. Cada DFS no passo 2 = um componente
    
    Aplicações:
    📱 Redes sociais: grupos de amigos
    🌐 Web: páginas que se referenciam mutuamente
    🧬 Biologia: cadeias de reações químicas
    💰 Economia: mercados conectados
```

**🛠️ Como Fazer**:
1. **Implemente para não-direcionados**: DFS simples
2. **Implemente Kosaraju**: Para grafos direcionados
3. **Conte componentes**: Quantos grupos isolados?
4. **Analise tamanhos**: Maior componente tem quantos nós?
5. **Visualize resultado**: Colorir nós por componente

---

## 🌳 **NÍVEL AVANÇADO**

### 📋 **Exercício 1: A Rede de Água (Fluxo Máximo)**

**🎭 Analogia**: Uma rede de canos conectando uma fonte de água a um destino. Cada cano tem capacidade limitada. Qual o máximo de água que pode fluir da fonte ao destino?

**🎨 Visualização**:
```
            💧 REDE DE DISTRIBUIÇÃO DE ÁGUA
    
    Rede com capacidades:
         ┌─ 20 ─→ B ─ 10 ─┐
    S ─→ ┤               ├ ─→ T
         └─ 10 ─→ C ─ 20 ─┘
    
    🌊 ALGORITMO FORD-FULKERSON:
    
    Iteração 1: Caminho S→B→T
    - Capacidade mínima: min(20,10) = 10
    - Fluxo enviado: 10
    - Capacidades restantes: S→B(10), B→T(0)
    
    Iteração 2: Caminho S→C→T  
    - Capacidade mínima: min(10,20) = 10
    - Fluxo enviado: 10
    - Capacidades restantes: S→C(0), C→T(10)
    
    Total: Fluxo máximo = 20 unidades/segundo
    
    Grafo Residual (capacidades restantes):
         ┌─ 10 ─→ B ─ 0 ─┐
         │    ↓ 10       │
    S ─→ ┤              ├ ─→ T
         │    ↑ 10       │
         └─ 0 ─→ C ─ 10 ─┘
    
    Aplicações:
    🚰 Distribuição de água/energia
    🚗 Fluxo de tráfego otimizado
    📦 Logística e distribuição
    💻 Redes de computadores
```

**🛠️ Como Fazer**:
1. **Implemente busca de caminhos**: BFS para encontrar caminho aumentante
2. **Construa grafo residual**: Capacidades restantes após cada iteração
3. **Implemente Edmonds-Karp**: Ford-Fulkerson com BFS
4. **Calcule corte mínimo**: Teorema max-flow min-cut
5. **Teste casos práticos**: Redes com gargalos, múltiplos caminhos

### 📋 **Exercício 2: O Vendedor Viajante (TSP)**

**🎭 Analogia**: Um vendedor precisa visitar todas as cidades de sua região exatamente uma vez e retornar ao ponto de partida, gastando o mínimo possível em combustível.

**🎨 Visualização**:
```
            🚗 VENDEDOR VIAJANTE (TSP)
    
    4 Cidades com distâncias (km):
         A ──100── B
         │ \     / │
        50  80  60 120
         │   \ /   │
         C ──40── D
    
    Todas as possibilidades (3! = 6 rotas):
    1. A→B→C→D→A: 100+60+40+50 = 250 km
    2. A→B→D→C→A: 100+120+40+50 = 310 km  
    3. A→C→B→D→A: 50+60+120+50 = 280 km
    4. A→C→D→B→A: 50+40+120+100 = 310 km
    5. A→D→B→C→A: 50+120+60+50 = 280 km ← Melhor!
    6. A→D→C→B→A: 50+40+60+100 = 250 km ← Também!
    
    📈 Crescimento Explosivo:
    4 cidades → 6 rotas
    10 cidades → 181.440 rotas
    15 cidades → 43 bilhões de rotas! 💥
    
    🧠 ESTRATÉGIAS:
    
    1. 🔄 Força Bruta: Testa todas → O(n!)
    2. 🎯 Algoritmo Guloso: Sempre vai para mais próxima
    3. 🧬 Algoritmo Genético: Evolução de soluções  
    4. 🌡️ Simulated Annealing: "Resfriamento" gradual
    5. 💡 Programação Dinâmica: O(n²2ⁿ) - melhor que força bruta
```

**🛠️ Como Fazer**:
1. **Implemente força bruta**: Todas permutações (só para n≤10)
2. **Implemente algoritmo guloso**: Heurística rápida mas não ótima
3. **Implemente programação dinâmica**: Held-Karp algorithm
4. **Compare qualidade vs tempo**: Quando usar cada abordagem?
5. **Teste dados reais**: Coordenadas de cidades brasileiras

### 📋 **Exercício 3: O Pintor de Mapas (Coloração de Grafos)**

**🎭 Analogia**: Um cartógrafo que precisa colorir um mapa usando o mínimo de cores possível, garantindo que países vizinhos tenham cores diferentes.

**🎨 Visualização**:
```
            🎨 COLORAÇÃO DE MAPAS
    
    Mapa (países vizinhos conectados):
         A ←→ B ←→ C
         ↕    ↕    ↕
         D ←→ E ←→ F
    
    Tentativa com 3 cores:
    A=🔴, B=🟢, C=🔴 (OK, A e C não são vizinhos)
    D=🟢 (vizinho de A🔴), E=🔴 (vizinho de B🟢,D🟢)
    F=🟢 (vizinho de C🔴,E🔴)
    
    ✅ Conseguiu com 3 cores!
    
    Aplicações Práticas:
    📅 Alocação de horários: 
    - Nós = disciplinas
    - Arestas = conflito (mesmo professor/sala)
    - Cores = horários disponíveis
    
    📡 Frequências de rádio:
    - Nós = antenas  
    - Arestas = interferência
    - Cores = frequências
    
    🧩 Sudoku:
    - Nós = células
    - Arestas = mesma linha/coluna/quadrante
    - Cores = números 1-9
```

**🛠️ Como Fazer**:
1. **Implemente algoritmo guloso**: Ordena vértices + colore sequencialmente
2. **Teste diferentes ordenações**: Por grau, aleatória, etc.
3. **Implemente backtracking**: Para coloração ótima (grafos pequenos)
4. **Aplique em problemas reais**: Alocação de recursos
5. **Analise resultados**: Número cromático vs heurísticas

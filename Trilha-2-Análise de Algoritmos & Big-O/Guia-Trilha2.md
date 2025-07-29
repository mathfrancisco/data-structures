# ⚡ TRILHA 2: Análise de Algoritmos & Big-O

## 🎯 **Analogia da Trilha**: A Eficiência da Cozinha

Imagine diferentes maneiras de preparar um jantar para convidados:
- **O(1)**: Pegar um refrigerante da geladeira - sempre demora o mesmo tempo
- **O(n)**: Descascar batatas - mais batatas = mais tempo proporcionalmente
- **O(n²)**: Comparar gostos de cada convidado com todos os outros - cresce muito rápido!

---

## 🌱 **NÍVEL INICIANTE**

### 📋 **Exercício 1: O Teste da Velocidade (Complexidade Simples)**

**🎭 Analogia**: Um velocímetro que mede diferentes tipos de "velocidade" de algoritmos, como um carro que pode ir a 50km/h, 100km/h ou acelerar gradualmente.

**🎨 Visualização**:
```
           VELOCÍMETROS DE ALGORITMOS
    
    🚗 CONSTANTE O(1) - Sempre igual
    ┌─────────────────────────┐
    │    Velocidade: 50 km/h  │ ← Sempre 50, não importa a distância
    └─────────────────────────┘
    
    🚚 LINEAR O(n) - Proporcional
    ┌─────────────────────────┐
    │  1 km = 1 minuto        │
    │  2 km = 2 minutos       │ ← Cresce proporcionalmente
    │  3 km = 3 minutos       │
    └─────────────────────────┘
    
    🐌 QUADRÁTICO O(n²) - Cresce rápido!
    ┌─────────────────────────┐
    │  1 item = 1 segundo     │
    │  2 itens = 4 segundos   │ ← 2² = 4
    │  3 itens = 9 segundos   │ ← 3² = 9
    │  4 itens = 16 segundos  │ ← 4² = 16
    └─────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Identifique padrões**: Quantas operações para cada entrada?
2. **Conte loops**: Um loop = O(n), dois aninhados = O(n²)
3. **Ignore constantes**: O(2n) = O(n), O(n + 5) = O(n)
4. **Meça na prática**: Cronômetro diferentes tamanhos de entrada
5. **Compare resultados**: Teoria vs prática

### 📋 **Exercício 2: A Corrida dos Algoritmos (Loops e Performance)**

**🎭 Analogia**: Uma corrida onde diferentes corredores (algoritmos) têm estratégias diferentes. Alguns mantêm ritmo constante, outros aceleram conforme a distância.

**🎨 Visualização**:
```
                    🏁 LINHA DE LARGADA
    👨‍💼 O(1) - Flash     │ Sempre chega em 1 segundo
    🚶‍♂️ O(n) - Caminhante │ 1 segundo por elemento  
    🏃‍♂️ O(log n) - Saltos │ Divide distância pela metade
    🐌 O(n²) - Caracol    │ Passo cada vez mais lento

    Distância: 100 elementos
    ┌─────────┬─────────┬─────────┬─────────┐
    │ Flash   │ Caminha │ Saltos  │ Caracol │
    │ 1 seg   │ 100 seg │ 7 seg   │10.000s  │
    └─────────┴─────────┴─────────┴─────────┘
    
    Distância: 1000 elementos  
    ┌─────────┬─────────┬─────────┬─────────┐
    │ Flash   │ Caminha │ Saltos  │ Caracol │
    │ 1 seg   │1000 seg │ 10 seg  │1.000.000s│
    └─────────┴─────────┴─────────┴─────────┘
```

**🛠️ Como Fazer**:
1. **Crie diferentes algoritmos**: Um para cada complexidade
2. **Meça tempos reais**: Use System.currentTimeMillis()
3. **Varie tamanho entrada**: 100, 1000, 10000 elementos
4. **Plote gráfico**: Visualize como tempo cresce
5. **Analise padrões**: Confirme teoria com prática

### 📋 **Exercício 3: O Laboratório de Medição (Instrumentação)**

**🎭 Analogia**: Um laboratório científico que mede precisamente quanto tempo e recursos cada experimento (algoritmo) consome.

**🎨 Visualização**:
```
            🔬 LABORATÓRIO DE MEDIÇÃO
    ┌─────────────────────────────────────────┐
    │  Experimento: "Buscar nome em lista"    │
    ├─────────────────────────────────────────┤
    │  📊 Instrumentos:                       │
    │  ⏱️  Cronômetro: mede tempo             │
    │  🧠 Monitor RAM: mede memória           │
    │  🔄 Contador: conta operações           │
    ├─────────────────────────────────────────┤
    │  📈 Resultados:                         │
    │  ┌─────────┬──────────┬─────────────┐   │
    │  │Tamanho  │ Tempo    │ Operações   │   │
    │  ├─────────┼──────────┼─────────────┤   │
    │  │   100   │   5ms    │     50      │   │
    │  │  1000   │  45ms    │    500      │   │
    │  │ 10000   │ 450ms    │   5000      │   │
    │  └─────────┴──────────┴─────────────┘   │
    │  📊 Conclusão: O(n) - Linear!          │
    └─────────────────────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Prepare experimentos**: Diferentes tamanhos de dados
2. **Instrumente código**: Adicione medições nos pontos certos
3. **Execute múltiplas vezes**: Média de várias execuções
4. **Registre dados**: Tabela com tamanho vs tempo
5. **Interprete resultados**: Identifique o padrão de crescimento

---

## 🌿 **NÍVEL INTERMEDIÁRIO**

### 📋 **Exercício 1: A Matriz do Tempo (Loops Aninhados)**

**🎭 Analogia**: Uma fábrica com esteiras transportadoras em duas dimensões. Para verificar cada produto, você precisa percorrer toda a grade - linha por linha, coluna por coluna.

**🎨 Visualização**:
```
                    🏭 FÁBRICA DE MATRIZES
    
    Matriz 3x3 (9 elementos):
    ┌─────┬─────┬─────┐  ← Loop externo: 3 iterações
    │ (0,0)│ (0,1)│ (0,2)│
    ├─────┼─────┼─────┤
    │ (1,0)│ (1,1)│ (1,2)│  ← Para cada linha...
    ├─────┼─────┼─────┤
    │ (2,0)│ (2,1)│ (2,2)│
    └─────┴─────┴─────┘
         ↑
    Loop interno: 3 iterações por linha
    Total: 3 × 3 = 9 operações = O(n²)
    
    Crescimento:
    2x2 = 4 operações
    3x3 = 9 operações  
    4x4 = 16 operações ← Cresce quadraticamente!
    10x10 = 100 operações
```

**🛠️ Como Fazer**:
1. **Crie matrizes diferentes**: 2x2, 5x5, 10x10, 100x100
2. **Implemente algoritmo**: Dois loops aninhados
3. **Conte operações**: Variável contador dentro dos loops
4. **Meça tempo**: Cronômetro para cada tamanho
5. **Compare crescimento**: n² vs medição real

### 📋 **Exercício 2: A Torre de Fibonacci (Recursão vs Iteração)**

**🎭 Analogia**: Duas maneiras de subir uma montanha:
- **Recursão**: Dividir em etapas menores, mas repetir muito trabalho
- **Iteração**: Ir passo a passo, lembrando do caminho já percorrido

**🎨 Visualização**:
```
            🏔️ MONTANHA DE FIBONACCI
    
    Recursão Simples (ineficiente):
                    fib(5)
                   /      \
               fib(4)      fib(3)
              /     \      /     \
          fib(3)  fib(2) fib(2) fib(1)
         /    \   /   \   /   \
      fib(2) fib(1) ... ... ... 
    ↑ Muito trabalho repetido! O(2ⁿ)
    
    Iteração (eficiente):
    Passo 1: a=0, b=1
    Passo 2: a=1, b=1  
    Passo 3: a=1, b=2
    Passo 4: a=2, b=3
    Passo 5: a=3, b=5 ← Resultado!
    ↑ Cada número calculado uma vez só! O(n)
    
    📊 Comparação para fib(40):
    Recursão: ~2 segundos
    Iteração: ~0,001 segundos (2000x mais rápido!)
```

**🛠️ Como Fazer**:
1. **Implemente ambas versões**: Recursiva e iterativa
2. **Meça para números pequenos**: fib(10), fib(20), fib(30)
3. **Observe crescimento**: Quando recursão fica lenta?
4. **Adicione memorização**: Cache para recursão
5. **Compare todas**: Recursão, iteração, memorização

### 📋 **Exercício 3: A Batalha dos Ordenadores (Algoritmos de Ordenação)**

**🎭 Analogia**: Uma competição entre diferentes métodos de organizar uma pilha de cartas. Cada competidor tem sua própria estratégia.

**🎨 Visualização**:
```
            🎯 ARENA DOS ORDENADORES
    
    🥊 BUBBLE SORT - O Persistente
    ┌─────────────────────────────────┐
    │ [3,1,4,2] → [1,3,4,2] → ...    │ Troca vizinhos
    │ Sempre termina, mas é lento     │ O(n²)
    │ Melhor caso: O(n) (já ordenado) │
    └─────────────────────────────────┘
    
    🏃‍♂️ QUICK SORT - O Esperto  
    ┌─────────────────────────────────┐
    │ Escolhe pivô: [3,1,4,2] → 3     │ Divide e conquista
    │ Menores à esquerda: [1,2|3|4]   │ O(n log n)
    │ Pior caso: O(n²) (má sorte)     │
    └─────────────────────────────────┘
    
    🤖 MERGE SORT - O Consistente
    ┌─────────────────────────────────┐
    │ Divide: [3,1,4,2] → [3,1][4,2]  │ Sempre O(n log n)
    │ Conquista: [1,3] + [2,4]        │ Nunca decepciona
    │ Merge: [1,2,3,4]                │
    └─────────────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Implemente 3 algoritmos**: Bubble, Quick, Merge Sort
2. **Teste cenários diferentes**:
    - Dados aleatórios
    - Já ordenados
    - Ordem reversa
3. **Meça performance**: Tempo para 1K, 10K, 100K elementos
4. **Analise comportamento**: Melhor/médio/pior caso
5. **Documente descobertas**: Quando usar cada um?

---

## 🌳 **NÍVEL AVANÇADO**

### 📋 **Exercício 1: O Mestre da Multiplicação (Algoritmo de Strassen)**

**🎭 Analogia**: Um matemático genial que descobriu uma forma mais inteligente de multiplicar matrizes grandes, usando menos operações que o método tradicional.

**🎨 Visualização**:
```
        🧮 MULTIPLICAÇÃO DE MATRIZES
    
    Método Tradicional O(n³):
    Para matriz 2x2: 8 multiplicações
    ┌─────┬─────┐   ┌─────┬─────┐   
    │ a   │ b   │ × │ e   │ f   │ = 8 operações
    ├─────┼─────┤   ├─────┼─────┤   
    │ c   │ d   │   │ g   │ h   │   
    └─────┴─────┘   └─────┴─────┘   
    
    🎓 Método Strassen O(n^2.807):
    Para matriz 2x2: apenas 7 multiplicações!
    P1 = a(f-h)     P5 = (a+d)(e+h)
    P2 = (a+b)h     P6 = (b-d)(g+h)  
    P3 = (c+d)e     P7 = (a-c)(e+f)
    P4 = d(g-e)
    
    📊 Economia:
    2x2: 8 vs 7 operações (12% melhor)
    1000x1000: Bilhões de operações poupadas!
```

**🛠️ Como Fazer**:
1. **Entenda o algoritmo**: Estude as 7 fórmulas de Strassen
2. **Implemente recursivamente**: Divide matriz em blocos
3. **Compare com tradicional**: Matrizes 2x2, 4x4, 8x8...
4. **Meça ponto de equilíbrio**: Quando Strassen fica melhor?
5. **Analise complexidade**: Confirme O(n^2.807) na prática

### 📋 **Exercício 2: O ArrayList Inteligente (Análise Amortizada)**

**🎭 Analogia**: Uma estante que dobra de tamanho quando fica cheia. Às vezes é caro expandir, mas no geral é muito eficiente.

**🎨 Visualização**:
```
            📚 ESTANTE DINÂMICA
    
    Capacidade inicial: 4 livros
    ┌─────┬─────┬─────┬─────┐
    │ 📖  │ 📖  │ 📖  │ 📖  │ ← Cheia!
    └─────┴─────┴─────┴─────┘
    
    Adicionar 5º livro → EXPANSÃO (caro!)
    ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐
    │ 📖  │ 📖  │ 📖  │ 📖  │ 📖  │     │     │     │
    └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
    ↑ Copiou 4 + adicionou 1 = 5 operações
    
    Próximos 3 livros: baratos (1 operação cada)
    ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐
    │ 📖  │ 📖  │ 📖  │ 📖  │ 📖  │ 📖  │ 📖  │ 📖  │
    └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
    
    📊 Análise Amortizada:
    8 inserções = 5 + 1 + 1 + 1 = 8 operações
    Média = 8/8 = 1 operação por inserção = O(1)!
```

**🛠️ Como Fazer**:
1. **Implemente array dinâmico**: Dobra tamanho quando necessário
2. **Rastreie operações**: Conte cópias vs inserções simples
3. **Calcule custo amortizado**: Total de operações / total de inserções
4. **Varie estratégias**: Dobrar vs aumentar 50% vs tamanho fixo
5. **Prove O(1) amortizado**: Matemática por trás do resultado

### 📋 **Exercício 3: O Problema do Caixeiro (NP-Completo)**

**🎭 Analogia**: Um vendedor que precisa visitar todas as cidades exatamente uma vez e voltar ao início, gastando o menor combustível possível. Problema "fácil" de entender, mas difícil de resolver!

**🎨 Visualização**:
```
        🗺️ PROBLEMA DO CAIXEIRO VIAJANTE
    
    Apenas 4 cidades = 6 rotas possíveis:
         A ──5── B
         │ \   / │
         3   2 4  7
         │   X   │ 
         C ──6── D
    
    Todas as possibilidades:
    A→B→C→D→A: 5+4+6+3 = 18
    A→B→D→C→A: 5+7+6+3 = 21  
    A→C→B→D→A: 3+4+7+3 = 17 ← Melhor!
    A→C→D→B→A: 3+6+7+5 = 21
    A→D→B→C→A: 3+7+4+3 = 17 ← Também!
    A→D→C→B→A: 3+6+4+5 = 18
    
    📈 Crescimento Explosivo:
    4 cidades → 6 rotas
    5 cidades → 24 rotas  
    10 cidades → 181.440 rotas
    20 cidades → 60 bilhões de rotas! 💥
```

**🛠️ Como Fazer**:
1. **Implemente força bruta**: Todas as permutações possíveis
2. **Implemente algoritmo guloso**: Sempre vai para cidade mais próxima
3. **Implemente programação dinâmica**: Memorização de subproblemas
4. **Compare qualidade**: Ótimo vs aproximações
5. **Meça limite prático**: Quantas cidades em tempo razoável?

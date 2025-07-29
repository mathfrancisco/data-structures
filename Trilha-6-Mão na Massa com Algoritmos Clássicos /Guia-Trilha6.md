# 🧮 TRILHA 6: Algoritmos Clássicos

## 🎯 **Analogia da Trilha**: A Caixa de Ferramentas do Especialista

Como um artesão experiente que tem a ferramenta certa para cada trabalho:
- **Ordenação**: Organizando uma biblioteca
- **Busca**: Encontrando agulha no palheiro
- **Programação Dinâmica**: Resolvendo problemas grandes quebrando em pedaços
- **Algoritmos Gulosos**: Fazendo sempre a melhor escolha local

---

## 🌱 **NÍVEL INICIANTE**

### 📋 **Exercício 1: A Corrida dos Organizadores (Algoritmos de Busca)**

**🎭 Analogia**: Duas pessoas procurando um livro - uma folheia página por página (busca linear), outra sempre abre no meio e decide para que lado ir (busca binária).

**🎨 Visualização**:
```
            📚 PROCURANDO O LIVRO "JAVA"
    
    Biblioteca com 1000 livros ordenados alfabeticamente:
    
    🐌 BUSCA LINEAR:
    [A...] [B...] [C...] ... [J-JAVA!] ... [Z...]
     ↑ 1    ↑ 2    ↑ 3        ↑ 500         ↑ 1000
    
    Pior caso: 1000 comparações
    Caso médio: 500 comparações
    
    🚀 BUSCA BINÁRIA:
    Passo 1: Meio = 500 (livro "M")
             "JAVA" < "M" → vai para esquerda
    
    Passo 2: Meio = 250 (livro "F")  
             "JAVA" > "F" → vai para direita
    
    Passo 3: Meio = 375 (livro "I")
             "JAVA" > "I" → vai para direita
             
    Passo 4: Meio = 437 (livro "J")
             "JAVA" = "J..." → ENCONTROU!
    
    Total: apenas 4 comparações! 🎯
    
    📊 Comparação:
    1.000 livros: Linear=500, Binária=10
    1.000.000 livros: Linear=500.000, Binária=20
```

**🛠️ Como Fazer**:
1. **Implemente busca linear**: Loop simples, compara cada elemento
2. **Implemente busca binária**: Divide array pela metade recursivamente
3. **Pré-requisito binária**: Array deve estar ordenado!
4. **Conte comparações**: Instrumente para medir operações
5. **Teste performance**: Diferentes tamanhos de array

### 📋 **Exercício 2: O Concurso de Organização (Ordenação Simples)**

**🎭 Analogia**: Três pessoas organizando uma pilha de cartas, cada uma com sua própria técnica - uma compara vizinhos (Bubble), outra procura o menor (Selection), e a terceira insere na posição certa (Insertion).

**🎨 Visualização**:
```
            🃏 CONCURSO DE ORDENAÇÃO
    
    Cartas iniciais: [5, 2, 8, 1, 9]
    
    🫧 BUBBLE SORT - O Persistente:
    Pass 1: [2,5,1,8,9] → troca 5↔2, 5↔1, 8↔9 
    Pass 2: [2,1,5,8,9] → troca 5↔1
    Pass 3: [1,2,5,8,9] → troca 2↔1
    Pass 4: [1,2,5,8,9] → sem trocas, terminou!
    
    "Bolhas" maiores sobem para o final
    
    🎯 SELECTION SORT - O Selecionador:
    Pass 1: Procura menor (1) → [1|5,2,8,9]
    Pass 2: Procura menor de [5,2,8,9] → [1,2|5,8,9]  
    Pass 3: Procura menor de [5,8,9] → [1,2,5|8,9]
    Pass 4: Procura menor de [8,9] → [1,2,5,8|9]
    
    Sempre encontra o mínimo restante
    
    🎴 INSERTION SORT - O Inseridor:
    Mão esquerda ordenada, direita desordenada:
    [5|2,8,1,9] → insere 2: [2,5|8,1,9]
    [2,5|8,1,9] → insere 8: [2,5,8|1,9]  
    [2,5,8|1,9] → insere 1: [1,2,5,8|9]
    [1,2,5,8|9] → insere 9: [1,2,5,8,9]
```

**🛠️ Como Fazer**:
1. **Implemente os 3 algoritmos**: Bubble, Selection, Insertion
2. **Analise cada passo**: Visualize como cada um trabalha
3. **Conte operações**: Quantas comparações e trocas?
4. **Teste casos especiais**: Já ordenado, ordem reversa, duplicatas
5. **Compare performance**: Qual é melhor em que situação?

### 📋 **Exercício 3: A Sequência Mágica (Fibonacci)**

**🎭 Analogia**: Uma sequência mágica onde cada número é a soma dos dois anteriores - como coelhos se reproduzindo, onde cada casal gera um novo casal a cada mês.

**🎨 Visualização**:
```
            🐰 REPRODUÇÃO DOS COELHOS (FIBONACCI)
    
    Mês 1: 🐰🐰 (1 casal jovem)
    Mês 2: 🐰🐰 (1 casal ainda jovem)  
    Mês 3: 🐰🐰 + 👶👶 (1 adulto + 1 jovem = 2 casais)
    Mês 4: 🐰🐰 + 👶👶 + 👶👶 (2 adultos + 1 jovem = 3 casais)
    Mês 5: 🐰🐰 🐰🐰 + 👶👶 👶👶 👶👶 (3 adultos + 2 jovens = 5 casais)
    
    Sequência: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...
                ↑  ↑  ↑
               F(1)+F(2)=F(3)
    
    🐌 RECURSÃO SIMPLES (ineficiente):
                    fib(5)
                   /      \
               fib(4)      fib(3)
              /     \      /     \
          fib(3)  fib(2) fib(2) fib(1)
         /    \   
      fib(2) fib(1)
    
    ↑ Muito trabalho repetido! fib(2) calculado 3 vezes!
    
    🚀 VERSÃO ITERATIVA (eficiente):
    a=0, b=1
    Para i=2 até n:
        c = a + b
        a = b  
        b = c
    
    ⏰ Comparação fib(40):
    Recursão: ~2 segundos
    Iteração: 0,001 segundos
```

**🛠️ Como Fazer**:
1. **Implemente versão recursiva**: Definição matemática direta
2. **Implemente versão iterativa**: Loop simples, mais eficiente
3. **Adicione memorização**: Cache para recursão
4. **Meça tempos**: Quando recursão fica impraticável?
5. **Explore aplicações**: Natureza, arte, arquitetura

---

## 🌿 **NÍVEL INTERMEDIÁRIO**

### 📋 **Exercício 1: Os Mestres da Velocidade (Ordenação Eficiente)**

**🎭 Analogia**: Três especialistas em organização que usam técnicas avançadas - um divide o trabalho (Merge), outro usa um pivô inteligente (Quick), e o terceiro usa uma pirâmide (Heap).

**🎨 Visualização**:
```
            ⚡ ALGORITMOS AVANÇADOS DE ORDENAÇÃO
    
    🔀 MERGE SORT - O Organizador Sistemático:
    Array: [38,27,43,3,9,82,10]
    
    Divide:      [38,27,43,3] | [9,82,10]
    Divide mais: [38,27][43,3] | [9,82][10]
    Divide mais: [38][27][43][3] | [9][82][10]
    
    Conquista:   [27,38][3,43] | [9,82][10]
    Conquista:   [3,27,38,43] | [9,10,82]
    Conquista:   [3,9,10,27,38,43,82] ✅
    
    ✅ Sempre O(n log n), estável
    ❌ Usa O(n) memória extra
    
    ⚡ QUICK SORT - O Estrategista:
    Array: [38,27,43,3,9,82,10]
    Pivô: 38
    
    Partição: [27,3,9,10] + [38] + [43,82]
                   ↑         ↑       ↑
              menores     pivô    maiores
    
    Recursão nos subarrays:
    [3,9,10,27] + [38] + [43,82] = [3,9,10,27,38,43,82] ✅
    
    ✅ In-place, rápido na prática
    ❌ Pior caso O(n²)
    
    🏔️ HEAP SORT - O Construtor de Pirâmides:
    Array: [38,27,43,3,9,82,10]
    
    1. Constrói Max-Heap:
              82
             /  \
           38    43
          / \   / \
         27  9 3  10
    
    2. Remove máximo (82), reconstrói heap
    3. Remove máximo (43), reconstrói heap  
    4. Repete até esvaziar
    
    ✅ Sempre O(n log n), in-place
    ❌ Não é estável
```

**🛠️ Como Fazer**:
1. **Implemente Merge Sort**: Divide recursivamente + merge ordenado
2. **Implemente Quick Sort**: Escolha pivô + particionamento
3. **Implemente Heap Sort**: Constrói heap + extrai máximos
4. **Compare performance**: Diferentes tipos de dados
5. **Analise estabilidade**: Elementos iguais mantêm ordem original?

### 📋 **Exercício 2: O Quebra-Cabeças Inteligente (Programação Dinâmica)**

**🎭 Analogia**: Um solucionador de quebra-cabeças que lembra as peças que já tentou, evitando repetir o mesmo trabalho. Como montar um quebra-cabeças gigante lembrando de cada tentativa.

**🎨 Visualização**:
```
            🧩 PROGRAMAÇÃO DINÂMICA
    
    1. 🎒 PROBLEMA DA MOCHILA:
    Itens: 💎(valor:60,peso:10) 💍(valor:100,peso:20) 👑(valor:120,peso:30)
    Mochila: capacidade 50kg
    
    Tabela DP:
         Peso→  0  10  20  30  40  50
    Item 0      0   0   0   0   0   0
    💎   1      0  60  60  60  60  60
    💍   2      0  60 100 160 160 160  
    👑   3      0  60 100 160 180 220
                                   ↑
                            Valor máximo: 220
    
    2. 📏 MAIOR SUBSEQUÊNCIA COMUM (LCS):
    String A: "AGGTAB"  
    String B: "GXTXAYB"
    
    Tabela DP:
        ""  G  X  T  X  A  Y  B
    ""   0  0  0  0  0  0  0  0
    A    0  0  0  0  0  1  1  1
    G    0  1  1  1  1  1  1  1  
    G    0  1  1  1  1  1  1  1
    T    0  1  1  2  2  2  2  2
    A    0  1  1  2  2  3  3  3
    B    0  1  1  2  2  3  3  4
                            ↑
                    LCS = "GTAB" (tamanho 4)
    
    💡 Princípio: 
    Problema grande = combinação ótima de subproblemas
    Memoriza soluções para evitar recálculo
```

**🛠️ Como Fazer**:
1. **Identifique subproblemas**: Como quebrar problema grande?
2. **Defina recorrência**: Relação entre problema e subproblemas
3. **Implemente memoização**: Top-down com cache
4. **Implemente tabulação**: Bottom-up preenchendo tabela
5. **Reconstroi solução**: Não só valor ótimo, mas a solução completa

### 📋 **Exercício 3: O Tomador de Decisões (Algoritmos Gulosos)**

**🎭 Analogia**: Uma pessoa que sempre faz a escolha que parece melhor no momento, sem pensar no futuro. Às vezes funciona perfeitamente, às vezes leva a becos sem saída.

**🎨 Visualização**:
```
            🤑 ALGORITMOS GULOSOS
    
    1. 💰 PROBLEMA DO TROCO:
    Dar troco de R$ 67 com menos moedas possível
    Moedas: [50, 25, 10, 5, 1]
    
    Guloso:
    R$ 67 → 1 moeda de R$ 50 → sobra R$ 17
    R$ 17 → 0 moedas de R$ 25 → sobra R$ 17  
    R$ 17 → 1 moeda de R$ 10 → sobra R$ 7
    R$ 7  → 1 moeda de R$ 5  → sobra R$ 2
    R$ 2  → 2 moedas de R$ 1 → sobra R$ 0
    
    Total: 5 moedas ✅ (É ótimo para moedas brasileiras!)
    
    2. 🎪 SELEÇÃO DE ATIVIDADES:
    Atividades com horários:
    A1: 09:00-10:00  A2: 09:30-11:00  A3: 10:30-12:00
    A4: 11:30-13:00  A5: 12:00-14:00
    
    Guloso (ordena por fim):
    1. Escolhe A1 (termina 10:00)
    2. A2 conflita, pula  
    3. Escolhe A3 (termina 12:00)
    4. Escolhe A4 (termina 13:00)
    5. A5 conflita, pula
    
    Resultado: [A1, A3, A4] = 3 atividades ✅
    
    ⚠️ Guloso nem sempre é ótimo!
    Exemplo: Moedas [4, 3, 1] para troco 6
    Guloso: 4 + 1 + 1 = 3 moedas
    Ótimo: 3 + 3 = 2 moedas ❌
```

**🛠️ Como Fazer**:
1. **Identifique escolha gulosa**: Que critério usar a cada passo?
2. **Prove se é ótimo**: Quando algoritmo guloso funciona?
3. **Implemente múltiplos problemas**: Troco, atividades, Huffman
4. **Compare com DP**: Quando usar cada abordagem?
5. **Teste casos extremos**: Quando guloso falha?

---

## 🌳 **NÍVEL AVANÇADO**

### 📋 **Exercício 1: O Explorador de Possibilidades (Backtracking)**

**🎭 Analogia**: Um explorador em um labirinto que marca cada caminho tentado. Quando chega em um beco sem saída, volta para a última bifurcação e tenta outro caminho.

**🎨 Visualização**:
```
            🔍 BACKTRACKING - EXPLORAÇÃO SISTEMÁTICA
    
    1. 👸 PROBLEMA DAS N-RAINHAS (4x4):
    Colocar 4 rainhas sem se atacarem:
    
    Tentativa 1:
    ♛ _ _ _    ♛ _ _ _    ♛ _ _ _    ♛ _ _ _
    _ _ ♛ _    _ _ ♛ _    _ _ ♛ _ →  _ _ ♛ _  
    _ _ _ _    _ ♛ _ _    _ ♛ _ _    _ ♛ _ _
    _ _ _ _ → _ _ _ _ → _ _ _ _    ❌ _ _ ❌
                              Conflito!
    
    BACKTRACK! Volta e tenta nova posição:
    ♛ _ _ _
    _ _ _ ♛  ← Nova tentativa
    _ ♛ _ _
    _ _ _ ♛  ✅ Solução encontrada!
    
    2. 🧩 SUDOKU:
    Tabuleiro parcial:
    [5,3,_,_,7,_,_,_,_]
    [6,_,_,1,9,5,_,_,_]
    [_,9,8,_,_,_,_,6,_]
    ...
    
    Algoritmo:
    1. Encontra próxima célula vazia
    2. Tenta números 1-9
    3. Verifica se válido (linha/coluna/quadrante)
    4. Recursão para próxima célula
    5. Se impossível → BACKTRACK
    
    📊 Árvore de Busca:
         Célula(0,2)
        /    |    \
       1     2     3...
      /      |      \
   Inválido Valid  Valid
             |       |
        Próxima  Próxima
          célula  célula
```

**🛠️ Como Fazer**:
1. **Identifique espaço de busca**: Todas possibilidades válidas
2. **Implemente função recursiva**: Tenta opção + recursão
3. **Adicione poda**: Elimina caminhos impossíveis cedo
4. **Implemente desfazer**: Remove decisão ao fazer backtrack
5. **Otimize ordem**: Tente opções mais promissoras primeiro

### 📋 **Exercício 2: O Detetive de Padrões (Algoritmos de String)**

**🎭 Analogia**: Três detetives especializados em encontrar pistas (padrões) em textos longos. Cada um tem sua técnica especial para não perder tempo procurando nos lugares errados.

**🎨 Visualização**:
```
            🔍 DETETIVES DE PADRÕES EM STRINGS
    
    Texto: "ABABCABABA"  Padrão: "ABABA"
    
    🐌 BUSCA INGÊNUA:
    ABABCABABA
    ABABA      ❌ não casa
     ABABA     ❌ não casa  
      ABABA    ❌ não casa
       ABABA   ❌ não casa
        ABABA  ❌ não casa
         ABABA ✅ encontrou!
    
    Total: 30 comparações
    
    🧠 KMP (KNUTH-MORRIS-PRATT):
    Pré-processa padrão para evitar comparações desnecessárias:
    
    Padrão: A B A B A
    LPS:    0 0 1 2 3  ← Longest Proper Prefix which is Suffix
    
    Busca inteligente:
    ABABCABABA
    ABABA      ❌ casa até C, mas sabe que AB já casa
     XX BA     ← Pula posições sabendo que falhará
         ABABA ✅ encontrou!
    
    Total: 19 comparações (economia de 37%!)
    
    🎯 BOYER-MOORE:
    Começa comparando do FIM do padrão:
    
    ABABCABABA
    ABABA      
        ↑ Compara 'C' com 'A': não casa
          'C' não existe no padrão → pula padrão todo!
    
    ABABCABABA
         ABABA ✅ encontrou em apenas 2 comparações!
```

**🛠️ Como Fazer**:
1. **Implemente busca ingênua**: Baseline para comparação
2. **Implemente KMP**: Tabela de falhas + busca inteligente
3. **Implemente Boyer-Moore**: Tabela de caracteres ruins + pulos
4. **Compare performance**: Diferentes tamanhos de texto/padrão
5. **Teste casos especiais**: Padrão não existe, múltiplas ocorrências

### 📋 **Exercício 3: O Compressor Mágico (Algoritmos de Compressão)**

**🎭 Analogia**: Dois magos que conseguem encolher textos enormes usando truques diferentes - um conta repetições (RLE), outro cria um código secreto onde letras frequentes têm códigos mais curtos (Huffman).

**🎨 Visualização**:
```
            🎩 MÁGICA DA COMPRESSÃO
    
    1. 🔢 RUN-LENGTH ENCODING (RLE):
    Texto original: "AAABBBCCCCDDDD"
    
    Análise: A(3) B(3) C(4) D(4)
    Comprimido: "3A3B4C4D"
    
    Original: 14 caracteres
    Comprimido: 8 caracteres
    Taxa: 57% do tamanho original ✅
    
    ❌ Não funciona bem com pouca repetição:
    "ABCD" → "1A1B1C1D" (pior que original!)
    
    2. 🌳 CODIFICAÇÃO DE HUFFMAN:
    Texto: "AAAAABBBCCDE"
    
    Frequências: A:5, B:3, C:2, D:1, E:1
    
    Árvore Huffman:
            (12)
           /    \
         A:5    (7)
               /   \
             B:3   (4)
                  /   \
                C:2   (2)
                     / \
                   D:1 E:1
    
    Códigos: A=0, B=10, C=110, D=1110, E=1111
    
    Original: 12 chars × 8 bits = 96 bits
    Huffman: 5×1 + 3×2 + 2×3 + 1×4 + 1×4 = 25 bits
    Taxa: 26% do tamanho original! 🎯
    
    Mensagem: AAAAABBBCCDE
    Codificada: 00000101010110110111011111
```

**🛠️ Como Fazer**:
1. **Implemente RLE**: Conta sequências consecutivas
2. **Implemente Huffman**: Constrói árvore + gera códigos
3. **Calcule taxas compressão**: Para diferentes tipos de texto
4. **Teste casos extremos**: Texto aleatório vs repetitivo
5. **Implemente decodificação**: Processo reverso para recuperar original

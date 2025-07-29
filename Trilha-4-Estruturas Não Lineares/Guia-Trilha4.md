# 🌳 TRILHA 4: Estruturas Não Lineares

## 🎯 **Analogia da Trilha**: A Organização da Natureza

A natureza organiza informações de forma hierárquica e não linear:
- **Árvores**: Sistema de arquivos, família genealógica
- **Hash Tables**: DNA (chave única para cada ser vivo)
- **Heaps**: Pirâmide social, organograma empresa

---

## 🌱 **NÍVEL INICIANTE**

### 📋 **Exercício 1: A Árvore Genealógica (Árvore Binária)**

**🎭 Analogia**: Uma árvore genealógica onde cada pessoa tem até dois filhos. Você pode rastrear linhagens, encontrar ancestrais e contar descendentes.

**🎨 Visualização**:
```
            👨‍👩‍👧‍👦 ÁRVORE GENEALÓGICA
    
                    👴 Avô João
                   /           \
              👨 Pai Carlos     👩 Tia Maria  
             /             \
        👦 Filho Pedro   👧 Filha Ana
       /       \
   👶 Neto    👶 Neta
    
    Terminologia:
    🌿 Raiz: Avô João (ancestral comum)
    🍃 Folhas: Neto, Neta (sem descendentes)
    🌿 Nível 0: Avô
    🌿 Nível 1: Pai, Tia  
    🌿 Nível 2: Pedro, Ana
    🌿 Altura: 3 níveis
    
    Operações:
    👶 Inserir: Adicionar novo membro
    🔍 Buscar: Encontrar pessoa específica
    📊 Contar: Quantos descendentes
    📏 Altura: Quantas gerações
```

**🛠️ Como Fazer**:
1. **Defina estrutura do nó**: Dados + filho esquerdo + filho direito
2. **Implemente inserção**: Escolha lado baseado em critério
3. **Implemente busca**: Percorrer recursivamente
4. **Conte nós**: Recursão para contar descendentes
5. **Calcule altura**: Máximo entre subárvores + 1

### 📋 **Exercício 2: A Biblioteca Organizada (BST)**

**🎭 Analogia**: Uma biblioteca onde livros estão organizados alfabeticamente em estantes. Títulos menores à esquerda, maiores à direita. Facilita encontrar qualquer livro rapidamente.

**🎨 Visualização**:
```
            📚 BIBLIOTECA BINÁRIA DE BUSCA
    
                      "Java"
                     /      \
            "Algoritmos"    "Python"
           /           \    /        \
      "Arrays"    "Estruturas" "MySQL" "Web"
    
    Regra BST: Esquerda < Raiz < Direita
    
    Buscar "MySQL":
    1. Começa em "Java": "MySQL" > "Java" → vai direita
    2. Vai para "Python": "MySQL" < "Python" → vai esquerda  
    3. Encontrou "MySQL"! ✅
    
    ⚡ Apenas 3 comparações para encontrar em 7 livros!
    (Lista normal precisaria de até 7 comparações)
    
    Operações:
    📖 Inserir: Mantém ordem BST → O(log n)
    🔍 Buscar: Divide busca pela metade → O(log n)
    🗑️ Remover: Reorganiza mantendo BST → O(log n)
```

**🛠️ Como Fazer**:
1. **Defina critério de ordenação**: Alfabético, numérico, etc.
2. **Implemente inserção recursiva**: Esquerda se menor, direita se maior
3. **Implemente busca eficiente**: Elimina metade a cada passo
4. **Teste propriedade BST**: Percurso em ordem deve ser ordenado
5. **Compare com busca linear**: Meça diferença de performance

### 📋 **Exercício 3: A Agenda Telefônica Rápida (HashSet)**

**🎭 Analogia**: Uma agenda telefônica mágica onde você fala o nome da pessoa e ela abre automaticamente na página certa, sem folhear.

**🎨 Visualização**:
```
            📞 AGENDA TELEFÔNICA MÁGICA
    
    Função Hash: nome → número da página
    
    hash("João") = 3
    hash("Maria") = 7  
    hash("Pedro") = 1
    
    Agenda (Array):
    ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐
    │  0  │  1  │  2  │  3  │  4  │  5  │  6  │  7  │
    └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
            ↑           ↑                       ↑
           Pedro       João                   Maria
    
    Operações:
    📞 Adicionar: hash(nome) → coloca na página
    🔍 Buscar: hash(nome) → vai direto na página
    🗑️ Remover: hash(nome) → marca página como vazia
    
    Colisão (mesmo hash):
    hash("Ana") = 3 (mesmo que João!)
    Solução: Lista ligada na página 3
    
    Página 3: João → Ana → NULL
```

**🛠️ Como Fazer**:
1. **Crie função hash simples**: Soma ASCII dos caracteres % tamanho
2. **Implemente array de listas**: Cada posição é uma lista (resolve colisões)
3. **Adicione elementos**: Hash → posição → adiciona na lista
4. **Busque elementos**: Hash → posição → procura na lista
5. **Teste distribuição**: Função hash distribui bem os dados?

---

## 🌿 **NÍVEL INTERMEDIÁRIO**

### 📋 **Exercício 1: A Enciclopédia Completa (BST Avançada)**

**🎭 Analogia**: Uma enciclopédia digital que não só encontra verbetes, mas também pode removê-los, listar em ordem alfabética, e encontrar o primeiro e último verbete.

**🎨 Visualização**:
```
            📖 ENCICLOPÉDIA DIGITAL BST
    
    Operações Avançadas:
    
    1. Percursos (diferentes "leituras"):
       Em-ordem: A B C D E F G (alfabética!)
       Pré-ordem: D B A C F E G (estrutura)
       Pós-ordem: A C B E G F D (limpeza)
    
                    D
                   / \
                  B   F
                 / \ / \
                A  C E  G
    
    2. Remoção Complexa:
       Remover "D" (raiz com 2 filhos):
       
       Antes:        Depois:
          D             E
         / \           / \
        B   F         B   F
       / \ / \       / \   \
      A  C E  G     A   C   G
      
      ↑ Substitui por sucessor em-ordem (E)
    
    3. Estatísticas:
       🌱 Altura: 3
       📊 Min: A, Max: G
       🔢 Total: 7 nós
```

**🛠️ Como Fazer**:
1. **Implemente todos percursos**: Em-ordem, pré-ordem, pós-ordem
2. **Implemente remoção**: 3 casos (folha, 1 filho, 2 filhos)
3. **Encontre min/max**: Vai sempre à esquerda/direita
4. **Calcule estatísticas**: Altura, quantidade, balanceamento
5. **Valide propriedade BST**: Após cada operação

### 📋 **Exercício 2: A Montanha de Prioridades (Heap)**

**🎭 Analogia**: Uma montanha onde o pico sempre tem a pedra mais valiosa. Quando você remove o pico, a segunda mais valiosa "sobe" automaticamente para o topo.

**🎨 Visualização**:
```
            ⛰️ MONTANHA DE PRIORIDADES (MAX-HEAP)
    
    Estrutura de Heap:
                    100 ← Sempre o maior no topo
                   /   \
                  80    90
                 / \   / \
                50 70 60 40
               / \
              30 20
    
    Como Array:
    ┌────┬────┬────┬────┬────┬────┬────┬────┬────┐
    │100 │ 80 │ 90 │ 50 │ 70 │ 60 │ 40 │ 30 │ 20 │
    └────┴────┴────┴────┴────┴────┴────┴────┴────┘
      0    1    2    3    4    5    6    7    8
    
    Relações:
    Pai de i: (i-1)/2
    Filho esq de i: 2*i + 1  
    Filho dir de i: 2*i + 2
    
    Operações:
    📥 Insert: Adiciona no fim + "borbulha" para cima
    📤 Extract-max: Remove topo + reorganiza
    🔄 Heapify: Restaura propriedade do heap
```

**🛠️ Como Fazer**:
1. **Use array como representação**: Mais eficiente que árvore
2. **Implemente heapify-up**: Elemento sobe até posição correta
3. **Implemente heapify-down**: Reorganiza após remoção do topo
4. **Implemente inserção**: Adiciona no fim + heapify-up
5. **Implemente extração**: Remove topo + move último para topo + heapify-down

### 📋 **Exercício 3: O Dicionário Inteligente (HashMap)**

**🎭 Analogia**: Um dicionário que não só traduz palavras, mas aprende com o uso. Palavras mais usadas ficam mais fáceis de encontrar, e ele se reorganiza automaticamente quando fica muito cheio.

**🎨 Visualização**:
```
            📚 DICIONÁRIO INTELIGENTE (HASHMAP)
    
    Estrutura Interna:
    ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐
    │  0  │  1  │  2  │  3  │  4  │  5  │  6  │  7  │
    └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
            │           │                       │
            ▼           ▼                       ▼
        "Pedro"→123  "Ana"→456               "Maria"→789
                     "João"→321
    
    Processo de Busca:
    1. Buscar "Ana"
    2. hash("Ana") = 3
    3. Vai para posição 3
    4. Procura "Ana" na lista → Encontrou! ✅
    
    Redimensionamento Automático:
    Carga atual: 5 elementos / 8 posições = 62.5%
    Se carga > 75% → Duplica tamanho + redistribui tudo
    
    Função Hash Melhorada:
    - Distribui uniformemente
    - Rápida de calcular  
    - Minimiza colisões
```

**🛠️ Como Fazer**:
1. **Implemente função hash robusta**: Não só soma ASCII
2. **Gerencie fator de carga**: Redimensiona quando > 75%
3. **Implemente redimensionamento**: Cria tabela maior + redistribui
4. **Otimize resolução de colisões**: Lista ligada ou sondagem
5. **Meça performance**: Tempo constante O(1) na prática?

---

## 🌳 **NÍVEL AVANÇADO**

### 📋 **Exercício 1: O Equilibrista Perfeito (Árvore AVL)**

**🎭 Analogia**: Um equilibrista que mantém uma pirâmide de pessoas sempre perfeitamente balanceada. Quando alguém entra ou sai, ele reorganiza tudo para manter o equilíbrio perfeito.

**🎨 Visualização**:
```
            🤹‍♂️ EQUILIBRISTA AVL
    
    Propriedade AVL: |altura_esq - altura_dir| ≤ 1
    
    Desbalanceamento (inserir 30):
         20                    20
        /  \        →         /  \
       10   40               10   40
           /                     /
          30                    30 ← Altura dir = 2, esq = 1
                                   Diferença = 1 ✅ OK
    
    Desbalanceamento crítico (inserir 25):
         20                    20
        /  \        →         /  \
       10   40               10   40
           /                     /
          30                   30
         /                    /
        25                   25 ← Diferença = 2 ❌ ROTAÇÃO!
    
    Após Rotação:
              30
             /  \
           20    40
          / \
         10  25 ← Balanceado! ✅
    
    Tipos de Rotação:
    🔄 Simples Direita: LL case
    🔄 Simples Esquerda: RR case  
    🔄 Dupla Esq-Dir: LR case
    🔄 Dupla Dir-Esq: RL case
```

**🛠️ Como Fazer**:
1. **Adicione altura aos nós**: Atualiza após cada operação
2. **Calcule fator balanceamento**: altura_esq - altura_dir
3. **Identifique casos rotação**: LL, LR, RR, RL
4. **Implemente 4 rotações**: Cada caso tem sua rotação
5. **Teste performance**: Garante O(log n) sempre?

### 📋 **Exercício 2: O Semáforo Inteligente (Árvore Rubro-Negra)**

**🎭 Analogia**: Um sistema de semáforos urbanos que mantém o trânsito fluindo suavemente. Cada semáforo é vermelho ou preto, e há regras rígidas para manter o fluxo equilibrado.

**🎨 Visualização**:
```
            🚦 SISTEMA DE SEMÁFOROS RB-TREE
    
    Regras do Trânsito (Propriedades RB):
    1. 🔴 Raiz sempre preta
    2. 🔴 Folhas (NIL) sempre pretas  
    3. 🔴 Nó vermelho → filhos pretos
    4. 🔴 Caminhos root→folha têm mesmo número de nós pretos
    
    Exemplo:
                    🖤 20
                   /    \
              🔴 10      🖤 30
             /   \      /    \
        🖤 5    🖤 15  🔴 25  🖤 40
       / \      / \   / \    / \
     NIL NIL  NIL NIL NIL NIL NIL NIL
    
    Balanceamento Automático:
    - Inserção: Pode quebrar regras → recolore/rotaciona
    - Remoção: Pode quebrar regras → recolore/rotaciona
    - Altura sempre ≤ 2 log(n+1) ← Garantia matemática!
    
    vs AVL:
    AVL: Mais balanceada, inserção/remoção mais cara
    RB: Menos balanceada, inserção/remoção mais barata
```

**🛠️ Como Fazer**:
1. **Adicione cor aos nós**: Enum { RED, BLACK }
2. **Implemente inserção RB**: Insere vermelho + corrige violações
3. **Implemente rotações e recoloração**: 6 casos de correção
4. **Implemente remoção RB**: Mais complexa que inserção
5. **Valide propriedades**: Após cada operação

### 📋 **Exercício 3: O Hash Perfeito (Estratégias Avançadas)**

**🎭 Analogia**: Um sistema de endereçamento postal ultra-eficiente que sempre encontra a casa certa, mesmo quando há muitas casas na mesma rua. Usa diferentes estratégias para resolver conflitos de endereço.

**🎨 Visualização**:
```
            📮 SISTEMA POSTAL AVANÇADO
    
    Estratégias de Resolução:
    
    1. 🔗 Encadeamento (Chaining):
       Rua 3: Casa João → Casa Ana → Casa Pedro
       ✅ Simples, flexível
       ❌ Usa mais memória
    
    2. 📍 Sondagem Linear:
       hash("João") = 3 (ocupado) → tenta 4, 5, 6...
       ✅ Usa menos memória
       ❌ Clustering (agrupamento)
    
    3. 📐 Sondagem Quadrática:  
       hash("João") = 3 → tenta 3+1², 3+2², 3+3²...
       ✅ Reduz clustering
       ❌ Pode não encontrar slot vazio
    
    4. 🔄 Hash Duplo:
       hash1("João") = 3, hash2("João") = 5
       Tenta: 3, 3+5, 3+2*5, 3+3*5...
       ✅ Excelente distribuição
       ❌ Mais complexo
    
    📊 Redimensionamento Inteligente:
    - Monitora fator de carga
    - Dobra tamanho quando necessário
    - Usa números primos (melhor distribuição)
```

**🛠️ Como Fazer**:
1. **Implemente múltiplas estratégias**: Teste todas as 4
2. **Compare performance**: Tempo inserção/busca/remoção
3. **Meça clustering**: Visualize distribuição dos dados
4. **Implemente redimensionamento**: Automático baseado em carga
5. **Teste casos extremos**: Muitas colisões, tabela cheia

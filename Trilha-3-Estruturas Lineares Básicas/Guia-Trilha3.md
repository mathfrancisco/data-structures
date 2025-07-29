# 📝 TRILHA 3: Estruturas Lineares

## 🎯 **Analogia da Trilha**: A Organização da Casa

Diferentes cômodos da casa organizam objetos de maneiras diferentes:
- **Arrays**: Armário com gavetas numeradas
- **Listas**: Trem com vagões conectados
- **Pilhas**: Torre de pratos
- **Filas**: Fila do banco

---

## 🌱 **NÍVEL INICIANTE**

### 📋 **Exercício 1: O Gerente do Estoque (Arrays)**

**🎭 Analogia**: Um depósito com prateleiras numeradas onde cada produto tem sua posição fixa. Você pode ir direto na prateleira 47 buscar o produto.

**🎨 Visualização**:
```
            🏪 DEPÓSITO ORGANIZADO
    
    Prateleiras Numeradas (Array):
    ┌───┬───┬───┬───┬───┬───┬───┬───┐
    │📱 │👕 │📚 │⚽ │🎧 │   │   │   │
    ├───┼───┼───┼───┼───┼───┼───┼───┤
    │ 0 │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │
    └───┴───┴───┴───┴───┴───┴───┴───┘
    
    Operações:
    📦 Adicionar: Encontra espaço vazio → O(n)
    🔍 Buscar: Percorre até encontrar → O(n)  
    📱 Acessar[2]: Vai direto na posição → O(1)
    🗑️ Remover: Remove e reorganiza → O(n)
    
    Vantagens: ✅ Acesso direto rápido
    Limitações: ❌ Tamanho fixo, inserção cara
```

**🛠️ Como Fazer**:
1. **Defina capacidade**: Array com tamanho máximo
2. **Implemente busca**: Percorre sequencialmente
3. **Gerencie espaços vazios**: Como reorganizar após remoção?
4. **Adicione validações**: Array cheio, produto inexistente
5. **Teste performance**: Compare busca vs acesso direto

### 📋 **Exercício 2: A Lista de Tarefas (ArrayList)**

**🎭 Analogia**: Uma agenda que pode crescer conforme você adiciona mais tarefas. Quando uma página acaba, você compra uma agenda maior e transfere tudo.

**🎨 Visualização**:
```
            📋 AGENDA DE TAREFAS
    
    Estado inicial (capacidade 4):
    ┌──────────────┬──────────────┬──────────────┬──────────────┐
    │ "Comprar"    │ "Estudar"    │              │              │
    └──────────────┴──────────────┴──────────────┴──────────────┘
    
    Adicionar mais tarefas... Opa, sem espaço!
    ┌──────────────┬──────────────┬──────────────┬──────────────┐
    │ "Comprar"    │ "Estudar"    │ "Exercitar"  │ "Cozinhar"   │
    └──────────────┴──────────────┴──────────────┴──────────────┘
    
    📈 EXPANSÃO! Nova agenda (capacidade 8):
    ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐
    │Comp │Estud│Exerc│Cozi │Novo │     │     │     │
    └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
    
    Operações:
    ✅ add(tarefa): Adiciona no final → O(1)*
    ✅ get(i): Acessa posição → O(1)
    ✅ remove(i): Remove e desloca → O(n)
    *Amortizado (às vezes precisa expandir)
```

**🛠️ Como Fazer**:
1. **Comece simples**: Array interno com capacidade inicial
2. **Implemente expansão**: Duplica tamanho quando necessário
3. **Gerencie tamanho**: Diferença entre capacidade e elementos
4. **Adicione funcionalidades**: Marcar completa, prioridade
5. **Teste cenários**: Lista vazia, cheia, expansão múltipla

### 📋 **Exercício 3: A Torre de Pratos (Stack)**

**🎭 Analogia**: Uma pilha de pratos limpos. Você sempre pega o de cima (último colocado) e sempre coloca pratos em cima da pilha.

**🎨 Visualização**:
```
            🍽️ TORRE DE PRATOS
    
    Operação PUSH (empilhar):
         ┌─────┐
         │ 🍽️  │ ← Novo prato (topo)
    ┌────┼─────┼────┐
    │    │ 🍽️  │    │
    ├────┼─────┼────┤
    │    │ 🍽️  │    │
    ├────┼─────┼────┤  
    │    │ 🍽️  │    │ ← Base
    └────┴─────┴────┘
    
    Operação POP (desempilhar):
    ┌────┬─────┬────┐
    │    │ 🍽️  │    │ ← Remove do topo
    ├────┼─────┼────┤
    │    │ 🍽️  │    │
    ├────┼─────┼────┤  
    │    │ 🍽️  │    │ ← Agora é o topo
    └────┴─────┴────┘
    
    Regra LIFO: Last In, First Out
    📥 push(): Adiciona no topo → O(1)
    📤 pop(): Remove do topo → O(1)  
    👀 peek(): Espia o topo → O(1)
    ❓ isEmpty(): Verifica se vazia → O(1)
```

**🛠️ Como Fazer**:
1. **Escolha implementação**: Array ou lista ligada
2. **Mantenha referência do topo**: Índice ou ponteiro
3. **Implemente operações básicas**: push, pop, peek, isEmpty
4. **Adicione validações**: Pilha vazia (pop), pilha cheia (array)
5. **Teste aplicação prática**: Verificador de parênteses balanceados

---

## 🌿 **NÍVEL INTERMEDIÁRIO**

### 📋 **Exercício 1: O Trem de Vagões (Lista Ligada)**

**🎭 Analogia**: Um trem onde cada vagão sabe onde está o próximo vagão, mas não tem numeração fixa. Para chegar no vagão 5, precisa passar pelos vagões 1, 2, 3, 4.

**🎨 Visualização**:
```
            🚂 TREM DE DADOS
    
    Lista Ligada Simples:
    ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐
    │ Dados:📱│───▶│ Dados:👕│───▶│ Dados:📚│───▶│ Dados:⚽│───▶ NULL
    │ Próximo │    │ Próximo │    │ Próximo │    │ Próximo │
    └─────────┘    └─────────┘    └─────────┘    └─────────┘
         ↑              ↑              ↑              ↑
      Nó 1           Nó 2           Nó 3           Nó 4
    
    Inserção no meio (após 📚):
    ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐
    │ Dados:📱│───▶│ Dados:👕│───▶│ Dados:📚│───▶│ Dados:🎧│───▶│ Dados:⚽│
    └─────────┘    └─────────┘    └─────────┘    └─────────┘    └─────────┘
                                        │                           ↑
                                        └─────────────────────────────┘
    
    Vantagens: ✅ Tamanho dinâmico, inserção O(1)
    Limitações: ❌ Acesso sequencial O(n), sem índices
```

**🛠️ Como Fazer**:
1. **Defina estrutura do nó**: Dados + referência para próximo
2. **Mantenha referência da cabeça**: Primeiro nó da lista
3. **Implemente inserção**: No início, fim, posição específica
4. **Implemente busca**: Percorrer sequencialmente
5. **Implemente remoção**: Reconectar referências

### 📋 **Exercício 2: A Fila do Banco (Queue)**

**🎭 Analogia**: Fila de um banco onde o primeiro que chega é o primeiro a ser atendido. Pessoas entram no final da fila e saem pelo início.

**🎨 Visualização**:
```
            🏛️ FILA DO BANCO
    
    ┌─────────────────────────────────────────────────────┐
    │                   FILA FIFO                         │
    └─────────────────────────────────────────────────────┘
    
    Enqueue (entrar na fila):      Dequeue (ser atendido):
         👤 Nova pessoa                    🏛️ Atendimento
         ↓                                ↑
    ┌────┬────┬────┬────┬────┐      🚶────┬────┬────┬────┐
    │ 👩 │ 👨 │ 👴 │ 👧 │ 👤 │      │ ❌ │ 👩 │ 👨 │ 👴 │
    └────┴────┴────┴────┴────┘      └────┴────┴────┴────┘
     ↑                  ↑            ↑                   
    Início             Fim          Atendido           
    (sai daqui)    (entra aqui)
    
    Regra FIFO: First In, First Out
    📥 enqueue(): Adiciona no fim → O(1)
    📤 dequeue(): Remove do início → O(1)
    👀 front(): Espia o primeiro → O(1)
    ❓ isEmpty(): Verifica se vazia → O(1)
```

**🛠️ Como Fazer**:
1. **Escolha implementação**: Array circular ou lista ligada
2. **Mantenha dois ponteiros**: Início (front) e fim (rear)
3. **Implemente enqueue**: Adiciona no rear, incrementa rear
4. **Implemente dequeue**: Remove do front, incrementa front
5. **Teste aplicação**: Simulação de atendimento com tempos

### 📋 **Exercício 3: A Estrada de Mão Dupla (Lista Duplamente Ligada)**

**🎭 Analogia**: Uma estrada onde você pode andar nas duas direções. Cada ponto da estrada tem placas indicando o próximo destino e o anterior.

**🎨 Visualização**:
```
            🛣️ ESTRADA BIDIRECIONAL
    
    Lista Duplamente Ligada:
         NULL ←── 📍 Início
                   ↓
    ┌─────────────────────────────────────────────────────┐
    │     ↶        ↶        ↶        ↶        ↶        │
    │ ┌─────────┐─────────┐─────────┐─────────┐─────────│─┐
    │ │ Ant │📱 │👕│ Próx│📚│ Próx│⚽│ Próx│🎧│     │  │
    │ │     │   │  │     │  │     │  │     │  │     │  │
    │ └─────────┘─────────┘─────────┘─────────┘─────────┴─┘
    │     ↷        ↷        ↷        ↷        ↷        │
    └─────────────────────────────────────────────────────┘
                                                ↑
                                          📍 Fim → NULL
    
    Vantagens sobre Lista Simples:
    ✅ Navegação bidirecional
    ✅ Remoção mais eficiente (não precisa buscar anterior)
    ✅ Inserção antes de um nó específico é O(1)
    
    Custo: 🔻 Mais memória (2 ponteiros por nó)
```

**🛠️ Como Fazer**:
1. **Defina nó com 2 ponteiros**: Anterior e próximo
2. **Mantenha cabeça e cauda**: Primeiro e último nós
3. **Implemente inserção bidirecional**: Início, fim, meio
4. **Implemente navegação**: Para frente e para trás
5. **Teste vantagens**: Compare com lista simples

---

## 🌳 **NÍVEL AVANÇADO**

### 📋 **Exercício 1: O Carrossel Infinito (Lista Circular)**

**🎭 Analogia**: Um carrossel de parque onde depois do último cavalo vem o primeiro novamente. Não existe "fim" - você pode girar infinitamente.

**🎨 Visualização**:
```
            🎠 CARROSSEL DE DADOS
    
    Lista Circular:
              ┌─────────┐
              │  Dados  │
              │    🦄   │
              └────┬────┘
                   │
         ┌─────────┴─────────┐
         ↓                   ↑
    ┌─────────┐         ┌─────────┐
    │  Dados  │    ←───  │  Dados  │
    │    🐎   │         │    🦓   │  
    └────┬────┘         └─────────┘
         │                   ↑
         ↓                   │
    ┌─────────┐         ┌─────────┐
    │  Dados  │    ───▶ │  Dados  │
    │    🐴   │         │    🦌   │
    └─────────┘         └────┬────┘
         ↑                   │
         └───────────────────┘
    
    Aplicações Práticas:
    🎮 Sistema de turnos em jogos
    📺 Playlist infinita de músicas  
    🔄 Round-robin de processos
    ⏰ Dias da semana (Dom→Seg→...→Sab→Dom)
```

**🛠️ Como Fazer**:
1. **Modifique lista ligada**: Último nó aponta para o primeiro
2. **Elimine conceito de NULL**: Sempre há um próximo
3. **Implemente rotação**: Mover referência "atual"
4. **Cuidado com loops infinitos**: Condições de parada
5. **Teste aplicação prática**: Sistema de turnos de jogo

### 📋 **Exercício 2: O Hospital Inteligente (Fila de Prioridade)**

**🎭 Analogia**: Pronto-socorro que atende por gravidade, não por ordem de chegada. Casos urgentes passam na frente, mesmo chegando depois.

**🎨 Visualização**:
```
            🏥 PRONTO-SOCORRO INTELIGENTE
    
    Fila Tradicional (FIFO):     Fila de Prioridade:
    🤧 → 😷 → 🤕 → 💀            💀 (Urgente - 1)
    Resfriado → Gripe → Fratura → Infarto    🤕 (Grave - 2)
                                              😷 (Moderado - 3)  
    ❌ Infarto espera!           🤧 (Leve - 4)
    
    Operações:
    📥 enqueue(paciente, prioridade): Insere ordenado
    📤 dequeue(): Remove mais prioritário
    👀 peek(): Verifica próximo (mais urgente)
    
    Estrutura interna (Lista ordenada):
    ┌─────────────┬─────────────┬─────────────┬─────────────┐
    │ 💀 Prioridade│ 🤕 Prioridade│ 😷 Prioridade│ 🤧 Prioridade│
    │    1         │    2         │    3         │    4         │
    └─────────────┴─────────────┴─────────────┴─────────────┘
         ↑ Sempre sai daqui (maior prioridade)
```

**🛠️ Como Fazer**:
1. **Defina níveis de prioridade**: 1=urgente, 2=grave, etc.
2. **Implemente inserção ordenada**: Mantém ordem por prioridade
3. **Gerencie empates**: FIFO entre mesma prioridade
4. **Otimize remoção**: Sempre do início (mais prioritário)
5. **Teste cenário realista**: Chegadas aleatórias, prioridades variadas

### 📋 **Exercício 3: A Mesa de Poker (Deque)**

**🎭 Analogia**: Uma mesa de poker onde o dealer pode colocar e tirar cartas de ambas as extremidades do baralho. Flexibilidade total nos dois lados.

**🎨 Visualização**:
```
            🃏 MESA DE POKER - DEQUE
    
    Double-Ended Queue (Deque):
    
         addFirst()     addLast()
            ↓              ↓
    ┌──────────────────────────────────────┐
    │  ←─── Pode inserir/remover ───→     │
    └──────────────────────────────────────┘
    ┌─────┬─────┬─────┬─────┬─────┬─────┐
    │ 🃏  │ 🂡  │ 🂮  │ 🃁  │ 🃎  │ 🂱  │
    └─────┴─────┴─────┴─────┴─────┴─────┘
    ↑                              ↑
    removeFirst()              removeLast()
    
    Operações (todas O(1)):
    📥 addFirst(): Adiciona no início
    📥 addLast(): Adiciona no fim
    📤 removeFirst(): Remove do início  
    📤 removeLast(): Remove do fim
    👀 peekFirst(): Espia início
    👀 peekLast(): Espia fim
    
    Aplicações:
    🔄 Undo/Redo em editores
    🎮 Movimentos em jogos (frente/trás)
    📚 Histórico de navegação
```

**🛠️ Como Fazer**:
1. **Implemente com array circular**: Mais eficiente em memória
2. **Mantenha dois ponteiros**: Front e rear
3. **Gerencie wraparound**: Quando ponteiros "dão volta"
4. **Implemente todas operações**: Ambas extremidades
5. **Teste casos especiais**: Deque vazio, cheio, um elemento

# 📝 TRILHA 3: Estruturas de Dados Lineares
## Guia Didático Completo - Arrays, Listas, Pilhas e Filas

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

### Por que estruturas lineares são fundamentais?

**Estruturas lineares** são a base de TUDO em programação. Entender profundamente arrays, listas, pilhas e filas é como um músico dominar escalas - essencial antes de tocar músicas complexas.

**Impacto Real**:
- 🎮 **Games**: Fila de comandos, histórico de ações (undo/redo)
- 🌐 **Navegadores**: Histórico de páginas = pilha
- 📱 **Apps**: Listas de contatos, mensagens = lista ligada
- 🖥️ **Sistemas Operacionais**: Fila de processos, pilha de execução
- 💻 **Compiladores**: Pilha para parsing de expressões

### O que você dominará

| Estrutura | Força | Fraqueza | Quando Usar |
|-----------|-------|----------|-------------|
| **Array** | Acesso O(1) | Tamanho fixo | Dados de tamanho conhecido |
| **ArrayList** | Acesso O(1), dinâmico | Inserção no meio O(n) | Muitas leituras, poucas inserções |
| **LinkedList** | Inserção/remoção O(1) | Acesso O(n) | Muitas inserções/remoções |
| **Stack (Pilha)** | LIFO eficiente | Acesso só ao topo | Undo/redo, parsing |
| **Queue (Fila)** | FIFO eficiente | Acesso só início/fim | Processamento por ordem |
| **Deque** | Ambas pontas O(1) | Mais complexa | Flexibilidade máxima |

### Cronograma Sugerido

**Tempo Total**: 70-90 horas (6-8 semanas)

- **Semana 1-2** (Iniciante): Arrays, ArrayList básico - 15h
- **Semana 3-4** (Intermediário): Listas ligadas, Stacks, Queues - 25h
- **Semana 5-6** (Avançado): Deque, listas circulares, otimizações - 25h
- **Semana 7-8** (Projetos): Sistema integrado - 25h

---

## 📖 TEORIA FUNDAMENTAL {#teoria}

### 1. ARRAYS - A BASE DE TUDO

#### Conceito Central

**Array** = Bloco contíguo de memória com elementos do mesmo tipo

**Analogia**: Prédio de apartamentos numerados
- Cada apartamento = elemento
- Número do apto = índice
- Todos aptos têm mesmo tamanho (tipo)
- Fácil achar apto 305 (acesso direto)
- Difícil adicionar novo apto no meio (reorganizar tudo)

#### Características Fundamentais

1. **Tamanho Fixo**: Definido na criação
2. **Memória Contígua**: Elementos sequenciais na RAM
3. **Acesso O(1)**: array[i] é instantâneo
4. **Cache-Friendly**: Dados próximos = rápido

#### Complexidades

| Operação | Complexidade | Explicação |
|----------|--------------|------------|
| **Acesso** | O(1) | Cálculo direto: base + (i × tamElemento) |
| **Busca** | O(n) | Percorre até encontrar |
| **Inserção no fim** | O(1) * | Se houver espaço |
| **Inserção no meio** | O(n) | Desloca todos à direita |
| **Remoção** | O(n) | Desloca todos à esquerda |

#### Quando Usar Arrays

✅ **Use quando**:
- Tamanho máximo conhecido
- Acesso por índice frequente
- Dados raramente modificados
- Performance crítica (cache)

❌ **Evite quando**:
- Tamanho desconhecido/variável
- Muitas inserções/remoções
- Memória limitada (desperdício)

---

### 2. ARRAYLIST - ARRAY DINÂMICO

#### Conceito Central

**ArrayList** = Array que cresce automaticamente quando necessário

**Analogia**: Estante expansível
- Começa com 10 prateleiras
- Quando enche, compra estante 2x maior
- Transfere todos os livros
- Descarta estante antiga

#### Estratégia de Expansão

**Padrão Java**:
1. Capacidade inicial: 10
2. Quando cheio: `newCapacity = oldCapacity + (oldCapacity >> 1)` (cresce 50%)
3. Copia todos elementos para novo array
4. Atualiza referência

#### Análise Amortizada

**Expansão cara, mas rara**:
- 8 inserções simples: O(1) cada
- 1 expansão: O(8) para copiar
- Total: 16 operações / 9 inserções = ~1.78 operações por inserção
- Conforme n cresce, aproxima-se de O(1) **amortizado**

#### Complexidades

| Operação | Pior Caso | Amortizado |
|----------|-----------|------------|
| **get(i)** | O(1) | O(1) |
| **add(elemento)** | O(n) | O(1) ⭐ |
| **add(i, elemento)** | O(n) | O(n) |
| **remove(i)** | O(n) | O(n) |
| **contains(elemento)** | O(n) | O(n) |

#### ArrayList vs Array

| Aspecto | Array | ArrayList |
|---------|-------|-----------|
| **Tamanho** | Fixo | Dinâmico |
| **Tipo** | Primitivos OK | Só objetos (autoboxing) |
| **Performance** | Levemente mais rápido | Overhead mínimo |
| **Flexibilidade** | Baixa | Alta |
| **Uso de memória** | Exato | Pode desperdiçar |

---

### 3. LISTA LIGADA (LINKED LIST)

#### Conceito Central

**Linked List** = Sequência de nós, cada um apontando para o próximo

**Analogia**: Trem de vagões
- Cada vagão = nó (dados + ponteiro)
- Conexão entre vagões = referência "next"
- Para chegar no vagão 10, passa por 1, 2, 3... 9
- Fácil adicionar vagão entre 5 e 6 (reconectar)
- Impossível pular direto para vagão 10

#### Estrutura do Nó

```
┌──────────────┐
│  Nó          │
├──────────────┤
│ dados: T     │  ← Valor armazenado
│ next: Nó     │  ← Referência ao próximo
└──────────────┘
```

#### Tipos de Listas Ligadas

1. **Simplesmente Ligada**
    - Cada nó aponta para próximo
    - Percorre só para frente
    - Remoção precisa do nó anterior

2. **Duplamente Ligada**
    - Cada nó aponta para próximo E anterior
    - Percorre ambas direções
    - Remoção mais fácil (tem referência ao anterior)
    - Usa mais memória (2 ponteiros)

3. **Circular**
    - Último nó aponta para o primeiro
    - Não tem "fim"
    - Útil para round-robin

#### Complexidades

| Operação | Simplesmente | Duplamente |
|----------|--------------|------------|
| **Acesso** | O(n) | O(n) |
| **Busca** | O(n) | O(n) |
| **Inserção no início** | O(1) | O(1) |
| **Inserção no fim** | O(1)* | O(1) |
| **Inserção no meio** | O(n) | O(n) |
| **Remoção do início** | O(1) | O(1) |
| **Remoção do fim** | O(n) | O(1) ⭐ |

*Com referência à cauda mantida

#### LinkedList vs ArrayList

| Cenário | Vencedor | Por quê |
|---------|----------|---------|
| Acesso aleatório | ArrayList | O(1) vs O(n) |
| Inserção no início | LinkedList | O(1) vs O(n) |
| Inserção no fim | ArrayList | O(1) amortizado, cache |
| Iteração sequencial | ArrayList | Cache locality |
| Memória limitada | Depende | LinkedList overhead por nó vs ArrayList desperdício |

**Regra Geral**: Use ArrayList a menos que insira/remova MUITO no início!

---

### 4. PILHA (STACK) - LIFO

#### Conceito Central

**Stack** = Last In, First Out (LIFO)

**Analogias**:
- Pilha de pratos: só acessa o de cima
- Undo/Redo: última ação é a primeira a desfazer
- Chamadas de função: última chamada retorna primeiro

#### Operações Fundamentais

| Operação | Descrição | Complexidade |
|----------|-----------|--------------|
| **push(item)** | Adiciona no topo | O(1) |
| **pop()** | Remove e retorna topo | O(1) |
| **peek()** | Retorna topo sem remover | O(1) |
| **isEmpty()** | Verifica se vazia | O(1) |
| **size()** | Quantidade de elementos | O(1) |

#### Implementações Possíveis

1. **Com Array/ArrayList**
    - Topo = último elemento
    - push() = add()
    - pop() = remove(size-1)
    - Simples e eficiente

2. **Com Linked List**
    - Topo = primeiro nó
    - push() = addFirst()
    - pop() = removeFirst()
    - Sem limite de tamanho

#### Aplicações Clássicas

1. **Parsing de Expressões**
    - Parênteses balanceados: `((a + b) * c)`
    - Conversão infixa → pós-fixa
    - Avaliação de pós-fixa

2. **Undo/Redo**
    - Stack de estados anteriores
    - Stack de estados desfeitos

3. **Navegação (Browser)**
    - Stack de páginas visitadas
    - Voltar = pop()

4. **Call Stack**
    - Recursão usa pilha implícita
    - Cada chamada empilha frame

---

### 5. FILA (QUEUE) - FIFO

#### Conceito Central

**Queue** = First In, First Out (FIFO)

**Analogias**:
- Fila do banco: primeiro a chegar, primeiro atendido
- Impressora: imprime na ordem das requisições
- Breadth-First Search: processa nível por nível

#### Operações Fundamentais

| Operação | Descrição | Complexidade |
|----------|-----------|--------------|
| **enqueue(item)** | Adiciona no fim | O(1) |
| **dequeue()** | Remove e retorna início | O(1) |
| **front()** | Retorna início sem remover | O(1) |
| **isEmpty()** | Verifica se vazia | O(1) |
| **size()** | Quantidade de elementos | O(1) |

#### Implementações

1. **Com Array Circular**
    - Ponteiros front e rear
    - Quando rear chega no fim, volta ao início
    - Eficiente em espaço
    - Tamanho fixo

2. **Com Linked List**
    - front = primeiro nó
    - rear = último nó
    - Tamanho dinâmico
    - Leve overhead de ponteiros

#### Array Circular - Conceito

```
Estado inicial (capacidade 5):
front=0, rear=0
┌─┬─┬─┬─┬─┐
│ │ │ │ │ │
└─┴─┴─┴─┴─┘

Após 3 enqueues:
front=0, rear=3
┌─┬─┬─┬─┬─┐
│A│B│C│ │ │
└─┴─┴─┴─┴─┘

Após 2 dequeues + 3 enqueues:
front=2, rear=0 (deu a volta!)
┌─┬─┬─┬─┬─┐
│E│ │C│D│E│
└─┴─┴─┴─┴─┘
  ↑     ↑ ↑
rear  front
```

**Cálculo de índices**:
- `rear = (rear + 1) % capacity`
- `front = (front + 1) % capacity`
- `size = (rear - front + capacity) % capacity`

#### Tipos Especiais de Filas

1. **Fila de Prioridade**
    - Elemento com maior prioridade sai primeiro
    - Implementada com heap
    - enqueue: O(log n), dequeue: O(log n)

2. **Deque (Double-Ended Queue)**
    - Inserção/remoção em ambas pontas
    - addFirst(), addLast(), removeFirst(), removeLast()
    - Versátil: funciona como stack ou queue

---

### 6. DEQUE - ESTRUTURA VERSÁTIL

#### Conceito Central

**Deque** = Queue com acesso em ambas pontas

**Analogia**: Mesa de poker onde dealer pode dar cartas de cima ou de baixo do baralho

#### Operações

| Operação | Complexidade | Uso |
|----------|--------------|-----|
| **addFirst()** | O(1) | Adiciona no início |
| **addLast()** | O(1) | Adiciona no fim |
| **removeFirst()** | O(1) | Remove do início |
| **removeLast()** | O(1) | Remove do fim |
| **getFirst()** | O(1) | Espia início |
| **getLast()** | O(1) | Espia fim |

#### Implementação com Array Circular

Mesma lógica de queue circular, mas permite operações em ambas pontas:
- `front = (front - 1 + capacity) % capacity` para addFirst
- `rear = (rear + 1) % capacity` para addLast

#### Aplicações

1. **Histórico de Navegação**
    - Avançar/voltar páginas
    - Manter janela deslizante

2. **Algoritmos de Janela Deslizante**
    - Máximo/mínimo em janela
    - Palíndromos

3. **Steal Work Algorithm**
    - Thread pool pega tarefas de ambos lados
    - Balanceamento de carga

---

### 7. COMPARAÇÃO GERAL

#### Tabela Decisória

| Necessidade | Estrutura Recomendada | Por quê |
|-------------|----------------------|---------|
| Acesso aleatório frequente | ArrayList | O(1) get() |
| Inserção/remoção no início | LinkedList ou Deque | O(1) vs O(n) |
| Inserção/remoção no fim | ArrayList | O(1) amortizado + cache |
| LIFO (pilha) | Stack (ArrayList) | Simples e eficiente |
| FIFO (fila) | LinkedList ou ArrayDeque | Evita deslocamentos |
| Ambas pontas | ArrayDeque | Mais eficiente que LinkedList |
| Tamanho fixo conhecido | Array | Sem overhead |
| Iteração sequencial | ArrayList | Cache locality |

#### Performance na Prática

Para n = 1.000.000 de elementos:

| Operação | ArrayList | LinkedList | ArrayDeque |
|----------|-----------|------------|------------|
| get(i) | <1ms | ~500ms | N/A |
| add(fim) | ~5ms | ~50ms | ~5ms |
| add(início) | ~500ms | <1ms | <1ms |
| remove(início) | ~500ms | <1ms | <1ms |
| Iteração | ~5ms | ~30ms | ~5ms |
| Memória | Base + 50% | Base + 200% | Base + 100% |

**Conclusão**: ArrayDeque domina quando não precisa de acesso aleatório!

---

## 🌱 NÍVEL INICIANTE - EXERCÍCIOS {#nivel-iniciante}

### 📋 EXERCÍCIO 1: Array Dinâmico Básico

**Objetivo**: Implementar ArrayList do zero

**Requisitos**:
1. Classe `MeuArrayList<T>`:
    - Array interno genérico
    - Capacidade inicial: 10
    - Contador de elementos

2. Métodos obrigatórios:
    - `add(T elemento)`: adiciona no fim
    - `get(int indice)`: retorna elemento
    - `size()`: quantidade atual
    - `isEmpty()`: verifica se vazio
    - `clear()`: remove todos

3. Validações:
    - IndexOutOfBounds para índice inválido
    - Não permitir null (opcional)

**Teste com**:
- Adicionar 15 elementos (força expansão)
- get() de todos índices
- Tentar get(-1) e get(size)

**Aprenda**: Mecânica básica de array dinâmico

---

### 📋 EXERCÍCIO 2: Expansão Automática

**Objetivo**: Implementar estratégia de crescimento

**Requisitos**:
1. Adicione ao exercício anterior:
    - Método privado `expandir()`: dobra capacidade
    - Chamado automaticamente quando cheio
    - Copia elementos para novo array

2. Rastreie estatísticas:
    - Quantidade de expansões
    - Elementos copiados total
    - Capacidade atual vs tamanho

3. Compare estratégias:
    - Dobrar (×2)
    - Aumentar 50% (×1.5)
    - Aumentar fixo (+10)

**Teste com**:
- Adicionar 1000 elementos
- Calcular operações por estratégia
- Qual mais eficiente?

**Aprenda**: Análise amortizada na prática

---

### 📋 EXERCÍCIO 3: Lista Ligada Simples

**Objetivo**: Implementar linked list do zero

**Requisitos**:
1. Classe interna `Node<T>`:
    - dados: T
    - next: Node<T>

2. Classe `MinhaListaLigada<T>`:
    - Referência head (primeiro nó)
    - Contador de elementos

3. Métodos:
    - `addFirst(T elemento)`: insere no início
    - `addLast(T elemento)`: insere no fim
    - `removeFirst()`: remove do início
    - `size()`: quantidade
    - `toString()`: exibe todos elementos

**Teste com**:
- Adicionar 10 elementos no início
- Adicionar 10 elementos no fim
- Remover 5 do início
- Imprimir lista

**Aprenda**: Manipulação de referências

---

### 📋 EXERCÍCIO 4: Pilha com Array

**Objetivo**: Implementar stack usando ArrayList

**Requisitos**:
1. Classe `MinhaPilha<T>`:
    - Use ArrayList internamente
    - Encapsule: usuário não vê ArrayList

2. Métodos:
    - `push(T elemento)`: adiciona no topo
    - `pop()`: remove e retorna topo
    - `peek()`: retorna topo sem remover
    - `isEmpty()`: verifica se vazia
    - `size()`: quantidade

3. Validações:
    - pop() e peek() em pilha vazia: exceção

**Teste com**:
- Empilhar 1, 2, 3, 4, 5
- Desempilhar todos (deve sair 5, 4, 3, 2, 1)
- Tentar pop() vazia

**Aprenda**: LIFO behavior, encapsulamento

---

### 📋 EXERCÍCIO 5: Verificador de Parênteses

**Objetivo**: Aplicação clássica de pilha

**Requisitos**:
1. Método `boolean verificarParenteses(String expressao)`:
    - Retorna true se balanceados
    - Suporta: (), [], {}

2. Algoritmo:
    - Percorre string caractere por caractere
    - Abre ( [ { → push na pilha
    - Fecha ) ] } → pop e verifica se combina
    - Ao final, pilha deve estar vazia

**Teste com**:
- `"(a + b)"` → true
- `"((a + b) * c)"` → true
- `"((a + b)"` → false (falta fechar)
- `"(a + b))"` → false (sobra fechar)
- `"{[()]}"` → true
- `"{[(])}"` → false (ordem errada)

**Aprenda**: Aplicação prática de pilha

---

### 📋 EXERCÍCIO 6: Fila com Array Circular

**Objetivo**: Implementar queue eficiente

**Requisitos**:
1. Classe `MinhaFila<T>`:
    - Array interno de tamanho fixo
    - Ponteiros front e rear
    - Contador de elementos

2. Métodos:
    - `enqueue(T elemento)`: adiciona no fim
    - `dequeue()`: remove do início
    - `front()`: espia início
    - `isFull()`: verifica se cheia
    - `isEmpty()`: verifica se vazia

3. Lógica circular:
    - Quando rear chega no fim, volta ao início
    - Usar módulo: `(rear + 1) % capacity`

**Teste com**:
- Capacidade 5: enqueue 3, dequeue 2, enqueue 4
- Verificar que usa circularmente
- Tentar enqueue quando cheia

**Aprenda**: Array circular, eficiência de espaço

---

## 🌿 NÍVEL INTERMEDIÁRIO - EXERCÍCIOS {#nivel-intermediario}

### 📋 EXERCÍCIO 7: Lista Duplamente Ligada

**Objetivo**: Implementar doubly linked list

**Requisitos**:
1. Classe `Node<T>`:
    - dados: T
    - next: Node<T>
    - prev: Node<T>

2. Classe `ListaDuplamenteLigada<T>`:
    - Referências head e tail
    - Contador de elementos

3. Métodos:
    - `addFirst()`, `addLast()`
    - `removeFirst()`, `removeLast()`
    - `get(int indice)`: busca otimizada
    - `remove(int indice)`: remove posição específica
    - `reverse()`: inverte lista in-place

4. Otimização em get(i):
    - Se i < size/2: busca do início
    - Senão: busca do fim (backwards)

**Teste com**:
- Adicionar 100 elementos
- get(10) e get(90) - verificar que usa otimização
- Remover do meio, início e fim
- Inverter lista

**Aprenda**: Navegação bidirecional

---

### 📋 EXERCÍCIO 8: Lista Circular

**Objetivo**: Implementar circular linked list

**Requisitos**:
1. Lista onde último nó aponta para primeiro
2. Métodos:
    - `add(T elemento)`
    - `rotate()`: move head para próximo
    - `rotateN(int n)`: rotaciona n posições
    - `display()`: exibe a partir de head

3. Cuidados:
    - Não tem "null" no fim
    - Loops infinitos em iteração
    - Condição de parada correta

**Teste com**:
- Adicionar 5 elementos: A, B, C, D, E
- Rotacionar 2 posições (head vai para C)
- Iterar e garantir que não entra em loop infinito

**Aprenda**: Listas circulares, round-robin

---

### 📋 EXERCÍCIO 9: Iterator Customizado

**Objetivo**: Implementar Iterator para sua lista

**Requisitos**:
1. Implemente `Iterator<T>` para:
    - MeuArrayList
    - MinhaListaLigada

2. Métodos do Iterator:
    - `hasNext()`: verifica se tem próximo
    - `next()`: retorna próximo elemento
    - `remove()`: remove elemento atual (opcional)

3. Suporte a for-each:
    - Implemente `Iterable<T>` nas suas classes

**Teste com**:
- Iterar com while(hasNext())
- Iterar com for-each
- Modificar lista durante iteração (deve lançar ConcurrentModificationException)

**Aprenda**: Iterators, fail-fast

---

### 📋 EXERCÍCIO 10: Calculadora com Pilha

**Objetivo**: Avaliar expressões pós-fixas

**Requisitos**:
1. Método `int avaliar(String posfixa)`:
    - Recebe: "3 4 + 2 *" (notação polonesa reversa)
    - Retorna: 14

2. Algoritmo:
    - Percorre tokens (split por espaço)
    - Número: push na pilha
    - Operador: pop 2, calcula, push resultado

3. Suporte a:
    - Operadores: +, -, *, /
    - Números negativos
    - Divisão por zero (exceção)

**Teste com**:
- "5 1 2 + 4 * + 3 -" → 14
- "15 7 1 1 + - / 3 * 2 1 1 + + -" → 5
- Expressão inválida

**Aprenda**: Aplicação real de pilha

---

### 📋 EXERCÍCIO 11: Conversão Infixa → Pós-fixa

**Objetivo**: Converter notação matemática

**Requisitos**:
1. Método `String infixaParaPosfixa(String infixa)`:
    - Entrada: "(3 + 4) * 2"
    - Saída: "3 4 + 2 *"

2. Algoritmo (Shunting Yard):
    - Pilha de operadores
    - Fila de saída
    - Regras de precedência

3. Suporte a:
    - Parênteses
    - Precedência (+-, */, ^)
    - Associatividade

**Teste com**:
- "3 + 4 * 2" → "3 4 2 * +"
- "(3 + 4) * 2" → "3 4 + 2 *"
- "3 + 4 * 2 / (1 - 5) ^ 2" → complexo

**Aprenda**: Parsing com pilha, precedência

---

### 📋 EXERCÍCIO 12: Simulador de Fila de Atendimento

**Objetivo**: Simulação com queue

**Requisitos**:
1. Classes:
    - `Cliente`: nome, tempoChegada, tempoAtendimento
    - `FilaAtendimento`: gerencia fila

2. Simulação:
    - Clientes chegam em tempos aleatórios
    - Cada um precisa de tempo aleatório de atendimento
    - Um atendente processa fila FIFO

3. Estatísticas:
    - Tempo médio de espera
    - Tempo máximo de espera
    - Taxa de ocupação do atendente
    - Tamanho máximo da fila

**Teste com**:
- 100 clientes em 1 hora
- Variação de tempo de atendimento
- Múltiplos atendentes (bonus)

**Aprenda**: Simulação discreta, filas

---

## 🌳 NÍVEL AVANÇADO - EXERCÍCIOS {#nivel-avancado}

### 📋 EXERCÍCIO 13: Fila de Prioridade com Heap

**Objetivo**: Implementar priority queue eficiente

**Requisitos**:
1. Classe `FilaPrioridade<T extends Comparable<T>>`:
    - Heap binário (array)
    - MinHeap ou MaxHeap (configurável)

2. Métodos:
    - `add(T elemento)`: O(log n)
    - `poll()`: remove min/max O(log n)
    - `peek()`: retorna min/max O(1)
    - `heapify()`: constrói heap de array

3. Operações de heap:
    - bubbleUp(): após inserção
    - bubbleDown(): após remoção
    - Índices: pai=(i-1)/2, filho_esq=2i+1, filho_dir=2i+2

**Teste com**:
- Adicionar 20 números aleatórios
- Remover todos (deve sair em ordem)
- Verificar que mantém propriedade de heap

**Aprenda**: Heaps, priorização eficiente

---

### 📋 EXERCÍCIO 14: Deque com Array Circular

**Objetivo**: Implementar deque eficiente

**Requisitos**:
1. Classe `MeuDeque<T>`:
    - Array circular
    - Operações em ambas pontas O(1)

2. Métodos:
    - `addFirst()`, `addLast()`
    - `removeFirst()`, `removeLast()`
    - `getFirst()`, `getLast()`
    - Expansão automática quando cheio

3. Desafios:
    - addFirst decrementa front circularmente
    - Manter size correto
    - Expansão mantém ordem

**Teste com**:
- Alternar addFirst e addLast
- Alternar removeFirst e removeLast
- Verificar ordem correta

**Aprenda**: Estrutura versátil, módulo aritmético

---

### 📋 EXERCÍCIO 15: Skip List

**Objetivo**: Lista ligada com níveis

**Requisitos**:
1. Estrutura:
    - Múltiplos níveis de listas ligadas
    - Nível 0: todos elementos
    - Níveis acima: "atalhos"

2. Operações:
    - `search(T elemento)`: O(log n) esperado
    - `insert(T elemento)`: O(log n)
    - `delete(T elemento)`: O(log n)

3. Lógica de níveis:
    - Novo elemento: sorteia altura (moeda)
    - Atualiza ponteiros em todos níveis

**Teste com**:
- Inserir 1000 elementos
- Comparar tempo de busca com lista normal
- Verificar que níveis reduzem busca

**Aprenda**: Estrutura probabilística, trade-offs

---

### 📋 EXERCÍCIO 16: LRU Cache

**Objetivo**: Cache com política LRU

**Requisitos**:
1. Classe `LRUCache<K, V>`:
    - Capacidade limitada
    - Remove menos recentemente usado

2. Estruturas:
    - HashMap para acesso O(1)
    - Lista duplamente ligada para ordem de uso

3. Métodos:
    - `get(K key)`: O(1) - move para início
    - `put(K key, V value)`: O(1) - adiciona ou atualiza
    - Quando cheio: remove do fim da lista

**Teste com**:
- Capacidade 3: put(1,a), put(2,b), put(3,c)
- get(1) - move 1 para início
- put(4,d) - remove 2 (menos recente)

**Aprenda**: Estruturas combinadas, LRU

---

### 📋 EXERCÍCIO 17: Editor de Texto com Undo/Redo

**Objetivo**: Sistema completo com stacks

**Requisitos**:
1. Classe `EditorTexto`:
    - Texto atual: StringBuilder
    - Stack de ações (undo)
    - Stack de ações desfeitas (redo)

2. Ações:
    - `inserir(String texto, int pos)`
    - `deletar(int pos, int len)`
    - `undo()`: desfaz última ação
    - `redo()`: refaz ação desfeita

3. Padrão Command:
    - Interface `Action`: execute(), undo()
    - Cada ação implementa

**Teste com**:
- Inserir "Hello"
- Inserir " World"
- Deletar 5 caracteres
- Undo 2x
- Redo 1x
- Verificar texto final

**Aprenda**: Command pattern, pilhas duplas

---

### 📋 EXERCÍCIO 18: Merge K Sorted Lists

**Objetivo**: Problema de entrevista clássico

**Requisitos**:
1. Método `ListNode mergeKLists(ListNode[] lists)`:
    - Recebe k listas ligadas ordenadas
    - Retorna 1 lista ordenada com todos elementos

2. Abordagens:
    - **Naive**: Merge 2 a 2 - O(kN)
    - **Min Heap**: Heap com próximo de cada lista - O(N log k)
    - **Divide & Conquer**: Merge recursivo - O(N log k)

3. Implemente todas 3 e compare

**Teste com**:
- k=3: [1,4,5], [1,3,4], [2,6]
- k=100: listas grandes
- Meça tempo de cada abordagem

**Aprenda**: Otimização, heap aplicado

---

## 🚀 PROJETOS INTEGRADORES {#projetos}

### PROJETO 1: Sistema de Gerenciamento de Tarefas (40-60h)

**Descrição**: Aplicação completa com múltiplas estruturas

**Funcionalidades**:

1. **Gerenciamento de Tarefas**:
    - ArrayList: lista de todas tarefas
    - PriorityQueue: tarefas por prioridade
    - LinkedList: histórico de ações

2. **Categorias e Tags**:
    - HashMap: tarefas por categoria
    - HashSet: tags únicas

3. **Undo/Redo**:
    - Stack: ações de criar/editar/deletar
    - Command pattern completo

4. **Notificações**:
    - Queue: lembretes pendentes
    - Processamento FIFO

5. **Pesquisa e Filtros**:
    - Busca por título, descrição, tag
    - Filtros combinados
    - Ordenação customizada

**Requisitos Técnicos**:
- Persistência (JSON/XML)
- Interface CLI ou GUI básica
- Testes unitários completos
- Documentação JavaDoc

**Entregáveis**:
- Código fonte
- Diagrama de classes
- Manual de usuário
- Casos de teste

---

### PROJETO 2: Simulador de Sistema Operacional (50-70h)

**Descrição**: Simulação de gerenciamento de processos

**Componentes**:

1. **Gerenciador de Processos**:
    - PriorityQueue: processos por prioridade
    - Estado: novo, pronto, executando, bloqueado, terminado
    - Escalonamento: Round-Robin, SJF, Prioridade

2. **Gerenciador de Memória**:
    - ArrayList: blocos de memória
    - First Fit / Best Fit / Worst Fit
    - Compactação de memória

3. **Sistema de Arquivos**:
    - Árvore: estrutura hierárquica
    - HashMap: acesso rápido por path
    - LinkedList: blocos de arquivo

4. **Fila de I/O**:
    - Queue: requisições de disco
    - Simulação de tempo de acesso
    - Estatísticas de throughput

5. **Visualização**:
    - Gráfico de Gantt
    - Uso de memória ao longo do tempo
    - Métricas de performance

**Métricas a Calcular**:
- Tempo médio de espera
- Turnaround time
- Utilização da CPU
- Throughput
- Fragmentação de memória

**Tecnologias**:
- Java Core
- JavaFX/Swing para visualização
- Simulação discreta

**Aprenda**: Aplicação real de todas estruturas, algoritmos de SO

---

## 📚 RECURSOS DE ESTUDO {#recursos}

### 📖 Livros Essenciais

1. **"Data Structures and Algorithms in Java" - Robert Lafore**
    - Capítulos: 3-7 (Arrays, Stacks, Queues, Linked Lists)
    - Nível: Iniciante a Intermediário
    - Por que: Visualizações excelentes, workshops práticos
    - Código: Disponível online

2. **"Algorithms" - Sedgewick & Wayne** (4ª Edição)
    - Capítulos: 1.3 (Bags, Queues, Stacks), 1.4 (Analysis)
    - Nível: Intermediário
    - Por que: Implementações em Java, análise rigorosa
    - Site: https://algs4.cs.princeton.edu

3. **"Introduction to Algorithms" - CLRS**
    - Capítulos: 10 (Elementary Data Structures)
    - Nível: Avançado
    - Por que: Análise matemática profunda

4. **"Data Structures & Problem Solving Using Java" - Weiss**
    - Capítulos: 3-4, 6
    - Nível: Todos
    - Por que: Foco em problem solving

### 🎓 Cursos Online

1. **Princeton - Algorithms Part I (Coursera)**
    - Instrutor: Robert Sedgewick
    - Weeks 1-2: Stacks, Queues, Bags
    - Gratuito para audit
    - Assignments em Java

2. **UC San Diego - Data Structures (Coursera)**
    - Duração: 6 semanas
    - Foco: Implementação prática
    - Projetos hands-on

3. **MIT 6.006 - Introduction to Algorithms**
    - Lectures 2-3: Data Structures
    - Gratuito: MIT OCW
    - Nível: Avançado

### 🎥 Canais YouTube

1. **mycodeschool**
    - Série: Data Structures
    - Tópicos: Arrays, Linked Lists, Stacks, Queues
    - Visual e didático

2. **Abdul Bari**
    - Playlists específicas por estrutura
    - Animações detalhadas

3. **CS Dojo**
    - Data Structures for Beginners
    - Exemplos práticos

### 🌐 Recursos Interativos

1. **VisuAlgo** (https://visualgo.net)
    - Linked List, Stack, Queue
    - Animações passo a passo
    - Suporta inputs customizados

2. **Data Structure Visualizations** (https://www.cs.usfca.edu/~galles/visualization/)
    - USF - University of San Francisco
    - Todas estruturas lineares
    - Código + visualização

3. **Algorithm Visualizer** (https://algorithm-visualizer.org)
    - Código editável
    - Visualização em tempo real

### 📄 Documentação e Artigos

1. **Java Collections Framework**
    - Javadoc oficial: https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
    - Leia implementações: ArrayList, LinkedList, ArrayDeque

2. **"Amortized Analysis Explained"** - CLRS Capítulo 17
    - Por que ArrayList.add() é O(1) amortizado
    - Técnicas: Aggregate, Accounting, Potential

3. **LeetCode Discuss**
    - Soluções comentadas
    - Trade-offs discutidos
    - Otimizações avançadas

### 🏆 Plataformas de Prática

1. **LeetCode - Tagged Problems**
    - Tag: Array, Linked List, Stack, Queue
    - Easy: 50+, Medium: 100+, Hard: 30+
    - Company tags (FAANG)

2. **HackerRank - Data Structures**
    - Arrays, Linked Lists, Stacks, Queues
    - Certificação disponível

3. **GeeksforGeeks Practice**
    - Problemas categorizados
    - Artigos explicativos
    - Múltiplas soluções

4. **Codeforces**
    - Competitive programming
    - Problemas envolvendo estruturas

### 🛠️ Ferramentas

1. **Java Visualizer** (https://cscircles.cemc.uwaterloo.ca/java_visualize/)
    - Execução passo a passo
    - Visualiza memória

2. **IntelliJ IDEA Debugger**
    - Visualize estruturas em runtime
    - Evaluate expressions
    - Memory view

3. **JProfiler**
    - Profile uso de ArrayList vs LinkedList
    - Identifique gargalos

---

## ✅ CHECKLIST DE AVALIAÇÃO {#checklist}

### Nível Iniciante

- [ ] Implemento array dinâmico com expansão automática
- [ ] Entendo complexidade O(1) amortizado
- [ ] Crio lista ligada simples do zero
- [ ] Implemento pilha e entendo LIFO
- [ ] Implemento fila e entendo FIFO
- [ ] Uso pilha para resolver problemas (parênteses)
- [ ] Entendo array circular

**Teste Prático**: Implemente ArrayList básico sem olhar referências

---

### Nível Intermediário

- [ ] Implemento lista duplamente ligada
- [ ] Crio iterators customizados
- [ ] Implemento lista circular
- [ ] Uso pilha para parsing (calculadora RPN)
- [ ] Converto infixa para pós-fixa
- [ ] Simulo sistemas com filas
- [ ] Comparo estruturas por performance

**Teste Prático**: Resolva 20 problemas médios no LeetCode

---

### Nível Avançado

- [ ] Implemento fila de prioridade com heap
- [ ] Crio deque eficiente com array circular
- [ ] Implemento skip list
- [ ] Combino estruturas (LRU cache)
- [ ] Uso Command pattern com stacks
- [ ] Otimizo problemas com estrutura certa
- [ ] Analiso trade-offs tempo vs espaço

**Teste Prático**: Implemente LRU Cache em 30 minutos

---

## 🎯 PRÓXIMOS PASSOS

1. **Trilha 4**: Estruturas Não-Lineares
    - Árvores, Heaps, Hash Tables
    - Estruturas hierárquicas

2. **Trilha 5**: Teoria dos Grafos
    - Grafos = estrutura mais versátil
    - Algoritmos clássicos

3. **Competitive Programming**
    - Codeforces, AtCoder
    - Prática intensiva

---

## 📝 CONCLUSÃO

**Você agora domina**:
✅ Arrays, ArrayLists e crescimento dinâmico
✅ Listas ligadas (simples, duplas, circulares)
✅ Pilhas e aplicações (parsing, undo/redo)
✅ Filas e variações (priority, deque)
✅ Quando usar cada estrutura
✅ Trade-offs de performance

**Impacto**:
- 70% dos problemas algorítmicos usam essas estruturas
- Base para árvores, grafos, hashing
- Essencial em entrevistas técnicas

**Continue praticando! Estruturas lineares são a fundação de tudo em CS! 🚀**
# 🎓 Guia Didático Visual: Estruturas de Dados e Algoritmos

## 🎯 Como Usar Este Guia

Este guia foi projetado para **aprender fazendo**, com explicações visuais e analogias do mundo real. Cada trilha progride do **iniciante ao avançado**, construindo conhecimento de forma incremental.

### 📚 Metodologia de Aprendizado

```
🔍 ENTENDA → 🎨 VISUALIZE → 🛠️ PRATIQUE → 🧪 TESTE → 🚀 APLIQUE
```

**Para cada exercício:**
1. **Leia a analogia** (conecta com o mundo real)
2. **Estude o diagrama** (visualiza o conceito)
3. **Siga o passo a passo** (implementa gradualmente)
4. **Teste diferentes cenários** (consolida o aprendizado)
5. **Aplique em projetos** (usa na prática)

---

# 🏗️ TRILHA 1: Fundamentos Java & Boas Práticas

## 🎯 **Analogia da Trilha**: Construindo uma Casa

Imagine que você vai construir uma casa. Antes de erguer as paredes, você precisa de:
- **Fundação sólida** (conceitos básicos)
- **Plantas bem definidas** (estruturas de classes)
- **Materiais de qualidade** (boas práticas)
- **Ferramentas adequadas** (Generics, Enums, etc.)

---

## 🌱 **NÍVEL INICIANTE**

### 📋 **Exercício 1: A Carteira de Identidade (Classes Básicas)**

**🎭 Analogia**: Uma carteira de identidade contém informações pessoais organizadas. Cada pessoa tem uma carteira única com dados específicos.

**🎨 Visualização**:
```
┌─────────────────────────┐
│    CARTEIRA DE ID       │
├─────────────────────────┤
│ Nome: João Silva        │
│ CPF: 123.456.789-00     │
│ Idade: 28               │
│ Altura: 1.75m           │
│ ────────────────────    │
│ 📝 apresentar()         │
│ 🔄 atualizarIdade()     │
└─────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Identifique os dados**: Que informações uma pessoa tem?
2. **Defina comportamentos**: O que uma pessoa pode fazer?
3. **Organize em classe**: Agrupe dados relacionados
4. **Proteja os dados**: Use private para encapsulamento
5. **Crie métodos de acesso**: Getters e setters controlados

**🧪 Cenários de Teste**:
- Criar várias pessoas com dados diferentes
- Tentar acessar dados diretamente (deve falhar)
- Modificar dados através dos métodos
- Apresentar informações formatadas

### 📋 **Exercício 2: A Caixa de Ferramentas (Arrays e Métodos)**

**🎭 Analogia**: Um carpinteiro tem uma caixa com diferentes ferramentas. Ele precisa encontrar a ferramenta certa rapidamente e saber quantas tem de cada tipo.

**🎨 Visualização**:
```
┌─────────────────────────────────────┐
│          CAIXA DE FERRAMENTAS       │
├─────┬─────┬─────┬─────┬─────┬─────┤
│  🔨 │  🪚 │  📏 │  🔧 │  ✂️ │  📐  │
├─────┼─────┼─────┼─────┼─────┼─────┤
│  0  │  1  │  2  │  3  │  4  │  5  │
└─────┴─────┴─────┴─────┴─────┴─────┘

Operações:
📦 adicionar() → Guarda nova ferramenta
🔍 buscar() → Encontra ferramenta específica
📊 contar() → Conta ferramentas de um tipo
```

**🛠️ Como Fazer**:
1. **Defina o container**: Array para guardar as ferramentas
2. **Implemente busca**: Percorra o array procurando o item
3. **Conte elementos**: Use loop para contar ocorrências
4. **Adicione validação**: Verifique se há espaço disponível
5. **Organize métodos**: Cada operação em seu próprio método

### 📋 **Exercício 3: O Dicionário de Palavras (Strings e Algoritmos)**

**🎭 Analogia**: Um dicionário analisa palavras - conta letras, verifica palíndromos, inverte texto. É como ter um assistente linguístico.

**🎨 Visualização**:
```
Palavra: "ARARA"
┌─┬─┬─┬─┬─┐
│A│R│A│R│A│
└─┴─┴─┴─┴─┘
 ↑       ↑
 │   ←───┤
 └───→   │ ← Palíndromo: lê igual nos dois sentidos

Análise:
🔤 Vogais: A, A, A (3 vogais)
🔄 Invertida: ARARA (igual!)
✅ É palíndromo: SIM
```

**🛠️ Como Fazer**:
1. **Analise caractere por caractere**: Use loop para percorrer string
2. **Classifique letras**: Vogais vs consoantes
3. **Compare posições**: Primeiro com último, segundo com penúltimo...
4. **Construa resultado**: Acumule informações durante o processamento
5. **Retorne análise**: Organize resultados de forma clara

---

## 🌿 **NÍVEL INTERMEDIÁRIO**

### 📋 **Exercício 1: A Caixa Mágica Multiuso (Generics)**

**🎭 Analogia**: Imagine uma caixa mágica que pode guardar qualquer tipo de objeto mantendo sua forma original. Uma caixa para livros sempre entrega livros, uma para ferramentas sempre entrega ferramentas.

**🎨 Visualização**:
```
         CAIXA GENÉRICA <T>
    ┌─────────────────────────┐
    │     Tipo: <T>          │
    ├─────────────────────────┤
    │  ┌─────────────────┐   │
    │  │       📦        │   │ ← Conteúdo do tipo T
    │  │     Item: T     │   │
    │  └─────────────────┘   │
    ├─────────────────────────┤
    │ 📥 guardar(T item)      │
    │ 📤 retirar() → T        │
    │ ❓ estaVazia() → bool   │
    └─────────────────────────┘

Exemplos de Uso:
Caixa<Livro> 📚 → Só aceita e retorna livros
Caixa<Ferramenta> 🔧 → Só aceita e retorna ferramentas
Caixa<Integer> 🔢 → Só aceita e retorna números
```

**🛠️ Como Fazer**:
1. **Defina o template**: Use `<T>` para representar qualquer tipo
2. **Armazene com segurança**: O tipo T garante consistência
3. **Valide operações**: Só aceite objetos do tipo correto
4. **Teste com diferentes tipos**: Strings, números, objetos customizados
5. **Implemente verificações**: Empty, full, etc.

### 📋 **Exercício 2: O Calendário Inteligente (Enums)**

**🎭 Analogia**: Um calendário que "conhece" os dias da semana. Ele sabe quais são úteis, feriados, pode calcular diferenças entre dias, e organizar atividades.

**🎨 Visualização**:
```
                    DIAS DA SEMANA
┌───────┬───────┬───────┬───────┬───────┬───────┬───────┐
│   SEG │   TER │   QUA │   QUI │   SEX │   SAB │   DOM │
├───────┼───────┼───────┼───────┼───────┼───────┼───────┤
│   💼  │   💼  │   💼  │   💼  │   💼  │   🏖️  │   🏖️  │
│ Útil  │ Útil  │ Útil  │ Útil  │ Útil  │ Livre │ Livre │
└───────┴───────┴───────┴───────┴───────┴───────┴───────┘

Funcionalidades:
📅 proximoDia() → Calcula o próximo dia
📊 diasAte(dia) → Conta dias até outro dia  
💼 isDiaUtil() → Verifica se é dia de trabalho
📋 agendar(tarefa) → Organiza atividades por dia
```

**🛠️ Como Fazer**:
1. **Defina os valores**: Cada dia com suas propriedades
2. **Adicione comportamentos**: Métodos que fazem sentido para dias
3. **Implemente lógica cíclica**: Segunda após domingo
4. **Categorize dias**: Úteis vs fins de semana
5. **Crie agenda**: Use enum para organizar tarefas

### 📋 **Exercício 3: A Biblioteca Organizada (Classes Internas)**

**🎭 Analogia**: Uma biblioteca onde os livros "pertencem" à biblioteca. Cada livro conhece sua biblioteca e pode interagir com o sistema interno.

**🎨 Visualização**:
```
                    🏛️ BIBLIOTECA
    ┌─────────────────────────────────────────────┐
    │  Nome: "Biblioteca Central"                 │
    │  📚 Acervo: Lista de livros                │
    │  👥 Usuários: Lista de membros             │
    ├─────────────────────────────────────────────┤
    │                                            │
    │  📖 LIVRO (classe interna)                │
    │  ┌─────────────────────────────────────┐   │
    │  │ ISBN: 978-123456789                │   │
    │  │ Título: "Java para Iniciantes"     │   │
    │  │ Status: Disponível                 │   │
    │  │ ─────────────────────────────────  │   │
    │  │ 📤 emprestar(usuario)              │   │ ← Acessa dados
    │  │ 📥 devolver()                      │   │   da biblioteca
    │  │ 📍 localizacao()                   │   │   diretamente
    │  └─────────────────────────────────────┘   │
    └─────────────────────────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Identifique relacionamentos**: Que objetos "pertencem" a outros?
2. **Defina acesso**: Classes internas podem acessar membros privados
3. **Implemente interações**: Livro se comunica com biblioteca
4. **Organize funcionalidades**: Separe responsabilidades logicamente
5. **Teste integração**: Verifique comunicação between classes

---

## 🌳 **NÍVEL AVANÇADO**

### 📋 **Exercício 1: A Fábrica de Computadores (Builder Pattern)**

**🎭 Analogia**: Uma fábrica que monta computadores personalizados. Cada cliente escolhe componentes passo a passo, e a fábrica garante que tudo seja compatível.

**🎨 Visualização**:
```
                    FÁBRICA DE COMPUTADORES
    ┌─────────────────────────────────────────────────┐
    │                 💻 BUILDER                       │
    ├─────────────────────────────────────────────────┤
    │  Passo 1: 🧠 CPU        → "Intel i7"           │
    │  Passo 2: 🧠 RAM        → "16GB DDR4"          │
    │  Passo 3: 💾 SSD        → "500GB NVMe"         │
    │  Passo 4: 🎮 GPU        → "RTX 3070"           │
    │  Passo 5: ⚡ Fonte      → "650W"               │
    ├─────────────────────────────────────────────────┤
    │  🔧 build() → Monta o computador final         │
    └─────────────────────────────────────────────────┘

    Resultado:
    ┌─────────────────────┐
    │  💻 COMPUTADOR      │
    │  ─────────────────  │
    │  Todos componentes  │
    │  validados e        │
    │  funcionando        │
    └─────────────────────┘
```

**🛠️ Como Fazer**:
1. **Identifique etapas**: Que passos são necessários para construir?
2. **Crie o builder**: Classe que acumula configurações
3. **Valide compatibilidade**: Componentes devem funcionar juntos
4. **Implemente fluent interface**: Métodos que retornam o builder
5. **Finalize construção**: Método build() cria objeto final

### 📋 **Exercício 2: O Inspetor de Objetos (Reflection)**

**🎭 Analogia**: Um detetive que pode examinar qualquer objeto e descobrir todos os seus segredos - que métodos tem, que atributos esconde, que pode fazer.

**🎨 Visualização**:
```
            🔍 INSPETOR DE OBJETOS
    ┌─────────────────────────────────────────┐
    │          Objeto Misterioso: 📦          │
    └─────────────────┬───────────────────────┘
                      │
                      ▼
    ┌─────────────────────────────────────────┐
    │           🔍 ANÁLISE                    │
    ├─────────────────────────────────────────┤
    │  📋 Classe: "Pessoa"                   │
    │  🏷️  Atributos encontrados:             │
    │      • String nome (privado)           │
    │      • int idade (privado)             │
    │      • double altura (privado)         │
    │  ⚙️  Métodos encontrados:               │
    │      • getNome() → String              │
    │      • setIdade(int) → void           │
    │      • apresentar() → String          │
    │  🎯 Pode executar:                     │
    │      • Chamar getNome() → "João"       │
    │      • Chamar apresentar() → "Olá!"   │
    └─────────────────────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Obtenha a classe**: Use getClass() ou Class.forName()
2. **Explore estrutura**: getDeclaredFields(), getDeclaredMethods()
3. **Acesse membros**: setAccessible(true) para membros privados
4. **Execute dinamicamente**: invoke() para chamar métodos
5. **Trate exceções**: Reflection gera várias exceções possíveis

### 📋 **Exercício 3: O Medidor de Performance (Anotações)**

**🎭 Analogia**: Etiquetas especiais que você cola em métodos para que um robô meça automaticamente quanto tempo cada um demora para executar.

**🎨 Visualização**:
```
                🏷️ ANOTAÇÃO PERSONALIZADA
    ┌─────────────────────────────────────────────┐
    │        @MedirTempo                          │
    │        ├─ target: METHOD                   │
    │        ├─ retention: RUNTIME               │
    │        └─ inherited: true                  │
    └─────────────────────────────────────────────┘
                          │
                          ▼
    ┌─────────────────────────────────────────────┐
    │  📊 MÉTODO ANOTADO                         │
    │  ┌─────────────────────────────────────┐   │
    │  │ @MedirTempo                         │   │
    │  │ public void calcularPi() {          │   │
    │  │     // código complexo aqui...      │   │
    │  │ }                                   │   │
    │  └─────────────────────────────────────┘   │
    └─────────────────────────────────────────────┘
                          │
                          ▼
    ┌─────────────────────────────────────────────┐
    │  ⏱️ RESULTADO AUTOMÁTICO                   │
    │  "calcularPi() executou em 145ms"         │
    └─────────────────────────────────────────────┘
```

**🛠️ Como Fazer**:
1. **Crie a anotação**: Define @interface com configurações
2. **Implemente processador**: Código que encontra anotações
3. **Meça execução**: Capture tempo antes e depois
4. **Intercept métodos**: Use reflection para "interceptar" execução
5. **Reporte resultados**: Log ou armazene informações de performance

---


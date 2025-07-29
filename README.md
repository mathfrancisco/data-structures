# 🚀 Jornada Completa: Estruturas de Dados e Algoritmos em Java

> *"A diferença entre um programador iniciante e um experiente não está na sintaxe que conhece, mas na eficiência dos algoritmos que consegue projetar."*

Este repositório é um **guia completo e prático** para dominar estruturas de dados e algoritmos usando Java. Projetado para estudantes, profissionais em transição de carreira e desenvolvedores que querem solidificar seus fundamentos em ciência da computação.

## 🎯 Objetivos de Aprendizado

Ao final desta jornada, você será capaz de:

- ✅ Analisar a complexidade de algoritmos usando Big-O
- ✅ Escolher a estrutura de dados mais adequada para cada problema
- ✅ Implementar estruturas de dados do zero
- ✅ Resolver problemas algorítmicos de forma eficiente
- ✅ Otimizar código para melhor performance
- ✅ Passar em entrevistas técnicas com confiança

## 📊 Roadmap Visual de Estudos

```
INICIANTE (4-6 semanas)
├── Trilha 1: Fundamentos Java
├── Trilha 2: Big-O (Básico)
├── Trilha 3: Arrays e Listas
└── Trilha 4: Árvores Simples

INTERMEDIÁRIO (6-8 semanas)
├── Trilha 2: Big-O (Avançado)
├── Trilha 3: Estruturas Avançadas
├── Trilha 4: Árvores Balanceadas
└── Trilha 5: Grafos Básicos

AVANÇADO (8-10 semanas)
├── Trilha 5: Algoritmos de Grafos
├── Trilha 6: Algoritmos Clássicos
├── Projetos Práticos
└── Preparação para Entrevistas
```

## 🏗️ Arquitetura do Projeto

```
data-structures-java/
├── 📁 trilha1-fundamentos/
│   ├── 📝 README.md                    # Guia da trilha
│   ├── 📋 Guia-Trilha1.md
│   └── 💻 src/
│       ├── exemplos/
│       ├── exercicios/
│       └── testes/
├── 📁 trilha2-complexidade/
├── 📁 trilha3-estruturas-lineares/
├── 📁 trilha4-estruturas-nao-lineares/
├── 📁 trilha5-grafos/
├── 📁 trilha6-algoritmos-classicos/
├── 📁 projetos-praticos/
└── 📁 recursos/
    ├── 📊 visualizacoes/
    ├── 📚 referencias/
    └── 🧪 templates-teste/
```

---

## 🛤️ Trilhas de Conhecimento

### 🔧 TRILHA 1 – Fundamentos Java & Boas Práticas

**Tempo estimado**: 2-3 semanas | **Pré-requisitos**: Conhecimentos básicos de Java

#### 📚 Conceitos Abordados
- Generics e Type Safety
- Padrões de Design (Builder, Factory)
- Reflection e Anotações
- Tratamento de Exceções
- Documentação e Testes

#### 💡 Por que é importante?
Antes de mergulhar em estruturas complexas, é essencial dominar os fundamentos que tornarão seu código mais limpo, seguro e maintível.

#### 🎯 Projeto Final
Implementar um sistema de biblioteca com padrões de design adequados.

---

### 📊 TRILHA 2 – Análise de Algoritmos & Complexidade

**Tempo estimado**: 3-4 semanas | **Pré-requisitos**: Trilha 1

#### 📚 Conceitos Abordados
- Notação Big-O, Θ (Theta) e Ω (Omega)
- Análise de melhor, médio e pior caso
- Complexidade de tempo vs. espaço
- Análise amortizada
- Profiling e medição prática

#### 💡 Exemplo Prático - Comparando Algoritmos

```java
// ❌ Algoritmo Ineficiente - O(n²)
public boolean temDuplicatas(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) return true;
        }
    }
    return false;
}

// ✅ Algoritmo Eficiente - O(n)
public boolean temDuplicatas(int[] array) {
    Set<Integer> vistos = new HashSet<>();
    for (int num : array) {
        if (!vistos.add(num)) return true;
    }
    return false;
}
```

#### 🎯 Projeto Final
Criar um benchmark comparativo de diferentes algoritmos de ordenação.

---

### 📝 TRILHA 3 – Estruturas Lineares

**Tempo estimado**: 4-5 semanas | **Pré-requisitos**: Trilha 2

#### 📚 Estruturas Implementadas
- **Arrays Dinâmicos**: Implementação similar ao ArrayList
- **Listas Ligadas**: Simples, dupla e circular
- **Pilhas**: Implementação com array e lista ligada
- **Filas**: Simples, circular e de prioridade
- **Deques**: Double-ended queue otimizada

#### 💡 Quando Usar Cada Estrutura?

| Estrutura | Acesso | Inserção | Remoção | Melhor Para |
|-----------|--------|----------|---------|-------------|
| Array | O(1) | O(n) | O(n) | Dados de tamanho fixo |
| Lista Ligada | O(n) | O(1) | O(1) | Inserções/remoções frequentes |
| Pilha | - | O(1) | O(1) | LIFO, recursão, parsing |
| Fila | - | O(1) | O(1) | FIFO, processamento por lotes |

#### 🎯 Projeto Final
Sistema de gerenciamento de tarefas com diferentes estruturas.

---

### 🌳 TRILHA 4 – Estruturas Não Lineares

**Tempo estimado**: 5-6 semanas | **Pré-requisitos**: Trilha 3

#### 📚 Estruturas Implementadas

**Árvores**:
- Árvore Binária básica
- Árvore Binária de Busca (BST)
- Árvore AVL (auto-balanceada)
- Árvore Rubro-Negra
- Heap (Min e Max)

**Tabelas Hash**:
- Hash com encadeamento
- Hash com endereçamento aberto
- Funções hash personalizadas

#### 💡 Visualização de Árvore AVL

```
     Antes da Rotação          Após Rotação à Direita
         A                           B
        / \                         / \
       B   C          →            D   A
      / \                             / \
     D   E                           E   C
```

#### 🎯 Projeto Final
Implementar um banco de dados simples com indexação por árvore B+.

---

### 🕸️ TRILHA 5 – Teoria dos Grafos

**Tempo estimado**: 4-5 semanas | **Pré-requisitos**: Trilha 4

#### 📚 Conceitos e Algoritmos

**Representações**:
- Matriz de adjacência
- Lista de adjacência
- Matriz de incidência

**Algoritmos de Percurso**:
- DFS (Depth-First Search)
- BFS (Breadth-First Search)

**Algoritmos de Caminho**:
- Dijkstra (menor caminho)
- Bellman-Ford (com pesos negativos)
- Floyd-Warshall (todos os pares)

**Algoritmos de Árvore**:
- Kruskal (árvore geradora mínima)
- Prim (árvore geradora mínima)

#### 💡 Aplicações Práticas
- Sistema de navegação GPS
- Redes sociais (grau de separação)
- Otimização de rotas de entrega
- Análise de dependências em projetos

#### 🎯 Projeto Final
Simulador de rede social com análise de comunidades.

---

### 🧮 TRILHA 6 – Algoritmos Clássicos

**Tempo estimado**: 6-8 semanas | **Pré-requisitos**: Trilha 5

#### 📚 Categorias de Algoritmos

**Ordenação**:
- Simples: Bubble, Selection, Insertion
- Eficientes: Merge Sort, Quick Sort, Heap Sort
- Especiais: Counting Sort, Radix Sort

**Busca**:
- Linear e Binária
- Busca em strings (KMP, Boyer-Moore)

**Paradigmas**:
- Divisão e Conquista
- Programação Dinâmica
- Algoritmos Gulosos
- Backtracking

#### 💡 Comparativo de Algoritmos de Ordenação

| Algoritmo | Melhor Caso | Caso Médio | Pior Caso | Estável? |
|-----------|-------------|------------|-----------|----------|
| Bubble Sort | O(n) | O(n²) | O(n²) | ✅ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | ❌ |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | ✅ |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | ❌ |

#### 🎯 Projeto Final
Sistema de otimização para problema do caixeiro viajante.

---

## 🚀 Metodologia de Estudo

### 1. **Teoria + Prática** (80/20)
- 20% lendo conceitos
- 80% implementando e testando

### 2. **Espiral de Aprendizado**
- Implemente uma versão simples
- Analise a complexidade
- Otimize e refatore
- Teste com dados reais

### 3. **Projetos Progressivos**
Cada trilha tem um projeto que usa conhecimentos anteriores.

---

## 🛠️ Setup do Ambiente

### Pré-requisitos
- Java 17+ (LTS recomendado)
- IDE (IntelliJ IDEA, Eclipse, VS Code)
- Maven ou Gradle
- Git

### Configuração Inicial

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/data-structures-java.git
cd data-structures-java

# Configure o Java
java --version

# Execute os testes
mvn test

# Execute exemplos
java -cp target/classes trilha1.exemplos.ExemploGenerics
```

### Estrutura de Testes

```java
// Template para todos os exercícios
@Test
public void testPerformance() {
    // Arrange
    int[] dados = gerarDadosAleatorios(100000);
    
    // Act
    long inicio = System.nanoTime();
    algoritmo.executar(dados);
    long fim = System.nanoTime();
    
    // Assert
    long tempoExecucao = fim - inicio;
    assertTrue("Deve executar em menos de 1s", 
               tempoExecucao < 1_000_000_000);
}
```

---

## 📚 Recursos Complementares

### 📖 Livros Recomendados
- **"Algoritmos: Teoria e Prática"** - Cormen, Leiserson, Rivest, Stein
- **"Estruturas de Dados e Algoritmos em Java"** - Robert Lafore
- **"Cracking the Coding Interview"** - Gayle McDowell

### 🌐 Plataformas de Prática
- [LeetCode](https://leetcode.com/) - Problemas algorítmicos
- [HackerRank](https://hackerrank.com/) - Desafios de programação
- [Codeforces](https://codeforces.com/) - Competições de programação

### 🎥 Canais no YouTube
- **Abdul Bari** - Algoritmos explicados visualmente
- **William Fiset** - Estruturas de dados em profundidade
- **Back To Back SWE** - Preparação para entrevistas

### 🔧 Ferramentas Úteis
- **VisuAlgo** - Visualização de algoritmos
- **Algorithm Visualizer** - Animações interativas
- **Big-O Cheat Sheet** - Referência rápida de complexidades

---

## 🎯 Projetos Práticos Sugeridos

### 1. **🏦 Sistema Bancário** (Trilhas 1-3)
- Contas com diferentes tipos
- Histórico de transações (lista ligada)
- Fila de atendimento prioritário

### 2. **🗂️ Sistema de Arquivos** (Trilha 4)
- Estrutura hierárquica com árvores
- Indexação com hash tables
- Busca eficiente de arquivos

### 3. **🚗 App de Navegação** (Trilha 5)
- Modelagem de mapas com grafos
- Algoritmo de menor caminho
- Sugestão de rotas alternativas

### 4. **🔍 Motor de Busca** (Trilha 6)
- Indexação de documentos
- Algoritmos de ranking
- Busca por padrões em texto

---

## 📈 Sistema de Progressão

### 🥉 Nível Bronze (Iniciante)
- [ ] Implementar todas as estruturas básicas
- [ ] Resolver 50 problemas no LeetCode (Easy)
- [ ] Completar 2 projetos práticos

### 🥈 Nível Prata (Intermediário)
- [ ] Otimizar algoritmos existentes
- [ ] Resolver 100 problemas no LeetCode (Easy + Medium)
- [ ] Contribuir com melhorias no projeto

### 🥇 Nível Ouro (Avançado)
- [ ] Implementar estruturas avançadas (B-trees, Skip Lists)
- [ ] Resolver 150+ problemas no LeetCode (incluindo Hard)
- [ ] Mentorear outros estudantes

---
### 🚀 **Próximos Passos na Carreira**

**📈 Especializações Possíveis**:
1. **Engenharia de Sistemas**: Distribuição, microserviços, Kubernetes
2. **Machine Learning**: Predição de tráfego, otimização com IA
3. **Big Data**: Processamento de dados geoespaciais em escala
4. **Pesquisa**: Novos algoritmos de grafos, publicações científicas

**💼 Oportunidades de Carreira**:
- **Software Engineer** em empresas de tecnologia
- **Algorithm Engineer** em startups de mobilidade
- **Data Engineer** em empresas de logística
- **Research Engineer** em universidades/institutos
- **Tech Lead** em projetos de infraestrutura

### 🌟 **Portfolio e Demonstração**

**📁 Entregáveis para Portfolio**:
1. **Código Fonte Completo**: GitHub com README detalhado
2. **Documentação Técnica**: Decisões arquiteturais, trade-offs
3. **Demo Interativo**: Vídeo mostrando funcionalidades
4. **Artigo Técnico**: Blog post sobre desafios e soluções
5. **Apresentação**: Slides para apresentar em eventos

**🎬 Roteiro da Demo (5 minutos)**:
1. **Problema** (30s): "Como otimizar rotas para 1M de usuários?"
2. **Solução** (2min): Tour pelo sistema, destacar estruturas usadas
3. **Performance** (1min): Benchmarks ao vivo, comparações
4. **Inovações** (1min): O que fez diferente, otimizações únicas
5. **Impacto** (30s): Métricas de performance, casos de uso reais

## 🤝 Como Contribuir

Este é um projeto colaborativo! Você pode contribuir de várias formas:

### 🐛 Reportando Bugs
Encontrou um erro? Abra uma [issue](https://github.com/mathfrancisco/data-structures-java/issues).

### 💡 Sugerindo Melhorias
Tem ideias para novos exercícios ou explicações? Compartilhe conosco!

### 🔧 Enviando Pull Requests
1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

### 📝 Melhorando Documentação
Explicações mais claras são sempre bem-vindas!

---

## 📝 Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.

---

---

**💪 Lembre-se**: A jornada de dominar estruturas de dados e algoritmos é uma maratona, não uma corrida. Seja consistente, pratique diariamente, e não tenha medo de errar. Cada bug é uma oportunidade de aprendizado!

**🚀 Comece hoje mesmo** escolhendo sua primeira trilha e dando o primeiro passo rumo ao domínio da programação eficiente!
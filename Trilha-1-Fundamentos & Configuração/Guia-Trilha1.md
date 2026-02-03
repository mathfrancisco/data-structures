# 🎓 TRILHA 1: Fundamentos Java & Boas Práticas
## Guia Didático Completo - Do Iniciante ao Avançado

---

## 📑 ÍNDICE

1. [Visão Geral e Objetivos](#visão-geral)
2. [Teoria Fundamental](#teoria)
3. [Nível Iniciante - Exercícios](#nivel-iniciante)
4. [Nível Intermediário - Exercícios](#nivel-intermediario)
5. [Nível Avançado - Exercícios](#nivel-avancado)
6. [Projetos Integradores](#projetos)
7. [Recursos de Estudo Recomendados](#recursos)
8. [Checklist de Avaliação](#checklist)

---

## 🎯 VISÃO GERAL E OBJETIVOS {#visão-geral}

### Por que esta trilha é essencial?

**Fundamentos sólidos** são como a fundação de um prédio - invisíveis, mas absolutamente críticos. Esta trilha ensina você a escrever código Java profissional que seja:

- ✅ **Type-safe** - Erros detectados em compilação, não em produção
- ✅ **Manutenível** - Fácil de entender e modificar
- ✅ **Reutilizável** - Componentes que funcionam em múltiplos contextos
- ✅ **Testável** - Código que pode ser validado automaticamente
- ✅ **Profissional** - Seguindo padrões da indústria

### Objetivos de Aprendizado

| Tópico | O que você dominará | Aplicação Real |
|--------|---------------------|----------------|
| **Encapsulamento** | Proteger dados e expor APIs limpas | Sistemas bancários, e-commerce |
| **Generics** | Criar código reutilizável type-safe | Frameworks, bibliotecas |
| **Enums** | Trabalhar com constantes tipadas | Estados de pedido, níveis de acesso |
| **Classes Internas** | Organizar código relacionado | Event handlers, callbacks |
| **Builder Pattern** | Construir objetos complexos | Configurações, DTOs |
| **Factory Pattern** | Criar objetos dinamicamente | Plugin systems, DI containers |
| **Reflection** | Inspecionar e manipular código | Frameworks, ORMs, serialização |
| **Annotations** | Metadados e configuração | Validação, mapeamento, testes |

### Cronograma Sugerido

**Tempo Total**: 60-80 horas (6-8 semanas, 2h/dia)

- **Semana 1-2** (Iniciante): Classes, Arrays, Strings - 15h
- **Semana 3-4** (Intermediário): Generics, Enums, Classes Internas - 20h
- **Semana 5-6** (Avançado): Padrões, Reflection, Annotations - 25h
- **Semana 7-8** (Projeto): Sistema integrado - 20h

---

## 📖 TEORIA FUNDAMENTAL {#teoria}

### 1. ENCAPSULAMENTO E POO

#### Conceito Central

**Encapsulamento** = Esconder complexidade interna + Expor interface simples

**Analogia**: Um carro moderno
- Você NÃO precisa saber: como funciona a injeção eletrônica, sistema ABS, etc.
- Você USA: volante, pedais, marcha
- Benefício: Fabricante pode melhorar motor sem mudar sua experiência

#### Os 4 Pilares da POO

1. **Encapsulamento**: Esconder dados internos
    - Modificadores de acesso: private, protected, public
    - Getters/Setters com validação
    - Imutabilidade quando apropriado

2. **Abstração**: Simplificar complexidade
    - Interfaces definem "o quê"
    - Classes implementam "como"
    - Usuário não vê detalhes

3. **Herança**: Reutilizar código
    - "É um" relacionamento
    - Classe filha herda comportamento da pai
    - Cuidado: herança excessiva cria acoplamento

4. **Polimorfismo**: Múltiplas formas
    - Mesmo método, comportamentos diferentes
    - Sobrescrita (override) vs Sobrecarga (overload)
    - Programar para interface, não implementação

#### Quando usar cada modificador?

| Modificador | Visibilidade | Quando Usar |
|-------------|--------------|-------------|
| **private** | Apenas na classe | Dados internos, métodos auxiliares |
| **default** | Mesmo pacote | Funcionalidade interna do pacote |
| **protected** | Subclasses + pacote | Métodos para herança controlada |
| **public** | Todo mundo | API pública, interfaces |

**Regra de Ouro**: Comece com **private**, torne public apenas se necessário!

---

### 2. GENERICS (TIPOS PARAMETRIZADOS)

#### Conceito Central

Generics = **Abstrair o tipo** sem perder segurança

**Analogia**: Tupperware genérico
- Mesmo recipiente guarda: frutas, legumes, carnes
- Mas você ETIQUETA: "Tupperware\<Frutas\>"
- Garante que só frutas entrem/saiam

#### Por que Generics existem?

**ANTES** (Java 1.4 e anterior):
- ArrayList guardava `Object`
- Cast manual em TODA leitura
- Erros só em RUNTIME 💥

**DEPOIS** (Java 5+):
- ArrayList\<String\> é type-safe
- SEM casts necessários
- Erros em COMPILAÇÃO ✅

#### Nomenclatura Padrão

| Letra | Significado | Exemplo |
|-------|-------------|---------|
| **T** | Type (tipo genérico) | `class Box<T>` |
| **E** | Element (elemento) | `List<E>` |
| **K** | Key (chave) | `Map<K, V>` |
| **V** | Value (valor) | `Map<K, V>` |
| **N** | Number | `class Calculator<N extends Number>` |

#### Wildcards - Quando usar?

1. **`? extends T`** (Upper Bounded)
    - **Uso**: Ler dados de tipos relacionados
    - **Exemplo**: `List<? extends Number>` aceita `List<Integer>`, `List<Double>`
    - **Limitação**: NÃO pode adicionar (só pode ler)

2. **`? super T`** (Lower Bounded)
    - **Uso**: Escrever dados em tipos relacionados
    - **Exemplo**: `List<? super Integer>` aceita `List<Number>`, `List<Object>`
    - **Limitação**: Pode adicionar, mas leitura retorna Object

3. **`?`** (Unbounded)
    - **Uso**: Não importa o tipo
    - **Exemplo**: `List<?>` - qualquer lista
    - **Limitação**: SÓ leitura como Object

**PECS**: Producer Extends, Consumer Super
- Se você **lê** de uma estrutura → use `extends`
- Se você **escreve** em uma estrutura → use `super`

---

### 3. ENUMS (ENUMERAÇÕES)

#### Conceito Central

Enum = **Conjunto FIXO de constantes** com superpoderes

**Analogia**: Semáforo
- Estados FIXOS: VERDE, AMARELO, VERMELHO
- Impossível criar estado inválido
- Cada estado pode ter comportamento próprio

#### Vantagens sobre constantes

| Aspecto | `final int` | `enum` |
|---------|-------------|--------|
| **Type Safety** | ❌ Aceita qualquer int | ✅ Só valores válidos |
| **Legibilidade** | ❌ Números sem significado | ✅ Nomes descritivos |
| **Métodos** | ❌ Não tem | ✅ Pode ter métodos |
| **Switch** | ⚠️ Precisa default | ✅ Compilador avisa falta |
| **Serialização** | ⚠️ Pode quebrar | ✅ Segura por design |

#### Padrões de Uso

1. **Enum Simples**: Apenas constantes
2. **Enum com Propriedades**: Cada constante tem dados
3. **Enum com Comportamento**: Cada constante age diferente
4. **Enum com Interface**: Implementa contrato comum

#### Métodos úteis de Enum

- `values()`: Array com todas constantes
- `valueOf(String)`: Converte string em enum
- `ordinal()`: Posição (0-based)
- `name()`: Nome da constante
- `compareTo()`: Compara ordem

---

### 4. CLASSES INTERNAS (NESTED CLASSES)

#### Tipos de Classes Internas

1. **Static Nested Class**
    - NÃO precisa de instância da outer class
    - Acessa apenas membros static da outer
    - Uso: Organização, Builder pattern

2. **Inner Class (Non-static)**
    - PRECISA de instância da outer class
    - Acessa todos membros da outer (até private!)
    - Uso: Event listeners, Iterators

3. **Local Class**
    - Definida dentro de um método
    - Acessa final/effectively final variables
    - Uso: Callbacks temporários

4. **Anonymous Class**
    - Sem nome, criada e usada na hora
    - Implementa interface ou extends classe
    - Uso: Listeners, Comparators (antes de lambdas)

#### Quando usar cada tipo?

| Tipo | Quando Usar | Exemplo Real |
|------|-------------|--------------|
| **Static Nested** | Associação lógica, sem dependência de instância | Builder, Factory |
| **Inner Class** | Precisa acessar dados da outer | Iterator de ArrayList |
| **Local Class** | Uso único dentro de método | Ordenação customizada |
| **Anonymous** | Implementação rápida, uso único | Event handlers |

---

### 5. PADRÕES DE DESIGN

#### Builder Pattern

**Problema Resolvido**: Construir objetos com MUITOS parâmetros opcionais

**Quando Usar**:
- 4+ parâmetros no construtor
- Muitos parâmetros opcionais
- Objeto imutável desejado
- Validação complexa necessária

**Benefícios**:
- Código legível (fluent interface)
- Validação centralizada
- Imutabilidade garantida
- Evita "telescoping constructors"

#### Factory Pattern

**Problema Resolvido**: Decidir QUAL classe instanciar em runtime

**Tipos de Factory**:

1. **Simple Factory**
    - Método static que retorna instância
    - Decisão baseada em parâmetro

2. **Factory Method**
    - Método abstrato em superclasse
    - Subclasses decidem classe concreta

3. **Abstract Factory**
    - Família de objetos relacionados
    - Garante compatibilidade entre produtos

**Quando Usar**:
- Criação complexa de objetos
- Decisão de tipo em runtime
- Ocultar classes concretas
- Plugin systems

#### Singleton Pattern

**Problema Resolvido**: Garantir UMA ÚNICA instância global

**Cuidados**:
- ⚠️ Dificulta testes (estado global)
- ⚠️ Viola princípio de responsabilidade única
- ⚠️ Problemas em ambientes multi-thread

**Alternativas Modernas**:
- Dependency Injection containers
- Scoped instances (request, session)

---

### 6. REFLECTION

#### Conceito Central

Reflection = **Inspecionar e modificar código em RUNTIME**

**Analogia**: Raio-X de código
- Ver estrutura interna de classes
- Acessar campos privados
- Invocar métodos dinamicamente
- Criar instâncias sem `new`

#### Principais Usos

1. **Frameworks**
    - Spring DI: Injeta dependências via reflection
    - Hibernate ORM: Mapeia objetos para BD
    - JUnit: Descobre métodos @Test

2. **Serialização**
    - Jackson JSON: Acessa getters/setters
    - Gson: Cria objetos e preenche campos

3. **Ferramentas**
    - IDEs: Autocomplete, refactoring
    - Debuggers: Inspeção de objetos

#### Custos da Reflection

| Aspecto | Impacto |
|---------|---------|
| **Performance** | 10-100x mais lento que acesso direto |
| **Segurança** | Pode violar encapsulamento |
| **Type Safety** | Perde verificação do compilador |
| **Refactoring** | IDEs não detectam usos via reflection |

**Regra**: Use reflection apenas quando REALMENTE necessário!

---

### 7. ANNOTATIONS

#### Conceito Central

Annotations = **Metadados** sobre código

**Analogia**: Etiquetas em produtos
- Não mudam o produto
- Dão informações extras
- Processadores leem e agem

#### Níveis de Retenção

1. **SOURCE**: Descartada após compilação
    - Exemplo: `@Override`, `@SuppressWarnings`
    - Uso: Hints para compilador

2. **CLASS**: Incluída no .class, não em runtime
    - Padrão se não especificado
    - Uso: Processadores de bytecode

3. **RUNTIME**: Disponível via reflection
    - Exemplo: `@Test`, `@Autowired`, `@JsonProperty`
    - Uso: Frameworks que processam em runtime

#### Targets de Annotations

- **TYPE**: Classes, interfaces, enums
- **FIELD**: Atributos
- **METHOD**: Métodos
- **PARAMETER**: Parâmetros de métodos
- **CONSTRUCTOR**: Construtores
- **LOCAL_VARIABLE**: Variáveis locais
- **ANNOTATION_TYPE**: Outras annotations
- **PACKAGE**: Pacotes

---

## 🌱 NÍVEL INICIANTE - EXERCÍCIOS {#nivel-iniciante}

### 📋 EXERCÍCIO 1: Sistema de Cadastro de Pessoas

**Objetivo**: Praticar encapsulamento básico e validação

**Requisitos**:
1. Crie classe `Pessoa` com atributos privados:
    - nome (String, não nulo, 2-100 caracteres)
    - cpf (String, formato 000.000.000-00)
    - dataNascimento (LocalDate, não futuro)
    - altura (double, entre 0.50 e 2.50)

2. Implemente validações em:
    - Construtor (lança IllegalArgumentException se inválido)
    - Setters (quando aplicável)

3. Crie métodos:
    - `getIdade()`: calcula idade atual
    - `apresentar()`: retorna String formatada
    - `equals()` e `hashCode()`: baseados em CPF

**Teste com**:
- Pessoa válida
- Nome inválido (muito curto/longo)
- CPF inválido
- Data futura
- Altura fora do range

**Aprenda**: Encapsulamento, validação, métodos derivados

---

### 📋 EXERCÍCIO 2: Gerenciador de Tarefas

**Objetivo**: Arrays, loops, métodos utilitários

**Requisitos**:
1. Crie classe `GerenciadorTarefas`:
    - Array privado de Strings (tarefas)
    - Contador de tarefas atuais

2. Métodos obrigatórios:
    - `adicionar(String tarefa)`: adiciona se houver espaço
    - `remover(int indice)`: remove e reorganiza array
    - `buscar(String texto)`: retorna índices que contêm texto
    - `listar()`: retorna cópia do array com tarefas
    - `contar()`: quantidade atual de tarefas

3. Validações:
    - Não permitir tarefa nula/vazia
    - Índice válido em remoção
    - Array cheio em adição

**Teste com**:
- Adicionar até encher
- Remover do início, meio, fim
- Buscar existente e inexistente
- Listar vazio e com dados

**Aprenda**: Manipulação de arrays, validações, edge cases

---

### 📋 EXERCÍCIO 3: Analisador de Strings

**Objetivo**: Algoritmos com Strings

**Requisitos**:
1. Crie classe `AnalisadorTexto` com métodos static:
    - `contarVogais(String texto)`: retorna quantidade
    - `contarConsoantes(String texto)`: retorna quantidade
    - `ehPalindromo(String texto)`: ignora espaços/pontuação
    - `inverter(String texto)`: retorna string invertida
    - `contarPalavras(String texto)`: conta palavras
    - `removerEspacosDuplicados(String texto)`: normaliza

2. Requisitos:
    - Ignorar case (maiúsculas/minúsculas)
    - Tratar null como string vazia
    - Caracteres especiais não são vogais nem consoantes

**Teste com**:
- "Arara" (palíndromo)
- "A man a plan a canal Panama" (palíndromo complexo)
- "   Texto   com    espaços   " (normalização)
- "123!@# abc" (misturado)
- null e vazio

**Aprenda**: Manipulação de strings, algoritmos básicos

---

### 📋 EXERCÍCIO 4: Calculadora de IMC

**Objetivo**: Enums simples e lógica condicional

**Requisitos**:
1. Crie enum `ClassificacaoIMC`:
    - ABAIXO_PESO (< 18.5)
    - PESO_NORMAL (18.5 - 24.9)
    - SOBREPESO (25.0 - 29.9)
    - OBESIDADE_GRAU_1 (30.0 - 34.9)
    - OBESIDADE_GRAU_2 (35.0 - 39.9)
    - OBESIDADE_GRAU_3 (>= 40.0)

2. Cada enum tem:
    - Descrição amigável
    - Método `getRecomendacao()`: dica de saúde

3. Classe `CalculadoraIMC`:
    - `calcularIMC(double peso, double altura)`: retorna IMC
    - `classificar(double imc)`: retorna ClassificacaoIMC
    - `analisar(double peso, double altura)`: retorna relatório completo

**Teste com**:
- Valores normais
- Extremos (muito baixo/alto)
- Zero e negativos (erro)

**Aprenda**: Enums com propriedades, validação de negócio

---

### 📋 EXERCÍCIO 5: Conversor de Unidades

**Objetivo**: Enums com métodos

**Requisitos**:
1. Crie enum `UnidadeComprimento`:
    - MILIMETRO, CENTIMETRO, METRO, KILOMETRO
    - Cada um tem fator de conversão para metros

2. Métodos do enum:
    - `converterPara(double valor, UnidadeComprimento destino)`
    - `getAbreviacao()`: mm, cm, m, km
    - `getNomeCompleto()`: milímetro, centímetro, etc

3. Classe `ConversorUnidades`:
    - Método estático que usa o enum
    - Validação de valores negativos

**Teste com**:
- 1000mm → cm (100cm)
- 1km → mm (1000000mm)
- 0 e valores decimais

**Aprenda**: Enums com lógica, conversões

---

## 🌿 NÍVEL INTERMEDIÁRIO - EXERCÍCIOS {#nivel-intermediario}

### 📋 EXERCÍCIO 6: Caixa Genérica Type-Safe

**Objetivo**: Entender Generics básicos

**Requisitos**:
1. Crie classe `Caixa<T>`:
    - Guarda um item do tipo T
    - Métodos: `guardar(T item)`, `retirar()`, `estaVazia()`, `limpar()`

2. Adicione validações:
    - Não guardar null
    - Não retirar de caixa vazia

3. Sobrescreva `toString()` mostrando tipo e conteúdo

**Teste com**:
- `Caixa<String>`
- `Caixa<Integer>`
- `Caixa<Pessoa>` (classe do exercício 1)
- Tentar guardar tipo errado (não deve compilar!)

**Aprenda**: Type parameters, type safety, reificação

---

### 📋 EXERCÍCIO 7: Lista Genérica Customizada

**Objetivo**: Generics com estrutura de dados

**Requisitos**:
1. Crie `MinhaLista<E>`:
    - Array interno genérico
    - Capacidade inicial de 10
    - Dobra tamanho quando cheia

2. Métodos:
    - `adicionar(E elemento)`
    - `remover(int indice)`: retorna elemento removido
    - `obter(int indice)`: retorna elemento
    - `tamanho()`: quantidade atual
    - `contem(E elemento)`: boolean

3. Implemente `Iterable<E>` para usar em for-each

**Teste com**:
- Adicionar mais que capacidade inicial
- Remover do meio e verificar ordem
- Iterar com for-each
- Diferentes tipos genéricos

**Aprenda**: Generics avançados, arrays genéricos, interfaces

---

### 📋 EXERCÍCIO 8: Processador de Coleções

**Objetivo**: Wildcards e bounded types

**Requisitos**:
1. Crie classe `ProcessadorColecoes` com métodos static:

    - `<T> T encontrarMaximo(List<T> lista, Comparator<T> comp)`
    - `<T extends Number> double calcularMedia(List<T> numeros)`
    - `<T> void trocar(List<T> lista, int i, int j)`
    - `void imprimirTodos(List<?> lista)`: aceita qualquer lista
    - `void adicionarInteiros(List<? super Integer> lista, int... valores)`

2. Cada método deve:
    - Validar parâmetros nulos
    - Lidar com lista vazia quando aplicável

**Teste com**:
- Listas de diferentes tipos
- Wildcards com extends e super
- Verificar type safety do compilador

**Aprenda**: Bounded types, wildcards, PECS principle

---

### 📋 EXERCÍCIO 9: Sistema de Notificações

**Objetivo**: Enums avançados com comportamento

**Requisitos**:
1. Crie enum `TipoNotificacao`:
    - EMAIL, SMS, PUSH, WHATSAPP

2. Cada tipo implementa `enviar(String mensagem, String destinatario)`:
    - EMAIL: valida formato email
    - SMS: valida formato telefone
    - PUSH: valida token de dispositivo
    - WHATSAPP: valida número internacional

3. Adicione propriedades:
    - `custoEstimado`: custo por envio
    - `tempoMedioEntrega`: em segundos
    - `taxaSucesso`: percentual histórico

4. Métodos do enum:
    - `isDisponivel()`: verifica se serviço está ativo
    - `calcularCusto(int quantidade)`: custo total
    - `melhorOpcao(List<TipoNotificacao> disponiveis)`: menor custo

**Teste com**:
- Envios válidos e inválidos
- Cálculo de custos
- Seleção de melhor opção

**Aprenda**: Enums com métodos abstratos, strategy pattern

---

### 📋 EXERCÍCIO 10: Configurador de Servidor

**Objetivo**: Builder Pattern

**Requisitos**:
1. Crie classe `ServidorConfig` com:
    - Obrigatórios: host, porta
    - Opcionais: timeout, maxConexoes, ssl, usuario, senha

2. Implemente padrão Builder:
    - Classe interna static `Builder`
    - Métodos fluent para opcionais
    - Validação no `build()`:
        - Porta entre 1-65535
        - Se ssl=true, porta deve ser 443
        - Se tem usuario, deve ter senha

3. `ServidorConfig` deve ser imutável (final fields, sem setters)

**Teste com**:
- Configuração mínima
- Todas opções
- Validações (porta inválida, ssl sem porta correta)

**Aprenda**: Builder pattern, imutabilidade, fluent interface

---

### 📋 EXERCÍCIO 11: Fábrica de Conexões

**Objetivo**: Factory Pattern

**Requisitos**:
1. Interface `Conexao`:
    - `conectar()`, `desconectar()`, `executarComando(String cmd)`

2. Implementações:
    - `ConexaoMySQL`
    - `ConexaoPostgreSQL`
    - `ConexaoMongoDB`

3. Classe `FabricaConexao`:
    - Método `criar(String tipo, String config)`: retorna Conexao
    - Tipos: "mysql", "postgresql", "mongodb"
    - Lança exceção para tipo desconhecido

4. Adicione:
    - Pool de conexões (reutilizar instâncias)
    - Registro de tipos customizados

**Teste com**:
- Criar cada tipo de conexão
- Tipo inválido
- Múltiplas conexões do mesmo tipo

**Aprenda**: Factory pattern, polimorfismo, plugin architecture

---

### 📋 EXERCÍCIO 12: Event Listener com Classes Internas

**Objetivo**: Inner classes e anonymous classes

**Requisitos**:
1. Interface `EventListener`:
    - `void onEvent(String eventName, Object data)`

2. Classe `EventManager`:
    - Registrar listeners para eventos
    - Disparar eventos
    - Inner class `EventoInfo`: guarda nome, timestamp, dados

3. Implemente:
    - Listener como inner class
    - Listener como anonymous class
    - Listener como lambda (Java 8+)

4. Funcionalidades:
    - Múltiplos listeners por evento
    - Remover listener
    - Listar eventos recentes

**Teste com**:
- Registrar vários tipos de listeners
- Disparar eventos e verificar recebimento
- Remover e verificar que não recebe mais

**Aprenda**: Inner classes, anonymous classes, observer pattern

---

## 🌳 NÍVEL AVANÇADO - EXERCÍCIOS {#nivel-avancado}

### 📋 EXERCÍCIO 13: Analisador de Classes via Reflection

**Objetivo**: Dominar Reflection API

**Requisitos**:
1. Crie classe `AnalisadorClasse` que analisa qualquer classe:

    - `listarCampos(Class<?> classe)`: todos fields (incluindo privados)
    - `listarMetodos(Class<?> classe)`: todos métodos
    - `listarConstrutores(Class<?> classe)`: todos construtores
    - `obterHierarquia(Class<?> classe)`: cadeia de herança
    - `listarInterfaces(Class<?> classe)`: interfaces implementadas
    - `obterAnotacoes(Class<?> classe)`: annotations da classe

2. Para cada membro, retorne:
    - Nome
    - Modificadores (public, private, static, etc)
    - Tipo de retorno (métodos)
    - Parâmetros (métodos/construtores)
    - Annotations

3. Adicione:
    - Método `invocar(Object obj, String metodo, Object... args)`: invoke dinâmico
    - Método `obterValorCampo(Object obj, String campo)`: acessa field privado
    - Método `setarValorCampo(Object obj, String campo, Object valor)`

**Teste com**:
- Classes do JDK (String, ArrayList)
- Suas próprias classes
- Invocação de métodos privados
- Modificação de campos final

**Aprenda**: Reflection API completa, segurança, performance

---

### 📋 EXERCÍCIO 14: Serializador JSON Customizado

**Objetivo**: Reflection para serialização

**Requisitos**:
1. Crie `JsonSerializer` que converte objetos em JSON:
    - Suporta: primitivos, Strings, arrays, coleções, objetos aninhados
    - Ignora campos transient e static
    - Respeita getters (propriedade JavaBeans)

2. Implemente:
    - `String toJson(Object obj)`: serializa para JSON
    - `<T> T fromJson(String json, Class<T> classe)`: deserializa
    - Tratamento de tipos especiais (Date, LocalDateTime)
    - Identação opcional (pretty print)

3. Desafios:
    - Detectar referências circulares
    - Suportar generics (List\<String\> vs List\<Integer\>)
    - Performance com objetos grandes

**Teste com**:
- Objetos simples
- Objetos com coleções
- Objetos aninhados
- Referência circular (deve detectar)

**Aprenda**: Reflection avançada, serialização, parsing

---

### 📋 EXERCÍCIO 15: Framework de Validação com Annotations

**Objetivo**: Criar e processar annotations

**Requisitos**:
1. Crie annotations de validação:
    - `@NotNull`: campo não pode ser null
    - `@NotEmpty`: String/Collection não vazia
    - `@Min(value)`: número >= value
    - `@Max(value)`: número <= value
    - `@Size(min, max)`: tamanho de String/Collection
    - `@Email`: formato de email válido
    - `@Pattern(regex)`: match com regex

2. Classe `Validator`:
    - `List<String> validar(Object obj)`: retorna erros encontrados
    - Processa annotations via reflection
    - Retorna lista vazia se válido

3. Funcionalidades extras:
    - Mensagens customizadas nas annotations
    - Validação de objetos aninhados
    - Grupos de validação (validar só alguns campos)

**Teste com**:
- Classe Pessoa com várias validações
- Objetos válidos e inválidos
- Validações complexas (regex, custom)

**Aprenda**: Custom annotations, annotation processing, validation

---

### 📋 EXERCÍCIO 16: Injeção de Dependências Simples

**Objetivo**: DI container com annotations

**Requisitos**:
1. Crie annotations:
    - `@Component`: marca classe gerenciada
    - `@Inject`: marca campo/construtor para injeção
    - `@Singleton`: instância única
    - `@Prototype`: nova instância cada vez

2. Classe `Container`:
    - `void registrar(Class<?> classe)`: registra componente
    - `<T> T obter(Class<T> classe)`: retorna instância
    - Resolve dependências automaticamente
    - Detecta ciclos de dependência

3. Funcionalidades:
    - Injeção por construtor (preferencial)
    - Injeção por field (se necessário)
    - Lazy initialization
    - Post-construct hooks

**Teste com**:
- Serviço dependendo de Repository
- Repository dependendo de Connection
- Singleton vs Prototype
- Ciclo de dependência (deve lançar exceção)

**Aprenda**: DI, reflection avançada, lifecycle management

---

### 📋 EXERCÍCIO 17: ORM Simplificado

**Objetivo**: Object-Relational Mapping

**Requisitos**:
1. Annotations para mapeamento:
    - `@Entity(table)`: marca classe como entidade
    - `@Id`: marca chave primária
    - `@Column(name)`: mapeia campo para coluna
    - `@GeneratedValue`: auto-increment
    - `@ManyToOne`, `@OneToMany`: relacionamentos

2. Classe `EntityManager`:
    - `void salvar(Object entity)`: INSERT ou UPDATE
    - `<T> T buscarPorId(Class<T> classe, Object id)`: SELECT
    - `<T> List<T> buscarTodos(Class<T> classe)`: SELECT *
    - `void deletar(Object entity)`: DELETE

3. Geração de SQL:
    - CREATE TABLE a partir da classe
    - INSERT/UPDATE/DELETE/SELECT
    - Tratamento de relacionamentos

**Teste com**:
- Classe Pessoa persistida em banco
- CRUD completo
- Relacionamentos (Pessoa tem Lista de Endereços)

**Aprenda**: ORM concepts, SQL generation, reflection mastery

---

### 📋 EXERCÍCIO 18: Framework de Testes Unitários

**Objetivo**: Criar mini JUnit

**Requisitos**:
1. Annotations:
    - `@Test`: marca método de teste
    - `@Before`: executa antes de cada teste
    - `@After`: executa depois de cada teste
    - `@BeforeClass`: executa uma vez antes de todos
    - `@AfterClass`: executa uma vez depois de todos
    - `@Ignore`: pula teste

2. Classe `TestRunner`:
    - `executar(Class<?> classeTest)`: roda todos testes
    - Relatório: total, passou, falhou, ignorados
    - Captura exceções como falha

3. Classe `Assert`:
    - `assertEquals(expected, actual)`
    - `assertTrue(condition)`
    - `assertNull(object)`
    - `assertThrows(Exception.class, () -> code)`

**Teste com**:
- Criar classe de testes própria
- Testes que passam e falham
- Métodos before/after
- Ignorar testes

**Aprenda**: Test frameworks, reflection, assertions

---

## 🚀 PROJETOS INTEGRADORES {#projetos}

### PROJETO 1: Sistema de Biblioteca Completo (40-60 horas)

**Descrição**: Sistema real com todos conceitos aplicados

**Funcionalidades**:
1. **Gerenciamento de Acervo**:
    - Livros, Revistas, DVDs (herança)
    - Busca por título, autor, ISBN, categoria
    - Controle de disponibilidade

2. **Usuários e Empréstimos**:
    - Cadastro de usuários (Pessoa do Ex. 1)
    - Sistema de empréstimo com prazos
    - Multas por atraso (calculadas automaticamente)
    - Histórico de empréstimos

3. **Notificações**:
    - Sistema de notificações (Ex. 9)
    - Lembretes de devolução
    - Avisos de reserva disponível

4. **Relatórios**:
    - Livros mais emprestados
    - Usuários inadimplentes
    - Estatísticas mensais

**Requisitos Técnicos**:
- Builder para criar objetos complexos
- Factory para diferentes tipos de mídia
- Generics para coleções type-safe
- Enums para estados (Disponível, Emprestado, Reservado)
- Annotations customizadas para validação
- Persistência com seu ORM (Ex. 17) ou arquivo JSON

**Entregáveis**:
- Código fonte completo
- Testes unitários (Ex. 18 ou JUnit)
- Documentação JavaDoc
- Manual de usuário
- Diagramas UML

---

### PROJETO 2: E-Commerce Backend (50-70 horas)

**Descrição**: Sistema de comércio eletrônico

**Funcionalidades**:
1. **Catálogo de Produtos**:
    - Categorias hierárquicas
    - Atributos dinâmicos (cor, tamanho, etc)
    - Busca e filtros avançados

2. **Carrinho e Pedidos**:
    - Carrinho de compras genérico
    - Cálculo de frete
    - Processamento de pedidos
    - Estados do pedido (enum com workflow)

3. **Pagamentos**:
    - Factory para diferentes formas (cartão, boleto, PIX)
    - Validação com annotations
    - Processamento assíncrono

4. **Usuários e Permissões**:
    - Cliente, Vendedor, Admin (roles com enum)
    - Sistema de autenticação
    - Controle de acesso

**Requisitos Técnicos**:
- DI container (Ex. 16) para serviços
- Event system para notificações
- Reflection para deserialização de requests
- Builder para criação de pedidos complexos
- Strategy pattern para cálculo de frete

**Entregáveis**:
- API REST funcional
- Collection do Postman/Insomnia
- Testes de integração
- Documentação técnica
- Schema do banco de dados

---

## 📚 RECURSOS DE ESTUDO RECOMENDADOS {#recursos}

### 📖 Livros Essenciais

1. **"Effective Java" - Joshua Bloch** (3ª Edição)
    - Capítulos essenciais: 2 (Creating and Destroying Objects), 3 (Methods Common to All Objects), 4 (Classes and Interfaces), 5 (Generics), 6 (Enums and Annotations)
    - Por que ler: Best practices direto do criador de partes do Java
    - Nível: Intermediário a Avançado

2. **"Java: Como Programar" - Deitel & Deitel**
    - Capítulos: 8 (Classes e Objetos), 16 (Generics), 17 (Collections)
    - Por que ler: Explicações didáticas com muitos exemplos
    - Nível: Iniciante a Intermediário

3. **"Head First Design Patterns" - Freeman & Robson**
    - Padrões: Factory, Builder, Singleton, Observer, Strategy
    - Por que ler: Abordagem visual e divertida
    - Nível: Intermediário

4. **"Clean Code" - Robert C. Martin**
    - Capítulos: 2 (Meaningful Names), 3 (Functions), 6 (Objects and Data Structures), 10 (Classes)
    - Por que ler: Escrever código profissional e manutenível
    - Nível: Todos os níveis

### 🎓 Cursos Online

1. **Coursera - "Object Oriented Programming in Java" (UC San Diego)**
    - Duração: 6 semanas
    - Cobre: POO, Generics, Collections
    - Gratuito para auditar

2. **Udemy - "Java Programming Masterclass" (Tim Buchalka)**
    - Duração: 80 horas
    - Cobre: Do básico ao avançado
    - Inclui: Generics, Reflection, Annotations

3. **Pluralsight - "Java Fundamentals" Path**
    - Cursos: Core Platform, Collections, Generics
    - Nível: Iniciante a Avançado
    - Trial gratuito disponível

4. **Baeldung - Artigos e Tutoriais**
    - Site: https://www.baeldung.com
    - Tópicos: Todos os conceitos Java
    - Gratuito com exemplos práticos

### 🎥 Canais YouTube Recomendados

1. **Programming with Mosh**
    - Playlists: Java Tutorial for Beginners
    - Estilo: Claro, direto ao ponto
    - Nível: Iniciante a Intermediário

2. **Amigoscode**
    - Playlists: Java, Spring Boot
    - Estilo: Prático, com projetos reais
    - Nível: Intermediário a Avançado

3. **Coding with John**
    - Playlists: Java Basics, Advanced Java
    - Estilo: Explicações detalhadas
    - Nível: Todos os níveis

4. **Marco Codes**
    - Playlists: Java Annotations, Reflection
    - Estilo: Conceitos avançados simplificados
    - Nível: Intermediário a Avançado

### 📱 Plataformas de Prática

1. **Exercism.io**
    - Track Java com 140+ exercícios
    - Mentoring gratuito
    - Foco em qualidade de código
    - URL: https://exercism.org/tracks/java

2. **Codingame**
    - Desafios gamificados
    - Tópicos: Algoritmos, POO
    - Ranking e competições
    - URL: https://www.codingame.com

3. **HackerRank - Java Domain**
    - Problemas específicos de Java
    - Certificação gratuita
    - URL: https://www.hackerrank.com/domains/java

4. **LeetCode - Java Tag**
    - Problemas de entrevista
    - Filtro por dificuldade
    - URL: https://leetcode.com/tag/java

### 📄 Documentação Oficial

1. **Oracle Java Tutorials**
    - URL: https://docs.oracle.com/javase/tutorial/
    - Seções: Learning the Java Language, Essential Java Classes
    - Oficial e sempre atualizado

2. **Java Language Specification**
    - URL: https://docs.oracle.com/javase/specs/
    - Para entender profundamente a linguagem
    - Nível: Avançado

3. **Javadoc API**
    - URL: https://docs.oracle.com/en/java/javase/17/docs/api/
    - Referência de todas as classes
    - Aprenda a ler JavaDoc!

### 🎯 Artigos e Papers Específicos

1. **Generics:**
    - "Generics in Java and C#" - Kennedy & Syme
    - "Adding Generics to the Java Programming Language" - Bracha et al

2. **Annotations:**
    - "JSR 175: A Metadata Facility for the Java Programming Language"
    - Baeldung Guide: https://www.baeldung.com/java-custom-annotation

3. **Reflection:**
    - Oracle Tutorial: https://docs.oracle.com/javase/tutorial/reflect/
    - "Java Reflection in Action" - Forman

4. **Design Patterns:**
    - "Gang of Four" - Design Patterns: Elements of Reusable OO Software
    - Refactoring Guru: https://refactoring.guru/design-patterns/java

### 💡 Dicas de Estudo Efetivo

1. **Ciclo de Aprendizado**:
    - Leia teoria (20% do tempo)
    - PRATIQUE código (70% do tempo)
    - Ensine/explique para alguém (10% do tempo)

2. **Técnica Pomodoro para Programação**:
    - 25 min: Código focado
    - 5 min: Pausa
    - 4 pomodoros → pausa longa (15-30 min)

3. **Progresso Incremental**:
    - Não tente aprender tudo de uma vez
    - Domine um conceito antes do próximo
    - Revise periodicamente (spaced repetition)

4. **Debugging como Aprendizado**:
    - Quando encontrar bug, entenda o PORQUÊ
    - Use debugger passo a passo
    - Cada erro é uma lição

---

## ✅ CHECKLIST DE AVALIAÇÃO {#checklist}

### Nível Iniciante - Fundamentos

- [ ] Consigo criar classes com encapsulamento adequado
- [ ] Entendo quando usar private, protected, public
- [ ] Sei validar dados em construtores e setters
- [ ] Posso manipular arrays e strings eficientemente
- [ ] Implemento equals() e hashCode() corretamente
- [ ] Uso enums simples em vez de constantes
- [ ] Compreendo diferença entre null e valores vazios
- [ ] Consigo ler e entender código com POO básica

**Projeto Mínimo**: Sistema de cadastro com validação

---

### Nível Intermediário - Reutilização

- [ ] Crio e uso classes genéricas type-safe
- [ ] Entendo wildcards (extends, super, unbounded)
- [ ] Aplico PECS principle corretamente
- [ ] Crio enums com propriedades e métodos
- [ ] Uso classes internas quando apropriado
- [ ] Implemento Builder pattern para objetos complexos
- [ ] Implemento Factory pattern para criação dinâmica
- [ ] Sei quando usar cada padrão de design
- [ ] Escrevo código reutilizável em múltiplos contextos

**Projeto Mínimo**: Framework/biblioteca reutilizável

---

### Nível Avançado - Metaprogramação

- [ ] Uso Reflection API para inspeção de classes
- [ ] Invoco métodos e acesso campos dinamicamente
- [ ] Crio annotations customizadas
- [ ] Processo annotations em runtime
- [ ] Entendo retenção (SOURCE, CLASS, RUNTIME)
- [ ] Entendo targets (TYPE, FIELD, METHOD, etc)
- [ ] Implemento frameworks simples (validation, DI, ORM)
- [ ] Conheço limitações e custos de reflection
- [ ] Balanceio flexibilidade vs performance

**Projeto Mínimo**: Framework que processa annotations

---

### Soft Skills para Desenvolvedor

- [ ] Escrevo código legível (naming, formatting)
- [ ] Comento apenas o necessário (código auto-explicativo)
- [ ] Escrevo JavaDoc para APIs públicas
- [ ] Versiono código com Git (commits claros)
- [ ] Escrevo testes para código crítico
- [ ] Refatoro código sem medo
- [ ] Peço code review e aceito feedback
- [ ] Mantenho aprendizado contínuo

---

## 🎓 PRÓXIMOS PASSOS

Após dominar esta trilha:

1. **TRILHA 2**: Análise de Algoritmos & Big-O
    - Entenda complexidade computacional
    - Otimize seus algoritmos

2. **TRILHA 3**: Estruturas de Dados Lineares
    - Implemente ArrayList, LinkedList, Stack, Queue
    - Entenda quando usar cada uma

3. **TRILHA 4**: Estruturas Não-Lineares
    - Árvores, Heaps, Hash Tables
    - Algoritmos de busca e ordenação

4. **Trilha 5**: Teoria dos Grafos
    - DFS, BFS, Dijkstra
    - Aplicações em problemas reais

5. **Frameworks Reais**:
    - Spring Framework (DI, AOP)
    - Hibernate (ORM)
    - JUnit/Mockito (Testing)

---

## 📝 CONCLUSÃO

Esta trilha construiu suas **fundações sólidas** em Java. Você agora:

✅ Escreve código **type-safe** e **robusto**
✅ Aplica **padrões de design** profissionais  
✅ Cria código **reutilizável** e **manutenível**
✅ Entende **metaprogramação** (reflection, annotations)
✅ Está preparado para **frameworks modernos**

**Próximo desafio**: Aplicar esses conceitos em estruturas de dados complexas e algoritmos eficientes!

**Lembre-se**:
- Pratique DIARIAMENTE (consistência > intensidade)
- Entenda o PORQUÊ, não apenas o COMO
- Ensine para consolidar conhecimento
- Refatore código antigo com novos conhecimentos

**Boa jornada! 🚀**
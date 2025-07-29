# 🗂️ PROJETO 2: Sistema de Arquivos Inteligente

## 🎭 **Analogia: A Biblioteca Universal**

Imagine uma biblioteca que contém **10 milhões de documentos** - livros, artigos, fotos, vídeos, mapas. Como você organizaria tudo para que qualquer pessoa possa encontrar qualquer documento em **menos de 2 segundos**?

Esse é exatamente o desafio de um sistema de arquivos moderno! Seu projeto criará um "Google Drive pessoal" que não apenas armazena arquivos, mas os organiza de forma inteligente.

---

## 🎨 **Visualização do Sistema**

```
            🗂️ SISTEMA DE ARQUIVOS INTELIGENTE
    
    🌳 ESTRUTURA HIERÁRQUICA (Árvore de Diretórios)
                        📁 Root
                       /      \
                  📁 Users    📁 System
                    /            \
            📁 joao.silva    📁 Applications
           /      |      \           \
    📁 Docs  📁 Photos  📁 Projects  📁 Games
      |        |         |
   📄 CV.pdf  🖼️ férias  💻 Website
              /    \
        🖼️ praia  🖼️ montanha
    
    ⚡ ÍNDICES PARA BUSCA RÁPIDA
    
    🏷️ POR NOME (Hash Table):
    "CV.pdf" → /Users/joao.silva/Docs/CV.pdf
    "férias" → /Users/joao.silva/Photos/férias/
    
    📊 POR TAMANHO (AVL Tree):
    10MB → [video1.mp4, video2.avi]
    5MB  → [foto1.jpg, foto2.png]
    1MB  → [doc1.pdf, doc2.docx]
    
    🕒 POR DATA (Heap):
    Mais recente: arquivo_hoje.txt (prioridade máxima)
    Ontem: relatorio.pdf
    Semana passada: backup.zip
```

---

## 🛠️ **Como Realizar o Projeto**

### 📅 **Cronograma Sugerido: 3-4 Semanas**

#### **🗓️ Semana 1: Estrutura Base (Trilha 4 - Árvores)**
**Objetivo**: Criar a hierarquia de diretórios como uma árvore

**🎯 O que fazer**:
1. **Implemente Árvore de Diretórios**:
    - Cada nó = pasta ou arquivo
    - Nós internos = pastas (podem ter filhos)
    - Folhas = arquivos (sem filhos)
    - Navegação pai ↔ filhos

2. **Crie as entidades principais**:
    - `Arquivo` (nome, tamanho, tipo, data, conteúdo)
    - `Diretorio` (nome, lista de filhos, pai)
    - `SistemaArquivos` (raiz, operações)

3. **Operações básicas da árvore**:
    - Criar pasta/arquivo
    - Navegar (cd, ls)
    - Calcular tamanho total de uma pasta
    - Encontrar caminho completo

**💡 Insight**: Por que árvore e não lista? Porque queremos navegar hierarquicamente (Users/João/Documentos) e não linearmente!

#### **🗓️ Semana 2: Busca Rápida (Trilha 4 - Hash Tables)**
**Objetivo**: Encontrar qualquer arquivo instantaneamente

**🎯 O que fazer**:
1. **Implemente Hash Table para nomes**:
    - Chave: nome do arquivo
    - Valor: caminho completo
    - Resolução de colisões (nomes iguais em pastas diferentes)

2. **Crie índice por extensão**:
    - `.pdf` → lista de todos PDFs
    - `.jpg` → lista de todas imagens
    - `.mp4` → lista de todos vídeos

3. **Busca inteligente**:
    - Busca por nome parcial ("rela*" encontra "relatorio.pdf")
    - Busca por tipo de arquivo
    - Busca combinada (nome + tipo + tamanho)

**🎨 Visualização dos Índices**:
```
📚 ÍNDICE POR NOME (Hash Table)
┌─────────────┬──────────────────────────────┐
│ "relatorio" │ /Users/joao/Docs/relatorio.pdf│
│ "foto1"     │ /Users/joao/Photos/foto1.jpg  │
│ "backup"    │ /System/backup.zip            │
└─────────────┴──────────────────────────────┘

🏷️ ÍNDICE POR EXTENSÃO  
┌─────┬─────────────────────────────────────┐
│.pdf │ [CV.pdf, relatorio.pdf, manual.pdf] │
│.jpg │ [foto1.jpg, foto2.jpg, logo.jpg]    │
│.mp4 │ [video1.mp4, apresentacao.mp4]      │
└─────┴─────────────────────────────────────┘
```

#### **🗓️ Semana 3: Otimização e Organização (Trilha 4 - AVL/Heaps)**
**Objetivo**: Organizar arquivos por diferentes critérios

**🎯 O que fazer**:
1. **AVL Tree por tamanho**:
    - Encontrar rapidamente arquivos grandes (limpeza de disco)
    - Listar arquivos ordenados por tamanho
    - Detectar duplicatas por tamanho + hash

2. **MinHeap para arquivos mais antigos**:
    - Encontrar arquivos para backup/arquivamento
    - Limpeza automática de arquivos temporários
    - Sugestões de arquivos esquecidos

3. **Sistema de tags inteligente**:
    - Tags automáticas baseadas em extensão
    - Tags personalizadas pelo usuário
    - Busca por múltiplas tags

#### **🗓️ Semana 4: Funcionalidades Avançadas**
**Objetivo**: Recursos de um sistema profissional

**🎯 O que fazer**:
1. **Sistema de versionamento**:
    - Múltiplas versões do mesmo arquivo
    - Histórico de mudanças
    - Rollback para versão anterior

2. **Análise de espaço em disco**:
    - Visualização do uso por pasta
    - Detecção de arquivos duplicados
    - Sugestões de limpeza

3. **Busca por conteúdo**:
    - Indexação do texto dentro dos arquivos
    - Busca full-text
    - Relevância dos resultados

---

## 🧠 **O Que Você Vai Aprender**

### 🎯 **Competências Técnicas Específicas**

**🌳 Árvores na Prática**:
- **Quando usar árvores**: Dados naturalmente hierárquicos
- **Navegação eficiente**: Operações de caminho (path traversal)
- **Balanceamento**: Por que sistemas reais usam B-trees

**⚡ Hash Tables Avançadas**:
- **Função hash para strings**: Como distribuir nomes de arquivo
- **Colisões reais**: Como lidar com arquivos de mesmo nome
- **Redimensionamento**: Quando e como expandir a tabela

**🔍 Indexação Múltipla**:
- **Índices compostos**: Buscar por nome + tipo + data
- **Trade-offs**: Velocidade de busca vs uso de memória
- **Manutenção**: Como manter índices sincronizados

### 💼 **Competências de Sistema**

**🗂️ Design de File Systems**:
- Como funciona NTFS, ext4, APFS
- Conceitos de inode, directory entry
- Performance de sistemas de arquivo

**🔍 Mecanismos de Busca**:
- Indexação vs busca linear
- Algoritmos de relevância
- Caching de resultados frequentes

---

## 🎯 **Desafios Progressivos**

### 🌱 **Nível Iniciante**
- [ ] Árvore de diretórios básica funcionando
- [ ] Navegação cd/ls/mkdir
- [ ] Busca por nome exato
- [ ] Cálculo de tamanho de pastas

### 🌿 **Nível Intermediário**
- [ ] Hash table para busca rápida por nome
- [ ] Índices por extensão e tamanho
- [ ] Busca com wildcards (*?)
- [ ] Sistema de permissões básico

### 🌳 **Nível Avançado**
- [ ] AVL tree para organização por tamanho/data
- [ ] Detecção de arquivos duplicados
- [ ] Sistema de tags personalizáveis
- [ ] Compressão automática de arquivos antigos

### 💎 **Nível Expert**
- [ ] Indexação de conteúdo full-text
- [ ] Sistema de versionamento Git-like
- [ ] Sincronização com cloud storage
- [ ] Interface gráfica com visualização de árvore

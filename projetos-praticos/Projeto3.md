# 🚗 PROJETO 3: App de Navegação Inteligente

## 🎭 **Analogia: O Melhor GPS do Mundo**

Você foi desafiado a criar um GPS que supere Google Maps e Waze! Seu app deve não apenas encontrar o caminho mais rápido, mas também **sugerir rotas alternativas**, **evitar trânsito pesado**, e **aprender com padrões de tráfego**.

Imagine um **mapa com 100.000 intersecções** (como São Paulo) onde você precisa calcular a melhor rota em **menos de 1 segundo**. Este é um dos problemas mais fascinantes da computação!

---

## 🎨 **Visualização do Sistema**

```
            🗺️ APP DE NAVEGAÇÃO INTELIGENTE
    
    🌐 MAPA COMO GRAFO
           A ──5km─── B ──3km─── C
           │(30min)   │(15min)   │
         2km│       4km│       1km│(5min)
      (10min)│   (20min)│         │
           │         │         │
           D ──7km─── E ──2km─── F
             (35min)   (10min)
    
    🎯 DIFERENTES TIPOS DE ROTA:
    
    🏃‍♂️ MAIS RÁPIDA (tempo): A→B→C→F = 35min
    📏 MAIS CURTA (distância): A→D→E→F = 11km  
    ⛽ ECONÔMICA (combustível): A→B→E→F = 9km
    🌳 CÊNICA (paisagem): A→D→(estrada rural)→F
    
    🧠 INTELIGÊNCIA ARTIFICIAL:
    ┌─────────────────────────────────────────┐
    │  📊 DADOS EM TEMPO REAL                 │
    │  🚗 Tráfego atual: Av. Paulista +45%    │
    │  🚧 Obras: Marginal Tietê fechada       │
    │  🌧️ Chuva: Velocidade -20% em toda SP   │
    │  📅 Rush hour: 18h = fator 1.8x         │
    └─────────────────────────────────────────┘
                    ↓
    ┌─────────────────────────────────────────┐
    │  🎯 ROTAS PERSONALIZADAS                │
    │  Rota 1: Evita Paulista (normal +15min) │
    │  Rota 2: Via expressa (+R$12 pedágio)   │
    │  Rota 3: Rota cênica (+25min, -stress)  │
    └─────────────────────────────────────────┘
```

---

## 🛠️ **Como Realizar o Projeto**

### 📅 **Cronograma Sugerido: 4-5 Semanas**

#### **🗓️ Semana 1: Modelagem do Mapa (Trilha 5 - Grafos)**
**Objetivo**: Representar o mundo real como um grafo computacional

**🎯 O que fazer**:
1. **Escolha a representação**:
    - **Lista de Adjacência** (recomendado): Eficiente para grafos esparsos
    - Cada intersecção = vértice
    - Cada rua = aresta com peso (tempo/distância)

2. **Crie as entidades**:
    - `Intersecao` (coordenadas GPS, tipo, semáforo?)
    - `Rua` (distância, velocidade máxima, tipo de via)
    - `Mapa` (grafo + operações de navegação)

3. **Carregue dados reais**:
    - Use OpenStreetMap da sua cidade
    - Converta para formato JSON simples
    - Comece com área pequena (centro da cidade)

4. **Visualização básica**:
    - Plot das intersecções em coordenadas x,y
    - Desenho das conexões
    - Interface simples para selecionar origem/destino

**💡 Por que Lista de Adjacência?** Mapas reais são **grafos esparsos** - cada intersecção conecta com poucas outras (2-6 em média), não com todas!

#### **🗓️ Semana 2: Algoritmos de Rota (Trilha 5 - Caminhos Mínimos)**
**Objetivo**: Implementar múltiplos algoritmos de roteamento

**🎯 O que fazer**:
1. **Dijkstra Clássico**:
    - Implementação com Heap (Priority Queue)
    - Encontra caminho ótimo garantido
    - Baseline para comparações

2. **A* (A-Estrela)**:
    - Dijkstra + heurística de distância euclidiana
    - Muito mais rápido que Dijkstra puro
    - Usado em jogos e navegação real

3. **Dijkstra Bidirecional**:
    - Busca simultânea de origem e destino
    - Para rotas muito longas (>100km)
    - Pode ser 2x mais rápido

4. **Comparação de Performance**:
    - Cronômetro cada algoritmo
    - Teste com diferentes distâncias
    - Analise trade-offs velocidade vs qualidade

**🎨 Visualização dos Algoritmos**:
```
🎯 DIJKSTRA (explora em todas direções)
     ○ ○ ○ ○ ○
   ○ ○ ○ ○ ○ ○ ○
 ○ ○ ○ S ○ ○ ○ ○ ○
   ○ ○ ○ ○ ○ ○ ○
     ○ ○ ○ ○ ○
           ↓
         Target

⭐ A-STAR (foca na direção do alvo)
         ○
       ○ ○ ○
     ○ ○ ○ ○ ○
       S ○ ○ ○
         ○ ○
           ↓
         Target
```

#### **🗓️ Semana 3: Rotas Inteligentes**
**Objetivo**: Adicionar inteligência ao sistema básico

**🎯 O que fazer**:
1. **Diferentes Critérios de Otimização**:
    - Tempo (padrão)
    - Distância (econômico)
    - Evitar pedágios
    - Evitar rodovias (rota cênica)

2. **Sistema de Pesos Dinâmicos**:
    - Manhã (7-9h): Ruas para centro +50% tempo
    - Tarde (17-19h): Ruas saindo centro +80% tempo
    - Chuva: Todas ruas +30% tempo
    - Fim de semana: Rodovias -20% tempo

3. **Rotas Alternativas**:
    - Implementar algoritmo de k-shortest paths
    - Garantir que rotas sejam "suficientemente diferentes"
    - Ranking por tempo, conforto, economia

4. **Prevenção de Trânsito**:
    - Identificar gargalos (pontes, túneis)
    - Sugerir horários alternativos
    - Alertas de congestionamento previsto

#### **🗓️ Semana 4: Análise de Tráfego**
**Objetivo**: Entender padrões e otimizar o sistema

**🎯 O que fazer**:
1. **Coleta de Dados Simulados**:
    - Simular 10.000 viagens por dia
    - Padrões realistas (casa→trabalho de manhã)
    - Variações por dia da semana

2. **Análise de Componentes Conectados**:
    - Identificar bairros isolados
    - Pontos críticos (se fecharem, cidade divide)
    - Redundância do sistema viário

3. **Detecção de Gargalos**:
    - Ruas mais utilizadas
    - Intersecções problemáticas
    - Sugestões de melhorias urbanas

4. **Machine Learning Básico**:
    - Predição de tempo de viagem
    - Padrões de tráfego por horário
    - Detecção de anomalias (acidente, evento)

#### **🗓️ Semana 5: Interface e Experiência**
**Objetivo**: Tornar o sistema utilizável e atrativo

**🎯 O que fazer**:
1. **Interface Gráfica**:
    - Mapa interativo (clique para origem/destino)
    - Visualização da rota calculada
    - Informações de tempo/distância

2. **Navegação Passo-a-Passo**:
    - "Em 500m, vire à direita na Rua A"
    - Recálculo automático se desviar
    - ETA (tempo estimado de chegada) atualizado

3. **Recursos Avançados**:
    - Histórico de viagens
    - Locais favoritos
    - Compartilhamento de rotas
    - Modo offline básico

---

## 🧠 **O Que Você Vai Aprender**

### 🎯 **Competências Algoritmo-Específicas**

**🛣️ Algoritmos de Grafos Reais**:
- **Dijkstra vs A***: Quando usar cada um na prática
- **Heurísticas**: Como criar estimativas que aceleram busca
- **Bidirectional Search**: Técnica avançada para grafos grandes

**📊 Análise de Redes**:
- **Centralidade**: Quais intersecções são mais importantes?
- **Conectividade**: Como medir robustez de uma rede viária
- **Fluxo Máximo**: Capacidade teórica do sistema

**⚡ Otimização de Performance**:
- **Preprocessing**: Como pré-calcular dados para busca rápida
- **Caching**: Quais rotas são consultadas com mais frequência
- **Paralelização**: Como usar múltiplos cores do processador

### 💼 **Competências de Domínio**

**🚗 Sistemas de Navegação**:
- Como funcionam GPS, Google Maps, Waze
- Diferença entre navegação online e offline
- Integração com dados de tráfego em tempo real

**🏙️ Planejamento Urbano**:
- Como o design de cidades afeta tráfego
- Conceitos de mobilidade urbana
- Impact de obras e eventos no trânsito

---

## 🎯 **Desafios Progressivos**

### 🌱 **Nível Iniciante**
- [ ] Grafo básico carregado de arquivo
- [ ] Dijkstra funcionando para rotas simples
- [ ] Interface de linha de comando
- [ ] Visualização básica em ASCII

### 🌿 **Nível Intermediário**
- [ ] A* implementado e mais rápido que Dijkstra
- [ ] Sistema de pesos por horário
- [ ] 3 rotas alternativas diferentes
- [ ] Interface gráfica básica

### 🌳 **Nível Avançado**
- [ ] Mapa real de cidade média (10k+ intersecções)
- [ ] Algoritmos otimizados (< 100ms por rota)
- [ ] Sistema de análise de tráfego
- [ ] Predição de congestionamentos

### 💎 **Nível Expert**
- [ ] Integração com APIs reais (trânsito, clima)
- [ ] Machine learning para otimização
- [ ] App mobile funcional
- [ ] Sistema distribuído (múltiplos servidores)

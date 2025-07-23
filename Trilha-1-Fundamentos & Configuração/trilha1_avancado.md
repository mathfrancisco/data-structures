# Fundamentos Java - Nível Avançado

## Exercício 1: Implementação de Builder Pattern
- Desenvolva uma classe complexa `Computador` com muitos atributos:
    - Processador, memória RAM, disco rígido, placa de vídeo, etc.
- Implemente o padrão Builder para criar instâncias de `Computador`
- Demonstre como o Builder facilita a criação de objetos com diferentes configurações

## Exercício 2: Reflection API
- Crie uma classe `AnalisadorClasse` que recebe um objeto qualquer como parâmetro
- Implemente métodos que usam Reflection para:
    - Listar todos os métodos da classe
    - Listar todos os atributos da classe
    - Invocar um método específico dinamicamente

## Exercício 3: Anotações Personalizadas
- Crie uma anotação personalizada `@LogExecutionTime`
- Implemente um mecanismo que, ao encontrar métodos com essa anotação, mede e registra o tempo de execução
- Demonstre o uso dessa anotação em vários métodos diferentes
import java.util.HashMap;

/**
 * Esta classe demonstra a alta performance da estrutura de dados HashMap
 * para buscar elementos através de uma chave.
 * A principal vantagem do HashMap é sua velocidade de busca, que em média
 * é de tempo constante, ou O(1), não importando o tamanho do mapa.
 */
public class Hasmap {

    // Define o número de elementos que vamos inserir e depois buscar.
    // Usamos um número grande para tornar a diferença de performance mais evidente.
    private static final int tamanho = 1000000; // 1 milhão de itens.

    public static void main(String[] args) {
        // 1. CRIAÇÃO DO HASHMAP
        // Criamos um HashMap que irá associar uma chave do tipo Integer (o ID do produto)
        // a um valor do tipo Produto (o objeto produto em si).
        // Pense nisso como um dicionário: a chave é a "palavra" e o valor é a "definição".
        HashMap<Integer, Produto> mapa = new HashMap<>();


        // 2. PREENCHIMENTO (POPULANDO O MAPA)
        // Este laço insere 1 milhão de produtos no mapa.
        // A complexidade desta etapa é O(n), pois precisamos realizar 'n' inserções.
        System.out.println("Inserindo " + tamanho + " produtos no mapa...");
        for (int i = 0; i < tamanho; i++) {
            // O método .put(chave, valor) associa a chave 'i' ao novo objeto Produto.
            // Graças à "mágica" do hash, o Java sabe exatamente onde guardar esse par
            // para encontrá-lo rapidamente depois.
            mapa.put(i, new Produto(i, "Produto " + i, i * 20.00));
        }
        System.out.println("Inserção concluída.");


        // 3. MEDIÇÃO DA PERFORMANCE DA BUSCA
        // Agora vamos medir quanto tempo leva para buscar todos os 1 milhão de itens.
        System.out.println("Buscando " + tamanho + " produtos no mapa...");
        long startTime = System.currentTimeMillis(); // Marca o tempo de início.

        // Este laço vai executar 'n' buscas no mapa.
        for (int qtd = 0; qtd < tamanho; qtd++) {
            // --- A OPERAÇÃO-CHAVE ESTÁ AQUI ---
            // O método .get(chave) busca um valor usando sua chave.
            // Esta operação é O(1) (tempo constante). Não importa se o mapa tem 100 ou
            // 10 milhões de itens, o tempo para encontrar um elemento é praticamente o mesmo.
            Produto p = mapa.get(qtd);
        }

        long endTime = System.currentTimeMillis(); // Marca o tempo de fim.

        // A complexidade total do laço de busca é n * O(1) = O(n).
        // O resultado é o tempo total para realizar 1 milhão de buscas ultra-rápidas.
        System.out.println("Tempo de execução da busca: " + (endTime - startTime) + "ms");
    }
}
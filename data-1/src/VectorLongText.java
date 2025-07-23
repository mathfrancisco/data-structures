/**
 * Esta classe demonstra um algoritmo com baixa performance devido à sua
 * complexidade de tempo quadrática, O(n²).
 * Isso acontece porque temos um laço de repetição (for) dentro de outro,
 * fazendo com que o número de operações cresça exponencialmente com o tamanho da entrada 'n'.
 */
public class VectorLongText {

    // Definindo o tamanho da nossa entrada 'n'.
    // Mesmo com 100.000 (menor que no exemplo do HashMap), o tempo será muito maior.
    private static final int tamanho = 100000;

    public static void main(String[] args) {
        // Criamos um array (vetor) de números longos, com 'tamanho' posições.
        // O acesso a um índice específico (ex: array[5]) é O(1), mas nosso algoritmo
        // não se beneficia disso.
        long[] array = new long[tamanho];

        System.out.println("Iniciando processamento com complexidade O(n²)...");
        long startTime = System.currentTimeMillis(); // Marca o tempo de início.

        // --- INÍCIO DO ALGORITMO O(n²) ---

        // Laço Externo: Será executado 'n' vezes (100.000 vezes).
        // Complexidade: O(n)
        for(int i = 0; i < tamanho; i++){

            // Laço Interno: Será executado 'n' vezes PARA CADA iteração do laço externo.
            // Complexidade: O(n)
            for(int j = 0; j < tamanho; j++){
                // Esta operação de soma será executada n * n vezes.
                // Total de operações = 100.000 * 100.000 = 10.000.000.000 (10 bilhões!).
                array[i] += j;
            }
        }

        // --- FIM DO ALGORITMO O(n²) ---

        long endTime = System.currentTimeMillis(); // Marca o tempo de fim.

        // O tempo de execução total reflete a natureza quadrática do algoritmo.
        // Se dobrássemos o 'tamanho', o tempo de execução seria aproximadamente 4x maior.
        System.out.println("Tempo de execução total: " + (endTime - startTime) + "ms");
    }
}
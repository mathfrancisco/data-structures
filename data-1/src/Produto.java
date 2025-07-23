/**
 * A classe Produto é um modelo de dados (ou "POJO" - Plain Old Java Object).
 * Ela serve como um "molde" para criar objetos que representam um produto,
 * contendo suas informações básicas como id, nome e preço.
 */
public class Produto {

    // --- ATRIBUTOS (ou campos, ou propriedades) ---
    // Atributos são as características do objeto. Usamos 'private' para aplicar o
    // princípio do encapsulamento, ou seja, protegemos os dados para que eles
    // só possam ser acessados ou modificados através de métodos públicos (getters e setters).

    private Integer id;     // Identificador único do produto.
    private String nome;    // Nome do produto.
    private Double preco;   // Preço do produto.


    // --- CONSTRUTOR ---
    /**
     * O construtor é um método especial chamado quando criamos um novo objeto desta classe.
     * Ex: new Produto(1, "Notebook", 5000.00);
     * Ele serve para inicializar os atributos do objeto com os valores passados.
     * A palavra-chave 'this' é usada para diferenciar o atributo da classe (this.id)
     * do parâmetro recebido pelo método (id).
     *
     * @param id    O ID a ser atribuído ao produto.
     * @param nome  O nome a ser atribuído ao produto.
     * @param preco O preço a ser atribuído ao produto.
     */
    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }


    // --- MÉTODOS GETTERS E SETTERS ---
    // São métodos públicos que permitem o acesso controlado aos atributos privados.

    /**
     * Getter para o ID. Retorna o valor do atributo 'id'.
     * @return o id do produto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter para o ID. Permite alterar o valor do atributo 'id'.
     * @param id o novo id do produto.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter para o Nome.
     * @return o nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter para o Nome.
     * @param nome o novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter para o Preço.
     * @return o preço do produto.
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Setter para o Preço.
     * @param preco o novo preço do produto.
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
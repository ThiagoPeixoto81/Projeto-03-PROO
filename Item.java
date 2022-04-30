public class Item implements Comparable<Item>{
    //Atributos
    private String nome;
    private String descricao;
    private double preco_compra;
    private double preco_venda;
    private double quantidade_comprada;
    private double quantidade_vendida;
    
    //Construtor da classe
    public Item(String nome, String desc, double preco_comp, double preco_vend, double qntd_comp, double qntd_vendida ){

        if (preco_comp < 0 || preco_comp == 0){
            throw new IllegalArgumentException("Erro: Preço de compra inválido. Tente Novamente\n");
        }else if(preco_vend < 0 || preco_vend == 0){
            throw new IllegalArgumentException("Erro: Preço de venda inválido. Tente Novamente\n");
        }else if(preco_vend < preco_comp){
            throw new IllegalArgumentException("Erro: Preço de venda menor que o preço de Compra. Tente Novamente\n");
        }else if(qntd_comp < 0 || qntd_comp == 0){
            throw new IllegalArgumentException("Erro: Quantidade comprada inválida. Tente Novamente\n");
        }else if(qntd_vendida > qntd_comp || qntd_vendida < 0){
            throw new IllegalArgumentException("Erro: Estoque negativo!. Tente Novamente\n");
        }else{
            this.preco_compra = preco_comp;
            this.preco_venda = preco_vend;
            this.nome = nome;
            this.descricao = desc;
            this.quantidade_comprada = qntd_comp;
            this.quantidade_vendida = qntd_vendida;
        }

    }


    //CompareTo
    @Override
    public int compareTo(Item outro){
        if (this.quantidade_comprada < outro.quantidade_comprada){
            return -1;
        }else if(this.quantidade_comprada > outro.quantidade_comprada){
            return 1;
        }else{
            return 0;
        }
    }


    //ToString, Getters e Setters
    @Override
    public String toString() {

        return ("Nome: " + this.nome + "\nDescrição: " + this.descricao + "\nPreço de compra: R$" + this.preco_compra + "\nPreço de venda: R$" + this.preco_venda + "\nQuantidade comprada: " + this.quantidade_comprada + "\nQuantidade vendida: " + this.quantidade_vendida);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco_compra(double preco_compra) {
        //Fazendo a mesma verificação do Construtor
        if (preco_compra < 0 || preco_compra == 0){
            throw new IllegalArgumentException("Erro: Preço de compra inválido. Tente Novamente\n");
        }else if(this.preco_venda < preco_compra){
            throw new IllegalArgumentException("Erro: Preço de venda menor que o preço de Compra. Tente Novamente\n");
        }else{
            this.preco_compra = preco_compra;
        }
    }

    public void setPreco_venda(double preco_venda) {
        //Fazendo a mesma verificação do Construtor
        if(preco_venda < 0 || preco_venda == 0){
            throw new IllegalArgumentException("Erro: Preço de venda inválido. Tente Novamente\n");
        }else if(preco_venda < this.preco_compra){
            throw new IllegalArgumentException("Erro: Preço de venda menor que o preço de Compra. Tente Novamente\n");
        }else{
            this.preco_venda = preco_venda;
        }
    }

    public void setQuantidade_comprada(double quantidade_comprada) {
        //Fazendo a mesma verificação do Construtor
        if(quantidade_comprada < 0 || quantidade_comprada == 0){
            throw new IllegalArgumentException("Erro: Quantidade comprada inválida. Tente Novamente\n");
        }else{
            this.quantidade_comprada = quantidade_comprada;
        }
    }

    public void setQuantidade_vendida(double quantidade_vendida) {
        if(quantidade_vendida < 0){
            throw new IllegalArgumentException("Erro: Estoque negativo. Tente Novamente\n");
        }else{
            this.quantidade_vendida = quantidade_vendida;
        }
        
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco_compra() {
        return preco_compra;
    }
    
    public double getPreco_venda() {
        return preco_venda;
    }
    
    public double getQuantidade_comprada() {
        return quantidade_comprada;
    }

    public double getQuantidade_vendida() {
        return quantidade_vendida;
    }


    //Adicionando novas quantidades
    public void Adicionaquantidade(double quantidade){
        this.quantidade_comprada = quantidade_comprada + quantidade;
    }

    //Fazendo baixa de itens
    public void VendasDeProdutos(double Numerodevendas){
        if (Numerodevendas > this.quantidade_comprada){
            throw new RuntimeException("Impossivel vender mais do que a quantidade existente. Tente Novamente.\n");
        }else{
            this.quantidade_comprada -= Numerodevendas;
        }
    }
}
public class Cantina {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        try{
            Item Produto1 = new Item("Teclado", "Rgestoque", 25, 40, 2000, 1500);
            Item Produto2 = new Item("Teclado", "Rgestoque", 25, 50, 1000, 800);
            Item produto3 = new Item("Teclado", "Rgestoque", 25, 30, 10, 5);
            
            estoque.AdicionaItem(Produto1);
            estoque.AdicionaItem(Produto2);
            estoque.AdicionaItem(produto3);
            estoque.MostraItens();
            estoque.ItensEmBaixa();
            estoque.prejuizolucro();

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}

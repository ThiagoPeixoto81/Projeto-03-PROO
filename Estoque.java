import java.util.ArrayList;

public class Estoque {
    
   private ArrayList<Item> Produtos = new ArrayList<Item>();
   private ArrayList<Item> ProdutosComBaixas = new ArrayList<Item>();
   
   
   //Adiciona Itens
   public void AdicionaItem(Item a){
        Produtos.add(a);
   }

   //Mostra itens
   public void MostraItens(){
       for (Item a:Produtos){
            System.out.println(a +"\n");
       }
   }

   //Itens Em baixa
   public void ItensEmBaixa(){
       for (Item a:Produtos){
           if (a.getQuantidade_comprada() < 50){
               ProdutosComBaixas.add(a);
           }
       }

       System.out.println("Os produtos em baixa são: \n");
        if (ProdutosComBaixas.isEmpty() == true){
            System.out.println("Não há produtos em baixa");
        }else{
            for (Item b:ProdutosComBaixas){
                System.out.println(b + "\n");
           }
        }
       }
    
    //Resumo Lucro/Prejuizo
    public void prejuizolucro(){
        double quantidadedeitensvendidos = 0;
        double quantidadedeitenscomprados = 0;
        double preju = 0;
        double lucro = 0;

        for (Item c:Produtos){
            quantidadedeitensvendidos += c.getQuantidade_vendida();
            quantidadedeitenscomprados += c.getQuantidade_comprada();
            preju += c.getPreco_compra() * c.getQuantidade_comprada();
            lucro += c.getPreco_venda() * c.getQuantidade_vendida();
        }

        System.out.println("O resumo das vendas da Cantina: " + "\n" +"Total de itens comprados: " + quantidadedeitenscomprados + "\nTotal de itens vendidos: " + quantidadedeitensvendidos + "\nLucro: R$" + lucro + "\nDinheiro gasto na compra de produtos: R$" + preju + "\nBalanço final: R$" + (lucro-preju));

    } 


}




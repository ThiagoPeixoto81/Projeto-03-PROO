import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Estoque {
    
   protected ArrayList<Item> Produtos = new ArrayList<Item>();
   private ArrayList<Item> ProdutosComBaixas = new ArrayList<Item>();
   
  //Mostra itens
  public void MostraItens(){
    Collections.sort(Produtos);
    System.out.println("=== Produtos do Estoque ===");
    for (Item a:Produtos){
         System.out.println(a +"\n");
    }
}

    //Exibição dos itens no menu
    public void MostraMenu(){
        int c = 0;
        System.out.println("=== Itens do Estoque ===");
        for (Item a:Produtos){
            System.out.printf("%s%d%s %s\n","[", c, "]", a.getNome());
            c++;
        }
    }
        
    

   //Adiciona Itens
   public void AdicionaItem(){
    while(true){
        Scanner sc = new Scanner(System.in);
        try{
            
            System.out.println("==== Adicionando Produtos ====");
            System.out.println("Insira o nome: ");
            String nome = sc.nextLine();
    
            System.out.println("Insira a descrição: ");
            String desc = sc.nextLine();
    
            System.out.println("Insira o preço de compra: ");
            double preco_compra = sc.nextDouble(); 
    
            System.out.println("Insira o preço de venda: ");
            double preco_venda = sc.nextDouble(); 
    
            System.out.println("Insira a quantidade comprada: ");
            double qntd_comp = sc.nextDouble(); 
    
            System.out.println("Insira a quantidade vendida: ");
            double qntd_vendida = sc.nextDouble(); 
            System.out.println("\n");
    
            Item a = new Item(nome, desc, preco_compra, preco_venda, qntd_comp, qntd_vendida);
            Produtos.add(a);
            
            System.out.println("Item adicionado com Sucesso!\n");
            break;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            
        }catch (InputMismatchException e){
            System.out.println("Insira valores válidos. Tente Novamente\n");

        }
        
    }
    
   }


   //Vende itens
   public void VendeItem(int index, double venda){
    if (venda > Produtos.get(index).getQuantidade_comprada()){
        throw new IllegalArgumentException("Não podemos vender essa quantidade. Tente novamente\n");
    }else{
        Produtos.get(index).VendasDeProdutos(venda);

        double adicionaquantidadevendida = Produtos.get(index).getQuantidade_vendida();
        Produtos.get(index).setQuantidade_vendida(adicionaquantidadevendida + venda);
    }

    System.out.println("Venda concluida!\n");
   }


   //Adiciona quantidade
   public void Adicionaquantidade(int index, double adicao){
       if (adicao < 0 || adicao == 0){
           throw new IllegalArgumentException("Impossivel adicionar essa quantidade de itens\n");
       }else{
           Produtos.get(index).Adicionaquantidade(adicao);
       }

       System.out.println("Quantidade adicionada!\n");
   }


   //Itens Em baixa
   public void ItensEmBaixa(){
       System.out.println("=== Produtos em baixa ===");
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

        System.out.println("=== Resumo Prejuizo/Lucro ===");
        for (Item c:Produtos){
            quantidadedeitensvendidos += c.getQuantidade_vendida();
            quantidadedeitenscomprados += c.getQuantidade_comprada();
            preju += c.getPreco_compra() * c.getQuantidade_comprada();
            lucro += c.getPreco_venda() * c.getQuantidade_vendida();
        }

        System.out.println("\nO resumo das vendas da Cantina: " + "\n" +"Total de itens comprados: " + quantidadedeitenscomprados + "\nTotal de itens vendidos: " + quantidadedeitensvendidos + "\nLucro: R$" + lucro + "\nDinheiro gasto na compra de produtos: R$" + preju + "\nBalanço final: R$" + (lucro-preju) + "\n");

    } 



}




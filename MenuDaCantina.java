import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDaCantina {
    
    private Estoque Estoque;
    
    public MenuDaCantina(Estoque Stock){
        this.Estoque = Stock;
    }


    public void Inicia(){
    
        Scanner sc = new Scanner(System.in);
            try{
                System.out.println("==== MENU ====");
                System.out.println("[1] Adicionar novo Item\n[2] Adicionar nova quantidade\n[3] Vender Item\n[4] Mostrar Resumo dos Itens\n[5]Mostrar Itens em Baixa (Menos de 50 unidades no estoque)\n[6] Mostrar Lucro/Prejuizo do Estoque\n[7]Sair\nSelecione a opção: ");
                int answer = sc.nextInt();
            
                switch (answer){
                    case 1:
                        Estoque.AdicionaItem();
                        this.Inicia();
                        break;
                       
                    case 2:

                        if (Estoque.Produtos.isEmpty()){
                            System.out.println("Não há nenhum item aqui. Tente adicionar um Item (Opção 1)");
                        }else{
                            Estoque.MostraMenu();

                            System.out.println("Qual item você deseja adicionar quantidade? (Digite o numero ao lado do nome)");
                            int index = sc.nextInt();
                            System.out.println("A quantidade que você irá adicionar: ");
                            int qnt = sc.nextInt();

                            Estoque.Adicionaquantidade(index, qnt);
                        }

                        break;
                    case 3:

                        if (Estoque.Produtos.isEmpty()){
                            System.out.println("Não há nenhum item aqui. Tente adicionar um Item (Opção 1)");
                        }else{
                            Estoque.MostraMenu();

                            System.out.println("Qual item vai ser vendido? (Digite o numero ao lado do nome)");
                            int index = sc.nextInt();
                            System.out.println("A quantidade que você irá vender: ");
                            int qnt = sc.nextInt();

                            Estoque.VendeItem(index, qnt);
                            
                    }

                        break;
                        
                    case 4:

                        
                }
                
            }catch(InputMismatchException e){
                System.out.println("Opção inválida. Tente novamente\n");
                this.Inicia();
            }catch (IndexOutOfBoundsException e){
                System.out.println("Você tentou acessar um item que não existe. Tente Novamente");
                this.Inicia();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                this.Inicia();
            }
        }
        
        


    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        MenuDaCantina menu = new MenuDaCantina(estoque);

        menu.Inicia();
        

        // estoque.AdicionaItem();
        // estoque.MostraItens();

        // try{
        //     estoque.VendeItem(0,10);
        //     estoque.Adicionaquantidade(0, 100);
        // }catch (IllegalArgumentException e){
        //     System.out.println(e.getMessage());
        // }
        
        // estoque.ItensEmBaixa();
        // estoque.MostraItens();
        


        
        // estoque.ItensEmBaixa();
        // estoque.prejuizolucro();
    }
}

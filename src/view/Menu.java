package view;
import model.Item;
import service.ItemService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Menu {
    private ItemService service;

    public Menu(ItemService service){
        this.service=service;
    }

    public void iniciar() {

        Scanner scanner = new Scanner(System.in);

        boolean executando = true;

        while (executando) {

            System.out.println("\n=========== CAMPUS HUB ===========");
            System.out.println("1 - Área Cliente");
            System.out.println("2 - Área Administrativa");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    areaCliente(scanner);
                    break;

                case 2:
                    System.out.println("Área administrativa ainda será implementada.");
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void cadastrarItem(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Cor: ");
        String cor = scanner.nextLine();


        System.out.print("Local: ");
        String local = scanner.nextLine();

        LocalDate data = LocalDate.now();
        Item item = new Item(
                nome,
                categoria,
                marca,
                cor,
                local,
                data
        );

        service.cadastrarItem(item);

        System.out.println("Item cadastrado com sucesso!");
    }
    private void listarItens() {

        List<Item> itens = service.listarTodos();

        for (Item item : itens) {
            System.out.println(item);
        }
    }

    private void buscarObjeto(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Digite o código do objeto: ");
        String codigo = scanner.nextLine();

        Item item = service.buscarPorCodigo(codigo);

        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Objeto não encontrado.");
        }
    }

    private void solicitarDevolucao(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Digite o código do objeto: ");
        String codigo = scanner.nextLine();

        boolean sucesso = service.solicitarDevolucao(codigo);

        if (sucesso) {
            System.out.println("Solicitação de devolução realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a solicitação.");
        }
    }

    private void areaCliente(Scanner scanner) {

        boolean executando = true;

        while (executando) {

            System.out.println("\n=========== ÁREA CLIENTE ===========");
            System.out.println("1 - Registrar objeto encontrado");
            System.out.println("2 - Buscar objeto");
            System.out.println("3 - Solicitar devolução");
            System.out.println("0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarItem(scanner);
                    break;

                case 2:
                    buscarObjeto(scanner);
                    break;

                case 3:
                    System.out.println("Solicitação de devolução ainda será implementada.");
                    break;

                case 0:
                    executando = false;
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}

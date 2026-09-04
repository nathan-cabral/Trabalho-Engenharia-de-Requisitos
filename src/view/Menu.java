package view;
import model.Item;
import service.AdminService;
import service.ItemService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import service.AdminService;

public class Menu {
    private ItemService service;

    public Menu(ItemService service, AdminService adminService) {
        this.service = service;
        this.adminService = adminService;
    }

    private AdminService adminService;


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
                    areaAdministrativa(scanner);
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
    private void areaAdministrativa(Scanner scanner) {

        scanner.nextLine();

        System.out.println("\n=========== ÁREA ADMINISTRATIVA ===========");

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        boolean autenticado = adminService.autenticar(id, senha);

        if (autenticado) {

            System.out.println("\nLogin realizado com sucesso!");

        } else {

            System.out.println("\nID ou senha incorretos.");

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

        System.out.println("\nObjeto registrado com sucesso!");
        System.out.println("Código do objeto: " + item.getCodigo());
        System.out.println("Status: " + item.getStatus());
    }
    private void listarItens() {

        List<Item> itens = service.listarTodos();

        for (Item item : itens) {
            System.out.println(item);
        }
    }

    private void buscarObjeto(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Digite o nome, código, marca, cor ou local do objeto: ");
        String termo = scanner.nextLine();

        List<Item> resultados = service.buscar(termo);

        if (resultados.isEmpty()) {

            System.out.println("Nenhum objeto encontrado.");

        } else {

            System.out.println("\n=========== RESULTADOS DA BUSCA ===========");

            for (Item item : resultados) {
                System.out.println(item);
                System.out.println("-----------------------------------");
            }
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
                    solicitarDevolucao(scanner);
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

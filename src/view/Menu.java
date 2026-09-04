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

            System.out.println("===== ACHADOS E PERDIDOS =====");
            System.out.println("1 - Cadastrar item");
            System.out.println("2 - Listar itens");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarItem(scanner);
                    break;

                case 2:
                    listarItens();
                    break;

                case 3:
                    System.out.println("Saindo...");
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

}

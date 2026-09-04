import model.Item;
import java.time.LocalDate;
import repository.ItemRepository;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Item celular=new Item(
                "Iphone 14 pro",
                "Eletronico",
                "Apple",
                "Preto",
                "Biblioteca",
                LocalDate.now()
        );

        Item mochila = new Item(
                "Mochila",
                "Acessório",
                "Nike",
                "Azul",
                "Mochila encontrada",
                LocalDate.now()
        );
        ItemRepository repository = new ItemRepository();

        repository.salvar(celular);
        repository.salvar(mochila);

        List<Item> itens = repository.listarTodos();


        System.out.println(itens);

    }

}
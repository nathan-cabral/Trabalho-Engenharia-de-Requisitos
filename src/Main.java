import model.Item;
import java.time.LocalDate;
import repository.ItemRepository;
import java.util.List;
import service.ItemService;
import view.Menu;

public class Main {

    public static void main(String[] args) {

        ItemRepository repository = new ItemRepository();

        ItemService service = new ItemService(repository);

        Menu menu = new Menu(service);

        menu.iniciar();





    }

}
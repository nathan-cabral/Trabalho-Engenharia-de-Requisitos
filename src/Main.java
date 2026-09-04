import model.Item;
import java.time.LocalDate;
import repository.ItemRepository;
import java.util.List;
import service.ItemService;
import view.Menu;
import service.AdminService;

public class Main {

    public static void main(String[] args) {

        ItemRepository repository = new ItemRepository();

        ItemService service = new ItemService(repository);

        AdminService adminService = new AdminService();

        Menu menu = new Menu(service, adminService);

        menu.iniciar();





    }

}
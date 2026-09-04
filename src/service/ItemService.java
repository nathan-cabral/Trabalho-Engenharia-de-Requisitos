package service;
import model.Item;
import repository.ItemRepository;
import java.util.List;

public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void cadastrarItem(Item item){
        repository.salvar(item);
    }

    public List<Item>listarTodos(){
        return repository.listarTodos();
    }

}
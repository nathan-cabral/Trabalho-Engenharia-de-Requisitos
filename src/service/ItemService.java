package service;
import model.Item;
import repository.ItemRepository;
import java.util.List;

public class ItemService {

    private ItemRepository repository;
    private int proximoCodigo = 1;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void cadastrarItem(Item item){
        String codigo = String.format("OB%03d", proximoCodigo);
        item.setCodigo(codigo);
        proximoCodigo++;
        repository.salvar(item);
    }

    public List<Item>listarTodos(){
        return repository.listarTodos();
    }

    public Item buscarPorCodigo(String codigo) {
        return repository.buscarPorCodigo(codigo);
    }


}
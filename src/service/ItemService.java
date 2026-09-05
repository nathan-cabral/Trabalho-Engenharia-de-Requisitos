package service;
import model.Item;
import repository.ItemRepository;
import java.util.List;
import model.StatusItem;

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

    public boolean solicitarDevolucao(String codigo) {

        Item item = repository.buscarPorCodigo(codigo);

        if (item == null) {
            return false;
        }

        if (item.getStatus() != StatusItem.ENCONTRADO) {
            return false;
        }

        item.setStatus(StatusItem.DEVOLUCAO_SOLICITADA);

        return true;
    }

    public List<Item> buscar(String termo) {
        return repository.buscar(termo);
    }
    public List<Item> listarSolicitacoesPendentes() {

        return repository.listarSolicitacoesPendentes();
    }



}
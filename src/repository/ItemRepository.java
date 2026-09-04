package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private List<Item> itens = new ArrayList<>();

    public void salvar(Item item) {
        itens.add(item);
    }

    public List<Item> listarTodos() {
        return itens;
    }

    public Item buscarPorCodigo(String codigo){
        for (Item item : itens) {
            if (item.getCodigo().equalsIgnoreCase(codigo)) {
                return item;
            }
        }
        return null;
    }
    public List<Item> buscar(String termo) {

        List<Item> resultados = new ArrayList<>();

        termo = termo.toLowerCase();

        for (Item item : itens) {

            if (
                    item.getCodigo().toLowerCase().contains(termo) ||
                            item.getNome().toLowerCase().contains(termo) ||
                            item.getCategoria().toLowerCase().contains(termo) ||
                            item.getMarca().toLowerCase().contains(termo) ||
                            item.getCor().toLowerCase().contains(termo) ||
                            item.getNome().toLowerCase().contains(termo) ||
                            item.getLocal().toLowerCase().contains(termo)
            ) {

                resultados.add(item);
            }
        }

        return resultados;
    }

}
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

}
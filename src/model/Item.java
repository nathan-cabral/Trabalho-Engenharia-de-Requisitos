package model;
import java.time.LocalDate;

public class Item {

    private String nome;
    private String categoria;
    private String marca;
    private String cor;
    private String local;
    private LocalDate data;
    private ItemStatus status;
    private String codigo;

    public Item(String nome,String categoria, String marca,
                String cor, String local, LocalDate data){
        this.nome=nome;
        this.categoria=categoria;
        this.marca=marca;
        this.cor=cor;
        this.local=local;
        this.data=data;
        this.status=ItemStatus.ENCONTRADO;
    }

    public String getNome(){
        return nome;
    }

    public String getCategoria(){
        return categoria;
    }

    public ItemStatus getStatus(){
        return status;
    }

    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo(){
        return codigo;
    }



    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", local='" + local + '\'' +
                ", data=" + data +
                '}';
    }
}

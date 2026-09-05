package model;
import java.time.LocalDate;

public class Item {

    private String nome;
    private String categoria;
    private String marca;
    private String cor;
    private String local;
    private LocalDate data;
    private StatusItem status;
    private String codigo;

    public Item(String nome,String categoria, String marca,
                String cor, String local, LocalDate data){
        this.nome=nome;
        this.categoria=categoria;
        this.marca=marca;
        this.cor=cor;
        this.local=local;
        this.data=data;
        this.status= StatusItem.ENCONTRADO;
    }

    public String getNome(){
        return nome;
    }

    public String getCategoria(){
        return categoria;
    }

    public StatusItem getStatus(){
        return status;
    }

    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getMarca(){
        return marca;
    }

    public String getCor(){
        return cor;
    }

    public String getLocal(){
        return local;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "========================================" +
                "\n           OBJETO ENCONTRADO" +
                "\n========================================" +
                "\nCódigo: " + codigo +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nMarca: " + marca +
                "\nCor: " + cor +
                "\nLocal: " + local +
                "\nData: " + data +
                "\nStatus: " + status +
                "\n========================================";
    }


}

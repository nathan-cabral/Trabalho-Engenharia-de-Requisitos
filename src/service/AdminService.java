package service;

public class AdminService {

    private final String ID_ADMIN = "admin";
    private final String SENHA_ADMIN = "1234";

    public boolean autenticar(String id, String senha) {

        return ID_ADMIN.equals(id) && SENHA_ADMIN.equals(senha);
    }
}
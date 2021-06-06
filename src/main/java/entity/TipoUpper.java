package entity;

public class TipoUpper {
    private int id;
    private String tipo;

    public TipoUpper (int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}

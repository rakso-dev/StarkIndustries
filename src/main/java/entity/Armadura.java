package entity;

public class Armadura {
    private int num_serie;
    private String modelo;

    public Armadura () {}

    public Armadura (int num_serie) {
        this.num_serie = num_serie;
    }

    public Armadura (int num_serie, String modelo) {
        this.num_serie = num_serie;
        this.modelo = modelo;
    }

    public int getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String toString() {
        return String.format("%s, %i", this.modelo, this.num_serie);
    }
}

package entity;

public class PiezaRobotica {
    private int id;
    private String linea;
    private String color;
    private double largo;
    private double ancho;
    private double alto;
    private int r_fabricante;
    private int r_armadura;

    public PiezaRobotica () {}

    public PiezaRobotica (int id) { this.id = id; } //ideal para delete

    public PiezaRobotica(int id, String linea, String color, double largo, double ancho, double alto, int r_fabricante, int r_armadura) {
        this.id = id;
        this.linea = linea;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.r_fabricante = r_fabricante;
        this.r_armadura = r_armadura;
    } //Este es para updates y selects

    public PiezaRobotica(String linea, String color, double largo, double ancho, double alto, int r_fabricante, int r_armadura) {
        this.linea = linea;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.r_fabricante = r_fabricante;
        this.r_armadura = r_armadura;
    } //Este es para inserts

    public int getId() {
        return id;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public int getR_fabricante() {
        return r_fabricante;
    }

    public void setR_fabricante(int r_fabricante) {
        this.r_fabricante = r_fabricante;
    }

    public int getR_armadura() {
        return r_armadura;
    }

    public void setR_armadura(int r_armadura) {
        this.r_armadura = r_armadura;
    }
}

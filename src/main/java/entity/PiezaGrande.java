package entity;

public class PiezaGrande extends PiezaRobotica {
    public PiezaGrande () {}

    public PiezaGrande (int id) {
        super(id);
    } //Delete

    public PiezaGrande(int id, String linea, String color, double largo, double ancho, double alto, String r_fabricante, int r_armadura) {
        super(id, linea, color, largo, ancho, alto, r_fabricante, r_armadura);
    } //Update y select

    public PiezaGrande(String linea, String color, double largo, double ancho, double alto, String r_fabricante, int r_armadura) {
        super(linea, color, largo, ancho, alto, r_fabricante, r_armadura);
    } //Insert
}

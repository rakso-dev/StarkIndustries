package entity;

public class PiezaChica extends PiezaRobotica{
    public PiezaChica () {}

    public PiezaChica(int id) {
        super(id);
    } //delete

    public PiezaChica(int id, String linea, String color, double largo, double ancho, double alto, String r_fabricante, int r_armadura) {
        super(id, linea, color, largo, ancho, alto, r_fabricante, r_armadura);
    } //Update y select

    public PiezaChica(String linea, String color, double largo, double ancho, double alto, String r_fabricante, int r_armadura) {
        super(linea, color, largo, ancho, alto, r_fabricante, r_armadura);
    } //Insert
}

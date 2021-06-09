package entity;

public class LowerBody extends PiezaRobotica {
    double altura_suelo;

    public LowerBody () {}

    public LowerBody (int id) { super(id); } //Para delete

    public LowerBody(int id, String linea, String color, double largo, double ancho, double alto, String r_fabricante, int r_armadura, double altura_suelo) {
        super(id, linea, color, largo, ancho, alto, r_fabricante, r_armadura);
        this.altura_suelo = altura_suelo;
    } //Select y update

    public LowerBody(String linea, String color, double largo, double ancho, double alto, String r_fabricante, int r_armadura, double altura_suelo) {
        super(linea, color, largo, ancho, alto, r_fabricante, r_armadura);
        this.altura_suelo = altura_suelo;
    } //Insert

    public double getAltura_suelo() {
        return altura_suelo;
    }

    public void setAltura_suelo(double altura_suelo) {
        this.altura_suelo = altura_suelo;
    }
}

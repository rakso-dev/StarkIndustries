package entity;

public class UpperBody extends PiezaRobotica {
    TipoUpper tipo;
    //int tipo;

    public UpperBody () {}

    public UpperBody (int id) { super(id); }

    public UpperBody(int id, String linea, String color, double largo, double ancho, double alto, int r_fabricante, int r_armadura, TipoUpper tipo) {
        super(id, linea, color, largo, ancho, alto, r_fabricante, r_armadura);
        this.tipo = tipo;
    }

    public TipoUpper getTipo() {
        return tipo;
    }

    /*
     public int getTipo() {
        return tipo;
     }
     */

    public void setTipo(TipoUpper tipo) {
        this.tipo = tipo;
    }

    /*
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    */
}

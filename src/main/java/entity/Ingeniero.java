package entity;

public class Ingeniero {
    private String cedula;
    private String nom_pila;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String calle;
    private int numero;
    private String codigo_postal;
    private String ciudad;
    private String pais;
    private String estudios;

    public Ingeniero () {} //default constructor

    public Ingeniero (String cedula) {
        this.cedula = cedula;   //for deletes n stuff
    }

    public Ingeniero (String cedula, String nom_pila, String apellido1, String apellido2, String telefono, String calle, int numero, String codigo_postal, String ciudad, String pais, String estudios) {
        this.cedula = cedula;
        this.nom_pila = nom_pila;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estudios = estudios;
    } //this is for inserts and updates :3

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNom_pila() {
        return nom_pila;
    }

    public void setNom_pila(String nom_pila) {
        this.nom_pila = nom_pila;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String toString () {
        return String.format("%s, %s %s %s, %s, %s %d, %s, %s, %s, %s", this.cedula, this.nom_pila, this.apellido1, this.apellido2, this.telefono, this.calle, this.numero,this.codigo_postal, this.ciudad, this.pais, this.estudios);
    }
}

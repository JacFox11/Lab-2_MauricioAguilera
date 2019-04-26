
package lab.pkg2_mauricioaguilera;


public class Empleados {
    private String nombre;
    private String appe;
    private String color;
    private int edad;
    private String genero;
    private double alt;
    private double peso;
    private String titulo;
    private String cargo;
    private int sueldo;
    
    public Empleados(String a, String b, String c, int d, String e, double f, double g, String h, String i, int j){
        nombre=a;
        appe=b;
        color=c;
        edad=d;
        genero=e;
        alt=f;
        peso=g;
        titulo=h;
        cargo=i;
        sueldo=j;
    }
    //******************************Sets y gets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppe() {
        return appe;
    }

    public void setAppe(String appe) {
        this.appe = appe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
    //****************************fin sets y gets
    
    public String toString(){
        return "Puesto: "+cargo+", "+nombre+" "+appe;
    }
    
}

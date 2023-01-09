import java.io.Serializable;

public class Juego implements Serializable {
    private String titulo;
    private int año;
    private String genero;
    private int edad;
    private String estudio;

    public Juego(String titulo, int año, String genero, int edad, String estudio) {
        this.titulo = titulo;
        this.año = año;
        this.genero = genero;
        this.edad = edad;
        this.estudio = estudio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "titulo='" + titulo + '\'' +
                ", año=" + año +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", estudio='" + estudio + '\'' +
                '}';
    }
}

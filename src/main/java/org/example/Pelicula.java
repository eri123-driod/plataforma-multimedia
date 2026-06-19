package org.example;

public class Pelicula extends Contenido {
    private String director;

    public Pelicula(String titulo, String genero, int duracion, String director) {
        super(titulo, genero, duracion);
        setDirector(director);
    }

    public String getDirector() { return director; }
    public void setDirector(String director) {
        this.director = (director == null || director.trim().isEmpty()) ? "Director Anónimo" : director;
    }

    @Override
    public String obtenerTipoContenido() { return "Película"; }

    @Override
    public String obtenerDatosParticulares() {
        return "Director: " + getDirector();
    }

    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("-> Disfruta la película dirigida por " + director + "\n");
    }
}

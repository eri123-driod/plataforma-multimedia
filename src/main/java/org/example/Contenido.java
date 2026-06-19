package org.example;

public abstract class Contenido { // se agrega abstract
    private String titulo;
    private String genero;
    protected int duracion; // Cambiado a protected para que el la serie se pueda usar en el cálculo

    public Contenido(String titulo, String genero, int duracion) {
        setTitulo(titulo);
        setGenero(genero);
        setDuracion(duracion);
    }

    public String getTitulo() { return titulo.toUpperCase(); }
    public void setTitulo(String titulo) {
        this.titulo = (titulo == null || titulo.trim().isEmpty()) ? "Sin Título" : titulo;
    }

    public String getGenero() { return "[" + genero + "]"; }
    public void setGenero(String genero) {
        this.genero = (genero == null || genero.trim().isEmpty()) ? "Sin Genero (GENERAL)" : genero;
    }

    public String getDuracion() { return duracion + " min."; }
    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            this.duracion = 1;
            System.out.println("Debe ser minimo de un minuto ");
        } else {
            this.duracion = duracion;
        }
    }

    public void reproducir(){
        System.out.print("Reproduciendo: "+ getTitulo() + " (" + getGenero() + ") ");
    }

    // --- NUEVOS MÉTODOS ---

    // Métodos abstractos que las hijas DEBEN implementar
    public abstract String obtenerTipoContenido();
    public abstract String obtenerDatosParticulares();

    // Métodos concretos (generales)
    public int obtenerTiempoTotal() {
        return this.duracion; // Por defecto regresa la duración base
    }

    public String obtenerDatosGenerales() {
        return "Título: " + getTitulo() + " | Género: " + getGenero() + " | Duración Base: " + getDuracion();
    }

    @Override
    public String toString() {
        return obtenerDatosGenerales() + " | " + obtenerDatosParticulares();
    }
}

package org.example;

public class Podcast extends Contenido {
    private String nombrePresentador;

    public Podcast(String titulo, String genero, int duracion, String nombrePresentador) {
        super(titulo, genero, duracion);
        setNombrePresentador(nombrePresentador);
    }

    public String getNombrePresentador() { return nombrePresentador; }
    public void setNombrePresentador(String nombrePresentador) {
        this.nombrePresentador = (nombrePresentador == null || nombrePresentador.trim().isEmpty()) ? "Desconocido" : nombrePresentador;
    }

    @Override
    public String obtenerTipoContenido() { return "Podcast"; }

    @Override
    public String obtenerDatosParticulares() {
        return "Presentador: " + getNombrePresentador();
    }

    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("-> Escuchando a: " + nombrePresentador + " en los micrófonos.\n");
    }
}


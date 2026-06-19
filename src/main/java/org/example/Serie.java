package org.example;

public class Serie extends Contenido {
    private int numTem;
    private int totalEpisodios; // Nuevo atributo necesario

    public Serie(String titulo, String genero, int duracionPorEpisodio, int numTem, int totalEpisodios) {
        super(titulo, genero, duracionPorEpisodio);
        setNumTem(numTem);
        setTotalEpisodios(totalEpisodios);
    }

    public void setNumTem(int numTem) { this.numTem = numTem <= 0 ? 1 : numTem; }

    public int getTotalEpisodios() { return totalEpisodios; }
    public void setTotalEpisodios(int totalEpisodios) { this.totalEpisodios = totalEpisodios <= 0 ? 1 : totalEpisodios; }

    @Override
    public String obtenerTipoContenido() { return "Serie"; }

    @Override
    public String obtenerDatosParticulares() {
        return "Temporadas: " + numTem + " | Total Episodios: " + totalEpisodios;
    }

    @Override
    public int obtenerTiempoTotal() {
        return this.duracion * this.totalEpisodios; // Duración promedio x cantidad de episodios
    }

    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("-> Maratoneando " + numTem + " temporadas.\n");
    }
}
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Contenido> plataforma = new ArrayList<>();
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    static void nuevaPelicula() throws IOException {
        System.out.print("Título de la película: "); String titulo = leer.readLine();
        System.out.print("Género: "); String genero = leer.readLine();
        System.out.print("Duración (en minutos): "); int duracion = Integer.parseInt(leer.readLine());
        System.out.print("Director: "); String director = leer.readLine();

        plataforma.add(new Pelicula(titulo, genero, duracion, director));
        System.out.println("¡Película registrada con éxito!\n");
    }

    static void nuevaSerie() throws IOException {
        System.out.print("Título de la serie: "); String titulo = leer.readLine();
        System.out.print("Género: "); String genero = leer.readLine();
        System.out.print("Duración promedio por episodio (min): "); int duracion = Integer.parseInt(leer.readLine());
        System.out.print("Número de temporadas: "); int temporadas = Integer.parseInt(leer.readLine());
        System.out.print("Número TOTAL de episodios de la serie: "); int episodios = Integer.parseInt(leer.readLine());

        plataforma.add(new Serie(titulo, genero, duracion, temporadas, episodios));
        System.out.println("¡Serie registrada con éxito!\n");
    }

    static void nuevoPodcast() throws IOException {
        System.out.print("Título del podcast: "); String titulo = leer.readLine();
        System.out.print("Género/Temática: "); String genero = leer.readLine();
        System.out.print("Duración (en minutos): "); int duracion = Integer.parseInt(leer.readLine());
        System.out.print("Nombre del presentador: "); String presentador = leer.readLine();

        plataforma.add(new Podcast(titulo, genero, duracion, presentador));
        System.out.println("¡Podcast registrado con éxito!\n");
    }

    // Filtrar contenidos por tipo (Pelicula, Serie, Podcast)
    static void filtrarPorTipo() throws IOException {
        System.out.println("¿Qué tipo de contenido deseas ver? (1. Película / 2. Serie / 3. Podcast): ");
        int tipo = Integer.parseInt(leer.readLine());
        String filtro = (tipo == 1) ? "Película" : (tipo == 2) ? "Serie" : (tipo == 3) ? "Podcast" : "";

        if (filtro.isEmpty()) { System.out.println("Opción inválida."); return; }

        System.out.println("\n--- MOSTRANDO UNICAMENTE: " + filtro.toUpperCase() + "S ---");
        for (Contenido c : plataforma) {
            if (c.obtenerTipoContenido().equals(filtro)) {
                System.out.println(c);
            }
        }
    }

    // Mostrar el tiempo total de reproducción
    static void mostrarTiemposTotales() {
        System.out.println("\n--- TIEMPOS TOTALES DE REPRODUCCIÓN ---");
        for (Contenido c : plataforma) {
            System.out.println(c.getTitulo() + " (" + c.obtenerTipoContenido() + ") -> Tiempo Total: " + c.obtenerTiempoTotal() + " min.");
        }
    }

    // Mostrar episodios (Exclusivo de Series usando Downcasting seguro)
    static void mostrarEpisodiosSeries() {
        System.out.println("\n--- CANTIDAD DE EPISODIOS EN SERIES ---");
        boolean haySeries = false;
        for (Contenido c : plataforma) {
            if (c instanceof Serie) {
                Serie s = (Serie) c; // Downcasting
                System.out.println("Serie: " + s.getTitulo() + " -> " + s.getTotalEpisodios() + " episodios.");
                haySeries = true;
            }
        }
        if(!haySeries) System.out.println("No hay series registradas.");
    }

    // Mostrar solo datos generales de la clase padre
    static void mostrarDatosGenerales() {
        System.out.println("\n--- DATOS GENERALES (CLASE PADRE) ---");
        for (Contenido c : plataforma) {
            System.out.println(c.obtenerDatosGenerales());
        }
    }

    // Mostrar solo datos particulares de las clases hijas
    static void mostrarDatosParticulares() {
        System.out.println("\n--- DATOS PARTICULARES (CLASES HIJAS) ---");
        for (Contenido c : plataforma) {
            System.out.println(c.getTitulo() + " (" + c.obtenerTipoContenido() + ") -> " + c.obtenerDatosParticulares());
        }
    }

     static void main() throws IOException {
         int op = 0;
         while (op != 9) {
             System.out.println("\n***=== PLATAFORMA MULTIMEDIA ===***");
             System.out.println("1. Registrar película");
             System.out.println("2. Registrar serie");
             System.out.println("3. Registrar podcast");
             System.out.println("---------------------------------------------------------------------------------");
             System.out.println("4. Mostrar únicamente por tipo (Serie, Película o Podcast)"); // Requerimiento 1
             System.out.println("5. Mostrar el Tiempo Total de cada contenido");            // Requerimiento 2
             System.out.println("6. Mostrar número de episodios en las series)");             // Requerimiento 3
             System.out.println("7. Mostrar los datos generales de Todo el Contenido");          // Requerimiento 4
             System.out.println("8. Mostrar los datos particulares de los contenidos ");       // Requerimiento 5
             System.out.println("9. Salir");
             System.out.print("\n¿Qué opción eliges?: ");
             op = Integer.parseInt(leer.readLine());

             switch (op) {
                 case 1: nuevaPelicula();
                 break;
                 case 2: nuevaSerie();
                 break;
                 case 3: nuevoPodcast();
                 break;
                 case 4: filtrarPorTipo();          // Ejecuta el filtro por tipo
                     break;
                 case 5: mostrarTiemposTotales();     // Llama a obtenerTiempoTotal()
                     break;
                 case 6: mostrarEpisodiosSeries();   // Llama a numero de episodios / totalEpisodios
                     break;
                 case 7: mostrarDatosGenerales();     // Llama a obtenerDatosGenerales()
                     break;
                 case 8: mostrarDatosParticulares();  // Llama a obtenerDatosParticulares()
                     break;
                 case 9:  System.out.println("Regresa pronto a nuestra plataforma....!!!");
                     break;
                 default: System.out.println("Opción no válida\n");
             }
         }
    }
}

package Servicio;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Entidad.Ahorcado;

public class AhorcadoServicio {

  Ahorcado ahorcado = new Ahorcado();
  Scanner scan = new Scanner(System.in);

  public void crearJuego() {

    System.out.println("Bienvenidos a EL AHORCADO (^o^)");
    elegirNivel();
    System.out.println("Para el nivel " + ahorcado.getNivel() + " tendrás " + ahorcado.getIntentosXnivel() + " intentos.");
    cadenaNivel();
    palabraReemplazada();
    System.out.println("Descubrir palabra: " + Arrays.toString(palabraReemplazada()));
  }

  public int elegirNivel() {
  
    System.out.println("Elegir nivel 1, 2 o 3: ");
    int nivel = Integer.parseInt(scan.nextLine());

    if(nivel != 1 && nivel != 2 && nivel != 3) {
      do {
        System.out.println("Ingrese un número válido por favor.");
        System.out.println("Elegir nivel 1, 2 o 3: ");
        nivel = Integer.parseInt(scan.nextLine());
      } while (nivel != 1 && nivel != 2 && nivel != 3);
    }
    
    ahorcado.setNivel(nivel);
    intentos(nivel);

    return nivel;
  }

  public void intentos(int nivel) {
    switch(nivel) {
      case 1: ahorcado.setIntentosXnivel(3); break;
      case 2: ahorcado.setIntentosXnivel(4); break;
      case 3: ahorcado.setIntentosXnivel(5); break;
      default: elegirNivel();
    }
  }

  public void cadenaNivel() {
    String[] palabras1, palabras2, palabras3 = new String[5];
    int nivel = ahorcado.getNivel();

    palabras1 = new String[]{"hola", "gato", "mundo", "mama", "lindo"};
    palabras2 = new String[]{"edificio", "ahorcado", "galaxia", "estrella", "universo"};
    palabras3 = new String[]{"sentimiento", "vegetariano", "bioquimica", "arquitectura", "contemplacion"};

    switch(nivel) {
      case 1: ahorcado.setCadenaNivel(palabras1); break;
      case 2: ahorcado.setCadenaNivel(palabras2); break;
      case 3: ahorcado.setCadenaNivel(palabras3); break;
      default: elegirNivel();
    }

    palabraAzar();
  }

  public void palabraAzar() {
    Random rand = new Random();
    int num = rand.nextInt(5)+1;
    String[] cadena = ahorcado.getCadenaNivel();

    ahorcado.setPalabraAjugar(cadena[num-1]);
  }

  public String[] palabraReemplazada() {
    String[] palabra = new String[ahorcado.getPalabraAjugar().length()];
    Arrays.fill(palabra, 0, ahorcado.getPalabraAjugar().length(), " _ ");
    // System.out.println(palabraReemplazada);
    return palabra;
  }

}

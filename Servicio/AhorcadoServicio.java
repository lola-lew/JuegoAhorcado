package Servicio;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Entidad.Ahorcado;

public class AhorcadoServicio {

  Ahorcado ahorcado = new Ahorcado();
  Scanner scan = new Scanner(System.in);


  public void crearJuego() {
    System.out.println("\nHoli! Bienvenidos a EL AHORCADO (^o^)");
    elegirNivel();
    System.out.println("Para el nivel " + ahorcado.getNivel() + " tendrás " + ahorcado.getIntentosXnivel() + " intentos.");
    cadenaNivel();
    palabraReemplazada();
    System.out.println(ahorcado.getPalabraAjugar());
    System.out.println("Descubrir palabra: " + palabraReemplazada());
    adivinarLetra();
    // reemplazarLetra();
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
    // Se setea la cantidad de intentos posibles de acuerdo al nivel elegido
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
  // Se setea la cadena de palabras que corresponde al nivel elegido
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
  // De la cadena de palabras del nivel se seleccionará una palabra random para jugar
    Random rand = new Random();
    int num = rand.nextInt(5)+1;
    String[] cadena = ahorcado.getCadenaNivel();

    ahorcado.setPalabraAjugar(cadena[num-1]);
  }


  public String palabraReemplazada() {
  /* 
   * Metodo para que la palabra a jugar se muestre asi:
   * hola ->  _ _ _ _
   */

    String palabra = ahorcado.getPalabraAjugar();
    int tamanio = (palabra.length()*2)-1;
    char[] palabraNueva = new char[tamanio];

    for (int i = 0; i < tamanio; i++) {
        if (i % 2 == 0) palabraNueva[i] = '_'; else palabraNueva[i] = ' ';
    }

    String palabraFinal = new String(palabraNueva);
    return palabraFinal;
  }


  public void letraAdivinada() {
    System.out.println("Adivinar letra >> ");
    ahorcado.setLetraAdivinada(scan.next().charAt(0));
  }
    
  
  public boolean verificar() {
  // Si la palabra contiene la letra adivinada el metodo retorna true
    String palabra = ahorcado.getPalabraAjugar();
    if(palabra.contains(String.valueOf(ahorcado.getLetraAdivinada()))) return true; else return false;
  }


  public void adivinarLetra() {
    
    for (int i = 0; i < ahorcado.getIntentosXnivel(); i++) {
      letraAdivinada(); 
      if(verificar()) {
        System.out.println("adivinaste. Crear metodo para reemplazar letras");
        reemplazarLetra();
      } else {
        adivinarLetra();
      }  
    }
  }


  public void reemplazarLetra() {
    char letra = ahorcado.getLetraAdivinada();
    String palabra = ahorcado.getPalabraAjugar();
    int tamanio = (palabra.length()*2)-1;
    char[] palabraNueva = new char[tamanio];

    // for (int i = 0; i < tamanio; i++) {
    //     if (i % 2 == 0) {
    //         int letraIndex = i / 2; // Índice de la letra en la palabra original
    //         palabraNueva[i] = palabra.charAt(letraIndex);
    //     } else {
    //         palabraNueva[i] = ' ';
    //     }
    // }

    for (int i = 0; i < palabra.length(); i++) {
      if(palabra.charAt(i) != letra) {
        palabraNueva[i] = '_';
      } else {
        palabraNueva[i] = palabra.charAt(i);
      }
    }

    String palabraFinal = new String(palabraNueva);
    System.out.println(palabraFinal);

  }

}

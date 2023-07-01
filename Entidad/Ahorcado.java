package Entidad;

public class Ahorcado {
  
  private int nivel, intentosXnivel;
  private String[] cadenaNivel;
  private String palabraAjugar;
  private Character letraAdivinada;


  public Ahorcado() {
  }


  public Ahorcado(int nivel, int intentosXnivel, String[] arregloNivel, String palabraAjugar, Character letraAdivinada) {
    this.nivel = nivel;
    this.intentosXnivel = intentosXnivel;
    this.cadenaNivel = arregloNivel;
    this.palabraAjugar = palabraAjugar;
    this.letraAdivinada = letraAdivinada;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public int getIntentosXnivel() {
    return intentosXnivel;
  }

  public void setIntentosXnivel(int intentosXnivel) {
    this.intentosXnivel = intentosXnivel;
  }

  public String[] getCadenaNivel() {
    return cadenaNivel;
  }

  public void setCadenaNivel(String[] arregloNivel) {
    this.cadenaNivel = arregloNivel;
  }

  public String getPalabraAjugar() {
    return palabraAjugar;
  }

  public void setPalabraAjugar(String palabraAjugar) {
    this.palabraAjugar = palabraAjugar;
  }

  public Character getLetraAdivinada() {
    return letraAdivinada;
  }

  public void setLetraAdivinada(Character letraAdivinada) {
    this.letraAdivinada = letraAdivinada;
  }
  
}

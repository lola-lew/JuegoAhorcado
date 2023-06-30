package Entidad;

public class Ahorcado {
  
  private int nivel, intentosXnivel;
  private String[] arregloNivel;
  private String palabraAjugar;
  
  
  public Ahorcado() {
  }


  public Ahorcado(int nivel, int intentosXnivel, String[] arregloNivel, String palabraAjugar) {
    this.nivel = nivel;
    this.intentosXnivel = intentosXnivel;
    this.arregloNivel = arregloNivel;
    this.palabraAjugar = palabraAjugar;
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


  public String[] getArregloNivel() {
    return arregloNivel;
  }


  public void setArregloNivel(String[] arregloNivel) {
    this.arregloNivel = arregloNivel;
  }


  public String getPalabraAjugar() {
    return palabraAjugar;
  }


  public void setPalabraAjugar(String palabraAjugar) {
    this.palabraAjugar = palabraAjugar;
  }

  
}

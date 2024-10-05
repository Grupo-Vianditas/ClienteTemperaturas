package org.example;

public class TemperaturaMessage {
    private String nombreHeladera;
    private int temperatura;

    public TemperaturaMessage(String nombreHeladera, int temperatura) {
        this.nombreHeladera = nombreHeladera;
        this.temperatura = temperatura;
    }

    public String getNombreHeladera() {
        return nombreHeladera;
    }

    public void setNombreHeladera(String nombreHeladera) {
        this.nombreHeladera = nombreHeladera;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
}

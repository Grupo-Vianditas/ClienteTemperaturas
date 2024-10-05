package org.example;

import java.time.LocalDateTime;

public class TemperaturaDTO {

    private Integer heladeraId;
    private Integer temperatura;

    private LocalDateTime fechaMedicion;

    public TemperaturaDTO(int heladeraId, int temperatura) {
        this.heladeraId = heladeraId;
        this.temperatura = temperatura;
        this.fechaMedicion = setFechaMedicion();
    }

    public Integer getHeladeraId() {
        return heladeraId;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public LocalDateTime getFechaMedicion() {
        return fechaMedicion;
    }

    public void setHeladeraId(Integer heladeraId) {
        this.heladeraId = heladeraId;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public LocalDateTime setFechaMedicion(){
        return LocalDateTime.now();
    }
}

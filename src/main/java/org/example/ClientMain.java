package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Map;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws Exception {

        Map<String, String> env = System.getenv();
        MQUtils mqutils = new MQUtils(
                env.get("QUEUE_HOST"),
                env.get("QUEUE_USERNAME"),
                env.get("QUEUE_PASSWORD"),
                env.get("QUEUE_USERNAME"),
                env.get("QUEUE_NAME")
        );
        mqutils.init();

        Scanner scanner = new Scanner(System.in);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // que mande mensajes hasta que se canse
        while(true){
            try {
                System.out.println("Ingrese el identificador (ID) de la heladera a actualizar: ");
                int heladeraId = Integer.parseInt(scanner.nextLine());

                System.out.println("Ingresa la temperatura: ");
                int temperatura = Integer.parseInt(scanner.nextLine());

                TemperaturaDTO tempMessage = new TemperaturaDTO(heladeraId, temperatura);

                String jsonMessage = objectMapper.writeValueAsString(tempMessage);

                System.out.println(":::: Mensaje a publicar: "+ jsonMessage + " ::::");

                mqutils.publish(jsonMessage);
                System.out.println(":::: Mensaje publicado con éxito ::::");
            } catch (NumberFormatException nfe) {
                System.out.println(":::: Error - Ingrese un valor valido ! ::::");
            } catch (Exception e){
                System.out.println(":::: Error - "+e+" ::::");
            }
        }

    }
}
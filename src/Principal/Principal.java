package Principal;

import Modelo.Moneda;
import PJson.GeneradorJson;
import API.ConsultaApi;


import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        GeneradorJson generador = new GeneradorJson();
        String origenMoneda = "";
        String destinoMoneda = "";
        double monto;
        int opcion = 1;

        while (opcion != 7){
            System.out.println("""
                    \n******************************************************
                    Sea Bienvenido/a al conversor de monedas =)
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    ******************************************************
                    
                    Elija una opción válida: """);

            if (!lectura.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                lectura.next(); // Consumir la entrada inválida
                continue;
            }

            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    origenMoneda = "USD";
                    destinoMoneda = "ARS";
                    break;
                case 2:
                    origenMoneda = "ARS";
                    destinoMoneda = "USD";
                    break;
                case 3:
                    origenMoneda = "USD";
                    destinoMoneda = "BRL";
                    break;
                case 4:
                    origenMoneda = "BRL";
                    destinoMoneda = "USD";
                    break;
                case 5:
                    origenMoneda = "USD";
                    destinoMoneda = "COP";
                    break;
                case 6:
                    origenMoneda = "COP";
                    destinoMoneda = "USD";
                    break;
                case 7:
                    System.out.println("El proceso finalizó");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida");
                    break;
            }

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el monto que desea convertir: ");

                if (!lectura.hasNextDouble()) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                    lectura.next(); // Consumir la entrada inválida
                    continue;
                }

                monto = lectura.nextDouble();

                if (monto > 0){
                    try {
                        Moneda consultaConversion = consulta.buscaMoneda(origenMoneda, destinoMoneda, monto);
                        System.out.println("El valor de " + monto +
                                " [" + origenMoneda + "] equivale a " + consultaConversion.conversion_result() +
                                " [" + destinoMoneda + "]");

                        generador.guardarArchivo(consultaConversion, origenMoneda, destinoMoneda);
                    } catch (NumberFormatException e){
                        System.out.println("Error, número no encontrado: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Error al grabar datos a JSON: " + e.getMessage());
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Por favor, ingrese un monto mayor a 0");
                }
            }
        }
        lectura.close();
        System.out.println("Finalizó la ejecución del programa");
    }
}
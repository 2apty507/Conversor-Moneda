import Index.Conexion;
import Index.Funtion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner a= new Scanner(System.in);
        Funtion funtion = new Funtion();
        Conexion connection = new Conexion();

        double monto = 0;
        double convertir = 0;
        String send;
        String search;
        int option = 0;

        do {

            //Menu y reset del option
            try{
                System.out.println("""
                        \n~~~~~~~~ Bienvenido al Conversor de Monedas~~~~~~~~
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        1- Dolar (USD) ---> Libra Esterlina (GBP)
                        2- Libra Esterlina (GBP) ---> Dolar (USD)
                        3- Euro (EUR) ---> Dolar (USD)
                        4- Dolar (USD) ---> Euro (EUR)
                        5- Consultar codigos de monedas
                        6- Deseo convertir a otras monedas
                        7- Salir
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        ~~~~ Eliga su opcion: ~~~~
                        """);
                option = a.nextInt();

            // Funcionamiento de las elecciones del option
             switch (option) {
                 case 1:
                     funtion.print("USD", "GBP");
                     monto = a.nextDouble();
                     convertir = funtion.convert("USD", "GBP", monto);
                     funtion.answer(monto, "USD", convertir, "GBP");
                     break;

                 case 2:
                     funtion.print("GBP", "USD");
                     monto = a.nextDouble();
                     convertir = funtion.convert("GBP", "USD", monto);
                     funtion.answer(monto, "GBP", convertir, "USD");
                     break;

                 case 3:
                     funtion.print("EUR", "USD");
                     monto = a.nextDouble();
                     convertir = funtion.convert("EUR", "USD", monto);
                     funtion.answer(monto, "", convertir, "");
                     break;
                 case 4:
                     funtion.print("USD","EUR");
                     monto = a.nextDouble();
                     convertir = funtion.convert("USD","EUR", monto);
                     funtion.answer(monto, "USD", convertir,"EUR");
                     break;
                 case 5:
                     System.out.println("Ingrese el codigo de la moneda a utilizar: ");
                     send = a.next().toUpperCase();
                     System.out.println("Ingrese el codigo de la moneda a la cual desea realizar la funtion: ");
                     search = a.next().toUpperCase();
                     System.out.println("Ingrese el monto a convertir: ");
                     monto = a.nextDouble();
                     convertir = funtion.convert(send, search, monto);
                     funtion.answer(monto, send, convertir, search);
                     break;
                 case 6:
                     funtion.monedas();
                     break;
                 case 7:
                     System.out.println("Finalizando Programa");
                     break;
                 default:
                     System.out.println("Opcion no valida");
             }
            }catch (NullPointerException e){
                System.out.println("Divisa erronea, ingrese el codigo correctamenta");
                a.nextLine();
            }catch (Exception e){
                System.out.println("Ingrese solamente números");
                a.nextLine();
            }

        } while (option !=7);



    }
}
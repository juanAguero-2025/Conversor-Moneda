import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteHttp cliente = new ClienteHttp(); 
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("********************************************");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertir(scanner, cliente, "USD", "ARS", "Dólar", "Peso argentino");
                    break;
                case 2:
                    convertir(scanner, cliente, "ARS", "USD", "Peso argentino", "Dólar");
                    break;
                case 3:
                    convertir(scanner, cliente, "USD", "BRL", "Dólar", "Real brasileño");
                    break;
                case 4:
                    convertir(scanner, cliente, "BRL", "USD", "Real brasileño", "Dólar");
                    break;
                case 5:
                    convertir(scanner, cliente, "USD", "COP", "Dólar", "Peso colombiano");
                    break;
                case 6:
                    convertir(scanner, cliente, "COP", "USD", "Peso colombiano", "Dólar");
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println(); // Espacio entre iteraciones
        }

        scanner.close();
    }

    private static void convertir(Scanner scanner, ClienteHttp cliente, String base, String destino, String nombreBase, String nombreDestino) {
        System.out.printf("Elegiste: %s =>> %s\n", nombreBase, nombreDestino);
        System.out.printf("Ingrese el monto en %s: ", nombreBase);
        double monto = scanner.nextDouble();

        double tasa = cliente.obtenerTasa(base, destino);
        double resultado = monto * tasa;

        System.out.printf("Equivale a: %.2f %s\n", resultado, nombreDestino);
    }
}
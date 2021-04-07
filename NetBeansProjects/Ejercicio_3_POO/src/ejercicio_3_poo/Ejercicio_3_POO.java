/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_3_poo;
import java.util.*;
public class Ejercicio_3_POO {

    public static void main(String[] args) {
	    LinkedList<CuentaBancaria> cuentas = new LinkedList<CuentaBancaria>();
	    TableConstructor menuBuilder = new TableConstructor();
        do {
            menuPrincipal();
            int input = (Integer) read(" _:", "integer");
            switch (input) {
                case 0:
                    System.out.println("Adiós ;)");
                    System.exit(0);
                case 1:
                    System.out.println("SELECCIONAR TIPO DE CUENTA:");
                    System.out.println("> 1 - Corriente");
                    System.out.println("> 2 - Ahorro");
                    int tipoCuenta = (Integer) read("", "integer");
                    switch (tipoCuenta) {
                        case 1:
                            CuentaCorriente cc = new CuentaCorriente(
                                    (String) read("Propietario: ", "string"),
                                    (String) read("IBAN: ", "string"),
                                    (double) read("Intereses anuales: ", "double")
                            );
                            cuentas.add(cc);
                            break;
                        case 2:
                            CuentaAhorro ca = new CuentaAhorro(
                                    (String) read("Propietario: ", "string"),
                                    (String) read("IBAN: ", "string"),
                                    (double) read("Intereses anuales: ", "double"),
                                    (double) read("Saldo minimo: ", "double")
                            );
                            cuentas.add(ca);
                            break;
                        default:
                            System.out.println("Entrada no conocida");
                    }
                    break;
                case 2:
                    String removeIban = (String) read("IBAN de cuenta a eliminar: ", "string");
                    for (Iterator<CuentaBancaria> it = cuentas.iterator(); it.hasNext(); ) {
                        CuentaBancaria cb = it.next();
                        if (cb.getIban().equals(removeIban))
                            it.remove();
                    }
                    break;
                case 3:
                    String selectIban = (String) read("IBAN: ", "string");
                    selectIban = selectIban.replaceAll(" ", "");
                    for (CuentaBancaria cb : cuentas) {
                        if (cb.getIban().equals(selectIban)) {
                            cuentas = seleccionarCuenta(cuentas, cb);
                            break;
                        }
                    }
                    break;
                case 4:
                    TableConstructor tb = new TableConstructor();
                    tb.setAllSizes(20);
                    tb.printHeader("PROPIETARIO", "IBAN", "TIPO");
                    for (CuentaBancaria cb : cuentas) {
                        cb.show(false);
                    }
                    break;
            }
        } while (true);
    }

    public static LinkedList<CuentaBancaria> seleccionarCuenta(LinkedList<CuentaBancaria> cuentas, CuentaBancaria cb) {
        // GET INDEX OF CuentaBancaria in cuentas.
        int index = 0;
        for (CuentaBancaria x : cuentas) {
            if (!(x.getIban().equals(cb.getIban()))) {
                index += 1;
            } else {
                break;
            }
        }

        int input;
        do {
            menuSecundario(cb.getPropietario(), cb.getIban());
            input = (Integer) read(" _: ", "integer");
            switch (input) {
                case 1:
                    cb.ingresar(
                            (double) read("Cantidad a ingresar: ", "double")
                    );
                    break;
                case 2:
                    cb.retirar(
                            (double) read("Cantidad a retirar: ", "double")
                    );
                    break;
                case 3:
                    cuentas = cb.transferir(
                            cuentas,
                            (String) read("IBAN Destino: ", "string"),
                            (double) read("Cantidad a transferir: ", "double")
                    );
                    break;
                case 4:
                    cb.mostrarDetalles(true);
                    break;
                case 5:
                    cb.setPropietario(
                            (String) read("Nuevo propietario: ", "string")
                    );
                    break;
            }
        } while (!(input==0));

        cuentas.remove(index);
        cuentas.add(index, cb);
        return cuentas;
    }

    public static void menuPrincipal() {
        System.out.println("1 Crear cuenta");
        System.out.println("2 Eliminar cuenta");
        System.out.println("3 Seleccionar cuenta");
        System.out.println("4 Mostrar cuentas");
        System.out.println("0 Salir");
    }

    public static void menuSecundario(String propietario, String iban) {
        System.out.println(propietario.toUpperCase() + " // " + iban.toUpperCase());
        System.out.println("1 Ingresar");
        System.out.println("2 Retirar");
        System.out.println("3 Transferir");
        System.out.println("--------------");
        System.out.println("4 Mostrar cuenta");
        System.out.println("--------------");
        System.out.println("5 Cambiar propietario");
        System.out.println("0 <-- Volver");
    }


    public static Object read(String msg, String type, String... enumeration) {
        boolean hasFilter;
        boolean correctInput;

        try {
            String test = enumeration[0];
            hasFilter = true;
        } catch (Exception ex) {
            hasFilter = false;
        }
        Scanner scan = new Scanner(System.in);
        switch (type) {
            case "string":
                if (!(hasFilter)) {
                    System.out.println(msg);
                    return scan.nextLine();
                } else {
                    do {
                        System.out.println(msg);
                        String entrada = scan.nextLine();
                        for (String element : enumeration) {
                            if (element.equals(entrada)) {
                                return entrada;
                            }
                        }
                    } while (true);
                }
            case "integer":
                
                int num = 0;
                System.out.println(msg);
                do {
                    try {
                        num = scan.nextInt();
                        correctInput = true;
                    } catch (InputMismatchException ex) {
                        correctInput = false;
                    }
                } while (!(correctInput));
                return num;
                
            case "double":
                double d = 0;
                System.out.println(msg);
                do {
                    try {
                        d = scan.nextDouble();
                        correctInput = true;
                    } catch (InputMismatchException ex) {
                        System.out.println("Utilice ',' para indicar céntimos");
                        correctInput = false;
                        scan.nextLine();
                    }
                } while (!(correctInput));
                return d;
                
            case "boolean":

                break;
        }
        return null;
    }
}
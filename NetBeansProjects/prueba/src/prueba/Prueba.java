package prueba;

import java.util.*;

public class Prueba {

    public static void main(String[] args) {
        TableConstructor tc = new TableConstructor();
        LinkedList<Empresa> empresas = new LinkedList<Empresa>();
        
        tc.setAllSizes(40);
        tc.printHeader("BIENVENIDO AL PROGRAMA");
        System.out.println("");
        do {
            System.out.println("Tiene que crear una empresa para poder empezar");
            empresas.add(newEmpresa());
        } while (empresas.size() < 1);
        do{
            startMenu();
            switch(iRead("")){
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Entrada desconocida");
                    break;
                case 1:
                    empresas.add(newEmpresa());
                    break;
                case 2:
                    try {
                        empresas.remove(getEmpresaIndex(empresas));
                        System.out.println("Se eliminó la empresa");
                    } catch (NullPointerException ex) {
                        System.out.println("No se encontró ninguna empresa");
                    }
                    break;
                case 3:
                    tc.setAllSizes(20);
                    tc.printHeader("NOMBRE", "CIF", "TLF", "DIRECCION");
                    for (Iterator<Empresa> it = empresas.iterator(); it.hasNext();) {
                        Empresa e = it.next();
                        e.show(false);
                    }
            }
        } while (true);
    }
    
    public static Integer getEmpresaIndex(LinkedList<Empresa> empresas){
        Scanner scan = new Scanner(System.in);
        Integer index = -1;
        String cif = "";
        
        System.out.println("Introduzca CIF de la empresa a eliminar:");
        System.out.print("> ");
        cif = scan.nextLine();
        
        for (Iterator<Empresa> it = empresas.iterator(); it.hasNext();) {
            Empresa e = it.next();
            if (e.getCif().equals(cif)) {
                return index;
            }
            index += 1;
        }
        
        return index;
    }
    
    public static void startMenu() {
        TableConstructor tc = new TableConstructor();
        tc.setAllSizes(40);
        tc.printHeader("MENU PRINCIPAL");
        tc.printRow(" 1  - Nueva empresa");
        tc.printRow(" 2  - Eliminar empresa");
        tc.printRow(" 3  - Mostrar empresas");
        tc.printRow(" 4  - Seleccionar empresa");
        tc.printRow(" 0  - Salir");
    }
    
    public static Empresa newEmpresa() {
        Empresa e = new Empresa(sRead("Nombre de empresa"),
                                sRead("CIF"));
        return e;
    }
    
    
    public static String sRead(String msg) {
        System.out.println("");
        System.out.print(msg + " > ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    
    public static Integer iRead(String msg) {
        try {
            System.out.print(msg + " > ");
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Entrada no válida");
            return null;
        }
    }
            
            
}

package ejercicio3;

import java.io.*;
import java.util.ArrayList;

/**
 *
 *  Examen Final Java. Clase Clientes
 *  EJERCICIO 3
 *  @author Cedric Christoph
 *
 */
public class Clientes {
    
    private static final File fichero = new File("clientes.txt");
    
    private ArrayList<Cliente> lista;
    
    public Clientes () 
    {
        lista = new ArrayList<Cliente>();
    }

    public void loadData() throws FileNotFoundException, IOException 
    {
        System.out.println("Cargando...");
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] splitted = linea.split(";");
            Cliente cliente = new Cliente();
            cliente.setNIF(splitted[0]);
            cliente.setNombre(splitted[1]);
            cliente.setTlf(splitted[2]);
            cliente.setDireccion(splitted[3]);
            cliente.setDeuda(Double.parseDouble(splitted[4]));
            lista.add(cliente);
        }
        br.close();
    }
    
    public void saveData() throws IOException 
    {
        System.out.println("Guardando...");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        for (Cliente cliente : lista) {
            String linea =  cliente.getNIF() + ";" +
                            cliente.getNombre() + ";" +
                            cliente.getTlf() + ";" +
                            cliente.getDireccion() + ";" +
                            cliente.getDeuda() + "\n";
            bw.write(linea);
        }
        bw.close();
    }
    
    public ArrayList<Cliente> getLista() 
    {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) 
    {
        this.lista = lista;
    }
    
    public Cliente buscar (String NIF) 
    {
        for (Cliente c : lista) {
            if (c.getNIF().equals(NIF))
                return c;
        }
        return null;
    }
    
    public boolean eliminar (String NIF) {
        return lista.remove(buscar(NIF));
    }
    
    public boolean eliminarFichero() {
        return fichero.delete();
    }
}

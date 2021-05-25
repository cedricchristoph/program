/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Cedric Christoph
 * @since 1.0
 * @version 1.0
 * 
 */

/**
 * 
 * Probabilidades de dar a una mina al azar en las distintas dificultades.
 * n = el número de minas en un mapa.
 * N = el número de células en un mapa.
 * p = (n/N) densidad de minas en un mapa (probabilidad de golpear una mina)
 * 
 * +--------------+------+------+-------+
 * |  DIFICULTAD  |  n   |   N  |   p   |
 * +--------------+------+------+-------+
 * | Principiante |  10  |  64  | 0.156 |
 * | Intermedio   |  40  |  256 | 0.156 |
 * | Experto      |  100 |  484 | 0.206 |
 * |--------------|------|------|-------|
 * 
 */
public class Juego {
    
    /**
     * 
     * Constantes de dificultad
     * 
     */
    public static final int PRINCIPIANTE = 0;
    public static final int INTERMEDIO = 1;
    public static final int EXPERTO = 2;
    
    /**
     * 
     * Constantes de probabilidad de minas
     * 
     */
    private static final float PROBABILIDAD_NORMAL = 15.6f;
    private static final float PROBABILIDAD_ALTA = 20.6f;
    
    /**
     * 
     * El mapa del juego
     * 
     */
    Celda[][] mapa;
    
    /**
     * 
     * Dificultad del juego
     * 
     */
    int dificultad;
    
    boolean hasFinished;
    
    /**
     * 
     * Constructor para cada partida.
     * @param dificultad Indica la dificultad de la partida.
     * 
     */
    public Juego(int dificultad) 
    {
        this.dificultad = dificultad;
        switch (dificultad) 
        {
            case PRINCIPIANTE:
                mapa = new Celda[8][8];
                break;
            case INTERMEDIO:
                mapa = new Celda[16][16];
                break;
            case EXPERTO:
                mapa = new Celda[22][22];
                break;
        }
    }
    
    /**
     * 
     * Método para iniciar el mapa. 
     * Este método se encarga de crear las minas y las casillas
     * 
     */
    public void init() 
    {
        float prob;
        if ((dificultad == PRINCIPIANTE) || (dificultad == INTERMEDIO)) 
            prob = PROBABILIDAD_NORMAL;
        else 
            prob = PROBABILIDAD_ALTA;
        
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if (getRandomBoolean(prob))
                    mapa[i][j] = new Mina();
                else
                    mapa[i][j] = new Casilla();
            }
        }
    }
    
    /**
     * 
     * Función para cambiar el estado de una celda a seleccionado.
     * 
     * @param x Posicion X a seleccionar
     * @param y Posicion Y a seleccionar
     *
     */
    public void select(int x, int y) 
    {
        mapa[x][y].select();
        hasFinished = mapa[x][y].esMina();
    }
    
    /**
     * 
     * Función que averigua la cantidad de minas que rodean a una celda en concreta.
     * 
     * @param x Posición X de la celda
     * @param y Posición Y de la celdaosición X de la celd
     * @return Integer Cantidad de minas alrededor
     * 
     */
    public int getMinasAlrededor(int x, int y) 
    {
        //System.out.println("X: " + x + " Y: " + y);
        int i = x - 1;
        int j = y - 1;
        int minas = 0;
        for (int a = i; a < (i+3); a++) {
            try {
                for (int b = j; b < (j+3); b++) {
                    //System.out.println(a + " " + b);
                    try {
                        if (mapa[a][b].esMina()){
                            if ((!(a==x) && !(b==y))) {
                                System.out.println(a + " " + b);
                                minas++;
                            }
                        }
                    } catch (Exception ex) {
                        if (a < 0)
                            throw new Exception("A es negativo");
                    }
                }
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        }
        return minas;
    }
    
    /**
     * 
     * Método para mostrar el mapa al jugador.
     * Se muestran los campos ya seleccionados con su debida cantidad de minas
     * que lo rodean.
     * 
     */
    public void show() 
    {
        System.out.print("       ");
        for (int i = 0; i < mapa.length; i++) {
            System.out.print(i + "   ");
        }
        System.out.print("\n\n");
        int x = 0;
        int y = 0;
        for (Celda[] fila : mapa) {
            y = 0;
            System.out.print(x + "    | ");
            for (Celda celda : fila) {
                if (celda.esMina() && celda.isSelected())
                    System.out.print("X | ");
                else if (celda.isSelected() && !(celda.esMina()))
                    System.out.print(getMinasAlrededor(x, y) + " | ");
                else
                    System.out.print("  | ");
                y++;
            }
            System.out.print("\n");
            x++;
        }
    }
    
    
    /**
     * 
     * Método primitivo para mostrar el mapa.
     * Su uso es exclusivo para el desarrollo y no para el juego real.
     * 
     */
    public void showDevMap() 
    {
        System.out.print("       ");
        for (int i = 0; i < mapa.length; i++) {
            System.out.print(i + "   ");
        }
        System.out.print("\n\n");
        int count = 0;
        for (Celda[] fila : mapa) {
            System.out.print(count + "    | ");
            for (Celda celda : fila) {
                if (celda.esMina())
                    System.out.print("X | ");
                else
                    System.out.print("  | ");
            }
            System.out.print("\n");
            count++;
        }
    }
    
    /**
     * Método que devuelve un true con cierta probabilidad.
     * @param probability
     * @return Boolean True o False dependiendo de la probabilidad
     */
    static boolean getRandomBoolean(float probability) 
    {
        double randomValue = Math.random()*100;  //0.0 to 99.9
        return randomValue <= probability;
    }
}

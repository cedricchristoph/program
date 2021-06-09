package tictactoe;

import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;
import javax.swing.*;

public class TicTacToe extends JFrame implements ItemListener, ActionListener {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("tictactoe/Bundle");

    /**
     * @return the yesnull
     */
    public int getYesnull() {
        return yesnull;
    }

    /**
     * @param yesnull the yesnull to set
     */
    public void setYesnull(int yesnull) {
        this.yesnull = yesnull;
    }

    /**
     * @return the a
     */
    public int[][] getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int[][] a) {
        this.a = a;
    }

    /**
     * @return the a1
     */
    public int[][] getA1() {
        return a1;
    }

    /**
     * @param a1 the a1 to set
     */
    public void setA1(int[][] a1) {
        this.a1 = a1;
    }

    /**
     * @return the state
     */
    public boolean isState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * @return the type
     */
    public boolean isType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * @return the set
     */
    public boolean isSet() {
        return set;
    }

    /**
     * @param set the set to set
     */
    public void setSet(boolean set) {
        this.set = set;
    }

    /**
     * @return the ic1
     */
    public Icon getIc1() {
        return ic1;
    }

    /**
     * @param ic1 the ic1 to set
     */
    public void setIc1(Icon ic1) {
        this.ic1 = ic1;
    }

    /**
     * @return the ic2
     */
    public Icon getIc2() {
        return ic2;
    }

    /**
     * @param ic2 the ic2 to set
     */
    public void setIc2(Icon ic2) {
        this.ic2 = ic2;
    }

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the ic11
     */
    public Icon getIc11() {
        return ic11;
    }

    /**
     * @param ic11 the ic11 to set
     */
    public void setIc11(Icon ic11) {
        this.ic11 = ic11;
    }

    /**
     * @return the ic22
     */
    public Icon getIc22() {
        return ic22;
    }

    /**
     * @param ic22 the ic22 to set
     */
    public void setIc22(Icon ic22) {
        this.ic22 = ic22;
    }

    /**
     * @return the chkBox1
     */
    public Checkbox getChkBox1() {
        return chkBox1;
    }

    /**
     * @param chkBox1 the chkBox1 to set
     */
    public void setChkBox1(Checkbox chkBox1) {
        this.chkBox1 = chkBox1;
    }

    /**
     * @return the chkBox2
     */
    public Checkbox getChkBox2() {
        return chkBox2;
    }

    /**
     * @param chkBox2 the chkBox2 to set
     */
    public void setChkBox2(Checkbox chkBox2) {
        this.chkBox2 = chkBox2;
    }

    /**
     * @return the b
     */
    public JButton[] getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(JButton[] b) {
        this.b = b;
    }

    /**
     * @return the reset
     */
    public JButton getReset() {
        return reset;
    }

    /**
     * @param reset the reset to set
     */
    public void setReset(JButton reset) {
        this.reset = reset;
    }

    /**
     * Método main del programa
     *
     * @param args Argumentos de consola
     */
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.init();
    }

    private int yesnull;
    private int a[][] = {{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11}, {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11},
    {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};
    private int a1[][] = {{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11}, {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11},
    {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};

    private boolean state;
    private boolean type;
    private boolean set;
    private Icon ic1;
    private Icon ic2;
    private Icon icon;
    private Icon ic11;
    private Icon ic22;
    private Checkbox chkBox1;
    private Checkbox chkBox2;
    private JButton[] b = new JButton[9];
    private JButton reset;

    /**
     *
     * Constructor de TicTacToe.
     *
     */
    public TicTacToe() {
        super(bundle.getString("TIC TAC TOE BY ASHWANI"));
        CheckboxGroup cbg = new CheckboxGroup();
        chkBox1 = new Checkbox(bundle.getString("VS COMPUTER"), cbg, false);
        chkBox2 = new Checkbox(bundle.getString("VS FRIEND"), cbg, false);
        chkBox1.setBounds(120, 80, 100, 40);
        chkBox2.setBounds(120, 150, 100, 40);
        state = true;
        type = true;
        set = true;
        ic1 = new ImageIcon(bundle.getString("IC1.JPG"));
        ic2 = new ImageIcon(bundle.getString("IC2.JPG"));
        ic11 = new ImageIcon(bundle.getString("IC11.JPG"));
        ic22 = new ImageIcon(bundle.getString("IC22.JPG"));
    }

    /**
     *
     * Método para inicializar la ventana y sus componentes
     *
     */
    public void init() {
        add(chkBox1);
        add(chkBox2);
        chkBox1.addItemListener(this);
        chkBox2.addItemListener(this);
        setLayout(null);
        setSize(330, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     *
     * Método para mostrar el botón reset.
     *
     */
    public void showResetButton() {
        int x = 10;
        int y = 10;
        int j = 0;
        for (int i = 0; i <= 8; i++, x += 100, j++) {
            b[i] = new JButton();
            if (j == 3) {
                j = 0;
                y += 100;
                x = 10;
            }
            b[i].setBounds(x, y, 100, 100);
            add(b[i]);
            b[i].addActionListener(this);
        }

        reset = new JButton(bundle.getString("RESET"));
        reset.setBounds(100, 350, 100, 50);
        add(reset);
        reset.addActionListener(this);
    }

    /**
     *
     * Método para checkear
     *
     * @param num1 Integer num1
     *
     */
    public void check(int num1) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 1; j <= 3; j++) {
                if (a[i][j] == num1) {
                    a[i][4] = 11;
                }
            }
        }
    }

    /**
     * ?!
     *
     * @param num Integer num
     */
    public void complogic(int num) {
        try {
            for (int i = 0; i <= 7; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (a[i][j] == num) {
                        a[i][0] = 11;
                        a[i][4] = 10;
                    }
                }
            }
            for (int i = 0; i <= 7; i++) {
                set = true;
                if (a[i][4] == 10) {
                    int count = 0;
                    for (int j = 1; j <= 3; j++) {
                        if (b[(a[i][j] - 1)].getIcon() != null) {
                            count++;
                        } //eof if 2
                        else {
                            yesnull = a[i][j];
                        }
                    }
                    if (count == 2) {
                        b[yesnull - 1].setIcon(ic2);
                        this.check(yesnull);
                        set = false;
                        break;
                    }
                } else if (a[i][0] == 10) {
                    for (int j = 1; j <= 3; j++) {
                        if (b[(a[i][j] - 1)].getIcon() == null) {
                            b[(a[i][j] - 1)].setIcon(ic2);
                            this.check(a[i][j]);
                            set = false;
                            break;
                        }
                    }
                    if (set == false) {
                        break;
                    }
                }

                if (set == false) {
                    break;
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     *
     * Método que reacciona cuando el estado de un item ha cambiado.
     *
     * @param e Evento
     *
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (chkBox1.getState()) {
            type = false;
        } else if (chkBox2.getState()) {
            type = true;
        }
        remove(chkBox1);
        remove(chkBox2);
        repaint(0, 0, 330, 450);
        showResetButton();
    }

    /**
     *
     * Método que se encarga de escuchar los eventos en la ventana. Se encarga
     * de ejecutar los eventos.
     *
     * @param e Evento
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (type == true) {
            if (e.getSource() == reset) {
                for (int i = 0; i <= 8; i++) {
                    b[i].setIcon(null);
                }
            } else {
                for (int i = 0; i <= 8; i++) {
                    if (e.getSource() == b[i]) {
                        if (b[i].getIcon() == null) {
                            if (state == true) {
                                icon = ic2;
                                state = false;
                            } else {
                                icon = ic1;
                                state = true;
                            }
                            b[i].setIcon(icon);
                        }
                    }
                }
            }
        } else {
            if (e.getSource() == reset) {
                for (int i = 0; i <= 8; i++) {
                    b[i].setIcon(null);
                }//eof for 
                for (int i = 0; i <= 7; i++) {
                    for (int j = 0; j <= 4; j++) {
                        a[i][j] = a1[i][j];   //again initialsing array
                    }
                }
            } else {
                for (int i = 0; i <= 8; i++) {
                    if (e.getSource() == b[i]) {
                        if (b[i].getIcon() == null) {
                            b[i].setIcon(ic1);
                            if (b[4].getIcon() == null) {
                                b[4].setIcon(ic2);
                                this.check(5);
                            } else {
                                this.complogic(i);
                            }
                        }
                    }
                }
            }
        }

        checkVictory();

    }

    /**
     *
     * Método que averigua si algún jugador ha ganado la partida. En el caso de
     * que alguien haya ganado se mostrará el mensaje.
     *
     */
    public void checkVictory() {
        try {
            for (int i = 0; i <= 7; i++) {
                Icon icon1 = b[(a[i][1] - 1)].getIcon();
                Icon icon2 = b[(a[i][2] - 1)].getIcon();
                Icon icon3 = b[(a[i][3] - 1)].getIcon();
                if ((icon1 == icon2) && (icon2 == icon3) && (icon1 != null)) {
                    if (icon1 == ic1) {
                        b[(a[i][1] - 1)].setIcon(ic11);
                        b[(a[i][2] - 1)].setIcon(ic11);
                        b[(a[i][3] - 1)].setIcon(ic11);
                        JOptionPane.showMessageDialog(TicTacToe.this, bundle.getString("!!!YOU WON!!! CLICK RESET"));
                        break;
                    } else if (icon1 == ic2) {
                        b[(a[i][1] - 1)].setIcon(ic22);
                        b[(a[i][2] - 1)].setIcon(ic22);
                        b[(a[i][3] - 1)].setIcon(ic22);
                        JOptionPane.showMessageDialog(TicTacToe.this, bundle.getString("!!!AWK (COMPUTER) WON!!! CLICK RESET"));
                        break;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

}

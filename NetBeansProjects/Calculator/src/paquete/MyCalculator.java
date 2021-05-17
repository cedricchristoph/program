package paquete;

import java.awt.*;
import java.awt.event.*;

/**
 * Main calculator window
 * @author Inf2
 */
public class MyCalculator extends Frame {

    
    public boolean setClear = true;
    double number, memValue;
    char op;

    String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
    String operatorButtonText[] = {"/", "sqrt", "*", "mod", "-", "1/X", "+", "="};
    String memoryButtonText[] = {"MC", "MR", "MS", "M+"};
    String specialButtonText[] = {"Backspc", "C", "CE"};

    MyDigitButton digitButton[] = new MyDigitButton[digitButtonText.length];
    MyOperatorButton operatorButton[] = new MyOperatorButton[operatorButtonText.length];
    MyMemoryButton memoryButton[] = new MyMemoryButton[memoryButtonText.length];
    MySpecialButton specialButton[] = new MySpecialButton[specialButtonText.length];

    Label displayLabel = new Label("0", Label.RIGHT);
    Label memLabel = new Label(" ", Label.RIGHT);

    final int FRAME_WIDTH = 410, FRAME_HEIGHT = 310;
    final int HEIGHT = 30, WIDTH = 50, H_SPACE = 5, V_SPACE = 5;
    final int TOPX = 30, TOPY = 50;

    /**
     * Constructor
     * @param frameText 
     */
    public MyCalculator(String frameText)
    {
        super(frameText);

        int tempX = TOPX, y = TOPY;
        displayLabel.setBounds(tempX, y, FRAME_WIDTH - 75, HEIGHT);
        displayLabel.setBackground(Color.BLUE);
        displayLabel.setForeground(Color.WHITE);
        add(displayLabel);

        memLabel.setBounds(TOPX, TOPY + HEIGHT + V_SPACE, WIDTH, HEIGHT);
        add(memLabel);

        /**
         * Set coordinates for memory buttons
         */
        tempX = TOPX;
        y = TOPY + 2 * (HEIGHT + V_SPACE);
        for (int i = 0; i < memoryButton.length; i++) {
            memoryButton[i] = new MyMemoryButton(tempX, y, WIDTH, HEIGHT, memoryButtonText[i], this);
            memoryButton[i].setForeground(Color.RED);
            y += HEIGHT + V_SPACE;
        }

        /**
         * Set coordinates for special buttons
         */
        tempX = TOPX + 1 * (WIDTH + H_SPACE);
        y = TOPY + 1 * (HEIGHT + V_SPACE);
        for (int i = 0; i < specialButton.length; i++) {
            specialButton[i] = new MySpecialButton(tempX, y, (int) (WIDTH * 1.5), HEIGHT, specialButtonText[i], this);
            specialButton[i].setForeground(Color.RED);
            tempX = tempX + 2 * WIDTH + H_SPACE;
        }

        /**
         * Set coordinates for digit button
         */
        int digitX = TOPX + WIDTH + H_SPACE;
        int digitY = TOPY + 2 * (HEIGHT + V_SPACE);
        tempX = digitX;
        y = digitY;
        for (int i = 0; i < digitButton.length; i++) {
            digitButton[i] = new MyDigitButton(tempX, y, WIDTH, HEIGHT, digitButtonText[i], this);
            digitButton[i].setForeground(Color.BLUE);
            tempX += WIDTH + H_SPACE;
            if ((i + 1) % 3 == 0) {
                tempX = digitX;
                y += HEIGHT + V_SPACE;
            }
        }

        /**
         * Set coordinates for operator buttons
         */
        int opsX = digitX + 2 * (WIDTH + H_SPACE) + H_SPACE;
        int opsY = digitY;
        tempX = opsX;
        y = opsY;
        for (int i = 0; i < operatorButton.length; i++) {
            tempX += WIDTH + H_SPACE;
            operatorButton[i] = new MyOperatorButton(tempX, y, WIDTH, HEIGHT, operatorButtonText[i], this);
            operatorButton[i].setForeground(Color.RED);
            if ((i + 1) % 2 == 0) {
                tempX = opsX;
                y += HEIGHT + V_SPACE;
            }
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }
    
    /**
     * Function thtat returns formatted text
     * @param temp
     * @return String formatted text
     */
    public static String getFormattedText(double temp) {
        String resText = "" + temp;
        if (resText.lastIndexOf(".0") > 0) {
            resText = resText.substring(0, resText.length() - 2);
        }
        return resText;
    }

    /**
     * Main method
     * @param args 
     */
    public static void main(String[] args) {
        new MyCalculator("Calculator - JavaTpoint");
    }
}
/*********************************************

Features not implemented and few bugs

i)  No coding done for "+/-" button.
ii) Menubar is not included.
iii)Not for Scientific calculation
iv)Some of the computation may lead to unexpected result
   due to the representation of Floating point numbers in computer
   is an approximation to the given value that can be stored
   physically in memory.

***********************************************/

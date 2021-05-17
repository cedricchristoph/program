/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * *****************************************
 */
class MyOperatorButton extends Button implements ActionListener {

    MyCalculator cl;

    MyOperatorButton(int x, int y, int width, int height, String cap, MyCalculator clc) {
        super(cap);
        setBounds(x, y, width, height);
        this.cl = clc;
        this.cl.add(this);
        addActionListener(this);
    }
///////////////////////

    public void actionPerformed(ActionEvent ev) {
        String opText = ((MyOperatorButton) ev.getSource()).getLabel();

        cl.setClear = true;
        double temp = Double.parseDouble(cl.displayLabel.getText());

        if (opText.equals("1/X")) {
            try {
                double tempd = 1 / (double) temp;
                cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
            } catch (ArithmeticException excp) {
                cl.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if (opText.equals("sqrt")) {
            try {
                double tempd = Math.sqrt(temp);
                cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
            } catch (ArithmeticException excp) {
                cl.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if (!opText.equals("=")) {
            cl.number = temp;
            cl.op = opText.charAt(0);
            return;
        }
        if (!opText.equals("mod")) {
            try {
                temp = cl.number % temp;
            } catch (ArithmeticException excp) {
                cl.displayLabel.setText("Divide by 0.");
                return;
            }
        }
// process = button pressed
        switch (cl.op) {
            case '+':
                temp += cl.number;
                break;
            case '-':
                temp = cl.number - temp;
                break;
            case '*':
                temp *= cl.number;
                break;
            case '/':
                try {
                    temp = cl.number / temp;
                } catch (ArithmeticException excp) {
                    cl.displayLabel.setText("Divide by 0.");
                    return;
                }
                break;
        }//switch

        cl.displayLabel.setText(MyCalculator.getFormattedText(temp));
//cl.number=temp;
    }//actionPerformed
}//class

package lesson7a;

import com.sun.deploy.net.protocol.http.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame {

    JFrame frame;
    JPanel window;
    JTextField textField;
    JButton btn0;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btn9;
    JButton btnPlus;
    JButton btnMinus;
    JButton btnDiv;
    JButton btnMultiply;
    JButton btnPoint;
    JButton btnEql;


    PressedButtonHandler handler = new PressedButtonHandler();

    Panel() {
        window = new JPanel();
        window.setBackground(Color.LIGHT_GRAY);
        window.setLayout(null);

        textField = new JTextField(15);
        window.add(textField);
        textField.setBounds(10, 10, 295, 35);
        textField.setEditable(false);

        JButton btnC = new JButton("C");
        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnBack = new JButton("<=");
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnMultiply = new JButton("x");
        JButton btnDiv = new JButton("/");
        JButton btnPoint = new JButton(".");
        JButton btnEql = new JButton("=");

        window.add(btnC);
        window.add(btn0);
        window.add(btn1);
        window.add(btn2);
        window.add(btn3);
        window.add(btn4);
        window.add(btn5);
        window.add(btn6);
        window.add(btn7);
        window.add(btn8);
        window.add(btn9);
        window.add(btnPlus);
        window.add(btnMinus);
        window.add(btnMultiply);
        window.add(btnDiv);
        window.add(btnEql);
        window.add(btnPoint);
        window.add(btnBack);


        btn7.setBounds(10, 55, 55, 35);
        btn8.setBounds(70, 55, 55, 35);
        btn9.setBounds(130, 55, 55, 35);
        btnDiv.setBounds(190, 55, 55, 35);
        btnC.setBounds(250, 55, 55, 35);
        btnC.setBackground(Color.ORANGE);

        btn4.setBounds(10, 95, 55, 35);
        btn5.setBounds(70, 95, 55, 35);
        btn6.setBounds(130, 95, 55, 35);
        btnMultiply.setBounds(190, 95, 55, 35);
        btnMinus.setBounds(250, 95, 55, 35);

        btn1.setBounds(10, 135, 55, 35);
        btn2.setBounds(70, 135, 55, 35);
        btn3.setBounds(130, 135, 55, 35);
        btnPlus.setBounds(190, 135, 55, 75);
        btnEql.setBounds(250, 135, 55, 75);

        btn0.setBounds(10, 175, 55, 35);
        btnPoint.setBounds(70, 175, 55, 35);
        btnBack.setBounds(130, 175, 55, 35);

        frame = new JFrame("Calculator");
        frame.setContentPane(window);
        frame.setSize(330, 260);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        btnC.addActionListener(handler);
        btn1.addActionListener(handler);
        btn2.addActionListener(handler);
        btn3.addActionListener(handler);
        btn4.addActionListener(handler);
        btn5.addActionListener(handler);
        btn6.addActionListener(handler);
        btn7.addActionListener(handler);
        btn8.addActionListener(handler);
        btn9.addActionListener(handler);
        btn0.addActionListener(handler);
        btnPlus.addActionListener(handler);
        btnMinus.addActionListener(handler);
        btnDiv.addActionListener(handler);
        btnMultiply.addActionListener(handler);
        btnBack.addActionListener(handler);
        btnPoint.addActionListener(handler);
        btnEql.addActionListener(handler);

    }

    private class PressedButtonHandler implements ActionListener {
        String textFromDisplay;
        String enteredText = "";
        char selectedAction;
        double result, var1, var2;

        public void actionPerformed(ActionEvent e) {

            revalidate();
            repaint();

           /* if (e.getSource() instanceof JButton && e.getSource() != btnDiv &&
                e.getSource() != btnEql && e.getSource() != btnMinus
                && e.getSource() != btnMultiply && e.getSource() != btnPlus) {

                textFromDisplay = ((JButton) e.getSource()).getText();
                textField.setText(textField.getText() + textFromDisplay);*//*

            }*/
            if (e.getSource().equals("1")) {
                /*extFromDisplay = ((JButton)e.getSource()).getText();*/
                textField.setText(textField.getText() + "1");
            }
            if (e.getSource() == btn2) {
                /*textFromDisplay = textField.getText();*/
                textField.setText(textField.getText() + "2");
            }

            if (e.getSource() == btnPlus) {
                enteredText = textField.getText();
                textField.setText(null);
                selectedAction = '+';

            }

            if (e.getSource() == btnMinus) {
                enteredText = textField.getText();
                textField.setText(null);
                selectedAction = '-';
            }
            if (e.getSource() == btnMultiply) {
                enteredText = textField.getText();
                textField.setText(null);
                selectedAction = '*';
            }
            if (e.getSource() == btnDiv) {
                enteredText = textField.getText();
                textField.setText(null);
                selectedAction = '/';
            }
            if (e.getSource() == btnEql) {
                var1 = Double.parseDouble(enteredText);
                var2 = Double.parseDouble(textField.getText());
                switch (selectedAction) {
                    case '+':
                        result = var1 + var2;
                        textField.setText(result + "");
                        break;
                    case '-':
                        result = var1 - var2;
                        textField.setText(result + "");
                        break;
                    case '*':
                        result = var1 * var2;
                        textField.setText(result + "");
                        break;
                    case '/':
                        result = var1 / var2;
                        textField.setText(result + "");
                        break;
                }

            }
            }
        }
    }









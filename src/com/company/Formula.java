package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Formula extends JFrame {
    private Double result = 0.0;
    private Double sum = 0.0;
    private int formula = 0;
    private JButton button1 = new JButton("Result");
    private JButton button2 = new JButton("Clean");
    private JButton button3 = new JButton("M+");
    private JButton button4 = new JButton("MC");
    private JTextField textFieldX = new JTextField("0", 5);
    private JTextField textFieldY = new JTextField("0", 5);
    private JTextField textFieldZ = new JTextField("0", 5);
    private JTextField textFieldResult = new JTextField("0", 20);
    private JLabel labelX = new JLabel("X:");
    private JLabel labelY = new JLabel("Y:");
    private JLabel labelZ = new JLabel("Z:");
    private JLabel labelResult = new JLabel("Result:");
    private JRadioButton radio1 = new JRadioButton("Formula 1");
    private JRadioButton radio2 = new JRadioButton("Formula 2");

    public double calculate1(Double x, Double y, Double z) {
        return ((Math.sin(y) + (y * y) + Math.exp(Math.cos(y))) * (Math.pow((Math.log(z) + (Math.sin(Math.PI) * Math.pow(x, 2))), 0.25)));
    }
    public double calculate2(Double x, Double y, Double z) {
        return ((Math.tan(Math.pow(x, 2)) + Math.pow(y, 0.5)) / (z * Math.log(x + y)));
    }

    public Formula() {
        super("Formula calculation");
        this.setBounds(760, 480, 300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        JPanel panel1 = new JPanel();
        panel1.add(radio1);
        radio1.setSelected(true);
        panel1.add(radio2);
        radio1.addActionListener(new ButtonEventListener ());
        radio2.addActionListener(new ButtonEventListener ());
        container.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.add(labelX);
        panel2.add(textFieldX);
        panel2.add(labelY);
        panel2.add(textFieldY);
        panel2.add(labelZ);
        panel2.add(textFieldZ);
        container.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.add(labelResult);
        panel3.add(textFieldResult);
        container.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.add(button1);
        panel4.add(button2);
        container.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.add(button3);
        panel5.add(button4);
        container.add(panel5);
        button1.addActionListener(new ButtonEventListener ());
        button2.addActionListener(new ButtonEventListener ());
        button3.addActionListener(new ButtonEventListener ());
        button4.addActionListener(new ButtonEventListener ());
    }

    public class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == radio1)
                    formula = 1;
                else if (e.getSource() == radio2)
                    formula = 0;
                else if (e.getSource() == button1) {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    if (formula == 1)
                        result = calculate1(x, y, z);
                    else if (formula == 0)
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                }

                else  if (e.getSource() == button2) {
                    textFieldX.setText("0");
                    textFieldY.setText("0");
                    textFieldZ.setText("0");
                    textFieldResult.setText("0");
                }

                else if(e.getSource() == button3) {
                    result = Double.parseDouble(textFieldResult.getText());
                    sum += result;
                    textFieldResult.setText(sum.toString());
                }

                else if(e.getSource() == button4) {
                    textFieldResult.setText("0");
                    result = Double.parseDouble(textFieldResult.getText());
                    sum = 0.0;
                    textFieldResult.setText(sum.toString());
                }

            }catch (NumberFormatException exception ) {
                JOptionPane.showMessageDialog(Formula.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
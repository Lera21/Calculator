package ru.geekbrains.prev;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateFrame extends JFrame {
  public CalculateFrame(){
    setTitle("Calculator");
    setBounds(50,50,300,400);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());

    JPanel top = new JPanel();
    top.setLayout(new BorderLayout());
    JTextField inputField = new JTextField();
    inputField.setEditable(false);
    top.add(inputField, BorderLayout.CENTER);



    JPanel bottom = new JPanel();
    bottom.setLayout(new GridLayout(5,3));
    add(top, BorderLayout.NORTH);
    add(bottom, BorderLayout.CENTER);


DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);

    for (int i = 0; i < 10; i++){
      JButton button = new JButton(String.valueOf(i));
      button.addActionListener(digitButtonListener);
      bottom.add(button);

    }
    JButton add = new JButton("+");
   add.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       JButton button = (JButton) e.getSource();

       StringBuilder sb = new StringBuilder(inputField.getText());
       sb.append(button.getText());

       inputField.setText(sb.toString());
     }
   });
    bottom.add(add);

    JButton minus = new JButton("-");
   /* add.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        StringBuilder mb = new StringBuilder(inputField.getText());
        mb.append(button.getText());
        inputField.setText(mb.toString());
                            }
                         });*/
    bottom.add(minus);

    JButton sqrt = new JButton("SQRT");
    bottom.add(sqrt);

    JButton clear = new JButton("C");
    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
      }
    });
    bottom.add(clear);

    JButton calc = new JButton("=");
    calc.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] values = inputField.getText().split("\\+");
        int sum = Integer.parseInt(values[0] + Integer.parseInt(values[1]));
        inputField.setText(String.valueOf(sum));
      }
    });
    calc.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        String[] values1 = inputField.getText().split("\\-");
        int minus = Integer.parseInt(values1[0] + Integer.parseInt(values1[1]));
        inputField.setText(String.valueOf(minus));

      }
    });
    bottom.add(calc);


    setVisible(true);
  }
}

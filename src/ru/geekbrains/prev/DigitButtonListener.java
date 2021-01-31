package ru.geekbrains.prev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {

  private JTextField textField;
  public DigitButtonListener(JTextField textField){
    this.textField = textField;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();

    StringBuilder sb = new StringBuilder(textField.getText());
    sb.append((button.getText()));

    textField.setText(sb.toString());
  }
}

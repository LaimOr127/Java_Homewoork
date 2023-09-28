package Homework.Pr15;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EmployeeView {
    private JFrame frame;
    private JLabel nameLabel;
    private JTextField nameTextField; // Добавлено поле для имени
    private JLabel hourlyRateLabel;
    private JTextField hourlyRateTextField;
    private JLabel hoursWorkedLabel;
    private JTextField hoursWorkedTextField;
    private JLabel salaryLabel;
    private JButton calculateButton;

    public EmployeeView() {
        frame = new JFrame("Заработная плата сотрудника");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        nameLabel = new JLabel("Имя: ");
        panel.add(nameLabel);

        nameTextField = new JTextField(10);
        panel.add(nameTextField);

        hourlyRateLabel = new JLabel("Почасовая ставка: ");
        panel.add(hourlyRateLabel);

        hourlyRateTextField = new JTextField(5);
        panel.add(hourlyRateTextField);

        hoursWorkedLabel = new JLabel("Отработанные часы: ");
        panel.add(hoursWorkedLabel);

        hoursWorkedTextField = new JTextField(5);
        panel.add(hoursWorkedTextField);

        calculateButton = new JButton("Рассчитать");
        panel.add(calculateButton);

        salaryLabel = new JLabel("");
        panel.add(salaryLabel);

        frame.setVisible(true);
    }

    public String getNameInput() {
        return nameTextField.getText();
    }

    public double getHourlyRateInput() {
        return Double.parseDouble(hourlyRateTextField.getText());
    }

    public int getHoursWorkedInput() {
        return Integer.parseInt(hoursWorkedTextField.getText());
    }

    public void setSalaryOutput(double salary) {
        salaryLabel.setText("Заработная плата: " + salary);
    }

    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }
}

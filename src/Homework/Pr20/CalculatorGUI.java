package Pr20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalculatorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();
            CalculatorView view = new CalculatorView();
            CalculatorController controller = new CalculatorController(model, view);
            controller.initController();

            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.getContentPane().setBackground(new Color(90, 0, 90));
            frame.add(view);

            frame.setVisible(true);
        });
    }
}

class CalculatorModel {
    private String expression = "";

    public void appendExpression(String input) {
        expression += input;
    }

    public void clearExpression() {
        expression = "";
    }

    public String getExpression() {
        return expression;
    }

    public double evaluateExpression() {
        try {
            return calculateRPN(expression);
        } catch (Exception ex) {
            return Double.NaN;
        }
    }

    private double calculateRPN(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("+")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a / b);
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class CalculatorView extends JPanel {
    private JTextField inputField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C" // Добавляем кнопку для очистки строки
    };

    public CalculatorView() {
        setLayout(new BorderLayout());
        setBackground(new Color(90, 0, 90));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); // Увеличиваем количество строк для добавления кнопки C
        buttonPanel.setBackground(new Color(90, 0, 90));
        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttons[i].setBackground(new Color(150, 0, 150));
            buttons[i].setForeground(Color.WHITE);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void setInputFieldText(String text) {
        inputField.setText(text);
    }

    public String getInputFieldText() {
        return inputField.getText();
    }

    public void addButtonClickListener(ActionListener listener, int index) {
        buttons[index].addActionListener(listener);
    }

    public String[] getButtonLabels() {
        return buttonLabels;
    }
}

class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        String[] buttonLabels = view.getButtonLabels();
        for (int i = 0; i < buttonLabels.length; i++) {
            view.addButtonClickListener(new ButtonClickListener(), i);
        }
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();
            if (command.equals("=")) {
                String expression = view.getInputFieldText();
                model.appendExpression(expression);
                double result = model.evaluateExpression();
                view.setInputFieldText(Double.toString(result));
                model.clearExpression();
            } else if (command.equals("C")) { // Обрабатываем очистку строки
                view.setInputFieldText("");
                model.clearExpression();
            } else {
                view.setInputFieldText(view.getInputFieldText() + " " + command);
            }
        }
    }
}

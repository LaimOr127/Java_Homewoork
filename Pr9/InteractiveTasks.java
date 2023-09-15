package Pr9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class InteractiveTasks {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Выбор задачи");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel label = new JLabel("Выберите задачу для выполнения:");
        panel.add(label);

        String[] taskOptions = {
                "Треугольная последовательность",
                "От 1 до n",
                "От A до B",
                "Заданная сумма цифр",
                "Сумма цифр числа",
                "Проверка числа на простоту",
                "Разложение на множители",
                "Палиндром",
                "Без двух нулей",
                "Разворот числа",
                "Количество единиц",
                "Вывести нечетные числа последовательности",
                "Вывести члены последовательности с нечетными номерами",
                "Цифры числа слева направо",
                "Цифры числа справа налево",
                "Количество элементов, равных максимуму",
                "Максимум последовательности"
        };

        JComboBox<String> taskComboBox = new JComboBox<>(taskOptions);
        panel.add(taskComboBox);

        JLabel inputLabel1 = new JLabel("Введите первое число:");
        panel.add(inputLabel1);

        JTextField inputField1 = new JTextField();
        panel.add(inputField1);

        JLabel inputLabel2 = new JLabel("Введите второе число:");
        panel.add(inputLabel2);

        JTextField inputField2 = new JTextField();
        panel.add(inputField2);

        JButton solveButton = new JButton("Решить");
        panel.add(solveButton);

        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTaskIndex = taskComboBox.getSelectedIndex();
                String input1 = inputField1.getText();
                String input2 = inputField2.getText();

                // Проверяем ввод на спец. символы, буквы и некорректные цифры
                if (!isValidInput(input1) || !isValidInput(input2)) {
                    resultTextArea.setText("Пожалуйста, введите корректные числа.");
                    return;
                }

                // В зависимости от выбранной задачи, вызываем соответствующий метод и выводим результат
                String result = solveTask(selectedTaskIndex, input1, input2);
                resultTextArea.setText(result);
            }
        });
    }

    private static boolean isValidInput(String input) {
        // Проверяем, что строка состоит только из цифр
        return input.matches("\\d+");
    }

    private static String solveTask(int taskIndex, String input1, String input2) {
        // Здесь в зависимости от выбранной задачи (taskIndex) и введенных данных (input1 и input2)
        // выполняем соответствующую задачу и возвращаем результат в виде строки
        // Пример:
        switch (taskIndex) {
            case 0:
                return task1(input1);
            case 1:
                return task2(input1);
            case 2:
                return task3(input1, input2);
            case 3:
                return task4(input1, input2);
            case 4:
                return task5(input1);
            case 5:
                return task6(input1);
            case 6:
                return task7(input1);
            case 7:
                return task8(input1);
            case 8:
                return task9(input1, input2);
            case 9:
                return task10(input1);
            case 10:
                return task11();
            case 11:
                return task12();
            case 12:
                return task13();
            case 13:
                return task14(input1);
            case 14:
                return task15(input1);
            case 15:
                return task16();
            case 16:
                return task17();
            default:
                return "Выберите задачу из списка.";
        }
    }

    public static String task1(String nStr) {
        try {
            int n = Integer.parseInt(nStr);

            if (n <= 1)
                return "1";

            StringBuilder result = new StringBuilder();

            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    result.append(i).append(" ");
                    n /= i;
                }
            }

            return result.toString().trim();
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task2(String nStr) {
        try {
            int n = Integer.parseInt(nStr);
            StringBuilder result = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                result.append(i).append(" ");
            }

            return result.toString().trim();
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task3(String aStr, String bStr) {
        try {
            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);
            StringBuilder result = new StringBuilder();

            if (a <= b) {
                for (int i = a; i <= b; i++) {
                    result.append(i).append(" ");
                }
            } else {
                for (int i = a; i >= b; i--) {
                    result.append(i).append(" ");
                }
            }

            return result.toString().trim();
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task4(String kStr, String sStr) {
        try {
            int k = Integer.parseInt(kStr);
            int s = Integer.parseInt(sStr);

            int count = 0;

            for (int num = (int) Math.pow(10, k - 1); num < Math.pow(10, k); num++) {
                int sum = 0;
                int n = num;

                while (n != 0) {
                    sum += n % 10;
                    n /= 10;
                }

                if (sum == s) {
                    count++;
                }
            }

            return Integer.toString(count);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task5(String NStr) {
        try {
            int N = Integer.parseInt(NStr);
            int sum = 0;

            while (N > 0) {
                sum += N % 10;
                N /= 10;
            }

            return Integer.toString(sum);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task6(String nStr) {
        try {
            int n = Integer.parseInt(nStr);

            if (n <= 1) {
                return "NO";
            }

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return "NO";
                }
            }

            return "YES";
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task7(String nStr) {
        try {
            int n = Integer.parseInt(nStr);
            StringBuilder result = new StringBuilder();
            int i = 2;

            while (n > 1) {
                if (n % i == 0) {
                    result.append(i).append(" ");
                    n /= i;
                } else {
                    i++;
                }
            }

            return result.toString().trim();
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task8(String word) {
        if (isPalindrome(word)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static String task9(String aStr, String bStr) {
        try {
            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);

            long[][] dp = new long[b + 1][2];
            dp[0][0] = 1;
            dp[0][1] = 0;

            for (int i = 1; i <= b; i++) {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            }

            return Long.toString(dp[b][0] + dp[b][1]);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task10(String nStr) {
        try {
            int n = Integer.parseInt(nStr);
            int reversedNumber = reverseNumber(n);

            return Integer.toString(reversedNumber);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static int reverseNumber(int n) {
        int reversed = 0;

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return reversed;
    }

    public static String task11() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            count += countOnes(num);
        }
        scanner.close();
        return "Количество единиц в последовательности: " + count;
    }

    private static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 10 == 1 ? 1 : 0;
            num /= 10;
        }
        return count;
    }

    public static String task12() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (num % 2 != 0) {
                result.append(num).append(" ");
            }
        }
        scanner.close();
        return "Нечетные числа в последовательности: " + result.toString().trim();
    }

    public static String task13() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (index % 2 == 0) {
                result.append(num).append(" ");
            }
            index++;
        }
        scanner.close();
        return "Члены последовательности с нечетными номерами: " + result.toString().trim();
    }

    public static String task14(String nStr) {
        try {
            int n = Integer.parseInt(nStr);
            StringBuilder result = new StringBuilder();

            while (n > 0) {
                int digit = n % 10;
                result.append(digit).append(" ");
                n /= 10;
            }

            return result.reverse().toString().trim();
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task15(String nStr) {
        try {
            int n = Integer.parseInt(nStr);
            StringBuilder result = new StringBuilder();

            while (n > 0) {
                int digit = n % 10;
                result.append(digit).append(" ");
                n /= 10;
            }

            return result.toString().trim();
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String task16() {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (num > max) {
                max = num;
                count = 1;
            } else if (num == max) {
                count++;
            }
        }
        scanner.close();
        return "Количество элементов, равных максимуму: " + count;
    }

    public static String task17() {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (num > max) {
                max = num;
            }
        }
        scanner.close();
        return "Максимум последовательности: " + max;
    }
}

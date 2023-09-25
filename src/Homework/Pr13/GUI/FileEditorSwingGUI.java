package Homework.Pr13.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class FileEditorSwingGUI {
    private File file = null; // Исходный файл
    private JTextArea textArea;

    public FileEditorSwingGUI() {
        // Создание главного окна
        JFrame frame = new JFrame("Редактор файла");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Создание текстового поля
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Создание панели с кнопками
        JPanel buttonPanel = new JPanel();
        JButton writeButton = new JButton("Записать в файл");
        JButton readButton = new JButton("Прочитать из файла");
        JButton editButton = new JButton("Редактировать файл");
        JButton appendButton = new JButton("Добавить в конец файла");
        JButton chooseFileButton = new JButton("Выбрать файл");
        JButton createFileButton = new JButton("Создать файл");
        JButton deleteFileButton = new JButton("Удалить файл");

        // Добавление слушателей для кнопок
        writeButton.addActionListener(e -> writeFile());
        readButton.addActionListener(e -> readFile());
        editButton.addActionListener(e -> editFile());
        appendButton.addActionListener(e -> appendToFile());
        chooseFileButton.addActionListener(e -> chooseFile());
        createFileButton.addActionListener(e -> createFile());
        deleteFileButton.addActionListener(e -> deleteFile());

        // Добавление кнопок на панель
        buttonPanel.add(writeButton);
        buttonPanel.add(readButton);
        buttonPanel.add(editButton);
        buttonPanel.add(appendButton);
        buttonPanel.add(chooseFileButton);
        buttonPanel.add(createFileButton);
        buttonPanel.add(deleteFileButton);

        // Добавление текстового поля и панели с кнопками на главное окно
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Отображение окна
        frame.setVisible(true);
    }

    // Метод для выбора файла с компьютера
    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            if (file != null) {
                JOptionPane.showMessageDialog(null, "Выбран файл: " + file.getName());
            }
        }
    }

    // Метод для создания нового файла
    private void createFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                file.createNewFile();
                JOptionPane.showMessageDialog(null, "Файл успешно создан: " + file.getName());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ошибка при создании файла!");
            }
        }
    }

    // Метод для удаления файла
    private void deleteFile() {
        if (file != null) {
            int response = JOptionPane.showConfirmDialog(null, "Вы уверены, что хотите удалить файл?", "Подтверждение удаления", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                if (file.delete()) {
                    JOptionPane.showMessageDialog(null, "Файл успешно удален: " + file.getName());
                    file = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Ошибка при удалении файла!");
                }
            }
        }
    }

    // Метод для записи информации в файл
    private void writeFile() {
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Выберите или создайте файл для записи!");
            return;
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            String content = textArea.getText();
            writer.write(content);
            writer.flush();
            JOptionPane.showMessageDialog(null, "Информация успешно записана в файл!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при записи в файл!");
        }
    }

    // Метод для чтения информации из файла
    private void readFile() {
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Выберите файл для чтения!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            textArea.setText(content.toString());
            JOptionPane.showMessageDialog(null, "Информация успешно прочитана из файла!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Файл не найден!");
        }
    }

    // Метод для редактирования информации в файле
    private void editFile() {
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Выберите файл для редактирования!");
            return;
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            String content = textArea.getText();
            writer.write(content);
            writer.flush();
            JOptionPane.showMessageDialog(null, "Информация в файле успешно отредактирована!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при редактировании файла!");
        }
    }

    // Метод для добавления текста в конец файла
    private void appendToFile() {
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Выберите файл для добавления текста!");
            return;
        }

        try (FileWriter writer = new FileWriter(file, true)) {
            String content = textArea.getText();
            writer.write(content);
            writer.flush();
            JOptionPane.showMessageDialog(null, "Текст успешно добавлен в конец файла!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при добавлении текста в файл!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileEditorSwingGUI());
    }
}

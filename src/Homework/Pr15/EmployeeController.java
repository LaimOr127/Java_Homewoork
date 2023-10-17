package Pr15;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private EmployeeView view;
    private Employee model;

    public EmployeeController(EmployeeView view, Employee model) {
        this.view = view;
        this.model = model;

        view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            double hourlyRate = view.getHourlyRateInput();
            int hoursWorked = view.getHoursWorkedInput();

            model = new Employee(name, hourlyRate, hoursWorked);

            double salary = model.calculateSalary();

            view.setSalaryOutput(salary);
        }
    }
}

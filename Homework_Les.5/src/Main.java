import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Employee[] personArray = new Employee[5];

        personArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 20);
        personArray[1] = new Employee("Mikhailov Mikhail", "Architect", "mikhail@mailbox.com", "892312312", 40000, 18);
        personArray[2] = new Employee("Popov Petr", "Headmaster", "petr@mailbox.com", "892312312", 1000000, 64);
        personArray[3] = new Employee("Orlov Vladimir", "Manager", "vladimir@mailbox.com", "892312312", 50000, 53);
        personArray[4] = new Employee("Rubinov Evgeny", "Accountant", "evgeny@mailbox.com", "892312312", 60000, 42);

        Arrays.stream(personArray).filter(employee -> employee.getAge() > 40).forEach(Employee::getInfoAbout);
    }
}

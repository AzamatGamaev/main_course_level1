public class Main {

    public static void main(String[] args) {

        Emploee[] personArray = new Emploee[5];

        personArray[0] = new Emploee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 20);
        personArray[1] = new Emploee("Mikhailov Mikhail", "Architect", "mikhail@mailbox.com", "892312312", 40000, 18);
        personArray[2] = new Emploee("Popov Petr", "Headmaster", "petr@mailbox.com", "892312312", 1000000, 64);
        personArray[3] = new Emploee("Orlov Vladimir", "Manager", "vladimir@mailbox.com", "892312312", 50000, 53);
        personArray[4] = new Emploee("Rubinov Evgeny", "Accountant", "evgeny@mailbox.com", "892312312", 60000, 42);

        for (int i = 0; i < personArray.length; i++)
            if (personArray[i].getAge() > 40) personArray[i].getInfoAbout();
    }
}

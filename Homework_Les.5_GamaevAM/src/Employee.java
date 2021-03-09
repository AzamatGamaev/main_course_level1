public class Employee {

    private String name, position, mail, telephoneNumber;
    private int salary, age;

    Employee(String name, String position, String mail, String telephoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18)
            this.age = age;
    }

    public void getInfoAbout() {
        System.out.println(name + " " + position + " " + mail + " " + telephoneNumber + " " + salary + " " + age + " ");
    }
}

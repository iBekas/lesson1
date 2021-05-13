package lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;

    public Employee (String fullName, String position, String email, int phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void consoleOutput(){
        System.out.printf("Ф.И.О. сотрудника: %s, Позиция в компании: %s, Тел.: %d, Заработная плата: %d, Возраст сотрудника: %d\n", fullName, position, phone, salary, age);
    }

    public int getAge(){
        return this.age;
    }

    public String getFullName(){
        return this.fullName;
    }

}

package lesson5;

public class CreateEmployee {
    public static void main(String[] args) {

        Employee[] employeeArr = new Employee[5];
        employeeArr[0] = new Employee("Андуин Рин", "Жрец", "rin@wow.com" , 800000000, 5000, 26);
        employeeArr[1] = new Employee("Далинар Холин", "Светлорд","holyn@archive.com" , 70000000, 4000, 50);
        employeeArr[2] = new Employee("Зубен Беллиарский", "Владыка Варанта", "zyben@gotic.com" , 66666666, 3000, 44);
        employeeArr[3] = new Employee("Муад'Диб", "Квисатц Хаддерах", "payl@dune.com" , 111111111, 2000, 17);
        employeeArr[4] = new Employee("Геннадий Букин", "Продовец обуви", "gena@shit.ru" ,22000000, 1, 45);

        employeeArr[1].consoleOutput();

        necessaryAge(employeeArr, 40);

    }

    public static void necessaryAge(Employee[] arr, int n){
        for (Employee i: arr) {
            if( i.getAge() > n) System.out.printf(i.getFullName() + " страрше %d лет.\n", n);
            }
        }


}




import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("ШИФРОВЩИК МЕТОДОМ ЦЕЗАРЯ");
        System.out.println("ВЫБЕРИТИ ПУНКТ МЕНЮ");
        System.out.println("1.Шифрование с ключом");
        System.out.println("2.Расшифрование с ключом");
        System.out.println("3.Brute force");
        System.out.println("0.Выход");

        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        System.out.println("ВЫ ВЫБРАЛИ  " + j);
    }

}

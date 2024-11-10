
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;



public class Application {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);


        System.out.println("МЕНЮ:");
        System.out.println("1 - ЗАШИФРОВКА С ПОМОЩЬЮ КЛЮЧА");
        System.out.println("2 - РАСШИФРОВКА С ПОМОЩЬЮ КЛЮЧА");
        System.out.println("3 - РАСШИФРОВКА BRUTE FORCE");
        System.out.println("4 - РАСШИФРОВКА СТАТИСТИЧЕСКИЙ АНАЛИЗ");
        System.out.println("end - ВЫХОД" + "\n");
        String sMenu;
        int iMenu = 0;
        //ПРОВЕРКА НА ВВОД КОРРЕКТНОГО ЗНАЧЕНИЯ
        for (int i = 0; true; i++) {
            System.out.println("ВВЕДИТЕ ПУНКТ МЕНЮ ");
            sMenu = sc.nextLine();
            if (Validator.isValidpMenu(sMenu)) {
                iMenu = Integer.parseInt(sMenu);
                break;
            }
            if (i == 3) {
                System.exit(0);
            }
        }
        //ФАЙЛ ЧТЕНИЯ
        String sNameFileR;
        for (int i = 0; true; i++) {
            System.out.println("УКАЖИТЕ ПУТЬ И ИМЯ ФАЙЛА ДЛЯ ЧТЕНИЯ");
            sNameFileR = sc.nextLine();
            if (Validator.isFileR(sNameFileR)) {
                break;
            }
            if (i == 3) {
                System.exit(0);
            }
        }
        //ФАЙЛ ЗАПИСИ
        String sNameFileW;
        for (int i = 0; true; i++) {
            System.out.println("УКАЖИТЕ ПУТЬ И ИМЯ ФАЙЛА ДЛЯ ЗАПИСИ");
            sNameFileW = sc.nextLine();
            if (Validator.isFileW(sNameFileW, sNameFileR)) {
                break;
            }
            if (i == 3) {
                System.exit(0);
            }
        }
        //РАБОТА С ФАЙЛАМИ:
        Path pathR = Path.of(sNameFileR);
        Path pathW = Path.of(sNameFileW);
        //СОЗДАТЬ МАСИВ СТРОК
        List<String> lines = FileManager.readFile(pathR);
        //СОЗДАТЬ ПУСТОЙ ФАИЛ(ОТЧИСТИТЬ СТАРЫЙ)
        Files.writeString(pathW, "");

        // ШИФРОВКА И ДЕШИФРОВКА КЛЮЧОМ----------------------------------------------------------------------
        if (iMenu == 1 || iMenu == 2) {
            String sKey;
            int iKey;
            for (int i = 0; true; i++) {
                System.out.println("ВВЕДИТЕ КЛЮЧ ШИФРОВАНИЯ (ЦЕЛОЕ ПОЛОЖИТЕЛЬНОЕ ЧИСЛО)");
                sKey = sc.nextLine();
                if (Validator.isValidKey(sKey)) {
                    iKey = Integer.parseInt(sKey);
                    break;
                }
                if (i == 3) {
                    System.exit(0);
                }
            }
            String newLines;
            //ШИФРОВКА
            if (iMenu == 1) {
                for (String sl : lines) {
                    newLines = Cipher.encrypt(sl, iKey) + "\n";
                    FileManager.writeFile(newLines, pathW);
                }
                System.out.println("ФАИЛ ЗАШИФРОВАН");
            //ДЕШИФРОВКА
            }else{
                for (String sl : lines) {
                    newLines = Cipher.decrypt(sl, iKey) + "\n";
                    FileManager.writeFile(newLines, pathW);
                }
                System.out.println("ФАИЛ РАСШИФРОВАН");
            }
        }
        //BRUTE FORCE-----------------------------------------------------------------------------------
        String newLines;
        if (iMenu == 3) {
             for (int i = 1; i <= Cipher.ALPHABET.size(); i++) {
                 String sKey = ("\n" + "---ключ : " + i  + " ---"+ "\n");
                 FileManager.writeFile(sKey, pathW);
                 int volumeTextLine = 5;
                 int currentTextLine = 0;
                 for (String sl : lines) {
                     newLines = Cipher.encrypt(sl, i) + "\n";
                     FileManager.writeFile(newLines, pathW);
                     currentTextLine ++;
                     if (currentTextLine == volumeTextLine){
                         break;
                     }
                 }
            }
            System.out.println("ФАИЛ С ВОЗМОЖНЫМИ ВАРИАНТАМИ СОЗДАН");

        }
        //StAnaliz-----------------------------------------------------------------------------------

        if (iMenu == 4 ) {
            System.out.println("РАЗДЕЛ В РАЗРАБОТКЕ");
            System.out.println("ВЫЙДЕТ С ОБНОВЛЕНИЕМ");
        }





    }

}

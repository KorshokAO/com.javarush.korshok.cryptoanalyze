import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    //МЕНЮ
    public static boolean isValidpMenu(String pMenu) {
        if (pMenu.equals("end")){System.exit(0);}       
        try {
            int pMenuInt = Integer.parseInt(pMenu);
            return (pMenuInt >= 1 && pMenuInt <= 4);      
        }catch (Exception e){
            System.out.println("ОШИБКА: ВВЕДЕНО НЕ ВЕРНОЕ ЗНАЧЕНИЕ");
            System.out.println("ВВЕДИТЕ ЦЕЛОЕ ЧИСЛО ОТ 1 ДО 5");
            return false;
        }
    }
    //ФАИЛ ДЛЯ ЧТЕНИЯ
    public static boolean isFileR(String nameFileR) {
        if (nameFileR.equals("end")){System.exit(0);}
        try {
            if (Files.size(Path.of(nameFileR)) > 0) {
                return true;
            }else {
                System.out.println("ОШИБКА: ФАИЛ ПУСТ");
                return false;
            }    
        }catch (Exception e){
            System.out.println("ОШИБКА: ФАИЛ НЕ НАЙДЕН");
            return false;
        }
    }
    //ФАИЛ ДЛЯ ЗАПИСИ
    public static boolean isFileW(String nameFileW, String nameFileR) {
        if (nameFileW.equals("end")) {
            System.exit(0);
        }
        if (nameFileR.equals(nameFileW)) {
            System.out.println("ОШИБКА: ФАЙЛ ДЛЯ ЗАПИСИ ДОЛЖЕН ОТЛИЧАТСЯ ОТ ФАЙЛА ДЛЯ ЧТЕНИЯ");
            return false;
        }
                try {
            Files.writeString(Path.of(nameFileW), "");
        }catch ( Exception e){
            System.out.println("ОШИБКА: НЕКОРРЕКТНОЕ ИМЯ ФАЙЛА");
            return false;
        }
        return true;
    }


    public static boolean isValidKey(String key) {
        if (key.equals("end")){System.exit(0);}
        try {
            int ikey = Integer.parseInt(key);
            System.out.println("КЛЮЧ ПРИНЯТ : "+ ikey);
            return (ikey>0);
        }catch (Exception e){
            System.out.println("ОШИБКА: ВВЕДЕНО НЕ ВЕРНОЕ ЗНАЧЕНИЕ");
            return false;
        }
    }






}

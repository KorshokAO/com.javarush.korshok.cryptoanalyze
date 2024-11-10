import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {

    public static final List ALPHABET = Arrays.asList('а', 'б',
            'в','г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    // ИНДУКС СДВИГА
    private static int indxArr(int index, int shift, int arrLenghy){
        int indexNorm = (index + shift) % (arrLenghy);
        if (indexNorm < 0){
            indexNorm = indexNorm + (arrLenghy);
            return indexNorm;
        }else {
            return indexNorm;
        }
    }

    //ШИФРОВЩИК
    public static String encrypt(String text, int shift) {
        StringBuilder sbText = new StringBuilder(text.toLowerCase());
        char chars;
        int indx;
        for (int i = 0; i < sbText.length(); i++) {
            chars = sbText.charAt(i);
            indx = ALPHABET.indexOf(chars);
            if (indx != -1) {
                indx = indxArr(indx, shift, ALPHABET.size());
                sbText.setCharAt(i, (char) ALPHABET.get(indx));
            }
        }
        return sbText.toString();
    }
    //ДЕШИФРОВЩИК
    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);

    }

    //BRUTE FORCE
    public static String decryptBF(String text) {

        return null;
    }

}

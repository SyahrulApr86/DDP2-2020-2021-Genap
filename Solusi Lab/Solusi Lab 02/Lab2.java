import java.util.Scanner;

public class Lab2 {
    final static int ASCII_START = 65;
    final static int ASCII_END = 90;
    final static int CIPHER_DIFFERENCE = 3;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String pesan = input.next();
        String urutanTahap = input.next();

        for (int i = 0; i < urutanTahap.length(); i++) {
            char currentStep = urutanTahap.charAt(i);
            if (currentStep == 'E') {
                pesan = encryptCaesar(pesan);
            } else if (currentStep == 'D') {
                pesan = decryptCaesar(pesan);
            } else {
                // do nothing
            }
        }
        System.out.println(pesan);

        input.close();
    }

    public static String encryptCaesar(String pesan) {
        String encryptResult = "";
        for (int i = 0; i < pesan.length(); i++) {
            // Set newCharacter to current char + 3
            char newCharacter = (char) (((int) pesan.charAt(i)) + CIPHER_DIFFERENCE);
            if (((int) newCharacter) > ASCII_END) {
                // Handle if overflow, then set it to A + (difference + 1)
                newCharacter = (char) (ASCII_START + (((int) newCharacter) - (ASCII_END + 1)));
            }
            // Set primitive char to reference char or Character, because it has a built-in
            // method Character.toString()
            Character object = newCharacter;
            // Concatenate string with string
            encryptResult +=  object.toString();
        }
        return encryptResult;
    }

    public static String decryptCaesar(String pesan) {
        String decryptResult = "";
        for (int i = 0; i < pesan.length(); i++) {
            // Set newCharacter to current char - 3
            char newCharacter = (char) (((int) pesan.charAt(i) - CIPHER_DIFFERENCE));
            if (((int) newCharacter) < ASCII_START) {
                // Handle if underflow, then set it to Z - (difference + 1)
                newCharacter = (char) (ASCII_END - ((ASCII_START) - ((int) newCharacter + 1)));
            }
            // Set primitive char to reference char or Character, because it has a built-in
            // method Character.toString()
            Character object = newCharacter;
            // Concatenate string with string
            decryptResult += object.toString();
        }
        return decryptResult;
    }
}

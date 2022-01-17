import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt untuk input pesan dan tahap enkripsi/dekripsi
        System.out.println("Masukkan pesan dan urutan tahap enkripsi/dekripsi:");
        String pesan = input.next();
        String encryptDecrypt = input.next();

        // Looping untuk menentukan enkripsi/deksripsi
        for (var i = 0; i < encryptDecrypt.length(); i++){
            if (encryptDecrypt.charAt(i) == 'E'){
                pesan = encrypt(pesan);
            }else if (encryptDecrypt.charAt(i) == 'D') {
                pesan = decrypt(pesan);
            }
        }

        // Mencetak output
        System.out.println("\nBerikut hasilnya:");
        System.out.println(pesan);

        input.close();
    }

    /**
     * Method untuk mengenkripsikan sebuah kata
     * @param word String yang akan di enkripsi
     * @return String yang sudah dienkripsi
     */
    public static String encrypt (String word){
        StringBuilder encryptWord = new StringBuilder();
        for (var i = 0; i < word.length(); i++){
            int ascii = (int) word.charAt(i) + 3;

            if (ascii > 90){
                ascii -= 26;
            }
            encryptWord.append((char) ascii);
        }
        return encryptWord.toString();
    }

    /**
     * Method untuk mendeksripsikan sebuah kata
     * @param word String yang akan didekripsi
     * @return String yang sudah didekripsi
     */
    public static String decrypt (String word){
        StringBuilder decryptWord = new StringBuilder();
        for (var i = 0; i < word.length(); i++){
            int ascii = (int) word.charAt(i) - 3;

            if (ascii < 65){
                ascii += 26;
            }
            decryptWord.append((char) ascii);
        }
        return decryptWord.toString();
    }

}

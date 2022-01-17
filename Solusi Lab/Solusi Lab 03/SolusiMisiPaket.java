import java.util.*;

public class SolusiMisiPaket {
    static int N;
    public static void main(String[] args) {

        /* 
        Proses Input dari user 
        */

        Scanner input = new Scanner(System.in);
        System.out.print("Panjang: ");
        N = Integer.parseInt(input.nextLine());
        int[] arr = new int[N];

        System.out.print("Barisan: ");
        for (int i = 0; i < N; i++) {
            int data = input.nextInt();
            arr[i] = data;
        }
        input.nextLine();

        System.out.print("Pergeseran: ");        
        String geser = input.nextLine();

        /* 
        Hitung berapa kali array harus dishift ke mana.
        bilangan positif berarti shift ke kanan, 
        bilangan negatif shift ke kiri
        */
        int dir = 0;
        for (char d : geser.toCharArray()) {
            if (d == 'R') dir++;
            else if (d == 'L') dir--;  
        }

        // Implementasi fungsi geser-geser
        int[] shiftedArray = shift(arr, dir);
        System.out.println("Output: " + Arrays.toString(shiftedArray));

        // Implementasi pengecekan elemen pertama
        System.out.println(check(shiftedArray));

        input.close();
    }

    public static int[] shift(int[] arr, int dir) {
        if (N <= 1) return arr;
        else dir = dir % N; 

        int[] res = arr.clone(); 
        for (int i = 0; i < N; i++) {
            if (i + dir >= N) res[i + dir - N] = arr[i];
            else if (i + dir < 0) res[i + dir + N] = arr[i];
            else res[i + dir] = arr[i];
        }
        return res;
    }

    public static boolean check(int[] arr) {
        if (N == 0) return false;
	    if (N == 1) return true;

        int first = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] < first) return false;
        }
        return true;
    }
}

import java.util.*;

public class MisiPaket {
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
        input.close();

        // Membuat array baru dengan panjang yang identik dengan
        // array sebelumnya
        int[] newArr = new int[arr.length];

        // Looping untuk penggeseran array
        for (var i = 0; i < geser.length(); i++){
            // Kondisi jika digeser ke kiri
            if (geser.charAt(i) == 'L'){
                for (var u = 0; u < arr.length; u++){
                    if (u+1 == arr.length){
                        newArr[u] = arr[0];
                    }else{
                        newArr[u] = arr[u+1];
                    }
                }

            // Kondisi jika digeser ke kanan
            }else if (geser.charAt(i) == 'R'){
                for (var u = 0; u < arr.length; u++){
                    if (u == 0){
                        newArr[u] = arr[arr.length-1];
                    }else{
                        newArr[u] = arr[u-1];
                    }
                }
            }
            arr = newArr.clone();
        }

        // Pengecekan nilai array pertama
        boolean result = true;
        if (newArr.length != 0){
            for (var u = 1; u < newArr.length; u++){
                if (newArr[u] < newArr[0]){
                    result = false;
                    break;
                }
            }
        }else {
            result = false;
        }

        // Mencetak output
        System.out.println("Output: " + Arrays.toString(newArr));
        System.out.println(result);
    }
}

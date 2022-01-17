import java.util.Arrays;

public class Tempat {
    private final String nama;
    private final String lokasi;
    private final String deskripsi;
    private final String tipeTempat;
    private boolean dikunjungi = false;
    static Tempat[] semuaTempat = new Tempat[0];

    public Tempat(String nama, String lokasi, String deskripsi, String tipeTempat) {
        // TODO: Tambahkan method Getter dan Setter sesuai keperluan.
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.tipeTempat = tipeTempat;
    }

    public String getNama() {
        return nama;
    }


    public String getLokasi() {
        return lokasi;
    }


    public String getDeskripsi() {
        return deskripsi;
    }


    public String getTipeTempat() {
        return tipeTempat;
    }


    public boolean isDikunjungi() {
        return dikunjungi;
    }

    public String kunjungi() {
        // TODO: Selesaikan bagian ini!
        this.dikunjungi = true;
        return String.format("Saya mengunjungi %s", getNama());
    }
    
    public String beraktivitas(String aktivitas, String namaTempat){
        Tempat tempat = getTempat(namaTempat);
        assert tempat != null;
        if (tempat.getTipeTempat().equals("gedung") && aktivitas.toLowerCase().startsWith("belajar")) {
            return tempat.beraktivitas(aktivitas.substring(8));
        } else if (tempat.getTipeTempat().equals("labkom") && aktivitas.equalsIgnoreCase("gunakan komputer")) {
            return tempat.beraktivitas(aktivitas);
        }
        return String.format("Di %s, aktivitas %s tidak dapat dilakukan.",namaTempat, aktivitas);
    }

    public String beraktivitas(String aktivitas) {
        return String.format("Saya melakukan %s di %s.", aktivitas, this.nama);
    }

    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nSudah dikunjungi: %b", nama, lokasi, deskripsi, dikunjungi);
    }

    public static Tempat getTempat(String namaTempat) {
        for (Tempat tempat : Tempat.semuaTempat){
            if (tempat.getNama().equals(namaTempat)){
                return tempat;
            }
        }
        return null;
    }

    public static void tambahArrayTempat(Tempat value) {
        Tempat[] temp = Arrays.copyOf(semuaTempat, semuaTempat.length+1);
        temp[semuaTempat.length] = value;
        semuaTempat = temp;
    }
}

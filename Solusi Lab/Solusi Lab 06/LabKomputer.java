public class LabKomputer extends Tempat {
    private int jumlahKomputer;
    public LabKomputer(String nama, String lokasi, String deskripsi, int jumlahKomputer) {
        // TODO: Selesaikan bagian ini!
        super(nama, lokasi, deskripsi,"labkom");
        this.jumlahKomputer = jumlahKomputer;
    }

    @Override
    public String beraktivitas(String aktivitas) {
        // TODO: Selesaikan bagian ini!
        this.kunjungi();
        return String.format("Saya meng%s di %s",aktivitas, this.getNama());
    }

    @Override
    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nJumlah Komputer tersedia: %d\nSudah dikunjungi: %b", super.getNama(), super.getLokasi(), super.getDeskripsi(), this.jumlahKomputer, super.isDikunjungi());
    }
}

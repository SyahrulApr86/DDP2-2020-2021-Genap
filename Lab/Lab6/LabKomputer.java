public class LabKomputer extends Tempat {
    private final int jumlahKomputer;
    public LabKomputer(String nama, String lokasi, String deskripsi, int jumlahKomputer) {
        // TODO: Selesaikan bagian ini!
        super(nama, lokasi, deskripsi, "labkom");
        this.jumlahKomputer = jumlahKomputer;
        // NOTE: Tipe tempat: labkom
    }

    @Override
    public String beraktivitas(String aktivitas) {
        // TODO: Selesaikan bagian ini!
        this.kunjungi();
        return String.format("Saya %s di %s", aktivitas, getNama());
    }

    @Override
    public String toString() {
        // TODO: Selesaikan bagian ini!
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nJumlah Komputer tersedia: %d\nSudah dikunjungi: %b\n", super.getNama(), super.getLokasi(), super.getDeskripsi(), this.jumlahKomputer, super.isDikunjungi());
    }
}

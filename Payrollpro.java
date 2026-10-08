package payrollpro;

import java.util.Scanner;

public class Payrollpro {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] daftarUsername = {"admin", "sukma", "fuzi", "fatih", "faisal", "naufal", "nanda"};
        String[] daftarPassword = {"12345", "sukma123", "fuzi123", "fatih123", "faisaL123", "naufaL123", "nanda123"};

        int kesempatan = 3;
        boolean berhasil = false;
        String userLogin = "";

        System.out.println("=== PAYROLL PRO ===");

        // Loop: maksimal 3x percobaan (Sesi 5)
        while (kesempatan > 0) {
            System.out.print("Username : ");
            String username = input.nextLine();
            System.out.print("Password : ");
            String password = input.nextLine();
            // Loop for untuk cek tiap akun (Sesi 5-6)
            for (int i = 0; i < daftarUsername.length; i++) {
                if (username.equals(daftarUsername[i]) && password.equals(daftarPassword[i])) {
                    berhasil = true;
                    userLogin = username;
                    break; // keluar dari loop (Sesi 6)
                }
            }

            // Percabangan (Sesi 4)
            if (berhasil) {
                break;
            } else {
                kesempatan--;
                System.out.println("Login gagal! Sisa kesempatan: " + kesempatan);
            }
        }

        if (berhasil) {
            System.out.println("Login berhasil! Selamat datang, " + userLogin);
            // ===== BAGIAN MENU PAYROLL =====
            String[] nama = new String[10]; // maksimal 10 karyawan
            long[] gajiPokok = new long[10];
            String [] jabatan = new String[10];
            String [] divisi = new String[10];

            nama[0] = "Sukma Ayu";
            gajiPokok[0] = 15000000;
            jabatan[0] = " Deputy Software Manager";
            divisi[0] = "IT";
            nama[1] = "Nanda Amelia Putri";
            gajiPokok[1] = 15000000;
            jabatan[1] = " HR manager";
            divisi[1] = "SDM";
            nama[2] = "Fauziah Nur Fadillah";
            gajiPokok[2] = 15000000;
            jabatan[2] = "Produk Manager";
            divisi[2] = "Produk";
            nama[3] = "Fatih Fadhlullah";
            gajiPokok[3] = 15000000;
            jabatan[3] = "Staff";
            divisi[3] = "IT";
            nama[4] = "Faisal Rizki Aditiya";
            gajiPokok[4] = 15000000;
            jabatan[4] = "Staff";
            divisi[4] = "IT";
            nama[5] = "Naufal Ibnu Hanif";
            gajiPokok[5] = 15000000;
            jabatan[5] = "Staff";
            divisi[5] = "IT";
            
            int jumlah = 6;                     // jumlah karyawan yang sudah diinput

            int pilihan = 0;
            long potonganPerHari = 100000;

            while (pilihan != 4) {
                System.out.println();
                System.out.println("===== MENU PAYROLL PRO =====");
                System.out.println("1. Tambah Karyawan");
                System.out.println("2. Lihat Data Karyawan");
                System.out.println("3. Hitung Gaji");
                System.out.println("4. Logout");
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {
                    case 1:
                        if (jumlah < 10) {
                            System.out.print("Nama karyawan : ");
                            nama[jumlah] = input.nextLine();
                            System.out.print("Gaji pokok    : ");
                            gajiPokok[jumlah] = Long.parseLong(input.nextLine());
                            System.out.print("Jabatan       : ");
                            jabatan[jumlah] = input.nextLine();
                            System.out.print("Divisi        : ");
                            divisi[jumlah] = input.nextLine();
                            jumlah++;
                            System.out.println("Data berhasil disimpan.");
                        } else {
                            System.out.println("Data penuh (maksimal 10 karyawan).");
                        }
                        break;

                    case 2:
                        if (jumlah == 0) {
                            System.out.println("Belum ada data karyawan.");
                        } else {
                            for (int i = 0; i < jumlah; i++) {
                                System.out.println((i + 1) + ". " + nama[i] + " - " + jabatan[i] + " (" + divisi[i] + ")");
                            }
                        }
                        break;
                    case 3:
                        if (jumlah == 0) {
                            System.out.println("Belum ada data karyawan.");
                            break;
                        }

                        System.out.print("Masukkan nama karyawan (0 = kembali): ");
                        String cari = input.nextLine();

                        if (cari.equals("0")) {
                            System.out.println("Kembali ke menu.");
                            break;
                        }
                        // Cari karyawan (huruf besar-kecil tidak masalah, nama sebagian juga bisa)
                        int index = -1;
                        for (int i = 0; i < jumlah; i++) {
                            if (nama[i].toLowerCase().contains(cari.toLowerCase())) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            System.out.println("Karyawan tidak ditemukan.");
                        } else {
                            System.out.println("Karyawan ditemukan: " + nama[index]);
                            System.out.print("Jumlah hari absen: ");
                            int absen = Integer.parseInt(input.nextLine());

                            long tunjangan = gajiPokok[index] * 10 / 100;   // tunjangan 10%
                            long potongan = gajiPokok[index] * 5 / 100;     // potongan 5%
                            long potonganAbsen = absen * potonganPerHari;
                            long gajiBersih = gajiPokok[index] + tunjangan - potongan - potonganAbsen;

                            System.out.println("--- " + nama[index] + " ---");
                            System.out.println("Gaji pokok     : Rp" + gajiPokok[index]);
                            System.out.println("Tunjangan      : Rp" + tunjangan);
                            System.out.println("Potongan       : Rp" + potongan);
                            System.out.println("Absen          : " + absen + " hari");
                            System.out.println("Potongan absen : Rp" + potonganAbsen);
                            System.out.println("Gaji bersih    : Rp" + gajiBersih);
                        }
                        break;
                    case 4:
                        System.out.println("Logout berhasil. Sampai jumpa, " + userLogin + "!");
                        break;

                    default:
                        System.out.println("Menu tidak tersedia, pilih 1-4.");
                }
            }
        } else {
            System.out.println("Akun terblokir. Coba lagi nanti.");
        }
    }
}

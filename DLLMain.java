
import java.util.Scanner;

public class DLLMain {
    public static void main(String[] args) {
        DoubleLinkedList10 list = new DoubleLinkedList10();
        Scanner scan = new Scanner(System.in);
        

        int pilihan;
        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Sisipkan setelah NIM tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa10 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                    break;
                }
                case 2 -> {
                    Mahasiswa10 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                    break;
                }
                case 3 -> {
                    list.removeFirst();
                    break;
                }
                case 4 -> {
                    list.removeLast();
                    break;
                }
                case 5 -> {
                    list.print();
                    break;
                }
                case 6 -> {
                    System.out.print("Masukkan NIM yang dicari : ");
                    String nim = scan.nextLine();
                    Node10 found = list.search(nim);
                    if (found != null) {
                        System.out.print("Data ditemukan: ");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }
                }
                case 7 -> {
                    System.out.print("Masukkan NIM setelah dimana data akan disisipkan: ");
                    String keyNim = scan.nextLine();
                    Mahasiswa10 mhs = inputMahasiswa(scan);
                    list.insertAfter(keyNim, mhs);
                    break;
                }
                case 0 -> {
                    System.out.println("Keluar dari program.");
                }
                default -> {
                System.out.println("Pilihan tidak valid!");
            }
        }
        } while (pilihan != 0);
        scan.close();
    }

    public static Mahasiswa10 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa10(nim, nama, kelas, ipk);
    }
    }
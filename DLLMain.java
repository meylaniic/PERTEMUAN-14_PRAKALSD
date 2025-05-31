
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
            System.out.println("8. Tambah di indeks tertentu");
            System.out.println("9. Hapus node setelah NIM tertentu");
            System.out.println("10. Hapus berdasarkan indeks");
            System.out.println("11. Tampilkan data pertama, terakhir, dan berdasarkan indeks");
            System.out.println("12. Tampilkan jumlah data");
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
                case 8 -> {
                    System.out.print("Masukkan index: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa10 mhs = inputMahasiswa(scan);
                    list.add(index, mhs);
                    break;
                }
                case 9 -> {
                    System.out.print("Masukkan NIM setelah dimana node akan dihapus: ");
                    String keyNim = scan.nextLine();
                    list.removeAfter(keyNim);
                    break;
                }
                case 10 -> {
                    System.out.print("Masukkan index yang akan dihapus: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.remove(index);
                    break;
                }
                case 11 -> {
                Mahasiswa10 first = list.getFirst();
                Mahasiswa10 last = list.getLast();
                System.out.println("Data pertama:");
                if (first != null) first.tampil();
                else System.out.println("Kosong");

                System.out.println("Data terakhir:");
                if (last != null) last.tampil();
                else System.out.println("Kosong");

                System.out.print("Masukkan indeks: ");
                int index = scan.nextInt();
                scan.nextLine();
                Mahasiswa10 mhs = list.getIndex(index);
                System.out.println("Data di indeks " + index + ":");
                if (mhs != null) mhs.tampil();
                else System.out.println("Tidak ditemukan");
                break;
                }
                case 12 -> {
                    System.out.println("Jumlah data dalam list: " + list.size());
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
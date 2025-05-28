public class DoubleLinkedList10 {
    Node10 head;
    Node10 tail;

    public DoubleLinkedList10() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa10 data) {
        Node10 newNode = new Node10(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa10 data) {
        Node10 newNode = new Node10(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa10 data) {
        Node10 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " +keyNim + " tidak ditemukan.");
            return;
        }

        Node10 newNode = new Node10(data);

        if (current==tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node Berhasil Disisipkan Setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih Kosong");
            return;
        }   
        Node10 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        Mahasiswa10 dataTerhapus = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah: ");
        dataTerhapus.tampil();
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        Mahasiswa10 dataTerhapus = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null; 
        }

        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah: ");
        dataTerhapus.tampil();
    }

    public Node10 search(String nim) {
        Node10 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}


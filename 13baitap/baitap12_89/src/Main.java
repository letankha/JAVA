import java.util.ArrayList;
import java.util.Scanner;

// Lớp Môn Học
class MonHoc {
    private String maMonHoc; // Mã môn học
    private String tenMonHoc; // Tên môn học
    private int soTinChi; // Số tín chỉ

    // Constructor không tham số
    public MonHoc() {
        this.maMonHoc = "";
        this.tenMonHoc = "";
        this.soTinChi = 0;
    }

    // Constructor có tham số
    public MonHoc(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    // Nhập thông tin môn học
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học: ");
        this.maMonHoc = scanner.nextLine();
        System.out.print("Nhập tên môn học: ");
        this.tenMonHoc = scanner.nextLine();
        System.out.print("Nhập số tín chỉ: ");
        this.soTinChi = scanner.nextInt();
    }

    // Xuất thông tin môn học
    public void xuat() {
        System.out.printf("Mã môn học: %s, Tên môn học: %s, Số tín chỉ: %d%n",
                maMonHoc, tenMonHoc, soTinChi);
    }

    // Getter cho mã môn học
    public String getMaMonHoc() {
        return maMonHoc;
    }

    // Getter cho tên môn học
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    // Getter cho số tín chỉ
    public int getSoTinChi() {
        return soTinChi;
    }
}

// Lớp Quản Lý Môn Học
class QuanLyMonHoc {
    private ArrayList<MonHoc> danhSachMonHoc;

    // Constructor
    public QuanLyMonHoc() {
        danhSachMonHoc = new ArrayList<>();
    }

    // Thêm môn học
    public void themMonHoc() {
        MonHoc monHoc = new MonHoc();
        monHoc.nhap();
        danhSachMonHoc.add(monHoc);
        System.out.println("Thêm môn học thành công.");
    }

    // Xóa môn học
    public void xoaMonHoc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học cần xóa: ");
        String maMonHocXoa = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < danhSachMonHoc.size(); i++) {
            if (danhSachMonHoc.get(i).getMaMonHoc().equalsIgnoreCase(maMonHocXoa)) {
                danhSachMonHoc.remove(i);
                System.out.println("Xóa môn học thành công.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy môn học với mã " + maMonHocXoa);
        }
    }

    // Hiển thị danh sách môn học
    public void hienThiMonHoc() {
        if (danhSachMonHoc.isEmpty()) {
            System.out.println("Danh sách môn học trống.");
            return;
        }
        System.out.println("Danh sách môn học:");
        for (MonHoc monHoc : danhSachMonHoc) {
            monHoc.xuat();
        }
    }

    // Tìm kiếm môn học
    public void timKiemMonHoc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn tiêu chí tìm kiếm:");
        System.out.println("1. Theo mã môn học");
        System.out.println("2. Theo tên môn học");
        System.out.println("3. Theo số tín chỉ");
        int luaChon = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline

        boolean found = false;
        switch (luaChon) {
            case 1: // Tìm theo mã môn học
                System.out.print("Nhập mã môn học cần tìm: ");
                String maMonHocTim = scanner.nextLine();
                for (MonHoc monHoc : danhSachMonHoc) {
                    if (monHoc.getMaMonHoc().equalsIgnoreCase(maMonHocTim)) {
                        monHoc.xuat();
                        found = true;
                    }
                }
                break;

            case 2: // Tìm theo tên môn học
                System.out.print("Nhập tên môn học cần tìm: ");
                String tenMonHocTim = scanner.nextLine();
                for (MonHoc monHoc : danhSachMonHoc) {
                    if (monHoc.getTenMonHoc().equalsIgnoreCase(tenMonHocTim)) {
                        monHoc.xuat();
                        found = true;
                    }
                }
                break;

            case 3: // Tìm theo số tín chỉ
                System.out.print("Nhập số tín chỉ cần tìm: ");
                int soTinChiTim = scanner.nextInt();
                for (MonHoc monHoc : danhSachMonHoc) {
                    if (monHoc.getSoTinChi() == soTinChiTim) {
                        monHoc.xuat();
                        found = true;
                    }
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }

        if (!found) {
            System.out.println("Không tìm thấy môn học theo tiêu chí đã chọn.");
        }
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyMonHoc qlMonHoc = new QuanLyMonHoc();

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm môn học");
            System.out.println("2. Xóa môn học");
            System.out.println("3. Hiển thị danh sách môn học");
            System.out.println("4. Tìm kiếm môn học");
            System.out.println("5. Thoát");
            int luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    qlMonHoc.themMonHoc();
                    break;
                case 2:
                    qlMonHoc.xoaMonHoc();
                    break;
                case 3:
                    qlMonHoc.hienThiMonHoc();
                    break;
                case 4:
                    qlMonHoc.timKiemMonHoc();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}

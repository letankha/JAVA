import java.util.ArrayList;
import java.util.Scanner;

// Lớp Môn Học
class MonHoc {
    private String maMonHoc; // Mã môn học
    private String tenMonHoc; // Tên môn học
    private int soTiet; // Số tiết

    // Constructor không tham số
    public MonHoc() {
        this.maMonHoc = "";
        this.tenMonHoc = "";
        this.soTiet = 0;
    }

    // Constructor có tham số
    public MonHoc(String maMonHoc, String tenMonHoc, int soTiet) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTiet = soTiet;
    }

    // Nhập thông tin môn học
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học: ");
        this.maMonHoc = scanner.nextLine();
        System.out.print("Nhập tên môn học: ");
        this.tenMonHoc = scanner.nextLine();
        System.out.print("Nhập số tiết: ");
        this.soTiet = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline
    }

    // Xuất thông tin môn học
    public void xuat() {
        System.out.printf("Mã môn học: %s, Tên môn học: %s, Số tiết: %d%n",
                maMonHoc, tenMonHoc, soTiet);
    }
}

// Lớp Học Viên
class HocVien {
    private String soCCCD; // Số CCCD hoặc Mã định danh
    private String tenHocVien; // Tên học viên
    private ArrayList<MonHoc> danhSachMonHoc; // Danh sách môn học

    // Constructor không tham số
    public HocVien() {
        this.soCCCD = "";
        this.tenHocVien = "";
        this.danhSachMonHoc = new ArrayList<>();
    }

    // Nhập thông tin học viên
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số CCCD hoặc mã định danh: ");
        this.soCCCD = scanner.nextLine();
        System.out.print("Nhập tên học viên: ");
        this.tenHocVien = scanner.nextLine();

        System.out.print("Nhập số môn học học viên đăng ký: ");
        int soMon = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline

        for (int i = 0; i < soMon; i++) {
            System.out.println("Nhập thông tin môn học " + (i + 1) + ":");
            MonHoc monHoc = new MonHoc();
            monHoc.nhap();
            danhSachMonHoc.add(monHoc);
        }
    }

    // Xuất thông tin học viên
    public void xuat() {
        System.out.printf("Số CCCD: %s, Tên học viên: %s%n", soCCCD, tenHocVien);
        System.out.println("Danh sách môn học:");
        for (MonHoc monHoc : danhSachMonHoc) {
            monHoc.xuat();
        }
    }

    // Kiểm tra số môn học
    public int getSoMonHoc() {
        return danhSachMonHoc.size();
    }
}

// Lớp Quản Lý Học Viên
class QuanLyHocVien {
    private ArrayList<HocVien> danhSachHocVien;

    // Constructor
    public QuanLyHocVien() {
        danhSachHocVien = new ArrayList<>();
    }

    // Thêm học viên
    public void themHocVien() {
        HocVien hocVien = new HocVien();
        hocVien.nhap();
        danhSachHocVien.add(hocVien);
        System.out.println("Thêm học viên thành công.");
    }

    // Hiển thị thông tin tất cả học viên
    public void hienThiHocVien() {
        if (danhSachHocVien.isEmpty()) {
            System.out.println("Danh sách học viên trống.");
            return;
        }
        System.out.println("Danh sách học viên đã đăng ký:");
        for (HocVien hocVien : danhSachHocVien) {
            hocVien.xuat();
            System.out.println();
        }
    }

    // Hiển thị thông tin học viên đăng ký ít nhất hai môn học
    public void hienThiHocVienHaiMon() {
        System.out.println("Danh sách học viên đăng ký ít nhất hai môn học:");
        boolean found = false;
        for (HocVien hocVien : danhSachHocVien) {
            if (hocVien.getSoMonHoc() >= 2) {
                hocVien.xuat();
                found = true;
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("Không có học viên nào đăng ký ít nhất hai môn học.");
        }
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyHocVien qlHocVien = new QuanLyHocVien();

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm học viên");
            System.out.println("2. Hiển thị thông tin học viên");
            System.out.println("3. Hiển thị học viên đăng ký ít nhất hai môn học");
            System.out.println("4. Thoát");
            int luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    qlHocVien.themHocVien();
                    break;
                case 2:
                    qlHocVien.hienThiHocVien();
                    break;
                case 3:
                    qlHocVien.hienThiHocVienHaiMon();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}

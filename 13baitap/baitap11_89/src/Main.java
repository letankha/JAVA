import java.util.ArrayList;
import java.util.Scanner;

// Lớp Người
class Nguoi {
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String diaChi;
    private String soCCCD;

    // Constructor không tham số
    public Nguoi() {
        this.hoTen = "Nguyen Van A";
        this.namSinh = 2000;
        this.gioiTinh = "Nam";
        this.diaChi = "Ha Noi";
        this.soCCCD = "123456789";
    }

    // Constructor có tham số
    public Nguoi(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    // Nhập thông tin
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhập năm sinh: ");
        this.namSinh = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline
        System.out.print("Nhập giới tính: ");
        this.gioiTinh = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.print("Nhập số CCCD: ");
        this.soCCCD = scanner.nextLine();
    }

    // Xuất thông tin
    public void xuat() {
        System.out.printf("Họ và tên: %s, Năm sinh: %d, Giới tính: %s, Địa chỉ: %s, Số CCCD: %s%n",
                hoTen, namSinh, gioiTinh, diaChi, soCCCD);
    }
}

// Lớp Nhân viên kế thừa từ lớp Người
class NhanVien extends Nguoi {
    private String maSoNhanVien; // Mã số nhân viên
    private String phongBan; // Phòng ban
    private String chucVu; // Chức vụ
    private double heSoLuong; // Hệ số lương

    // Constructor không tham số
    public NhanVien() {
        super();
        this.maSoNhanVien = "NV001";
        this.phongBan = "Phòng A";
        this.chucVu = "Nhân viên";
        this.heSoLuong = 1.0;
    }

    // Constructor có tham số
    public NhanVien(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD,
                    String maSoNhanVien, String phongBan, String chucVu, double heSoLuong) {
        super(hoTen, namSinh, gioiTinh, diaChi, soCCCD);
        this.maSoNhanVien = maSoNhanVien;
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
    }

    // Nhập thông tin nhân viên
    @Override
    public void nhap() {
        super.nhap(); // Nhập thông tin từ lớp Người
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số nhân viên: ");
        this.maSoNhanVien = scanner.nextLine();
        System.out.print("Nhập phòng ban: ");
        this.phongBan = scanner.nextLine();
        System.out.print("Nhập chức vụ: ");
        this.chucVu = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        this.heSoLuong = scanner.nextDouble();
    }

    // Xuất thông tin nhân viên
    @Override
    public void xuat() {
        super.xuat(); // Xuất thông tin từ lớp Người
        System.out.printf("Mã số nhân viên: %s, Phòng ban: %s, Chức vụ: %s, Hệ số lương: %.2f, Lương: %.2f%n",
                maSoNhanVien, phongBan, chucVu, heSoLuong, tinhLuong());
    }

    // Tính lương
    public double tinhLuong() {
        double heSoPhuCap = 0;
        switch (chucVu) {
            case "Giám đốc":
                heSoPhuCap = 1.0;
                break;
            case "Phó Giám đốc":
                heSoPhuCap = 0.75;
                break;
            case "Trưởng phòng":
                heSoPhuCap = 0.5;
                break;
            case "Phó Trưởng phòng":
                heSoPhuCap = 0.35;
                break;
            default:
                heSoPhuCap = 0.0;
                break;
        }
        return heSoLuong * 1800000 + heSoPhuCap * 1800000;
    }

    // Getter cho mã số nhân viên
    public String getMaSoNhanVien() {
        return maSoNhanVien;
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<NhanVien> danhSach = new ArrayList<>();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline

        // Nhập vào danh sách nhân viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhân viên " + (i + 1) + ":");
            NhanVien nhanVien = new NhanVien(); // Khởi tạo với giá trị mặc định
            nhanVien.nhap();
            danhSach.add(nhanVien);
        }

        // In danh sách và lương nhân viên
        System.out.println("Danh sách nhân viên và lương:");
        for (NhanVien nv : danhSach) {
            nv.xuat();
        }

        // Tìm thông tin theo mã số nhân viên
        System.out.print("Nhập mã số nhân viên cần tìm: ");
        String maSoTim = scanner.nextLine();
        boolean found = false;

        for (NhanVien nv : danhSach) {
            if (nv.getMaSoNhanVien().equalsIgnoreCase(maSoTim)) {
                System.out.println("Thông tin nhân viên có mã số " + maSoTim + ":");
                nv.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên với mã số " + maSoTim);
        }

        scanner.close(); // Đóng scanner
    }
}

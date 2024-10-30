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

// Lớp Sinh viên kế thừa từ lớp Người
class SinhVien extends Nguoi {
    private String maSoSinhVien; // Mã số sinh viên
    private String lop; // Lớp
    private double diemTrungBinh; // Điểm trung bình toàn khóa

    // Constructor không tham số
    public SinhVien() {
        super();
        this.maSoSinhVien = "SV001";
        this.lop = "12A1";
        this.diemTrungBinh = 0.0;
    }

    // Constructor có tham số
    public SinhVien(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD,
                    String maSoSinhVien, String lop, double diemTrungBinh) {
        super(hoTen, namSinh, gioiTinh, diaChi, soCCCD);
        this.maSoSinhVien = maSoSinhVien;
        this.lop = lop;
        this.diemTrungBinh = diemTrungBinh;
    }

    // Nhập thông tin sinh viên
    @Override
    public void nhap() {
        super.nhap(); // Nhập thông tin từ lớp Người
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số sinh viên: ");
        this.maSoSinhVien = scanner.nextLine();
        System.out.print("Nhập lớp: ");
        this.lop = scanner.nextLine();
        System.out.print("Nhập điểm trung bình toàn khóa: ");
        this.diemTrungBinh = scanner.nextDouble();
    }

    // Xuất thông tin sinh viên
    @Override
    public void xuat() {
        super.xuat(); // Xuất thông tin từ lớp Người
        System.out.printf("Mã số sinh viên: %s, Lớp: %s, Điểm trung bình: %.2f, Xếp loại: %s%n",
                maSoSinhVien, lop, diemTrungBinh, xepLoai());
    }

    // Phương thức xếp loại tốt nghiệp
    public String xepLoai() {
        if (diemTrungBinh >= 9.0) {
            return "Xuất sắc";
        } else if (diemTrungBinh >= 8.0) {
            return "Giỏi";
        } else if (diemTrungBinh >= 7.0) {
            return "Khá";
        } else if (diemTrungBinh >= 5.5) {
            return "Trung bình";
        } else {
            return "Không đạt";
        }
    }

    // Getter cho mã số sinh viên
    public String getMaSoSinhVien() {
        return maSoSinhVien;
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SinhVien> danhSach = new ArrayList<>();

        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline

        // Nhập vào danh sách sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên " + (i + 1) + ":");
            SinhVien sinhVien = new SinhVien(); // Khởi tạo với giá trị mặc định
            sinhVien.nhap();
            danhSach.add(sinhVien);
        }

        // In danh sách và kết quả xếp loại tốt nghiệp
        System.out.println("Danh sách sinh viên và kết quả xếp loại:");
        for (SinhVien sv : danhSach) {
            sv.xuat();
        }

        // Tìm thông tin theo mã số sinh viên
        System.out.print("Nhập mã số sinh viên cần tìm: ");
        String maSoTim = scanner.nextLine();
        boolean found = false;

        for (SinhVien sv : danhSach) {
            if (sv.getMaSoSinhVien().equalsIgnoreCase(maSoTim)) {
                System.out.println("Thông tin sinh viên có mã số " + maSoTim + ":");
                sv.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với mã số " + maSoTim);
        }

        scanner.close(); // Đóng scanner
    }
}

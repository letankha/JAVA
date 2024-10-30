import java.util.ArrayList;
import java.util.Scanner;

// Lớp Người
class Nguoi9 {
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String diaChi;
    private String soCCCD;

    // Constructor không tham số
    public Nguoi9() {
        this.hoTen = "Nguyen Van A";
        this.namSinh = 2000;
        this.gioiTinh = "Nam";
        this.diaChi = "Ha Noi";
        this.soCCCD = "123456789";
    }

    // Constructor có tham số
    public Nguoi9(String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
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

    // Getter cho số CCCD
    public String getSoCCCD() {
        return soCCCD;
    }
}

// Lớp DanhBa kế thừa từ lớp Nguoi
class DanhBa1 extends Nguoi {
    private String soDienThoai;
    private int soPhutGoi;

    // Constructor kế thừa
    public DanhBa1(String soDienThoai, int soPhutGoi, String hoTen, int namSinh, String gioiTinh, String diaChi, String soCCCD) {
        super(hoTen, namSinh, gioiTinh, diaChi, soCCCD);
        this.soDienThoai = soDienThoai;
        this.soPhutGoi = soPhutGoi;
    }

    // Nhập thông tin
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        this.soDienThoai = scanner.nextLine();
        super.nhap();
        System.out.print("Nhập số phút gọi: ");
        this.soPhutGoi = scanner.nextInt();
    }

    // Xuất thông tin
    public void xuat() {
        System.out.printf("Số điện thoại: %s, ", soDienThoai);
        super.xuat();
        System.out.printf("Số phút gọi: %d, Cước chưa thuế: %.2f%n", soPhutGoi, tinhCuoc());
    }

    // Tính cước điện thoại chưa có thuế
    public double tinhCuoc() {
        double cuocThueBao = 27000; // Cước thuê bao
        double cuocPhutGoi = 0;

        if (soPhutGoi <= 200) {
            cuocPhutGoi = soPhutGoi * 120;
        } else if (soPhutGoi <= 1000) {
            cuocPhutGoi = 200 * 120 + (soPhutGoi - 200) * 80;
        } else {
            cuocPhutGoi = 200 * 120 + 800 * 80 + (soPhutGoi - 1000) * 40;
        }

        return cuocThueBao + cuocPhutGoi;
    }

    // Getter cho số điện thoại
    public String getSoDienThoai() {
        return soDienThoai;
    }
}

// Lớp Main
public class baitap7_89 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DanhBa> danhSach = new ArrayList<>();
        double tongTien = 0;

        System.out.print("Nhập số lượng thuê bao điện thoại: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline

        // Nhập vào danh sách
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin thuê bao " + (i + 1) + ":");
            DanhBa1 danhBa1 = new DanhBa1("", 0, "", 0, "", "", ""); // Khởi tạo với giá trị mặc định
            danhBa1.nhap();

            tongTien += danhBa1.tinhCuoc();
        }

        // In danh sách và tổng tiền
        System.out.println("Danh sách thuê bao điện thoại:");
        for (DanhBa db : danhSach) {
            db.xuat();
        }
        System.out.printf("Tổng số tiền thu được: %.2f%n", tongTien);

        // Tìm thông tin theo số điện thoại
        System.out.print("Nhập số điện thoại cần tìm: ");
        String soDienThoaiTim = scanner.nextLine();
        boolean found = false;

        for (DanhBa db : danhSach) {
            if (db.getSoDienThoai().equals(soDienThoaiTim)) {
                System.out.println("Thông tin thuê bao:");
                db.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy số điện thoại.");
        }

        scanner.close(); // Đóng scanner
    }
}

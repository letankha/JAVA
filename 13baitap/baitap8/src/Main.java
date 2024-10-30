import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Date {
    private int ngay;
    private int thang;
    private int nam;

    // Hàm khởi tạo không tham số
    public Date() {
        this.ngay = 1;
        this.thang = 1;
        this.nam = 2000;
    }

    // Hàm khởi tạo có tham số
    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    // Phương thức nhập ngày
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        this.ngay = scanner.nextInt();
        System.out.print("Nhập tháng: ");
        this.thang = scanner.nextInt();
        System.out.print("Nhập năm: ");
        this.nam = scanner.nextInt();
    }

    // Phương thức xuất ngày
    public void xuat() {
        System.out.printf("%02d/%02d/%04d\n", ngay, thang, nam);
    }

    // Getter cho năm
    public int getNam() {
        return nam;
    }
}

class Nguoi extends Date {
    private String hoLot;
    private String ten;
    private String diaChi;
    private String soCCCD;

    // Hàm khởi tạo không tham số
    public Nguoi() {
        super();
        this.hoLot = "";
        this.ten = "";
        this.diaChi = "";
        this.soCCCD = "";
    }

    // Hàm khởi tạo có tham số
    public Nguoi(String hoLot, String ten, String diaChi, String soCCCD, int ngay, int thang, int nam) {
        super(ngay, thang, nam);
        this.hoLot = hoLot;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soCCCD = soCCCD;
    }

    // Phương thức nhập thông tin người
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ lót: ");
        this.hoLot = scanner.nextLine();
        System.out.print("Nhập tên: ");
        this.ten = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.print("Nhập số CCCD: ");
        this.soCCCD = scanner.nextLine();
        System.out.println("Nhập ngày sinh:");
        super.nhap();
    }

    // Phương thức xuất thông tin người
    public void xuat() {
        System.out.printf("Họ lót: %s, Tên: %s, Địa chỉ: %s, Số CCCD: %s, Ngày sinh: ", hoLot, ten, diaChi, soCCCD);
        super.xuat();
    }

    // Getter cho số CCCD
    public String getSoCCCD() {
        return soCCCD;
    }

    // Getter cho tên đầy đủ
    public String getTenDayDu() {
        return hoLot + " " + ten;
    }
}

class QuanLyNguoi {
    private ArrayList<Nguoi> danhSachNguoi;

    // Hàm khởi tạo
    public QuanLyNguoi() {
        danhSachNguoi = new ArrayList<>();
    }

    // Thêm người vào danh sách
    public void themNguoi() {
        Nguoi nguoi = new Nguoi();
        nguoi.nhap();
        danhSachNguoi.add(nguoi);
        System.out.println("Thêm người thành công!");
    }

    // Hiển thị tất cả người trong danh sách
    public void hienThiTatCaNguoi() {
        System.out.println("Danh sách người đã đăng ký:");
        for (Nguoi nguoi : danhSachNguoi) {
            nguoi.xuat();
            System.out.println("-------------------------------");
        }
    }

    // Tìm và in thông tin người theo CCCD
    public void timNguoiTheoCCCD() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số CCCD để tìm: ");
        String cccd = scanner.nextLine();
        boolean found = false;

        for (Nguoi nguoi : danhSachNguoi) {
            if (nguoi.getSoCCCD().equals(cccd)) {
                nguoi.xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy người với CCCD: " + cccd);
        }
    }

    // Sắp xếp và hiển thị danh sách theo thứ tự chữ cái
    public void sapXepTheoTen() {
        Collections.sort(danhSachNguoi, new Comparator<Nguoi>() {
            @Override
            public int compare(Nguoi o1, Nguoi o2) {
                return o1.getTenDayDu().compareToIgnoreCase(o2.getTenDayDu());
            }
        });

        System.out.println("Danh sách người sắp xếp theo thứ tự chữ cái:");
        hienThiTatCaNguoi();
    }

    public static void main(String[] args) {
        QuanLyNguoi qlNguoi = new QuanLyNguoi();
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\nChương trình quản lý người");
            System.out.println("1. Nhập thông tin người");
            System.out.println("2. Hiển thị danh sách người");
            System.out.println("3. Tìm thông tin người theo CCCD");
            System.out.println("4. Sắp xếp và hiển thị danh sách theo thứ tự chữ cái");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Xử lý dòng mới

            switch (luaChon) {
                case 1:
                    qlNguoi.themNguoi();
                    break;
                case 2:
                    qlNguoi.hienThiTatCaNguoi();
                    break;
                case 3:
                    qlNguoi.timNguoiTheoCCCD();
                    break;
                case 4:
                    qlNguoi.sapXepTheoTen();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (luaChon != 5);
    }
}
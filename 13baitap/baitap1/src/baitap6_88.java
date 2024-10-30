class MyPham {
    protected String tenmp;
    protected String nhasx;
    protected int dongia;

    // Constructor không tham số
    public MyPham() {
        this.tenmp = "Tên mỹ phẩm";
        this.nhasx = "Nhà sản xuất";
        this.dongia = 100000; // Giá mặc định
    }

    // Constructor có tham số
    public MyPham(String tenmp, String nhasx, int dongia) {
        this.tenmp = tenmp;
        this.nhasx = nhasx;
        this.dongia = dongia;
    }

    // Phương thức tính giá bán
    public float giaBan() {
        return dongia + (dongia * 0.05f); // Giá bán = giá gốc + 5%
    }

    // Phương thức tính thành tiền
    public float thanhTien(int soluong) {
        return soluong * dongia; // Thành tiền = số lượng * giá gốc
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.printf("Tên mỹ phẩm: %s, Nhà sản xuất: %s, Đơn giá: %d%n", tenmp, nhasx, dongia);
    }
}

class DauGoi extends MyPham {
    // Constructor kế thừa
    public DauGoi(String tenmp, String nhasx, int dongia) {
        super(tenmp, nhasx, dongia);
    }

    // Ghi đè phương thức giaBan
    @Override
    public float giaBan() {
        return dongia * 1.5f; // Giá bán = giá gốc * 1.5
    }

    // Ghi đè phương thức thanhTien
    @Override
    public float thanhTien(int soluong) {
        return super.thanhTien(soluong) * 1.05f; // Thành tiền nhân thêm 5% thuế VAT
    }
}

public class baitap6_88 {
    public static void main(String[] args) {
        // Tạo đối tượng MyPham
        MyPham myPham = new MyPham("Son môi", "Công ty A", 50000);
        myPham.display();
        System.out.printf("Giá bán: %.2f%n", myPham.giaBan());
        System.out.printf("Thành tiền cho 3 sản phẩm: %.2f%n", myPham.thanhTien(3));

        // Tạo đối tượng DauGoi
        DauGoi dauGoi = new DauGoi("Dầu gội", "Công ty B", 70000);
        dauGoi.display();
        System.out.printf("Giá bán: %.2f%n", dauGoi.giaBan());
        System.out.printf("Thành tiền cho 2 sản phẩm: %.2f%n", dauGoi.thanhTien(2));
    }
}

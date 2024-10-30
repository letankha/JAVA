class SinhVien {
    private String hoten;
    private String mssv;
    private String lop;

    // Khởi tạo mặc định
    public SinhVien() {
        this.hoten = "Nguyen Van A";
        this.mssv = "123456";
        this.lop = "CTK34";
    }

    // Khởi tạo với tham số
    public SinhVien(String hoten, String mssv, String lop) {
        this.hoten = hoten;
        this.mssv = mssv;
        this.lop = lop;
    }

    // Phương thức lấy họ tên
    public String getHoten() {
        return hoten;
    }

    // Phương thức lấy mã số sinh viên
    public String getMssv() {
        return mssv;
    }

    // Phương thức lấy lớp
    public String getLop() {
        return lop;
    }
}

public class baitap5_88 {
    public static void main(String[] args) {
        // Tạo đối tượng SinhVien với giá trị mặc định
        SinhVien sv1 = new SinhVien();
        System.out.println("Thông tin sinh viên 1:");
        System.out.println("Họ tên: " + sv1.getHoten());
        System.out.println("MSSV: " + sv1.getMssv());
        System.out.println("Lớp: " + sv1.getLop());

        // Tạo đối tượng SinhVien với giá trị nhập từ người dùng
        SinhVien sv2 = new SinhVien("Tran Thi B", "654321", "CTK35");
        System.out.println("\nThông tin sinh viên 2:");
        System.out.println("Họ tên: " + sv2.getHoten());
        System.out.println("MSSV: " + sv2.getMssv());
        System.out.println("Lớp: " + sv2.getLop());
    }
}

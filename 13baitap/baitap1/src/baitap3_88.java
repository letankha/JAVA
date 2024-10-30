import java.util.Scanner;



    class Date {
        private int day;
        private int month;
        private int year;


        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        // Hàm nhập giá trị
        public void input() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập ngày: ");
            this.day = scanner.nextInt();
            System.out.print("Nhập tháng: ");
            this.month = scanner.nextInt();
            System.out.print("Nhập năm: ");
            this.year = scanner.nextInt();
        }

        // Hàm hiện thông tin
        public void display() {
            System.out.printf("%02d/%02d/%04d%n", day, month, year);
        }

        // Hàm kiểm tra xem ngày có hợp lệ hay không
        public boolean isValid() {
            if (year < 1) return false; // Năm phải lớn hơn 0
            if (month < 1 || month > 12) return false; // Tháng phải từ 1 đến 12

            // Số ngày trong từng tháng
            int[] daysInMonth = {31, isLeapYear() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            return day > 0 && day <= daysInMonth[month - 1]; // Kiểm tra ngày
        }

        // Hàm kiểm tra năm nhuận
        private boolean isLeapYear() {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }

    public class baitap3_88 {
        public static void main(String[] args) {
            // Tạo Date với giá trị 09/09/2005
            Date date1 = new Date(9, 9, 2005);
            System.out.print("Ngày Date 1: ");
            date1.display();

            // Tạo Date với giá trị nhập từ bàn phím
            Date date2 = new Date(0, 0, 0); // Khởi tạo với giá trị mặc định
            date2.input();
            System.out.print("Ngày Date 2: ");
            date2.display();


            if (date2.isValid()) {
                System.out.println("Date 2 hợp lệ.");
            } else {
                System.out.println("Date 2 không hợp lệ.");
            }
        }
    }



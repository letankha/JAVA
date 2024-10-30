import java.util.ArrayList;
import java.util.Scanner;

// Lớp Clock
class Clock {
    private int hour;
    private int minute;
    private int second;

    // Constructor không tham số
    public Clock() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // Constructor có tham số
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Nhập thông tin giờ
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giờ: ");
        this.hour = scanner.nextInt();
        System.out.print("Nhập phút: ");
        this.minute = scanner.nextInt();
        System.out.print("Nhập giây: ");
        this.second = scanner.nextInt();
    }

    // Xuất thông tin giờ
    public void display() {
        System.out.printf("%02d:%02d:%02d", hour, minute, second);
    }

    // Getter cho giờ
    public int getHour() {
        return hour;
    }

    // Getter cho phút
    public int getMinute() {
        return minute;
    }

    // Getter cho giây
    public int getSecond() {
        return second;
    }
}

// Lớp Chuyến bay kế thừa từ lớp Clock
class Flight extends Clock {
    private String flightCode; // Mã số chuyến bay
    private String airline; // Hãng hàng không

    // Constructor không tham số
    public Flight() {
        super();
        this.flightCode = "XXX";
        this.airline = "Unknown Airline";
    }

    // Constructor có tham số
    public Flight(String flightCode, String airline, int hour, int minute, int second) {
        super(hour, minute, second);
        this.flightCode = flightCode;
        this.airline = airline;
    }

    // Nhập thông tin chuyến bay
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số chuyến bay: ");
        this.flightCode = scanner.nextLine();
        System.out.print("Nhập hãng hàng không: ");
        this.airline = scanner.nextLine();
        System.out.println("Nhập giờ bay:");
        super.input();
    }

    // Xuất thông tin chuyến bay
    public void display() {
        System.out.printf("Mã chuyến bay: %s, Hãng hàng không: %s, Giờ bay: ", flightCode, airline);
        super.display();
        System.out.println();
    }

    // Getter cho mã chuyến bay
    public String getFlightCode() {
        return flightCode;
    }

    // So sánh giờ bay với chuyến bay khác
    public boolean isSameTime(Flight other) {
        return this.getHour() == other.getHour() &&
                this.getMinute() == other.getMinute() &&
                this.getSecond() == other.getSecond();
    }
}

// Lớp Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Flight> flightList = new ArrayList<>();

        System.out.print("Nhập số lượng chuyến bay: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline

        // Nhập vào danh sách chuyến bay
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin chuyến bay " + (i + 1) + ":");
            Flight flight = new Flight(); // Khởi tạo với giá trị mặc định
            flight.input();
            flightList.add(flight);
        }

        // In danh sách chuyến bay
        System.out.println("Danh sách các chuyến bay:");
        for (Flight flight : flightList) {
            flight.display();
        }

        // Tìm chuyến bay theo mã số
        System.out.print("Nhập mã số chuyến bay cần tìm: ");
        String flightCodeToFind = scanner.nextLine();
        boolean found = false;

        for (Flight flight : flightList) {
            if (flight.getFlightCode().equalsIgnoreCase(flightCodeToFind)) {
                System.out.println("Giờ bay của chuyến bay " + flightCodeToFind + " là: ");
                flight.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy chuyến bay với mã số " + flightCodeToFind);
        }

        // In danh sách chuyến bay có cùng giờ bay
        System.out.println("Các chuyến bay có cùng giờ bay:");
        for (Flight flight1 : flightList) {
            for (Flight flight2 : flightList) {
                if (flight1 != flight2 && flight1.isSameTime(flight2)) {
                    flight1.display();
                    break;
                }
            }
        }

        scanner.close(); // Đóng scanner
    }
}

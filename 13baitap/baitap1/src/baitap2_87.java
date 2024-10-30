import java.util.Scanner;

class Clock {
    private int gio;
    private int phut;
    private int giay;


    public Clock(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
        roundTime();
    }


    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap gio: ");
        this.gio = scanner.nextInt();
        System.out.print("Nhap phut: ");
        this.phut = scanner.nextInt();
        System.out.print("Nhap giay: ");
        this.giay = scanner.nextInt();
        roundTime();
    }


    public void print() {
        System.out.printf("%02d:%02d:%02d%n", gio, phut, giay);
    }


    private void roundTime() {

        if (giay >= 60) {
            phut += giay / 60;
            giay = giay % 60;
        }

        if (phut >= 60) {
            gio += phut / 60;
            phut = phut % 60;
        }

        if (gio >= 24) {
            gio = gio % 24;
        }
    }
}

public class baitap2_87 {
    public static void main(String[] args) {
        // Tạo Clock với giá trị 9:15:38
        Clock clock1 = new Clock(13, 40, 38);
        System.out.print("Thoi gian Clock 1: ");
        clock1.print();

        // Tạo Clock với giá trị nhập từ bàn phím
        Clock clock2 = new Clock(0, 0, 0); // Khởi tạo với giá trị mặc định
        clock2.nhap();
        System.out.print("Thoi gian Clock 2: ");
        clock2.print();

        // In ra thời gian sau khi làm tròn
        System.out.print("Thoi gian Clock 2 sau khi lam tron: ");
        clock2.print();
    }
}

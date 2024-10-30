import java.util.Scanner;

class Diem {
   private int x , y;


    public void Gan(int hoanh, int tung) {
        this.x = hoanh;
        this.y = tung;
    }


    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap hoanh do: ");
        this.x = scanner.nextInt();
        System.out.print("Nhap tung do: ");
        this.y = scanner.nextInt();
    }


    public void Indiem() {
        System.out.println("(" + x + ", " + y + ")");
    }


    public int PutX() {
        return x;
    }

    public int PutY() {
        return y;
    }
}

public class baitap1_87{
    public static void main(String[] args) {

        Diem A = new Diem();
        A.Gan(3, 4);
        System.out.print("Toa do diem A: ");
        A.Indiem();


        Diem B = new Diem();
        B.Nhap();
        System.out.print("Toa do diem B: ");
        B.Indiem();


        Diem C = new Diem();
        C.Gan(-B.PutX(), -B.PutY());
        System.out.print("Toa do diem C (doi xung diem B qua goc toa do): ");
        C.Indiem();

        double distanceBToOrigin = Math.sqrt(B.PutX() * B.PutX() + B.PutY() * B.PutY());
        System.out.println("Khoang cach tu diem B den goc toa do: " + distanceBToOrigin);
    }
}

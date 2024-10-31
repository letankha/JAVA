import java.util.Scanner;
public class dongcot {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int sodong, socot;
        float sum=0;
        System.out.println("nhap so dong: ");
        sodong = nhap.nextInt();
        System.out.println("nhap so cot: ");
        socot = nhap.nextInt();

        int[][] A = new int[sodong][socot];
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++) {
                System.out.print("Nhap phan tu [" + i + ", " + j + "]: ");
                A[i][j] = nhap.nextInt();
            }
        }
        System.out.println("Mang vua nhap: ");
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println("\n");
        }
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++) {

                sum = sum+A[i][j];
            }
        }
        System.out.println("so chan: ");
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++) {
                if(A[i][j]%2==0)
                    System.out.format("%3d",A[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("so le: ");
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++) {
                if(A[i][j]%2!=0)
                    System.out.format("%3d",A[i][j]);
            }
            System.out.println("\n");
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++)
            {
                if (A[i][j] > max)
                    max = A[i][j];
            }
        }

        int min= Integer.MAX_VALUE;
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < socot; j++)
            {
                if (A[i][j] < min)
                    min = A[i][j];
            }
        }
        System.out.format("%.2f",sum/(sodong*socot));
        System.out.format("\nSo lon nhat trong mang la: %d",max);
        System.out.format("\nSo nho nhat trong mang la: %d",min);


        //System.out.println("Trung binh cong: "+sum/(sodong*socot));

    }
}
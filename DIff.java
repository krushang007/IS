import java.util.Scanner;

public class DIff {
    public static void main(String[] args) {
        long p,q,a,b;
        // p = 6
        // q = 3
        // q is primitive root of p
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter p : ");
        p=sc.nextLong();
        System.out.println("Enter q : ");
        q=sc.nextLong();
        System.out.println("user 1 private key : ");
        // 21
        a=sc.nextLong();
        System.out.println("user 2 private key : ");
        // 15
        b=sc.nextLong();
        double u1=Math.pow(p,a )%q;
        double u2=Math.pow(p,b )%q;
        System.out.println("user 1 public key : "+u1);
        System.out.println("user 2 public key : "+u2);
        System.out.println("-------------------------------------");
        System.out.println("User 1 secret key : "+Math.pow(u2, a)%q);
        System.out.println("User 2 secret key : "+Math.pow(u1, b)%q);
    }
}

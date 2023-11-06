import java.util.Scanner;

public class myRSA {
    static Double getD(Double e,Double pie)
    {
        Double d=0.0;
        for(Double i=1.0;i<pie;i++)
        {
            if((e * i) % pie == 1)
            {
                System.out.println(e+" "+i+" "+pie);
                d=i;
                break;
            }
        }
        return d;
    }
    public static void main(String[] args) {
        Double p,q,e;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter p : ");
        p=sc.nextDouble();
        System.out.println("Enter q : ");
        q=sc.nextDouble();
        Double n=p*q;
        System.out.println("Enter public exponent : ");
        e=sc.nextDouble();
        System.out.println("Enter plain text : ");
        Double P=sc.nextDouble();
        Double pie=(p-1)*(q-1);
        Double d=getD(e,pie);
        System.out.println("Public key (e,n) is  : "+"("+e+","+n+")");
        System.out.println("Public key (ed,n) is  : "+"("+d+","+n+")");
        // e *d % pie ==1
        System.out.println("Encrypted text is : ");
        Double D=Math.pow(P,e)%n;
        System.out.println(P+"^"+e+"%"+n+" is : "+D);
        System.out.println("Decrypted text is : ");
        System.out.println(D+"^"+d+"%"+n+" is : "+Math.pow(D, d)%n);
    }
}

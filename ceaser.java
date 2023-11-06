import java.util.Scanner;

public class ceaser
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int key;
        String plainText,CipherText="";
        System.out.println("Enter plain text : ");
        plainText=sc.next();
        plainText=plainText.toUpperCase();
        System.out.println("Enter key : ");
        key=sc.nextInt();
        for(int i=0;i<plainText.length();i++)
        {
           char ch=plainText.charAt(i);
           int ind=(int)(ch+key)%65+65;
           char cd=(char)ind;
           CipherText+=cd;
        }
        System.out.println("Cipher text is  : "+CipherText);
    }
}
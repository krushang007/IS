import java.util.Scanner;

public class monoalpha {
    public static void main(String[] args) {
        String plainText="",cipherText="";
        char arr[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char arr2[]={'G','H','I','J','K','L','M','A','B','C','D','E','F','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Plain text : ");
        plainText=sc.nextLine();
        plainText=plainText.toUpperCase();
        for(int i=0;i<plainText.length();i++)
        {
            char ch=plainText.charAt(i);
            int ind=(int)ch-'A';
            char cd=arr2[ind];
            cipherText+=cd;
        }
        System.out.println("Cipher text is : "+cipherText);
        String Plaintext="";
        String findString=new String(arr2);
        findString=findString.toUpperCase();
        for(int i=0;i<cipherText.length();i++)
        {
            char ch=cipherText.charAt(i);
            int ind=findString.indexOf(ch);
            char cd=arr[ind];
            Plaintext+=cd;
        }
        System.out.println("Plain text is : "+Plaintext);
    }
}

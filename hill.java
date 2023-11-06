import java.util.Scanner;

public class hill {
    static String multiply(int mat[][],int arr[])
    {
        String temp="";
        for(int i=0;i<mat.length;i++)
        {
            int x=0;
            for(int j=0;j<mat.length;j++)
            {
                x+=mat[i][j]*arr[j];
            }
            char ch=(char)(x%26+'a');
            temp+=ch;
        }

        return temp;
    }

    public static void main(String[] args) {

        String plaintext="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter matrix size : ");
        int size=sc.nextInt();
        int mat[][]=new int[size][size];
        System.out.println("Enter matrix values : ");
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter plain text : ");
        plaintext=sc.next();
        if(plaintext.length()%size!=0)
        {
            int x=size-plaintext.length()%size;
            for(int i=0;i<x;i++)
            {
                plaintext+='x';
            }
        }
        String cipString="";
        for(int i=0;i<plaintext.length();i+=size)
        {
            int arr[]=new int[size];
            String temp=plaintext.substring(i, i+size);
            for(int j=0;j<size;j++)
            {
                char ch=temp.charAt(j);
                int index=(int)ch-'a';
                arr[j]=index;
            }
            cipString+=(multiply(mat, arr));
        }
        System.out.println("Cipher text is : "+cipString);
        
    }
}

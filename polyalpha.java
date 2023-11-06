import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.util.Scanner;

public class polyalpha
{
    public static String fileRead(String path) throws Exception
    {
        String content="";
        File f=new File(path);
        Scanner sc=new Scanner(f);
        while(sc.hasNextLine())
        {
            content+=sc.next();
        }
        return content;
    }
    public static void vigener() throws Exception
    { 
        String plainText=fileRead("input.txt"),key;
        Scanner st=new Scanner(System.in);
        System.out.println("Enter Key : ");
        key=st.next();
        String arr[]=new String[1024];
        arr=plainText.split(" ");
        plainText="";
        for(int i=0;i<arr.length;i++)
        {
            plainText+=arr[i];
        }
        System.out.println("Plain Text : "+plainText);  
        key=key.toUpperCase();
        plainText=plainText.toUpperCase();
        while(key.length()<plainText.length())
        {
            key+=key;
        }
        String cipher="";
        for(int i=0;i<plainText.length();i++)
        {
            char plainVal,keyVal,cipherVal;
            plainVal=plainText.charAt(i);
            keyVal=key.charAt(i);
            int ascii=((int)plainVal+(int)keyVal-2*'A')%26;
            cipherVal=(char)(ascii+65);
            cipher+=cipherVal;
        }
        System.out.println("Cipher Text : "+cipher);
        File wr=new File("output.txt");
        FileWriter fw=new FileWriter(wr);
        fw.write(cipher);
        fw.close();
        String decyptedText="";
        for(int i=0;i<cipher.length();i++)
        {
            char plainVal,keyVal,cipherVal;
            cipherVal=cipher.charAt(i);
            keyVal=key.charAt(i);
            int ascii=((int)cipherVal-(int)keyVal);
            if(ascii<0)
            {
                ascii+=26;
                ascii=ascii%26;
            }
            cipherVal=(char)(ascii+65);
            decyptedText+=cipherVal;
        }
        System.out.println("DECRYPTED TEXT is : "+decyptedText);
    }
    public static void autokey() throws Exception
    {
        String plainText=fileRead("input.txt"),key;
        Scanner st=new Scanner(System.in);
        System.out.println("Enter Key : ");
        key=st.next();
        String arr[]=new String[1024];
        arr=plainText.split(" ");
        plainText="";
        for(int i=0;i<arr.length;i++)
        {
            plainText+=arr[i];
        }
        System.out.println("Plain Text : "+plainText);  
        key=key.toUpperCase();
        plainText=plainText.toUpperCase();
        while(key.length()<plainText.length())
        {
            key+=plainText;
        }
        String cipher="";
        for(int i=0;i<plainText.length();i++)
        {
            char plainVal,keyVal,cipherVal;
            plainVal=plainText.charAt(i);
            keyVal=key.charAt(i);
            int ascii=((int)plainVal+(int)keyVal-2*'A')%26;
            cipherVal=(char)(ascii+65);
            cipher+=cipherVal;
        }
        System.out.println("Cipher Text : "+cipher);
        File wr=new File("output.txt");
        FileWriter fw=new FileWriter(wr);
        fw.write(cipher);
        fw.close();
        String decyptedText="";
        for(int i=0;i<cipher.length();i++)
        {
            char plainVal,keyVal,cipherVal;
            cipherVal=cipher.charAt(i);
            keyVal=key.charAt(i);
            int ascii=((int)cipherVal-(int)keyVal);
            if(ascii<0)
            {
                ascii+=26;
                ascii=ascii%26;
            }
            cipherVal=(char)(ascii+65);
            decyptedText+=cipherVal;
        }
        System.out.println("DECRYPTED TEXT is : "+decyptedText);
    }
    
    public static void main(String[] args) throws Exception{
        
        Scanner sc=new Scanner(System.in);
        int i=3;
        while(i!=0)
        {
        System.out.println("0. Exit");
        System.out.println("1. Vigenere Cipher ");
            System.out.println("2. AutoKey Cipher ");
            System.out.print("Enter your choice : ");
            i=sc.nextInt();
            switch(i)
            {
                case 0 : System.exit(0);
                case 1 : vigener();
                break;
                case 2 : autokey() ;
                break;
                default : System.out.println("Invalid choice !!!!!");
            }
    }
}
}
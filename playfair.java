import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class playfair {
    public static void main(String[] args) {
        char arr[][]=new char[5][5];
        Scanner sc=new Scanner(System.in);
        String key,plaintext;
        int ind[]=new int[26];
        Arrays.fill(ind, 0);
        ind[9]=1;
        System.out.println("Enter Key : ");
        key=sc.nextLine();
        System.out.println("Enter Plain text : ");
        plaintext=sc.nextLine();
        plaintext=plaintext.replaceAll("j", "i");
        int num=0;
            for(int a=0;a<key.length();a++)
            {
                char ch=key.charAt(a);
                int index=(int)ch-97;
                if(ind[index]==0)
                {
                    arr[num/5][num%5]=ch;
                    ind[index]=1;
                    num++;
                }
            }
            for(int i=0;i<26;i++)
            {
                if(ind[i]==0)
                {
                    int index=i+97;
                    arr[num/5][num%5]=(char)index;
                    ind[i]=1;
                    num++;
                }

            }
        String matrix="";
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(arr[i][j]+ " ");
                matrix+=arr[i][j];
            }
            System.out.println();
        }
        System.out.println(matrix);
        int temp=0;
        char parts[][]=new char[plaintext.length()][2];
        for(int i=0;i<plaintext.length();i+=2)
        {
            if(i!=plaintext.length()-1)
            {
                char first=plaintext.charAt(i);
                char second=plaintext.charAt(i+1);
                if(first==second)
                {
                    i--;
                    parts[temp][0]=first;
                    parts[temp][1]='x';
                    temp++;
                }
                else
                {
                    parts[temp][0]=first;
                    parts[temp][1]=second;
                    temp++;
                }
            }
            else if(i==plaintext.length()-1)
            {
                char first=plaintext.charAt(i);
                parts[temp][0]=first;
                    parts[temp][1]='x';
                    temp++;
            }
        }
        // System.out.println("2D matrix is  :  ");
        // for(int i=0;i<temp;i++)
        // {
        //     for(int j=0;j<2;j++)
        //     {
        //         System.out.print(parts[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        String ans=encrypt1String(matrix, parts, temp,arr);
        System.out.println("Answer is  :  "+ans);
    }
     static String encrypt1String(String matrix,char two[][],int temp,char mat[][])
        {
            String cipher="";
            
            for(int i=0;i<temp;i++)
            {
                char first=two[i][0];
                char second=two[i][1];
                int findex=matrix.indexOf(first);
                int sindex=matrix.indexOf(second);
                // same row
                if(findex/5==sindex/5)
                {
                    int a=findex%5;
                    int b=sindex%5;
                    a=(a+1)%5;
                    b=(b+1)%5;
                    cipher+=mat[findex/5][a];
                    cipher+=mat[findex/5][b];
                    System.out.println("Fist is : "+first);
                    System.out.println("second is : "+second);
                     System.out.println("Fist enc  is : "+mat[findex/5][a]);
                    System.out.println("second enc is : "+mat[findex/5][b]);
                }
                // same column
                else if(findex%5==sindex%5)
                {
                    int a=findex/5;
                    int b=sindex/5;
                    a=(a+1)%5;
                    b=(b+1)%5;
                    cipher+=mat[a][findex%5];
                    cipher+=mat[b][findex%5];
                    System.out.print("Fist is : "+first);
                    System.out.println("  second is : "+second);
                     System.out.print("enc  is : "+mat[a][findex%5]);
                    System.out.println("    second enc is : "+mat[b][findex%5]);
                }
                else
                {
                    cipher+=mat[findex/5][sindex%5];
                    cipher+=mat[sindex/5][findex%5];
                    System.out.print("Fist is : "+first);
                    System.out.println("  second is : "+second);
                     System.out.print("enc  is : "+mat[findex/5][sindex%5]);
                    System.out.println("    second enc is : "+mat[sindex/5][findex%5]);
                }
            }
            return cipher;
        }
}

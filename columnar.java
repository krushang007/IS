import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class columnar {

	public static String fileRead(String file) throws FileNotFoundException
	{
		String readData="";
		File f=new File(file);
		Scanner sc=new Scanner(f);
		while(sc.hasNext())
		{
			readData+=sc.next();
		}
		System.out.println("Plain Text is : "+readData);
		sc.close();
		return readData;
	}
	public static void fileWrite(String file,String data) throws IOException
	{
		File f=new File(file);
		FileWriter fr=new FileWriter(f);
		fr.write(data);
		fr.close();
	}
    public static void main(String[] args) throws IOException {
        String PlainText = fileRead("input.txt");
        List<Integer> key = new ArrayList<>(List.of(3, 2, 6, 4, 1, 5));
        String cipherText= encrypt(PlainText, key);
        fileWrite("decrypted.txt",cipherText);
        String plainText= decrypt(cipherText, key);
        fileWrite("encrypted.txt",plainText);
        
    }

    public static List<Integer> analyse(String plainText, String cipherText) {
        Map<Integer, Integer> sortedMap = new HashMap<>();
        plainText = plainText.toLowerCase();
        cipherText = cipherText.toLowerCase();
        double plainTxtSize = plainText.length();

        for (int z = 1; z < Integer.MAX_VALUE; z++) {
            int c = 0;
            double width = z;
            double height = Math.ceil(plainTxtSize / z);
            String[][] pl = new String[(int) height][(int) width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < z; j++) {
                    if (c >= plainTxtSize) {
                        pl[i][j] = "";
                    } else {
                        pl[i][j] = String.valueOf(plainText.charAt(c));
                        c++;
                    }
                }
            }

            List<String> myList = new ArrayList<>();

            for (int i = 0; i < z; i++) {
                StringBuilder word = new StringBuilder();
                for (int j = 0; j < height; j++) {
                    word.append(pl[j][i]);
                }
                myList.add(word.toString());
            }

            if (myList.size() == 7) {
                String d = "";
            }

            boolean correctKey = true;
            String cipherCopy = cipherText;

            sortedMap = new HashMap<>();

            for (int i = 0; i < myList.size(); i++) {
                int x = cipherCopy.indexOf(myList.get(i));
                if (x == -1) {
                    correctKey = false;
                } else {
                    sortedMap.put(x, i + 1);
                    cipherCopy.replace(myList.get(i), "#");
                }
            }

            if (correctKey) {
                break;
            }
        }

        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> newMap = new HashMap<>();

        for (int i = 0; i < sortedMap.size(); i++) {
            newMap.put((Integer) sortedMap.entrySet().toArray(new Map.Entry[0])[i].getValue(), i + 1);
        }

        for (int i = 1; i <= newMap.size(); i++) {
            output.add(newMap.get(i));
        }

        return output;
    }

    public static String decrypt(String cipherText, List<Integer> key) {
        double cipherTxtSize = cipherText.length();
        double width = key.size();
        double height = Math.ceil(cipherTxtSize / width);
        int cnt = 0;

        char[][] arr = new char[(int) height][(int) width];

        Map<Integer, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < key.size(); i++) {
            keyMap.put(key.get(i) - 1, i);
        }

        int numberOfFullColumns = cipherText.length() % key.size();

        for (int i = 0; i < key.size(); i++) {
            for (int k = 0; k < height; k++) {
                if (numberOfFullColumns != 0 && k == height - 1 && keyMap.get(i) >= numberOfFullColumns) {
                    continue;
                }

                arr[k][keyMap.get(i)] = cipherText.charAt(cnt);
                cnt++;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                builder.append(arr[i][j]);
            }
        }

        String result = builder.toString().toUpperCase();
        System.out.println("Decrypted text : "+result);
        return result;
    }

    public static String encrypt(String plainText, List<Integer> key) {
        double plainTxtSize = plainText.length();
        double width = key.size();
        double height = Math.ceil(plainTxtSize / width);
        int c = 0;
        char[][] pl = new char[(int) height][(int) width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (c >= plainTxtSize) {
                    pl[i][j] = 'x';
                } else {
                    pl[i][j] = plainText.charAt(c);
                    c++;
                }
            }
        }

        Map<Integer, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < key.size(); i++) {
            keyMap.put(key.get(i) - 1, i);
        }

        StringBuilder myCipherText = new StringBuilder();

        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < height; j++) {
                myCipherText.append(pl[j][keyMap.get(i)]);
            }
        }

        String result = myCipherText.toString().toUpperCase();
        System.out.println("Encrypted text : "+ result);
        return result;
    }
}

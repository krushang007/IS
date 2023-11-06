import java.io.*;
import java.math.BigInteger;
import java.util.Random;
public class keyexchange {
 public static void main(String[] args) {
 BigInteger p, g, a, b;
 String inputFile = "input.txt";
 String outputFile = "output.txt";
 try {
 BufferedReader reader = new BufferedReader(new FileReader(inputFile));
 // Read prime modulus (p) and primitive root (g) from input file
 p = new BigInteger(reader.readLine());
 g = new BigInteger(reader.readLine());
 // Generate random secret keys for Alice and Bob
 a = generateRandomKey(p.subtract(BigInteger.ONE)); // a should be in the range [1, p-2]
 b = generateRandomKey(p.subtract(BigInteger.ONE)); // b should be in the range [1, p-2];
 // Calculate public keys for Alice and Bob
 BigInteger A = g.modPow(a, p);
 BigInteger B = g.modPow(b, p);
 // Write public keys to the output file
 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
 writer.write("Alice's Private Key (a):\n" + a.toString() + "\n");
 writer.write("Bob's Private Key (b):\n" + b.toString() + "\n");
 writer.write("Alice's Public Key (A):\n" + A.toString() + "\n");
 writer.write("Bob's Public Key (B):\n" + B.toString() + "\n");
 // Calculate the shared secret key
 BigInteger secretKeyA = B.modPow(a, p);
 BigInteger secretKeyB = A.modPow(b, p);
 // Ensure that both shared keys match
 if (secretKeyA.equals(secretKeyB)) {
 writer.write("Shared Secret Key (s):\n" + secretKeyA.toString() + "\n");
 } else {
 System.err.println(
 "Key exchange failed. Shared secret keys do not match."
 );
 }
 writer.close();
 reader.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 public static BigInteger generateRandomKey(BigInteger max) {
 Random rand = new Random();
 BigInteger result;
 do {
 result = new BigInteger(max.bitLength(), rand);
 } while (
 result.compareTo(BigInteger.ONE) <= 0 || result.compareTo(max) >= 0
 );
 return result;
 }
}

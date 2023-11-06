import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;
public class RSA {
 private static final String PUBLIC_KEY_FILE = "public.key";
 private static final String PRIVATE_KEY_FILE = "private.key";
 public static void main(String[] args) throws Exception {
 String plainText = readFile("input.txt");
 // Generate public-private key pair
 KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
 keyPairGenerator.initialize(2048);
 KeyPair keyPair = keyPairGenerator.generateKeyPair();
 // Extract public and private keys
 PublicKey publicKey = keyPair.getPublic();
 PrivateKey privateKey = keyPair.getPrivate();
 // Write public and private keys to files
 saveKey(PUBLIC_KEY_FILE, publicKey.getEncoded());
 saveKey(PRIVATE_KEY_FILE, privateKey.getEncoded());
 // Encrypt the plain text
 byte[] encryptedText = encrypt(
 plainText.getBytes(StandardCharsets.UTF_8),
 publicKey
 );
 // Write the encrypted text to a file
 writeFile(
 "encrypted.txt",
 Base64.getEncoder().encodeToString(encryptedText)
 );
 // Decrypt the encrypted text
 byte[] decryptedText = decrypt(encryptedText, privateKey);
 // Write the decrypted text to a file
 writeFile(
 "decrypted.txt",
 new String(decryptedText, StandardCharsets.UTF_8)
 );
 }
 public static byte[] encrypt(byte[] data, PublicKey publicKey)
 throws Exception {
 Cipher cipher = Cipher.getInstance("RSA");
 cipher.init(Cipher.ENCRYPT_MODE, publicKey);
 return cipher.doFinal(data);
 }
 public static byte[] decrypt(byte[] data, PrivateKey privateKey)
 throws Exception {
 Cipher cipher = Cipher.getInstance("RSA");
 cipher.init(Cipher.DECRYPT_MODE, privateKey);
 return cipher.doFinal(data);
 }
 public static void saveKey(String fileName, byte[] key) throws IOException {
 FileOutputStream fos = new FileOutputStream(fileName);
 fos.write(key);
 fos.close();
 }
 public static String readFile(String fileName) throws IOException {
 BufferedReader br = new BufferedReader(new FileReader(fileName));
 StringBuilder sb = new StringBuilder();
 String line;
 while ((line = br.readLine()) != null) {
 sb.append(line);
 }
 br.close();
 return sb.toString();
 }
 public static void writeFile(String fileName, String content)
 throws IOException {
 BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
 bw.write(content);
 bw.close();
 }
}

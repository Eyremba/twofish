import java.util.Scanner;

public class MyTwofish 
{
	public static void main(String[] args) 
	{
		try (Scanner in = new Scanner(System.in))
		{
			System.out.print("Enter the key : ");
			String k = in.nextLine();
			System.out.print("Enter the plain text : ");
			String pt = in.nextLine();
			byte tempKey[] = k.getBytes();
			byte tempPlainText[] = pt.getBytes();
			byte key[] = new byte[32];
			byte plainText[] = new byte[128];
					
			int i;
			for(i=0; i<32;i++)
			{
				if(i<tempKey.length)  key[i] = tempKey[i];
				else key[i] = (byte)0;
			}
			for(i=0; i<128;i++)
			{
				if(i<tempPlainText.length)  plainText[i] = tempPlainText[i];
				else plainText[i] = (byte)0;
			}
						
			Object K = Twofish_Algorithm.makeKey(key);
			byte[] ct = Twofish_Algorithm.blockEncrypt(plainText, 0, K);
			String cipherText = new String(ct);
			System.out.println("Cipher text : "+cipherText);
			
			System.out.print("Enter the key : ");
			String k2 = in.nextLine();
			byte tempKey2[] = k2.getBytes();
			byte key2[] = new byte[32];
			for(i=0; i<32;i++)
			{
				if(i<tempKey2.length)  key2[i] = tempKey2[i];
				else key2[i] = (byte)0;
			}
			
			Object K2 = Twofish_Algorithm.makeKey(key2);
			byte[] cpt = Twofish_Algorithm.blockDecrypt(ct, 0, K2);
			String ot = new String(cpt);
			System.out.println("Decrypted Text : "+ot);
		}
	}
}

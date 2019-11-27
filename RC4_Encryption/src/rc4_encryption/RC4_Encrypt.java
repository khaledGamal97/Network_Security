/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc4_encryption;

/**
 *
 * @author KHALED97
 */
public class RC4_Encrypt {

    private static int[] s;
    public static StringBuffer cipher;

    // Making Swap
    private static void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    // Permutation "S"
    public static void init_Box(String key, int key_length) {
        s = new int[256];
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (s[i] + key.charAt(i % key_length) + j) % 256;
            swap(s, i, j);
        }
    }

    public static void generate_chiper(String plain) {
        int index = 0;
        int i = 0;
        int j = 0;
        cipher = new StringBuffer();
        while (index < plain.length()) {
            i = (++i) % 256;
            j = (s[i] + j) % 256;
            swap(s, i, j);
            int temp = s[(s[i] + s[j]) % 256];
            int a = plain.charAt(index);
            cipher.append(Integer.toHexString((temp ^ a)).length() == 2 ? Integer.toHexString((temp ^ a)).toUpperCase()
                    : ("0" + Integer.toHexString((temp ^ a)).toUpperCase()));
            index++;
        }

    }

}

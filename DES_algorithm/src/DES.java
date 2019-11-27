


import java.util.ArrayList;
//WELCOME TO THE PARTY AT NINE PM

public class DES {

    String key;
    String right, left;
    ArrayList<String> subKeys = new ArrayList<>();
    String prevLeft;
    String prevRight;
  

    private void generateSubKeys(String key1) {
        key = toBinary(key1);
        subKeys = new ArrayList<>();
        if (key.length() == 64) {
           
            key = permute(key, data.PC1, 64);
            prevLeft = key.substring(0, key.length() / 2);
            prevRight = key.substring(key.length() / 2);

            String newLeft;
            String newRight;
            String newSubKey;

            for (int i = 0; i < 16; i++) {
                newLeft = rotate(prevLeft, data.SEL_SHIFT_C_D[i]);
                prevLeft = newLeft;
                newRight = rotate(prevRight, data.SEL_SHIFT_C_D[i]);
                prevRight = newRight;
                newSubKey = newLeft + newRight;
                newSubKey = permute(newSubKey, data.PC2, 56);
                if (subKeys != null && newSubKey != null) {
                    subKeys.add(newSubKey);
                } else {
                    return;
                }

            }
        } else {
            return;
        }
    }

    public String cipher(String plain) {
        if (subKeys != null && subKeys.size() == 16) {
            plain = permute(plain, data.IP, 64);
            if (plain == null) {
                return plain;
            }
            split(plain);

            for (int i = 0; i < 16; i++) {

                mixer(subKeys.get(i));
                if (i != 15) {
                    swaper();
                }
            }
            String res = left + right;
            String finalCipher = permute(res, data.IP_INVERSE, 64);
            return finalCipher;
        } else {
            return null;
        }

    }

    public String decipher(String cipher) {
        if (subKeys != null && subKeys.size() == 16) {

            cipher = permute(cipher, data.IP, 64);
            if (cipher == null) {
                return cipher;
            }
            split(cipher);
            for (int i = 15; i >= 0; i--) {
                mixer(subKeys.get(i));
                if (i != 0) {
                    swaper();
                }
            }
            String res = left + right;
            String finalPlain = permute(res, data.IP_INVERSE, 64);
            return finalPlain;
        } else {
            return null;
        }

    }


    public String cipherMessage(String plain,String key1) {
        generateSubKeys(key1);
        StringBuilder builder = new StringBuilder();
        String temp;
        plain = toBinary(plain);

        for (int i = 0; i < plain.length(); i += 64) {
            temp = cipher(plain.substring(i, i + 64)); 
            builder.append(fromBinaryToString(temp)); 
        }

        return builder.toString();
    }


   
    public String decipherMessage(String cipherText,String key1) {
        generateSubKeys(key1);
        StringBuilder builder = new StringBuilder();
        String temp;
        cipherText = toBinary(cipherText);
        for (int i = 0; i < cipherText.length(); i += 64) {
            temp = decipher(cipherText.substring(i, i + 64));
            builder.append(fromBinaryToString(temp));
        }

        return builder.toString();
    }

   

    public static String toBinary(String a) {
        String temp;
        int t;
        StringBuilder builder = new StringBuilder(a);

        int mod = builder.toString().length() % 8;
        int iteration = mod == 0 ? 0 : (8 - mod);
        for (int i = 0; i < iteration; i++) {
            builder.append(" ");
        }
        a = builder.toString();
        builder = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            t = (int) a.charAt(i);
            temp = Integer.toBinaryString(t);

            while (temp.length() < 8) {
                temp = "0" + temp;
            }
            builder.append(temp);
        }

        return builder.toString();
    }

    public static String fromBinaryToString(String aBinary) {
        if (aBinary.length() % 8 == 0) {
            StringBuilder builder = new StringBuilder();
            int temp;
            for (int i = 0; i < aBinary.length(); i += 8) {
                temp = Integer.parseInt(aBinary.substring(i, i + 8), 2);
                builder.append((char) temp);
            }
            return builder.toString();

        } else {
            return "";
        }
    }



    private String permute(String plain, byte[] table, int length) {
        StringBuilder builder = new StringBuilder();
        if (plain.length() == length) {
            for (byte index : table) {
                builder.append(plain.charAt(index - 1));
            }
            return builder.toString();
        } else {
            return null;
        }
    }

   

    private void split(String plain) {
        left = plain.substring(0, plain.length() / 2);
        right = plain.substring(plain.length() / 2);
    }

    /**
     * expand right 32 bit into 48 bit to be XORED with key
     *
     * @return expanded right
     */
    private String expandWithDBox() {
        StringBuilder builder = new StringBuilder();
        for (byte index : data.D_BOX) {
            builder.append(right.charAt(index - 1));
        }
        return builder.toString();
    }


    private void swaper() {
        String temp;
        temp = left;
        left = right;
        right = temp;
    }


    private void mixer(String key) {
        String newRight = expandWithDBox(); // now right is 48
        newRight = xor(newRight, key);
        newRight = sbox(newRight); //not imp, now r is 32
        newRight = permute(newRight, data.P, 32); // permuate after S-Box selection
        left = xor(newRight, left);
    }


    private String xor(String newRight, String key) {
        if (newRight.length() == key.length()) {
            long k = Long.parseLong(key, 2); // here problem was with int
            long n = Long.parseLong(newRight, 2);
            long res = n ^ k;
            String resBinary = Long.toBinaryString(res);
            while (resBinary.length() < key.length()) {
                resBinary = "0" + resBinary;
            }
            return resBinary;
        } else {
            return null;
        }
    }

    private String sbox(String newRight) {
        if (newRight.length() != 48) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int row, col, sbox_value;
        String resNum;
        String sub;
        char fr, sc;
        for (int i = 0; i < 48; i += 6) {
            sub = newRight.substring(i, i + 6);
            fr = sub.charAt(0);
            sc = sub.charAt(5);
            row = Integer.parseInt("" + fr + sc, 2);
            col = Integer.parseInt((newRight.substring(i + 1, i + 5)), 2);
            sbox_value = (row * 16) + col;
            sbox_value = data.SBOX[i / 6][sbox_value];
            resNum = Integer.toBinaryString(sbox_value);
            while (resNum.length() < 4) {
                resNum = "0" + resNum;
            }
            builder.append(resNum);
        }

        return builder.toString();
    }


    private String rotate(String input, byte b) {
        StringBuilder builder = new StringBuilder(input);
        for (int i = 0; i < b; i++) {
            char c = builder.charAt(0);
            builder = builder.deleteCharAt(0);
            builder.append(c);
        }

        String s = builder.toString();
        while (s.length() < input.length()) {
            s = "0" + s;
        }
        return s;
    }



    interface data {

        int INTIAL = 0;
        int FINAL = 1;

        byte[] PC1 = new byte[]{57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51,
                43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30,
                22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};

        byte[] SEL_SHIFT_C_D = new byte[]{1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

        byte[] PC2 = new byte[]{14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16,
                7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53,
                46, 42, 50, 36, 29, 32};

        byte[] IP = new byte[]{58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};

        byte[] IP_INVERSE = new byte[]{40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};

        byte[] D_BOX = new byte[]{32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};

        byte[] P = new byte[]{16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};

        byte[][] SBOX = new byte[][]{{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13},
                {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9},
                {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12},
                {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14},
                {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3},
                {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13},
                {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12},
                {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};

    }

}
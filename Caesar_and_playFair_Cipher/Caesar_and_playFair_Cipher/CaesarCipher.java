package test1;
/**
 *
 * @author khaled97
 */


public class CaesarCipher {
    static String encrypt(String plainText,int key){
        
        String CipherText=new String("");
        
         for (int i = 0; i < plainText.length(); i++) {
            if ( (plainText.charAt(i)) == ' ') {
                CipherText+=' ';
            }else {
                if (Character.isLowerCase(plainText.charAt(i))){
                CipherText+=(char)(((int)plainText.charAt(i)+key-97)%26+97);
                }else{
                    CipherText+=(char)(((int)plainText.charAt(i)+key-65)%26+65);
                }
            }
                
            
        }
        return CipherText;
    }
    static String decrypt(String CipherText,int key){
        
        String plainText=new String("");
        
        for (int i = 0; i < CipherText.length(); i++) {
            if ( CipherText.charAt(i) == ' ') {
                plainText+=' ';
            } else {
                if(Character.isLowerCase(CipherText.charAt(i))){
                    if(((int)CipherText.charAt(i)-key)<97){
                    plainText+=(char)(((int)CipherText.charAt(i)-key-97+26)%26+97);
                
                    }else {
                    plainText+=(char)(((int)CipherText.charAt(i)-key-97)%26+97);
                   }
                }else{
                    if(((int)CipherText.charAt(i)-key)<65){
                    plainText+=(char)(((int)CipherText.charAt(i)-key-65+26)%26+65);
                
                }else {
                    plainText+=(char)(((int)CipherText.charAt(i)-key-65)%26+65);
                }
                }
                

            } 
                
           
        }
        return plainText;
    }
}




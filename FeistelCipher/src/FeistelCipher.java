/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc
 */
public class FeistelCipher {
    static public String encrypt(String plainText,String key,String function,int n_Of_Rounds){
        String cipherText=new String("");
        int n=plainText.length();
        String leftPart=plainText.substring(0, n/2);
        String rightPart=plainText.substring(n/2);
        int LE0=Integer.parseInt(leftPart, 2);
        int RE0=Integer.parseInt(rightPart, 2);
        int k=Integer.parseInt(key, 2);
        int LEP=LE0;
        int REP=RE0;
        int left_temp,right_temp;
        
        for(int i=0;i<n_Of_Rounds;i++){
            left_temp=REP;
            right_temp=REP;
            
            if(function=="AND") right_temp=REP & k;
            if(function=="OR")  right_temp=REP | k;
            if(function=="XOR") right_temp=REP ^ k;
            
            REP=right_temp ^ LEP;
            LEP=left_temp;
               
        }
        int temp=REP;
        REP=LEP;
        LEP=temp;
        
        leftPart=Integer. toBinaryString(LEP);
        rightPart=Integer.toBinaryString(REP);
        
        if(leftPart.length()<n/2){
        for (int i=0;i<=((n/2)-leftPart.length());i++){
            leftPart='0'+leftPart;
        }
           }
        
        if(rightPart.length()<n/2){
        for (int i=0;i<=((n/2)-rightPart.length());i++){
            rightPart='0'+rightPart;
        }
           }
        
        cipherText=leftPart+rightPart;
        return cipherText;
    }
    static public String decrypt(String cipherText,String key,String function,int n_Of_Rounds){
        String plainText=new String("");
        int n=cipherText.length();
        String leftPart=cipherText.substring(0, n/2);
        String rightPart=cipherText.substring(n/2);
        int LD0=Integer.parseInt(leftPart, 2);
        int RD0=Integer.parseInt(rightPart, 2);
        int k=Integer.parseInt(key, 2);
        int LDP=LD0;
        int RDP=RD0;
        int left_temp,right_temp;
        
        for(int i=0;i<n_Of_Rounds;i++){
            left_temp=RDP;
            right_temp=RDP;
            
            if(function=="AND") right_temp=RDP & k;
            if(function=="OR")  right_temp=RDP | k;
            if(function=="XOR") right_temp=RDP ^ k;
            
            RDP=right_temp ^ LDP;
            LDP=left_temp;
               
        }
        int temp=RDP;
        RDP=LDP;
        LDP=temp;
        
        leftPart=Integer. toBinaryString(LDP);
        rightPart=Integer.toBinaryString(RDP);
        
        if(leftPart.length()<n/2){
        for (int i=0;i<=((n/2)-leftPart.length());i++){
            leftPart='0'+leftPart;
        }
           }
        
        if(rightPart.length()<n/2){
        for (int i=0;i<=((n/2)-rightPart.length());i++){
            rightPart='0'+rightPart;
        }
           }
        
        plainText=leftPart+rightPart;
        return plainText;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa_cipher;

import java.lang.Math;

/**
 *
 * @author khaled97
 */
public class RSA_cipher {

    int n; //n=p*q
    int e; //public key {e,n}
    int d; //private key{d,n}
    
    //found the value of e and d
    public void key(int p, int q) {
        n = p * q;
        //System.out.println("n= " + n);
        int Q_of_n = (p - 1) * (q - 1);
        //System.out.println("Q_of_n= " + Q_of_n);
        //found the value of e
        for (int i = 2; i < Q_of_n; i++) {
            if (Q_of_n % i == 0) {
                continue;
            } else {
                e = i;
                break;
            }
        }
       // System.out.println("e= " + e);
        //found value of d
        int i = 1;
        while (true) {
            if (((i * e) % Q_of_n) == 1) {
                d = i;
                break;
            }
            i++;
        }
        //System.out.println("d= " + d);

    }

    public int encrypt(int m, int p, int q) {
        int c = 0;
        key(p, q);
        c = (int) (Math.pow(m, e) % n);
//        System.out.println("m2= "+m);
//        System.out.println("c1= "+c);

        return c;
    }

    public int decrypt(int c, int p, int q) {
        int m = 0;
        key(p, q);
        m = (int) (Math.pow(c, d) % n);

//        System.out.println("c2= "+c);
//        System.out.println("m2= "+m);
        return m;
    }

}


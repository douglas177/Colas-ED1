/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

/**
 *
 * @author Usuario
 */
public class ColaL {

    Nodo Cabeza;
    Nodo Fin;
    int Cant;

    public ColaL() {
        Cabeza = null;
        Fin = null;
        Cant = 0;
    }

    public boolean Vacia() {
        return Cant == 0;
    }

    public int Get() {
        return Cabeza.getDato();
    }

    public void Encolar(int ele) {
        Nodo p = new Nodo();
        p.setDato(ele);
        if (Vacia()) {
            Cabeza = p;
            Fin = p;
        } else {
            Fin.setEnlace(p);
            Fin = p;
        }
        Cant++;
    }
    public int Decolar() {
        int x = Cabeza.getDato();
        if (Cabeza == Fin) {
            Cabeza = null;
            Fin = null;
        } else {
            Cabeza = Cabeza.getEnlace();
        }
        Cant--;
        return x;
    }

    @Override
    public String toString() {
        String S = "Q-> [ ";
        Nodo Ca = Cabeza;
        while (Ca != null) {
            S = S + Ca.getDato();
            if(Ca.getEnlace()!=null)
                S = S + " , ";
            Ca = Ca.getEnlace();
        }
        
        S = S + " ]";
        return S;
    }
    public static void main(String[] args) {
        ColaL A = new ColaL();
        A.Encolar(5);
        A.Encolar(7);
        A.Encolar(8);
        A.Encolar(3);
        System.out.println(A);
        int x = A.Decolar();
        System.out.println(x);
        System.out.println("");
        A.Encolar(32);
        System.out.println(A);
    }
}

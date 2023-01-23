/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Usuario
 */
public class ColaV {

    /*
    Metodos
    Constructor()
    Encolar()
    Decolar()
    Vacia()
    Llena(Estática)
    Get()
    
    Implementar
    toString();
    
    
     */
    int Q[];
    int Cabeza;
    int Fin;

    public ColaV(int cant) {
        Q = new int[cant];
        Cabeza = -1;
        Fin = -1;
    }

    public boolean Vacia() {
        return Cabeza == -1;
    }

    public int Get() {
        return Q[Cabeza];
    }

    public boolean Llena() {
        return ((Fin + 1) % Q.length == Cabeza);

    }

    public void Encolar(int ele) {
        if (Llena()) {
            System.out.println("Error::Encolar:Cola Llena");
            System.exit(1);
        } else {
            if (Vacia()) {
                Cabeza = 0;
                Fin = 0;
            } else {
                Fin = (Fin + 1) % Q.length;
            }
            Q[Fin] = ele;
        }
    }

    public int Decolar() {
        int x = Q[Cabeza];
        if (Cabeza == Fin) {
            Cabeza = -1;
            Fin = -1;
        } else {
            Cabeza = (Cabeza + 1) % Q.length;
        }
        return x;
    }

    @Override
    public String toString() {
        String S = "Q-> [ ";
        int Ca = Cabeza;
        while (Ca != Fin) {
            S = S + Q[Ca] + " , ";
            Ca = (Ca+ 1)% Q.length;
        }
        S = S + Q[Fin]+ " ]";
        return S;

    }
    public static void main(String[] args) {
        ColaV A = new ColaV(5);
        A.Encolar(5);
        A.Encolar(2);
        A.Encolar(1);
        System.out.println(A);
        A.Decolar();
        A.Decolar();
        int X =A.Decolar();
        System.out.println("");
        System.out.println(X);
        System.out.println("");
        System.out.println(A);
       /* A.Encolar(1);
        A.Encolar(6);
        System.out.println(A);*/
        
    }

}

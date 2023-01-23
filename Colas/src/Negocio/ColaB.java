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
public class ColaB {

    VectorbitsGe Q;
    VectorbitsGe Signo;
    int Cabeza;
    int Fin;
    int Nbits;

    public ColaB(int cant, int nbit) {
        Q = new VectorbitsGe(cant, nbit);
        Signo = new VectorbitsGe(cant, 1);
        Cabeza = 0;
        Fin = 0;
        this.Nbits = nbit;
    }

    public boolean Vacia() {
        return Cabeza == 0;
    }

    public int Get() {
        int x = Q.Get(Cabeza);
        int signo = Signo.Get(Cabeza);
        if (signo == 1) {
            x = -x;
        }
        return x;
    }

    public boolean Llena() {
        return ((Fin + 1) % Q.dim == Cabeza);
    }

    public int Nbit() {
        return this.Nbits;
    }

    public void Encolar(int ele) {
        if (Llena()) {
            System.out.println("Error::Encolar:Cola Llena");
            System.exit(1);

        } else {
            int Elemento = Math.abs(ele);
            if (Vacia()) {
                Cabeza = 1;
                Fin = 1;

                if (ele >= 0) {
                    Signo.Insertar(0, Fin);
                } else {
                    Signo.Insertar(1, Fin);
                }
                Q.Insertar(Elemento, Fin);
            } else {
                Fin = ((Fin) % Q.dim) + 1;
                Q.Insertar(Elemento, Fin);
                if (ele >= 0) {
                    Signo.Insertar(0, Fin);
                } else {
                    Signo.Insertar(1, Fin);
                }
            }
        }
    }

    public int Decolar() {
        int x = Q.Get(Cabeza);
        int signo = Signo.Get(Cabeza);
        if (signo == 1) {
            x = -x;
        }
        if (Cabeza == Fin) {
            Cabeza = 0;
            Fin = 0;
        } else {
            Cabeza = ((Cabeza) % Q.dim) + 1;
        }
        return x;
    }

    @Override
    public String toString() {
        String S = "Q-> [ ";
        if (!Vacia()) {
            int Ca = Cabeza;
            while (Ca != Fin) {
                int x = Signo.Get(Ca);
                if (x == 1) {
                    S = S + (-Q.Get(Ca)) + " , ";
                } else {
                    S = S + Q.Get(Ca) + " , ";
                }
                Ca = ((Ca) % Q.dim) + 1;
            }
            if (Signo.Get(Ca) == 1) {
                S = S + (-Q.Get(Ca));
            } else {
                S = S + Q.Get(Ca);
            }
        }
        S = S + " ]";
        return S;
    }

    public static void main(String[] args) {
        ColaB A = new ColaB(5, 4);
        A.Encolar(5);
        A.Encolar(-9);
        A.Encolar(-0);
        A.Encolar(-7);
        A.Encolar(9);
        int x = A.Fin;
        System.out.println(x);
        A.Decolar();
        A.Decolar();
        A.Decolar();
        A.Decolar();
        A.Decolar();
        //A.Decolar();
        System.out.println(A);
    }
}

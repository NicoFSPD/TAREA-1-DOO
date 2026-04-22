package org.example;
import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> al;

    public Deposito(){
        al = new ArrayList<>();
    }

    public void addElemento(T x){
        al.add(x);
    }

    public T getElemento(){
        if (al.size() == 0){
            return null;
        }
        return al.remove(0);
    }
}

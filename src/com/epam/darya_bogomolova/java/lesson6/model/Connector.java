package com.epam.darya_bogomolova.java.lesson6.model;

import java.io.*;

public class Connector {

    private Object object;

    public Connector() throws IOException {
    }

    public Object getObject() {
        return object;
    }

    public void writeSerializeObject(Object o){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serialize_object.txt"))) {
            out.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readSerializeObject(){
        try (ObjectInputStream in =  new ObjectInputStream (new FileInputStream("serialize_object.txt"))) {
            return in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

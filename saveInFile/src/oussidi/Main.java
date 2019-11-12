package oussidi;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User obj = new User("Oussidi","Mohamed");
        Voiture objV = new Voiture("Dacia logan","Model 2030",345,"essance");
        saveObjectToFile(obj,"data.txt");
    }
    public static <T> void saveObjectToFile(T object,String fileName) {
        String str = object.toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            writer.write(str);
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<User> readObjectFromFile(String fileName) {
        ArrayList<User> list =new ArrayList<>();
        try {
            String ligne;
            LineNumberReader lnr = new LineNumberReader(new FileReader(fileName));
            try {
                while((ligne=lnr.readLine()) != null){
                    String[] tab_info = ligne.split("|");
                   list.add(new User(tab_info[0],tab_info[1]));
                }
            }finally {
                lnr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}

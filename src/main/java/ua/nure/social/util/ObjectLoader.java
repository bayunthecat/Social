package ua.nure.social.util;

import java.io.*;

public class ObjectLoader {

    public boolean loadObjectToFile(Object object, String filename) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            logError(e);
            return false;
        }
        return true;
    }

    public Object loadObjectFromFile(String filename) {
        Object result = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            result = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logError(e);
        }
        return result;
    }

    private void logError(Exception exception) {
        System.out.println("Writing failed ==> " + exception.getMessage());
    }
}

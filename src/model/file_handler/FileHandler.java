package model.file_handler;

import java.io.*;

public class FileHandler implements Saveable, Loadable {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Object object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @Override
    public Object load() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }
}

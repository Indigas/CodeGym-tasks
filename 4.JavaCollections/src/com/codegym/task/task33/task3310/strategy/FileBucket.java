package com.codegym.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("temp-", null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (Exception e){

        }
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e){
            return 0;
        }
    }

    public void putEntry(Entry entry){
        try {
            OutputStream out = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(entry);
            oos.close();
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Entry getEntry(){
        if(getFileSize()==0)
            return null;

        try {
            InputStream is = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            return (Entry)ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

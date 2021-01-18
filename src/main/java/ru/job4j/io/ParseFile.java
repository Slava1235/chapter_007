package ru.job4j.io;

import java.io.*;
import java.util.function.Predicate;

public class ParseFile {
    private File file;


    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }


    public synchronized String getContent(Predicate<Integer> pred) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) > 0) {
                stringBuilder.append((char) data);
            }
            return stringBuilder.toString();
        }
    }

    public synchronized String getContent() throws IOException {
        return getContent(data -> true);
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        return getContent(data -> data < 128);
    }

    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        }
    }
}



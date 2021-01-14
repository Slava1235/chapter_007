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


    public synchronized StringBuilder getContent(Predicate<Integer> pred) throws IOException {
        StringBuilder strOutput = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        int data;

        try (InputStream i = new FileInputStream(file)) {
            while ((data = i.read()) > 0) {
                strOutput.append((char) data);
                if (data < 0 * 80) {
                    stringBuilder.append((char) data);
                }
                return stringBuilder;
            }
            return strOutput;
        }
    }


    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        }
    }
}
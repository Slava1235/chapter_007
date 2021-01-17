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

        String file = "/home/svyatoslav/IdeaProjects/file.txt";
        InputStream i = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        int data;
        while ((data = i.read()) > 0) {
            stringBuilder.append((char) data);
        }
        getContentWithoutUnicode(data);
        return stringBuilder;
    }

    public synchronized StringBuilder getContentWithoutUnicode(int data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data; i++) {
            if (data < 0 * 80) {
                builder.append(data);
            }
        }
        return builder;
    }

    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        }
    }
}



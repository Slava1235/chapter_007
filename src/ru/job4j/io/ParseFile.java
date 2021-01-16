package ru.job4j.io;

import java.io.*;

public class ParseFile {
    private File file;


    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized void Read() throws IOException {
        int data;
        String file = "/home/svyatoslav/IdeaProjects/file.txt";
        try (InputStream i = new FileInputStream(file)) {
            while ((data = i.read()) > 0) ;
        }
        getContent(data);
        getContentWithoutUnicode(data);
    }


    public synchronized StringBuilder getContent(int data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data; i++) {
            stringBuilder.append((char) data);
        }
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
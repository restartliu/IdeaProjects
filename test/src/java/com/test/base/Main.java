package com.test.base;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    static String path = "test.txt";

    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        main.scannerTest();
//        main.consoleInputTest();
//        main.datePrintTest();
//        main.printWriterTest();
//        main.breakLoopTest();
//        main.copyArray();
//        main.sortCompare();
    }

    //running in console
    public void consoleInputTest(){
        Console console = System.console();
        if (console != null) {
            String s = console.readLine("Input username: ");
            char[] passwd = console.readPassword("Input password: ");
            System.out.println("username:" + s + "    " + "password:" + Arrays.toString(passwd));
        }
    }

    public void scannerTest() throws IOException {
        Scanner scanner = new Scanner(Paths.get(Main.path), "UTF-8");
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }

    public void printWriterTest() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter(Main.path, "UTF-8");
        printWriter.append("life is a fucking movie");
        printWriter.flush();
        printWriter.close();
    }

    public void datePrintTest(){
        System.out.printf("%1$s %2$tB %2$te, %2$tY\n", "Due date", new Date());
        System.out.printf("%1$s %2$tB %<te, %<tY\n", "Due date", new Date());
        System.out.printf("%s %tB %<te, %<tY\n", "Due date", new Date());
        System.out.printf("%s %tT %<tB %<te, %<tY\n", "Due date", new Date());
        System.out.println(new Date());
    }

    public void breakLoopTest(){
        test:
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == 10)
                    break test;
                System.out.print(i+ "" + j + "\t");
            }
        }
    }

    public void copyArray(){
        int[] temp = {10, 50, 69, 85, 87, 81, 89};
        int[] ints = Arrays.copyOf(temp, 2*temp.length);
        Arrays.sort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //16.16s
    public void sortCompare(){
        Random random = new Random();
        int[] buffer = new int[100000000];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = random.nextInt(100000000);
        }
        Arrays.sort(buffer);
        for (int i : buffer) {
            System.out.print(i + "\t");
        }
    }
}

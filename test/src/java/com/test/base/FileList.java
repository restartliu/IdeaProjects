package com.test.base;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        FileList fileList = new FileList();
        fileList.printList("/home/restart/Downloads");
    }

    private void printList(File file, int tabCount){
        for (int i = 0; i < tabCount; i++){
            System.out.print("    ");
        }
        System.out.print(file.getName() + "\n");

        File[] files = file.listFiles();
        if ( files != null && files.length != 0 ){
            for (File listFile : files) {
                printList(listFile, tabCount+1);
            }
        }
    }

    public Boolean printList(String filePath){
        File file = new File(filePath);
        if (file.exists()){
            printList(file, 0);
            return true;
        }
        return false;
    }
}

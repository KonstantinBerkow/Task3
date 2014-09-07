package com.company;

import java.io.File;
import java.util.List;

/**
 * Class for tests.
 */
public class Main {

    /**
     * Put path to initialDirectory which you want to traverse in args[]. Then content of this directory will be printed to console.
     *
     * @param args args[0] - path to directory which you want to traverse.
     */
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("No arguments!");
            return;
        }
        File initialDir = new File(args[0]);

        if (!initialDir.exists()) {
            System.err.println("File does not exist!");
            return;
        }
        if (!initialDir.isDirectory()) {
            System.err.println("File is not a directory!");
            return;
        }

        List<String> test = FileTools.allSubDirectories(initialDir);
        for (String s : test)
            System.out.println(s);
    }

}

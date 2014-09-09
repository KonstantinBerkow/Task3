package com.company;

import java.io.File;
import java.util.List;

/**
 * Class for tests.
 */
public class Main {

    private static final String DEFAULT_DIR_PATH = "D:/Program Files";

    /**
     * Put path to initialDirectory which you want to traverse in args[]. Then content of this directory will be printed to console.
     *
     * @param args args[0] - path to directory which you want to traverse.
     */
    public static void main(String[] args) {
        String dirPath;
        if (args.length > 0) {
            dirPath = args[0];
            System.out.println("Proceeding to file " + dirPath);
        } else {
            dirPath = DEFAULT_DIR_PATH;
            System.out.println("No arguments! Proceeding to default file " + dirPath);
        }

        File initialDir = new File(dirPath);

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

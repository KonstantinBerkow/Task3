package com.company;

import java.io.File;
import java.util.*;

/**
 * Class with method to traverse directories.
 */
public class FileTools {

    /**
     * Not recursively traverses files and directories in given directory.
     * Returns a list of paths to traversed directories and files.
     *
     * @param initialDirectory File object which represents main directory.
     * @return List of files paths
     */
    public static List<String> allSubDirectories(File initialDirectory) {
        List<String> listOfFiles = new ArrayList<String>(); //Empty list which will be filled with directories and files

        Queue<String> queueOfFiles = new ArrayDeque<String>(); //Queue which will be used for traverse
        queueOfFiles.add(initialDirectory.getPath());   //Adding initialDirectory to queue

        while (!queueOfFiles.isEmpty()) {
            File currentDir = new File(queueOfFiles.remove()); //Extracting directory from queue to traverse its content

            try {
                listOfFiles.add(currentDir.getPath());  //Adding path to current directory to list
                File[] files = currentDir.listFiles();  //getting directories content
                if (files == null) continue;    //Some directories and files are hidden or system and will throw NullPtr exception
                for (File file : files) {
                    if (file.isDirectory()) {   //if one is directory then add it to queue to process later
                        queueOfFiles.add(file.getPath());
                    } else listOfFiles.add(file.getPath()); //else it is file so add it to list
                }
            } catch (SecurityException e) {
                System.err.println("Access denied: " + e.getMessage());
            }
        }

        return listOfFiles;
    }

}

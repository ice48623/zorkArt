package io.muic.ooc.zorkArt.mapFactory;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ice on 2/3/17.
 */
public class readFile {
    public static List<String> readLine(String pathToFile) {
        List<String> lines = null;
        try {
            File file = new File(pathToFile);
            lines = FileUtils.readLines(file, "UTF-8");

//            for (String line : lines) {
//                System.out.println(line);
//            }


        } catch (IOException e) {
            System.out.println("Couldn't open file");
        }
        return lines;
    }
}

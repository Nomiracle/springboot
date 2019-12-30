package IOExample.IO;

import IOExample.FourWaysToCopyFiles;

import java.io.File;

public class FilenameFilterExample {
    public static void main(String[] args) {
        String fileName = "copyfile.txt";
        String name = FourWaysToCopyFiles.class.
                getResource(fileName).getPath();
        name = name.replace(fileName, "");
        System.out.println("filePath: " + name);

        //Delete all files from this directory
        File dir = new File(name);
        //Filter out all log files
        String[] logFiles = dir.list((dir1, name1) ->
                name1.matches(".*([12345])"));
        assert logFiles != null;
        for (String path : logFiles) {
            path = name +
//                    File.separator +
                    path;
//            System.out.println(path);
            File fileDelete = new File(path);
            if (fileDelete.delete()) {
                System.out.println("file : " + path + " is deleted : ");
            }
        }
    }
}


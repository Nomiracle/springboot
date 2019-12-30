package IOExample.IO;

import IOExample.FourWaysToCopyFiles;

import java.io.File;

public class FileFilterExample {
    public static void main(String[] args) {
        String fileName = "copyfile.txt";
        String name = FourWaysToCopyFiles.class.
                getResource(fileName).getPath();
        name = name.replace(fileName, "");
        System.out.println("filePath: " + name);
        File dir = new File(name);

        File[] files = dir.listFiles(file->file.getName().endsWith(
                "txt"
        ));
        assert files != null;
        for(File file : files){
            String path = file.getAbsolutePath() ;
            System.out.println(path);
        }
    }
}

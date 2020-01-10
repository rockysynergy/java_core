import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.Date;

public class MyFilesTest {
    public static void main(String[] args) {
        // moveFile();
        fileAttributes();
    }

    public static void moveFile() {
        Path from = Paths.get("c:/temp", "abc.txt");

        // Move the file from `c:/temp/abc.txt` to `c:/temp/test/def.txt`, Overwritting,
        // if file exits
        Path to = from.getParent().resolve("test/def.txt");
        try {
            // Size in bytes
            System.out.println("size of abc.txt: " + Files.size(from));
            Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error on moving the file: " + e.getMessage());
        }
    }

    public static void fileAttributes() {
        Path path = Paths.get("c:/temp");
        System.out.println("Is directory? " + Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));

        try {
            // Get file basic attributes
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(attributes.isDirectory());
            System.out.println(new Date(attributes.lastModifiedTime().toMillis()).toLocaleString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDirectory() {
        Path path = Paths.get("c:/temp/test");
        try {
            // Create file
            if (Files.notExists(path)) {
                Files.createDirectories(path);
                System.out.println("Create dir");
            } else {
                System.out.println("dir exists");
            }

            Path path2 = path.resolve("A.java");
            Path path3 = path.resolve("B.java");
            Path path4 = path.resolve("C.java");
            Path path5 = path.resolve("D.java");

            Files.createFile(path2);
            Files.createFile(path3);
            Files.createFile(path4);
            Files.createFile(path5);

            // Iterate without condition
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            for (Path p: paths) {
                System.out.println(p.getFileName());
            }
            System.out.println();

            // Make a iterator with filter
            DirectoryStream<Path> pathsFilter = Files.newDirectoryStream(path, "*.{java,txt}");
            for (Path p : pathsFilter) {
                System.out.println(p.getFileName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
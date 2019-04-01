package ua.nure.timoshenko.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public final class Util {

    private static final String ENCODING = "UTF-8";

    private Util() {}

    public static String readFile(String path) throws IOException {
        String res = null;

            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);


        return res;
    }
}

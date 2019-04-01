package ua.nure.timoshenko.practice3;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static ua.nure.timoshenko.practice3.Part1.*;
import static ua.nure.timoshenko.practice3.Part5.*;
import static ua.nure.timoshenko.practice3.Util.readFile;


public class Demo {

    public static final String ARROW = " ===> ";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String INPUT_PART_1 = readFile("part1.txt");
        String INPUT_PART_2 = readFile("part2.txt");
        String INPUT_PART_3 = readFile("part3.txt");
        System.out.println("~~~~~~~Part1~~~~~~~");
        System.out.println(convert1(INPUT_PART_1));
        System.out.println(convert2(INPUT_PART_1));
        System.out.println(convert3(INPUT_PART_1));
        System.out.println(convert4(INPUT_PART_1));

        System.out.println("~~~~~~~Part2~~~~~~~");
        System.out.println(Part2.convert(INPUT_PART_2));

        System.out.println("~~~~~~~Part3~~~~~~~");
        System.out.println(Part3.convert(INPUT_PART_3));

        System.out.println("~~~~~~~Part4~~~~~~~");
        System.out.println(Part4.hash("password", "SHA-256"));
        System.out.println(Part4.hash("passwort", "SHA-256"));

        System.out.println("~~~~~~~Part5~~~~~~~");

        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ARROW + decimal2Roman(i) + ARROW + roman2Decimal(decimal2Roman(i)));
        }


    }
}

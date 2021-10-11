package me.bruno.santana.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StringAndFilesMethods {

    public static void main(String[] args) throws IOException {

        //String methods

        String str = "";
        System.out.println("isBlank() " + str.isBlank()); //Returns true if the string is empty or contains only white space codepoints, otherwise false.
        System.out.println("isEmpty() " + str.isEmpty()); //Returns true if, and only if, length() is 0.

        str = " ";
        System.out.println("isBlank() " + str.isBlank());
        System.out.println("isEmpty() " + str.isEmpty());

        Stream<String> lines = "Hello\nWorld!".lines();//Returns a stream of lines extracted from this string, separated by line terminators.
        lines.forEach(System.out::println);

        String name = " Bruno  ";
        System.out.println("|" + name + "|");
        System.out.println("|" + name.strip() + "|"); //Returns a string whose value is this string, with all leading and trailing white space removed.

        //Files methods

        Path path = Files.writeString(Files.createTempFile("helloworld", ".txt"), "Hi, my name is Bruno!");
        System.out.println(path);
        String s = Files.readString(path);
        System.out.println(s);
    }

}

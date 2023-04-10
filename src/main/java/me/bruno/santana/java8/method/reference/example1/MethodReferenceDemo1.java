package me.bruno.santana.java8.method.reference.example1;

//Example based on this link: https://www.youtube.com/watch?v=svQKKg3aFzo

interface Parser {
    String parse(String str);
}

class StringParser {
    public static String convert(String s) {
        if(s.length()<=3)
            s = s.toUpperCase();
        else
            s = s.toLowerCase();

        return s;
    }
}

class StringParser2 {
    public String convert(String s) {
        if(s.length()>=3)
            s = s.toUpperCase();
        else
            s = s.toLowerCase();

        return s;
    }
}

class MyPrinter {
    public void print(String str, Parser p) {
        str = p.parse(str);
        System.out.println(str);
    }
}

public class MethodReferenceDemo1 {

    public static void main(String[] args) {
        String str = "Bruno Sant' Ana";
        MyPrinter mp = new MyPrinter();

        //using anonymous class
        mp.print(str, new Parser() {
            @Override
            public String parse(String str) {
                return StringParser.convert(str);
            }
        });

        //using Lambda
        mp.print(str, (s -> StringParser.convert(s)));

        //using method reference with static method
        mp.print(str, StringParser::convert);

        //using method reference with non-static method
        StringParser2 sp2 = new StringParser2();
        mp.print(str, sp2::convert);
    }

}

package me.bruno.santana.java17;

abstract sealed class Shape permits Circle, Square {
    public String message(){
        return "This is a shape!";
    }
}

final class Circle extends Shape{}

non-sealed class Square extends Shape{}

//non-sealed class Anything extends Shape{} //java: class is not allowed to extend sealed class: me.bruno.santana.java17.Shape (as it is not listed in its permits clause)

public class SealedClass {

    public static void main(String[] args) {
        System.out.println(new Circle().message());
        System.out.println(new Square().message());
    }

}

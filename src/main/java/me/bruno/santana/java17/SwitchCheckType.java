package me.bruno.santana.java17;

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class SwitchCheckType {

    public static void main(String[] args) {
        SwitchCheckType s = new SwitchCheckType();
        System.out.println(s.test(Integer.valueOf(1)));
        System.out.println(s.test("Testing switch"));
        System.out.println(s.test(new Cat("Rag")));
        System.out.println(s.test(new Object()));
    }

    public String test(Object obj) {

        return switch (obj) {
            case Integer i -> "An integer: " + i;
            case String s -> "A string: " + s;
            case Cat c -> "A Cat: " + c;
            default -> "I don't know what it is";
        };

    }

}

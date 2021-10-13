package me.bruno.santana.java11;

interface NameConcatenator{
    public String concatenate(String firstName, String lastName);
}

public class TypeInferenceForLambdaParameters {

    public static void main(String[] args) {
        //Java 11
        NameConcatenator nameConcatenator = (var firstName, var lastName) -> firstName + " " + lastName; //In the Java 11 we can use var in the Lambda parameters
        System.out.println(nameConcatenator.concatenate("Bruno", "Sant' Ana"));

        //Before Java 11
        NameConcatenator nc1 = (String firstName, String lastName) -> firstName + " " + lastName;
        System.out.println(nc1.concatenate("Anderson", "Silva"));

        NameConcatenator nc2 = (firstName, lastName) -> firstName + " " + lastName;
        System.out.println(nc2.concatenate("Anderson", "Freire"));
    }

}

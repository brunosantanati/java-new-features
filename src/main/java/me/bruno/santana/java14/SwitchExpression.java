package me.bruno.santana.java14;

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, RANDOM;
}

public class SwitchExpression {

    public static void main(String[] args) {

        int dayNumber = getDayNumber(Day.MONDAY);
        System.out.println(dayNumber);

        dayNumber = getDayNumber(Day.SATURDAY);
        System.out.println(dayNumber);

        dayNumber = getDayNumber(Day.RANDOM);
        System.out.println(dayNumber);
    }

    private static int getDayNumber(Day day) {
        int dayNumber = switch (day){
            case SUNDAY -> 1;
            case MONDAY -> 2;
            case TUESDAY -> 3;
            case WEDNESDAY -> 4;
            case THURSDAY -> 5;
            case FRIDAY -> 6;
            case SATURDAY -> 7;
            default -> {
                int min = 1;
                int max = 7;
                int randomDay = (int)Math.floor(Math.random()*(max-min+1)+min);
                yield randomDay;
            }
        };
        return dayNumber;
    }

}

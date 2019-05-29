
public class Main {

    public static void main(String[] args) {
        System.out.println(isAWeekDay("sun"));
        System.out.println(clockTime("24:11:01"));
    }

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    // 13:11:09
    public static boolean clockTime(String string) {
        return string.matches("(([01][0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]");
    }

    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]+");
    }
}

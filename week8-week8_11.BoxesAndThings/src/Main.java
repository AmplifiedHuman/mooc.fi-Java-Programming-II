public class Main {
    public static void main(String[] args) {
        Box firstBox = new Box(100);
        Box secondBox = new Box(50);
        firstBox.add(new CD("halo", "title", 1989));
        firstBox.add(new Book("Peter", "Ender\'s Game", 34));
        secondBox.add(new CD("halo", "title", 1989));
        secondBox.add(new Book("Peter", "Ender\'s Game", 34));
        Box thirdBox = new Box(150);
        thirdBox.add(firstBox);
        thirdBox.add(secondBox);
        thirdBox.add(new Book("Peter", "Ender\'s Game", 34));
        System.out.println(thirdBox);
    }
}
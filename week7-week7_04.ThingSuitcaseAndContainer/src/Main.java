public class Main {
    public static void main(String[] Container) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        int initialWeight = 1;
        for (int i = 0; i < 100; i++) {
            Suitcase newSuitcase = new Suitcase(100);
            newSuitcase.addThing(new Thing("Brick", initialWeight++));
            container.addSuitcase(newSuitcase);
        }
    }
}
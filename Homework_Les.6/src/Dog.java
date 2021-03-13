public class Dog extends Animal {

    public static int dogCreated = 0;
    public static final int MAX_DOG_RUN_DIST = 500;
    public static final int MAX_DOG_SWIM_DIST = 10;

    public Dog(String name) {
        super(name);
        dogCreated++;
    }

    @Override
    public String run(int distance) {
        if (distance > MAX_DOG_RUN_DIST) return "Собака не может пробежать больше " + MAX_DOG_RUN_DIST + "м.";
        return name + " пробежал " + distance + "м.";
    }

    @Override
    public String swim(int distance) {
        if (distance > MAX_DOG_RUN_DIST) {
            return "Собака не может пробежать больше " + MAX_DOG_RUN_DIST + "м.";
        }
        return name + " пробежал " + distance + "м.";
    }
}

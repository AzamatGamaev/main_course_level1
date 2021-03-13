public class Cat extends Animal {

    public static int catCreated = 0;
    public static final int MAX_CAT_RUN_DIST = 200;

    public Cat(String name) {
        super(name);
        catCreated++;
    }

    public String run(int runDist) {
        if (runDist > MAX_CAT_RUN_DIST) {
            return "Кошка не может пробежать больше " + MAX_CAT_RUN_DIST + "м.";
        }
        return name + " пробежал " + runDist + "м.";
    }

    public String swim(int swimDist) {
        return "Кошки не умеют плавать." + name + " тоже не умеет.";
    }
}

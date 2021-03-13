public abstract class Animal {

    public static int animalCreated = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCreated++;
    }

    public abstract String run(int runDist);
    public abstract String swim(int swimDist);

}

public class Plate {

    private int food;

    public Plate(int food) {
        if (food<0) {
            throw new IllegalArgumentException("The food can't be negative");
        }
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }//Default Getters and Setters

    public void info() {
        System.out.println("Plate: " + food);
    }

    public void decreaseFood(int catAppetite) {
        if ((food - catAppetite) < 0) {
            System.out.println("Cat cannot eat more food than is available.");
        } else {
            food -= catAppetite;
        }
        System.out.println();
    }

    public void addFood (int addingFood) {
        food += addingFood;
    }
}

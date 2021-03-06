public class Main {

    public static void main(String[] args) {

        Cat catBarsik = new Cat("Barsik", 20);
        Plate plate = new Plate(50);

        plate.info();
        catBarsik.eat(plate, plate.getFood());
        catBarsik.isSatiety();
        plate.info();

        plate.addFood(30);
        plate.info();

        Cat[] cats = new Cat[3];
        cats[0]= new Cat("Tom", 25);
        cats[1]= new Cat("Jerry", 25);
        cats[2]= new Cat("Musya", 25);


        for (Cat cat : cats) {//
            cat.eat(plate, plate.getFood());
            cat.isSatiety();
        }
    }
}

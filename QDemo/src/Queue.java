public class Queue {

    char[] q;
    int putLoc, getLoc;

    Queue(int size) {
        q = new char[size + 1];
        putLoc = getLoc = 0;
    }

    void put(char ch) {
        if (putLoc == q.length - 1) {
            System.out.println(" - Очередь заполнена");
            return;
        }
        putLoc++;
        q[putLoc] = ch;
    }

    char get() {
        if (getLoc == putLoc) {
            System.out.println(" - Очередь пустая");
            return (char) 0;
        }
        getLoc++;
        return q[getLoc];
    }
}

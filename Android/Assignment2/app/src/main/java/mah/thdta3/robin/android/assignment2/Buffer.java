package mah.thdta3.robin.android.assignment2;

import java.util.LinkedList;

/**
 * Created by robin on 04/10/2017.
 */

public class Buffer<T> {

    private LinkedList<T> buffer = new LinkedList<T>();

    public synchronized void put(T obj) {
        buffer.addLast(obj);
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while(buffer.isEmpty()) {
            wait();
        }
        return buffer.removeFirst();
    }

}

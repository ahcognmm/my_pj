import java.util.*;

public class LRUcache<E> {

    int[] priority;
    protected HashMap<Integer, E> map = new HashMap<>();
    int count = 0;


    private int size;

    public LRUcache(int size) {
        this.size = size;
        priority = new int[size];
    }

    public void set(E e) {
        if (!map.containsValue(e)) {
            if (totalInCache() < size) {
                pushAll();
                map.put(0, e);
                priority[count] = count + 1;
                count += 1;
            } else {
                pushAll();
                map.put(0, e);
            }
        } else {
            int key = getKey(e);
            for (int i = 0; i < key + 1; i++) {
                swap(0, i);
            }
        }

    }

    protected void pushAll() {
        if (priority[0] != 0) {
            for (int i : priority) {
                if (i < size && i != 0)
                    swap(0, i);
                else break;
            }
        }
    }

    protected void swap(int index1, int index2) {
        if (index1 != index2) {
            E e = map.get(index1);
            map.put(index1, map.get(index2));
            map.put(index2, e);
        }
    }

    public E getE(int index) {
        return this.map.get(index);
    }

    public int totalInCache() {
        return Collections.max(new ArrayList<Integer>() {{
            for (int i : priority) add(i);
        }});

    }

    public void print() {
        System.out.println(map.toString());
    }

    protected int getKey(E e) {
        int key = -1;
        int to = totalInCache();
        for (int i = 0; i < to; i++) {
            if (map.get(i) == e) {
                key = i;
                break;
            }
        }
        return key;
    }
}

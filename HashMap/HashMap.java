import java.io.*;
import java.util.*;

public class HashMap<K, V> {

    int size; // n
    LinkedList<HMNode>[] buckets; // N = buckets.length

    private class HMNode {
        K key;
        V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
        }
    }

    public void put(K key, V value) throws Exception {
        int bi = getBucketIndex(key); // by hashcode
        int dataidx = getDataIndex(bi, key);

        if (dataidx != -1) { // key found
            HMNode node = buckets[bi].get(dataidx);
            node.value = value;
        } else { // key not found
            HMNode node = new HMNode(key, value);
            buckets[bi].add(node);
            size++;
        }

        double lambda = (size * 1.0) / buckets.length; // converting size into double

        if (lambda > 2.0) {
            reHash();
        }

    }

    public void reHash() throws Exception {
        LinkedList<HMNode>[] oldBucket = buckets;
        initbuckets(2 * oldBucket.length);
        size = 0;
        for (int i = 0; i < oldBucket.length; i++) {
            for (HMNode node : oldBucket[i]) {
                put(node.key, node.value);
            }
        }

    }

    public int getDataIndex(int bi, K key) {

        int di = 0;
        for (HMNode node : buckets[bi]) {
            if (node.key.equals(key)) {
                return di; // key found
            }
            di++;
        }
        return -1; // key not found
    }

    public int getBucketIndex(K key) { // hash function
        int code = key.hashCode();
        return Math.abs(code) % buckets.length;
    }

    public V get(K key) throws Exception {
        int bi = getBucketIndex(key); // by hashcode
        int dataidx = getDataIndex(bi, key);

        if (dataidx != -1) { // key found
            HMNode node = buckets[bi].get(dataidx);
            return node.value;
        } else { // key not found
            return null;
        }
    }

    public boolean containsKey(K key) {
        int bi = getBucketIndex(key); // by hashcode
        int dataidx = getDataIndex(bi, key);

        if (dataidx != -1) { // key found
            return true;
        } else { // key not found
            return false;
        }
    }

    public V remove(K key) throws Exception {
        int bi = getBucketIndex(key); // by hashcode
        int dataidx = getDataIndex(bi, key);

        if (dataidx != -1) { // key found
            HMNode node = buckets[bi].remove(dataidx);
            size--;
            return node.value;
        } else { // key not found
            return null;
        }
    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> keyList = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            for (HMNode node : buckets[i]) {
                keyList.add(node.key);
            }
        }

        return keyList;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.println("Display Begins");
        for (int bi = 0; bi < buckets.length; bi++) {
            System.out.print("Bucket" + bi + " ");
            for (HMNode node : buckets[bi]) {
                System.out.print(node.key + "@" + node.value + " ");
            }
            System.out.println(".");
        }
        System.out.println("Display Ends");
    }
}

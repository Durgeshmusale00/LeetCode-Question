class Bucket {
    private List<Integer> container;

    public Bucket() {
        container = new LinkedList<>();
    }

    public void insert(Integer val) {
        if (!container.contains(val)) {
            container.add(val);
        }
    }

    public void remove(Integer val) {
        container.remove(val);
    }

    public boolean contains(Integer val) {
        return container.contains(val);
    }
}

class MyHashSet {

    int numBucket = 767;
    Bucket[] buckets;

    public MyHashSet() {
        buckets = new Bucket[numBucket];

        for (int i = 0; i < numBucket; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int getIndex(int key) {
        return key % numBucket;
    }

    public void add(int key) {
        int bucketIndex = getIndex(key);
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = getIndex(key);
        buckets[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = getIndex(key);
        return buckets[bucketIndex].contains(key);
    }
}
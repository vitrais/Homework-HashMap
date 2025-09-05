public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] table;
    private int size;
    private int threshold;

    // Внутренний класс для хранения пар ключ-значение
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    // Конструктор
    public CustomHashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    // Метод put
    public void put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        addEntry(hash, key, value, index);
        size++;
        if (size >= threshold)
            resize(table.length * 2);
    }

    // Метод get
    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    // Метод remove
    public V remove(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry<K, V> prev = null;
        for (Entry<K, V> entry = table[index]; entry != null; prev = entry, entry = entry.next) {
            if (entry.getKey().equals(key)) {
                if (prev == null)
                    table[index] = entry.next;
                else
                    prev.next = entry.next;
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    // Вспомогательные методы
    private int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(key, value);
        table[index].next = e;
    }

    private void resize(int newCapacity) {
        Entry[] oldTable = table;
        table = new Entry[newCapacity];
        threshold = (int) (newCapacity * LOAD_FACTOR);

        for (Entry<K, V> entry : oldTable) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int i = indexFor(hash(entry.getKey()), newCapacity);
                entry.next = table[i];
                table[i] = entry;
            }
        }
    }
}
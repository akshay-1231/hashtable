package hash;

public class HashTable {
	private static final int SIZE = 10;
	private Integer[] keys;
	private String[] values;

	public HashTable() {
		keys = new Integer[SIZE];
		values = new String[SIZE];
	}

	private int hash(int key) {
		return key % SIZE;
	}

	public void insert(int key, String value) {
		int index = hash(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
             
				values[index] = value;
				return;
			}
			index = (index + 1) % SIZE;
		}

		keys[index] = key;
		values[index] = value;
	}

	public String get(int key) {
		int index = hash(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				return values[index];
			}
			index = (index + 1) % SIZE;
		}

		return null;
	}

	public boolean remove(int key) {
		int index = hash(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				keys[index] = null;
				values[index] = null;
				return true;
			}
			index = (index + 1) % SIZE;
		}

		return false;
	}

	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (int i = 0; i < SIZE; i++) {
			if (keys[i] != null) {
				result.append(keys[i]).append(": ").append(values[i]).append(", ");
			}
		}
		if (result.length() > 1) {
			result.setLength(result.length() - 2);
		}
		result.append("}");
		return result.toString();
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.insert(1, "one");
		hashTable.insert(2, "two");
		hashTable.insert(10, "ten");
		hashTable.insert(14, "fourteen");
		hashTable.insert(16, "sixten");
		

		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(2));
		System.out.println(hashTable.get(10));
		System.out.println(hashTable.get(14));
		System.out.println(hashTable.get(16));
		
		hashTable.remove(2);
		System.out.println(hashTable);
	}
}

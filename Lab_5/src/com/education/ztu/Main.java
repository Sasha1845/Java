package com.education.ztu;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // =========================
        // Завдання 3: Динамічний масив
        // =========================
        System.out.println("=== ArrayList ===");
        List<Product> products = new ArrayList<>();
        Product p1 = new Product("Apple", 1.2);
        Product p2 = new Product("Banana", 0.8);
        Product p3 = new Product("Orange", 1.5);

        products.add(p1);
        products.add(p2);
        products.add(p3);

        List<Product> moreProducts = Arrays.asList(new Product("Kiwi", 2.0), new Product("Mango", 2.5));
        products.addAll(moreProducts);

        System.out.println("ArrayList: " + products);
        System.out.println("Get element at index 1: " + products.get(1));
        System.out.println("Index of Banana: " + products.indexOf(p2));
        System.out.println("Last index of Banana: " + products.lastIndexOf(p2));

        products.remove(p2);
        System.out.println("After removing Banana: " + products);

        products.set(0, new Product("Pineapple", 3.0));
        System.out.println("After set element at index 0: " + products);

        Collections.sort(products);
        System.out.println("After sort: " + products);

        List<Product> sublist = products.subList(1, 3);
        System.out.println("Sublist(1,3): " + sublist);

        System.out.println("Contains Mango? " + products.contains(new Product("Mango", 2.5)));
        System.out.println("Is empty? " + products.isEmpty());
        System.out.println("Size: " + products.size());

        Object[] array = products.toArray();
        System.out.println("ToArray: " + Arrays.toString(array));

        System.out.println("\n=== Iterator ===");
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\n=== ListIterator ===");
        ListIterator<Product> listIterator = products.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        // =========================
        // Завдання 4: Черга ArrayDeque
        // =========================
        System.out.println("\n=== ArrayDeque ===");
        ArrayDeque<Product> queue = new ArrayDeque<>();
        queue.push(p1);
        queue.offerLast(p2);
        queue.offerLast(p3);

        System.out.println("Queue: " + queue);
        System.out.println("First element: " + queue.getFirst());
        System.out.println("Peek last: " + queue.peekLast());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Remove last: " + queue.removeLast());
        System.out.println("Poll last: " + queue.pollLast());
        System.out.println("Queue after operations: " + queue);

        // =========================
        // Завдання 5: Множина TreeSet
        // =========================
        System.out.println("\n=== TreeSet ===");
        TreeSet<Product> set = new TreeSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println("TreeSet: " + set);
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("HeadSet(Orange): " + set.headSet(new Product("Orange", 0)));
        System.out.println("SubSet(Apple, Orange): " + set.subSet(new Product("Apple",0), new Product("Orange",0)));
        System.out.println("TailSet(Banana): " + set.tailSet(new Product("Banana",0)));
        System.out.println("Ceiling(Apple): " + set.ceiling(new Product("Apple",0)));
        System.out.println("Floor(Mango): " + set.floor(new Product("Mango",0)));
        System.out.println("Higher(Apple): " + set.higher(new Product("Apple",0)));
        System.out.println("Lower(Orange): " + set.lower(new Product("Orange",0)));
        System.out.println("Poll first: " + set.pollFirst());
        System.out.println("Poll last: " + set.pollLast());
        System.out.println("Descending set: " + set.descendingSet());

        // =========================
        // Завдання 6: Map HashMap
        // =========================
        System.out.println("\n=== HashMap ===");
        Map<String, Product> map = new HashMap<>();
        map.put("Apple", p1);
        map.put("Banana", p2);
        map.put("Orange", p3);

        System.out.println("Map: " + map);
        System.out.println("Get Apple: " + map.get("Apple"));
        System.out.println("Contains key Banana? " + map.containsKey("Banana"));
        System.out.println("Contains value p2? " + map.containsValue(p2));
        map.putIfAbsent("Kiwi", new Product("Kiwi",2));
        System.out.println("After putIfAbsent: " + map);

        Set<Map.Entry<String, Product>> entries = map.entrySet();
        for(Map.Entry<String, Product> entry : entries){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // =========================
        // Завдання 7: Collections
        // =========================
        System.out.println("\n=== Collections ===");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5,3,8,1,9));
        System.out.println("Original list: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        System.out.println("Binary search for 3: " + Collections.binarySearch(numbers, 3));

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        Collections.fill(numbers, 0);
        System.out.println("Fill with 0: " + numbers);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Collections.copy(numbers2, Arrays.asList(9,9,9,9,9));
        System.out.println("After copy: " + numbers2);

        Collections.rotate(numbers2, 2);
        System.out.println("After rotate by 2: " + numbers2);

        Collection<Integer> checked = Collections.checkedCollection(numbers2, Integer.class);
        System.out.println("Checked collection: " + checked);

        System.out.println("Max: " + Collections.max(numbers2));
        System.out.println("Min: " + Collections.min(numbers2));
        System.out.println("Frequency of 9: " + Collections.frequency(numbers2, 9));
    }
}

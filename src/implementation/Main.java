package implementation;
public class Main {
    public static void main(String[] args) {
        // Create a new instance of myArrayList
        myArrayList<Integer> myList = new myArrayList<>();

        // Add elements to the list
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);

        // Print the elements of the list
        System.out.println("My List: " + myList); // Output: My List: [10, 20, 30, 40, 50]

        // Access elements by index
        System.out.println("Element at index 2: " + myList.get(2)); // Output: Element at index 2: 30

        // Modify an element at a specific index
        myList.set(3, 45);
        System.out.println("My List after setting index 3 to 45: " + myList); // Output: My List after setting index 3 to 45: [10, 20, 30, 45, 50]

        // Check if the list contains an element
        System.out.println("Contains 30? " + myList.contains(30)); // Output: Contains 30? true
        System.out.println("Contains 25? " + myList.contains(25)); // Output: Contains 25? false

        // Find the index of an element
        System.out.println("Index of 30: " + myList.indexOf(30)); // Output: Index of 30: 2
        System.out.println("Index of 25: " + myList.indexOf(25)); // Output: Index of 25: -1

        // Find the last index of an element
        System.out.println("Last index of 45: " + myList.lastIndexOf(45)); // Output: Last index of 45: 3
        System.out.println("Last index of 60: " + myList.lastIndexOf(60)); // Output: Last index of 60: -1

        // Create a sublist from index 1 to 4 (excluding index 4)
        List<Integer> sublist = myList.subList(1, 4);
        System.out.println("Sublist: " + sublist); // Output: Sublist: [20, 30, 45]

        // Remove an element by value
        myList.remove(Integer.valueOf(20));
        System.out.println("My List after removing 20: " + myList); // Output: My List after removing 20: [10, 30, 45, 50]

        // Remove an element by index
        myList.remove(2);
        System.out.println("My List after removing element at index 2: " + myList); // Output: My List after removing element at index 2: [10, 30, 50]

        // Check if the list is empty
        System.out.println("Is the list empty? " + myList.isEmpty()); // Output: Is the list empty? false

        // Get the size of the list
        System.out.println("Size of the list: " + myList.size()); // Output: Size of the list: 3

        // Clear the list
        myList.clear();
        System.out.println("My List after clearing: " + myList); // Output: My List after clearing: []

        // Check if the list is empty after clearing
        System.out.println("Is the list empty after clearing? " + myList.isEmpty()); // Output: Is the list empty after clearing? true
    }
}

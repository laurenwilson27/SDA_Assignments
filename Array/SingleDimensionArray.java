package Array;

import java.util.Arrays;

public class SingleDimensionArray{
    int[] arr;

    public SingleDimensionArray(int sizeOfArray){
        arr = new int[sizeOfArray];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }

    public void insert(int location, int valueToInsert){
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToInsert;
                System.out.println("Successfully inserted");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array");
        } catch (NullPointerException e) {
            System.out.println("Cannot insert into an empty array.");
        }
    }

    // 2. Traverses the array contained by the class, printing each value in the array to output
    //      Uninitialized values are omitted
    public void traverse() {
        // Use a try-catch, in case traversal of a blank array is attempted
        try {
            for (int i : arr) {
                if (i != Integer.MIN_VALUE)
                    System.out.println(i);
            }

            // Print one last line for tidiness.
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Cannot traverse array because it contains no data.");
        }
    }

    // 3. Deletes the value from a specified index in the array.
    //      If no index is specified, deletes the full array.
    public void delete(int index) {
        try {
            arr[index] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot delete from index " + index + " because it does not exist.");
        } catch (NullPointerException e) {
            System.out.println("Cannot delete from array because it contains no data.");
        }
    }

    public void delete() {
        arr = null;
    }

    // 4. Searches for a value in the array.
    //      Returns the index of a match if one is found, otherwise returns -1.
    public int search(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }

        // If no match is found after the loop, return -1.
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }


    public static void main(String[] args) {
        //create the object of the class
        SingleDimensionArray singleDimensionArray = new SingleDimensionArray(8);
        singleDimensionArray.insert(0,1);
        singleDimensionArray.insert(1,2);
        singleDimensionArray.insert(2,3);
        singleDimensionArray.insert(3,4);
        singleDimensionArray.insert(4,5);
        singleDimensionArray.insert(5,3);
        singleDimensionArray.insert(6,4);
        singleDimensionArray.insert(7,5);
        // System.out.println(singleDimensionArray.toString());
        System.out.println(singleDimensionArray);

        // Test traverse and delete
        singleDimensionArray.traverse();
        singleDimensionArray.delete(3);
        singleDimensionArray.delete(100);
        singleDimensionArray.traverse();

        // Test exception catch for invalid insert
        singleDimensionArray.insert(100, 100);

        // Test search
        System.out.print("The first instance of '5' is at index: ");
        System.out.println(singleDimensionArray.search(5));
        System.out.print("The first instance of '9' is at index: ");
        System.out.println(singleDimensionArray.search(9));

        // Test full delete
        System.out.println(singleDimensionArray);
        singleDimensionArray.delete();
        System.out.println(singleDimensionArray);

        // Test exception catching for empty array
        singleDimensionArray.insert(0, 0);
        singleDimensionArray.traverse();
    }
}

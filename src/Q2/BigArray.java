package Q2;

public class BigArray {
    public static void main(String[] args) {
        int[] array = new int[19];
        for (int lcv = 0; lcv < array.length; lcv++) {
            array[lcv] = (int)(Math.random() * (91 - 20) + 20);
        }

        // 1. Print the Array from the beginning to the end
        for (int lcv = 0; lcv < array.length; lcv++) {
            System.out.print(array[lcv] + " ");
        }
        System.out.println();

        // 2. Print the Array from the beginning to the end using a for-each loop
        for (int temp : array) {
            System.out.print(temp + " ");
        }
        System.out.println();

        // 3. What number is in the middle of the Array?
        System.out.println("The middle number is " + array[array.length / 2]);

        // 4. What is the average of the first, last, and middle numbers?
        double avg = array[0] + array[array.length - 1] + array[array.length / 2];
        System.out.println("Average of the first, middle, and last numbers is " + (avg/3));

        // 5. Find the smallest and the largest number in the Array
        int smallest = array[0];
        int largest = array[0];
        for (int num : array) {
            if (num < smallest) smallest = num;
            if (num > largest)  largest  = num;
        }
        System.out.println("The smallest number is " + smallest);
        System.out.println("The largest number is " + largest);

        // 6. Switch the largest with the smallest number. Print the list
        for (int lcv = 0; lcv < array.length; lcv++) {
            if (array[lcv] == smallest)
                array[lcv] = largest;
            else if (array[lcv] == largest)
                array[lcv] = smallest;
        }

        for (int x : array)
            System.out.print(x + " ");
        System.out.println();

        // 7. Create a new random from 1 to 10 and insert it in the middle slot. Print the numbers.
        int randNum = (int)(Math.random() * 10 + 1);
        array[array.length / 2] = randNum;

        for (int x : array)
            System.out.print(x + " ");
        System.out.println();

        // 8. Add 10 to every number in the List. Print all.
        for (int lcv = 0; lcv < array.length; lcv++)
            array[lcv] += 10;

        for (int x : array) System.out.print(x + " ");
        System.out.println();

        // 9. Replace the 3rd element in the array with 5 and print the number that was ousted (only use one method to complete this.)
        int myThird = array[2];
        array[2] = 5;
        System.out.println("The number that was ousted is " + myThird);

        // 10. What numbers are in the 50s?
        // 11. What numbers are multiples of 4?
        // 12. Is there a 60 in the list?
        // 13. Check to see if all the elements from front to back are in the same order from back to front
        // 14. How many numbers are greater than the average?
        // 15. How many of the numbers are even?
        // 16. Copy all of the elements of the array into a new array but in reverse order
        // 17. Write a program to shift every element of an array circularly right. E.g.-INPUT : 1 2 3 4 5 OUTPUT : 5 1 2 3 4
        // 18. Find the sum of all of the digits of all of the elements
    }
}

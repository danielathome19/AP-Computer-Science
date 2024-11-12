package Q2;

public class BigArray {
    public static void main(String[] args) {
        int[] array = new int[19];
        for (int lcv = 0; lcv < array.length; lcv++)
            array[lcv] = (int) (Math.random() * (91 - 20) + 20);  // random * (max-min) + min

        // 1. Print the Array from the beginning to the end
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        // 2. Print the Array from the beginning to the end using a for-each loop
        for (int temp : array)  // for every int in array
            System.out.print(temp + " ");
        System.out.println();

        // 3. What number is in the middle of the Array?
        System.out.println("The middle number is: " + array[array.length / 2]);

        // 4. What is the average of the first, last and middle numbers?
        double avg = array[0] + array[array.length - 1] + array[array.length / 2];
        System.out.println("Average of first, middle, and last numbers is: " + (avg/3));

        // 5. Find the smallest and the largest number in the Array
        int smallest = array[0];
        int largest  = array[0];
        for (int num : array) {
            if (num < smallest) smallest = num;
            if (num > largest)  largest  = num;
        }
        System.out.println("Smallest number: " + smallest);
        System.out.println("Largest number: "  + largest);

        // 6. Switch the largest with smallest number. Print the list
        int smallIndex = -1;
        int largeIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == smallest) smallIndex = i;
            if (array[i] == largest)  largeIndex = i;
        }

        int tempswap      = array[smallIndex];
        array[smallIndex] = array[largeIndex];
        array[largeIndex] = tempswap;

        for (int x : array)
            System.out.print(x + " ");
        System.out.println();

        // 7. Create a new random from 1 to 10 and insert it in the middle slot. Print the numbers.
        int randNum = (int) (Math.random() * 10 + 1);
        array[array.length / 2] = randNum;

        for (int x : array)
            System.out.print(x + " ");
        System.out.println();

        // 8. Add 10 to every number in the List. Print all.
        for (int i = 0; i < array.length; i++)
            array[i] += 10;

        for (int x : array) System.out.print(x + " ");
        System.out.println();

        // 9. Replace the 3rd element in the array with 5 and print the number that was ousted (only use one method to complete this.)
        int myThird = array[2];
        array[2] = 5;
        System.out.println("The number that was ousted is " + myThird);

        // 10. What numbers are in the 50s?
        for (int num : array)
            if (num >= 50 && num <= 59)
                System.out.print(num + " ");
        System.out.println();

        // 11. What numbers are multiples of 4?
        for (int i = 0; i < array.length; i++)
            if (array[i] % 4 == 0)
                System.out.print(array[i] + " ");
        System.out.println();

        // 12. Is there a 60 in the list?
        boolean sixty = false;
        for (int n : array)
            if (n == 60) sixty = true;
        System.out.println("Is 60 in the list: " + sixty);

        // 13. Check to see if all of the elements from front to back
        // are in the same order from back to front
        boolean same = true;
        for (int lcv = 0; lcv < array.length; lcv++)
            if (array[lcv] != array[(array.length-1) - lcv])
                same = false;
        System.out.println("Is the array palindromic: " + same);

        // 14. How many numbers are greater than the average?
        double average = 0;
        for (int x : array)
            average += x;
        average /= array.length;

        int avgCount = 0;
        for (int x : array)
            if (x > average) avgCount++;
        System.out.printf("There are %d numbers greater than the average\n", avgCount);

        // 15. How many of the numbers are even?
        int evens = 0;
        for (int num : array)
            if (num % 2 == 0) evens++;
        System.out.printf("There are %d even numbers\n", evens);

        // 16. Copy all of the elements of the array into a new array but in reverse order
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++)
            array2[i] = array[(array.length-1) - i];

        for (int n : array2)
            System.out.print(n + " ");
        System.out.println();

        // 17. Write a program to shift every element of an array circularly right.
        // E.g.-INPUT : 1 2 3 4 5 OUTPUT : 5 1 2 3 4
        int[] shiftArr = circularShiftRight(array);
        for (int n : shiftArr)
            System.out.print(n + " ");
        System.out.println();

        // 18. Find the sum of all of the digits of all of the elements
        int sum = 0;
        for (int num : array) {
            int digitsum = 0;
            int temp = num;
            while (temp > 0) {
                int n = temp % 10;
                temp /= 10;
                digitsum += n;
            }
            sum += digitsum;
        }
        System.out.println("Sum of all digits of all elements: " + sum);
    }

    public static int[] circularShiftRight(int[] arr) {
        int temp = arr[arr.length - 1];
        int[] shifted = new int[arr.length];
        for (int lcv = 1; lcv < arr.length; lcv++)
            shifted[lcv] = arr[lcv-1];
        shifted[0] = temp;
        return shifted;
    }
}












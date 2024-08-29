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
        for (int num : array) {
            if (num >= 50 && num <= 59)
                System.out.print(num + " ");
        }
        System.out.println();

        // 11. What numbers are multiples of 4?
        for (int lcv = 0; lcv < array.length; lcv++) {
            if (array[lcv] % 4 == 0) {
                System.out.print(array[lcv] + " ");
            }
        }
        System.out.println();

        // 12. Is there a 60 in the list?
        boolean sixty = false;
        for (int temp : array) {
            if (temp == 60) sixty = true;
        }
        System.out.println("Is 60 in the list? " + sixty);

        // 13. Check to see if all the elements from front to back
        // are in the same order from back to front
        boolean same = true;
        for (int lcv = 0; lcv < array.length; lcv++ ) {
            if (array[lcv] != array[array.length - 1 - lcv])
                same = false;
        }
        System.out.println("Is the array palindromic? " + same);

        // 14. How many numbers are greater than the average?
        double average = 0;
        for (int x : array)
            average += x;
        average /= array.length;

        int count = 0;
        for (int x : array)
            if (x > average) count++;
        System.out.printf("There are %d numbers greater than the average\n", count);

        // 15. How many of the numbers are even?
        int evens = 0;
        for (int num : array)
            if (num % 2 == 0) evens++;
        System.out.printf("There are %d even numbers\n", evens);

        // 16. Copy all the elements of the array into a new array but in reverse order
        int[] array2 = new int[array.length];
        for (int lcv = 0; lcv < array.length; lcv++)
            array2[lcv] = array[array.length - 1 - lcv];

        for (int n : array2)
            System.out.print(n + " ");
        System.out.println();

        // 17. Write a program to shift every element of an array circularly right.
        // E.g.-INPUT : 1 2 3 4 5 OUTPUT : 5 1 2 3 4
        int[] shiftArr = circularShiftRight(array);
        for (int n : shiftArr)
            System.out.print(n + " ");
        System.out.println();

        // 18. Find the sum of all the digits of all the elements
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
        System.out.println("Sum of all digits of all elements = " + sum);
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

/*
38 28 35 38 54 66 39 70 32 61 32 32 75 48 54 46 47 24 58
38 28 35 38 54 66 39 70 32 61 32 32 75 48 54 46 47 24 58
The middle number is 61
Average of the first, middle, and last numbers is 52.333333333333336
The smallest number is 24
The largest number is 75
38 28 35 38 54 66 39 70 32 61 32 32 24 48 54 46 47 75 58
38 28 35 38 54 66 39 70 32 3 32 32 24 48 54 46 47 75 58
48 38 45 48 64 76 49 80 42 13 42 42 34 58 64 56 57 85 68
The number that was ousted is 45
58 56 57
48 48 64 76 80 64 56 68
Is 60 in the list? false
Is the array palindromic? false
There are 9 numbers greater than the average
There are 14 even numbers
68 85 57 56 64 58 34 42 42 13 42 80 49 76 64 48 5 38 48
68 48 38 5 48 64 76 49 80 42 13 42 42 34 58 64 56 57 85
Sum of all digits of all elements = 186
*/
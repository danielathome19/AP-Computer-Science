// Daniel Szelogowski
// 11/15/2022
// Big Array Part I
public class BigArray {
    /*
    Make an Array. Fill it with 19 random numbers from 20 to 90

    1. Print the Array from the beginning to the end
    2. Print the Array from the beginning to the end using a for-each loop
    3. What number is in the middle of the Array?
    4. What is the average of the first, last and middle numbers?
    5. Find the smallest and the largest number in the Array
    6. Switch the largest with smallest number. Print the list
    7. Create a new random from 1 to 10 and insert it in the middle slot. Print the numbers.
    8. Add 10 to every number in the List. Print all.
    9. Replace the 3rd element in the array with 5 and print the number that was ousted (only use one method to complete this.)
    10. What numbers are in the 50s?
    11. What numbers are multiples of 4?
    12. Is there a 60 in the list?
    13. Check to see if all of the elements from front to back are in the same order from back to front
    14. How many numbers are greater than the average?
    15. How many of the numbers are even?
    16. Copy all of the elements of the array into a new array but in reverse order
    17. Write a program to shift every element of an array circularly right. E.g.-INPUT : 1 2 3 4 5 OUTPUT : 5 1 2 3 4
    18. Find the sum of all of the digits of all of the elements
    */
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

        // 4. What is the average of the first, last and middle numbers?
        double avg = array[0] + array[array.length - 1] + array[array.length / 2];
        System.out.println("Average of the first, middle, and last numbers is " + (avg/3));

        // 5. Find the smallest and the largest number in the Array
        int smallest = array[0];
        int largest = array[0];
        for (int num : array) {
            if (num < smallest)
                smallest = num;
            if (num > largest)
                largest = num;
        }
        System.out.println("The smallest number is " + smallest);
        System.out.println("The larger number is " + largest);

        // 6. Switch the largest with smallest number. Print the list
        for (int lcv = 0; lcv < array.length; lcv++) {
            if (array[lcv] == smallest)
                array[lcv] = largest;
            else if (array[lcv] == largest)
                array[lcv] = smallest;
        }

        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();

        // 7. Create a new random from 1 to 10 and insert it in the middle slot. Print the numbers.
        int randNum = (int)(Math.random() * 10 + 1);
        array[array.length / 2] = randNum;

        for (int x : array)
            System.out.print(x + " ");
        System.out.println();

        // 8. Add 10 to every number in the List. Print all.
        for (int lcv = 0; lcv < array.length; lcv++) {
            array[lcv] += 10;
        }

        for (int x : array) System.out.print(x + " ");
        System.out.println();

        // 9. Replace the 3rd element in the array with 5 and print the number that was ousted
        // (only use one method to complete this.)
        int mythird = array[2];
        array[2] = 5;
        System.out.println("The number that was ousted is " + mythird);


        // 10. What numbers are in the 50s?
        for (int num : array) {
            if (num >= 50 && num <= 59) {
                System.out.print(num + " ");
            }
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
            if (temp == 60)
                sixty = true;
        }
        System.out.println("Is 60 in the list? " + sixty);

        // 13. Check to see if all of the elements from front to back
        // are in the same order from back to front
        boolean same = true;
        for (int lcv = 0; lcv < array.length; lcv++) {
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
            if (num % 2 == 0) {
                evens++;
            }
        System.out.printf("There are %d even numbers\n", evens);

        // 16. Copy all of the elements of the array into a new array but in reverse order
        int[] array2 = new int[array.length];
        for (int lcv = 0; lcv < array.length; lcv++) {
            array2[lcv] = array[array.length - 1 - lcv];
        }

        for (int n : array2)
            System.out.print(n + " ");
        System.out.println();

        // 17. Write a program to shift every element of an array circularly right. E.g.-INPUT : 1 2 3 4 5 OUTPUT : 5 1 2 3 4
        int[] shiftArray = circularShiftRight(array);
        for (int num : shiftArray)
            System.out.print(num + " ");
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
        System.out.println("Sum of all digits of all elements = " + sum);
    }

    public static int[] circularShiftRight(int[] arr) {
        int temp = arr[arr.length - 1];
        int[] shifted = new int[arr.length];
        for (int lcv = 0; lcv < arr.length; lcv++)
            shifted[lcv] = arr[lcv];

        for (int lcv = 0; lcv < shifted.length - 1; lcv++) {
            shifted[lcv + 1] = arr[lcv];
        }
        shifted[0] = temp;
        return shifted;
    }
}
/*
81 49 22 52 49 81 39 34 32 43 84 74 81 89 89 90 35 61 26
81 49 22 52 49 81 39 34 32 43 84 74 81 89 89 90 35 61 26
The middle number is 43
Average of the first, middle, and last numbers is 50.0
The smallest number is 22
The larger number is 90
81 49 90 52 49 81 39 34 32 43 84 74 81 89 89 22 35 61 26
81 49 90 52 49 81 39 34 32 8 84 74 81 89 89 22 35 61 26
91 59 100 62 59 91 49 44 42 18 94 84 91 99 99 32 45 71 36
The number that was ousted is 100
59 59
44 84 32 36
Is 60 in the list? false
Is the array palindromic? false
There are 9 numbers greater than the average
There are 8 even numbers
36 71 45 32 99 99 91 84 94 18 42 44 49 91 59 62 5 59 91
36 91 59 5 62 59 91 49 44 42 18 94 84 91 99 99 32 45 71
Sum of all digits of all elements = 199
*/
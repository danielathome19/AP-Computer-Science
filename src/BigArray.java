// Daniel Szelogowski
// 11/15/2022
// Big Array
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

    }
}

package week1;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            if (digits[index] != 9) {
                digits[index] += 1;
                for (int i = index + 1; i < digits.length; i++) {
                    digits[i] = 0;
                }
                return digits;
            }
            index--;
        }

        int[] arr = new int[digits.length + 1];
        arr[0] = 1;

        return arr;
    }
}

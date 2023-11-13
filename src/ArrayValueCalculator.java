public class ArrayValueCalculator {
    public static int doCalc(String[][] numbers) throws ArraySizeException, ArrayDataException {

        if (numbers.length != 4 || numbers[0].length != 4 || numbers[1].length != 4 || numbers[2].length != 4 || numbers[3].length != 4) {
            throw new ArraySizeException("Array must be of size 4x4");
        }

        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                try {
                    result += Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data at index [" + i + "][" + j + "]", e);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[][] testNumbers = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "nn"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = doCalc(testNumbers);
            System.out.println("Result: " + result);
        } catch (ArraySizeException e) {
            System.out.println("ArraySizeException: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("ArrayDataException: " + e.getMessage());

            Throwable originalException = e.getCause();
            if (originalException != null) {
                System.out.println("Original Exception: " + originalException.getClass().getSimpleName());
                System.out.println("Original Exception Message: " + originalException.getMessage());
            } else {
                System.out.println("No original exception available.");
            }
        }
    }
}
package Controller;

public class StringSplitter {
    public static String[] splitString(String input, String delimiter) {
        if (input == null || delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("Input and delimiter must not be null or empty.");
        }
        return input.split(delimiter);
    }

    public static void main(String[] args) {
        String input = "apple#banana#cherry#date";
        String delimiter = "#";

        // Call the splitString function
        String[] result = splitString(input, delimiter);

        // Print the results
        for (String part : result) {
            System.out.println(part);
        }
    }
}

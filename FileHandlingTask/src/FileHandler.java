
import java.io.*;
import java.util.Scanner;

public class FileHandler {

    // Constant to store the file name used for all operations
    static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        // Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Display operation choices to the user
        System.out.println("Choose Operation:\n1. Write\n2. Read\n3. Modify");
        int choice = scanner.nextInt();  // Get user's choice
        scanner.nextLine(); // Consume leftover newline character after nextInt()

        // Perform operation based on user's choice
        switch (choice) {
            case 1:
                writeToFile(scanner); // Call write function
                break;
            case 2:
                readFromFile(); // Call read function
                break;
            case 3:
                modifyFile(scanner); // Call modify function
                break;
            default:
                System.out.println("Invalid choice!"); // Handle invalid input
        }

        scanner.close(); // Close the scanner resource
    }

    // Method to write user input content to file
    public static void writeToFile(Scanner scanner) {
        try {
            // Create BufferedWriter to write to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            System.out.println("Enter content to write:");
            String content = scanner.nextLine(); // Read content from user
            writer.write(content); // Write content to file
            writer.close(); // Close the writer
            System.out.println("Content written to " + FILE_NAME);
        } catch (IOException e) {
            // Handle file writing exceptions
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read and display content of file
    public static void readFromFile() {
        try {
            // Create BufferedReader to read from file
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("Contents of " + FILE_NAME + ":");
            // Read and print each line from the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close(); // Close the reader
        } catch (IOException e) {
            // Handle file reading exceptions
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file by replacing its entire content
    public static void modifyFile(Scanner scanner) {
        try {
            // First read the existing content
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            StringBuilder content = new StringBuilder(); // To store current file content
            String line;

            // Read all lines and append to StringBuilder
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close(); // Close the reader

            // Show current content to user
            System.out.println("Current content:");
            System.out.println(content);

            // Ask user for new content
            System.out.println("Enter new content to replace:");
            String newContent = scanner.nextLine();

            // Write new content to the file (overwrite mode)
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(newContent); // Replace with new content
            writer.close(); // Close the writer

            System.out.println("File modified successfully.");
        } catch (IOException e) {
            // Handle exceptions in modifying file
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}

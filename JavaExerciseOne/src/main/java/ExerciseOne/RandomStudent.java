package ExerciseOne;

import java.io.*;
import java.util.Random;

public class RandomStudent {
    // Pre-create a size of 10 string array to store the name
    private String[] nameArray = new String[10];

    // Declare the number of line for dynamically using
    private int numberOfLines = 0;

    // The name randomly chosen;
    private String randomName = null;

    // Getter for randomName
    public String getRandomName() {
        return this.randomName;
    }

    // Choose a random name
    public void chooseRandomName() throws Exception {
        // Read file and store names into array
        this.setUpNameArray();

        // Get the random prepared for choosing a random name
        Random rand = new Random();

        // Get the random number
        int random = rand.nextInt(numberOfLines);

        // Get the name
        String nameBeChosen = nameArray[random];

        // Display the Student Name that got selected
        System.out.println("The student: *** " + nameBeChosen + " *** is chosen");

        this.randomName = nameBeChosen;
    }

    // Read from file and store the name into array
    private void setUpNameArray() throws Exception {
        // Get the file
        File file = new File("src/main/resources/NameList.txt");

        // Create buffered reader to read the file
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declare the line
        String line;

        // Get the number of line
        while ((line = br.readLine()) != null) {
            // Dynamically create nameList Array
            // If the length of array is smaller than the numberlines
            // which means it will out of bound
            // add array length
            if (numberOfLines >= nameArray.length - 1) {
                addLengthArray(nameArray);
            }

            // Store the name into array
            nameArray[numberOfLines++] = line;
        }
    }

    // Used for adding size to array
    private void addLengthArray(String[] array) {
        String[] newArray = new String[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.nameArray = newArray;
    }


}

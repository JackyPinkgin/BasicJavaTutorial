package controlflow;

public class ElseIfExample2 {
    public static void main(String[] args) {

        // Declare a variable int simulate your age.
        int age = 20;

        // Test age less than or equal 17
        if (age <= 17) {
            System.out.println("You are 17 or younger");
        }

        // Test age equals 18
        else if (age == 18) {
            System.out.println("You are 18 year old");
        }

        // Test age, greater than 18 and less than 40
        else if (age > 18 && age < 40) {
            System.out.println("You are between 19 and 39");
        }

        // Remaining cases (Greater than or equal to 40)
        else {
            // Nested if statements
            // Test age not equals 50.
            if (age != 50) {
                System.out.println("You are not 50 year old");
            }

            // Negative statements
            if (!(age == 50)) {
                System.out.println("You are not 50 year old");
            }

            // If age is 60 or 70
            if (age == 60 || age == 70) {
                System.out.println("You are 60 or 70 year old");
            }

        }

    }


}

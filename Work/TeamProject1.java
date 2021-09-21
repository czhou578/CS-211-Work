import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamProject1 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList < Person > names = new ArrayList < > ();
        Scanner scanner = new Scanner(System.in); //scan for user input
        boolean end = false; //scan for end of 
        String father;
        String mother;

        makeList(names); //push to method

        while (!end) {
            System.out.println("Type\"Quit\" to quit the program \n");
            System.out.println("Type in Name with Capitalization: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("Quit")) {
                System.out.println("You have quit the program!");
                System.exit(0);
                end = true; //works
            } else {
                System.out.println("Entered Name: " + name.toUpperCase());
                Person person = query(name, names);
                if (person != null) {
                    System.out.println("Maternal Line:");
                    System.out.println("\t" + name.toUpperCase());
                    mother = person.getMother();
                    if (mother == null) {
                        mother = "Mother Unknown";
                    }
                    System.out.println("\t\t" + mother);

                    System.out.println("Paternal Line:");
                    System.out.println("\t" + name.toUpperCase());
                    father = person.getFather();
                    if (father == null) {
                        father = "Father Unknown";
                    }
                    System.out.println("\t\t" + father);

                    System.out.println("Children:");
                    ArrayList < String > childList = new ArrayList < String > (person.getChildren());
                    for (String child: childList) {
                        System.out.println("\t" + child);
                    }
                } else {
                    System.out.println("The person was not found");
                }
                System.out.println("\n");
            }
        }
    }


    // Query method to get persons name.
    public static Person query(String name, ArrayList < Person > list) {
        for (int i = 0; i < list.size(); i++) {
            Person current = list.get(i);
            if (name.equalsIgnoreCase(current.getName())) {
                return current;
            }
        }
        return null;
    }


    public static void makeList(ArrayList < Person > list) {
        // try-catch : FileNotFoundException
        try {
            Scanner scan = new Scanner(new File("C:\\Users\\mycol\\CS 211\\CS 211 Work\\src\\tudor (1).dat"));
            String name = "";
            String mother = "";
            String father = "";
            // do-while to read "first" list in doc.
            do {
                // scan the name and create it as a person then add it to list.
                name = scan.nextLine();
                if (!name.equalsIgnoreCase("END")) list.add(new Person(name));
            } while (!name.equalsIgnoreCase("END"));
            // scan through next list.
            do {
                // scan the name, call the person from list.
                // assign mother and father;
                name = scan.nextLine();
                // if statement to catch end of list before continuing.
                if (name.equalsIgnoreCase("END")) break;
                mother = scan.nextLine();
                father = scan.nextLine();
                // Query method to find the Person
                Person p = query(name, list);
                if (p != null) {
                    p.addMother(mother);
                    p.addFather(father);
                }

                // Query method to find the mother
                Person m = query(mother, list);
                if (m != null) m.addChildren(name);

                // Query method to find the FATHER
                Person d = query(father, list);
                if (d != null) d.addChildren(name);

            } while (!name.equalsIgnoreCase("END") && !mother.equalsIgnoreCase("END") && !father.equalsIgnoreCase("END"));
            //CLOSE YOUR SCANNERS
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught in Catch block: file not found");
        }
    } // END PARSE METHOD
}
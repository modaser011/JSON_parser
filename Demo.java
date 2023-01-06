
import Parsing.Catalogue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class Demo {

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {

        Catalogue catalogue = new Catalogue();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {

                System.out.println("my Application - JSON \n\n" + "--------------------------------------------\n"
                        + "1. Add More builds \n" + "--------------------------------------------\n"
                        + "2. Search for a Specific build in terms of city or year \n"
                        + "3. delete a Specific build \n"

                        + "--------------------------------------------\n" + "4. Exit \n"
                        + "--------------------------------------------\n");

                System.out.print("Enter operation number U want do it: ");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        catalogue.addbuild();
                        System.out.println("**********************************************************\n");

                        break;
                    case "2":
                        System.out.println("Enter Search Key **(city or year)");
                        String key = sc.nextLine();
                        catalogue.searchByKey(key);
                        break;
                        case "3":
                        System.out.println("Enter Search Key **(city or year)");
                        String key2 = sc.nextLine();
                        catalogue.delete(key2);
                        break;
                    case "4":
                        System.out.println("-------- Thank U ------------");
                        return;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }

                System.out.println("\n\n\n");
            }
        }

    }

}

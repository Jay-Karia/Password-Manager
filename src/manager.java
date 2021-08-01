import java.util.Objects;
import java.util.Scanner;
import java.io.*;
public class manager {
    public static void main(String[] args){
        println("Welcome to Java Password Manager Developed -- By Jay (v-1.0)");
        println("\nWhat do you want to Do?\n1) Enter a New Password\n2) Retrieve Your Password");
        String sel;
        Scanner selection = new Scanner(System.in);
        sel = selection.nextLine();
        if (sel.equals("1")) {
            println("\nSelected: 1) Enter a new Password");

            println("\nEnter your name");
            Scanner name = new Scanner(System.in);
            String n = name.nextLine();

            println("\nEnter your Message");
            Scanner purpose = new Scanner(System.in);
            String p = purpose.nextLine();

            println("\nYour Password");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();
            boolean valid;
            do {
                valid = true;
                println("Confirm your Password");
                Scanner newPass = new Scanner(System.in);
                String newPassword = newPass.nextLine();

                if (Objects.equals(password, newPassword)) {
                    println("Password is Set!");
                    println("\nEnter the Security Key for your Password");
                    Scanner security = new Scanner(System.in);
                    String key = security.nextLine() + ".txt";
                    setPassword(key, n, password, p);
                } else {
                    println("Your password doesn't match! Try again");
                    valid = false;
                }
            } while (!valid);
        } else if (sel.equals("2")) {
            println("\nSelected: 2) Retrieve Your Password");
            println("\nEnter the Security Key to retrieve your password");
            Scanner sec = new Scanner(System.in);
            String newSec = sec.nextLine();
            getPass(newSec);
        }
    }

    private static void getPass(String key) {
        try {
            File f = new File(key + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

        } catch (Exception i) {
            println("Could not get your Password!! Sorry");
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void setPassword(String securityKey, String name, String password, String purpose) {

        try {
            File file = new File(securityKey);
            Writer writer = new FileWriter(file);

            writer.write("Name: " + name);
            writer.write("\nPassword: " + password);
            writer.write("\nMessage: " + purpose);
            writer.write("\nSecurity Key: " +  securityKey);
            println("\nYour Password is Successfully Saved!");


            writer.flush();
            writer.close();
        } catch (IOException ex) {
            println("\nAn Error occurred while storing your Password! Sorry");
        }

    }
}
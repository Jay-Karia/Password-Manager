import java.util.Objects;
import java.util.Scanner;
import java.io.*;
public class manager {
    public static void main(String[] args) throws IOException {
        println("Welcome to Java Password Manager Developed -- By Jay (v-1.0)");

        println("\n1) Set your Custom Directory where your password will be saved\n2) Keep it Default");
        String cDir = null;
        Scanner Sel = new Scanner(System.in);
        String s = Sel.next();
        if (s.equals("1")) {
            println("Selected: 1) Custom Directory");
            Scanner custom = new Scanner(System.in);
            cDir = custom.nextLine();
            System.out.println("You Directory is set to: " + cDir);
        } else if (s.equals("2")) {
            println("\nSelected: 2) Default Directory");
            cDir = new java.io.File(".").getCanonicalPath();
            System.out.println("Default Directory is set: " + cDir);
        }

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
            Scanner mess = new Scanner(System.in);
            String message = mess.nextLine();

            println("\nYour Password");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();
            boolean valid;
            println("Confirm your Password");
            do {
                valid = true;
                Scanner newPass = new Scanner(System.in);
                String newPassword = newPass.nextLine();

                if (Objects.equals(password, newPassword)) {
                    println("Password is Set!");
                    println("\nEnter the Security Key for your Password");
                    Scanner security = new Scanner(System.in);
                    String key = security.nextLine();
                    /*Setting a Password*/
                    try {
                        File file = new File(cDir+key + ".txt");
                        Writer writer = new FileWriter(file);

                        writer.write("Name: " + n);
                        writer.write("\nPassword: " + password);
                        writer.write("\nMessage: " + message);
                        writer.write("\nSecurity Key: " +  key);
                        println("\nYour Password is Successfully Saved!");


                        writer.flush();
                        writer.close();
                    } catch (IOException ex) {
                        println("\nAn Error occurred while storing your Password! Sorry");
                    }
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
            try {
                File f = new File(cDir + newSec + ".txt");
                BufferedReader br = new BufferedReader(new FileReader(f));
                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }

            } catch (Exception i) {
                println("Could not get your Password!! Sorry");
            }
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }
}
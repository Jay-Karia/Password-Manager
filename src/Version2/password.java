package Version2;

import java.util.Objects;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class password {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws IOException {
        println("Welcome to Java Password Manager Developed -- By Jay (v-1.0)");

        println("\n1) Set your Custom Directory\n2) Keep it Default");
        String cDir = null;
        Scanner Sel = new Scanner(System.in);
        String s = Sel.next();
        if (s.equals("1")) {
            println("Selected: 1) Custom Directory");
            Scanner custom = new Scanner(System.in);
            cDir = custom.nextLine() + "\\";
            System.out.println("You Directory is set to: " + cDir);
        } else if (s.equals("2")) {
            println("\nSelected: 2) Default Directory");
            cDir = new java.io.File(".").getCanonicalPath() + "\\";
            System.out.println("Default Directory is set: " + cDir);
        }

        println("\nWhat do you want to Do?\n1) Enter a New Password\n2) Retrieve Your Password\n3) Delete your Password");
        String sel;
        Scanner selection = new Scanner(System.in);
        sel = selection.nextLine();
        switch (sel) {
            case "1" -> {
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
                        println("\nPassword is Set!");
                        println("One last Step to go!\n");
                        println("Enter the Security Key for your Password");
                        Scanner security = new Scanner(System.in);
                        String key = security.nextLine();
                        /*Setting a Password*/
                        encode(key, cDir);
                    } else {
                        println("Your password doesn't match! Try again");
                        valid = false;
                    }
                } while (!valid);
            }
            case "2" -> {
                println("\nSelected: 2) Retrieve Your Password");
                println("\nEnter the Security Key to retrieve your password\n");
                Scanner sec = new Scanner(System.in);
                String newSec = sec.nextLine();
                try {
                    File f = new File(cDir + newSec + ".txt");
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String str;
                    while ((str = br.readLine()) != null) {
                        System.out.println(str);
                    }
                    br.close();

                } catch (Exception i) {
                    println("Could not get your Password!! Sorry");
                }
            }
            case "3" -> {
                println("Selected: 3) Delete your Password");
                println("\nEnter the Security Key to delete your password");
                Scanner del = new Scanner(System.in);
                String newDel = del.nextLine();
                try {
                    File delFile = new File(cDir + newDel + ".txt");
                    delFile.delete();
                    println("\nYour Password is Successfully Deleted!");
                } catch (Exception e) {
                    println("Could not Delete your Password! Sorry");
                }
            }
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void encode(String security, String Dir) {
        String[] n = {"|/|@mE", "nG45(^)", "*$%@!MI"};
        String[] p = {"********", "****************", "******"};
        String[] k = {"5E(UrItY", "||E()**", "S55!@#54HH"};
        String[] m = {"mE55@6E", "NEE67/**/", "/*CoMmENT*/"};

        String Name = null;
        String Password = null;
        String Message = null;
        String key = null;

        try {
            File file = new File(Dir + security + ".txt");
            Writer writer = new FileWriter(file);

            writer.write("LaWbC__s" + Name);
            writer.write("|)WWbg?>" + Password);
            writer.write("nCD<<>::;" + Message);
            writer.write("nth<,,>+=" + key);
            println("\nYour Password is Successfully Saved!");


            writer.flush();
            writer.close();
        } catch (IOException ex) {
            println("\nAn Error occurred while storing your Password! Sorry");
        }
    }
}
import java.util.Scanner;

public class Flames_Calcultor {
    public static void main(String args[]) {
        Flames_Calcultor obj = new Flames_Calcultor();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter First Person Name:");
        String name_1 = in.nextLine().replaceAll(" ", "").toUpperCase();

        System.out.println("Enter Second Person Name:");
        String name_2 = in.nextLine().replaceAll(" ", "").toUpperCase();

        System.out.println(obj.Flames(name_1, name_2));
    }

    private String Flames(String name_1, String name_2) {
        String temp1 = name_1;
        String temp2 = name_2;

        for (int i = 0; i < name_1.length(); i++) {
            for (int j = 0; j < name_2.length(); j++) {
                if (name_1.charAt(i) == name_2.charAt(j)) {
                    name_1 = name_1.replaceFirst("" + name_1.charAt(i), " ");
                    name_2 = name_2.replaceFirst("" + name_2.charAt(j), " ");
                    break;
                }
            }
        }

        String input = name_1.replaceAll(" ", "") + name_2.replaceAll(" ", "");
        String flamesChar = "FLAMES";

        while (flamesChar.length() != 1) {
            int removeChar = input.length() % flamesChar.length();
            if (removeChar != 0) {
                flamesChar = flamesChar.substring(removeChar) + flamesChar.substring(0, removeChar - 1);
            } else {
                flamesChar = flamesChar.substring(0, flamesChar.length() - 1);
            }
        }

        char finalChar = flamesChar.charAt(0);
        String relationship;

        switch (finalChar) {
            case 'F':
                relationship = "Friends";
                break;
            case 'L':
                relationship = "Love";
                break;
            case 'A':
                relationship = "Affection";
                break;
            case 'M':
                relationship = "Marriage";
                break;
            case 'E':
                relationship = "Enemies";
                break;
            case 'S':
                relationship = "Siblings";
                break;
            default:
                relationship = "Unknown";
        }
        
        return relationship;
    }
}

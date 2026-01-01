import java.util.Scanner;

public class SingleCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a single character: ");
        String userInput = input.next();

        if(userInput.length()!=1){
            System.out.print("Error message");
            return;
        }

        char ch = userInput.charAt(0);
       // char ch = input.next().charAt(0);


        if(!Character.isLetter(ch)){
            System.out.println("Error: Input is not a letter.");
            return;
        }
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
                ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            System.out.print("VOWEL");
        }
        else {
            System.out.print("Consonant");
        }



    }
}

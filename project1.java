import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class project1 {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("1PLAYER OR 2PLAYER?");
        Scanner sc = new Scanner(System.in);
        String players = sc.nextLine();
        String word;

        if(players.equals("1")){
            Scanner scanner = new Scanner(new File("C:/Users/User/OneDrive/Desktop/dictionary.txt"));  // a file that consist of all the random words
            // source -

            List<String> words = new ArrayList<>(); // to save words in list

            while (scanner.hasNext()) {           //to traverse through all the words and add it in our list
                words.add(scanner.nextLine());
            }

            Random rand = new Random();                          //random class
            word = words.get(rand.nextInt(words.size()));   //to pick a random word from the list and the size given is also random
        }
        else{
            System.out.println("Player 1, please enter your word - ");
            word = sc.nextLine();
            System.out.print("\n".repeat(50));
            System.out.println("'Ready for player 2, good luck!");
        }

        //System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();    // a list to save all the guesses by a place   //prints the current state of the word

        int wrongCount = 0;
        while(true){                                         //run the loop until yes
            //   -------
            //   |     |
            //   o
            //  \ /
            //   |
            //  / \
            printHangedMan(wrongCount);

            if(wrongCount>=6){
                System.out.println("YOU LOOSE!!");
                System.out.println("The word was - "+word);
                break;
            }

            printWordState(word, playerGuesses);                                        
            if(!getPlayerGuess( sc,  word, playerGuesses)){     // this method guesses the letter of the word given by user and match and does the task
                wrongCount++;
            }     
            
            if(printWordState(word, playerGuesses))   {        //checks whether the word guess made by player is right, if so, print
                System.out.println("YOU WIN!!!");
                break;
            }

            System.out.println("PLease enter your guess for the word");  //if not, give player another chance to guess letter and word

            if(sc.nextLine().equals(word)){                   //another case for win, if the guessed word matched with the given word
                System.out.println("YOU WIN!!!");
                break;
            }
            else{                                             //else, keep on trying again and again until certain condition
                System.out.println("Oops! Try again");
            }

        }
         
        

        
    }

    private static boolean printWordState(String word, List<Character> playerGuesses){
        int correctCount = 0;
        for(int i=0; i<word.length(); i++){                  // the loop runs through the word selected and if the char guessed right, it prints char at that 
                                                            // right position, else prints _ as it is        
            if(playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else{
                System.out.print("_");
            }

        }
        System.out.println();

        return (word.length()==correctCount);
    }

    
private static boolean getPlayerGuess(Scanner sc, String word, List<Character> playerGuesses) {    //this function whether the word contains the letter guessed or not
    System.out.println("Please enter your guess letter:");
    String letterGuess = sc.nextLine();

    playerGuesses.add(letterGuess.charAt(0));
    return word.contains(letterGuess);
}


private static void printHangedMan(Integer wrongCount){          //this is the function where the hangman appears as per the wrong guesses from user
    System.out.println(" -------");
            System.out.println(" |     |");

            if(wrongCount>=1){
                System.out.println(" o");
            }

            if(wrongCount>=2){
                System.out.print("\\");
                if(wrongCount>=3){
                System.out.println(" /");
                }
                if(wrongCount>=4){
                System.out.println(" |");
                }
                if(wrongCount>=5){
                    System.out.print("/");
                }
                if(wrongCount>=6){
                    System.out.print(" \\");
                }
                else{
                    System.out.print("");
                }
            }

            System.out.println("");
            System.out.println("");

}

}
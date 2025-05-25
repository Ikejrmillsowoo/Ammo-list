package codewithike.demo;

import codewithike.demo.models.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordValidator {

    private Word wordToGuess;// = "";
    private char playerGuesses;// = ' ';
    private int numOfGuesses;// = 0;
    private String playerInputString;// = "";
    private boolean restartGame = false;
    private char[] arr1;

    public WordValidator(Word wordToGuess, char playerGuesses, int numOfGuesses, String playerInputString, boolean restartGame, char[] arr1) {
        this.wordToGuess = wordToGuess;
        this.playerGuesses = playerGuesses;
        this.numOfGuesses = numOfGuesses;
        this.playerInputString = playerInputString;
        this.restartGame = restartGame;
        this.arr1 = arr1;
    }

    public WordValidator(Word wordToGuess){
        this.wordToGuess = wordToGuess;
        this.numOfGuesses = wordToGuess.getWordLength();
    }

    public void runGame() {
        //starts the game with prompt for input and assign
        selectWordToGuess();
        announceGame();
        initializeGame(wordToGuess.length());
        while (numOfGuesses > 0 && !restartGame) {
            playerNextGuess();
            compareStrings();
        }
        if (restartGame) {
            wordToGuess = "";
            playerGuesses = ' ';
            numOfGuesses = 0;
            playerInputString = "";
            restartGame = false;
            arr1 = new char[wordToGuess.length()];
            runGame();
        }

    }

    public void selectWordToGuess() {
        int rand = (int) (Math.random() * wordBank.length);
        wordToGuess = wordBank[rand];
        numOfGuesses = wordBank[rand].length();
    }

    public void announceGame() {
        System.out.println("There is a secret word that has been selected:");
        System.out.println("The game is about you guessing the word.");
        //System.out.println(wordToGuess);
    }

    public char getPlayerInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        char response = (char) sc.next().charAt(0);
        return response;
    }

    public void initializeGame(int x) {
        char[] arr = new char[x];
        Arrays.fill(arr, '_');
        arr1 = arr;
        playerInputString = Arrays.toString(arr);
        System.out.println("Word to guess: " + playerInputString);
    }

    public void displayPlayerGuesses() {
        System.out.println("Word to guess: " + Arrays.toString(arr1));
    }

    public void playerNextGuess() {
        playerGuesses = getPlayerInput("Guess your letter ");
    }

    public ArrayList<Integer> checkIfLetterIsInWord() {
        String s = Character.toString(playerGuesses);
        ArrayList<Integer> indexes = new ArrayList<>();
        int indexForLetter = 0;
        char[] wordToGuessArr = wordToGuess.toCharArray();
        for (int i = 0; i < wordToGuessArr.length; i++) {
            if (wordToGuessArr[i] == playerGuesses) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public boolean isGuessedSuccessful() {

        ArrayList<Integer> indexes = checkIfLetterIsInWord();
        for (Integer index : indexes) {
            arr1[index] = playerGuesses;
        }
        if (indexes.isEmpty()) {
            numOfGuesses--;
            return false;
        }
        return true;
    }

    public void compareStrings() {
        //Print array to show where player is at.

        boolean guessedSuccessful = isGuessedSuccessful();
        System.out.println(Arrays.toString(arr1));
        //System.out.println(wordToGuess);
        if (guessedSuccessful && Arrays.equals(wordToGuess.toCharArray(), arr1)) {
            playerWon();
        } else if (numOfGuesses == 0) {
            playerLost();
        }
        displayPlayerGuesses();
    }

    public void playerWon() {
        //print message
        char userInput = getPlayerInput("You won, Do you want to play again? 1-Yes, 2-No");
        keepPlayOrQuit(userInput);
    }

    public void playerLost() {
        //print sad message
        System.out.println("You run out of guesses:");
        char userInput = getPlayerInput("You lost, Do you want to play again? 1-Yes, 2-No");
        keepPlayOrQuit(userInput);

    }

    public void keepPlayOrQuit(char c) {
        if (c == '1') {
            restartGame = true;
        } else if (c == '2') {
            System.out.println("Thanks for playing!");
            System.exit(0); //game exits here
        }
    }
}

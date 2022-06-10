package com.hang.man.game;

import com.hang.man.game.util.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HangmanGame {

    private final HangmanWord word;
    private final HashMap<String, GuessResult> guesses;

    public HangmanGame() {

        this.word = HangmanWord.getRandomWord();
        this.guesses = new HashMap<>();
        // set up the game.
    }

    public int getIncorrectGuessCount() {

        return (int) guesses.values().stream().filter(e -> e == GuessResult.INCORRECT).count();

    }

    private Set<String> getWrongGuesses() {
        return guesses.entrySet().
                stream().
                filter(entry -> entry.getValue() != GuessResult.CORRECT).
                map(Map.Entry::getKey).
                collect(Collectors.toSet());
    }



    /**
     * @return A pair consisting of the result of the guess and the end state given
     * by this guess.
     */
    public Pair<GuessResult, EndState> guess(String guess) {

        guess = guess.toLowerCase().trim(); // e

        EndState endState;
        GuessResult result = GuessResult.INCORRECT; // default.

        if ("".equals(guess) || 0 == guess.length() || " ".equals(guess) ) return new Pair<>(GuessResult.INVALID_BLANK, EndState.NIL);

        if (guesses.containsKey(guess)) {
            // don't allow duplicates. but don't make them lose because of it.
            return new Pair<>(GuessResult.INVALID_DUPLICATE, EndState.NIL);
        }
        if (!WordUtil.isChar(guess)) { // if its a full word
            if (word.equals(guess)) { // then check if it's correct
                return new Pair<>(GuessResult.CORRECT, EndState.WIN); // if it is, you win!
            }
        } else {
//            only one character to check.
            if (word.contains(guess)) {
                result = GuessResult.CORRECT;
            }
        }

        endState = getIncorrectGuessCount() + (result == GuessResult.INCORRECT ? 1 : 0) >= HangmanConstants.MAX_INCORRECT_GUESSES - 1
                ? EndState.LOSE : EndState.NIL;

        return new Pair<>(result, endState);
    }

    public void printPlatformState() {
        System.out.println(platformState());
    }


    /**
     * Nobody else really needs this, only us.
     */
    private String platformState() {
        return getPlatformPrintState(this);
    }

    protected static String getPlatformPrintState(HangmanGame game) {
        return HangmanConstants.PLATFORM_STATES[game.getIncorrectGuessCount()];
    }

    private String getWordOutputState() {
        return WordUtil.underlineWord(Arrays.stream(word.word().split(""))
                        .map(e -> guesses.get(e) == GuessResult.CORRECT ? e : " ")
                        .collect(Collectors.joining("")));
//                : cantThinkOfAName();
    }

    private String cantThinkOfAName() {

        int count = word.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String at;
            if (guesses.containsKey(at = String.valueOf(word.word().charAt(i)))) {
                sb.append(at);

            } else {
                sb.append("_");
            }
            sb.append(" ");

        }

        return sb.toString().trim();
    }

    // TODO
    private String getIncorrectGuessOutputState() {
        if (guesses.size() < 1) return "";
        StringBuilder sb = new StringBuilder();
        getWrongGuesses().forEach(e -> sb.append(e).append(" "));
        return sb.toString();
    }

    public void printFullGameState() {
        printPlatformState();

        var maker = new StringMaker();
        var characterStates = maker.color16(StringMaker.Color16.FG_RED)
                .raw(getIncorrectGuessOutputState())
                .raw("\n")
                .color16(StringMaker.Color16.FG_GREEN)
                .raw(getWordOutputState()) // characterStates words are green
                .toString();
        System.out.println(characterStates);
    }


    private void tick() {

        if (Arrays.stream(word.word().split(""))
                .allMatch(guesses::containsKey)) {
            System.out.println("You WIN!"); // pre-check to see if all letters have been guessed already.
            return;
        }

        WordUtil.clearScreen();
        printFullGameState(); // update the user with what everything looks like.

        var userInputInputStream = new UserInputInputStream();
        var guess = userInputInputStream.readWord().toLowerCase().trim();

        final var state = guess(guess);
//        only add if its wrong or right.
        if (state.left() == GuessResult.CORRECT || state.left() == GuessResult.INCORRECT)  guesses.put(guess, state.left());
        printFullGameState(); // update the user with what everything looks like.


        switch (state.right()) {
            case WIN -> System.out.println("YOU WIN!");
            case NIL -> tick();
            case LOSE -> System.out.println("You lost.");
        }

    }

    public void run() {
        tick();
    }

}

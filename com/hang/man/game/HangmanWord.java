package com.hang.man.game;

import com.hang.man.game.util.WordUtil;

import java.util.Collections;

public record HangmanWord(String word, int length) {

    /**
     * @return A random word picked frmo the Words class
     * @see WordUtil
     */
    public static HangmanWord getRandomWord() {

        Collections.shuffle(WordUtil.WORD_CHOICES);
        var word = WordUtil.WORD_CHOICES.get(0);
        return new HangmanWord(word, word.length());
    }


    public boolean contains(String needle) {
        return word.toLowerCase().contains(needle.toLowerCase());
    }

    public boolean equals(String needle) {
        return needle.equalsIgnoreCase(word);
    }
}
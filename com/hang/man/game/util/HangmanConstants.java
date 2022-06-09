package com.hang.man.game.util;

public class HangmanConstants {


    public static final int MAX_INCORRECT_GUESSES = 7;

    /**
     * The states for when you get a question wrong.
     */
// Platform generously supplied on github by Chris Horton
// You can find it here: https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c
    public static final String[] PLATFORM_STATES = {"""
  +---+
  |   |
      |
      |
      |
      |
=========
""", """
  +---+
  |   |
  O   |
      |
      |
      |
=========
""", """

  +---+
  |   |
  O   |
  |   |
      |
      |
=========
""", """

  +---+
  |   |
  O   |
 /|   |
      |
      |
=========

""", """

  +---+
  |   |
  O   |
 /|\\ |
      |
      |
=========
""", """
  +---+
  |   |
  O   |
 /|\\  |
 /    |
      |
=========\040

""", """

  +---+
  |   |
  O   |
 /|\\ |
 / \\ |
      |
=========
"""};

}

package com.hang.man.game.util;

/**
 *
 * The results for a guess
 */
public enum GuessResult {

    CORRECT,
    INCORRECT,
    /**
     * User has already guessed this.
     *
     */
    DUPLICATE,
    /**
     *
     * User tried inputting nothing
     */
    INVALID_BLANK,
	/*
		User tried to guess something they already guessed.
	*/
	INVALID_DUPLICATE


}

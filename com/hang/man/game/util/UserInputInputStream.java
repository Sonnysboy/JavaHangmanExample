package com.hang.man.game.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class UserInputInputStream {

    private static final BufferedReader consoleIO;

    private static final class ConsoleInputHolder {
        public static final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        public static BufferedReader getBr() {
            return br;
        }
    }

    public int readInt() {
        try {
            return consoleIO.read();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @return An entire null-terminated line of input.
     */
    public String readLine() {
        try {
            return consoleIO.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return A single word.
     */
    public String readWord() {
        try {
            return consoleIO.readLine().split(" ")[0];
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return ""; // nothing was entered.
        }
    }

    /*
     * @return A single double value.
     */
    public double readDouble() {
        try {

            return Double.parseDouble(readWord());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.d;
        }
    }

    /**
     * @return A single long value.
     */
    public long readLong() {
        try {

            return Long.parseLong(readWord());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @return A single float.
     */
    public float readFloat() {

        try {

            return Float.parseFloat(readWord());
        } catch (Exception e) {
            e.printStackTrace();
            return 0.f;
        }
    }

    static {
        consoleIO = ConsoleInputHolder.getBr();
    }

}
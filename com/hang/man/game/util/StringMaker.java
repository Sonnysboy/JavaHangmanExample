package com.hang.man.game.util;

/**
 * This is a direct port of https://github.com/nathan-fiscaletti/ansi-util
 *
 * @author Nathan Fiscaletti
 * <p>
 * Usage:
 * <p>
 * StringMaker sb = new StringMaker();
 * <p>
 * System.out.println(
 * sb.raw("Hello, ")
 * .underline("John Doe")
 * .resetUnderline()
 * .raw(". ")
 * .raw("This is ")
 * .color16(StringMaker.Color16.FG_RED, "red")
 * .raw(".")
 * );
 */
public class StringMaker {
    /**
     * The current String.
     *
     * @var String
     */
    private String string = "";

    /**
     * Reset the hidden flag.
     *
     * @return StringMaker
     */
    public StringMaker resetHidden() {
        return this.resetHidden("");
    }

    /**
     * Reset the hidden flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker resetHidden(String value) {
        this.ansi(Integer.toString(28));
        this.raw(value);

        return this;
    }

    /**
     * Reset the invert colors flag.
     *
     * @return StringMaker
     */
    public StringMaker resetInvertColors() {
        return this.resetInvertColors("");
    }

    /**
     * Reset the hidden flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker resetInvertColors(String value) {
        this.ansi(Integer.toString(27));
        this.raw(value);

        return this;
    }

    /**
     * Reset the blink flag.
     *
     * @return StringMaker
     */
    public StringMaker resetBlink() {
        return this.resetBlink("");
    }

    /**
     * Reset the blink flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker resetBlink(String value) {
        this.ansi(Integer.toString(25));
        this.raw(value);

        return this;
    }

    /**
     * Reset the underline flag.
     *
     * @return StringMaker
     */
    public StringMaker resetUnderline() {
        return this.resetUnderline("");
    }

    /**
     * Reset the underline flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker resetUnderline(String value) {
        this.ansi(Integer.toString(24));
        this.raw(value);

        return this;
    }

    /**
     * Reset the dim flag.
     *
     * @return StringMaker
     */
    public StringMaker resetDim() {
        return this.resetDim("");
    }

    /**
     * Reset the dim flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker resetDim(String value) {
        this.ansi(Integer.toString(22));
        this.raw(value);

        return this;
    }

    /**
     * Reset the bold flag.
     *
     * @return StringMaker
     */
    public StringMaker resetBold() {
        return this.resetBold("");
    }

    /**
     * Reset the bold flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker resetBold(String value) {
        this.ansi(Integer.toString(21));
        this.raw(value);

        return this;
    }

    /**
     * Reset to default.
     *
     * @return StringMaker
     */
    public StringMaker reset() {
        return this.reset("");
    }

    /**
     * Reset to default.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker reset(String value) {
        this.ansi(Integer.toString(0));
        this.raw(value);

        return this;
    }

    /**
     * Set the hide flag.
     *
     * @return StringMaker
     */
    public StringMaker hide() {
        return this.hide("");
    }

    /**
     * Set the hide flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker hide(String value) {
        this.ansi(Integer.toString(8));
        this.raw(value);

        return this;
    }

    /**
     * Set the invert color flag.
     *
     * @return StringMaker
     */
    public StringMaker invertColor() {
        return this.invertColor("");
    }

    /**
     * Set the invert color flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker invertColor(String value) {
        this.ansi(Integer.toString(7));
        this.raw(value);

        return this;
    }

    /**
     * Set the blink flag.
     *
     * @return StringMaker
     */
    public StringMaker blink() {
        return this.blink("");
    }

    /**
     * Set the invert flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker blink(String value) {
        this.ansi(Integer.toString(5));
        this.raw(value);

        return this;
    }

    /**
     * Set the underline flag.
     *
     * @return StringMaker
     */
    public StringMaker underline() {
        return this.underline("");
    }

    /**
     * Set the underline flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker underline(String value) {
        this.ansi(Integer.toString(4));
        this.raw(value);

        return this;
    }

    /**
     * Set the dim flag.
     *
     * @return StringMaker
     */
    public StringMaker dim() {
        return this.dim("");
    }

    /**
     * Set the dim flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker dim(String value) {
        this.ansi(Integer.toString(2));
        this.raw(value);

        return this;
    }

    /**
     * Set the bold flag.
     *
     * @return StringMaker
     */
    public StringMaker bold() {
        return this.bold("");
    }

    /**
     * Set the bold flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker bold(String value) {
        this.ansi(Integer.toString(1));
        this.raw(value);

        return this;
    }

    /**
     * Set a 16-bit color.
     *
     * @param color Color16
     * @return StringMaker
     */
    public StringMaker color16(Color16 color) {
        return this.color16(color, "");
    }

    /**
     * Set a 16-bit color.
     *
     * @param color Color16
     * @param value String
     * @return StringMaker
     */
    public StringMaker color16(Color16 color, String value) {
        this.ansi(Integer.toString(color.getValue()));
        this.raw(value);

        return this;
    }

    /**
     * Set a 256-bit color.
     *
     * @param color int
     * @return StringMaker
     */
    public StringMaker color256(int color) throws Exception {
        return this.color256(color, "");
    }

    /**
     * Set a 256-bit color.
     *
     * @param color int
     * @param value String
     * @return StringMaker
     */
    public StringMaker color256(int color, String value) throws Exception {
        if (color < 0 || color > 256) {
            throw new Exception("Valid 256-bit colors must be within the range of 0 and 256.");
        }

        this.ansi("38;5;" + color);
        this.raw(value);

        return this;
    }

    /**
     * Set a 256-bit background color.
     *
     * @param color int
     * @return StringMaker
     */
    public StringMaker backgroundColor256(int color) throws Exception {
        return this.backgroundColor256(color, "");
    }

    /**
     * Set a 256-bit background color.
     *
     * @param color int
     * @param value String
     * @return StringMaker
     */
    public StringMaker backgroundColor256(int color, String value) throws Exception {
        if (color < 0 || color > 256) {
            throw new Exception("Valid 256-bit colors must be within the range of 0 and 256.");
        }

        this.ansi("48;5;" + color);
        this.raw(value);

        return this;
    }

    public StringMaker pad(int amount, String paddingString) {

        this.raw(String.format("%-" + amount + "s", paddingString));
        return this;
    }


    public StringMaker pad(int amount) {
        return pad(amount, " ");
    }

    /**
     * Appends a raw String.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker raw(String value) {
        this.string += value;
        return this;
    }

    /**
     * Add a custom ANSI flag.
     *
     * @param value String
     * @return StringMaker
     */
    public StringMaker ansi(String value) {
        this.string += "\u001b[" + value + "m";
        return this;
    }

    /**
     * Build the final string.
     *
     * @return StringMaker
     */
    @Override
    public String toString() {
        this.reset();
        return this.string;
    }

    /**
     * Color16 values.
     */
    public enum Color16 {
        FG_RESET(39),
        FG_BLACK(30),
        FG_RED(31),
        FG_GREEN(32),
        FG_YELLOW(33),
        FG_BLUE(34),
        FG_MAGENTA(35),
        FG_CYAN(36),
        FG_LIGHT_GRAY(37),
        FG_DARK_GRAY(90),
        FG_LIGHT_RED(91),
        FG_LIGHT_GREEN(92),
        FG_LIGHT_YELLOW(93),
        FG_LIGHT_BLUE(94),
        FG_LIGHT_MAGENTA(95),
        FG_LIGHT_CYAN(96),
        FG_WHITE(97),
        BG_RESET(49),
        BG_BLACK(40),
        BG_RED(41),
        BG_GREEN(42),
        BG_YELLOW(43),
        BG_BLUE(44),
        BG_MAGENTA(45),
        BG_CYAN(46),
        BG_LIGHT_GRAY(47),
        BG_DARK_GRAY(100),
        BG_LIGHT_RED(101),
        BG_LIGHT_GREEN(102),
        BG_LIGHT_YELLOW(103),
        BG_LIGHT_BLUE(104),
        BG_LIGHT_MAGENTA(105),
        BG_LIGHT_CYAN(106),
        BG_WHITE(107);

        private final int value;

        public int getValue() {
            return value;
        }

        Color16(int value) {
            this.value = value;
        }
    }
}
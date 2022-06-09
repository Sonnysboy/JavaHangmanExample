package com.hang.man.game.util;


public class OperatingSystems {


    public static boolean isWindows() {
        return System.getProperty("os.name")
                .toLowerCase()
                .contains("win");
    }
}

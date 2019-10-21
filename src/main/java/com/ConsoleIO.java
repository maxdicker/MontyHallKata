package com;

public class ConsoleIO implements IO {

    @Override
    public void printLine(String s) {
        System.out.println(s);
    }
}

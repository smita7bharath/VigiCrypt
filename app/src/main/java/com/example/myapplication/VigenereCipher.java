package com.example.myapplication;

public class VigenereCipher {
    private static final int ALPHABET_SIZE = 26;

    public static String encrypt(String input, String key) {
        StringBuilder output = new StringBuilder();
        int keyIndex = 0;
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                output.append(c);
                continue;
            }
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int shift = key.charAt(keyIndex) - 'A';
            char encryptedChar = (char) ((c - base + shift) % ALPHABET_SIZE + base);
            output.append(encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }
        return output.toString();
    }

    public static String decrypt(String input, String key) {
        StringBuilder output = new StringBuilder();
        int keyIndex = 0;
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                output.append(c);
                continue;
            }
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int shift = key.charAt(keyIndex) - 'A';
            char decryptedChar = (char) ((c - base - shift + ALPHABET_SIZE) % ALPHABET_SIZE + base);
            output.append(decryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }
        return output.toString();
    }

}

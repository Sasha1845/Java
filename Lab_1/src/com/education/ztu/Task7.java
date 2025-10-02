package com.education.ztu;
public class Task7 {
    public static void main(String[] args) {
        char[] letters = new char[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('A' + i);
        }
        for (char c : letters) {
            System.out.println(c + " ==> " + (int) c);
        }
    }
}

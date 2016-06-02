package ua.nure.social.util;

import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();

    public String generateName(int from, int to, char[] alphabet) {
        char[] name = new char[getInt(from, to)];
        for(int i = 0; i < name.length; i++) {
            name[i] = alphabet[getInt(0, alphabet.length - 1)];
        }
        return new String(name);
    }

    public int getInt(int from, int to) {
        return random.nextInt(to - from + 1) + from;
    }
}

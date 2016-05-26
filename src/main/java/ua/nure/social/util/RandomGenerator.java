package ua.nure.social.util;

import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();

    public String generateName(int from, int to) {
        char[] name = new char[getInt(from, to)];
        for(int i = 0; i < name.length; i++) {
            name[i] = (char)getInt(97, 122);
        }
        return new String(name);
    }

    public int getInt(int from, int to) {
        return random.nextInt(from - to + 1) + to;
    }
}

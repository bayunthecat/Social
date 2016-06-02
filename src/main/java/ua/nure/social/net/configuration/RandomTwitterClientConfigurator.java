package ua.nure.social.net.configuration;

@SuppressWarnings("unused")
public class RandomTwitterClientConfigurator {

    private static final String SPLIT_REGEX = "(?!^)";

    private int[] nameLengthRange;

    private int[] followersCountRange;

    private int[] friendsCountRange;

    private char[] alphabet;

    public int getNameLengthLower() {
        return nameLengthRange[0];
    }

    public int getNameLengthHigher() {
        return nameLengthRange[1];
    }

    public int getFollowersLower() {
        return followersCountRange[0];
    }

    public int getFollowersHigher() {
        return followersCountRange[1];
    }

    public int getFriendsLower() {
        return friendsCountRange[0];
    }

    public int getFriendsHigher() {
        return friendsCountRange[1];
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        String[] splitArray = alphabet.split(SPLIT_REGEX);
        this.alphabet = new char[splitArray.length];
        for(int i = 0; i < splitArray.length; i++) {
            splitArray[i].getChars(0, 1, this.alphabet, i);
        }
    }

    public void setNameLengthRange(int[] nameLengthRange) {
        this.nameLengthRange = trimLength(nameLengthRange);
    }

    public void setFollowersCountRange(int[] followersCountRange) {
        this.followersCountRange = trimLength(followersCountRange);
    }

    public void setFriendsCountRange(int[] friendsCountRange) {
        this.friendsCountRange = trimLength(friendsCountRange);
    }

    private int[] trimLength(int[] array) {
        int[] correctArray = array.clone();
        if(array.length > 2) {
            correctArray = new int[2];
            System.arraycopy(array, 0, correctArray, 0, correctArray.length);
        }
        return correctArray;
    }
}
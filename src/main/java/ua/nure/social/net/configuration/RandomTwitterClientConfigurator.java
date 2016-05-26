package ua.nure.social.net.configuration;

public class RandomTwitterClientConfigurator {

    private int[] nameLengthRange;

    private int[] followersCountRange;

    private int[] friendsCountRange;

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
package ua.nure.social.net.tools.limit;

import twitter4j.RateLimitStatus;

public class CustomRateLimitStatus implements RateLimitStatus {



    @Override
    public int getRemaining() {
        return 0;
    }

    @Override
    public int getLimit() {
        return 0;
    }

    @Override
    public int getResetTimeInSeconds() {
        return 0;
    }

    @Override
    public int getSecondsUntilReset() {
        return 0;
    }
}

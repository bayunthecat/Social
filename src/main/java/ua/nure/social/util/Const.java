package ua.nure.social.util;

public class Const {

    public static final String CURLY_OPENING_BRACKET = "{";

    public static final String CURLY_CLOSING_BRACKET = "}";

    public static final String COMMA = ",";

    public static final String WHITESPACE = " ";

    public static final String COLON = ":";

    public static final String DOT = ".";

    public static class Neo4j {

        public static final class Node {

            public static final String USER = "User";

            private Node() {
            }
        }

        public static class Relationship {

            public static final String FOLLOWER = "FOLLOWS";

            public static final String FRIEND = "FRIEND_WITH";

            private Relationship() {
            }
        }

        public static class Property {

            public static final String SCREEN_NAME = "screenName";

            public static final String COUNTRY = "country";

            private Property() {
            }
        }

        public static class Configuration {

            public static final String BASE_PACKAGE = "ua.nure.social";

            public static final String REPO_PACKAGE = "ua.nure.social.repository";

            private Configuration() {
            }
        }
    }

    private Const() {
    }
}

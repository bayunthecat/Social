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

    public static class Spring {

        public static class Components {

            public static final String TWITTER_PAGABLE_TRANSFORMER = "twitterPagableTransformer";

            private Components() {
            }
        }

        public static class Scope {

            public static final String PROTOTYPE = "prototype";

            private Scope() {
            }
        }

        private Spring() {
        }
    }

    public static class App {

        public static final int DEFAULT_DEPTH = 2;

        public static final int SECONDS_TO_MILLIS = 1000;

        public static final int SAFE_THRESHOLD = 1000;

        private App() {
        }
    }

    private Const() {
    }
}

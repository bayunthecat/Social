package ua.nure.social.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {

    @SuppressWarnings("unchecked")
    public static <T> Collection<T> getCollectionsAsOne(Collection<T>... collections) {
        List<T> unitedCollection = new ArrayList<>();
        for(Collection col : collections) {
            unitedCollection.addAll(col);
        }
        return unitedCollection;
    }
}

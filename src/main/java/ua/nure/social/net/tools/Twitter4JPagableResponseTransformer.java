package ua.nure.social.net.tools;

import twitter4j.PagableResponseList;

import java.util.ArrayList;
import java.util.List;

public class Twitter4JPagableResponseTransformer implements ResponseTransformer<PagableResponseList<?>, List<?>> {

    @Override
    public List<?> transform(PagableResponseList<?> response) {
        List<Object> transformedResponse = new ArrayList<>();
        transformedResponse.addAll(response);
        return transformedResponse;
    }
}

package ua.nure.social.net.tools.converter;

import twitter4j.PagableResponseList;

import java.util.ArrayList;
import java.util.List;

public class Twitter4JPagableResponseConverter implements ResponseConverter<PagableResponseList<?>, List<?>> {

    @Override
    public List<?> convert(PagableResponseList<?> response) {
        List<Object> transformedResponse = new ArrayList<>();
        transformedResponse.addAll(response);
        return transformedResponse;
    }
}

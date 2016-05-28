package ua.nure.social.net.tools.converter;

public interface ResponseConverter<F, T> {

    T convert(F response);

}

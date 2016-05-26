package ua.nure.social.net.tools;

public interface ResponseTransformer<F, T> {

    T transform(F response);

}

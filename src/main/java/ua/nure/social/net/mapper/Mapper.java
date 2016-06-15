package ua.nure.social.net.mapper;

import ua.nure.social.model.ModelEntity;

public interface Mapper<T extends ModelEntity>{

    T map(Object object);

}
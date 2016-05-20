package ua.nure.social.analytics.mapper;

import ua.nure.social.model.BaseItem;

public interface Mapper<T extends BaseItem>{

    T map(Object object);

}

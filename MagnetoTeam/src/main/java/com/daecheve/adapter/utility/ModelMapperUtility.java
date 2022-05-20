package com.daecheve.adapter.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 *
 * @author daecheve
 */
public class ModelMapperUtility {

    private static ModelMapper modelMapper = new ModelMapper();

    private ModelMapperUtility() {
    }

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
}

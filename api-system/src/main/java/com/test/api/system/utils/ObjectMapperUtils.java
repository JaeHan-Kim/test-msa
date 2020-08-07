package com.test.api.system.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * 
 * 클래스명: <code>ObjectMapperUtils</code><br/><br/>
 *
 * entity에서 dto로 변환 해주는 utils
 *
 * @since 2019. 12. 4.
 * @author JaeHan-Kim
 *
 */
public class ObjectMapperUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private ObjectMapperUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 
     * entity에서 outClass Dto로 변환
     *
     * @since 2019. 12. 4.
     * @author JaeHan-Kim
     *
     * @param <D>
     * @param <T>
     * @param entity
     * @param outClass
     * @return
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    /**
     * 
     * entity List를 outClass Dto List로 변환
     *
     * @since 2019. 12. 4.
     * @author JaeHan-Kim
     *
     * @param <D>
     * @param <T>
     * @param entityList
     * @param outClass
     * @return
     */
    public static <D, T> List<D> mapList(final Collection<T> entityList, Class<D> outClass) {
        return entityList.stream()
                .map(entity -> map(entity, outClass))
                .collect(Collectors.toList());
    }

    /**
     * 
     * 목록으로 조회된 entity Page를 outClass Dto Page로 변환
     *
     * @since 2019. 12. 4.
     * @author JaeHan-Kim
     *
     * @param <D>
     * @param <T>
     * @param entityPage
     * @param outClass
     * @return
     */
    /*
    public static <D, T> Page<D> mapPage(Page<T> entityPage, Class<D> outClass) {
        List<D> dtoList = mapList(entityPage.getContent(), outClass);
        return new CrewPageImpl<>(dtoList, entityPage.getPageable(), entityPage.getTotalElements());
    }
    */
}

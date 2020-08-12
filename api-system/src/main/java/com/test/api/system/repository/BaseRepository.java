package com.test.api.system.repository;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseRepository extends QuerydslRepositorySupport {

    public BaseRepository(Class<?> domainClass) {
        super(domainClass);
    }

    /**
     * 
     * querydsl의 숫자 비교 조건을 구성함.
     *
     * @since 2020. 05. 15.
     * @author JaeHan-Kim
     *
     * @param <T>
     * @param path
     * @param val
     * @return
     */
    public <T extends Number & Comparable<?>> BooleanExpression eq(NumberPath<T> path, T val) {
        if (val != null) {
            return path.eq(val);
        }

        return null;
    }

    /**
     * 
     * querydsl의 문자 비교 조건을 구성함.
     *
     * @since 2020. 05. 15.
     * @author JaeHan-Kim
     *
     * @param path
     * @param val
     * @return
     */
    public BooleanExpression eq(StringPath path, String val) {
        if (StringUtils.isNotEmpty(val)) {
            return path.eq(val);
        }

        return null;
    }

    /**
     * 
     * querydsl의 문자 비교 조건을 구성함.
     *
     * @since 2020. 05. 15.
     * @author JaeHan-Kim
     *
     * @param path
     * @param val
     * @return
     */
    public BooleanExpression ne(StringPath path, String val) {
        if (val != null) {
            return path.ne(val);
        }

        return null;
    }

    /**
     * 
     * querydsl의 문자 like 조건을 구성함.
     *
     * @since 2020. 05. 15.
     * @author JaeHan-Kim
     *
     * @param path
     * @param val
     * @return
     */
    public BooleanExpression like(StringPath path, String val) {
        if (val != null) {
            return path.like(val);
        }

        return null;
    }

    /**
     * 
     * querydsl의 문자 테이블 select 항목 전체를 구성해서 반환함.
     *
     * @since 2020. 1. 9.
     * @author JaeHan-Kim
     *
     * @param entity
     * @return
     */
    public Expression<?>[] getAllExpression(Object entity, Expression<?>...expressions) {
        Expression<?>[] arr = new Expression[] {};
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field f : fields) {
            try {
                if (f.getModifiers() == 26) { continue; }

                Expression<?> val = (Expression<?>) f.get(entity);

                if (val instanceof StringPath || val instanceof NumberPath || val instanceof DateTimePath) {
                    arr = (Expression[]) ArrayUtils.add(arr, val);
                }
            } catch (Exception e) {
                log.info("skip!");
            }
        }

        // 추가 Expression 적용
        for (Expression<?> e : expressions) {
            arr = (Expression[]) ArrayUtils.add(arr, e);
        }


        return arr;
    }
}

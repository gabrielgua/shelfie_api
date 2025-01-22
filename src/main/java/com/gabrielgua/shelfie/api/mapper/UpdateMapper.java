package com.gabrielgua.shelfie.api.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Component
public class UpdateMapper {

    public <T> void copyNonNullProperties(T source, T target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private String[] getNullPropertyNames(Object source) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(source.getClass()))
                .map(FeatureDescriptor::getName)
                .filter(name -> {
                    try {
                        return BeanUtils.getPropertyDescriptor(source.getClass(), name).getReadMethod().invoke(source) == null;
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        return false;
                    }
                })
                .toArray(String[]::new);
    }
}
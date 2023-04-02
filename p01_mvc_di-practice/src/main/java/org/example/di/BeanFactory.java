package org.example.di;

import org.example.controller.UserController;

import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanFactory {

    private final Set<Class<?>> preInstantatedClazz;
    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantatedClazz) {
        this.preInstantatedClazz = preInstantatedClazz;
    }

    public <T> T getBean(Class<T> requiredType) {
        return (T)beans.get(requiredType);
    }
}

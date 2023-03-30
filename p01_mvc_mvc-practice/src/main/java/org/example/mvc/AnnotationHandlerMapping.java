package org.example.mvc;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.controller.RequestMethod;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping {
    private final Object[] basePackage;
    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    public AnnotationHandlerMapping(Object ... basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }

    public void initialize() {
        Reflections reflections = new Reflections(basePackage);

        // HomeController
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Controller.class);

        typesAnnotatedWith.forEach(clazz -> {
            Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
                RequestMapping requestMapping = declaredMethod.getDeclaredAnnotation(RequestMapping.class);

                Arrays.stream(getRequestMapping(requestMapping))
                        .forEach(requestMethod -> handlers.put(
                                new HandlerKey(requestMethod, requestMapping.value()), new AnnotationHandler()
                        ));
            });
        });

    }

    private RequestMethod[] getRequestMapping(RequestMapping requestMapping) {
        return requestMapping.method();
    }
}

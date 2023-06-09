package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandler implements HandlerMapping{
    // URL path => key,
    // /users -> UserController
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        // annotation controller로 대체
        //mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET,"/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST,"/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET,"/user/form"), new ForwardController("/user/form.jsp"));
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }


}

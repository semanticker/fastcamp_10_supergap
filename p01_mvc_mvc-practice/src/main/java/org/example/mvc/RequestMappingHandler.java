package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;
import org.example.mvc.controller.UserCreateController;
import org.example.mvc.controller.UserListController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandler {
    // URL path => key,
    // /users -> UserController
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET,"/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST,"/users"), new UserCreateController());
    }

    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath);
    }


}

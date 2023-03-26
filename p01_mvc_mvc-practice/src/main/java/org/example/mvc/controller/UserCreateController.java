package org.example.mvc.controller;

import org.example.model.User;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements org.example.mvc.controller.Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userId = request.getParameter("userId");
        String name = request.getParameter("name");

        UserRepository.save(new User(userId, name ));

        //user 추가
        return "redirect:/users";
    }
}

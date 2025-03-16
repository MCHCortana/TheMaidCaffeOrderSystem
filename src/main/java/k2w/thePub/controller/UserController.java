package k2w.thePub.controller;

import k2w.thePub.dto.UserDTO;
import k2w.thePub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index").addObject("listOfUsers", service.getAll());
    }

    @PostMapping("/user-create")
    public @ResponseBody UserDTO create(@RequestBody UserDTO data) {
        return service.create(data);
    }

    @GetMapping("/users")
    public @ResponseBody List<UserDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/users/{id}")
    public @ResponseBody UserDTO getUserById(@PathVariable Long id) {
        return service.findUser(id);
    }

}

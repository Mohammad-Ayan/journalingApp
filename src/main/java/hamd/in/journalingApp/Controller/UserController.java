package hamd.in.journalingApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hamd.in.journalingApp.Entity.User;
import hamd.in.journalingApp.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> getAllUsers(){
       return userService.getAll();
        
    }
}
package hamd.in.journalingApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hamd.in.journalingApp.Entity.User;
import hamd.in.journalingApp.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Debugging: Log the received user object
        System.out.println("Received User: " + user);
        
        // Validate input
        if (user.getUserName() == null || user.getUserName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Username cannot be null or empty");
        }
        
        try {
            userService.saveEntry(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    

    @PutMapping("{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username){
         User userInDb =  userService.findByUserName(username);
       if(userInDb != null){
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveEntry(userInDb);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
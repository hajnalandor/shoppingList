package hu.flowacademy.shoppingList.Controller;

import hu.flowacademy.shoppingList.domain.User;
import hu.flowacademy.shoppingList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addElement(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<User>> Addlist(@RequestBody List<User> users) {
        return ResponseEntity.ok(userService.saveUserList(users));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteById(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getOneUser(username));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getlistUsers());
    }

}

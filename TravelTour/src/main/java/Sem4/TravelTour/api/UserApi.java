package Sem4.TravelTour.api;

import Sem4.TravelTour.config.JwtUtils;
import Sem4.TravelTour.entity.AppRole;
import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.User;
import Sem4.TravelTour.service.CartService.CartService;
import Sem4.TravelTour.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("api/auth")

public class UserApi {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;
    private final UserService userService;
    private final CartService cartService;
    @Autowired
    public UserApi(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id){
        if(!userService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.findById(id).get());
    }
    @GetMapping("email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        if(userService.exsitsByEmail(email)){
            return ResponseEntity.ok(userService.findByEmail(email).get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        if(userService.exsitsByEmail(user.getEmail())){
            return ResponseEntity.notFound().build();
        }
//        if(userService.existsById(user.getUserId())){
//            return ResponseEntity.badRequest().build();
//        }
        Set<AppRole> roles = new HashSet<>();
        roles.add(new AppRole(1, null)); //1 is user 2 is admin
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setToken(jwtUtils.doGenerateToken(user.getEmail()));
        User u = userService.save(user);
        Cart c = new Cart(0L, 0.0, u.getAddress(), u.getPhone(), u);
        cartService.save(c);
        return ResponseEntity.ok(u);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> put(@PathVariable("id") Long id, @RequestBody User user) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if (!id.equals(user.getUserId())) {
            return ResponseEntity.badRequest().build();
        }

        User temp = userService.findById(id).get();

        if (!user.getPassword().equals(temp.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        Set<AppRole> roles = new HashSet<>();
        roles.add(new AppRole(1, null));

        user.setRoles(roles);
        return ResponseEntity.ok(userService.save(user));
    }
    @PutMapping("admin/{id}")
    public ResponseEntity<User> putAdmin(@PathVariable("id") Long id, @RequestBody User user) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if (!id.equals(user.getUserId())) {
            return ResponseEntity.badRequest().build();
        }
        Set<AppRole> roles = new HashSet<>();
        roles.add(new AppRole(2, null));

        user.setRoles(roles);
        return ResponseEntity.ok(userService.save(user));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        User u = userService.findById(id).get();
        u.setStatus(false);
        userService.save(u);
        return ResponseEntity.ok().build();
    }
}
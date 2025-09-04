package br.edu.unipaulistana.backend.Blog.Controller;

import br.edu.unipaulistana.backend.Blog.domainmodel.User;
import br.edu.unipaulistana.backend.Blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//http://localhost:8080/users
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor //
public class UserController {

    // @Autowired criar quando der merda
   private final UserService userService;
    @GetMapping
   public List<User> findAll() {
       return this.userService.findAll();
    }
}

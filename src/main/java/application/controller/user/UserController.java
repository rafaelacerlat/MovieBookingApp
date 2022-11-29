package application.controller.user;

import application.service.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    EndUserService endUserService;

    @GetMapping("/{userId}/tickets")
    public ResponseEntity<Object> getScreeningsByMovie(@PathVariable long userId) {
        try {
            return new ResponseEntity<>(endUserService.getTicketsByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

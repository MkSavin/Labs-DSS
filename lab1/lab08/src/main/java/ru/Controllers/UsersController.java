package ru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Models.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final User user;

    public UsersController(User _user) {
        user = _user;
    }

    @GetMapping
    public String menu(Model ui) {
        ui.addAttribute("users", user.GetUsersList());
        return "list";
    }

    @GetMapping("/create")
    public String createForm() {
        return "create";
    }

    @PostMapping("/create")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("position") String position) {

        User user = new User();

        user.setName(name);
        user.setPosition(position);

        user.Create(user);

        return "redirect:edit/" + user.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        User.Delete(id);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model u) {
        u.addAttribute("user", User.GetUser(id));

        return "show";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model u) {
        u.addAttribute("user", User.GetUser(id));

        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       @RequestParam("name") String name,
                       @RequestParam("position") String position) {

        User user = new User();

        user.setId(id);
        user.setName(name);
        user.setPosition(position);

        user.Update(user);

        return "redirect:/users/";
    }
}

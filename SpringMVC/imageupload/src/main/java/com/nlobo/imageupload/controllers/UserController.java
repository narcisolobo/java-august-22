package com.nlobo.imageupload.controllers;

import com.nlobo.imageupload.models.LoginUser;
import com.nlobo.imageupload.models.User;
import com.nlobo.imageupload.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        // empty user object for register form
        model.addAttribute("user", new User());
        // empty loginuser object for login form
        model.addAttribute("loginUser", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/users/register")
    public String registerUser(
            Model model,
            HttpSession session,
            @Valid @ModelAttribute("user") User user,
            BindingResult result) {

        // call register method in service
        User newUser = userService.register(user, result);

        if (result.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }

        session.setAttribute("userId", newUser.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/users/login")
    public String login(
            Model model,
            HttpSession session,
            @Valid @ModelAttribute("loginUser") LoginUser loginUser,
            BindingResult result) {

        // call the login method in the service
        User loggedInUser = userService.login(loginUser, result);

        if (result.hasErrors()) {
            model.addAttribute("user", new User());
            return "index.jsp";
        }

        session.setAttribute("userId", loggedInUser.getId());
//		session.setAttribute("firstName", loggedInUser.getFirstName());
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        User user = userService.findById((Long) session.getAttribute("userId"));
        model.addAttribute("user", user);
        return "dashboard.jsp";
    }

    @GetMapping("/images")
    public ResponseEntity<byte[]> showImage(
            @RequestParam("id") Long id,
            HttpServletResponse response,
            HttpServletRequest request)
            throws ServletException, IOException {
        User user = userService.findById(id);
        byte[] imageContent = user.getProfilePic();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/jpeg"));
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
//        response.getOutputStream().write(user.getProfilePic());
//        response.getOutputStream().close();
    }

    @GetMapping("/users/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

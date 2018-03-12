package ru.savshop.educenter.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.savshop.educenter.model.Type;
import ru.savshop.educenter.model.User;
import ru.savshop.educenter.repository.LessonRepository;
import ru.savshop.educenter.repository.UserRepository;
import ru.savshop.educenter.security.CurrentUser;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class RegisterController {

    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private UserRepository userRepository;

    @Value("${shop.userpic.upload.path}")
    private String imageUploadPath;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap map) {
        map.addAttribute("student", new User());
        return "register";
    }

    @RequestMapping (value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSucces() {
        CurrentUser principal = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal.getUser().getType() == Type.MANAGER){
            return "redirect:/admin";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(name = "registerUser") User user,
                          @RequestParam(value = "picture") MultipartFile file) throws IOException {
        File dir = new File(imageUploadPath);
        if (!dir.exists()){
            dir.mkdir();
        }
        String picName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File(imageUploadPath + picName);
        file.transferTo(picture);
        user.setPicUrl(picName);
        user.setType(Type.STUDENT);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/";
    }
    @RequestMapping(value = "/product/image", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(imageUploadPath + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}

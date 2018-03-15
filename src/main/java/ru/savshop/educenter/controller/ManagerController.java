package ru.savshop.educenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.savshop.educenter.model.Lecturer;
import ru.savshop.educenter.model.Lesson;
import ru.savshop.educenter.repository.LecturerRepository;
import ru.savshop.educenter.repository.LessonRepository;
import ru.savshop.educenter.repository.UserRepository;
import ru.savshop.educenter.security.CurrentUser;

@Controller
public class ManagerController {

    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap map) {
        map.addAttribute("addlesson", new Lesson());
        map.addAttribute("addlecturer", new Lecturer());
        map.addAttribute("allLecturer", lecturerRepository.findAll());
        map.addAttribute("allUsers", userRepository.findAll());

        return "admin";
    }

    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
    public String addLesson(@ModelAttribute(name = "lesson") Lesson lesson) {
        lessonRepository.save(lesson);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addLecturer", method = RequestMethod.POST)
    public String addLecturer(@ModelAttribute(name = "lecturer")Lecturer lecturer) {
        lecturerRepository.save(lecturer);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deletePage(ModelMap map) {
        map.addAttribute("allUsers", userRepository.findAll());

        return "deleteUser";
    }

    @RequestMapping(value = "/deleteUsers", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") int id) {
        userRepository.delete(id);
        return "redirect:/admin";
    }

}

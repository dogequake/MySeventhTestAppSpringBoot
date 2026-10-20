package ru.chernyshev.MySeventhTestAppSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.chernyshev.MySeventhTestAppSpringBoot.dao.StudyGroupRepository;
import ru.chernyshev.MySeventhTestAppSpringBoot.entity.StudyGroup;

@Controller
public class StudyGroupController {

    private final StudyGroupRepository groupRepository;

    @Autowired
    public StudyGroupController(StudyGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public ModelAndView getAllGroups() {
        ModelAndView mav = new ModelAndView("list-groups");
        mav.addObject("groups", groupRepository.findAll());
        return mav;
    }

    @GetMapping("/addGroupForm")
    public ModelAndView addGroupForm() {
        ModelAndView mav = new ModelAndView("add-group-form");
        mav.addObject("group", new StudyGroup());
        return mav;
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute StudyGroup group) {
        groupRepository.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/showGroupUpdateForm")
    public ModelAndView showGroupUpdateForm(@RequestParam("groupId") Integer groupId) {
        ModelAndView mav = new ModelAndView("add-group-form");
        StudyGroup group = groupRepository.findById(groupId).orElse(new StudyGroup());
        mav.addObject("group", group);
        return mav;
    }

    @GetMapping("/deleteGroup")
    public String deleteGroup(@RequestParam("groupId") Integer groupId) {
        groupRepository.deleteById(groupId);
        return "redirect:/groups";
    }
}
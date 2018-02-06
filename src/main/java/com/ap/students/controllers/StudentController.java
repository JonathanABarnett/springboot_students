package com.ap.students.controllers;

import com.ap.students.models.Student;
import com.ap.students.models.StudentData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping(value = "/")
    public String index(Model model){
        String title = "Welcome to Student Registration";
        model.addAttribute("title", title);
        model.addAttribute("students", StudentData.getStudentList());
        return "students/index";
    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String displayAddStudentForm(Model model){
        String title = "Student Registration";
        model.addAttribute("title", title);
        return "students/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAddStudentForm(@ModelAttribute Student student){
        StudentData.addStudent(student);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method=RequestMethod.GET)
    public String displayRemoveStudentForm(Model model) {
        String title = "Student Removal";
        model.addAttribute("title", title);
        model.addAttribute("students", StudentData.getStudentList());
        return "students/remove";
    }

    @RequestMapping(value = "remove", method=RequestMethod.POST)
    public String processRemoveStudentForm(@RequestParam int[] studentsId) {
        for (int id : studentsId) {
            StudentData.removeStudent(id);
        }
        return "redirect:";
    }
}

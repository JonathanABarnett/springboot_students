package com.ap.students.controllers;

import com.ap.students.data.GradeDao;
import com.ap.students.data.StudentDao;
import com.ap.students.models.Grade;
import com.ap.students.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private GradeDao gradeDao;

    @RequestMapping(value = "/")
    public String index(Model model){
        String title = "Welcome to Student Registration";
        model.addAttribute("title", title);
        model.addAttribute("students", studentDao.findAll());
        return "students/index";
    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String displayAddStudentForm(Model model){
        String title = "Student Registration";
        model.addAttribute("title", title);
        model.addAttribute(new Student());
        model.addAttribute("grades", gradeDao.findAll());
        return "students/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAddStudentForm(@ModelAttribute @Valid Student student, Errors errors, Model model, @RequestParam int gradeId){
        String title = "Student Registration";
        if(errors.hasErrors()) {
            model.addAttribute("title", title);
            model.addAttribute("grades", gradeDao.findAll());
            return "students/add";
        }
        Grade grade = gradeDao.findOne(gradeId);
        student.setGrade(grade);
        studentDao.save(student);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method=RequestMethod.GET)
    public String displayRemoveStudentForm(Model model) {
        String title = "Student Removal";
        model.addAttribute("title", title);
        model.addAttribute("students", studentDao.findAll());
        return "students/remove";
    }

    @RequestMapping(value = "remove", method=RequestMethod.POST)
    public String processRemoveStudentForm(@RequestParam int[] studentsId) {
        for (int id : studentsId) {
            studentDao.delete(id);
        }
        return "redirect:";
    }

}

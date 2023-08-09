package com.smartIct.PublicTransport.Controller;

import com.smartIct.PublicTransport.DAO.StudentsRepository;
import com.smartIct.PublicTransport.Entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepo;

    @GetMapping("/students")
    public String listAll(Model model) {
        List<Students> listStudents = studentsRepo.findAll();
        model.addAttribute("listStudents", listStudents);

        return "students";
    }

}
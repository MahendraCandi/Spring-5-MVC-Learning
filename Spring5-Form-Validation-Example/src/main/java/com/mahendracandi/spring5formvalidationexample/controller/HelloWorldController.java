package com.mahendracandi.spring5formvalidationexample.controller;

import com.mahendracandi.spring5formvalidationexample.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(name = "/")
public class HelloWorldController {

    // default get handler
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "enroll";
    }

    // method ini dipanggil pada form submission, handling POST request
    // disini juga memvalidasi inputan user
    // valid untuk bilang spring kalau parameter student harus divalidasi dulu
    // bindingResult untuk menangkap hasil validasi pada student, jika ada error akan ditangkap oleh bindingResult,
    // jika tidak ada bindingResult, maka spring tidak akan melakukan validasi dan melempar exceptionnya
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "enroll";
        }
        model.addAttribute("success", "Dear " + student.getFirstName() + ", your registration completed succesfully");
        return "success";
    }

    @ModelAttribute("sections")
    public List<String> initializeSections(){
        List<String> sections = new ArrayList<>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }

    @ModelAttribute("countries")
    public List<String> initializeCountries(){
        List<String> countries = new ArrayList<>();
        countries.add("INDONESIA");
        countries.add("MALAYSIA");
        countries.add("SINGAPUR");
        countries.add("THAILAND");
        countries.add("BRUNEI DARUSSALAM");
        return countries;
    }

    @ModelAttribute("subjects")
    public List<String> initialiseSubjects(){
        List<String> subjects = new ArrayList<>();
        subjects.add("MATEMATIKA");
        subjects.add("BAHASA INDONESIA");
        subjects.add("BAHASA INGGRIS");
        subjects.add("BAHASA PEMROGRAMAN");
        subjects.add("FISIKA");
        return subjects;
    }

}

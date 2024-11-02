package com.ldr.proginternet.controller;

import com.ldr.proginternet.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    // Lista em memória para armazenar as pessoas (somente para fins de exemplo)
    private List<Person> personList = new ArrayList<>();

    @GetMapping
    public String home(Model model) {
        model.addAttribute("persons", personList);
        return "home";
    }

    @GetMapping("/personList")
    public String getPersonList(Model model) {
        model.addAttribute("persons", personList);
        return "fragments/personList";
    }


    // Endpoint que lida com o envio do formulário
    @PostMapping("/ajax/submit")
    public String submitPerson(@RequestParam String name, @RequestParam String email, Model model) {
        // Adiciona uma nova pessoa à lista
        Person person = new Person(name, email);
        personList.add(person);

        // Atualiza o modelo com a lista atualizada de pessoas
        model.addAttribute("persons", personList);
        
        // Retorna o fragmento que contém a lista atualizada
        return "fragments/personList";
    }
}

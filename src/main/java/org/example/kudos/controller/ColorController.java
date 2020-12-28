package org.example.kudos.controller;

import org.example.kudos.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colors")
@CrossOrigin(origins = {"http://localhost:3000", "https://magickudos-frontend.herokuapp.com"})
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    public ColorController() {
        super();
    }

}

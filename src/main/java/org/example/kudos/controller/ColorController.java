package org.example.kudos.controller;

import org.example.kudos.model.Color;
import org.example.kudos.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/colors")
@CrossOrigin(origins = {"http://localhost:3000", "https://magickudos-frontend.herokuapp.com"})
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    public ColorController() {
        super();
    }

    @GetMapping
    public List<Color> getColors()
    { return colorRepository.findAll(); }

    @GetMapping(path = "/{kudosType}")
    public Color getOneColorPallete(@PathVariable String kudosType, HttpServletResponse response)
    {
        if (colorRepository.findById(kudosType).isPresent())
        {
            return colorRepository.findById(kudosType).get();
        }
        response.setStatus(204);
        return null;
    }

    @PostMapping()
    public int createColor(@RequestBody Color color, HttpServletResponse response)
    {
        if (color.getKudosType()!= null && color.getHeaderMessage()!= null && color.getLogoImage() != null &&
            color.getButton() != null && color.getButtonText() != null && color.getButtonHover() != null && color.getLogin() != null &&
            color.getLoginBoxShallow() != null && color.getFieldsBoxShallow() != null) {
            colorRepository.save(color);
            response.setStatus(201);
        }
        else { response.setStatus(400); }
        return response.getStatus();
    }

    @DeleteMapping()
    public void deleteAllColors()
    {
        colorRepository.deleteAll();
    }

}

package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/kudos")
@CrossOrigin (origins = "http://localhost:3000")
public class KudoController {

    @Autowired
    private KudoRepository kudoRepository;

    public KudoController() {
        super();
    }

    @PostMapping()
    public int createKudo(@RequestBody Kudo kudo,HttpServletResponse response)
    {
        if ( !kudo.getSender().equalsIgnoreCase("") && !kudo.getReceiver().equalsIgnoreCase("")  && !kudo.getMessage().equalsIgnoreCase("") && !kudo.getLayout().equalsIgnoreCase("")) {
            kudoRepository.save(kudo);
            response.setStatus(201);
        }

        else {
            response.setStatus(400); //If at least one field is empty, return bad request
        }

        return response.getStatus();
    }

    @GetMapping
    public List<Kudo> getKudos()
    {
        return kudoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Kudo getSingleKudo(@PathVariable String id, HttpServletResponse response)
    {

        if (kudoRepository.findById(id).isPresent())
        {
            return kudoRepository.findById(id).get();
        }

        response.setStatus(204);
        return null;

    }

    @PutMapping
    public List<Kudo> storeKudos()
    {
        for (int i = 0; i < kudoRepository.findAll().size(); i++)
        {
            Kudo kudo = kudoRepository.findAll().get(i);
            kudo.setStored("yes");
            kudoRepository.save(kudo);
        }

        return kudoRepository.findAll();
    }


    @PutMapping(path = "/{id}")
    public Kudo storeSingleKudo(@PathVariable String id, HttpServletResponse response)
    {

        if (kudoRepository.findById(id).isPresent()) {
            Kudo kudo = kudoRepository.findById(id).get();
            kudo.setStored("yes");
            kudoRepository.save(kudo);
            return kudo;
        }

        response.setStatus(404);
        return null;

    }

    @DeleteMapping()
    public void deleteAllKudos()
    {
        kudoRepository.deleteAll();
    }

    @DeleteMapping(path = "/{id}")
    public int deleteSingleKudo(@PathVariable String id, HttpServletResponse response)
    {

        if (kudoRepository.findById(id).isPresent())
        {
            kudoRepository.deleteById(id);
        }

        else
        {
            response.setStatus(404);
        }


        return response.getStatus();
    }

}

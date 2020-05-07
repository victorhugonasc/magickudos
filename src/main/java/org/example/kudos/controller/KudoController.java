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
    public Kudo createKudo(@RequestBody Kudo kudo,HttpServletResponse response)
    {
        if (!kudo.getId().isEmpty() && !kudo.getSender().isEmpty() && !kudo.getReceiver().isEmpty() && !kudo.getMessage().isEmpty() && !kudo.getLayout().isEmpty()) {
            kudoRepository.save(new Kudo(kudo.getId(),kudo.getSender(),kudo.getReceiver(),kudo.getMessage(),kudo.getLayout()));
            response.setStatus(201);
        }

        else {
            response.setStatus(400); //If at least one field is empty, return bad request
        }

        return kudo;
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
    public void deleteAllUsers()
    {
        kudoRepository.deleteAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSingleUser(@PathVariable String id, HttpServletResponse response)
    {

        if (kudoRepository.findById(id).isPresent())
        {
            kudoRepository.deleteById(id);
            return;
        }

        response.setStatus(404);
    }

}

package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/kudos")
public class KudoController {

    @Autowired
    private KudoRepository kudoRepository;

    public KudoController() {
        super();
    }

      @PostMapping()
    public Kudo createKudo(@RequestBody Kudo kudo,HttpServletResponse response)
    {
       kudoRepository.save(new Kudo(kudo.getId(),kudo.getSender(),kudo.getReceiver(),kudo.getMessage(),kudo.getDate(),kudo.getLayout()));
       response.setStatus(201);
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

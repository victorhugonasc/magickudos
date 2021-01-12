package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kudos")
@CrossOrigin (origins = {"http://localhost:3000", "https://magickudos-frontend.herokuapp.com"})
public class KudoController {

    @Autowired
    private KudoRepository kudoRepository;

    public KudoController() {
        super();
    }

    @PostMapping()
    public int createKudo(@RequestBody Kudo kudo,HttpServletResponse response)
    {
        if ( kudo.getSender()!= null && kudo.getReceiver()!= null && kudo.getMessage()!= null && kudo.getLayout()!= null) {
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
    public int updateSingleKudo(@PathVariable String id, @RequestBody Kudo kudo, HttpServletResponse response)
    {
        Optional<Kudo> kudoOptional = kudoRepository.findById(id);

        if (!kudoOptional.isPresent()) {
            response.setStatus(204);
        }

        else{
            kudo.setId(id);
            kudo.setDate(kudoOptional.get().getDate());
            kudo.setStored(kudoOptional.get().getStored());
            kudoRepository.save(kudo);
        }
        return response.getStatus();
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

        else {response.setStatus(404);}
        return response.getStatus();
    }

}

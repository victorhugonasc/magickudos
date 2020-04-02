package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kudos")
public class KudoController {

    @Autowired
    private KudoRepository kudoRepository;
    private ArrayList<Kudo> kudoList= new ArrayList<>();

    public KudoController() {
        super();
    }

      @PostMapping()
    public Kudo createKudo(@RequestBody Kudo kudo)
    {
       kudoRepository.save(new Kudo(kudo.getId(),kudo.getSender(),kudo.getReceiver(),kudo.getMessage(),kudo.getDate(),kudo.getLayout()));
       kudoList.add(kudo);
       return kudo;

    }


    @GetMapping
    public List<Kudo> getKudos()
    {
        return kudoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Kudo getSingleKudo(@PathVariable String id, HttpServletResponse response)
    {
        for (Kudo kudo: kudoList) {
            if (id.contentEquals(kudo.getId()))
            {
              return kudo;
            }
        }
        response.setStatus(204);
        return null;
    }

    @PutMapping
    public List<Kudo> storeKudos()
    {
        for (Kudo kudo: kudoList) {
            kudo.setStored("yes");
        }

        kudoRepository.saveAll(kudoList);
        return kudoList;
    }

    @PutMapping("/{id}")
    public Kudo storeSingleKudo(@PathVariable String id, HttpServletResponse response)
    {

        for (Kudo kudo: kudoList) {
            if (id.contentEquals(kudo.getId()))
            {
                kudo.setStored("yes");
                kudoRepository.save(kudo);
                return kudo;
            }
        }
        response.setStatus(204);
        return null;
    }

    @DeleteMapping()
    public void deleteAllUsers()
    {
        kudoRepository.deleteAll();
        kudoList.clear();
    }

    @DeleteMapping("/id")
    public void deleteSingleUser(@PathVariable String id, HttpServletResponse response)
    {
        for (Kudo kudo : kudoList)
        {
            if (kudo.getId().contentEquals(id))
            {
                kudoRepository.delete(kudo);
                kudoList.remove(kudo);
                break;
            }
        }
        response.setStatus(204);
    }

}

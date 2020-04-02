package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Kudo getSingleKudo(@PathVariable String id)
    {
        for (Kudo kudo: kudoList) {
            if (id.contentEquals(kudo.getId()))
            {
              return kudo;
            }
        }
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
    public Kudo storeSingleKudo(@PathVariable String id)
    {

        for (Kudo kudo: kudoList) {
            if (id.contentEquals(kudo.getId()))
            {
                kudo.setStored("yes");
                kudoRepository.save(kudo);
                return kudo;
            }
        }

        return null;
    }


}

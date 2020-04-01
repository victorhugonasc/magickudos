package Controller;

import Model.Kudo;
import Repository.KudoRepository;
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
    public void createKudo(@RequestBody Kudo kudo)
    {
       // kudoRepository.save(new Kudo(kudo.getId(),kudo.getSender(),kudo.getReceiver(),kudo.getMessage(),kudo.getDate(),kudo.getLayout()));
        kudoList.add(new Kudo(kudo.getId(),kudo.getSender(),kudo.getReceiver(),kudo.getMessage(),kudo.getDate(),kudo.getLayout()));
    }


    @GetMapping
    public List<Kudo> getKudos()
    {
        return kudoRepository.findAll();
    }

    @GetMapping
    public Kudo getSingleKudo(@RequestBody Kudo kudoRequest)
    {
        for (Kudo kudo: kudoList) {
            if (kudoRequest.getId() == kudo.getId())
            {
              return kudo;
            }
        }
        return null;
    }

    @PutMapping
    public void storeKudos()
    {
        for (Kudo kudo: kudoList) {
            kudo.setStored("yes");
        }

        kudoRepository.saveAll(kudoList);
    }

    @PutMapping
    public void storeSingleKudo(@RequestBody Kudo kudoRequest)
    {

        for (Kudo kudo: kudoList) {
            if (kudoRequest.getId() == kudo.getId())
            {
                kudo.setStored("yes");
                kudoRepository.save(kudo);
            }
        }


    }


}

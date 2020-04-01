package Repository;

import Model.Kudo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KudoRepository  extends MongoRepository<Kudo, String> {

    public List<Kudo> findAll();

}

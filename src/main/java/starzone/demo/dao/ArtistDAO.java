package starzone.demo.dao;

import org.springframework.data.repository.CrudRepository;
import starzone.demo.entity.Artist;

public interface ArtistDAO extends CrudRepository<Artist, Integer> {
}

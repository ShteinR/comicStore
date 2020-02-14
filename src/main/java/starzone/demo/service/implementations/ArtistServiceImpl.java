package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.ArtistDAO;
import starzone.demo.dao.AuthorDAO;
import starzone.demo.entity.Artist;
import starzone.demo.service.ArtistService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("artistService")
@Transactional
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistDAO artistDAO;

    @Override
    public Optional<Artist> findById(int id) {
        return artistDAO.findById(id);
    }

    public boolean saveArtist(Artist artist) {
        try {
            artistDAO.save(artist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}

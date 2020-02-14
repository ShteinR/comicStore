package starzone.demo.service;

import starzone.demo.entity.Artist;

import java.util.Optional;

public interface ArtistService {
    Optional<Artist> findById(int id);
}

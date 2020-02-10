package starzone.demo.service;

import starzone.demo.entity.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> getById(int id);
}


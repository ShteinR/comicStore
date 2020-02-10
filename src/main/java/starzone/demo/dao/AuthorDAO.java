package starzone.demo.dao;

import org.springframework.data.repository.CrudRepository;
import starzone.demo.entity.Author;

public interface AuthorDAO extends CrudRepository<Author, Integer> {
}

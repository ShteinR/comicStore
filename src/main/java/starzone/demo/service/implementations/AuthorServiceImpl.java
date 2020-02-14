package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.AuthorDAO;
import starzone.demo.entity.Author;
import starzone.demo.service.AuthorService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorDAO authorDAO;

    @Override
    public Optional<Author> getById(int id) {
        return authorDAO.findById(id);
    }

    public boolean saveAuthor(Author author){
        authorDAO.save(author);
        return true;
    }






}

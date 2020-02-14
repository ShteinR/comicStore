package starzone.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "artist_name")
    private String artistName;
    @Column(name = "artist_age")
    private int artistAge;
    @OneToMany(mappedBy = "artist")
    private List<Product> comics = new ArrayList<>();

    public List<Product> getComics() {
        return comics;
    }

    public void setComics(List<Product> comics) {
        this.comics = comics;
    }

    public int getAuthorAge() {
        return artistAge;
    }

    public void setAuthorAge(int authorAge) {
        this.artistAge = authorAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }


}

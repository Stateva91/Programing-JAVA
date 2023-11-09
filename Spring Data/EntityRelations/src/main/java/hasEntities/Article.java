package hasEntities;

import jakarta.persistence.*;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String text;
    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private User author;

    public Article(){

    }

    public Article(String text) {
        this.text = text;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}


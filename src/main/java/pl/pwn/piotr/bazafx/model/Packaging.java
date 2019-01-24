package pl.pwn.piotr.bazafx.model;

import javax.persistence.*;

@Entity
@Table(name ="opakowanie")
public class Packaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopakowanie")
    private long id;

    @Column(name = "rodzaj_opakowania")
    private String packaging;

    public Packaging() {
    }

    public Packaging(String packaging) {
        this.packaging = packaging;
    }

    public Packaging(long id, String packaging) {
        this.id = id;
        this.packaging = packaging;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    @Override
    public String toString() {
        return "Packaging{" +
                "id=" + id +
                ", packaging='" + packaging + '\'' +
                '}';
    }
}

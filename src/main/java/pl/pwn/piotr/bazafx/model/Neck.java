package pl.pwn.piotr.bazafx.model;

import javax.persistence.*;

@Entity
@Table(name ="gwint")
public class Neck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgwint")
    private long id;

    @Column(name = "rodzaj_gwintu")
    private String neck;

    @Column(name = "srednica")
    private String neckDimension;

    public Neck() {
    }

    public Neck(String neck, String neckDimension) {
        this.neck = neck;
        this.neckDimension = neckDimension;
    }

    public Neck(long id, String neck, String neckDimension) {
        this.id = id;
        this.neck = neck;
        this.neckDimension = neckDimension;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getNeckDimension() {
        return neckDimension;
    }

    public void setNeckDimension(String neckDimension) {
        this.neckDimension = neckDimension;
    }

    @Override
    public String toString() {
        return "Neck{" +
                "id=" + id +
                ", neck='" + neck + '\'' +
                ", neckDimension='" + neckDimension + '\'' +
                '}';
    }
}

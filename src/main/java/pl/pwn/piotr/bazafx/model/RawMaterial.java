package pl.pwn.piotr.bazafx.model;


import javax.persistence.*;

@Entity
@Table(name ="tworzywo")
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtworzywo")
    private long id;

    @Column(name = "rodzaj_tworzywa")
    private String rawMaterial;

    @Column(name = "nazwa_tworzywa")
    private String nameOfTheRawMaterial;

    public RawMaterial() {
    }

    public RawMaterial(String rawMaterial, String nameOfTheRawMaterial) {
        this.rawMaterial = rawMaterial;
        this.nameOfTheRawMaterial = nameOfTheRawMaterial;
    }

    public RawMaterial(long id, String rawMaterial, String nameOfTheRawMaterial) {
        this.id = id;
        this.rawMaterial = rawMaterial;
        this.nameOfTheRawMaterial = nameOfTheRawMaterial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public String getNameOfTheRawMaterial() {
        return nameOfTheRawMaterial;
    }

    public void setNameOfTheRawMaterial(String nameOfTheRawMaterial) {
        this.nameOfTheRawMaterial = nameOfTheRawMaterial;
    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "id=" + id +
                ", rawMaterial='" + rawMaterial + '\'' +
                ", nameOfTheRawMaterial='" + nameOfTheRawMaterial + '\'' +
                '}';
    }
}

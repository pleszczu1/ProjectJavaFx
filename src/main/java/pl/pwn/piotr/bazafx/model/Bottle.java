package pl.pwn.piotr.bazafx.model;

import javax.persistence.*;

@Entity
@Table(name ="butelki")
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbutelki")
    private long id;

    @ManyToOne
    @JoinColumn(name = "tworzywo_idtworzywo")
    private RawMaterial nameOfTheRawMaterial;

    @Transient
    private String nameMaterial;

    public String getNameMaterial() {
        String name = "";
        if(nameOfTheRawMaterial!= null) {
            name = nameOfTheRawMaterial.getNameOfTheRawMaterial();
        }
        return name;
    }

    @ManyToOne
    @JoinColumn(name = "gwint_idgwint")
    private Neck neck;

    @Transient
    private String neckName;

    public String getNeckName(){
        String neckname = "";
        if(neck!=null){
            neckname=neck.getNeck();
        }
        return neckname;
    }

    @Column(name = "waga")
    private int weight;

    @Column(name = "numer_katalogowy")
    private int catalogueNumber;

    @Column(name = "pojemnosc")
    private int capacity;

    @Column(name = "ilosc_w_opakowaniu")
    private int numberInBox;

    public Bottle() {
    }

    public Bottle(RawMaterial nameOfTheRawMaterial, Neck neck, int weight, int catalogueNumber, int capacity, int numberInBox) {
        this.nameOfTheRawMaterial = nameOfTheRawMaterial;
        this.neck = neck;
        this.weight = weight;
        this.catalogueNumber = catalogueNumber;
        this.capacity = capacity;
        this.numberInBox = numberInBox;
    }

    public Bottle(long id, RawMaterial nameOfTheRawMaterial, Neck neck, int weight, int catalogueNumber, int capacity, int numberInBox) {
        this.id = id;
        this.nameOfTheRawMaterial = nameOfTheRawMaterial;
        this.neck = neck;
        this.weight = weight;
        this.catalogueNumber = catalogueNumber;
        this.capacity = capacity;
        this.numberInBox = numberInBox;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RawMaterial getNameOfTheRawMaterial() {
        return nameOfTheRawMaterial;
    }

    public void setNameOfTheRawMaterial(RawMaterial nameOfTheRawMaterial) {
        this.nameOfTheRawMaterial = nameOfTheRawMaterial;
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCatalogueNumber() {
        return catalogueNumber;
    }

    public void setCatalogueNumber(int catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberInBox() {
        return numberInBox;
    }

    public void setNumberInBox(int numberInBox) {
        this.numberInBox = numberInBox;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "id=" + id +
                ", nameOfTheRawMaterial=" + nameOfTheRawMaterial +
                ", neck=" + neck +
                ", weight=" + weight +
                ", catalogueNumber=" + catalogueNumber +
                ", capacity=" + capacity +
                ", numberInBox=" + numberInBox +
                '}';
    }
}


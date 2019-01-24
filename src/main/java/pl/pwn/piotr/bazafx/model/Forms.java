package pl.pwn.piotr.bazafx.model;


import javax.persistence.*;

@Entity
@Table(name ="forma_butelki")
public class Forms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idforma_butelki")
    private long id;

    @Column(name = "numer_butelki")
    private int numberOfTheBottles;

    @Column(name = "ilosc_form")
    private int quantityOfTheForms;

    @Column(name = "pojemnosc")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "butelki_idbutelki" )
    private Bottle bottles;

    @Transient
    private String bottleId;

    public Long getBottleId(){
        Long idName = 0L ;
        if(bottles!=null){
            idName = bottles.getId();
        }
        return idName;
    }

    @ManyToOne
    @JoinColumn(name = "butelki_tworzywo_idtworzywo" )
    private RawMaterial rawMaterials;

    @Transient
    private String nameMaterial;

    public String getNameMaterial() {
        String name = "";
        if(rawMaterials!= null) {
            name = rawMaterials.getNameOfTheRawMaterial();
        }
        return name;
    }

    @ManyToOne
    @JoinColumn(name = "butelki_gwint_idgwint" )
    private Neck necks;

    @Transient
    private String neckName;

    public String getNeckName(){
        String neckname = "";
        if(necks!=null){
            neckname=necks.getNeck();
        }
        return neckname;
    }

    public Forms() {
    }

    public Forms(int numberOfTheBottles, int quantityOfTheForms, int capacity, Bottle bottles, RawMaterial rawMaterials, Neck necks) {
        this.numberOfTheBottles = numberOfTheBottles;
        this.quantityOfTheForms = quantityOfTheForms;
        this.capacity = capacity;
        this.bottles = bottles;
        this.rawMaterials = rawMaterials;
        this.necks = necks;
    }

    public Forms(long id, int numberOfTheBottles, int quantityOfTheForms, int capacity, Bottle bottles, RawMaterial rawMaterials, Neck necks) {
        this.id = id;
        this.numberOfTheBottles = numberOfTheBottles;
        this.quantityOfTheForms = quantityOfTheForms;
        this.capacity = capacity;
        this.bottles = bottles;
        this.rawMaterials = rawMaterials;
        this.necks = necks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfTheBottles() {
        return numberOfTheBottles;
    }

    public void setNumberOfTheBottles(int numberOfTheBottles) {
        this.numberOfTheBottles = numberOfTheBottles;
    }

    public int getQuantityOfTheForms() {
        return quantityOfTheForms;
    }

    public void setQuantityOfTheForms(int quantityOfTheForms) {
        this.quantityOfTheForms = quantityOfTheForms;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Bottle getBottles() {
        return bottles;
    }

    public void setBottles(Bottle bottles) {
        this.bottles = bottles;
    }

    public RawMaterial getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(RawMaterial rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public Neck getNecks() {
        return necks;
    }

    public void setNecks(Neck necks) {
        this.necks = necks;
    }

    @Override
    public String toString() {
        return "Forms{" +
                "id=" + id +
                ", numberOfTheBottles=" + numberOfTheBottles +
                ", quantityOfTheForms=" + quantityOfTheForms +
                ", capacity=" + capacity +
                ", bottles=" + bottles +
                ", rawMaterials=" + rawMaterials +
                ", necks=" + necks +
                '}';
    }
}

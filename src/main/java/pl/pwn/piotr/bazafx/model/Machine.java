package pl.pwn.piotr.bazafx.model;


import javax.persistence.*;

@Entity
@Table(name = "butelczarki")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbutelaczarki")
    private long id;

    @Column(name = "numer_butelczarki")
    private String numberOfTheMachine;

    @Column(name = "liczba_glowic")
    private int numberOfHeads;

    @Column(name = "liczba_wozkow")
    private int numberOfPrams;

    public Machine() {
    }

    public Machine(String  numberOfTheMachine, int numberOfHeads, int numberOfPrams) {
        this.numberOfTheMachine = numberOfTheMachine;
        this.numberOfHeads = numberOfHeads;
        this.numberOfPrams = numberOfPrams;
    }

    public Machine(long id, String numberOfTheMachine, int numberOfHeads, int numberOfPrams) {
        this.id = id;
        this.numberOfTheMachine = numberOfTheMachine;
        this.numberOfHeads = numberOfHeads;
        this.numberOfPrams = numberOfPrams;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String  getNumberOfTheMachine() {
        return numberOfTheMachine;
    }

    public void setNumberOfTheMachine(String  numberOfTheMachine) {
        this.numberOfTheMachine = numberOfTheMachine;
    }

    public int getNumberOfHeads() {
        return numberOfHeads;
    }

    public void setNumberOfHeads(int numberOfHeads) {
        this.numberOfHeads = numberOfHeads;
    }

    public int getNumberOfPrams() {
        return numberOfPrams;
    }

    public void setNumberOfPrams(int numberOfPrams) {
        this.numberOfPrams = numberOfPrams;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", numberOfTheMachine=" + numberOfTheMachine +
                ", numberOfHeads=" + numberOfHeads +
                ", numberOfPrams=" + numberOfPrams +
                '}';
    }
}

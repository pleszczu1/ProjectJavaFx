package pl.pwn.piotr.bazafx.model;


import javax.persistence.*;

@Entity
@Table(name ="brygada")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbrygada")
    private long id;

    @Column(name = "numer_brygady")
    private String squadNumber;

    @Column(name = "lider_brygady")
    private String squadLider;

    public Squad() {
    }

    public Squad(String squadNumber, String squadLider) {
        this.squadNumber = squadNumber;
        this.squadLider = squadLider;
    }

    public Squad(long id, String squadNumber, String squadLider) {
        this.id = id;
        this.squadNumber = squadNumber;
        this.squadLider = squadLider;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    public String getSquadLider() {
        return squadLider;
    }

    public void setSquadLider(String squadLider) {
        this.squadLider = squadLider;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "id=" + id +
                ", squadNumber='" + squadNumber + '\'' +
                ", squadLider='" + squadLider + '\'' +
                '}';
    }
}

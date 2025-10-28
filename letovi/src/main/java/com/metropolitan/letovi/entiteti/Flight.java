package com.metropolitan.letovi.entiteti;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "od", nullable = false)
    private String od;

    @Column(name = "destinacija", nullable = false)
    private String destinacija;

    @Column(name = "vreme", nullable = false)
    private String vreme;

    @Column(name = "brojputnika", nullable = false)
    private int brojPutnika;

    @Column(name = "cena", nullable = false)
    private int cena;

    public Flight() {
    }

    public Flight(int id, String od, String destinacija, String vreme, int brojPutnika, int cena) {
        this.id = id;
        this.od = od;
        this.destinacija = destinacija;
        this.vreme = vreme;
        this.brojPutnika = brojPutnika;
        this.cena = cena;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(String destinacija) {
        this.destinacija = destinacija;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public int getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(int brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}

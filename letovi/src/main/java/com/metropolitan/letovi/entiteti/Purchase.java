package com.metropolitan.letovi.entiteti;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "kupovine")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "od")
    private String od;

    @Column(name = "destinacija")
    private String destinacija;

    @Column(name = "vreme")
    private String vreme;

    @Column(name = "brojputnika")
    private Integer brojPutnika;

    @Column(name = "zeljeniprtljag")
    private Boolean zeljeniPrtljag;

    @Column(name = "ukupnacena")
    private Double ukupnaCena;

    public Purchase() {
    }

    //Integer flightId
    public Purchase(Integer id,  String od, String destinacija, String vreme, Integer brojPutnika, Boolean zeljeniPrtljag, Double ukupnaCena) {
        this.id = id;
//        this.flightId = flightId;
        this.od = od;
        this.destinacija = destinacija;
        this.vreme = vreme;
        this.brojPutnika = brojPutnika;
        this.zeljeniPrtljag = zeljeniPrtljag;
        this.ukupnaCena = ukupnaCena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getFlightId() {
//        return flightId;
//    }
//
//    public void setFlightId(int flightId) {
//        this.flightId = flightId;
//    }

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

    public Integer getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(Integer brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public Boolean getZeljeniPrtljag() {
        return zeljeniPrtljag;
    }

    public void setZeljeniPrtljag(Boolean zeljeniPrtljag) {
        this.zeljeniPrtljag = zeljeniPrtljag;
    }

    public Double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }
}

package com.example.example.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name, surname, teamFrom, teamInto;
    int amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeamFrom() {
        return teamFrom;
    }

    public void setTeamFrom(String teamFrom) {
        this.teamFrom = teamFrom;
    }

    public String getTeamInto() {
        return teamInto;
    }

    public void setTeamInto(String teamInto) {
        this.teamInto = teamInto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Transfer() {
    }

    public Transfer(String name, String surname, String teamFrom, String teamInto, int amount) {
        this.name = name;
        this.surname = surname;
        this.teamFrom = teamFrom;
        this.teamInto = teamInto;
        this.amount = amount;
    }
}

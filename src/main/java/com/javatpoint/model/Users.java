package com.javatpoint.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class Users {
    @Id
    @Column
    private int id;

    @Column
    private int hp;

    @Column
    @Size(min = 5, message = "Name should have atleast 5 characters")
    private String name;

    @Column
    private int stamina;

    @Column
    private int atk;

    @Column
    private int def;

    @Column
    private int agi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", hp=" + hp + ", stamina=" + stamina + ", atk=" + atk + ", def=" + def + ", agi=" + agi + "]";
    }
}

package com.hiwotab.daveslist.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=2)
    private String description;
    @NotNull
    @Size(min=2)
    private String rules;
    @NotNull
    private boolean wifi;
    @NotNull
    private String cable;
    @NotNull
    private boolean pvBathroom;
    @NotNull
    private boolean availability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPvBathroom() {
        return pvBathroom;
    }

    public void setPvBathroom(boolean pvBathroom) {
        this.pvBathroom = pvBathroom;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public boolean isWifi() {return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }


    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }
}

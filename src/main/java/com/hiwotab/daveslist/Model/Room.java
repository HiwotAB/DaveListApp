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
    private boolean cable;
    @NotNull
    private String pvBathroom;
    @NotNull
    @Size(min=2)
    private String availability;

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

    public boolean isCable() {
        return cable;
    }

    public void setCable(boolean cable) {
        this.cable = cable;
    }

    public String getPvBathroom() {
        return pvBathroom;
    }

    public void setPvBathroom(String pvBathroom) {
        this.pvBathroom = pvBathroom;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}

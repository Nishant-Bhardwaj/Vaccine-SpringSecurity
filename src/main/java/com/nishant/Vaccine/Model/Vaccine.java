package com.nishant.Vaccine.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "vaccineTBL")
public class Vaccine {

    @Id
    @Column(name = "vaccineId")
    private int vaccineId;

    @Column(name = "vaccineName")
    private String vaccineName;

    public Vaccine() {
    }

    public Vaccine(int vaccineId, String vaccineName) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}

package com.Safetynet.Model.Specific;

import com.Safetynet.Model.Specific.utils.PersonWithNameAgeMedRecs;

import java.util.List;
import java.util.Objects;

public class Flood {
    private String address;
    private List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList;

    public Flood() {
    }

    public Flood(String address, List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList) {
        this.address = address;
        this.personWithNameAgeMedRecsList = personWithNameAgeMedRecsList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PersonWithNameAgeMedRecs> getPersonWithNameAgeMedRecsList() {
        return personWithNameAgeMedRecsList;
    }

    public void setPersonWithNameAgeMedRecsList(List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList) {
        this.personWithNameAgeMedRecsList = personWithNameAgeMedRecsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flood)) return false;
        Flood flood = (Flood) o;
        return Objects.equals(address, flood.address) && Objects.equals(personWithNameAgeMedRecsList, flood.personWithNameAgeMedRecsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, personWithNameAgeMedRecsList);
    }

    @Override
    public String toString() {
        return "Flood{" +
                "address='" + address + '\'' +
                ", personWithNameAgeMedRecsList=" + personWithNameAgeMedRecsList +
                '}';
    }
}

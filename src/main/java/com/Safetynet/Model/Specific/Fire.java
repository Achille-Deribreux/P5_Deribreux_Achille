package com.Safetynet.Model.Specific;

import com.Safetynet.Model.Specific.utils.PersonWithNameAgeMedRecs;

import java.util.List;
import java.util.Objects;

public class Fire {
    private Integer firestationNumber;
    private List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList;

    public Fire() {
    }

    public Fire(Integer firestationNumber, List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList) {
        this.firestationNumber = firestationNumber;
        this.personWithNameAgeMedRecsList = personWithNameAgeMedRecsList;
    }

    public Integer getFirestationNumber() {
        return firestationNumber;
    }

    public void setFirestationNumber(Integer firestationNumber) {
        this.firestationNumber = firestationNumber;
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
        if (!(o instanceof Fire)) return false;
        Fire fire = (Fire) o;
        return Objects.equals(firestationNumber, fire.firestationNumber) && Objects.equals(personWithNameAgeMedRecsList, fire.personWithNameAgeMedRecsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firestationNumber, personWithNameAgeMedRecsList);
    }

    @Override
    public String toString() {
        return "Fire{" +
                "firestationNumber=" + firestationNumber +
                ", personWithNameAgeMedRecsList=" + personWithNameAgeMedRecsList +
                '}';
    }
}


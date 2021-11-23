package com.Safetynet.Model.Specific;

import com.Safetynet.Model.Specific.utils.PersonWithNameAdressPhone;

import java.util.List;
import java.util.Objects;

public class ListByFirestation {
    private List<PersonWithNameAdressPhone> personWithNameAdressPhoneList;
    private Integer adultsCounter;
    private Integer childrensCounter;

    public ListByFirestation(List<PersonWithNameAdressPhone> personWithNameAdressPhoneList, Integer adultsCounter, Integer childrensCounter) {
        this.personWithNameAdressPhoneList = personWithNameAdressPhoneList;
        this.adultsCounter = adultsCounter;
        this.childrensCounter = childrensCounter;
    }

    public ListByFirestation() {
    }

    public List<PersonWithNameAdressPhone> getPersonWithNameAdressPhoneList() {
        return personWithNameAdressPhoneList;
    }

    public void setPersonWithNameAdressPhoneList(List<PersonWithNameAdressPhone> personWithNameAdressPhoneList) {
        this.personWithNameAdressPhoneList = personWithNameAdressPhoneList;
    }

    public Integer getAdultsCounter() {
        return adultsCounter;
    }

    public void setAdultsCounter(Integer adultsCounter) {
        this.adultsCounter = adultsCounter;
    }

    public Integer getChildrensCounter() {
        return childrensCounter;
    }

    public void setChildrensCounter(Integer childrensCounter) {
        this.childrensCounter = childrensCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListByFirestation)) return false;
        ListByFirestation that = (ListByFirestation) o;
        return Objects.equals(personWithNameAdressPhoneList, that.personWithNameAdressPhoneList) && Objects.equals(adultsCounter, that.adultsCounter) && Objects.equals(childrensCounter, that.childrensCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personWithNameAdressPhoneList, adultsCounter, childrensCounter);
    }

    @Override
    public String toString() {
        return "ListByFirestation{" +
                "personWithNameAdressPhoneList=" + personWithNameAdressPhoneList +
                ", adultsCounter=" + adultsCounter +
                ", childrensCounter=" + childrensCounter +
                '}';
    }
}

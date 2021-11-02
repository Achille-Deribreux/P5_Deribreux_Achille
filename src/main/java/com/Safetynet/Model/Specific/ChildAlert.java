package com.Safetynet.Model.Specific;

import com.Safetynet.Model.Specific.utils.PersonWithNameAge;

import java.util.List;
import java.util.Objects;

public class ChildAlert {
    private List<PersonWithNameAge> childrenList;
    private List<PersonWithNameAge> adultsList;

    public ChildAlert() {
    }

    public ChildAlert(List<PersonWithNameAge> childrenList, List<PersonWithNameAge> adultsList) {
        this.childrenList = childrenList;
        this.adultsList = adultsList;
    }

    public List<PersonWithNameAge> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<PersonWithNameAge> childrenList) {
        this.childrenList = childrenList;
    }

    public List<PersonWithNameAge> getAdultsList() {
        return adultsList;
    }

    public void setAdultsList(List<PersonWithNameAge> adultsList) {
        this.adultsList = adultsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildAlert)) return false;
        ChildAlert that = (ChildAlert) o;
        return Objects.equals(childrenList, that.childrenList) && Objects.equals(adultsList, that.adultsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childrenList, adultsList);
    }

    @Override
    public String toString() {
        return "ChildAlert{" +
                "childrenList=" + childrenList +
                ", adultsList=" + adultsList +
                '}';
    }
}

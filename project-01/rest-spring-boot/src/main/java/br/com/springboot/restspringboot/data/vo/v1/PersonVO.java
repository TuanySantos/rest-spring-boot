package br.com.springboot.restspringboot.data.vo.v1;
import java.io.Serializable;


public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO personVO)) return false;

        if (!id.equals(personVO.id)) return false;
        if (!firstName.equals(personVO.firstName)) return false;
        if (!getLastName().equals(personVO.getLastName())) return false;
        if (!getAddress().equals(personVO.getAddress())) return false;
        return getGender().equals(personVO.getGender());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getGender().hashCode();
        return result;
    }
}

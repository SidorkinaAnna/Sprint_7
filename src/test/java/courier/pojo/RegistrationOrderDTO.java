package courier.pojo;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationOrderDTO {
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("metroStation")
    @Expose
    private Integer metroStation;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("rentTime")
    @Expose
    private Integer rentTime;
    @SerializedName("deliveryDate")
    @Expose
    private String deliveryDate;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("color")
    @Expose
    private List<String> color;


    public RegistrationOrderDTO(String firstName, String lastName, String address,
                                Integer metroStation, String phone, Integer rentTime,
                                String deliveryDate, List<String> color, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.color = color;
        this.comment = comment;
    }

    public RegistrationOrderDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Integer getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(Integer metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public void setRentTime(Integer rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "RegistrationOrderDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", metroStation=" + metroStation +
                ", phone='" + phone + '\'' +
                ", rentTime=" + rentTime +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", comment='" + comment + '\'' +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationOrderDTO that = (RegistrationOrderDTO) o;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(address, that.address)
                && Objects.equals(metroStation, that.metroStation)
                && Objects.equals(phone, that.phone)
                && Objects.equals(rentTime, that.rentTime)
                && Objects.equals(deliveryDate, that.deliveryDate)
                && Objects.equals(comment, that.comment)
                && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }
}


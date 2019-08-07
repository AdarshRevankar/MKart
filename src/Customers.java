import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {
    @XmlElement(name = "customer")
    private List<Customer> customerList = null;

    Customers(){ }
    List<Customer> getCustomerList() {
        return customerList;
    }

    void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
class Customer {
    private String name, address;
    private int id, phone;

    public Customer(String name, String address, int id, int phone) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

}

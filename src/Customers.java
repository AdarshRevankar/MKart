import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class    : Customers
 * Purpose  : Holding List of Customer class objects.
 * Thus easy way to write to XML file.
 */
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {
    @XmlElement(name = "customer")
    private List<Customer> customerList = null;

    Customers() {
        customerList = new ArrayList<Customer>();
    }

    List<Customer> getCustomerList() {
        return customerList;
    }

    void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

/**
 * Class    : Customer
 * Purpose  : All attributes of customer and methods
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
class Customer {
    private String name, uname, password;

    Customer() {
    }

    public Customer(String name, String uname, String password) {
        this.name = name;
        this.uname = uname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer Name :" + name;
    }


    public String getName() {
        return name;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }

}

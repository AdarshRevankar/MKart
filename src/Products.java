import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class    : Products
 * Purpose  : Holding List of Product class objects.
 *            Thus easy way to write to XML file.
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
    @XmlElement(name = "product")
    private List<Product> productList = null;

    Products(){
        productList = new ArrayList<Product>();
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

/**
 * Class    : Product
 * Purpose  : All attributes & methods of Product class.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
class Product {
    private String name, brand, desc;
    private int price, id;
    Product(){}
    public Product(String name, String brand, String desc, int price, int id) {
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
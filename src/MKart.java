import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MKart {
    public static void main(String[] args) throws JAXBException, IOException, ClassNotFoundException {
        // Products object
        Products products = new Products();
        products.setProductList(new ArrayList<Product>());

        // Parser
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Appliance Details :");
        Document page = Jsoup.connect("https://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=" + scan.next()).get();

        Elements eachElement = page.getElementsByAttribute("class");
        for (Element item : eachElement)
            System.out.println(item.text());

        XMLJavaReadWriters.write("Products", products, "D:\\product.xml");
    }
}
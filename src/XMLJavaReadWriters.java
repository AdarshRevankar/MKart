import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XMLJavaReadWriters {
    public static Object read(String className, String path)
            throws FileNotFoundException, JAXBException, ClassNotFoundException {
        Class cls = Class.forName(className);
        FileInputStream fis = new FileInputStream(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(fis);
    }

    static void write(String className, Object writeObject, String path)
            throws IOException, JAXBException, ClassNotFoundException {
        Class cls = Class.forName(className);
        JAXBContext context = JAXBContext.newInstance(cls);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fos = new FileOutputStream(path);
        marshaller.marshal(writeObject, fos);
        fos.close();
    }
}

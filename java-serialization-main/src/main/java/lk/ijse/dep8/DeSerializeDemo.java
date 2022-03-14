package lk.ijse.dep8;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeSerializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path filePath = Paths.get(System.getProperty("user.home"),
                "Desktop",
                "Serialization Demos",
                "Customer.dep8");


        if (!Files.exists(filePath)){
            System.err.println("No such file to read");
            return;
        }


        InputStream fis = Files.newInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Customer c = (Customer) ois.readObject();
        ois.close();

        c.printDetails();
    }
}

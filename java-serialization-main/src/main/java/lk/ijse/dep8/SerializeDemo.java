package lk.ijse.dep8;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeDemo {

    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("C001", "Dulanga", "Matara");

        String homeDirPath = System.getProperty("user.home");
        Path dirPath = Paths.get(homeDirPath, "Desktop", "Serialization Demos");

        if (!Files.isDirectory(dirPath)){
            Files.createDirectory(dirPath);
        }

        Path filePath = Paths.get(dirPath.toString(), "Customer.dep8");
        if (!Files.exists(filePath)){
            Files.createFile(filePath);
        }

        OutputStream fos = Files.newOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(customer);



        oos.close();
    }
}

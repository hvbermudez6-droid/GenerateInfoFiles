import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays; // Importa Arrays
import java.util.List;

public class GenerateInfoFiles {

    // M�todo que crea un archivo con los datos proporcionados
    public void generateFile(String fileName, List<String> data) {
        FileWriter fileWriter = null;
        try {
            // Crear el archivo
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();  // Si no existe, se crea
            }
            
            // Escribir datos en el archivo
            fileWriter = new FileWriter(file);
            for (String line : data) {
                fileWriter.write(line + System.lineSeparator());  // Escribe cada l�nea en el archivo
            }
            System.out.println("Archivo generado con �xito: " + fileName);
        } catch (IOException e) {
            System.out.println("Ocurri� un error al escribir el archivo: " + e.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();  // Asegura que el flujo de datos se cierre
                }
            } catch (IOException e) {
                System.out.println("Ocurri� un error al cerrar el archivo: " + e.getMessage());
            }
        }
    }

    // M�todo para leer y mostrar el contenido del archivo generado
    public void printFileContent(String fileName) {
        try {
            List<String> content = Files.readAllLines(Paths.get(fileName));
            System.out.println("Contenido del archivo " + fileName + ":");
            for (String line : content) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ocurri� un error al leer el archivo: " + e.getMessage());
        }
    }

    // M�todo principal para probar la creaci�n de archivos
    public static void main(String[] args) {
        // Creamos una instancia de la clase
        GenerateInfoFiles generator = new GenerateInfoFiles();
        
        // Datos de prueba (m�s realistas)
        List<String> data = Arrays.asList( // Usamos Arrays.asList en lugar de List.of
            "Nombre: Juan P�rez",
            "Edad: 30",
            "Direcci�n: Calle Ficticia, 123",
            "Tel�fono: 555-1234",
            "Email: juan.perez@example.com",
            "Fecha de registro: 09/09/2025"
        );
        
        // Nombre del archivo
        String fileName = "archivoPrueba.txt";
        
        // Llamada al m�todo para generar el archivo
        generator.generateFile(fileName, data);
        
        // Verificamos si el archivo contiene los datos correctos
        generator.printFileContent(fileName);
    }
}
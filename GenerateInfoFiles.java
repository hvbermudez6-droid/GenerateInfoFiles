import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays; // Importa Arrays
import java.util.List;

public class GenerateInfoFiles {

    // Método que crea un archivo con los datos proporcionados
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
                fileWriter.write(line + System.lineSeparator());  // Escribe cada línea en el archivo
            }
            System.out.println("Archivo generado con éxito: " + fileName);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();  // Asegura que el flujo de datos se cierre
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error al cerrar el archivo: " + e.getMessage());
            }
        }
    }

    // Método para leer y mostrar el contenido del archivo generado
    public void printFileContent(String fileName) {
        try {
            List<String> content = Files.readAllLines(Paths.get(fileName));
            System.out.println("Contenido del archivo " + fileName + ":");
            for (String line : content) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    // Método principal para probar la creación de archivos
    public static void main(String[] args) {
        // Creamos una instancia de la clase
        GenerateInfoFiles generator = new GenerateInfoFiles();
        
        // Datos de prueba (más realistas)
        List<String> data = Arrays.asList( // Usamos Arrays.asList en lugar de List.of
            "Nombre: Juan Pérez",
            "Edad: 30",
            "Dirección: Calle Ficticia, 123",
            "Teléfono: 555-1234",
            "Email: juan.perez@example.com",
            "Fecha de registro: 09/09/2025"
        );
        
        // Nombre del archivo
        String fileName = "archivoPrueba.txt";
        
        // Llamada al método para generar el archivo
        generator.generateFile(fileName, data);
        
        // Verificamos si el archivo contiene los datos correctos
        generator.printFileContent(fileName);
    }
}
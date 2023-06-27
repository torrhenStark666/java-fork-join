import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator  {
    public static void main(String[] args) {
        generateFileWithNumbers("output_1000.txt", 1000);
        generateFileWithNumbers("output_10000.txt", 10000);
        generateFileWithNumbers("output_100000.txt", 100000);
        generateFileWithNumbers("output_100000000.txt", 100000000);
        generateFileWithNumbers("output_150000000.txt", 150000000);
        generateFileWithNumbers("output_200000000.txt", 200000000);
    }

    private static void generateFileWithNumbers(String fileName, int numberOfNumbers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Random random = new Random();

            for (int i = 0; i < numberOfNumbers; i++) {
                int randomNumber = random.nextInt(numberOfNumbers);
                writer.write(randomNumber + " ");
            }

            System.out.println("Arquivo " + fileName + " gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo " + fileName + ": " + e.getMessage());
        }
    }
}

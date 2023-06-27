import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSequencial {

    public static void main(String[] args) {
        int[] array = readArrayFromFile("output_200000000.txt");

        Long tempoSequencialInicial = System.currentTimeMillis();
        System.out.println("Iniciando ordenação");
        Quicksort.quickSort(array, 0, array.length - 1);

        //System.out.println("Ordenação Sequencial:");
        //printArray(array);

        Long tempoSequencialFinal = System.currentTimeMillis();
        System.out.println("Tempo de execução: "+((tempoSequencialFinal - tempoSequencialInicial)) + " ms");
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static int[] readArrayFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Scanner scanner = new Scanner(reader);
            List values = new ArrayList<Integer>(0);
            while(scanner.hasNext()) {
                values.add(Integer.parseInt(scanner.next()));
            }

            int[] array = new int[values.size()];
            for (int i = 0; i < values.size(); i++) {
                array[i] = Integer.parseInt(values.get(i).toString());
            }
            return array;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return new int[0];
        }
    }

}

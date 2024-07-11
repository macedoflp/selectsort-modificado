//developed by Felipe Macedo
package Problemas;

import java.util.Random;

public class Problema02<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void SelectSortModificado(T[] lista) {
        int tamanhoLista = lista.length;

        for (int i = 0; i < tamanhoLista / 2; i++) {
            int minIndex = i;
            int maxIndex = i;

            for (int j = i + 1; j < tamanhoLista - i; j++) {
                if (lista[j].compareTo(lista[minIndex]) < 0) {
                    minIndex = j;
                } else if (lista[j].compareTo(lista[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }

            // Troca o menor elemento para a posição correta
            T auxiliar = lista[minIndex];
            lista[minIndex] = lista[i];
            lista[i] = auxiliar;

            // Se o máximo for trocado com o mínimo, ajusta o índice do máximo
            if (maxIndex == i)
                maxIndex = minIndex;

            // Troca o maior elemento para a posição correta
            auxiliar = lista[maxIndex];
            lista[maxIndex] = lista[tamanhoLista - 1 - i];
            lista[tamanhoLista - 1 - i] = auxiliar;
        }
    }

    public static void main(String[] args) {
        Integer[] listaNumerica = gerarListaAleatoria(1000);
        System.out.println("Lista antes da ordenação:");
        printLista(listaNumerica);

        long comecoTempo = System.nanoTime();
        SelectSortModificado(listaNumerica);
        long finalTempo = System.nanoTime();

        double duracao = (finalTempo - comecoTempo) / 1_000_000_000.0; // Convertendo para segundos

        System.out.println("\nTamanho da Lista:");
        System.out.println(listaNumerica.length);

        System.out.println("\nLista depois da ordenação:");
        printLista(listaNumerica);
        System.out.println("Tempo de execução: " + duracao + " segundos");
    }

    public static <T> void printLista(T[] lista) {
        for (T t : lista) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static Integer[] gerarListaAleatoria(int tamanho) {
        Random random = new Random();
        Integer[] lista = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            lista[i] = random.nextInt(100); // Números aleatórios de 0 a 99
        }
        return lista;
    }
}


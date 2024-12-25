package org.example;

import java.util.ArrayList;

public class FCFSalgorithm extends CPUalgorithm {

    // Konstruktor
    FCFSalgorithm() {
        super();
        this.name = "FCFS";
    }

    public void performAlgorithm() {
        while (true) {
            // Lista procesów dostępnych w bieżącym czasie
            ArrayList<Process> availableProcesses = new ArrayList<>();
            for (Process process : processes) {
                if (!process.getIsDone() && process.getAt() <= timePassed) {
                    availableProcesses.add(process);
                }
            }

            // Jeśli nie ma dostępnych procesów
            if (availableProcesses.isEmpty()) {
                // Sprawdź, czy są jeszcze jakieś procesy do przetworzenia
                Process nextArrival = null;
                for (Process process : processes) {
                    if (!process.getIsDone()) {
                        if (nextArrival == null || process.getAt() < nextArrival.getAt()) {
                            nextArrival = process;
                        }
                    }
                }

                // Jeśli nie ma więcej procesów, kończymy
                if (nextArrival == null) {
                    break;
                }

                // Przesuń czas do czasu przyjścia najwcześniejszego procesu
                timePassed = nextArrival.getAt();
                continue; // Kontynuujemy pętlę, aby uwzględnić nowy czas
            }

            // Sortowanie dostępnych procesów według czasu przyjścia
            availableProcesses.sort((p1, p2) -> Integer.compare(p1.getAt(), p2.getAt()));

            // Pobranie pierwszego procesu do przetworzenia
            Process nextProcess = availableProcesses.get(0);
            processingOrder.add(nextProcess); // Dodanie do kolejności przetwarzania

            // Aktualizacja czasów dla procesu
            nextProcess.setCt(timePassed + nextProcess.getBt()); // Completion Time
            nextProcess.setTat(nextProcess.getCt() - nextProcess.getAt()); // Turn Around Time
            nextProcess.setWt(nextProcess.getTat() - nextProcess.getBt()); // Waiting Time
            nextProcess.setIsDoneToTrue(); // Oznaczenie procesu jako zakończonego

            // Przesunięcie czasu symulacji
            timePassed = nextProcess.getCt();
        }

        // Obliczenie średnich czasów
        setMeanTat();
        setMeanWt();
    }
}
package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // stworz mape 15 na 15
        // wypelnij mape dowolnymi przeszkodami typu x (40)
        // w miejscu nie bedacym przeszkoda wylosuj gracza literka G
        // zapewnic mechanizm w korym wprowdzajac z klawiatury literki wsad bedziesz poruszal sie graczem z zachowaniem scianm i przeszkod

        startTheProgramme();

    }

    public static void startTheProgramme() {
        ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>(15);

        String przeszkoda = "x";
        int count = 0;

        for (int d = 0; d < 15; d++) {
            ArrayList<String> array = new ArrayList<>();
            for (int p = 0; p < 15; p++) {
                array.add("_");
            }
            x.add(array);
        }


        do {
            int j = (int) (Math.random() * 15);
            int l = (int) (Math.random() * 15);
            if (x.get(j).get(l).equals("_")) {
                x.get(j).set(l, przeszkoda);
                count++;
            }
        } while (count < 40);


        String pacMan = "P";

        int z = (int) (Math.random() * 15);
        int c = (int) (Math.random() * 15);

        x.get(z).set(c, pacMan);

        for (int p = 0; p < x.size(); p++) {
            for (int m = 0; m < x.get(p).size(); m++) {
                System.out.print(x.get(p).get(m));
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        int count2 = 0;
        do {
            System.out.println("W jakim kierunku chcesz sie poruszyc");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            int oldCoordinate = z;
            int oldCoordinate2 = c;

            if (s.equalsIgnoreCase("w")) {
                if (z == 0) {
                    System.out.println("Nie mozesz sie ruszyc w gore");
                } else {
                    int index = z - 1;
                    if (x.get(index).get(c).equalsIgnoreCase("x")) {
                        System.out.println("Nie mozesz ruszyc sie w gore poniewaz jest tam przeszkoda");
                    } else {
                        System.out.println("mozesz ruszyc w gore");
                        --z;
                        x.get(z).set(c, pacMan);
                        x.get(oldCoordinate).set(c, "_");
                        System.out.println("Pomyslnie w gore");
                    }

                }
            }

            if (s.equalsIgnoreCase("s")) {
                if (z == 14) {
                    System.out.println("Nie mozesz sie ruszyc w dol");
                } else {
                    int index = z + 1;
                    if (x.get(index).get(c).equalsIgnoreCase("x")) {
                        System.out.println("Nie mozesz ruszyc sie w dol poniewaz jest tam przeszkoda");
                    } else {
                        ++z;
                        System.out.println("mozesz ruszyc w dol");
                        x.get(z).set(c, pacMan);
                        x.get(oldCoordinate).set(c, "_");
                        System.out.println("Pomyslnie w dol");
                    }

                }
            }

            if (s.equalsIgnoreCase("a")) {
                if (c == 0) {
                    System.out.println("Nie mozesz sie ruszyc w lewo");
                } else {
                    int index = c - 1;
                    if (x.get(z).get(index).equalsIgnoreCase("x")) {
                        System.out.println("Nie mozesz ruszyc sie w lewo poniewaz jest tam przeszkoda");

                    } else {
                        --c;
                        x.get(z).set(c, pacMan);
                        x.get(z).set(oldCoordinate2, "_");
                        System.out.println("Pomyslnie w lewo");
                    }
                }
            }

            if (s.equalsIgnoreCase("d")) {
                if (c == 14) {
                    System.out.println("Nie mozesz sie ruszyc w prawo");
                } else {
                    int index = c +1;
                    if (x.get(z).get(index).equalsIgnoreCase("x")) {
                        System.out.println("Nie mozesz ruszyc sie w prawo poniewaz jest tam przeszkoda");
                    } else {
                        ++c;
                        x.get(z).set(c, pacMan);
                        x.get(z).set(oldCoordinate2, "_");
                        System.out.println("Pomyslnie w prawo");
                    }

                }
            }
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            for (int p = 0; p < x.size(); p++) {
                for (int m = 0; m < x.get(p).size(); m++) {
                    System.out.print(x.get(p).get(m));
                    System.out.print(" ");
                }
                System.out.println(" ");
            }

            count2++;
        } while (count2 < 300);

    }


}




















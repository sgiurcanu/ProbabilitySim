package com.example.probabilitysim;
import java.util.Scanner;

public class CustomMarble {
        private String color;
        private int size;

        public CustomMarble(String color, int size) {
            this.color = color;
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void displayInfo() {
            System.out.println("Marble color: " + color);
            System.out.println("Marble size: " + size);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter marble color: ");
            String color = scanner.nextLine();

            System.out.print("Enter marble size: ");
            int size = scanner.nextInt();

            Marble myMarble = new Marble(color, size);
            myMarble.displayInfo();

    }
}

package io;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductIO {

    static File file = new File("product.csv");

    public static void write(List<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : products) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file");
        }
    }

    public static ArrayList<Product> read() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                Product product = new Product(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), arr[4]);
                products.add(product);
            }



        } catch (Exception e) {
            System.out.println("Loi doc file");
        }
        return products;
    }
}
package validate;

import model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductValidate {
    static Scanner scanner = new Scanner(System.in);

    public static int quantity() {
        while (true) {
            try {
                System.out.println("Nhập số lượng sản phẩm");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi.");
            }
        }
    }

    public static int id(List<Product> products) {
        int idMax = 0;
        for (Product p : products) {
            if (p.getId() > idMax) {
                idMax = p.getId();
            }
        }
        return idMax + 1;
    }


    public static double price() {
        while (true) {
            try {
                System.out.println("Nhập giá sản phẩm");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi.");
            }
        }
    }

    public static String name(List<Product> products) {
        while (true) {
            try {
                System.out.println("Nhập tên sản phẩm");
                String name = scanner.nextLine();

                if (name.isEmpty()) {
                    System.err.println("Vui lòng nhập tên");
                    continue;
                }

                boolean check = true;
                for (Product p : products) {
                    if (p.getName().equals(name)) {
                        System.err.println("Trùng tên rồi");
                        check = false;
                        break;
                    }
                }

                if (check) {
                    return name;
                }
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
    public static String description() {
        while (true) {
            try {
                System.out.println("Nhập mô tả");
                String description = scanner.nextLine();

                if (description.isEmpty()) {
                    System.err.println("Vui lòng nhập mô tả");
                    continue;
                }

                return description;
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}

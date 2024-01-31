package manager;

import io.ProductIO;
import model.Product;
import validate.ProductValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(Product p) {
        products.add(p);
    }



    public Product create() {
        int id = ProductValidate.id(products);
        String name = ProductValidate.name(products);
        double price = ProductValidate.price();
        int quantity = ProductValidate.quantity();
        String description = ProductValidate.description();
        return new Product(id, name, price, quantity, description);
    }

    public void edit() {
        try {
            boolean editProduct =false;
            while (!editProduct) {
                System.out.println("Nhập id muốn sửa");
                String id = scanner.nextLine();
                if(id.isEmpty()) {
                    return;
                }
                int index = findIndexById(Integer.parseInt(id));
                if (index != -1) {
                    products.set(index, create());
                    System.out.println("SUa thành công");
                    write();
                    return;
                }
                else {
                    System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
                }
            }
        } catch (Exception e) {
            System.out.println("Id phải l số");
        }

    }

    public void delete() {
        try {
                boolean deleteProduct = false;
                while(!deleteProduct) {
                    System.out.println("Nhập id muốn xóa");
                    String id = scanner.nextLine();
                    if(id.isEmpty()) {
                        return;
                    }
                    int index = findIndexById(Integer.parseInt(id));
                    if (index != -1) {
                        products.remove(index);
                        System.out.println("Xoa tc");
                        return;
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
                    }
                }

            } catch(Exception e){
                System.out.println("Id phải l số");
            }



    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        int pageSize = 5;
        int currentPage = 1;
        int startIndex = 0;
        while (true) {
            System.out.println("ID, Tên, Giá, Số lượng, Mô tả");
            int endIndex = Math.min(startIndex + pageSize, products.size());

            for (int i = startIndex; i < endIndex; i++) {
                System.out.println(products.get(i));
            }
            System.out.println("Nhấn Enter để xem trang tiếp ");
            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                break;
            }
            currentPage++;
            startIndex = pageSize * (currentPage - 1);
            if (startIndex >= products.size()) {
                break;
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void sortProductUp() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }
    public void sortProductDown() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() < products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    public Product findProductMax() {
        if (!products.isEmpty()) {
            Product max = products.get(0);
            for (Product p : products) {
                if (p.getPrice() > max.getPrice()) {
                    max = p;
                }
            }
            return max;

        } else {
            return null;
        }
    }
    public void read() {
        products = ProductIO.read();
    }
    public void write() {
        ProductIO.write(products);
    }
}

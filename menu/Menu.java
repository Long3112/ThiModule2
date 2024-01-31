package menu;

import manager.ProductManager;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        ProductManager manageProduct = new ProductManager();
        while (true) {
            System.out.println("Menu Quản Lý Sản Phẩm");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm");
            System.out.println("6. Tìm sản phẩm đắt nhât");
            System.out.println("7. Đọc file");
            System.out.println("8. Ghi file");
            System.out.println("9. Thoát");
            int choice ;
            while (true) {
                try {
                    System.out.println("Nhập lựa chọn của bạn");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }

            switch (choice){
                case 1:
                    manageProduct.display();
                    break;
                case 2:
                    manageProduct.add(manageProduct.create());
                    break;
                case 3:
                    manageProduct.edit();
                    break;
                case 4:
                    manageProduct.delete();
                    break;
                case 5:
                    System.out.println("1. Hiển thị tăng dần");
                    System.out.println("2. Hiển thị giảm dần");
                    int sortChoice;
                    while (true) {
                        try {
                            System.out.println("Nhập lựa chọn của bạn");
                            sortChoice = Integer.parseInt(scanner.nextLine());
                            if (sortChoice == 1 || sortChoice == 2) {
                                break;
                            } else {
                                System.out.println("Lựa chọn không hợp lệ");
                            }
                        } catch (Exception e) {
                            System.out.println("Lựa chọn không hợp lệ");
                        }
                    }
                    if (sortChoice == 1) {
                        manageProduct.sortProductUp();
                    } else if (sortChoice == 2) {
                        manageProduct.sortProductDown();
                    }
                    manageProduct.display();
                    break;
                case 6:
                    System.out.println("Max la :"+manageProduct.findProductMax());
                    break;
                case 7:
                    System.out.println("Doc file se ghi mat ca du lieu hien tai?");
                    System.out.println("Co chac chan Doc file? Y/N");
                    String inputRead = scanner.nextLine();
                    if(inputRead.equals("Y")){
                       manageProduct.read();
                        System.out.println("Doc file thanh cong");
                    }

                    break;
                case 8:
                    System.out.println("Ghi file se ghi mat ca du lieu hien tai?");
                    System.out.println("Co chac chan ghi file? Y/N");
                    String inputWrite = scanner.nextLine();
                    if(inputWrite.equals("Y")){
                        manageProduct.write();
                        System.out.println("Ghi file thanh cong");
                    }

                    break;
                case 9:
                    return;
            }

        }

    }
}

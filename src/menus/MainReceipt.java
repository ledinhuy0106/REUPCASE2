package menus;

import model.Receipt;
import files.FileReceipt;

import service.ReceiptHanding;
import java.util.Scanner;

public class MainReceipt {
    public static void mainReceipt() {
        ReceiptHanding receiptHanding = new ReceiptHanding();
        receiptHanding.add(new Receipt(1,"uy","Lin","11/10/2021","10/10/2022",100));
        int choice = -1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. In danh sách receipt. ");
                System.out.println("2. Thêm receipt. ");
                System.out.println("3. Tìm recei theo id ");
                System.out.println("4. Sửa receipt ");
                System.out.println("5. Viết ");
                System.out.println("6. Đọc ");
                System.out.println("7. Tổng tiền. ");
                System.out.println("8. Xóa Recei ");
                System.out.println("9. Quay lại menu ");
                System.out.println("0. Kết thúc ");
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Sai đầu vào");
            }
            switch (choice) {
                case 1:
                    receiptHanding.printList();
                    break;
                case 2:
                    receiptHanding.add(receiptHanding.creat());
                    try {
                        FileReceipt.write2("fileReceipt.csv", receiptHanding.getReceiptList());
                        System.out.println("Hoàn thành");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Nhập id");
                    int id = scanner.nextInt();
                    receiptHanding.findIndexById2(id);
                    break;
                case 4:
                    System.out.println("Nhập id muốn edit");
                    int editInForById = scanner.nextInt();
                    receiptHanding.edit(editInForById, receiptHanding.creat());
                    try {
                        FileReceipt.write2("fileReceipt.csv", receiptHanding.getReceiptList());
                        System.out.println("Hoàn thành");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        FileReceipt.write2("fileReceipt.csv", receiptHanding.getReceiptList());
                        System.out.println("Hoàn thành");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        FileReceipt.read2("fileReceipt.csv");
                        System.out.println("Hoàn thành");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    receiptHanding.getTotalMoney();
                    break;
                case 8:
                    System.out.println("Nhập id muốn xóa");
                    int deleteById = scanner.nextInt();
                    receiptHanding.delete2(deleteById);
                    break;
                case 9:
                    MainManagement.showMenu();
                    break;
                case 0:
                    System.out.println("Kết thúc");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }
}

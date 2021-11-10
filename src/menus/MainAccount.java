package menus;

import model.Account;
import service.AccountHanding;
import service.AccountManage;

import java.util.Scanner;

public class MainAccount {
    public static void account() {
        AccountHanding accountHanding = new AccountHanding();
        accountHanding.add(new Account("uy", "123", "uy", 18, "353413219", "uyblack1234567890@gmail.com"));
        System.out.println("Xìn chào đã đến khách sạn");
        System.out.println("Vui lòng đăng nhập: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên đăng nhập: ");
        String user = scanner.nextLine();
        System.out.println("nhập mật khẩu: ");
        String pass = scanner.nextLine();
        boolean check = accountHanding.findUserAndPass(user, pass);
        if (check) {
            System.out.println("Hoàn thành");
            MainManagement.showMenu();
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
            System.out.println("Vui lòng nhập lại!");
        }
    }

    public static void accountMenu() {
        AccountHanding accountHanding = new AccountHanding();
        accountHanding.add(new Account("uy", "123", "uy", 18, "353413219", "uyblack1234567890@gmail,com"));
        int choice = -1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1.in danh sách quản trị ");
                System.out.println("2. thêm quản trị ");
                System.out.println("3. Quay lại menu ");
                System.out.println("0. Kết thúc ");
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Nhập sai đầu vào");
            }
            switch (choice) {
                case 1 -> accountHanding.printList();
                case 2 -> {
                    accountHanding.add(creat());
                    System.out.println("Hoàn thành!");
                }
                case 3 -> MainManagement.showMenu();
                case 0 -> {
                    System.out.println("Kết thúc!");
                    System.exit(0);
                }
                default -> System.out.println("Tùy chọn không hợp lệ!");
            }
        }
    }

    public static Account creat() {
        Scanner scanner = new Scanner(System.in);
        String useName = AccountManage.inputClientAccount();
        String pass = AccountManage.inputClientPassword();
        System.out.print("Nhập tên người dùng: ");
        String name = scanner.nextLine();
        String email = AccountManage.inputEmail();
        System.out.print("Nhập tuổi người dùng: ");
        int age = scanner.nextInt();
        String phone = AccountManage.inputPhoneNumber();
        return new Account(useName, pass, name, age, phone, email);
    }
}

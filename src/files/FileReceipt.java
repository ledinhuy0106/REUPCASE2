package files;

import model.Receipt;
import service.ReceiptHanding;

import java.io.*;
import java.util.List;

public class FileReceipt {
    public static void write2(String path, List<Receipt> list) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder str = new StringBuilder("Receipt id,Customer Name,Staff Name,Check in day,Check out day,Total money (USD)");
        for (Receipt receipt : list) {
            str.append("\n");
            str.append(receipt.getReceitId()).append(",");
            str.append(receipt.getCustomerName()).append(",");
            str.append(receipt.getStaffName()).append(",");
            str.append(receipt.getCheckinDay()).append(",");
            str.append(receipt.getCheckoutDay()).append(",");
            str.append(receipt.getReceiptPrice());
        }
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Receipt> read2(String patch) throws IOException {
        ReceiptHanding receiptManage = new ReceiptHanding();
        FileReader fileReader = new FileReader(patch);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            int id = Integer.parseInt(arr[0]);
            String customerName = arr[1];
            String staffName = arr[2];
            String checkIn = arr[3];
            String checkOut = arr[4];
            double money = Double.parseDouble(arr[5]);
            receiptManage.add(new Receipt(id, customerName, staffName, checkIn, checkOut, money));
        }
        receiptManage.printList();
        bufferedReader.close();
        return null;
    }
}

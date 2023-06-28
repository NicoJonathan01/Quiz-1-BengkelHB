package view;

import javax.swing.JOptionPane;
import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;

import model.JenisPembayaran;

public class Dialog {
    public static String showInputDialog(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public static void showMessageDialog(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static JenisPembayaran showInputDialogForEnum(String message, String title, JenisPembayaran[] selectionValue, JenisPembayaran initialSelectionValue){
        return (JenisPembayaran) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, selectionValue, initialSelectionValue);
    }

    public static Date showInputDialogForDate(String message, String title, Date initialSelectionValue){
        // return (Date) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, null, initialSelectionValue);

        DateFormat dateFormat = DateFormat.getDateInstance();

        String dateString = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, null, initialSelectionValue != null ? dateFormat.format(initialSelectionValue) : null).toString();

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }
}

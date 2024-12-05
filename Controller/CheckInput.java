package Controller;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class CheckInput {
    public static String cekJenisKelamin(JRadioButton pria, JRadioButton wanita){
        if (pria.isSelected()) {
            return "Laki-laki";
        }
        else if (wanita.isSelected()) {
            return "Perempuan";
        }
        return "";
    }

    public static String cekGolonganDarah(JRadioButton a, JRadioButton b, JRadioButton o, JRadioButton ab, JRadioButton ssr){
        if (a.isSelected()) {
            return "A";
        }
        else if (b.isSelected()) {
            return "B";
        }
        else if (o.isSelected()) {
            return "O";
        }
        else if (ab.isSelected()) {
            return "AB";
        }
        else if (ssr.isSelected()){
            return "SSR";
        }
        return "";
    }

    public static String cekPekerjaan(JCheckBox karyawanSwasta, JCheckBox pns, JCheckBox wiraswasta, JCheckBox akademisi, JCheckBox pengangguran){
        String pekerjaan = "";
        if (karyawanSwasta.isSelected()) {
            pekerjaan += "Karyawan Swasta;";
        }
        if (pns.isSelected()) {
            pekerjaan += "PNS;";
        }
        if (wiraswasta.isSelected()) {
            pekerjaan += "Wiraswasta;";
        }
        if (akademisi.isSelected()) {
            pekerjaan += "Akademisi;";
        }
        if (pengangguran.isSelected()) {
            pekerjaan += "Pengangguran;";
        }
        return pekerjaan;
    }

    public static String cekNegaraAsal(JRadioButton wni, JRadioButton wna, Classes.Model.TextField negara){
        if (wni.isSelected()) {
            return "WNI";
        }
        else if (wna.isSelected()) {
            return "WNA: " + negara.getText();
        }
        return "";
    }
}

package View;

import Classes.Model.DatePicker;
import Classes.Model.Frame;
import Classes.Model.KTP;
import Classes.Model.Label;
import Classes.Model.Panel;
import Classes.Model.TextField;
import DB.ConnectionManager;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class InputData {
    
    static String profilPath;
    static String ttdPath;

    public static void inputDataKTP(){
        //hehe
        JRadioButton rbS = new JRadioButton("SSR");
        rbS.setVisible(false);
        Frame inputFrame = new Frame("Form Pengisian Data KTP");
        Panel panel = new Panel();
        inputFrame.add(panel);
        
        Label lNIK = new Label("NIK");
        lNIK.setBounds(10, 5, 300, 30);
        TextField nik = new TextField();
        nik.setBounds(310, 5, 300, 30);
        panel.add(lNIK);
        panel.add(nik);
        nik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (nik.getText().equalsIgnoreCase("genshin")) {
                    rbS.setVisible(true);
                }
                else{
                    rbS.setVisible(true);
                }
            }
        });

        Label lNama = new Label("Nama");
        lNama.setBounds(10, 40, 300, 30);
        TextField nama = new TextField();
        nama.setBounds(310, 40, 300, 30);
        panel.add(lNama);
        panel.add(nama);

        Label lTempatLahir = new Label("Tempat Lahir");
        lTempatLahir.setBounds(10, 75, 300, 30);
        TextField tempatLahir = new TextField();
        tempatLahir.setBounds(310, 75, 300, 30);
        panel.add(lTempatLahir);
        panel.add(tempatLahir);
        
        Label lTanggalLahir = new Label("Tanggal Lahir");
        lTanggalLahir.setBounds(10, 110, 300, 30);
        DatePicker tanggalLahir = new DatePicker();
        tanggalLahir.setBounds(310, 110, 300, 30);
        panel.add(lTanggalLahir);
        panel.add(tanggalLahir);
    
        Label lJenisKelamin = new Label("Jenis Kelamin");
        lJenisKelamin.setBounds(10, 145, 300, 30);
        Panel panelRadio = new Panel();
        panelRadio.setBounds(310, 145, 300, 30);
        panelRadio.setLayout(new FlowLayout());
        panel.add(panelRadio);
        JRadioButton rbPria = new JRadioButton("Pria");
        JRadioButton rbWanita = new JRadioButton("Wanita");
        ButtonGroup jenisKelamin = new ButtonGroup();
        jenisKelamin.add(rbPria);
        jenisKelamin.add(rbWanita);
        panel.add(lJenisKelamin);
        panelRadio.add(rbPria);
        panelRadio.add(rbWanita);
    
        Label lGolDarah = new Label("Golongan Darah");
        lGolDarah.setBounds(10, 180, 300, 30);
        Panel panelRadioGolDarah = new Panel();
        panelRadioGolDarah.setBounds(310, 180, 300, 30);
        panelRadioGolDarah.setLayout(new FlowLayout());
        panel.add(panelRadioGolDarah);
        JRadioButton rbA = new JRadioButton("A");
        JRadioButton rbB = new JRadioButton("B");
        JRadioButton rbO = new JRadioButton("O");
        JRadioButton rbAB = new JRadioButton("AB");
        ButtonGroup golDarah = new ButtonGroup();
        golDarah.add(rbA);
        golDarah.add(rbB);
        golDarah.add(rbO);
        golDarah.add(rbAB);
        golDarah.add(rbS);
        panel.add(lGolDarah);
        panelRadioGolDarah.add(rbA);
        panelRadioGolDarah.add(rbB);
        panelRadioGolDarah.add(rbO);
        panelRadioGolDarah.add(rbAB);
        panelRadioGolDarah.add(rbS);

        Label lAlamat = new Label("Alamat");
        lAlamat.setBounds(10, 215, 300, 30);
        TextField alamat = new TextField();
        alamat.setBounds(310, 215, 300, 30);
        panel.add(lAlamat);
        panel.add(alamat);
    
        Label lRTRW = new Label("RT/RW");
        lRTRW.setBounds(10, 250, 300, 30);
        TextField rtrw = new TextField();
        rtrw.setBounds(310, 250, 300, 30);
        panel.add(lRTRW);
        panel.add(rtrw);
    
        Label lKelDesa = new Label("Kel/Desa");
        lKelDesa.setBounds(10, 285, 300, 30);
        TextField kelDesa = new TextField();
        kelDesa.setBounds(310, 285, 300, 30);
        panel.add(lKelDesa);
        panel.add(kelDesa);
    
        Label lKecamatan = new Label("Kecamatan");
        lKecamatan.setBounds(10, 320, 300, 30);
        TextField kecamatan = new TextField();
        kecamatan.setBounds(310, 320, 300, 30);
        panel.add(lKecamatan);
        panel.add(kecamatan);
    
        Label lAgama = new Label("Agama");
        lAgama.setBounds(10, 355, 300, 30);
        JComboBox<String> cbAgama = new JComboBox<>();
        cbAgama.setBounds(310, 355, 300, 30);
        cbAgama.addItem("Kristen");
        cbAgama.addItem("Katolik");
        cbAgama.addItem("Islam");
        cbAgama.addItem("Buddha");
        cbAgama.addItem("Hindu");
        cbAgama.addItem("Konghucu");
        panel.add(lAgama);
        panel.add(cbAgama);

        Label lStatusPerkawinan = new Label("Status Perkawinan");
        lStatusPerkawinan.setBounds(10, 390, 300, 30);
        JComboBox<String> cbStatusPerkawinan = new JComboBox<>();
        cbStatusPerkawinan.setBounds(310, 390, 300, 30);
        cbStatusPerkawinan.addItem("Belum Menikah");
        cbStatusPerkawinan.addItem("Menikah");
        cbStatusPerkawinan.addItem("Janda");
        cbStatusPerkawinan.addItem("Duda");
        panel.add(lStatusPerkawinan);
        panel.add(cbStatusPerkawinan);
        
        Label lPekerjaan = new Label("Pekerjaan");
        lPekerjaan.setBounds(10, 425, 300, 30);
        Panel chbPekerjaan = new Panel();
        chbPekerjaan.setBounds(310, 425, 300, 60);
        chbPekerjaan.setLayout(new FlowLayout());
        JCheckBox chbKaryawanSwasta = new JCheckBox("Karyawan Swasta");
        JCheckBox chbPNS = new JCheckBox("PNS");
        JCheckBox chbWiraswasta = new JCheckBox("Wiraswatsa");
        JCheckBox chbAkademisi = new JCheckBox("Akademisi");
        JCheckBox chbPengangguran = new JCheckBox("Pengangguran");
        chbPekerjaan.add(chbKaryawanSwasta);
        chbPekerjaan.add(chbPNS);
        chbPekerjaan.add(chbWiraswasta);
        chbPekerjaan.add(chbAkademisi);
        chbPekerjaan.add(chbPengangguran);
        panel.add(lPekerjaan);
        panel.add(chbPekerjaan);
        chbPengangguran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chbPengangguran.isSelected()) {
                    chbKaryawanSwasta.setEnabled(false);
                    chbPNS.setEnabled(false);
                    chbWiraswasta.setEnabled(false);
                    chbAkademisi.setEnabled(false);

                    chbKaryawanSwasta.setSelected(false);
                    chbPNS.setSelected(false);
                    chbWiraswasta.setSelected(false);
                    chbAkademisi.setSelected(false);

                } else {
                    chbKaryawanSwasta.setEnabled(true);
                    chbPNS.setEnabled(true);
                    chbWiraswasta.setEnabled(true);
                    chbAkademisi.setEnabled(true);
                }
            }
        });
    
        Label lKewarganegaraan = new Label("Kewarganegaraan");
        lKewarganegaraan.setBounds(10, 490, 300, 30);
        Panel panelKewarganegaraan = new Panel();
        panelKewarganegaraan.setBounds(310, 490, 300, 30);
        panelKewarganegaraan.setLayout(new FlowLayout());
        panel.add(panelKewarganegaraan);
        JRadioButton rbWNI = new JRadioButton("WNI");
        JRadioButton rbWNA = new JRadioButton("WNA");
        ButtonGroup kewarganegaraan = new ButtonGroup();
        kewarganegaraan.add(rbWNI);
        kewarganegaraan.add(rbWNA);
        panel.add(lKewarganegaraan);
        panelKewarganegaraan.add(rbWNI);
        panelKewarganegaraan.add(rbWNA);
        TextField asalNegara = new TextField();
        asalNegara.setBounds(200, 8, 80, 20);
        asalNegara.setVisible(false);
        panelKewarganegaraan.add(asalNegara);
        rbWNA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == rbWNA) {
                    asalNegara.setVisible(true);
                }
            }
        });
        rbWNI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == rbWNI) {
                    asalNegara.setVisible(false);
                }
            }
        });

        Label lFotoProfil = new Label("Foto Profil");
        lFotoProfil.setBounds(10, 525, 300, 30);
        JButton fileFoto = new JButton("Masukkan Foto");
        fileFoto.setBounds(310, 525, 300, 30);
        panel.add(lFotoProfil);
        panel.add(fileFoto);
        fileFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("Assets"));
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    profilPath = fileChooser.getSelectedFile().getAbsolutePath();
                }
            }
        });
        
        Label lTandaTangan = new Label("Tanda Tangan");
        lTandaTangan.setBounds(10, 560, 300, 30);
        JButton fileTTD = new JButton("Masukkan Foto");
        fileTTD.setBounds(310, 560, 300, 30);
        panel.add(lTandaTangan);
        panel.add(fileTTD);
        fileTTD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser2 = new JFileChooser();
                fileChooser2.setCurrentDirectory(new File("Assets"));
                int returnValue = fileChooser2.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    ttdPath = fileChooser2.getSelectedFile().getAbsolutePath();
                }
            }
        });

        Label lBerlakuHingga = new Label("Berlaku Hingga");
        lBerlakuHingga.setBounds(10, 595, 300, 30);
        TextField berlakuHingga = new TextField();
        berlakuHingga.setBounds(310, 595, 300, 30);
        panel.add(lBerlakuHingga);
        panel.add(berlakuHingga);
        
        Label lKotaPembuatan = new Label("Kota Pembuatan KTP");
        lKotaPembuatan.setBounds(10, 630, 300, 30);
        TextField kotaPembuatan = new TextField();
        kotaPembuatan.setBounds(310, 630, 300, 30);
        panel.add(lKotaPembuatan);
        panel.add(kotaPembuatan);

        JButton confirmation = new JButton("Submit");
        confirmation.setBounds(510, 665, 100, 30);
        panel.add(confirmation);

        inputFrame.setVisible(true);

        confirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String nikData = nik.getText();
                String namaData = nama.getText();
                String tempatLahirData = tempatLahir.getText();
                Date temp = tanggalLahir.getDate();
                String tanggalLahirData = "";
                if (temp != null) {
                    tanggalLahirData = format.format(temp);
                }
                String jenisKelaminData = Controller.CheckInput.cekJenisKelamin(rbPria, rbWanita);
                String golonganDarahData = Controller.CheckInput.cekGolonganDarah(rbA, rbB, rbO, rbAB, rbS);
                String alamatData = alamat.getText();
                String rtrwData = rtrw.getText();
                String kelDesaData = kelDesa.getText();
                String kecamatanData = kecamatan.getText();
                String agamaData = cbAgama.getSelectedItem().toString();
                String statusPerkawinanData = cbStatusPerkawinan.getSelectedItem().toString();
                String pekerjaanData = Controller.CheckInput.cekPekerjaan(chbKaryawanSwasta, chbPNS, chbWiraswasta, chbAkademisi, chbPengangguran);
                String negaraAsalData = Controller.CheckInput.cekNegaraAsal(rbWNI, rbWNA, asalNegara);
                String berlakuHinggaData = berlakuHingga.getText();
                String kotaPembuatanData = kotaPembuatan.getText();
                String tanggalPembuatanData = format.format(Calendar.getInstance().getTime());
                
                if (nikData.isEmpty() || namaData.isEmpty() || tempatLahirData.isEmpty() || tanggalLahirData.isEmpty()
                || jenisKelaminData.isEmpty() || golonganDarahData.isEmpty() || alamatData.isEmpty() || rtrwData.isEmpty()
                || kelDesaData.isEmpty() || kecamatanData.isEmpty() || agamaData.isEmpty() || statusPerkawinanData.isEmpty()
                || pekerjaanData.isEmpty() || negaraAsalData.isEmpty() || berlakuHinggaData.isEmpty() || kotaPembuatanData.isEmpty()
                || tanggalPembuatanData.isEmpty() || profilPath.isEmpty() || ttdPath.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ada field yang tidak terisi", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String query = "insert into dataktp (nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golonganDarah, alamat, rtrw, kelDesa, kecamatan, agama, statusPerkawinan, pekerjaan, negaraAsal, profilePath, ttdPath, berlakuHingga, kotaPembuatan, tanggalPembuatan) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        PreparedStatement st = ConnectionManager.connect().prepareStatement(query);
                        st.setString(1, nikData);
                        st.setString(2, namaData);
                        st.setString(3, tempatLahirData);
                        st.setString(4, tanggalLahirData);
                        st.setString(5, jenisKelaminData);
                        st.setString(6, golonganDarahData);
                        st.setString(7, alamatData);
                        st.setString(8, rtrwData);
                        st.setString(9, kelDesaData);
                        st.setString(10, kecamatanData);
                        st.setString(11, agamaData);
                        st.setString(12, statusPerkawinanData);
                        st.setString(13, pekerjaanData);
                        st.setString(14, negaraAsalData);
                        st.setString(15, profilPath);
                        st.setString(16, ttdPath);
                        st.setString(17, berlakuHinggaData);
                        st.setString(18, kotaPembuatanData);
                        st.setString(19, tanggalPembuatanData);

                        st.execute();
                    } catch (SQLException er) {
                        er.printStackTrace();
                    }
                    KTP ktpBaru = new KTP(nikData, namaData, tempatLahirData, tanggalLahirData, jenisKelaminData, golonganDarahData, alamatData, rtrwData, kelDesaData, kecamatanData, agamaData, statusPerkawinanData, pekerjaanData, negaraAsalData, profilPath, ttdPath, berlakuHinggaData, kotaPembuatanData, tanggalPembuatanData);
                    Classes.Model.Data.listKTP.add(ktpBaru);
                    inputFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Berhasil Membuat KTP", "Success", JOptionPane.DEFAULT_OPTION);
                    View.ShowKTP.showKTP(ktpBaru);
                }
            }
        });
    }
}

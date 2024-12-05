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


public class UpdateDeleteKTP {

    static String profilPath;
    static String ttdPath;

    public static void deleteKTP(String nik){
        String query = "DELETE FROM dataktp WHERE nik = ?";
        try (PreparedStatement st = ConnectionManager.connect().prepareStatement(query)) {
            st.setString(1, nik);

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Delete KTP", "Success", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            er.printStackTrace();
        }
    }

    public static void updateKTP(KTP ktp){
        //hehe
        JRadioButton rbS = new JRadioButton("SSR");
        rbS.setVisible(false);
        Frame inputFrame = new Frame("Form Pengisian Data KTP");
        Panel panel = new Panel();
        inputFrame.add(panel);
        
        Label lNIK = new Label("NIK");
        lNIK.setBounds(10, 5, 300, 30);
        TextField nik = new TextField();
        nik.setText(ktp.getNik());
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
        nama.setText(ktp.getNama());
        nama.setBounds(310, 40, 300, 30);
        panel.add(lNama);
        panel.add(nama);

        Label lTempatLahir = new Label("Tempat Lahir");
        lTempatLahir.setBounds(10, 75, 300, 30);
        TextField tempatLahir = new TextField();
        tempatLahir.setText(ktp.getTempatLahir());
        tempatLahir.setBounds(310, 75, 300, 30);
        panel.add(lTempatLahir);
        panel.add(tempatLahir);
        
        Label lTanggalLahir = new Label("Tanggal Lahir");
        lTanggalLahir.setBounds(10, 110, 300, 30);
        DatePicker tanggalLahir = new DatePicker();
        tanggalLahir.setDateFormatString(ktp.getTanggalLahir());
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
        String sebelumUpdateKelamin = ktp.getJenisKelamin();
        if (sebelumUpdateKelamin.equalsIgnoreCase("laki-laki")) {
            rbPria.setSelected(true);
        }
        else{
            rbWanita.setSelected(true);
        }
    
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
        String sebelumUpdateGolDar = ktp.getGolonganDarah();
        if (sebelumUpdateGolDar.equalsIgnoreCase("a")) {
            rbA.setSelected(true);
        }
        else if (sebelumUpdateGolDar.equalsIgnoreCase("b")) {
            rbB.setSelected(true);
        }
        else if (sebelumUpdateGolDar.equalsIgnoreCase("o")) {
            rbO.setSelected(true);
        }
        else if (sebelumUpdateGolDar.equalsIgnoreCase("ab")) {
            rbAB.setSelected(true);
        }
        else{
            rbS.setSelected(true);
        }

        Label lAlamat = new Label("Alamat");
        lAlamat.setBounds(10, 215, 300, 30);
        TextField alamat = new TextField();
        alamat.setText(ktp.getAlamat());
        alamat.setBounds(310, 215, 300, 30);
        panel.add(lAlamat);
        panel.add(alamat);
    
        Label lRTRW = new Label("RT/RW");
        lRTRW.setBounds(10, 250, 300, 30);
        TextField rtrw = new TextField();
        rtrw.setText(ktp.getRtrw());
        rtrw.setBounds(310, 250, 300, 30);
        panel.add(lRTRW);
        panel.add(rtrw);
    
        Label lKelDesa = new Label("Kel/Desa");
        lKelDesa.setBounds(10, 285, 300, 30);
        TextField kelDesa = new TextField();
        kelDesa.setText(ktp.getKelDesa());
        kelDesa.setBounds(310, 285, 300, 30);
        panel.add(lKelDesa);
        panel.add(kelDesa);
    
        Label lKecamatan = new Label("Kecamatan");
        lKecamatan.setBounds(10, 320, 300, 30);
        TextField kecamatan = new TextField();
        kecamatan.setText(ktp.getKecamatan());
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
        String sebelumUpdateAgama = ktp.getAgama();
        if (sebelumUpdateAgama.equalsIgnoreCase("kristen")) {
            cbAgama.setSelectedIndex(1);
        }
        else if (sebelumUpdateAgama.equalsIgnoreCase("katolik")) {
            cbAgama.setSelectedIndex(2);
        }
        else if (sebelumUpdateAgama.equalsIgnoreCase("islam")) {
            cbAgama.setSelectedIndex(3);
        }
        else if (sebelumUpdateAgama.equalsIgnoreCase("buddha")) {
            cbAgama.setSelectedIndex(4);
        }
        else if (sebelumUpdateAgama.equalsIgnoreCase("hindu")) {
            cbAgama.setSelectedIndex(5);
        }
        else {
            cbAgama.setSelectedIndex(6);
        }

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
        String sebelumUpdateStatusPerkawinan = ktp.getStatusPerkawinan();
        if (sebelumUpdateStatusPerkawinan.equalsIgnoreCase("belum menikah")) {
            cbStatusPerkawinan.setSelectedIndex(1);
        }
        else if (sebelumUpdateStatusPerkawinan.equalsIgnoreCase("menikah")) {
            cbStatusPerkawinan.setSelectedIndex(2);
        }
        else if (sebelumUpdateStatusPerkawinan.equalsIgnoreCase("janda")) {
            cbStatusPerkawinan.setSelectedIndex(3);
        }
        else {
            cbStatusPerkawinan.setSelectedIndex(4);
        }
        
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
        profilPath = ktp.getProfilePath();
        
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
        ttdPath = ktp.getTtdPath();

        Label lBerlakuHingga = new Label("Berlaku Hingga");
        lBerlakuHingga.setBounds(10, 595, 300, 30);
        TextField berlakuHingga = new TextField();
        berlakuHingga.setText(ktp.getBerlakuHingga());
        berlakuHingga.setBounds(310, 595, 300, 30);
        panel.add(lBerlakuHingga);
        panel.add(berlakuHingga);
        
        Label lKotaPembuatan = new Label("Kota Pembuatan KTP");
        lKotaPembuatan.setBounds(10, 630, 300, 30);
        TextField kotaPembuatan = new TextField();
        kotaPembuatan.setText(ktp.getKotaPembuatan());
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
                    String query = "UPDATE dataktp SET nama = ?, tempatLahir = ?, tanggalLahir = ?, jenisKelamin = ?, golonganDarah = ?, alamat = ?, rtrw = ?, kelDesa = ?, kecamatan = ?, agama = ?, statusPerkawinan = ?, pekerjaan = ?, negaraAsal = ?, profilePath = ?, ttdPath = ?, berlakuHingga = ?, kotaPembuatan = ?, tanggalPembuatan = ? WHERE nik = ?";
                    try {
                        PreparedStatement st = ConnectionManager.connect().prepareStatement(query);
                        st.setString(1, namaData);
                        st.setString(2, tempatLahirData);
                        st.setString(3, tanggalLahirData);
                        st.setString(4, jenisKelaminData);
                        st.setString(5, golonganDarahData);
                        st.setString(6, alamatData);
                        st.setString(7, rtrwData);
                        st.setString(8, kelDesaData);
                        st.setString(9, kecamatanData);
                        st.setString(10, agamaData);
                        st.setString(11, statusPerkawinanData);
                        st.setString(12, pekerjaanData);
                        st.setString(13, negaraAsalData);
                        st.setString(14, profilPath);
                        st.setString(15, ttdPath);
                        st.setString(16, berlakuHinggaData);
                        st.setString(17, kotaPembuatanData);
                        st.setString(18, tanggalPembuatanData);
                        st.setString(19, nikData);

                        st.execute();
                    } catch (SQLException er) {
                        er.printStackTrace();
                    }
                    KTP ktpBaru = new KTP(nikData, namaData, tempatLahirData, tanggalLahirData, jenisKelaminData, golonganDarahData, alamatData, rtrwData, kelDesaData, kecamatanData, agamaData, statusPerkawinanData, pekerjaanData, negaraAsalData, profilPath, ttdPath, berlakuHinggaData, kotaPembuatanData, tanggalPembuatanData);
                    Classes.Model.Data.listKTP.add(ktpBaru);
                    inputFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Berhasil Update KTP", "Success", JOptionPane.DEFAULT_OPTION);
                    View.ShowKTP.showKTP(ktpBaru);
                }
            }
        });
    }
}
package View;

import Classes.Model.*;
import DB.ConnectionManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ShowKTP {
    public static void searchKTP(){
        Frame frame = new Frame("Select KTP");
        frame.setBounds(400, 300, 640, 100);
        Panel panel = new Panel();
        frame.add(panel);

        Label lNIK = new Label("NIK");
        lNIK.setBounds(10, 5, 300, 30);
        TextField nik = new TextField();
        nik.setBounds(100, 5, 300, 30);
        panel.add(lNIK);
        panel.add(nik);

        JButton show = new JButton("Search");
        show.setBounds(400, 5, 150, 30);
        panel.add(show);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT * FROM dataktp WHERE nik = ?";
                try (PreparedStatement st = ConnectionManager.connect().prepareStatement(query)) {
                    st.setString(1, nik.getText());

                    try (ResultSet rs = st.executeQuery()) {
                        if (rs.next()) {
                            KTP ktpShowed = new KTP(
                                rs.getString("nik"),
                                rs.getString("nama"),
                                rs.getString("tempatLahir"),
                                rs.getString("tanggalLahir"),
                                rs.getString("jenisKelamin"),
                                rs.getString("golonganDarah"),
                                rs.getString("alamat"),
                                rs.getString("rtrw"),
                                rs.getString("kelDesa"),
                                rs.getString("kecamatan"),
                                rs.getString("agama"),
                                rs.getString("statusPerkawinan"),
                                rs.getString("pekerjaan"),
                                rs.getString("negaraAsal"),
                                rs.getString("profilePath"),
                                rs.getString("ttdPath"),
                                rs.getString("berlakuHingga"),
                                rs.getString("kotaPembuatan"),
                                rs.getString("tanggalPembuatan")
                            );
                            ShowKTP.showKTP(ktpShowed);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(panel, "KTP tidak ditemukan", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (SQLException er) {
                    JOptionPane.showMessageDialog(panel, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    er.printStackTrace();
                }
            }
        });


        frame.setVisible(true);
    }
    public static void showKTP(KTP ktp){
        Frame frame = new Frame("KTP");
        frame.setBounds(350, 200, 700, 420);
        Panel panel = new Panel();
        panel.setBackground(Color.CYAN);
        frame.add(panel);
        
        Label titleKTP = new Label("REPUBLIK HARAPAN BANGSA");
        titleKTP.setFont(new Font("Helvetica", Font.PLAIN, 30));
        titleKTP.setBounds(120,0,600,50);
        panel.add(titleKTP);

        Label lnik = new Label("NIK");
        lnik.setFont(new Font("Helvetica", Font.PLAIN, 20));
        lnik.setBounds(20, 055, 50, 40);
        panel.add(lnik);
        Label nik = new Label(ktp.getNik());
        nik.setFont(new Font("Helvetica", Font.PLAIN, 20));
        nik.setBounds(160, 055, 300, 40);
        panel.add(nik);

        Label lNama = new Label("Nama");
        lNama.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lNama.setBounds(20, 75, 150, 30);
        panel.add(lNama);
        Label Nama = new Label(ktp.getNama().toUpperCase());
        Nama.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Nama.setBounds(160, 75, 300, 30);
        panel.add(Nama);

        Label lTempatTanggalLahir = new Label("Tempat/Tgl Lahir");
        lTempatTanggalLahir.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lTempatTanggalLahir.setBounds(20, 95, 150, 30);
        panel.add(lTempatTanggalLahir);
        Label TempatTanggalLahir = new Label(ktp.getTempatLahir().toUpperCase() + ", " +  ktp.getTanggalLahir().toUpperCase());
        TempatTanggalLahir.setFont(new Font("Helvetica", Font.PLAIN, 15));
        TempatTanggalLahir.setBounds(160, 95, 300, 30);
        panel.add(TempatTanggalLahir);

        Label lJenisKelamin = new Label("Jenis Kelamin");
        lJenisKelamin.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lJenisKelamin.setBounds(20, 115, 150, 30);
        panel.add(lJenisKelamin);
        Label JenisKelamin = new Label(ktp.getJenisKelamin().toUpperCase());
        JenisKelamin.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JenisKelamin.setBounds(160, 115, 300, 30);
        panel.add(JenisKelamin);

        Label lGolonganDarah = new Label("Gol.Darah : ");
        lGolonganDarah.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lGolonganDarah.setBounds(300, 115, 150, 30);
        panel.add(lGolonganDarah);
        Label golonganDarah = new Label(ktp.getGolonganDarah().toUpperCase());
        golonganDarah.setFont(new Font("Helvetica", Font.PLAIN, 15));
        golonganDarah.setBounds(380, 115, 300, 30);
        panel.add(golonganDarah);

        Label lAlamat = new Label("Alamat");
        lAlamat.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lAlamat.setBounds(20, 135, 150, 30);
        panel.add(lAlamat);
        Label Alamat = new Label(ktp.getAlamat().toUpperCase());
        Alamat.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Alamat.setBounds(160, 135, 300, 30);
        panel.add(Alamat);

        Label lRTRW = new Label("RT/RW");
        lRTRW.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lRTRW.setBounds(40, 155, 150, 30);
        panel.add(lRTRW);
        Label RTRW = new Label(ktp.getRtrw().toUpperCase());
        RTRW.setFont(new Font("Helvetica", Font.PLAIN, 15));
        RTRW.setBounds(160, 155, 300, 30);
        panel.add(RTRW);
        
        Label lKelDesa = new Label("Kel/Desa");
        lKelDesa.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lKelDesa.setBounds(40, 175, 150, 30);
        panel.add(lKelDesa);
        Label KelDesa = new Label(ktp.getKelDesa().toUpperCase());
        KelDesa.setFont(new Font("Helvetica", Font.PLAIN, 15));
        KelDesa.setBounds(160, 175, 300, 30);
        panel.add(KelDesa);
        
        Label lKecamatan = new Label("Kecamatan");
        lKecamatan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lKecamatan.setBounds(40, 195, 150, 30);
        panel.add(lKecamatan);
        Label Kecamatan = new Label(ktp.getKecamatan().toUpperCase());
        Kecamatan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Kecamatan.setBounds(160, 195, 300, 30);
        panel.add(Kecamatan);
        
        Label lAgama = new Label("Agama");
        lAgama.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lAgama.setBounds(20, 215, 150, 30);
        panel.add(lAgama);
        Label Agama = new Label(ktp.getAgama().toUpperCase());
        Agama.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Agama.setBounds(160, 215, 300, 30);
        panel.add(Agama);
        
        Label lStatusPerkawinan = new Label("Status Perkawinan");
        lStatusPerkawinan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lStatusPerkawinan.setBounds(20, 235, 150, 30);
        panel.add(lStatusPerkawinan);
        Label StatusPerkawinan = new Label(ktp.getStatusPerkawinan().toUpperCase());
        StatusPerkawinan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        StatusPerkawinan.setBounds(160, 235, 300, 30);
        panel.add(StatusPerkawinan);
        
        Label lPekerjaan = new Label("Pekerjaan");
        lPekerjaan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lPekerjaan.setBounds(20, 255, 150, 30);
        panel.add(lPekerjaan);
        Label Pekerjaan = new Label(ktp.getPekerjaan().toUpperCase());
        Pekerjaan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Pekerjaan.setBounds(160, 255, 300, 30);
        panel.add(Pekerjaan);
        
        Label lKewarganegaraan = new Label("Kewarganegaraan");
        lKewarganegaraan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lKewarganegaraan.setBounds(20, 275, 150, 30);
        panel.add(lKewarganegaraan);
        Label Kewarganegaraan = new Label(ktp.getNegaraAsal().toUpperCase());
        Kewarganegaraan.setFont(new Font("Helvetica", Font.PLAIN, 15));
        Kewarganegaraan.setBounds(160, 275, 300, 30);
        panel.add(Kewarganegaraan);
        
        Label lBerlakuHingga = new Label("Berlaku Hingga");
        lBerlakuHingga.setFont(new Font("Helvetica", Font.PLAIN, 15));
        lBerlakuHingga.setBounds(20, 295, 150, 30);
        panel.add(lBerlakuHingga);
        Label BerlakuHingga = new Label(ktp.getBerlakuHingga().toUpperCase());
        BerlakuHingga.setFont(new Font("Helvetica", Font.PLAIN, 15));
        BerlakuHingga.setBounds(160, 295, 300, 30);
        panel.add(BerlakuHingga);
        
        ImageIcon profile = new ImageIcon(ktp.getProfilePath());
        JLabel profileLabel = new JLabel();
        profileLabel.setBounds(470, 60, 135,150);
        profileLabel.setIcon(profile);
        panel.add(profileLabel);
        Label labelKotaProfil = new Label(ktp.getKotaPembuatan().toUpperCase());
        labelKotaProfil.setBounds(470, 210, 120,30);
        Label labelTanggalProfil = new Label(ktp.getTanggalPembuatan().toUpperCase());
        labelTanggalProfil.setBounds(450, 230, 150,30);
        panel.add(labelKotaProfil);
        panel.add(labelTanggalProfil);

        ImageIcon ttd = new ImageIcon(ktp.getTtdPath());
        JLabel ttdLabel = new JLabel();
        ttdLabel.setBounds(470, 270, 135,60);
        ttdLabel.setIcon(ttd);
        panel.add(ttdLabel);

        JButton update = new JButton("Update KTP");
        update.setBounds(20, 320, 100, 30);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                UpdateDeleteKTP.updateKTP(ktp);
                frame.dispose();
            }
        });

        JButton delete = new JButton("Delete KTP");
        delete.setBounds(150, 320, 100, 30);
        panel.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                UpdateDeleteKTP.deleteKTP(ktp.getNik());
                frame.dispose();
            }
        });


        frame.setVisible(true);
    }
}

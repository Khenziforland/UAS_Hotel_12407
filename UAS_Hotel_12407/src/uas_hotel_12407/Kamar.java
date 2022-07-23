/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_hotel_12407;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ryuu
 */
public class Kamar extends javax.swing.JFrame {
    int Pendapatan_keuangan, sub_total;
    int kamarA_terisi, kamarB_terisi, kamarC_terisi;
    int kamarA_kosong, kamarB_kosong, kamarC_kosong;
    String kelas;
    Connection conn;
    Statement stm;
            String url = "jdbc:mysql://localhost/pbo_hotel_12407";
            String user = "root";
            String pass = "";

    /**
     * Creates new form Kamar
     */
    public Kamar() throws SQLException {
        initComponents();
        input_kamar(false);
        getDataLaporan();
        tampil_data_kamar();
    }
    
    void input_kamar(boolean x) {
        kodeKamar.setEnabled(x);
        namaKamar.setEnabled(x);
        hargaKamar.setEnabled(x);
        kelasKamar.setEnabled(x);
        fasilitasKamar.setEnabled(x);
        posisiKamar.setEnabled(x);
    }
    
    private void getDataLaporan() throws SQLException {
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm .executeQuery("SELECT * FROM laporan");
        
        if (res.next()) {
        kamarA_terisi = res.getInt("kamarA_terisi");
        kamarB_terisi = res.getInt("kamarB_terisi");
        kamarC_terisi = res.getInt("kamarC_terisi");
        
        kamarA_kosong = res.getInt("kamarA_kosong");
        kamarB_kosong = res.getInt("kamarB_kosong");
        kamarC_kosong = res.getInt("kamarC_kosong");
        
        Pendapatan_keuangan = res.getInt("Pendapatan_keuangan");
            }
    }
    
    private void updateDataLaporan() throws SQLException {
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("UPDATE laporan SET "
                + "kamarA_terisi = '"+kamarA_terisi+"', kamarB_terisi = '"+kamarB_terisi+"', kamarC_terisi = '"+kamarC_terisi+"', kamarA_kosong = '"+kamarA_kosong+"',"
                + "kamarB_kosong = '"+kamarB_kosong+"', kamarC_kosong = '"+kamarC_kosong+"', Pendapatan_keuangan = '"+Pendapatan_keuangan+"' WHERE 1");
        
        if ( pstm.executeUpdate() > 0) {
            
        }
    }
    
    private void tampil_data_kamar() throws SQLException {
        DefaultTableModel tableKamar = new DefaultTableModel();
        
        tableKamar.addColumn("KODE KAMAR");
        tableKamar.addColumn("NAMA KAMAR");
        tableKamar.addColumn("KELAS");
        tableKamar.addColumn("HARGA");
        tableKamar.addColumn("FASILITAS");
        tableKamar.addColumn("POSISI KAMAR");
        
        tableDataKamar.setModel(tableKamar);
        
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet dataKamar = stm .executeQuery("SELECT * FROM kamar ORDER BY Kode_kamar ASC");
        
        while (dataKamar.next()) {
            tableKamar.addRow(new Object[]{
                dataKamar.getString("Kode_kamar"),
                dataKamar.getString("Nama_kamar"),
                dataKamar.getString("Kelas"),
                dataKamar.getString("Harga"),
                dataKamar.getString("fasilitas"),
                dataKamar.getString("Posisi_kamar")
            });
        }
    }
    
    private void kosongkan_input() {
        kodeKamar.setText("");
        namaKamar.setText("");
        hargaKamar.setText("");
        fasilitasKamar.setText("");
        
        kodeKamar.requestFocus();
    }
    
    private void simpan_data_kamar() throws SQLException {
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("INSERT INTO kamar"
                + " (Kode_kamar, Nama_kamar, Kelas, Harga, Fasilitas, Posisi_kamar)"
                + " VALUES ('"+kodeKamar.getText()+"', '"+namaKamar.getText()+"', '"+kelasKamar.getText()+"', '"+hargaKamar.getText()+"',"
                        + " '"+fasilitasKamar.getText()+"', '"+posisiKamar.getSelectedItem()+"')");
        tampil_data_kamar();
        
        if ( pstm.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Simpan Data Kamar Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Simpan Data Kamar Gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void ubah_data_kamar() throws SQLException {
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("UPDATE kamar SET "
                + "Kode_kamar = '"+kodeKamar.getText()+"', Nama_kamar = '"+namaKamar.getText()+"', Kelas = '"+kelasKamar.getText()+"', Harga = '"+hargaKamar.getText()+"',"
                + "Fasilitas = '"+fasilitasKamar.getText()+"', Posisi_kamar = '"+posisiKamar.getSelectedItem()+"' WHERE Kode_kamar = '"+kodeKamar.getText()+"'");
        
        if ( pstm.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Ubah Data Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new javax.swing.JPanel();
        judulCheckin = new javax.swing.JLabel();
        panelTamu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kodeKamar = new javax.swing.JTextField();
        namaKamar = new javax.swing.JTextField();
        hargaKamar = new javax.swing.JTextField();
        fasilitasKamar = new javax.swing.JTextField();
        posisiKamar = new javax.swing.JComboBox<>();
        kelasKamar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataKamar = new javax.swing.JTable();
        panelButton = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnInput = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        judulCheckin1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBackground.setBackground(new java.awt.Color(0, 0, 0));

        judulCheckin.setFont(new java.awt.Font("Edwardian Script ITC", 1, 48)); // NOI18N
        judulCheckin.setForeground(new java.awt.Color(218, 165, 32));
        judulCheckin.setText("Data Kamar Hotel Reyhan");

        panelTamu.setBackground(new java.awt.Color(255, 255, 255));
        panelTamu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Kode Kamar");
        panelTamu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nama Kamar");
        panelTamu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Harga");
        panelTamu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Kelas");
        panelTamu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fasilitas");
        panelTamu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Posisi Kamar");
        panelTamu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        kodeKamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kodeKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodeKamarKeyPressed(evt);
            }
        });
        panelTamu.add(kodeKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 170, -1));

        namaKamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        namaKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKamarActionPerformed(evt);
            }
        });
        namaKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaKamarKeyPressed(evt);
            }
        });
        panelTamu.add(namaKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 310, -1));

        hargaKamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hargaKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaKamarActionPerformed(evt);
            }
        });
        hargaKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hargaKamarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKamarKeyTyped(evt);
            }
        });
        panelTamu.add(hargaKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, -1));

        fasilitasKamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fasilitasKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fasilitasKamarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fasilitasKamarKeyTyped(evt);
            }
        });
        panelTamu.add(fasilitasKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 250, -1));

        posisiKamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        posisiKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lantai 1", "Lantai 2", "Lantai 3" }));
        panelTamu.add(posisiKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 100, -1));

        kelasKamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kelasKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kelasKamarKeyPressed(evt);
            }
        });
        panelTamu.add(kelasKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 70, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("A / B / C");
        panelTamu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        tableDataKamar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableDataKamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDataKamar);

        panelButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        panelButton.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 90, 40));

        btnInput.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInput.setText("INPUT");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });
        panelButton.add(btnInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 40));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 40));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelButton.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, 40));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panelButton.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 40));

        judulCheckin1.setFont(new java.awt.Font("Edwardian Script ITC", 1, 48)); // NOI18N
        judulCheckin1.setForeground(new java.awt.Color(218, 165, 32));
        judulCheckin1.setText("Input Data Kamar");

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(judulCheckin)
                .addGap(225, 225, 225))
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTamu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(judulCheckin1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulCheckin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(judulCheckin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kodeKamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeKamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if( kodeKamar.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error: Kode Kamar Tidak Boleh Kosong !",
                    "Error !", JOptionPane.WARNING_MESSAGE);
            } else {
                namaKamar.requestFocus();
            }
        }
    }//GEN-LAST:event_kodeKamarKeyPressed

    private void namaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKamarActionPerformed

    private void namaKamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if( namaKamar.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error: Nama Kamar Tidak Boleh Kosong !",
                    "Error !", JOptionPane.WARNING_MESSAGE);
            } else {
                hargaKamar.requestFocus();
            }
        }
    }//GEN-LAST:event_namaKamarKeyPressed

    private void hargaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaKamarActionPerformed

    private void hargaKamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if( hargaKamar.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error: Harga Kamar Tidak Boleh Kosong !",
                    "Error !", JOptionPane.WARNING_MESSAGE);
            } else {
                kelasKamar.requestFocus();
            }
        }
    }//GEN-LAST:event_hargaKamarKeyPressed

    private void fasilitasKamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fasilitasKamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if( namaKamar.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error: Fasilitas Kamar Tidak Boleh Kosong !",
                    "Error !", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_fasilitasKamarKeyPressed

    private void fasilitasKamarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fasilitasKamarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fasilitasKamarKeyTyped

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int reply =JOptionPane.showConfirmDialog(
            null,
            "Apakah Anda yakin ingin keluar aplikasi ?",
            "Konfirmasi Keluar Aplikasi",
            JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        // TODO add your handling code here:
        input_kamar(true);
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            if( kodeKamar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: Kode Kamar tidak boleh kosong !", 
                        "Error !", JOptionPane.WARNING_MESSAGE);
            }
            ubah_data_kamar();
            tampil_data_kamar();
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Kesalahan " + err);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            if( kodeKamar.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error: Kode Kamar tidak boleh kosong !", 
                        "Error !", JOptionPane.WARNING_MESSAGE);
            } else {
                conn = (Connection) DriverManager.getConnection(url, user, pass);
                stm = conn.createStatement();
                PreparedStatement pstm = conn.prepareStatement("DELETE FROM kamar WHERE Kode_kamar = '"+kodeKamar.getText()+"'");
        
            if ( pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }

            kelas = kelasKamar.getText();
                    switch (kelas) {
                        case "A":
                                kamarA_kosong -= 1;
                            break;
                        case "B":
                                kamarB_kosong -= 1;
                            break;
                        case "C":
                            kamarC_kosong -= 1;
                            break;
                        default:
                            break;
                    }
            tampil_data_kamar();
            kosongkan_input();
            updateDataLaporan();
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, "Kesalahan " + err);
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            // TODO add your handling code here:
            if( kodeKamar.getText().isEmpty() || namaKamar.getText().isEmpty() || hargaKamar.getText().isEmpty() || kelasKamar.getText().isEmpty() || fasilitasKamar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Mohon Lengkapi Kolom Isian !", 
                    "Error !", JOptionPane.WARNING_MESSAGE);    
            } else {
                kelas = kelasKamar.getText();
                switch (kelas) {
                    case "A":
                            kamarA_kosong += 1;
                        break;
                    case "B":
                            kamarB_kosong += 1;
                        break;
                    case "C":
                        kamarC_kosong += 1;
                        break;
                    default:
                        break;
                }
                simpan_data_kamar();
                kosongkan_input();
                tampil_data_kamar();
                updateDataLaporan();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Kamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void hargaKamarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKamarKeyTyped
        // TODO add your handling code here:
        char c =evt.getKeyChar();
        if ( c != KeyEvent.VK_ENTER ) {
            if (! ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Masukkan hanya angka 0-9 !");
                evt.consume();
            }
        }
    }//GEN-LAST:event_hargaKamarKeyTyped

    private void kelasKamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kelasKamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if( kelasKamar.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error: Kelas Kamar Tidak Boleh Kosong !",
                    "Error !", JOptionPane.WARNING_MESSAGE);
            } else {
                fasilitasKamar.requestFocus();
            }
        }
    }//GEN-LAST:event_kelasKamarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Kamar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Kamar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField fasilitasKamar;
    private javax.swing.JTextField hargaKamar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judulCheckin;
    private javax.swing.JLabel judulCheckin1;
    private javax.swing.JTextField kelasKamar;
    private javax.swing.JTextField kodeKamar;
    private javax.swing.JTextField namaKamar;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelTamu;
    private javax.swing.JComboBox<String> posisiKamar;
    private javax.swing.JTable tableDataKamar;
    // End of variables declaration//GEN-END:variables
}

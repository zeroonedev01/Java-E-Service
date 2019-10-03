/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import configs.functions;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zeref
 */
public class DataService extends javax.swing.JInternalFrame {

    functions f = new functions();

    private void tampil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tanggal masuk");
        model.addColumn("Status");
        model.addColumn("Id Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Id Item");
        model.addColumn("Merk");
        model.addColumn("Jenis");
        
        try {
            String cari =this.cari.getText();
            String basicQuery = "SELECT service.id, service.tgl_masuk,service.status,service.id_pelanggan, pelanggan.nama,item.id as id_item,item.merk,jenis.name as jenis FROM `item` INNER join service on item.id_service = service.id INNER join jenis on item.id_jenis = jenis.id INNER JOIN pelanggan on pelanggan.id = service.id_pelanggan where 1";
            if (r_diambil.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and service.status = 'diambil' and pelanggan.nama like '%" + cari + "%' or item.merk like '%" + cari + "%' or jenis.name like '%" + cari + "%'");
                } else {
                    f.select(basicQuery + " and service.status = 'diambil'");

                }
            } else if (r_diproses.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and service.status = 'diproses' and pelanggan.nama like '%" + cari + "%' or item.merk like '%" + cari + "%' or jenis.name like '%" + cari + "%'");
                } else {
                    f.select(basicQuery + " and service.status = 'diproses'");

                }
            } else if (r_diterima.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and service.status = 'diterima' and pelanggan.nama like '%" + cari + "%' or item.merk like '%" + cari + "%' or jenis.name like '%" + cari + "%'");
                } else {
                    f.select(basicQuery + " and service.status = 'diterima'");

                }
            } else if (r_selesai.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and service.status = 'selesai' and pelanggan.nama like '%" + cari + "%' or item.merk like '%" + cari + "%' or jenis.name like '%" + cari + "%'");
                } else {
                    f.select(basicQuery + " and service.status = 'selesai'");

                }
            } else {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and pelanggan.nama like '%" + cari + "%' or item.merk like '%" + cari + "%' or jenis.name like '%" + cari + "%'");
                } else {
                    f.select(basicQuery);

                }

            }

            int no = 1;
            while (f.rs.next()) {
                model.addRow(new Object[]{
                    f.rs.getString("id"),
                    f.rs.getString("tgl_masuk"),
                    f.rs.getString("status"),
                    f.rs.getString("id_pelanggan"),
                    f.rs.getString("nama"),
                    f.rs.getString("id_item"),
                    f.rs.getString("merk"),
                    f.rs.getString("jenis"),});

            }
            tabel.setModel(model);
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    /**
     * Creates new form DataService
     */
    public DataService() {
        initComponents();
        r_all.setSelected(true);
        tampil();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        datetoday = new javax.swing.JLabel();
        b_refresh = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        r_selesai = new javax.swing.JRadioButton();
        r_diterima = new javax.swing.JRadioButton();
        r_diproses = new javax.swing.JRadioButton();
        r_diambil = new javax.swing.JRadioButton();
        r_all = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        show = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Service");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabel);

        datetoday.setText("jLabel2");

        b_refresh.setText("Refresh");
        b_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_refreshActionPerformed(evt);
            }
        });

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));

        buttonGroup1.add(r_selesai);
        r_selesai.setText("Selesai");

        buttonGroup1.add(r_diterima);
        r_diterima.setText("Diterima");
        r_diterima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                r_diterimaItemStateChanged(evt);
            }
        });

        buttonGroup1.add(r_diproses);
        r_diproses.setText("Diproses");

        buttonGroup1.add(r_diambil);
        r_diambil.setText("Diambil");

        buttonGroup1.add(r_all);
        r_all.setText("All");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(r_diterima)
                .addGap(18, 18, 18)
                .addComponent(r_diproses)
                .addGap(18, 18, 18)
                .addComponent(r_selesai)
                .addGap(18, 18, 18)
                .addComponent(r_diambil)
                .addGap(18, 18, 18)
                .addComponent(r_all)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_diterima)
                    .addComponent(r_diproses)
                    .addComponent(r_selesai)
                    .addComponent(r_diambil)
                    .addComponent(r_all))
                .addContainerGap())
        );

        jLabel2.setText("Cari");

        show.setText("show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(datetoday)
                .addGap(150, 150, 150)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(show)
                .addGap(39, 39, 39)
                .addComponent(b_refresh)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(b_refresh)
                                .addComponent(show))
                            .addComponent(datetoday, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Service");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_refreshActionPerformed
        tampil();        // TODO add your handling code here:
    }//GEN-LAST:event_b_refreshActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        tampil();        // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyReleased

    private void r_diterimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_r_diterimaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_r_diterimaItemStateChanged

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        tampil();        // TODO add your handling code here:
    }//GEN-LAST:event_showActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_refresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel datetoday;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r_all;
    private javax.swing.JRadioButton r_diambil;
    private javax.swing.JRadioButton r_diproses;
    private javax.swing.JRadioButton r_diterima;
    private javax.swing.JRadioButton r_selesai;
    private javax.swing.JButton show;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}

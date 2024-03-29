/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import configs.functions;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Login1;

/**
 * Touch me https://github.com/tejojr 
 * @author Zeref
 */
public class User extends javax.swing.JInternalFrame {

    functions f = new functions();
    String id;

    private void tampil(String cari) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("no");
        model.addColumn("ID");
        model.addColumn("name");
        model.addColumn("username");
        model.addColumn("Password");
        model.addColumn("level");
        try {
            if (cari != null) {
                f.select("select * from admin where name like '%" + cari + "%' or username like '%" + cari + "%' or role like '%" + cari + "%'");
            } else {
                f.select("select * from admin ");
            }
            int no = 1;
            while (f.rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    f.rs.getString("id"),
                    f.rs.getString("name"),
                    f.rs.getString("username"),
                    f.rs.getString("password"),
                    f.rs.getString("role")

                });

            }
            tabel.setModel(model);
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void mati() {
        t_nama.setEnabled(false);
        t_uname.setEnabled(false);
        t_pass.setEnabled(false);
        simpan.setEnabled(false);
        cancel.setEnabled(false);
        cmb_level.setEnabled(false);
        tambah.setEnabled(true);
        update.setEnabled(true);
        delete.setEnabled(true);
    }

    public void aktif() {
        t_nama.setEnabled(true);
        t_uname.setEnabled(true);
        t_pass.setEnabled(true);
        cmb_level.setEnabled(true);
        t_nama.requestFocus();
        tambah.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
    }

    private void clear() {
        t_nama.setText("");
        t_uname.setText("");
        t_pass.setText("");
        cmb_level.setSelectedItem("admin");

    }

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        tampil("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t_pass = new javax.swing.JTextField();
        t_nama = new javax.swing.JTextField();
        t_uname = new javax.swing.JTextField();
        cmb_level = new javax.swing.JComboBox<>();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manage User");

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form User");

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

        jPanel2.setBackground(java.awt.Color.white);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel2.setText("Nama :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel3.setText("Username :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel4.setText("Password :");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel6.setText("Level :");

        t_pass.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        t_pass.setEnabled(false);

        t_nama.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        t_nama.setEnabled(false);

        t_uname.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        t_uname.setEnabled(false);

        cmb_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        cmb_level.setEnabled(false);

        tambah.setText("Add");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        simpan.setText("Save");
        simpan.setEnabled(false);
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cari.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel7.setText("Cari :");

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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tambah)
                                .addGap(18, 18, 18)
                                .addComponent(simpan)
                                .addGap(18, 18, 18)
                                .addComponent(update))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t_pass)
                            .addComponent(t_uname)
                            .addComponent(cmb_level, 0, 200, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(t_uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmb_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambah)
                            .addComponent(simpan)
                            .addComponent(update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(cancel))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        aktif();
        simpan.setEnabled(true);
        cancel.setEnabled(true);
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed

        f.cud("INSERT into admin value (null,'" + t_nama.getText() + "','" + t_uname.getText() + "',md5('" + t_pass.getText() + "'),'" + cmb_level.getSelectedItem() + "')", "Data dengan Nama '" + t_nama.getText() + "' berhasil ditambahkan");
        clear();
        tampil("");
        mati();// TODO add your handling code here:
    }//GEN-LAST:event_simpanActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (t_nama.getText().isEmpty() == false) {
            f.cud("update admin set name = '" + t_nama.getText() + "', username = '" + t_uname.getText() + "', password=md5('" + t_pass.getText() + "'), role = '" + cmb_level.getSelectedItem() + "' where id = '" + id + "'", "Data dengan id '" + id + "' berhasil diubah");
            clear();
            tampil("");
            mati();
        } else {
            JOptionPane.showMessageDialog(null, "Poloh data yang akan di Edit");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        mati();
        clear();// TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (t_nama.getText().isEmpty() == false) {
            int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus", "Hapus", JOptionPane.YES_NO_OPTION);

            if (konfirmasi == 0) {
                if (!Login1.id.equals(id)) {
                    f.cud("delete from admin where id='" + id + "'", "Data dengan id '" + id + "' berhasil dihapus");
                    clear();
                    tampil("");
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak diperbolehkan menghapus akun yang sedang aktif");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Poloh data yang akan di hapus");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        tampil(cari.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyReleased

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        id = tabel.getModel().getValueAt(row, 1).toString();
        String nama = tabel.getModel().getValueAt(row, 2).toString();
        String username = tabel.getModel().getValueAt(row, 3).toString();
        String password = tabel.getModel().getValueAt(row, 4).toString();
        Object level = tabel.getModel().getValueAt(row, 5).toString();
        t_nama.setText(nama);
        t_uname.setText(username);
        t_pass.setText(password);
        cmb_level.setSelectedItem(level);
        aktif();
        update.setEnabled(true);
        delete.setEnabled(true);
        tambah.setEnabled(true);
        simpan.setEnabled(false);
        cancel.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cmb_level;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_pass;
    private javax.swing.JTextField t_uname;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}

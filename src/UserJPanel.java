
import equipmentrent.ConnDB;
import equipmentrent.User;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Salman
 */
public class UserJPanel extends javax.swing.JPanel {

    User user;

    /**
     * Creates new form UserJPanel
     */
    public UserJPanel(User pasedUser) {
        initComponents();
        user = pasedUser;
       if(user.level <5){
           addEquepmentButton.setVisible(false);
           addUserButton.setVisible(false);
        }
        if (user.equipments.length == 0) {
            returnButton.setEnabled(false);
        }
        if ((new ConnDB().getAvailableEquipment()) == null) {
            rentButton.setEnabled(false);
        }
        greatingLabel.setText(greatingLabel.getText() + user.name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rentButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        greatingLabel = new javax.swing.JLabel();
        addUserButton = new javax.swing.JButton();
        addEquepmentButton = new javax.swing.JButton();

        rentButton.setText("استعارة");
        rentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentButtonActionPerformed(evt);
            }
        });

        returnButton.setText("تسليم");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        greatingLabel.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        greatingLabel.setText("مرحبا : ");

        addUserButton.setText("اضافة مستخدم");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        addEquepmentButton.setText("اضافة كاميرا");
        addEquepmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEquepmentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(greatingLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 107, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addEquepmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greatingLabel)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addEquepmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentButtonActionPerformed
        JFrame mainFram = (JFrame) SwingUtilities.getWindowAncestor(this);

        mainFram.setContentPane(new RentJPanel(user));
        mainFram.invalidate();
        mainFram.validate();
    }//GEN-LAST:event_rentButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        JFrame mainFram = (JFrame) SwingUtilities.getWindowAncestor(this);

        mainFram.setContentPane(new ReturnJPanel(user));
        mainFram.invalidate();
        mainFram.validate();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void addEquepmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEquepmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEquepmentButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEquepmentButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JLabel greatingLabel;
    private javax.swing.JButton rentButton;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}

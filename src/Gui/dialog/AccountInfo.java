/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.dialog;

import Function.OpenForm;
import Gui.SignIn;
import Model.AccountModel;
import Object.Account;
import javax.swing.JOptionPane;

/**
 *
 * @author SunCho
 */
public class AccountInfo extends javax.swing.JDialog {
    
    private static Account account = null;
    
    /**
     * Creates new form AccountInfo
     * @param parent
     * @param modal
     * @param account
     */
    public AccountInfo(java.awt.Frame parent, boolean modal, Account account) {
        super(parent, modal);
        AccountInfo.account = account;
        
        initComponents();
        loadAccountInfo();
    }
    
    private void loadAccountInfo(){
        jLb_AccountId.setText(account.getId() + "");
        jLb_Fullname.setText(account.getFullName());
        jLb_Email.setText(account.getEmail());
        jLb_Mobile.setText(account.getMobile());
        jLb_Username.setText(account.getUsername());
        jTF_Password.setText(account.getPassword());
        jLb_Type.setText(account.getType());
        jLb_Date.setText(account.getCreated()+"");
        jLb_Status.setText(account.getStatus()==1 ? "Active" : account.getStatus()==2 ? "Pending" : "Deactive");
        jLb_Btn_Action.setText(account.getStatus()==1 ? "Deactive" : account.getStatus()==2 ? "Approval" : "Active");
        if(account.getStatus()==1){
            jLb_Btn_Action.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Important_20px.png")));
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

        jPanel = new javax.swing.JPanel();
        jLb_Close = new javax.swing.JLabel();
        jLb_AccountInfo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLb_AccountId = new javax.swing.JLabel();
        jLb_Username = new javax.swing.JLabel();
        jTF_Password = new javax.swing.JPasswordField();
        jLb_Type = new javax.swing.JLabel();
        jLb_Date = new javax.swing.JLabel();
        jLb_Status = new javax.swing.JLabel();
        jCb_ShowPassword = new javax.swing.JCheckBox();
        jLb_PersonInfo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLb_Fullname = new javax.swing.JLabel();
        jLb_Email = new javax.swing.JLabel();
        jLb_Mobile = new javax.swing.JLabel();
        jLb_Action = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel_Btn_Action = new javax.swing.JPanel();
        jLb_Btn_Action = new javax.swing.JLabel();
        jPanel_Btn_Delete = new javax.swing.JPanel();
        jLb_Btn_Delete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel.setBackground(new java.awt.Color(42, 150, 83));
        jPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(212, 212, 212)));

        jLb_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_20px.png"))); // NOI18N
        jLb_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_CloseMouseClicked(evt);
            }
        });

        jLb_AccountInfo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLb_AccountInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLb_AccountInfo.setText("Account Info");

        jSeparator1.setBackground(new java.awt.Color(42, 150, 83));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Account ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Create Date:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Status:");

        jLb_AccountId.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_AccountId.setForeground(new java.awt.Color(255, 255, 255));
        jLb_AccountId.setText("Null");

        jLb_Username.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Username.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Username.setText("Null");

        jTF_Password.setBackground(new java.awt.Color(42, 150, 83));
        jTF_Password.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTF_Password.setForeground(new java.awt.Color(255, 255, 255));
        jTF_Password.setText("jPasswor");
        jTF_Password.setBorder(null);
        jTF_Password.setCaretColor(new java.awt.Color(42, 150, 83));

        jLb_Type.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Type.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Type.setText("Null");

        jLb_Date.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Date.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Date.setText("Null");

        jLb_Status.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Status.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Status.setText("Null");

        jCb_ShowPassword.setBackground(new java.awt.Color(42, 150, 83));
        jCb_ShowPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCb_ShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        jCb_ShowPassword.setText(" Show password");
        jCb_ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCb_ShowPasswordActionPerformed(evt);
            }
        });

        jLb_PersonInfo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLb_PersonInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLb_PersonInfo.setText("Person Info");

        jSeparator2.setBackground(new java.awt.Color(42, 150, 83));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fullname:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Phone number:");

        jLb_Fullname.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Fullname.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Fullname.setText("Null");

        jLb_Email.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Email.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Email.setText("Null");

        jLb_Mobile.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Mobile.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Mobile.setText("Null");

        jLb_Action.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLb_Action.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Action.setText("Action");

        jSeparator3.setBackground(new java.awt.Color(42, 150, 83));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel_Btn_Action.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Btn_Action.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel_Btn_Action.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Btn_Action.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Btn_ActionMouseClicked(evt);
            }
        });

        jLb_Btn_Action.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLb_Btn_Action.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Btn_Action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Btn_Action.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Checked_20px.png"))); // NOI18N
        jLb_Btn_Action.setText("Active");

        javax.swing.GroupLayout jPanel_Btn_ActionLayout = new javax.swing.GroupLayout(jPanel_Btn_Action);
        jPanel_Btn_Action.setLayout(jPanel_Btn_ActionLayout);
        jPanel_Btn_ActionLayout.setHorizontalGroup(
            jPanel_Btn_ActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Btn_ActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLb_Btn_Action, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_Btn_ActionLayout.setVerticalGroup(
            jPanel_Btn_ActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Btn_ActionLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLb_Btn_Action)
                .addGap(5, 5, 5))
        );

        jPanel_Btn_Delete.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Btn_Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel_Btn_Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Btn_Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Btn_DeleteMouseClicked(evt);
            }
        });

        jLb_Btn_Delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLb_Btn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Btn_Delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Unavailable_20px.png"))); // NOI18N
        jLb_Btn_Delete.setText("Delete");

        javax.swing.GroupLayout jPanel_Btn_DeleteLayout = new javax.swing.GroupLayout(jPanel_Btn_Delete);
        jPanel_Btn_Delete.setLayout(jPanel_Btn_DeleteLayout);
        jPanel_Btn_DeleteLayout.setHorizontalGroup(
            jPanel_Btn_DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Btn_DeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLb_Btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_Btn_DeleteLayout.setVerticalGroup(
            jPanel_Btn_DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Btn_DeleteLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLb_Btn_Delete)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(jLb_Action)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(jLb_PersonInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(jLb_AccountInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(jPanel_Btn_Action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel_Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(53, 53, 53)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLb_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jTF_Password)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6)
                                .addGap(72, 72, 72)))
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLb_Status, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLb_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1)
                                .addGap(46, 46, 46)
                                .addComponent(jLb_AccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel4)
                                .addGap(80, 80, 80)
                                .addComponent(jLb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(jCb_ShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel7)
                                .addGap(60, 60, 60)
                                .addComponent(jLb_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel8)
                                .addGap(83, 83, 83)
                                .addComponent(jLb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel9)
                                .addGap(24, 24, 24)
                                .addComponent(jLb_Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLb_Close)
                .addGap(8, 8, 8))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLb_Close)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_AccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLb_Type)
                    .addComponent(jLabel1)
                    .addComponent(jLb_AccountId))
                .addGap(12, 12, 12)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLb_Username)
                    .addComponent(jLabel5)
                    .addComponent(jLb_Date))
                .addGap(12, 12, 12)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLb_Status))
                .addGap(20, 20, 20)
                .addComponent(jCb_ShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_PersonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLb_Fullname))
                .addGap(12, 12, 12)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLb_Email))
                .addGap(12, 12, 12)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLb_Mobile))
                .addGap(20, 20, 20)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_Action, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_Btn_Action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLb_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_CloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLb_CloseMouseClicked

    private void jCb_ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCb_ShowPasswordActionPerformed
        if (jCb_ShowPassword.isSelected()) {
            jTF_Password.setEchoChar((char) 0);
        } else {
            jTF_Password.setEchoChar('*');
        }
    }//GEN-LAST:event_jCb_ShowPasswordActionPerformed

    private void jPanel_Btn_ActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Btn_ActionMouseClicked
        int accountId = account.getId();
        int status = account.getStatus();
        boolean isCheck = false;
        AccountModel am = new AccountModel();
        if(status == 1){
            isCheck = am.updateStatusAccount(accountId, 0);
        }else{
            isCheck = am.updateStatusAccount(accountId, 1);
        }                   
        if(isCheck){
            this.dispose();
        }
    }//GEN-LAST:event_jPanel_Btn_ActionMouseClicked

    private void jPanel_Btn_DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Btn_DeleteMouseClicked
        int i = JOptionPane.showConfirmDialog(null, "Do you want delete account?", " Notification",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
            new javax.swing.ImageIcon(getClass().getResource("/Images/Help_40px.png")));
        
        switch (i) {
            case 0:
                int accountId = account.getId();
                boolean isCheck = false;
                AccountModel am = new AccountModel();
                isCheck = am.deleteAccount(accountId);
                if(isCheck){
                    this.dispose();
                }   break;
            case 1:
                this.dispose();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jPanel_Btn_DeleteMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        if(account == null){
            SignIn signin = new SignIn();
            OpenForm.Open(signin);
        }else{
            java.awt.EventQueue.invokeLater(() -> {
                AccountInfo dialog = new AccountInfo(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCb_ShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLb_AccountId;
    private javax.swing.JLabel jLb_AccountInfo;
    private javax.swing.JLabel jLb_Action;
    private javax.swing.JLabel jLb_Btn_Action;
    private javax.swing.JLabel jLb_Btn_Delete;
    private javax.swing.JLabel jLb_Close;
    private javax.swing.JLabel jLb_Date;
    private javax.swing.JLabel jLb_Email;
    private javax.swing.JLabel jLb_Fullname;
    private javax.swing.JLabel jLb_Mobile;
    private javax.swing.JLabel jLb_PersonInfo;
    private javax.swing.JLabel jLb_Status;
    private javax.swing.JLabel jLb_Type;
    private javax.swing.JLabel jLb_Username;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel_Btn_Action;
    private javax.swing.JPanel jPanel_Btn_Delete;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField jTF_Password;
    // End of variables declaration//GEN-END:variables
}

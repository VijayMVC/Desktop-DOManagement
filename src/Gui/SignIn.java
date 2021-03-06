/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Function.DragListener;
import Function.OpenForm;
import Model.AccountModel;
import Object.Account;
import java.awt.Toolkit;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SunCho
 */
public class SignIn extends javax.swing.JFrame {

    /**
     * Creates new form Singin
     */
    public SignIn() {
        initComponents();
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon_24px.png")));
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
        jPanel_form = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        jLb_Notification = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        border_bottom_password = new javax.swing.JSeparator();
        password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        border_bottom_username = new javax.swing.JSeparator();
        remember_me = new javax.swing.JRadioButton();
        btn_signin = new javax.swing.JPanel();
        signin = new javax.swing.JLabel();
        jLb_forgot_password = new javax.swing.JLabel();
        jLb_register = new javax.swing.JLabel();
        jPanel_img = new javax.swing.JPanel();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(42, 150, 83));
        setMinimumSize(new java.awt.Dimension(760, 500));
        setName("JFrame_Signin"); // NOI18N
        setUndecorated(true);

        jPanel.setBackground(new java.awt.Color(42, 150, 83));

        jPanel_form.setBackground(new java.awt.Color(42, 150, 83));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_20px.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        welcome.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setText("WELCOME BACK!");

        jLb_Notification.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLb_Notification.setForeground(new java.awt.Color(153, 255, 255));
        jLb_Notification.setText(" ");

        username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User_18px.png"))); // NOI18N
        username.setText("Username");

        txt_username.setBackground(new java.awt.Color(42, 150, 83));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(null);
        txt_username.setCaretColor(new java.awt.Color(255, 255, 255));

        border_bottom_password.setBackground(new java.awt.Color(42, 150, 83));
        border_bottom_password.setForeground(new java.awt.Color(255, 255, 255));

        password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Password_16px.png"))); // NOI18N
        password.setText("Password");

        txt_password.setBackground(new java.awt.Color(42, 150, 83));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.setCaretColor(new java.awt.Color(255, 255, 255));

        border_bottom_username.setBackground(new java.awt.Color(42, 150, 83));
        border_bottom_username.setForeground(new java.awt.Color(255, 255, 255));

        remember_me.setBackground(new java.awt.Color(42, 150, 83));
        remember_me.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        remember_me.setForeground(new java.awt.Color(255, 255, 255));
        remember_me.setText(" Remember Me");
        remember_me.setAlignmentY(0.0F);
        remember_me.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_signin.setBackground(new java.awt.Color(42, 150, 83));
        btn_signin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_signin.setAlignmentX(0.2F);
        btn_signin.setAlignmentY(0.2F);
        btn_signin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_signinMouseClicked(evt);
            }
        });

        signin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        signin.setForeground(new java.awt.Color(255, 255, 255));
        signin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Login_24px.png"))); // NOI18N
        signin.setText(" Sign In");

        javax.swing.GroupLayout btn_signinLayout = new javax.swing.GroupLayout(btn_signin);
        btn_signin.setLayout(btn_signinLayout);
        btn_signinLayout.setHorizontalGroup(
            btn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_signinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(signin)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        btn_signinLayout.setVerticalGroup(
            btn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_signinLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(signin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jLb_forgot_password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLb_forgot_password.setForeground(new java.awt.Color(255, 255, 255));
        jLb_forgot_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lock_16px.png"))); // NOI18N
        jLb_forgot_password.setText("Forgot password");
        jLb_forgot_password.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_forgot_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_forgot_passwordMouseClicked(evt);
            }
        });

        jLb_register.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLb_register.setForeground(new java.awt.Color(255, 255, 255));
        jLb_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Register_18px.png"))); // NOI18N
        jLb_register.setText("Register");
        jLb_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_registerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_formLayout = new javax.swing.GroupLayout(jPanel_form);
        jPanel_form.setLayout(jPanel_formLayout);
        jPanel_formLayout.setHorizontalGroup(
            jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_formLayout.createSequentialGroup()
                .addGroup(jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(border_bottom_username, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(border_bottom_password, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(remember_me, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btn_signin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLb_forgot_password))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLb_register))
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLb_Notification, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_formLayout.createSequentialGroup()
                .addComponent(close)
                .addGap(6, 6, 6))
        );
        jPanel_formLayout.setVerticalGroup(
            jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_formLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(close)
                .addGap(50, 50, 50)
                .addComponent(welcome)
                .addGap(10, 10, 10)
                .addComponent(jLb_Notification)
                .addGap(25, 25, 25)
                .addComponent(username)
                .addGap(10, 10, 10)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(border_bottom_username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(password)
                .addGap(12, 12, 12)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(border_bottom_password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remember_me)
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_signin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLb_forgot_password)
                .addGap(16, 16, 16)
                .addComponent(jLb_register))
        );

        jPanel_img.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CoverImg.png"))); // NOI18N
        jPanel_img.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 396, 500));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addComponent(jPanel_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void btn_signinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_signinMouseClicked
        String username = txt_username.getText();
        String password = txt_password.getText();

        //JOptionPane.showMessageDialog(null, "Wrong Username or Password.");
        AccountModel am = new AccountModel();
        Account acc = am.login(username, password);
        if (acc == null) {
            jLb_Notification.setText("Sai tài khoản hoặc mật khẩu!");
        } else if (acc.getStatus() != 1) {
            jLb_Notification.setText("Tài khoản chưa kích hoạt!");
        } else if (acc.getType().equalsIgnoreCase("student")) {
            jLb_Notification.setText("Bạn không có quyền truy cập!");
        } else {
            Home home = new Home(acc);
            OpenForm.Open(home);
            this.dispose();
        }
    }//GEN-LAST:event_btn_signinMouseClicked

    private void jLb_registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_registerMouseClicked
        OpenForm.Open(new SignUp());
        this.dispose();
    }//GEN-LAST:event_jLb_registerMouseClicked

    private void jLb_forgot_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_forgot_passwordMouseClicked
        OpenForm.Open(new ResetPassword());
        this.dispose();
    }//GEN-LAST:event_jLb_forgot_passwordMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }

        SignIn g = new SignIn();
        
        DragListener drag = new DragListener();
        g.addMouseListener(drag);
        g.addMouseMotionListener(drag);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            g.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator border_bottom_password;
    private javax.swing.JSeparator border_bottom_username;
    private javax.swing.JPanel btn_signin;
    private javax.swing.JLabel close;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLb_Notification;
    private javax.swing.JLabel jLb_forgot_password;
    private javax.swing.JLabel jLb_register;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel_form;
    private javax.swing.JPanel jPanel_img;
    private javax.swing.JLabel password;
    private javax.swing.JRadioButton remember_me;
    private javax.swing.JLabel signin;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    private javax.swing.JLabel username;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}

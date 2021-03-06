/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Function.AutoSentEmail;
import Function.CreatePassword;
import Function.DragListener;
import Function.OpenForm;
import Function.SetEmailContent;
import Model.AccountModel;
import Model.EmailInfoModel;
import Model.StudentModel;
import Object.Account;
import Object.EmailInfo;
import Object.Student;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SunCho
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form Singin
     */
    public SignUp() {
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
        email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        border_bottom_email = new javax.swing.JSeparator();
        btn_signup = new javax.swing.JPanel();
        signin = new javax.swing.JLabel();
        jLb_SignIn = new javax.swing.JLabel();
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
        welcome.setText("WELCOME !");

        jLb_Notification.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLb_Notification.setForeground(new java.awt.Color(153, 255, 255));
        jLb_Notification.setText(" ");

        email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Message_20px.png"))); // NOI18N
        email.setText("Email");

        txt_email.setBackground(new java.awt.Color(42, 150, 83));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setBorder(null);
        txt_email.setCaretColor(new java.awt.Color(255, 255, 255));

        border_bottom_email.setBackground(new java.awt.Color(42, 150, 83));
        border_bottom_email.setForeground(new java.awt.Color(255, 255, 255));

        btn_signup.setBackground(new java.awt.Color(42, 150, 83));
        btn_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_signup.setAlignmentX(0.2F);
        btn_signup.setAlignmentY(0.2F);
        btn_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_signupMouseClicked(evt);
            }
        });

        signin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        signin.setForeground(new java.awt.Color(255, 255, 255));
        signin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Login_24px.png"))); // NOI18N
        signin.setText(" Sign Up");

        javax.swing.GroupLayout btn_signupLayout = new javax.swing.GroupLayout(btn_signup);
        btn_signup.setLayout(btn_signupLayout);
        btn_signupLayout.setHorizontalGroup(
            btn_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_signupLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(signin)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        btn_signupLayout.setVerticalGroup(
            btn_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_signupLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(signin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jLb_SignIn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLb_SignIn.setForeground(new java.awt.Color(255, 255, 255));
        jLb_SignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login_20px.png"))); // NOI18N
        jLb_SignIn.setText("Sign In");
        jLb_SignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_SignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_SignInMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_formLayout = new javax.swing.GroupLayout(jPanel_form);
        jPanel_form.setLayout(jPanel_formLayout);
        jPanel_formLayout.setHorizontalGroup(
            jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_formLayout.createSequentialGroup()
                .addGroup(jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(border_bottom_email, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_formLayout.createSequentialGroup()
                                .addComponent(jLb_SignIn)
                                .addGap(75, 75, 75)
                                .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLb_Notification, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_formLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(close)))
                .addGap(6, 6, 6))
        );
        jPanel_formLayout.setVerticalGroup(
            jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_formLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(close)
                .addGap(50, 50, 50)
                .addComponent(welcome)
                .addGap(15, 15, 15)
                .addComponent(jLb_Notification)
                .addGap(65, 65, 65)
                .addComponent(email)
                .addGap(10, 10, 10)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(border_bottom_email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_formLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLb_SignIn))
                    .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void btn_signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_signupMouseClicked
        String toEmail = txt_email.getText();
        jLb_Notification.setText("Đang xử lý...");
        
        AccountModel am = new AccountModel();
        if (am.getOneAccountByEmail(toEmail) != null) {
            jLb_Notification.setText("Email đã tồn tại");
        } else {
            Student student = new StudentModel().getStudentsByEmail(toEmail);
            if (student != null) {
                Account acc = new Account();
                acc.setFullName(student.getFullName());
                acc.setEmail(student.getEmail());
                acc.setMobile(student.getMobile());
                String[] temp = student.getEmail().split("@");
                acc.setUsername(temp[0]);
                String password = CreatePassword.randomPassword(8);
                acc.setPassword(password);
                acc.setType("student");
                acc.setStatus(2);
                if (am.addAccount(acc)) {
                    jLb_Notification.setText("Tài khoản đã được tạo, đợi xét duyệt từ quản trị viên");
                    List<EmailInfo> list = new EmailInfoModel().getAllEmail();
                    for(EmailInfo ei : list){
                        if(ei.getRule().equals("system")){
                            new AutoSentEmail().sentEmail(ei.getEmail(), ei.getPassword(), toEmail, "Welcome to DOManagement System", new SetEmailContent().emailContent(acc, password, ei.getEmail()));
                            break;
                        }
                    }
                } else {
                    jLb_Notification.setText("Có lỗi xảy ra, vui lòng thử lại");
                }
            }else{
                jLb_Notification.setText("Chỉ sử dụng email FPT Univversity");
            }
        }
    }//GEN-LAST:event_btn_signupMouseClicked

    private void jLb_SignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_SignInMouseClicked
        OpenForm.Open(new SignIn());
        this.dispose();
    }//GEN-LAST:event_jLb_SignInMouseClicked

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

        SignUp g = new SignUp();
        DragListener drag = new DragListener();
        g.addMouseListener(drag);
        g.addMouseMotionListener(drag);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            g.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator border_bottom_email;
    private javax.swing.JPanel btn_signup;
    private javax.swing.JLabel close;
    private javax.swing.JLabel email;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLb_Notification;
    private javax.swing.JLabel jLb_SignIn;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel_form;
    private javax.swing.JPanel jPanel_img;
    private javax.swing.JLabel signin;
    private javax.swing.JTextField txt_email;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}

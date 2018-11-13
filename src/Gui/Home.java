/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.dialog.RoomInfo;
import Gui.dialog.ReportAction;
import Gui.dialog.AccountInfo;
import Gui.dialog.About;
import Function.AccountController;
import Function.RoomController;
import Function.StudentController;
import Function.DragListener;
import Function.EmailInfoController;
import Function.ExportToExcel;
import Function.OpenForm;
import Function.ReportController;
import Model.AccountModel;
import Model.DomModel;
import Model.EmailContentModel;
import Model.EmailInfoModel;
import Model.JoinTableModel;
import Model.RoomModel;
import Model.StudentModel;
import Model.TransferRoomModel;
import Object.Account;
import Object.Dom;
import Object.EmailInfo;
import Object.Room;
import Object.Student;
import Object.StudentJoinRoom;
import Object.TransferRoom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;

/**
 *
 * @author SunCho
 */
public class Home extends javax.swing.JFrame {
    
    public static Account acc = null;
    
    AccountModel am = new AccountModel();
    JoinTableModel fm = new JoinTableModel();
    StudentModel sm = new StudentModel();
    RoomModel rm = new RoomModel();
    DomModel dm = new DomModel();
    TransferRoomModel trm = new TransferRoomModel();
    EmailInfoModel eim = new EmailInfoModel();
    EmailContentModel ecm = new EmailContentModel();
    
    AccountController ac = new AccountController();
    StudentController sc = new StudentController();
    RoomController rc = new RoomController();
    ReportController rec = new ReportController();
    EmailInfoController eic = new EmailInfoController();
    
    List<Account> listAccounts = am.getAllAccount();
    List<StudentJoinRoom> listStudents = fm.getAllStudentJoinRoom();
    List<Dom> listDom = new ArrayList();
    List<Room> listRoom = new ArrayList();
    List<TransferRoom> listTransferRoom = new ArrayList();
    List<EmailInfo> listEmail = new ArrayList();
    
    String totalStudents = sm.countTotalStudent() + "";
    String totalRoom = rm.countTotalRoom() + "";
    String totalFreeSlot = rm.countFreeSlot() + "";
    String totalReport = trm.countTotalApplicationFalse() + "";
    
    String sampleContent = "Dear [username],\n\n"
                + "Enter content here...\n\n"
                + "Thanks!\n"
                + "Phòng quản lý Ký Túc Xá - FPT Hòa Lạc.";

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        initHome();
        setIcon();
        setStyleTable();
        loadDashboard();
        
        jTF_Username.setEditable(false);
        jTF_Username.setBackground(new Color(255, 255, 255));
    }
    
    public Home(Account acc) {
        initComponents();
        initHome();
        setIcon();
        setStyleTable();
        loadDashboard();
        Home.acc = acc;
        jLb_Fullname.setText(Home.acc.getFullName());
        jLb_Role.setText(Home.acc.getType().toUpperCase());
        
        jTF_Username.setEditable(false);
        jTF_Username.setBackground(new Color(255, 255, 255));
        
        if (acc.getType().equalsIgnoreCase("staff")) {
            jPanel_Menu_AddAccount.setVisible(false);
            jPanel_Menu_Setting.setVisible(false);
        }
    }
    
    private void initHome() {
        jPanel_Content_Dashboard.setVisible(true);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(false);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(false);
        
        setBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        resetBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
    }
    
    private void setStyleTable() {
        Font f = new Font("Segoe UI", Font.PLAIN, 13);
        jTable_ListAccounts.getTableHeader().setFont(f);
        jTable_ListStudents.getTableHeader().setFont(f);
        jTable_ListRooms.getTableHeader().setFont(f);
        jTable_ListReport.getTableHeader().setFont(f);
        jTable_ListEmail.getTableHeader().setFont(f);
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon_24px.png")));
    }
    
    private void setBtnColor(Component btn) {
        btn.setBackground(new Color(45, 180, 95));
    }
    
    private void resetBtnColor(Component btn) {
        btn.setBackground(new Color(42, 150, 83));
    }
    
    private void loadDashboard() {
        jLb_Number_Student.setText(totalStudents);
        jLb_Number_Room.setText(totalRoom);
        jLb_Number_Slot.setText(totalFreeSlot);
        jLb_Number_Report.setText(totalReport);
    }
    
//    private final ComponentListener dialogEvent = new ComponentListener() {
//        @Override
//        public void componentHidden(ComponentEvent e) {
//            JOptionPane.showMessageDialog(null, "HIDE");
//        }
//        
//        @Override
//        public void componentMoved(ComponentEvent e) {
//            System.out.println("dialog moved");
//        }
//        
//        @Override
//        public void componentResized(ComponentEvent e) {
//            System.out.println("dialog resized");
//        }
//        
//        @Override
//        public void componentShown(ComponentEvent e) {
//            System.out.println("dialog shown");
//        }
//    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_Role = new javax.swing.ButtonGroup();
        buttonGroup_Status = new javax.swing.ButtonGroup();
        buttonGroup_Email_Role = new javax.swing.ButtonGroup();
        jPanel_Home = new javax.swing.JPanel();
        jPanel_SlideBarMenu = new javax.swing.JPanel();
        jLb_Logo = new javax.swing.JLabel();
        jLb_SubLogo = new javax.swing.JLabel();
        jSeparator_LogoTop = new javax.swing.JSeparator();
        jLb_Avatar = new javax.swing.JLabel();
        jLb_Fullname = new javax.swing.JLabel();
        jLb_Role = new javax.swing.JLabel();
        jSeparator_LogoBot = new javax.swing.JSeparator();
        jPanel_Menu_Dashboard = new javax.swing.JPanel();
        jLb_Icon_1 = new javax.swing.JLabel();
        jLb_Text_1 = new javax.swing.JLabel();
        jPanel_Menu_Accounts = new javax.swing.JPanel();
        jLb_Icon_2 = new javax.swing.JLabel();
        jLb_Text_2 = new javax.swing.JLabel();
        jPanel_Menu_Students = new javax.swing.JPanel();
        jLb_Icon_3 = new javax.swing.JLabel();
        jLb_Text_3 = new javax.swing.JLabel();
        jPanel_Menu_RoomDom = new javax.swing.JPanel();
        jLb_Icon_4 = new javax.swing.JLabel();
        jLb_Text_4 = new javax.swing.JLabel();
        jPanel_Menu_Report = new javax.swing.JPanel();
        jLb_Icon_5 = new javax.swing.JLabel();
        jLb_Text_5 = new javax.swing.JLabel();
        jPanel_Menu_AddAccount = new javax.swing.JPanel();
        jLb_Icon_6 = new javax.swing.JLabel();
        jLb_Text_6 = new javax.swing.JLabel();
        jPanel_Menu_Setting = new javax.swing.JPanel();
        jLb_Icon_7 = new javax.swing.JLabel();
        jLb_Text_7 = new javax.swing.JLabel();
        jPanel_Menu_Logout = new javax.swing.JPanel();
        jLb_Icon_8 = new javax.swing.JLabel();
        jLb_Text_8 = new javax.swing.JLabel();
        jPanel_Right = new javax.swing.JPanel();
        jLb_About = new javax.swing.JLabel();
        jLb_BtnClose = new javax.swing.JLabel();
        jPanel_Title = new javax.swing.JPanel();
        jLb_Title = new javax.swing.JLabel();
        jPanel_Content_Dashboard = new javax.swing.JPanel();
        jPanel_TotalStudents = new javax.swing.JPanel();
        jLb_Icon2 = new javax.swing.JLabel();
        jLb_Number_Student = new javax.swing.JLabel();
        jLb_Description_Student = new javax.swing.JLabel();
        jPanel_TotalRoom = new javax.swing.JPanel();
        jLb_Icon3 = new javax.swing.JLabel();
        jLb_Number_Room = new javax.swing.JLabel();
        jLb_Description_Room = new javax.swing.JLabel();
        jPanel_TotalSlot = new javax.swing.JPanel();
        jLb_Icon4 = new javax.swing.JLabel();
        jLb_Number_Slot = new javax.swing.JLabel();
        jLb_Description_Slot = new javax.swing.JLabel();
        jPanel_TotalReport = new javax.swing.JPanel();
        jLb_Icon1 = new javax.swing.JLabel();
        jLb_Number_Report = new javax.swing.JLabel();
        jLb_Description_Report = new javax.swing.JLabel();
        jPanel_Content_Accounts = new javax.swing.JPanel();
        jLb_ListAccounts = new javax.swing.JLabel();
        jLb_TotalActive = new javax.swing.JLabel();
        jLb_TotalDeactive = new javax.swing.JLabel();
        jLb_TotalPending = new javax.swing.JLabel();
        jLb_TotalAccounts = new javax.swing.JLabel();
        jLb_TotalAdmin = new javax.swing.JLabel();
        jLb_TotalStaff = new javax.swing.JLabel();
        jLb_TotalStudentsRole = new javax.swing.JLabel();
        jLb_ListAccountsRefresh = new javax.swing.JLabel();
        jScrollPane_Accounts = new javax.swing.JScrollPane();
        jTable_ListAccounts = new javax.swing.JTable();
        jTF_SearchAccount = new javax.swing.JTextField();
        jComboBox_FitterAccount = new javax.swing.JComboBox<>();
        jBtn_SearchAccount = new javax.swing.JButton();
        jPanel_Content_Students = new javax.swing.JPanel();
        jLb_ListStudents = new javax.swing.JLabel();
        jLb_TotalStudents = new javax.swing.JLabel();
        jLb_TotalMale = new javax.swing.JLabel();
        jLb_TotalFemale = new javax.swing.JLabel();
        jLb_ListStudentsRefresh = new javax.swing.JLabel();
        jScrollPane_Students = new javax.swing.JScrollPane();
        jTable_ListStudents = new javax.swing.JTable();
        jTF_SearchStudent = new javax.swing.JTextField();
        jComboBox_FitterStudent = new javax.swing.JComboBox<>();
        jBtn_SearchStudent = new javax.swing.JButton();
        jPanel_Content_DomRoom = new javax.swing.JPanel();
        jLb_ListDomSelect = new javax.swing.JLabel();
        jCb_Dom = new javax.swing.JComboBox<>();
        jBtn_SearchDom = new javax.swing.JButton();
        jLb_DescriptionRoom = new javax.swing.JLabel();
        jPanel_ListRooms = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListRooms = new javax.swing.JTable();
        jLb_RoomStatus = new javax.swing.JLabel();
        jLb_TotalRoom = new javax.swing.JLabel();
        jLb_TotalRoomActive = new javax.swing.JLabel();
        jLb_TotalRoomMaintenance = new javax.swing.JLabel();
        jLb_TotalRoomDeactive = new javax.swing.JLabel();
        jLb_ListRoom = new javax.swing.JLabel();
        jLb_ExportToExcelListRoom = new javax.swing.JLabel();
        jLb_RefreshListRoom = new javax.swing.JLabel();
        jPanel_Content_Report = new javax.swing.JPanel();
        jLb_ListReportSelect = new javax.swing.JLabel();
        jCb_Report = new javax.swing.JComboBox<>();
        jBtn_SearchReport = new javax.swing.JButton();
        jLb_DescriptionReport = new javax.swing.JLabel();
        jPanel_ListReport = new javax.swing.JPanel();
        jLb_ListReport = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_ListReport = new javax.swing.JTable();
        jLb_ListReportRefresh = new javax.swing.JLabel();
        jPanel_Content_AddAccount = new javax.swing.JPanel();
        jLb_AddNewAccount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTF_Fullname = new javax.swing.JTextField();
        jTF_Email = new javax.swing.JTextField();
        jTF_PhoneNumber = new javax.swing.JTextField();
        jTF_Username = new javax.swing.JTextField();
        jTF_Password = new javax.swing.JPasswordField();
        jTF_PasswordCf = new javax.swing.JPasswordField();
        jRb_Admin = new javax.swing.JRadioButton();
        jRb_Director = new javax.swing.JRadioButton();
        jRb_Active = new javax.swing.JRadioButton();
        jRb_Deactive = new javax.swing.JRadioButton();
        jBt_Submit = new javax.swing.JButton();
        jLb_Notofication = new javax.swing.JLabel();
        jBtn_Clear = new javax.swing.JButton();
        jBtn_GetUsername = new javax.swing.JButton();
        jCb_Showpass = new javax.swing.JCheckBox();
        jPanel_Content_Setting = new javax.swing.JPanel();
        jLb_Setting = new javax.swing.JLabel();
        jLb_Email_Infor = new javax.swing.JLabel();
        jLb_Email = new javax.swing.JLabel();
        jTF_EmailSetting = new javax.swing.JTextField();
        jLb_Password = new javax.swing.JLabel();
        jPF_EmailPassword = new javax.swing.JPasswordField();
        jCb_ShowPassword_Setting = new javax.swing.JCheckBox();
        jRb_Ktx = new javax.swing.JRadioButton();
        jRb_System = new javax.swing.JRadioButton();
        jBtn_SaveEmailInfo = new javax.swing.JButton();
        jLb_List_Email = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_ListEmail = new javax.swing.JTable();
        jLb_Email_Content = new javax.swing.JLabel();
        jLb_Select_Email = new javax.swing.JLabel();
        jCb_selectEmail = new javax.swing.JComboBox<>();
        jLb_ListEmailRefresh = new javax.swing.JLabel();
        jLb_Subject = new javax.swing.JLabel();
        jTF_Subject = new javax.swing.JTextField();
        jLb_Content = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Content = new javax.swing.JTextArea();
        jBtn_Savecontent = new javax.swing.JButton();
        jRb_Support = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel_Home.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_SlideBarMenu.setBackground(new java.awt.Color(42, 150, 83));

        jLb_Logo.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        jLb_Logo.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Logo.setText("DOM");

        jLb_SubLogo.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jLb_SubLogo.setForeground(new java.awt.Color(255, 255, 255));
        jLb_SubLogo.setText("anagement");

        jSeparator_LogoTop.setBackground(new java.awt.Color(45, 180, 95));
        jSeparator_LogoTop.setForeground(new java.awt.Color(42, 150, 83));

        jLb_Avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Avatar/Avatar_45px.png"))); // NOI18N

        jLb_Fullname.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_Fullname.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Fullname.setText("Nguyễn Thị Thu Thảo");

        jLb_Role.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLb_Role.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Role.setText("ADMIN");

        jSeparator_LogoBot.setBackground(new java.awt.Color(45, 180, 95));
        jSeparator_LogoBot.setForeground(new java.awt.Color(42, 150, 83));

        jPanel_Menu_Dashboard.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_Dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_DashboardMouseClicked(evt);
            }
        });
        jPanel_Menu_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_1.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dashboard_26px.png"))); // NOI18N
        jPanel_Menu_Dashboard.add(jLb_Icon_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_1.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_1.setText(" Dashboard");
        jPanel_Menu_Dashboard.add(jLb_Text_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_Accounts.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_Accounts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_Accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_AccountsMouseClicked(evt);
            }
        });
        jPanel_Menu_Accounts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_2.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Account_24px.png"))); // NOI18N
        jPanel_Menu_Accounts.add(jLb_Icon_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_2.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_2.setText(" Accounts");
        jPanel_Menu_Accounts.add(jLb_Text_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_Students.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_Students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_Students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_StudentsMouseClicked(evt);
            }
        });
        jPanel_Menu_Students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_3.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Student_23px.png"))); // NOI18N
        jPanel_Menu_Students.add(jLb_Icon_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_3.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_3.setText(" Students");
        jPanel_Menu_Students.add(jLb_Text_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_RoomDom.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_RoomDom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_RoomDom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_RoomDomMouseClicked(evt);
            }
        });
        jPanel_Menu_RoomDom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_4.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Room_26px_1.png"))); // NOI18N
        jPanel_Menu_RoomDom.add(jLb_Icon_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_4.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_4.setText(" Dom & Room");
        jPanel_Menu_RoomDom.add(jLb_Text_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_Report.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_Report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_ReportMouseClicked(evt);
            }
        });
        jPanel_Menu_Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_5.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Report_23px.png"))); // NOI18N
        jPanel_Menu_Report.add(jLb_Icon_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_5.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_5.setText(" Report");
        jPanel_Menu_Report.add(jLb_Text_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_AddAccount.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_AddAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_AddAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_AddAccountMouseClicked(evt);
            }
        });
        jPanel_Menu_AddAccount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_6.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add_User_23px.png"))); // NOI18N
        jPanel_Menu_AddAccount.add(jLb_Icon_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_6.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_6.setText(" Add Account");
        jPanel_Menu_AddAccount.add(jLb_Text_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_Setting.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_Setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_Setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_SettingMouseClicked(evt);
            }
        });
        jPanel_Menu_Setting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_7.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Settings_24px.png"))); // NOI18N
        jPanel_Menu_Setting.add(jLb_Icon_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_7.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_7.setText(" Setting");
        jPanel_Menu_Setting.add(jLb_Text_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jPanel_Menu_Logout.setBackground(new java.awt.Color(42, 150, 83));
        jPanel_Menu_Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Menu_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_Menu_LogoutMouseClicked(evt);
            }
        });
        jPanel_Menu_Logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon_8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLb_Icon_8.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Icon_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sign_Out_24px.png"))); // NOI18N
        jPanel_Menu_Logout.add(jLb_Icon_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, 28));

        jLb_Text_8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Text_8.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Text_8.setText(" Sign Out");
        jPanel_Menu_Logout.add(jLb_Text_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        javax.swing.GroupLayout jPanel_SlideBarMenuLayout = new javax.swing.GroupLayout(jPanel_SlideBarMenu);
        jPanel_SlideBarMenu.setLayout(jPanel_SlideBarMenuLayout);
        jPanel_SlideBarMenuLayout.setHorizontalGroup(
            jPanel_SlideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator_LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator_LogoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_Accounts, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_RoomDom, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_Setting, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel_Menu_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel_SlideBarMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_SlideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_SlideBarMenuLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLb_SubLogo))
                    .addComponent(jLb_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_SlideBarMenuLayout.createSequentialGroup()
                        .addComponent(jLb_Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel_SlideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLb_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLb_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel_SlideBarMenuLayout.setVerticalGroup(
            jPanel_SlideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SlideBarMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_SlideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_SlideBarMenuLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLb_SubLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLb_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator_LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel_SlideBarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_SlideBarMenuLayout.createSequentialGroup()
                        .addComponent(jLb_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLb_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jSeparator_LogoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_Menu_Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_Accounts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_RoomDom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_Setting, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel_Menu_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        jPanel_Home.add(jPanel_SlideBarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 750));

        jPanel_Right.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_About.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/About_24px.png"))); // NOI18N
        jLb_About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_AboutMouseClicked(evt);
            }
        });
        jPanel_Right.add(jLb_About, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 20, 20));

        jLb_BtnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Gray_27px.png"))); // NOI18N
        jLb_BtnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_BtnCloseMouseClicked(evt);
            }
        });
        jPanel_Right.add(jLb_BtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 20, 20));

        jPanel_Title.setBackground(new java.awt.Color(255, 255, 255));

        jLb_Title.setBackground(new java.awt.Color(204, 204, 204));
        jLb_Title.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLb_Title.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Title.setText("Dashboard");

        javax.swing.GroupLayout jPanel_TitleLayout = new javax.swing.GroupLayout(jPanel_Title);
        jPanel_Title.setLayout(jPanel_TitleLayout);
        jPanel_TitleLayout.setHorizontalGroup(
            jPanel_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TitleLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLb_Title)
                .addContainerGap(866, Short.MAX_VALUE))
        );
        jPanel_TitleLayout.setVerticalGroup(
            jPanel_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TitleLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLb_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel_Right.add(jPanel_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 980, 80));

        jPanel_Content_Dashboard.setBackground(new java.awt.Color(233, 235, 238));
        jPanel_Content_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_TotalStudents.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_TotalStudents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Total_Students_64px.png"))); // NOI18N
        jPanel_TotalStudents.add(jLb_Icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 11, 60, -1));

        jLb_Number_Student.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLb_Number_Student.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Number_Student.setText("189");
        jPanel_TotalStudents.add(jLb_Number_Student, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLb_Description_Student.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Description_Student.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Description_Student.setText("Total students");
        jPanel_TotalStudents.add(jLb_Description_Student, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        jPanel_Content_Dashboard.add(jPanel_TotalStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 100));

        jPanel_TotalRoom.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_TotalRoom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Total_Room_64px.png"))); // NOI18N
        jPanel_TotalRoom.add(jLb_Icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 11, 64, -1));

        jLb_Number_Room.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLb_Number_Room.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Number_Room.setText("45");
        jPanel_TotalRoom.add(jLb_Number_Room, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLb_Description_Room.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Description_Room.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Description_Room.setText("Total room");
        jPanel_TotalRoom.add(jLb_Description_Room, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        jPanel_Content_Dashboard.add(jPanel_TotalRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 220, 100));

        jPanel_TotalSlot.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_TotalSlot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Total_Slot_64px.png"))); // NOI18N
        jPanel_TotalSlot.add(jLb_Icon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 11, 60, -1));

        jLb_Number_Slot.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLb_Number_Slot.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Number_Slot.setText("233");
        jPanel_TotalSlot.add(jLb_Number_Slot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLb_Description_Slot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Description_Slot.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Description_Slot.setText("Total slot");
        jPanel_TotalSlot.add(jLb_Description_Slot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        jPanel_Content_Dashboard.add(jPanel_TotalSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 220, 100));

        jPanel_TotalReport.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_TotalReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_TotalReportMouseClicked(evt);
            }
        });
        jPanel_TotalReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLb_Icon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_Icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Total_Report_64px.png"))); // NOI18N
        jPanel_TotalReport.add(jLb_Icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 11, 62, -1));

        jLb_Number_Report.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLb_Number_Report.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Number_Report.setText("3");
        jPanel_TotalReport.add(jLb_Number_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLb_Description_Report.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Description_Report.setForeground(new java.awt.Color(102, 102, 102));
        jLb_Description_Report.setText("Total report");
        jPanel_TotalReport.add(jLb_Description_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        jPanel_Content_Dashboard.add(jPanel_TotalReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 220, 100));

        jPanel_Right.add(jPanel_Content_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Content_Accounts.setBackground(new java.awt.Color(233, 235, 238));

        jLb_ListAccounts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_ListAccounts.setForeground(new java.awt.Color(51, 51, 51));
        jLb_ListAccounts.setText("List accounts:");

        jLb_TotalActive.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalActive.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Checkmark_22px.png"))); // NOI18N
        jLb_TotalActive.setText("Active: 20");
        jLb_TotalActive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalActiveMouseClicked(evt);
            }
        });

        jLb_TotalDeactive.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalDeactive.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalDeactive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Unavailable_Green_18px.png"))); // NOI18N
        jLb_TotalDeactive.setText("Deactive: 20");
        jLb_TotalDeactive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalDeactive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalDeactiveMouseClicked(evt);
            }
        });

        jLb_TotalPending.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalPending.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalPending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clock_20px.png"))); // NOI18N
        jLb_TotalPending.setText("Pending: 20");
        jLb_TotalPending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalPending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalPendingMouseClicked(evt);
            }
        });

        jLb_TotalAccounts.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalAccounts.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Grid_View_17px_Green.png"))); // NOI18N
        jLb_TotalAccounts.setText("Total: 40");
        jLb_TotalAccounts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalAccountsMouseClicked(evt);
            }
        });

        jLb_TotalAdmin.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalAdmin.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Manager_20px_1.png"))); // NOI18N
        jLb_TotalAdmin.setText("Admin: 20");
        jLb_TotalAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalAdminMouseClicked(evt);
            }
        });

        jLb_TotalStaff.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalStaff.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Member_22px.png"))); // NOI18N
        jLb_TotalStaff.setText("Staffs: 20");
        jLb_TotalStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalStaffMouseClicked(evt);
            }
        });

        jLb_TotalStudentsRole.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalStudentsRole.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalStudentsRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Student_Male_15px.png"))); // NOI18N
        jLb_TotalStudentsRole.setText("Students: 100");
        jLb_TotalStudentsRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalStudentsRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalStudentsRoleMouseClicked(evt);
            }
        });

        jLb_ListAccountsRefresh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_ListAccountsRefresh.setForeground(new java.awt.Color(0, 153, 51));
        jLb_ListAccountsRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Repeat_16px.png"))); // NOI18N
        jLb_ListAccountsRefresh.setText(" Refresh");
        jLb_ListAccountsRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_ListAccountsRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_ListAccountsRefreshMouseClicked(evt);
            }
        });

        jTable_ListAccounts.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_ListAccounts.setForeground(new java.awt.Color(51, 51, 51));
        jTable_ListAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Fullname", "Phone Number", "Username", "Email", "Type", "Created Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_ListAccounts.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_ListAccounts.setRowHeight(28);
        jTable_ListAccounts.setSelectionBackground(new java.awt.Color(45, 180, 95));
        jTable_ListAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ListAccountsMouseClicked(evt);
            }
        });
        jScrollPane_Accounts.setViewportView(jTable_ListAccounts);
        if (jTable_ListAccounts.getColumnModel().getColumnCount() > 0) {
            jTable_ListAccounts.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_ListAccounts.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_ListAccounts.getColumnModel().getColumn(1).setMinWidth(150);
            jTable_ListAccounts.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable_ListAccounts.getColumnModel().getColumn(4).setMinWidth(200);
            jTable_ListAccounts.getColumnModel().getColumn(4).setMaxWidth(200);
            jTable_ListAccounts.getColumnModel().getColumn(5).setMinWidth(80);
            jTable_ListAccounts.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jTF_SearchAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTF_SearchAccount.setForeground(new java.awt.Color(51, 51, 51));

        jComboBox_FitterAccount.setBackground(new java.awt.Color(233, 235, 238));
        jComboBox_FitterAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_FitterAccount.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_FitterAccount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Fullname", " Phone Number", " Username" }));

        jBtn_SearchAccount.setBackground(new java.awt.Color(233, 235, 238));
        jBtn_SearchAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_SearchAccount.setForeground(new java.awt.Color(51, 51, 51));
        jBtn_SearchAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search_14px.png"))); // NOI18N
        jBtn_SearchAccount.setText("Search");
        jBtn_SearchAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_SearchAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Content_AccountsLayout = new javax.swing.GroupLayout(jPanel_Content_Accounts);
        jPanel_Content_Accounts.setLayout(jPanel_Content_AccountsLayout);
        jPanel_Content_AccountsLayout.setHorizontalGroup(
            jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_AccountsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_Content_AccountsLayout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jTF_SearchAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_FitterAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_SearchAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane_Accounts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel_Content_AccountsLayout.createSequentialGroup()
                            .addComponent(jLb_ListAccounts)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLb_ListAccountsRefresh)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Content_AccountsLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLb_TotalActive)
                        .addGap(25, 25, 25)
                        .addComponent(jLb_TotalDeactive)
                        .addGap(26, 26, 26)
                        .addComponent(jLb_TotalPending)
                        .addGap(50, 50, 50)
                        .addComponent(jLb_TotalAccounts)
                        .addGap(25, 25, 25)
                        .addComponent(jLb_TotalAdmin)
                        .addGap(27, 27, 27)
                        .addComponent(jLb_TotalStaff)
                        .addGap(28, 28, 28)
                        .addComponent(jLb_TotalStudentsRole)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel_Content_AccountsLayout.setVerticalGroup(
            jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_AccountsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_SearchAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_FitterAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_SearchAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_TotalAdmin)
                    .addComponent(jLb_TotalStaff)
                    .addComponent(jLb_TotalAccounts)
                    .addComponent(jLb_TotalStudentsRole)
                    .addComponent(jLb_TotalActive)
                    .addComponent(jLb_TotalPending)
                    .addComponent(jLb_TotalDeactive))
                .addGap(7, 7, 7)
                .addGroup(jPanel_Content_AccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_ListAccountsRefresh)
                    .addComponent(jLb_ListAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane_Accounts, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Right.add(jPanel_Content_Accounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Content_Students.setBackground(new java.awt.Color(233, 235, 238));

        jLb_ListStudents.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_ListStudents.setForeground(new java.awt.Color(51, 51, 51));
        jLb_ListStudents.setText("List students:");

        jLb_TotalStudents.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalStudents.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Grid_View_17px_Green.png"))); // NOI18N
        jLb_TotalStudents.setText("Total: 40");
        jLb_TotalStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalStudentsMouseClicked(evt);
            }
        });

        jLb_TotalMale.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalMale.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalMale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Male_User_15px_1.png"))); // NOI18N
        jLb_TotalMale.setText(" Male: 20");
        jLb_TotalMale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalMaleMouseClicked(evt);
            }
        });

        jLb_TotalFemale.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_TotalFemale.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalFemale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Female_Profile_15px_1.png"))); // NOI18N
        jLb_TotalFemale.setText(" Female: 20");
        jLb_TotalFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalFemaleMouseClicked(evt);
            }
        });

        jLb_ListStudentsRefresh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_ListStudentsRefresh.setForeground(new java.awt.Color(0, 153, 51));
        jLb_ListStudentsRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Repeat_16px.png"))); // NOI18N
        jLb_ListStudentsRefresh.setText(" Refresh");
        jLb_ListStudentsRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_ListStudentsRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_ListStudentsRefreshMouseClicked(evt);
            }
        });

        jTable_ListStudents.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_ListStudents.setForeground(new java.awt.Color(51, 51, 51));
        jTable_ListStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Room", "Check In", "Fullname", "Email", "Roll Number", "Phone Number", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_ListStudents.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_ListStudents.setRowHeight(28);
        jTable_ListStudents.setSelectionBackground(new java.awt.Color(45, 180, 95));
        jTable_ListStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ListStudentsMouseClicked(evt);
            }
        });
        jScrollPane_Students.setViewportView(jTable_ListStudents);
        if (jTable_ListStudents.getColumnModel().getColumnCount() > 0) {
            jTable_ListStudents.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_ListStudents.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_ListStudents.getColumnModel().getColumn(1).setMinWidth(80);
            jTable_ListStudents.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable_ListStudents.getColumnModel().getColumn(2).setMinWidth(135);
            jTable_ListStudents.getColumnModel().getColumn(2).setMaxWidth(135);
            jTable_ListStudents.getColumnModel().getColumn(3).setMinWidth(160);
            jTable_ListStudents.getColumnModel().getColumn(3).setMaxWidth(160);
            jTable_ListStudents.getColumnModel().getColumn(4).setMinWidth(200);
            jTable_ListStudents.getColumnModel().getColumn(4).setMaxWidth(200);
            jTable_ListStudents.getColumnModel().getColumn(7).setMinWidth(80);
            jTable_ListStudents.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        jTF_SearchStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTF_SearchStudent.setForeground(new java.awt.Color(51, 51, 51));

        jComboBox_FitterStudent.setBackground(new java.awt.Color(233, 235, 238));
        jComboBox_FitterStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_FitterStudent.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_FitterStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Fullname", " Room", " Roll Number", " Phone Number" }));

        jBtn_SearchStudent.setBackground(new java.awt.Color(233, 235, 238));
        jBtn_SearchStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_SearchStudent.setForeground(new java.awt.Color(51, 51, 51));
        jBtn_SearchStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search_14px.png"))); // NOI18N
        jBtn_SearchStudent.setText("Search");
        jBtn_SearchStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_SearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Content_StudentsLayout = new javax.swing.GroupLayout(jPanel_Content_Students);
        jPanel_Content_Students.setLayout(jPanel_Content_StudentsLayout);
        jPanel_Content_StudentsLayout.setHorizontalGroup(
            jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_StudentsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel_Content_StudentsLayout.createSequentialGroup()
                            .addComponent(jLb_ListStudents)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLb_TotalStudents)
                            .addGap(40, 40, 40)
                            .addComponent(jLb_TotalMale)
                            .addGap(40, 40, 40)
                            .addComponent(jLb_TotalFemale)
                            .addGap(40, 40, 40)
                            .addComponent(jLb_ListStudentsRefresh))
                        .addComponent(jScrollPane_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_Content_StudentsLayout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jTF_SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_FitterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel_Content_StudentsLayout.setVerticalGroup(
            jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_StudentsLayout.createSequentialGroup()
                .addGroup(jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Content_StudentsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtn_SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_FitterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_Content_StudentsLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTF_SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel_Content_StudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_ListStudentsRefresh)
                    .addComponent(jLb_TotalMale)
                    .addComponent(jLb_TotalFemale)
                    .addComponent(jLb_TotalStudents)
                    .addComponent(jLb_ListStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Right.add(jPanel_Content_Students, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Content_DomRoom.setBackground(new java.awt.Color(233, 235, 238));

        jLb_ListDomSelect.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_ListDomSelect.setForeground(new java.awt.Color(51, 51, 51));
        jLb_ListDomSelect.setText("Select:");

        jCb_Dom.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jCb_Dom.setForeground(new java.awt.Color(51, 51, 51));

        jBtn_SearchDom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_SearchDom.setForeground(new java.awt.Color(51, 51, 51));
        jBtn_SearchDom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search_14px.png"))); // NOI18N
        jBtn_SearchDom.setText("View");
        jBtn_SearchDom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_SearchDom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchDomActionPerformed(evt);
            }
        });

        jLb_DescriptionRoom.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_DescriptionRoom.setForeground(new java.awt.Color(51, 51, 51));
        jLb_DescriptionRoom.setText("Select Dom to view room.");

        jPanel_ListRooms.setBackground(new java.awt.Color(233, 235, 238));

        jTable_ListRooms.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_ListRooms.setForeground(new java.awt.Color(51, 51, 51));
        jTable_ListRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Room ID", "Room", "Total slot", "Free slot", "Electricity used", "Water used", "Type", "Status", "Payment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_ListRooms.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_ListRooms.setName(""); // NOI18N
        jTable_ListRooms.setRowHeight(28);
        jTable_ListRooms.setSelectionBackground(new java.awt.Color(45, 180, 95));
        jTable_ListRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ListRoomsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ListRooms);
        if (jTable_ListRooms.getColumnModel().getColumnCount() > 0) {
            jTable_ListRooms.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_ListRooms.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLb_RoomStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_RoomStatus.setForeground(new java.awt.Color(51, 51, 51));
        jLb_RoomStatus.setText("Room status:");

        jLb_TotalRoom.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_TotalRoom.setForeground(new java.awt.Color(0, 153, 51));
        jLb_TotalRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Grid_View_17px_Green.png"))); // NOI18N
        jLb_TotalRoom.setText("Total: ");
        jLb_TotalRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalRoomMouseClicked(evt);
            }
        });

        jLb_TotalRoomActive.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_TotalRoomActive.setForeground(new java.awt.Color(0, 153, 255));
        jLb_TotalRoomActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Circle_15px.png"))); // NOI18N
        jLb_TotalRoomActive.setText("Active: ");
        jLb_TotalRoomActive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalRoomActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalRoomActiveMouseClicked(evt);
            }
        });

        jLb_TotalRoomMaintenance.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_TotalRoomMaintenance.setForeground(new java.awt.Color(255, 102, 0));
        jLb_TotalRoomMaintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Synchronize_15px.png"))); // NOI18N
        jLb_TotalRoomMaintenance.setText("Maintenance:");
        jLb_TotalRoomMaintenance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalRoomMaintenance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalRoomMaintenanceMouseClicked(evt);
            }
        });

        jLb_TotalRoomDeactive.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_TotalRoomDeactive.setForeground(new java.awt.Color(255, 51, 51));
        jLb_TotalRoomDeactive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Unavailable_15px.png"))); // NOI18N
        jLb_TotalRoomDeactive.setText("Deactive: ");
        jLb_TotalRoomDeactive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_TotalRoomDeactive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_TotalRoomDeactiveMouseClicked(evt);
            }
        });

        jLb_ListRoom.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_ListRoom.setForeground(new java.awt.Color(51, 51, 51));
        jLb_ListRoom.setText("List rooms:");

        jLb_ExportToExcelListRoom.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_ExportToExcelListRoom.setForeground(new java.awt.Color(0, 153, 51));
        jLb_ExportToExcelListRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Download_18px.png"))); // NOI18N
        jLb_ExportToExcelListRoom.setText("Export to excel");
        jLb_ExportToExcelListRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_ExportToExcelListRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_ExportToExcelListRoomMouseClicked(evt);
            }
        });

        jLb_RefreshListRoom.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_RefreshListRoom.setForeground(new java.awt.Color(0, 153, 51));
        jLb_RefreshListRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Repeat_16px.png"))); // NOI18N
        jLb_RefreshListRoom.setText(" Refresh");
        jLb_RefreshListRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_RefreshListRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_RefreshListRoomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ListRoomsLayout = new javax.swing.GroupLayout(jPanel_ListRooms);
        jPanel_ListRooms.setLayout(jPanel_ListRoomsLayout);
        jPanel_ListRoomsLayout.setHorizontalGroup(
            jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListRoomsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_ListRoomsLayout.createSequentialGroup()
                        .addComponent(jLb_ListRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLb_ExportToExcelListRoom)
                        .addGap(29, 29, 29)
                        .addComponent(jLb_RefreshListRoom))
                    .addGroup(jPanel_ListRoomsLayout.createSequentialGroup()
                        .addComponent(jLb_RoomStatus)
                        .addGap(35, 35, 35)
                        .addComponent(jLb_TotalRoom)
                        .addGap(40, 40, 40)
                        .addComponent(jLb_TotalRoomActive)
                        .addGap(40, 40, 40)
                        .addComponent(jLb_TotalRoomMaintenance)
                        .addGap(40, 40, 40)
                        .addComponent(jLb_TotalRoomDeactive))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel_ListRoomsLayout.setVerticalGroup(
            jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListRoomsLayout.createSequentialGroup()
                .addGroup(jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLb_RoomStatus)
                        .addComponent(jLb_TotalRoom))
                    .addGroup(jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLb_TotalRoomMaintenance)
                        .addComponent(jLb_TotalRoomActive)
                        .addComponent(jLb_TotalRoomDeactive)))
                .addGap(14, 14, 14)
                .addGroup(jPanel_ListRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_ListRoom)
                    .addComponent(jLb_ExportToExcelListRoom)
                    .addComponent(jLb_RefreshListRoom))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel_Content_DomRoomLayout = new javax.swing.GroupLayout(jPanel_Content_DomRoom);
        jPanel_Content_DomRoom.setLayout(jPanel_Content_DomRoomLayout);
        jPanel_Content_DomRoomLayout.setHorizontalGroup(
            jPanel_Content_DomRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_ListRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_Content_DomRoomLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Content_DomRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_DescriptionRoom)
                    .addGroup(jPanel_Content_DomRoomLayout.createSequentialGroup()
                        .addComponent(jLb_ListDomSelect)
                        .addGap(10, 10, 10)
                        .addComponent(jCb_Dom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_SearchDom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_Content_DomRoomLayout.setVerticalGroup(
            jPanel_Content_DomRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_DomRoomLayout.createSequentialGroup()
                .addGroup(jPanel_Content_DomRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_Content_DomRoomLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel_Content_DomRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCb_Dom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtn_SearchDom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Content_DomRoomLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLb_ListDomSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLb_DescriptionRoom)
                .addGap(14, 14, 14)
                .addComponent(jPanel_ListRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Right.add(jPanel_Content_DomRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Content_Report.setBackground(new java.awt.Color(233, 235, 238));

        jLb_ListReportSelect.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_ListReportSelect.setForeground(new java.awt.Color(51, 51, 51));
        jLb_ListReportSelect.setText("Select:");

        jCb_Report.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jCb_Report.setForeground(new java.awt.Color(51, 51, 51));
        jCb_Report.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Report", " Room transfer", " Checkout" }));

        jBtn_SearchReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_SearchReport.setForeground(new java.awt.Color(51, 51, 51));
        jBtn_SearchReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search_14px.png"))); // NOI18N
        jBtn_SearchReport.setText("View");
        jBtn_SearchReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_SearchReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchReportActionPerformed(evt);
            }
        });

        jLb_DescriptionReport.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_DescriptionReport.setForeground(new java.awt.Color(51, 51, 51));
        jLb_DescriptionReport.setText("Select report to view.");

        jPanel_ListReport.setBackground(new java.awt.Color(233, 235, 238));

        jLb_ListReport.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_ListReport.setForeground(new java.awt.Color(51, 51, 51));
        jLb_ListReport.setText("List report:");

        jTable_ListReport.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_ListReport.setForeground(new java.awt.Color(51, 51, 51));
        jTable_ListReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Report ID", "Fullname", "Email", "Phone number", "Type", "Rooms current", "Transfer to", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_ListReport.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_ListReport.setName(""); // NOI18N
        jTable_ListReport.setRowHeight(28);
        jTable_ListReport.setSelectionBackground(new java.awt.Color(45, 180, 95));
        jTable_ListReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ListReportMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_ListReport);
        if (jTable_ListReport.getColumnModel().getColumnCount() > 0) {
            jTable_ListReport.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_ListReport.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_ListReport.getColumnModel().getColumn(1).setMinWidth(70);
            jTable_ListReport.getColumnModel().getColumn(1).setMaxWidth(70);
            jTable_ListReport.getColumnModel().getColumn(3).setMinWidth(180);
            jTable_ListReport.getColumnModel().getColumn(3).setMaxWidth(180);
        }

        jLb_ListReportRefresh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_ListReportRefresh.setForeground(new java.awt.Color(0, 153, 51));
        jLb_ListReportRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Repeat_16px.png"))); // NOI18N
        jLb_ListReportRefresh.setText(" Refresh");
        jLb_ListReportRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLb_ListReportRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_ListReportRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ListReportLayout = new javax.swing.GroupLayout(jPanel_ListReport);
        jPanel_ListReport.setLayout(jPanel_ListReportLayout);
        jPanel_ListReportLayout.setHorizontalGroup(
            jPanel_ListReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListReportLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_ListReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_ListReportLayout.createSequentialGroup()
                        .addComponent(jLb_ListReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLb_ListReportRefresh))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel_ListReportLayout.setVerticalGroup(
            jPanel_ListReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListReportLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel_ListReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_ListReport)
                    .addComponent(jLb_ListReportRefresh))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel_Content_ReportLayout = new javax.swing.GroupLayout(jPanel_Content_Report);
        jPanel_Content_Report.setLayout(jPanel_Content_ReportLayout);
        jPanel_Content_ReportLayout.setHorizontalGroup(
            jPanel_Content_ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_ReportLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_Content_ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_DescriptionReport)
                    .addGroup(jPanel_Content_ReportLayout.createSequentialGroup()
                        .addComponent(jLb_ListReportSelect)
                        .addGap(10, 10, 10)
                        .addComponent(jCb_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_SearchReport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel_ListReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Content_ReportLayout.setVerticalGroup(
            jPanel_Content_ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_ReportLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel_Content_ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLb_ListReportSelect)
                    .addGroup(jPanel_Content_ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCb_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtn_SearchReport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jLb_DescriptionReport)
                .addGap(16, 16, 16)
                .addComponent(jPanel_ListReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Right.add(jPanel_Content_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Content_AddAccount.setBackground(new java.awt.Color(233, 235, 238));

        jLb_AddNewAccount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_AddNewAccount.setForeground(new java.awt.Color(51, 51, 51));
        jLb_AddNewAccount.setText("Enter account information:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Fullname:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("@fpt.edu.vn");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Phone number:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Username:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Password:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Confirm password:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Role:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Status:");

        jTF_Fullname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_Fullname.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

        jTF_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_Email.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

        jTF_PhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_PhoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

        jTF_Username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_Username.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

        jTF_Password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_Password.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

        jTF_PasswordCf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_PasswordCf.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

        jRb_Admin.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Role.add(jRb_Admin);
        jRb_Admin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_Admin.setForeground(new java.awt.Color(51, 51, 51));
        jRb_Admin.setText(" ADMIN");

        jRb_Director.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Role.add(jRb_Director);
        jRb_Director.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_Director.setForeground(new java.awt.Color(51, 51, 51));
        jRb_Director.setText(" STAFF");

        jRb_Active.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Status.add(jRb_Active);
        jRb_Active.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_Active.setForeground(new java.awt.Color(51, 51, 51));
        jRb_Active.setText(" ACTIVE");

        jRb_Deactive.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Status.add(jRb_Deactive);
        jRb_Deactive.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_Deactive.setForeground(new java.awt.Color(51, 51, 51));
        jRb_Deactive.setText(" DEACTIVE");

        jBt_Submit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBt_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Checkmark_Green_22px.png"))); // NOI18N
        jBt_Submit.setText("Submit");
        jBt_Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBt_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBt_SubmitActionPerformed(evt);
            }
        });

        jLb_Notofication.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Notofication.setForeground(new java.awt.Color(42, 150, 83));
        jLb_Notofication.setText(" ");

        jBtn_Clear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Broom_18px.png"))); // NOI18N
        jBtn_Clear.setText("Clear");
        jBtn_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ClearActionPerformed(evt);
            }
        });

        jBtn_GetUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_GetUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Down_Arrow_18px.png"))); // NOI18N
        jBtn_GetUsername.setText("Get from email");
        jBtn_GetUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_GetUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_GetUsernameActionPerformed(evt);
            }
        });

        jCb_Showpass.setBackground(new java.awt.Color(233, 235, 238));
        jCb_Showpass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jCb_Showpass.setText(" Show password");
        jCb_Showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCb_ShowpassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Content_AddAccountLayout = new javax.swing.GroupLayout(jPanel_Content_AddAccount);
        jPanel_Content_AddAccount.setLayout(jPanel_Content_AddAccountLayout);
        jPanel_Content_AddAccountLayout.setHorizontalGroup(
            jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLb_AddNewAccount))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(jTF_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel2)
                .addGap(95, 95, 95)
                .addComponent(jTF_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(jTF_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel5)
                .addGap(65, 65, 65)
                .addComponent(jTF_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jBtn_GetUsername))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel6)
                .addGap(69, 69, 69)
                .addComponent(jTF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jCb_Showpass))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel7)
                .addGap(16, 16, 16)
                .addComponent(jTF_PasswordCf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel8)
                .addGap(96, 96, 96)
                .addComponent(jRb_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jRb_Director))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel9)
                .addGap(84, 84, 84)
                .addComponent(jRb_Active, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jRb_Deactive))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jBt_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jBtn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLb_Notofication, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_Content_AddAccountLayout.setVerticalGroup(
            jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLb_AddNewAccount)
                .addGap(60, 60, 60)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtn_GetUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_Content_AddAccountLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCb_Showpass))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_PasswordCf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRb_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRb_Director, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRb_Active, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRb_Deactive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel_Content_AddAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLb_Notofication))
        );

        jPanel_Right.add(jPanel_Content_AddAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Content_Setting.setBackground(new java.awt.Color(233, 235, 238));

        jLb_Setting.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Setting.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Setting.setText("Setting email info for auto system:");

        jLb_Email_Infor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Email_Infor.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Email_Infor.setText("Add new email:");

        jLb_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Email.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Email.setText("Email:");

        jTF_EmailSetting.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_EmailSetting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(171, 173, 179)));

        jLb_Password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Password.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Password.setText("Password:");

        jPF_EmailPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jCb_ShowPassword_Setting.setBackground(new java.awt.Color(233, 235, 238));
        jCb_ShowPassword_Setting.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCb_ShowPassword_Setting.setForeground(new java.awt.Color(51, 51, 51));
        jCb_ShowPassword_Setting.setText(" Show password");
        jCb_ShowPassword_Setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCb_ShowPassword_SettingActionPerformed(evt);
            }
        });

        jRb_Ktx.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Email_Role.add(jRb_Ktx);
        jRb_Ktx.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_Ktx.setForeground(new java.awt.Color(51, 51, 51));
        jRb_Ktx.setText(" KTX");

        jRb_System.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Email_Role.add(jRb_System);
        jRb_System.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_System.setForeground(new java.awt.Color(51, 51, 51));
        jRb_System.setText("SYSTEM");

        jBtn_SaveEmailInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_SaveEmailInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Checkmark_Green_22px.png"))); // NOI18N
        jBtn_SaveEmailInfo.setText("Save");
        jBtn_SaveEmailInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_SaveEmailInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SaveEmailInfoActionPerformed(evt);
            }
        });

        jLb_List_Email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_List_Email.setForeground(new java.awt.Color(51, 51, 51));
        jLb_List_Email.setText("List email:");

        jTable_ListEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable_ListEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Email", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_ListEmail.setGridColor(new java.awt.Color(204, 204, 204));
        jTable_ListEmail.setRowHeight(25);
        jTable_ListEmail.setSelectionBackground(new java.awt.Color(45, 180, 95));
        jScrollPane4.setViewportView(jTable_ListEmail);
        if (jTable_ListEmail.getColumnModel().getColumnCount() > 0) {
            jTable_ListEmail.getColumnModel().getColumn(0).setMinWidth(40);
            jTable_ListEmail.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable_ListEmail.getColumnModel().getColumn(2).setMinWidth(80);
            jTable_ListEmail.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jLb_Email_Content.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLb_Email_Content.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Email_Content.setText("Setting email content:  //coming soon");

        jLb_Select_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Select_Email.setText("Select email:");

        jCb_selectEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLb_ListEmailRefresh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLb_ListEmailRefresh.setForeground(new java.awt.Color(0, 153, 51));
        jLb_ListEmailRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Repeat_16px.png"))); // NOI18N
        jLb_ListEmailRefresh.setText(" Refresh");
        jLb_ListEmailRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLb_Subject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Subject.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Subject.setText("Subject:");

        jTF_Subject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTF_Subject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(171, 173, 179)));

        jLb_Content.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLb_Content.setForeground(new java.awt.Color(51, 51, 51));
        jLb_Content.setText("Content:");

        jTextArea_Content.setColumns(20);
        jTextArea_Content.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea_Content.setRows(5);
        jTextArea_Content.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));
        jScrollPane2.setViewportView(jTextArea_Content);

        jBtn_Savecontent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtn_Savecontent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Checkmark_Green_22px.png"))); // NOI18N
        jBtn_Savecontent.setText("Save");
        jBtn_Savecontent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Savecontent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SavecontentActionPerformed(evt);
            }
        });

        jRb_Support.setBackground(new java.awt.Color(233, 235, 238));
        buttonGroup_Email_Role.add(jRb_Support);
        jRb_Support.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jRb_Support.setForeground(new java.awt.Color(51, 51, 51));
        jRb_Support.setText("SUPPORT");

        javax.swing.GroupLayout jPanel_Content_SettingLayout = new javax.swing.GroupLayout(jPanel_Content_Setting);
        jPanel_Content_Setting.setLayout(jPanel_Content_SettingLayout);
        jPanel_Content_SettingLayout.setHorizontalGroup(
            jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLb_Setting)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Content_SettingLayout.createSequentialGroup()
                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtn_Savecontent, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLb_Content, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLb_Email_Infor)
                                        .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                            .addGap(44, 44, 44)
                                            .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLb_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLb_Select_Email)
                                        .addComponent(jLb_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Content_SettingLayout.createSequentialGroup()
                                        .addGap(440, 440, 440)
                                        .addComponent(jLb_List_Email)
                                        .addGap(276, 276, 276))
                                    .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2)
                                            .addComponent(jTF_Subject)
                                            .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTF_EmailSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                                                .addComponent(jRb_Ktx)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jRb_System)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jRb_Support))
                                                            .addComponent(jBtn_SaveEmailInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jPF_EmailPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jCb_ShowPassword_Setting)))
                                                .addGap(73, 73, 73)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                                            .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                                                .addComponent(jCb_selectEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(jLb_ListEmailRefresh)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_Content_SettingLayout.createSequentialGroup()
                                .addComponent(jLb_Email_Content, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(50, 50, 50))
        );
        jPanel_Content_SettingLayout.setVerticalGroup(
            jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLb_Setting)
                .addGap(22, 22, 22)
                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_Email_Infor)
                    .addComponent(jLb_List_Email))
                .addGap(15, 15, 15)
                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_EmailSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLb_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPF_EmailPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCb_ShowPassword_Setting))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRb_Ktx)
                            .addComponent(jRb_System)
                            .addComponent(jRb_Support))
                        .addGap(18, 18, 18)
                        .addComponent(jBtn_SaveEmailInfo)
                        .addGap(34, 34, 34)
                        .addComponent(jLb_Email_Content)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCb_selectEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLb_Select_Email)
                            .addComponent(jLb_ListEmailRefresh))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel_Content_SettingLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)))
                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_Content_SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Content, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtn_Savecontent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jPanel_Right.add(jPanel_Content_Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 980, 670));

        jPanel_Home.add(jPanel_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 980, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLb_BtnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_BtnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLb_BtnCloseMouseClicked

    private void jPanel_Menu_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_DashboardMouseClicked
        jLb_Title.setText("Dashboard");
        
        initHome();
        loadDashboard();
    }//GEN-LAST:event_jPanel_Menu_DashboardMouseClicked

    private void jPanel_Menu_AccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_AccountsMouseClicked
        jLb_Title.setText("Accounts");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(true);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(false);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(false);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        setBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        resetBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
        
        ac.displayListAccounts(jTable_ListAccounts, listAccounts);
        jTF_SearchAccount.setText(" ");
        
        int totalAccounts = 0;
        int totalAdmin = 0;
        int totalStaffs = 0;
        int totalStudentsRole = 0;
        
        int totalActive = 0;
        int totalDeactive = 0;
        int totalPending = 0;
        
        for (Account a : listAccounts) {
            totalAccounts++;
            if (a.getType().equalsIgnoreCase("admin")) {
                totalAdmin++;
            } else if (a.getType().equalsIgnoreCase("staff")) {
                totalStaffs++;
            } else {
                totalStudentsRole++;
            }
            
            switch (a.getStatus()) {
                case 1:
                    totalActive++;
                    break;
                case 0:
                    totalDeactive++;
                    break;
                default:
                    totalPending++;
                    break;
            }
        }
        
        jLb_TotalAccounts.setText("Total: " + totalAccounts);
        jLb_TotalAdmin.setText("Admin: " + totalAdmin);
        jLb_TotalStaff.setText("Staffs: " + totalStaffs);
        jLb_TotalStudentsRole.setText(" Students: " + totalStudentsRole);
        
        jLb_TotalActive.setText("Active: " + totalActive);
        jLb_TotalDeactive.setText("Deactive: " + totalDeactive);
        jLb_TotalPending.setText("Pending: " + totalPending);
    }//GEN-LAST:event_jPanel_Menu_AccountsMouseClicked

    private void jPanel_Menu_StudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_StudentsMouseClicked
        jLb_Title.setText("Students");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(true);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(false);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(false);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        setBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        resetBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
        
        sc.displayListStudents(jTable_ListStudents, listStudents);
        jTF_SearchStudent.setText(" ");
        
        int totalMale = 0;
        int totalFemale = 0;
        for (Student s : listStudents) {
            if (s.isGender() == true) {
                totalMale++;
            } else {
                totalFemale++;
            }
        }
        jLb_TotalStudents.setText(" Total: " + totalStudents);
        jLb_TotalMale.setText(" Male: " + totalMale);
        jLb_TotalFemale.setText(" Female: " + totalFemale);
    }//GEN-LAST:event_jPanel_Menu_StudentsMouseClicked

    private void jPanel_Menu_RoomDomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_RoomDomMouseClicked
        jLb_Title.setText("Room & Dom");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(true);
        jPanel_Content_Report.setVisible(false);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(false);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        setBtnColor(jPanel_Menu_RoomDom);
        resetBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
        
        listDom = dm.getAllDom();
        
        jCb_Dom.removeAllItems();
        jCb_Dom.addItem(" Dom");
        jCb_Dom.setSelectedIndex(0);
        listDom.forEach((dom) -> {
            jCb_Dom.addItem(" " + dom.getName());
        });
        
        jPanel_ListRooms.setVisible(false);
    }//GEN-LAST:event_jPanel_Menu_RoomDomMouseClicked

    private void jPanel_Menu_ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_ReportMouseClicked
        jLb_Title.setText("Report");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(true);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(false);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        setBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
        
        jPanel_ListReport.setVisible(false);
    }//GEN-LAST:event_jPanel_Menu_ReportMouseClicked

    private void jPanel_Menu_AddAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_AddAccountMouseClicked
        jLb_Title.setText("Add new account");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(false);
        jPanel_Content_AddAccount.setVisible(true);
        jPanel_Content_Setting.setVisible(false);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        resetBtnColor(jPanel_Menu_Report);
        setBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
    }//GEN-LAST:event_jPanel_Menu_AddAccountMouseClicked

    private void jPanel_Menu_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_LogoutMouseClicked
        acc = null;
        this.setVisible(false);
        SignIn signin = new SignIn();
        OpenForm.Open(signin);
    }//GEN-LAST:event_jPanel_Menu_LogoutMouseClicked

    private void jLb_AboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_AboutMouseClicked
        About about = new About(this, true);
        OpenForm.Open(about);
    }//GEN-LAST:event_jLb_AboutMouseClicked

    private void jBtn_SearchAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchAccountActionPerformed
        int type = jComboBox_FitterAccount.getSelectedIndex();
        String text = jTF_SearchAccount.getText().trim();
        ac.displayListAccounts(jTable_ListAccounts, ac.listSeachAccount(type, text, listAccounts));
    }//GEN-LAST:event_jBtn_SearchAccountActionPerformed
    
    private final WindowAdapter dialogAccountInfoClose = new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            listAccounts = am.getAllAccount();
            ac.displayListAccounts(jTable_ListAccounts, listAccounts);
            
            int totalActive = 0;
            int totalDeactive = 0;
            int totalPending = 0;
            
            for (Account a : listAccounts) {
                switch (a.getStatus()) {
                    case 1:
                        totalActive++;
                        break;
                    case 0:
                        totalDeactive++;
                        break;
                    default:
                        totalPending++;
                        break;
                }
            }
            
            jLb_TotalActive.setText("Active: " + totalActive);
            jLb_TotalDeactive.setText("Deactive: " + totalDeactive);
            jLb_TotalPending.setText("Pending: " + totalPending);
        }
        
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing");
        }
    };

    private void jTable_ListAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ListAccountsMouseClicked
        int index = jTable_ListAccounts.getSelectedRow();
        TableModel model = jTable_ListAccounts.getModel();
        
        String email = model.getValueAt(index, 4).toString().trim();
        
        AccountInfo ai = new AccountInfo(this, true, am.getOneAccountByEmail(email));
        ai.addWindowListener(dialogAccountInfoClose);
        //about.addComponentListener(dialogEvent);
        OpenForm.Open(ai);
    }//GEN-LAST:event_jTable_ListAccountsMouseClicked

    private void jTable_ListStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ListStudentsMouseClicked
        int index = jTable_ListStudents.getSelectedRow();
        TableModel model = jTable_ListStudents.getModel();
        
        String rollnumber = model.getValueAt(index, 5).toString().trim();
    }//GEN-LAST:event_jTable_ListStudentsMouseClicked

    private void jBtn_SearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchStudentActionPerformed
        int type = jComboBox_FitterStudent.getSelectedIndex();
        String text = jTF_SearchStudent.getText().trim();
        sc.displayListStudents(jTable_ListStudents, sc.listSeachStudent(type, text, listStudents));
    }//GEN-LAST:event_jBtn_SearchStudentActionPerformed
    
    int domId = -1;
    private void jBtn_SearchDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchDomActionPerformed
        
        String domName = (String) jCb_Dom.getSelectedItem();
        if (domName.trim().equalsIgnoreCase("Dom")) {
            domId = 0;
        } else {
            domId = dm.getOneDomByName(domName.trim()).getId();
        }
        
        if (domId == 0) {
            jPanel_ListRooms.setVisible(false);
            jLb_DescriptionRoom.setForeground(new Color(255, 51, 51));
            jLb_DescriptionRoom.setText("Select Dom to view room.");
        } else {
            listRoom = rm.getAllRoomByDom(domId, -1);
            if (listRoom.isEmpty()) {
                jPanel_ListRooms.setVisible(false);
                jLb_DescriptionRoom.setForeground(new Color(255, 51, 51));
                jLb_DescriptionRoom.setText("List room is empty.");
            } else {
                jLb_DescriptionRoom.setForeground(new Color(51, 51, 51));
                jLb_DescriptionRoom.setText("Select Dom to view room.");
                
                int all = listRoom.size();
                int activity = 0;
                int maintenance = 0;
                int stopUsing = 0;
                for (Room room : listRoom) {
                    if (room.getStatus() == 1) {
                        activity++;
                    }
                    if (room.getStatus() == 2) {
                        maintenance++;
                    }
                    if (room.getStatus() == 0) {
                        stopUsing++;
                    }
                }
                
                jLb_TotalRoom.setText("Total: " + all + "");
                jLb_TotalRoomActive.setText("Active: " + activity + "");
                jLb_TotalRoomMaintenance.setText("Maintenance: " + maintenance + "");
                jLb_TotalRoomDeactive.setText("Deactive: " + stopUsing + "");
                
                jPanel_ListRooms.setVisible(true);
                rc.displayListRoom(jTable_ListRooms, listRoom);
            }
        }
    }//GEN-LAST:event_jBtn_SearchDomActionPerformed

    private void jLb_TotalRoomActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalRoomActiveMouseClicked
        rc.displayListRoom(jTable_ListRooms, rc.listSeachRoom(1, listRoom));
    }//GEN-LAST:event_jLb_TotalRoomActiveMouseClicked

    private void jLb_TotalRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalRoomMouseClicked
        rc.displayListRoom(jTable_ListRooms, listRoom);
    }//GEN-LAST:event_jLb_TotalRoomMouseClicked

    private void jLb_TotalRoomMaintenanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalRoomMaintenanceMouseClicked
        rc.displayListRoom(jTable_ListRooms, rc.listSeachRoom(2, listRoom));
    }//GEN-LAST:event_jLb_TotalRoomMaintenanceMouseClicked

    private void jLb_TotalRoomDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalRoomDeactiveMouseClicked
        rc.displayListRoom(jTable_ListRooms, rc.listSeachRoom(0, listRoom));
    }//GEN-LAST:event_jLb_TotalRoomDeactiveMouseClicked
    
    private final WindowAdapter dialogRoomInfoClose = new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            listRoom = rm.getAllRoomByDom(domId, -1);
            rc.displayListRoom(jTable_ListRooms, listRoom);
            
            int all = listRoom.size();
            int activity = 0;
            int maintenance = 0;
            int stopUsing = 0;
            for (Room room : listRoom) {
                if (room.getStatus() == 1) {
                    activity++;
                }
                if (room.getStatus() == 2) {
                    maintenance++;
                }
                if (room.getStatus() == 0) {
                    stopUsing++;
                }
            }
            
            jLb_TotalRoom.setText("Total: " + all + "");
            jLb_TotalRoomActive.setText("Active: " + activity + "");
            jLb_TotalRoomMaintenance.setText("Maintenance: " + maintenance + "");
            jLb_TotalRoomDeactive.setText("Deactive: " + stopUsing + "");
        }
        
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing");
        }
    };

    private void jTable_ListRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ListRoomsMouseClicked
        int index = jTable_ListRooms.getSelectedRow();
        TableModel model = jTable_ListRooms.getModel();
        
        int roomId = Integer.parseInt(model.getValueAt(index, 1).toString().trim());
        
        Room room = rm.getRoomById(roomId);
        RoomInfo ri = new RoomInfo(this, true, room);
        ri.addWindowListener(dialogRoomInfoClose);
        OpenForm.Open(ri);
    }//GEN-LAST:event_jTable_ListRoomsMouseClicked
    
    String username = "";
    private void jBt_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBt_SubmitActionPerformed
        String fullname = jTF_Fullname.getText();
        String email = jTF_Email.getText();
        String mobile = jTF_PhoneNumber.getText();
        String password = jTF_Password.getText();
        String passwordCf = jTF_PasswordCf.getText();
        
        jRb_Admin.setActionCommand("admin");
        jRb_Director.setActionCommand("staff");
        String role = "";
        try {
            role = buttonGroup_Role.getSelection().getActionCommand();
        } catch (Exception e) {
            role = "admin";
        }
        
        jRb_Active.setActionCommand("1");
        jRb_Deactive.setActionCommand("0");
        String status = "";
        try {
            status = buttonGroup_Status.getSelection().getActionCommand();
        } catch (Exception e) {
            status = "1";
        }
        
        boolean isCheck;
        if (password.equals(passwordCf)) {
            Account account = new Account();
            account.setFullName(fullname);
            account.setEmail(email + "@fpt.edu.vn");
            account.setMobile(mobile);
            account.setUsername(email);
            account.setPassword(password);
            account.setType(role);
            account.setStatus(Integer.parseInt(status));
            isCheck = am.addAccount(account);
            if (isCheck) {
                jLb_Notofication.setText("Add new account successfuly!");
            }
        } else {
            jLb_Notofication.setText("Password not match!");
        }
    }//GEN-LAST:event_jBt_SubmitActionPerformed

    private void jBtn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ClearActionPerformed
        jTF_Fullname.setText("");
        jTF_Email.setText("");
        jTF_PhoneNumber.setText("");
        jTF_Username.setText("");
        jTF_Password.setText("");
        jTF_PasswordCf.setText("");
    }//GEN-LAST:event_jBtn_ClearActionPerformed

    private void jBtn_GetUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_GetUsernameActionPerformed
        jTF_Username.setText(jTF_Email.getText());
    }//GEN-LAST:event_jBtn_GetUsernameActionPerformed

    private void jBtn_SearchReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchReportActionPerformed
        int typeReport = jCb_Report.getSelectedIndex();
        switch (typeReport) {
            case 0:
                jPanel_ListReport.setVisible(false);
                jLb_DescriptionReport.setText("Select report to view.");
                break;
            case 1:
                listTransferRoom = trm.getAllApplication();
                if (listTransferRoom.isEmpty()) {
                    jPanel_ListReport.setVisible(false);
                    jLb_DescriptionReport.setText("List report is empty.");
                } else {
                    jLb_DescriptionReport.setText("Select report to view.");
                    jPanel_ListReport.setVisible(true);
                    rec.displayListReport(jTable_ListReport, listTransferRoom);
                }
                break;
            case 2:
                break;
            default:
                jPanel_ListReport.setVisible(false);
                jLb_DescriptionReport.setText("List is Empty.");
                break;
        }
    }//GEN-LAST:event_jBtn_SearchReportActionPerformed
    
    private final WindowAdapter dialogReportClose = new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            listTransferRoom = trm.getAllApplication();
            rec.displayListReport(jTable_ListReport, listTransferRoom);
        }
        
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing");
        }
    };

    private void jTable_ListReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ListReportMouseClicked
        int index = jTable_ListReport.getSelectedRow();
        TableModel model = jTable_ListReport.getModel();
        
        int reportId = Integer.parseInt(model.getValueAt(index, 1).toString().trim());
        
        int roomId = trm.getRoomByTransId(reportId).getRoomId();
        
        String email = model.getValueAt(index, 3).toString().trim();
        int studentId = sm.getStudentsByEmail(email).getId();
        
        boolean check = trm.getRoomByTransId(reportId).isStatus();
        int boo = 0;
        if (check) {
            boo = 1;
        }
        ReportAction ra = new ReportAction(this, true, reportId, roomId, studentId, boo);
        ra.addWindowListener(dialogReportClose);
        OpenForm.Open(ra);
    }//GEN-LAST:event_jTable_ListReportMouseClicked

    private void jLb_ExportToExcelListRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_ExportToExcelListRoomMouseClicked
        if (listRoom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data is empty.\nPlease get link before Export data.");
        } else {
            try {
                final JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(this);
                String url = fc.getSelectedFile().getPath();
                String replaceUrl = url.replace('\\', '/');
                ExportToExcel.ExportToExcelListRoom(listRoom, replaceUrl);
                
                JOptionPane.showMessageDialog(null, "Export done!", " Notification", JOptionPane.CLOSED_OPTION,
                        new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
            } catch (HeadlessException e) {
                System.out.println("getSelectedFile().getPath() NULL");
            }
        }
    }//GEN-LAST:event_jLb_ExportToExcelListRoomMouseClicked

    private void jLb_ListReportRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_ListReportRefreshMouseClicked
        listTransferRoom = trm.getAllApplication();
        rec.displayListReport(jTable_ListReport, listTransferRoom);
        
        JOptionPane.showMessageDialog(null, "Refresh done!", " Notification", JOptionPane.CLOSED_OPTION,
                new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
    }//GEN-LAST:event_jLb_ListReportRefreshMouseClicked

    private void jLb_RefreshListRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_RefreshListRoomMouseClicked
        listRoom = rm.getAllRoomByDom(domId, -1);
        rc.displayListRoom(jTable_ListRooms, listRoom);
        
        int all = listRoom.size();
        int activity = 0;
        int maintenance = 0;
        int stopUsing = 0;
        for (Room room : listRoom) {
            if (room.getStatus() == 1) {
                activity++;
            }
            if (room.getStatus() == 2) {
                maintenance++;
            }
            if (room.getStatus() == 0) {
                stopUsing++;
            }
        }
        
        jLb_TotalRoom.setText("Total: " + all + "");
        jLb_TotalRoomActive.setText("Active: " + activity + "");
        jLb_TotalRoomMaintenance.setText("Maintenance: " + maintenance + "");
        jLb_TotalRoomDeactive.setText("Deactive: " + stopUsing + "");
        
        JOptionPane.showMessageDialog(null, "Refresh done!", " Notification", JOptionPane.CLOSED_OPTION,
                new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
    }//GEN-LAST:event_jLb_RefreshListRoomMouseClicked

    private void jLb_TotalStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalStudentsMouseClicked
        sc.displayListStudents(jTable_ListStudents, listStudents);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalStudentsMouseClicked

    private void jLb_TotalMaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalMaleMouseClicked
        List<StudentJoinRoom> listStudentsMale = new ArrayList<>();
        listStudents.stream().filter((sjr) -> (sjr.isGender() == true)).forEachOrdered((sjr) -> {
            listStudentsMale.add(sjr);
        });
        sc.displayListStudents(jTable_ListStudents, listStudentsMale);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalMaleMouseClicked

    private void jLb_TotalFemaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalFemaleMouseClicked
        List<StudentJoinRoom> listStudentsFemale = new ArrayList<>();
        listStudents.stream().filter((sjr) -> (sjr.isGender() == false)).forEachOrdered((sjr) -> {
            listStudentsFemale.add(sjr);
        });
        sc.displayListStudents(jTable_ListStudents, listStudentsFemale);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalFemaleMouseClicked

    private void jLb_ListStudentsRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_ListStudentsRefreshMouseClicked
        listStudents = fm.getAllStudentJoinRoom();
        sc.displayListStudents(jTable_ListStudents, listStudents);
        jTF_SearchStudent.setText(" ");
        JOptionPane.showMessageDialog(null, "Refresh done!", " Notification", JOptionPane.CLOSED_OPTION,
                new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
    }//GEN-LAST:event_jLb_ListStudentsRefreshMouseClicked

    private void jLb_TotalAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalAccountsMouseClicked
        ac.displayListAccounts(jTable_ListAccounts, listAccounts);
        jTF_SearchAccount.setText(" ");
    }//GEN-LAST:event_jLb_TotalAccountsMouseClicked

    private void jLb_TotalAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalAdminMouseClicked
        List<Account> listAccountsAdmin = new ArrayList<>();
        listAccounts.stream().filter((account) -> (account.getType().equalsIgnoreCase("admin"))).forEachOrdered((account) -> {
            listAccountsAdmin.add(account);
        });
        ac.displayListAccounts(jTable_ListAccounts, listAccountsAdmin);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalAdminMouseClicked

    private void jLb_TotalStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalStaffMouseClicked
        List<Account> listAccountsStaff = new ArrayList<>();
        listAccounts.stream().filter((account) -> (account.getType().equalsIgnoreCase("staff"))).forEachOrdered((account) -> {
            listAccountsStaff.add(account);
        });
        ac.displayListAccounts(jTable_ListAccounts, listAccountsStaff);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalStaffMouseClicked

    private void jLb_ListAccountsRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_ListAccountsRefreshMouseClicked
        listAccounts = am.getAllAccount();
        ac.displayListAccounts(jTable_ListAccounts, listAccounts);
        jTF_SearchAccount.setText(" ");
        JOptionPane.showMessageDialog(null, "Refresh done!", " Notification", JOptionPane.CLOSED_OPTION,
                new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
    }//GEN-LAST:event_jLb_ListAccountsRefreshMouseClicked

    private void jLb_TotalStudentsRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalStudentsRoleMouseClicked
        List<Account> listAccountsStudent = new ArrayList<>();
        listAccounts.stream().filter((account) -> (account.getType().equalsIgnoreCase("student"))).forEachOrdered((account) -> {
            listAccountsStudent.add(account);
        });
        ac.displayListAccounts(jTable_ListAccounts, listAccountsStudent);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalStudentsRoleMouseClicked

    private void jPanel_TotalReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_TotalReportMouseClicked
        jLb_Title.setText("Report");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(true);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(false);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        setBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        resetBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
        
        jPanel_ListReport.setVisible(false);
    }//GEN-LAST:event_jPanel_TotalReportMouseClicked

    private void jPanel_Menu_SettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_Menu_SettingMouseClicked
        jLb_Title.setText("Setting");
        
        jPanel_Content_Dashboard.setVisible(false);
        jPanel_Content_Accounts.setVisible(false);
        jPanel_Content_Students.setVisible(false);
        jPanel_Content_DomRoom.setVisible(false);
        jPanel_Content_Report.setVisible(false);
        jPanel_Content_AddAccount.setVisible(false);
        jPanel_Content_Setting.setVisible(true);
        
        resetBtnColor(jPanel_Menu_Dashboard);
        resetBtnColor(jPanel_Menu_Accounts);
        resetBtnColor(jPanel_Menu_Students);
        resetBtnColor(jPanel_Menu_RoomDom);
        resetBtnColor(jPanel_Menu_Report);
        resetBtnColor(jPanel_Menu_AddAccount);
        setBtnColor(jPanel_Menu_Setting);
        resetBtnColor(jPanel_Menu_Logout);
        
        listEmail = eim.getAllEmail();
        eic.displayListEmail(jTable_ListEmail, listEmail);
        
        jCb_selectEmail.removeAllItems();
        jCb_selectEmail.addItem(" ---");
        jCb_selectEmail.setSelectedIndex(0);
        listEmail.forEach((email) -> {
            jCb_selectEmail.addItem(" " + email.getEmail());
        });
        
        jTF_EmailSetting.setText(" ");
        jTF_Subject.setText(" ");
        
        jTextArea_Content.setText(sampleContent);

    }//GEN-LAST:event_jPanel_Menu_SettingMouseClicked

    private void jCb_ShowpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCb_ShowpassActionPerformed
        if (jCb_Showpass.isSelected()) {
            jTF_Password.setEchoChar((char) 0);
            jTF_PasswordCf.setEchoChar((char) 0);
        } else {
            jTF_Password.setEchoChar('*');
            jTF_PasswordCf.setEchoChar('*');
        }
    }//GEN-LAST:event_jCb_ShowpassActionPerformed

    private void jBtn_SaveEmailInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SaveEmailInfoActionPerformed
        String email = jTF_EmailSetting.getText().trim();
        String pwd = jPF_EmailPassword.getText().trim();
        
        jRb_Ktx.setActionCommand("ktx");
        jRb_System.setActionCommand("system");
        jRb_Support.setActionCommand("support");
        
        String role = "";
        try {
            role = buttonGroup_Email_Role.getSelection().getActionCommand();
        } catch (Exception e) {
            role = "ktx";
        }
        
        if (email.endsWith("@gmail.com")) {
            if (eim.addEmail(new EmailInfo(email, pwd, role, ""))) {
                JOptionPane.showMessageDialog(null, "Save done!", " Notification", JOptionPane.CLOSED_OPTION,
                        new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
                
                jTF_EmailSetting.setText(" ");
                jPF_EmailPassword.setText("");
                
                listEmail = eim.getAllEmail();
                eic.displayListEmail(jTable_ListEmail, listEmail);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Only accept Gmail!", " Notification", JOptionPane.CLOSED_OPTION,
                    new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
        }

    }//GEN-LAST:event_jBtn_SaveEmailInfoActionPerformed

    private void jCb_ShowPassword_SettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCb_ShowPassword_SettingActionPerformed
        if (jCb_ShowPassword_Setting.isSelected()) {
            jPF_EmailPassword.setEchoChar((char) 0);
        } else {
            jPF_EmailPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCb_ShowPassword_SettingActionPerformed

    private void jLb_TotalPendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalPendingMouseClicked
        List<Account> listAccountsAdmin = new ArrayList<>();
        listAccounts.stream().filter((account) -> (account.getStatus() == 2)).forEachOrdered((account) -> {
            listAccountsAdmin.add(account);
        });
        ac.displayListAccounts(jTable_ListAccounts, listAccountsAdmin);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalPendingMouseClicked

    private void jLb_TotalDeactiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalDeactiveMouseClicked
        List<Account> listAccountsAdmin = new ArrayList<>();
        listAccounts.stream().filter((account) -> (account.getStatus() == 0)).forEachOrdered((account) -> {
            listAccountsAdmin.add(account);
        });
        ac.displayListAccounts(jTable_ListAccounts, listAccountsAdmin);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalDeactiveMouseClicked

    private void jLb_TotalActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_TotalActiveMouseClicked
        List<Account> listAccountsAdmin = new ArrayList<>();
        listAccounts.stream().filter((account) -> (account.getStatus() == 1)).forEachOrdered((account) -> {
            listAccountsAdmin.add(account);
        });
        ac.displayListAccounts(jTable_ListAccounts, listAccountsAdmin);
        jTF_SearchStudent.setText(" ");
    }//GEN-LAST:event_jLb_TotalActiveMouseClicked

    private void jBtn_SavecontentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SavecontentActionPerformed
//        String email = (String) jCb_selectEmail.getSelectedItem();
//        String subject = jTF_Subject.getText().trim();
//        String content = jTextArea_Content.getText();
//        
//        String temp[] = content.split("\n\n");               
//        
//        boolean check = ecm.addEmailContent(new EmailContent(eim.getOneEmailByName(email.trim()).getId(), subject, temp[1], ""));
//        if (check) {
//            JOptionPane.showMessageDialog(null, "Saved!", " Notification", JOptionPane.CLOSED_OPTION,
//                    new javax.swing.ImageIcon(getClass().getResource("/Images/Info_40px.png")));
//        }
    }//GEN-LAST:event_jBtn_SavecontentActionPerformed

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

        /* Create and display the form */
        if (acc != null) {
            Home h = new Home();
            DragListener drag = new DragListener();
            h.addMouseListener(drag);
            h.addMouseMotionListener(drag);
            
            java.awt.EventQueue.invokeLater(() -> {
                h.setVisible(true);
            });
        } else {
            SignIn signin = new SignIn();
            OpenForm.Open(signin);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_Email_Role;
    private javax.swing.ButtonGroup buttonGroup_Role;
    private javax.swing.ButtonGroup buttonGroup_Status;
    private javax.swing.JButton jBt_Submit;
    private javax.swing.JButton jBtn_Clear;
    private javax.swing.JButton jBtn_GetUsername;
    private javax.swing.JButton jBtn_SaveEmailInfo;
    private javax.swing.JButton jBtn_Savecontent;
    private javax.swing.JButton jBtn_SearchAccount;
    private javax.swing.JButton jBtn_SearchDom;
    private javax.swing.JButton jBtn_SearchReport;
    private javax.swing.JButton jBtn_SearchStudent;
    private javax.swing.JComboBox<String> jCb_Dom;
    private javax.swing.JComboBox<String> jCb_Report;
    private javax.swing.JCheckBox jCb_ShowPassword_Setting;
    private javax.swing.JCheckBox jCb_Showpass;
    private javax.swing.JComboBox<String> jCb_selectEmail;
    private javax.swing.JComboBox<String> jComboBox_FitterAccount;
    private javax.swing.JComboBox<String> jComboBox_FitterStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLb_About;
    private javax.swing.JLabel jLb_AddNewAccount;
    private javax.swing.JLabel jLb_Avatar;
    private javax.swing.JLabel jLb_BtnClose;
    private javax.swing.JLabel jLb_Content;
    private javax.swing.JLabel jLb_DescriptionReport;
    private javax.swing.JLabel jLb_DescriptionRoom;
    private javax.swing.JLabel jLb_Description_Report;
    private javax.swing.JLabel jLb_Description_Room;
    private javax.swing.JLabel jLb_Description_Slot;
    private javax.swing.JLabel jLb_Description_Student;
    private javax.swing.JLabel jLb_Email;
    private javax.swing.JLabel jLb_Email_Content;
    private javax.swing.JLabel jLb_Email_Infor;
    private javax.swing.JLabel jLb_ExportToExcelListRoom;
    private javax.swing.JLabel jLb_Fullname;
    private javax.swing.JLabel jLb_Icon1;
    private javax.swing.JLabel jLb_Icon2;
    private javax.swing.JLabel jLb_Icon3;
    private javax.swing.JLabel jLb_Icon4;
    private javax.swing.JLabel jLb_Icon_1;
    private javax.swing.JLabel jLb_Icon_2;
    private javax.swing.JLabel jLb_Icon_3;
    private javax.swing.JLabel jLb_Icon_4;
    private javax.swing.JLabel jLb_Icon_5;
    private javax.swing.JLabel jLb_Icon_6;
    private javax.swing.JLabel jLb_Icon_7;
    private javax.swing.JLabel jLb_Icon_8;
    private javax.swing.JLabel jLb_ListAccounts;
    private javax.swing.JLabel jLb_ListAccountsRefresh;
    private javax.swing.JLabel jLb_ListDomSelect;
    private javax.swing.JLabel jLb_ListEmailRefresh;
    private javax.swing.JLabel jLb_ListReport;
    private javax.swing.JLabel jLb_ListReportRefresh;
    private javax.swing.JLabel jLb_ListReportSelect;
    private javax.swing.JLabel jLb_ListRoom;
    private javax.swing.JLabel jLb_ListStudents;
    private javax.swing.JLabel jLb_ListStudentsRefresh;
    private javax.swing.JLabel jLb_List_Email;
    private javax.swing.JLabel jLb_Logo;
    private javax.swing.JLabel jLb_Notofication;
    private javax.swing.JLabel jLb_Number_Report;
    private javax.swing.JLabel jLb_Number_Room;
    private javax.swing.JLabel jLb_Number_Slot;
    private javax.swing.JLabel jLb_Number_Student;
    private javax.swing.JLabel jLb_Password;
    private javax.swing.JLabel jLb_RefreshListRoom;
    private javax.swing.JLabel jLb_Role;
    private javax.swing.JLabel jLb_RoomStatus;
    private javax.swing.JLabel jLb_Select_Email;
    private javax.swing.JLabel jLb_Setting;
    private javax.swing.JLabel jLb_SubLogo;
    private javax.swing.JLabel jLb_Subject;
    private javax.swing.JLabel jLb_Text_1;
    private javax.swing.JLabel jLb_Text_2;
    private javax.swing.JLabel jLb_Text_3;
    private javax.swing.JLabel jLb_Text_4;
    private javax.swing.JLabel jLb_Text_5;
    private javax.swing.JLabel jLb_Text_6;
    private javax.swing.JLabel jLb_Text_7;
    private javax.swing.JLabel jLb_Text_8;
    private javax.swing.JLabel jLb_Title;
    private javax.swing.JLabel jLb_TotalAccounts;
    private javax.swing.JLabel jLb_TotalActive;
    private javax.swing.JLabel jLb_TotalAdmin;
    private javax.swing.JLabel jLb_TotalDeactive;
    private javax.swing.JLabel jLb_TotalFemale;
    private javax.swing.JLabel jLb_TotalMale;
    private javax.swing.JLabel jLb_TotalPending;
    private javax.swing.JLabel jLb_TotalRoom;
    private javax.swing.JLabel jLb_TotalRoomActive;
    private javax.swing.JLabel jLb_TotalRoomDeactive;
    private javax.swing.JLabel jLb_TotalRoomMaintenance;
    private javax.swing.JLabel jLb_TotalStaff;
    private javax.swing.JLabel jLb_TotalStudents;
    private javax.swing.JLabel jLb_TotalStudentsRole;
    private javax.swing.JPasswordField jPF_EmailPassword;
    private javax.swing.JPanel jPanel_Content_Accounts;
    private javax.swing.JPanel jPanel_Content_AddAccount;
    private javax.swing.JPanel jPanel_Content_Dashboard;
    private javax.swing.JPanel jPanel_Content_DomRoom;
    private javax.swing.JPanel jPanel_Content_Report;
    private javax.swing.JPanel jPanel_Content_Setting;
    private javax.swing.JPanel jPanel_Content_Students;
    private javax.swing.JPanel jPanel_Home;
    private javax.swing.JPanel jPanel_ListReport;
    private javax.swing.JPanel jPanel_ListRooms;
    private javax.swing.JPanel jPanel_Menu_Accounts;
    private javax.swing.JPanel jPanel_Menu_AddAccount;
    private javax.swing.JPanel jPanel_Menu_Dashboard;
    private javax.swing.JPanel jPanel_Menu_Logout;
    private javax.swing.JPanel jPanel_Menu_Report;
    private javax.swing.JPanel jPanel_Menu_RoomDom;
    private javax.swing.JPanel jPanel_Menu_Setting;
    private javax.swing.JPanel jPanel_Menu_Students;
    private javax.swing.JPanel jPanel_Right;
    private javax.swing.JPanel jPanel_SlideBarMenu;
    private javax.swing.JPanel jPanel_Title;
    private javax.swing.JPanel jPanel_TotalReport;
    private javax.swing.JPanel jPanel_TotalRoom;
    private javax.swing.JPanel jPanel_TotalSlot;
    private javax.swing.JPanel jPanel_TotalStudents;
    private javax.swing.JRadioButton jRb_Active;
    private javax.swing.JRadioButton jRb_Admin;
    private javax.swing.JRadioButton jRb_Deactive;
    private javax.swing.JRadioButton jRb_Director;
    private javax.swing.JRadioButton jRb_Ktx;
    private javax.swing.JRadioButton jRb_Support;
    private javax.swing.JRadioButton jRb_System;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane_Accounts;
    private javax.swing.JScrollPane jScrollPane_Students;
    private javax.swing.JSeparator jSeparator_LogoBot;
    private javax.swing.JSeparator jSeparator_LogoTop;
    private javax.swing.JTextField jTF_Email;
    private javax.swing.JTextField jTF_EmailSetting;
    private javax.swing.JTextField jTF_Fullname;
    private javax.swing.JPasswordField jTF_Password;
    private javax.swing.JPasswordField jTF_PasswordCf;
    private javax.swing.JTextField jTF_PhoneNumber;
    private javax.swing.JTextField jTF_SearchAccount;
    private javax.swing.JTextField jTF_SearchStudent;
    private javax.swing.JTextField jTF_Subject;
    private javax.swing.JTextField jTF_Username;
    private javax.swing.JTable jTable_ListAccounts;
    private javax.swing.JTable jTable_ListEmail;
    private javax.swing.JTable jTable_ListReport;
    private javax.swing.JTable jTable_ListRooms;
    private javax.swing.JTable jTable_ListStudents;
    private javax.swing.JTextArea jTextArea_Content;
    // End of variables declaration//GEN-END:variables
}

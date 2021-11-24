package org.theoffice.duckish.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.theoffice.duckish.obj.*;
import org.theoffice.duckish.proc.CRUD;

public class SystemUI extends javax.swing.JFrame {

    private Employee userEmployee;
    CRUD myCRUD = new CRUD("root", "902020");
    DefaultTableModel tableModelDishes = new DefaultTableModel();
    DefaultTableModel tableModelDrinks = new DefaultTableModel();
    DefaultTableModel tableModelDesserts = new DefaultTableModel();

    public void setUserEmployee(Employee userEmployee) {
        this.userEmployee = userEmployee;
    }

    public SystemUI(Employee userEmployee) {
        this.userEmployee = userEmployee;
        initComponents();
        setLocationRelativeTo(null);

        if (userEmployee.getJobTitle().equals("Manager")) {

            btnSettings.setEnabled(true);
        } else {
            btnSettings.setEnabled(false);
        }
        
        putDishesTable();
        putDrinksTable();
        putDessertsTable();
    }

    public SystemUI() {
        initComponents();
        setLocationRelativeTo(null);
        putDishesTable();
        putDrinksTable();
        putDessertsTable();
        
    }
    private void cleanTableDish(){
        for (int i = 0; i < tableDishesList.getRowCount(); i++) {
            tableModelDishes.removeRow(i);
            //This smell bad
            i-=1;
        }
    }
    private void cleanTableDrink(){
        for (int i = 0; i < tableDrinksList.getRowCount(); i++) {
            tableModelDrinks.removeRow(i);
            //This smell bad
            i-=1;
        }
    }
    private void cleanTableDessert(){
        for (int i = 0; i < tableDessertsList.getRowCount(); i++) {
            tableModelDesserts.removeRow(i);
            //This smell bad
            i-=1;
        }
    }
    
    private void putDishesTable(){
        cleanTableDish();
        tableModelDishes.addColumn("Name");
        tableModelDishes.addColumn("Price");
        ArrayList Products;
        Dish myDish;
        if(myCRUD.connect()){
            myCRUD.useDataBase();
            String[] Data = new String [3];
            Products = myCRUD.getDishesDish();
            if (Products != null) {
                for(int i = 0; i<Products.size();i++){
                myDish = (Dish) Products.get(i);
                Data[0] = myDish.getName();
                Data[1] = String.valueOf(myDish.getPrice());
                tableModelDishes.addRow(Data);
                }
                this.tableDishesList.setModel(tableModelDishes);
                this.tableDishesList.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.tableDishesList.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error to get data");
        }        
    }
    
    private void putDrinksTable(){
        cleanTableDrink();
        tableModelDrinks.addColumn("Name");
        tableModelDrinks.addColumn("Price");
        ArrayList Products;
        Dish myDish;
        if(myCRUD.connect()){
            myCRUD.useDataBase();
            String[] Data = new String [3];
            Products = myCRUD.getDishesDrink();
            if (Products != null) {
                for(int i = 0; i<Products.size();i++){
                myDish = (Dish) Products.get(i);
                Data[0] = myDish.getName();
                Data[1] = String.valueOf(myDish.getPrice());
                tableModelDrinks.addRow(Data);
                }
                this.tableDrinksList.setModel(tableModelDrinks);
                this.tableDrinksList.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.tableDrinksList.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error to get data");
        }        
    }
    
    private void putDessertsTable(){
        cleanTableDessert();
        tableModelDesserts.addColumn("Name");
        tableModelDesserts.addColumn("Price");
        ArrayList Products;
        Dish myDish;
        if(myCRUD.connect()){
            myCRUD.useDataBase();
            String[] Data = new String [3];
            Products = myCRUD.getDishesDesserts();
            if (Products != null) {
                for(int i = 0; i<Products.size();i++){
                myDish = (Dish) Products.get(i);
                Data[0] = myDish.getName();
                Data[1] = String.valueOf(myDish.getPrice());
                tableModelDesserts.addRow(Data);
                }
                this.tableDessertsList.setModel(tableModelDesserts);
                this.tableDessertsList.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.tableDessertsList.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error to get data");
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

        MenuUserPop = new javax.swing.JPopupMenu();
        Singout = new javax.swing.JMenuItem();
        SystemLogo = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        btnUsers = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnKitchen = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAddTableList = new javax.swing.JButton();
        btnDeleteTable = new javax.swing.JButton();
        PrincipalTabbed = new javax.swing.JTabbedPane();
        jPannelTables = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOfPrincipal = new javax.swing.JTable();
        btnAddCommand = new javax.swing.JButton();
        btnDeleteCommand = new javax.swing.JButton();
        jPanelDishes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDishesList = new javax.swing.JTable();
        btnAddDish = new javax.swing.JButton();
        btnDeleteDish = new javax.swing.JButton();
        jPanelDrinks = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableDrinksList = new javax.swing.JTable();
        btnAddDrink = new javax.swing.JButton();
        btnDeleteDrink = new javax.swing.JButton();
        jPanelDesserts = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDessertsList = new javax.swing.JTable();
        btnAddDessert = new javax.swing.JButton();
        btnDeleteDessert = new javax.swing.JButton();
        jPanelTicketPreviwe = new javax.swing.JPanel();
        btnPrintTicket = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        Singout.setText("Sing out");
        Singout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SingoutActionPerformed(evt);
            }
        });
        MenuUserPop.add(Singout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Duckish");
        setName("SystemUI"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 800));

        SystemLogo.setBackground(new java.awt.Color(13, 70, 87));
        SystemLogo.setForeground(new java.awt.Color(11, 59, 74));
        SystemLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_mini.png"))); // NOI18N

        titlePanel.setBackground(new java.awt.Color(11, 59, 74));

        btnUsers.setBackground(new java.awt.Color(11, 59, 74));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnUsers.setComponentPopupMenu(MenuUserPop);
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnSettings.setBackground(new java.awt.Color(11, 59, 74));
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tools.png"))); // NOI18N
        btnSettings.setPreferredSize(new java.awt.Dimension(55, 45));
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnKitchen.setBackground(new java.awt.Color(11, 59, 74));
        btnKitchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chef.png"))); // NOI18N
        btnKitchen.setPreferredSize(new java.awt.Dimension(55, 45));
        btnKitchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitchenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKitchen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsers)
                .addGap(19, 19, 19))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKitchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsers)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePanel.setBackground(new java.awt.Color(22, 117, 145));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tables"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        btnAddTableList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirm.png"))); // NOI18N
        btnAddTableList.setMaximumSize(new java.awt.Dimension(50, 45));
        btnAddTableList.setMinimumSize(new java.awt.Dimension(30, 30));
        btnAddTableList.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddTableList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTableListActionPerformed(evt);
            }
        });

        btnDeleteTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N
        btnDeleteTable.setMinimumSize(new java.awt.Dimension(30, 30));
        btnDeleteTable.setPreferredSize(new java.awt.Dimension(55, 45));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addComponent(btnAddTableList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddTableList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        PrincipalTabbed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TableOfPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableOfPrincipal.setMaximumSize(new java.awt.Dimension(500, 64));
        TableOfPrincipal.setPreferredSize(new java.awt.Dimension(500, 64));
        TableOfPrincipal.setShowGrid(true);
        jScrollPane1.setViewportView(TableOfPrincipal);

        btnAddCommand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddCommand.setPreferredSize(new java.awt.Dimension(50, 45));

        btnDeleteCommand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N

        javax.swing.GroupLayout jPannelTablesLayout = new javax.swing.GroupLayout(jPannelTables);
        jPannelTables.setLayout(jPannelTablesLayout);
        jPannelTablesLayout.setHorizontalGroup(
            jPannelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannelTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPannelTablesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(btnDeleteCommand)
                .addGap(194, 194, 194))
        );
        jPannelTablesLayout.setVerticalGroup(
            jPannelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannelTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPannelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCommand))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Tables", jPannelTables);

        jPanelDishes.setPreferredSize(new java.awt.Dimension(724, 500));

        tableDishesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        tableDishesList.setMaximumSize(new java.awt.Dimension(515, 64));
        tableDishesList.setPreferredSize(new java.awt.Dimension(500, 64));
        jScrollPane2.setViewportView(tableDishesList);

        btnAddDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddDish.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddCommand.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDishActionPerformed(evt);
            }
        });

        btnDeleteDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N

        javax.swing.GroupLayout jPanelDishesLayout = new javax.swing.GroupLayout(jPanelDishes);
        jPanelDishes.setLayout(jPanelDishesLayout);
        jPanelDishesLayout.setHorizontalGroup(
            jPanelDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDishesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelDishesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(btnDeleteDish)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDishesLayout.setVerticalGroup(
            jPanelDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDishesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDish))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Dishes", jPanelDishes);

        tableDrinksList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        jScrollPane6.setViewportView(tableDrinksList);

        btnAddDrink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddDrink.setPreferredSize(new java.awt.Dimension(50, 45));

        btnDeleteDrink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N
        btnDeleteDrink.setPreferredSize(new java.awt.Dimension(50, 45));

        javax.swing.GroupLayout jPanelDrinksLayout = new javax.swing.GroupLayout(jPanelDrinks);
        jPanelDrinks.setLayout(jPanelDrinksLayout);
        jPanelDrinksLayout.setHorizontalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(btnDeleteDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDrinksLayout.setVerticalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Drinks", jPanelDrinks);

        tableDessertsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        tableDessertsList.setMaximumSize(new java.awt.Dimension(515, 64));
        tableDessertsList.setPreferredSize(new java.awt.Dimension(515, 800));
        jScrollPane4.setViewportView(tableDessertsList);

        btnAddDessert.setText("jButton3");

        btnDeleteDessert.setText("jButton4");

        javax.swing.GroupLayout jPanelDessertsLayout = new javax.swing.GroupLayout(jPanelDesserts);
        jPanelDesserts.setLayout(jPanelDessertsLayout);
        jPanelDessertsLayout.setHorizontalGroup(
            jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnAddDessert)
                .addGap(159, 159, 159)
                .addComponent(btnDeleteDessert)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDessertsLayout.setVerticalGroup(
            jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDessert)
                    .addComponent(btnDeleteDessert))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Desserts", jPanelDesserts);

        jPanelTicketPreviwe.setBackground(new java.awt.Color(11, 59, 74));
        jPanelTicketPreviwe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTicketPreviwe.setMaximumSize(new java.awt.Dimension(289, 90));
        jPanelTicketPreviwe.setName(""); // NOI18N

        btnPrintTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        btnPrintTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintTicketActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Price"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanelTicketPreviweLayout = new javax.swing.GroupLayout(jPanelTicketPreviwe);
        jPanelTicketPreviwe.setLayout(jPanelTicketPreviweLayout);
        jPanelTicketPreviweLayout.setHorizontalGroup(
            jPanelTicketPreviweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTicketPreviweLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrintTicket)
                .addGap(75, 75, 75))
            .addGroup(jPanelTicketPreviweLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTicketPreviweLayout.setVerticalGroup(
            jPanelTicketPreviweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTicketPreviweLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnPrintTicket)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrincipalTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTicketPreviwe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SystemLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SystemLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PrincipalTabbed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTicketPreviwe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintTicketActionPerformed
        // TODO add the methot to print a ticket:
    }//GEN-LAST:event_btnPrintTicketActionPerformed

    private void btnAddTableListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTableListActionPerformed
        // TODO add the methot to add tables:
    }//GEN-LAST:event_btnAddTableListActionPerformed

    private void btnKitchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitchenActionPerformed
        // Chage the general view to the Kitchen view
        this.setVisible(false);
        Kitchen gok = new Kitchen();
        gok.setVisible(true);
    }//GEN-LAST:event_btnKitchenActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // Change the general view to the admin options
        this.setVisible(false);
        AdminUI goAdm = new AdminUI();
        goAdm.setVisible(true);

    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsersActionPerformed

    private void SingoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SingoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        StartUI setStart = new StartUI();
        setStart.setVisible(true);
    }//GEN-LAST:event_SingoutActionPerformed

    private void btnAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddDishActionPerformed
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
            java.util.logging.Logger.getLogger(SystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuUserPop;
    private javax.swing.JTabbedPane PrincipalTabbed;
    private javax.swing.JMenuItem Singout;
    private javax.swing.JLabel SystemLogo;
    private javax.swing.JTable TableOfPrincipal;
    private javax.swing.JButton btnAddCommand;
    private javax.swing.JButton btnAddDessert;
    private javax.swing.JButton btnAddDish;
    private javax.swing.JButton btnAddDrink;
    private javax.swing.JButton btnAddTableList;
    private javax.swing.JButton btnDeleteCommand;
    private javax.swing.JButton btnDeleteDessert;
    private javax.swing.JButton btnDeleteDish;
    private javax.swing.JButton btnDeleteDrink;
    private javax.swing.JButton btnDeleteTable;
    private javax.swing.JButton btnKitchen;
    private javax.swing.JButton btnPrintTicket;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnUsers;
    private javax.swing.JPanel jPanelDesserts;
    private javax.swing.JPanel jPanelDishes;
    private javax.swing.JPanel jPanelDrinks;
    private javax.swing.JPanel jPanelTicketPreviwe;
    private javax.swing.JPanel jPannelTables;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tableDessertsList;
    private javax.swing.JTable tableDishesList;
    private javax.swing.JTable tableDrinksList;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}

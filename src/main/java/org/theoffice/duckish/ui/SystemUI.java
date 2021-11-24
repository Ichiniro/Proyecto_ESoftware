package org.theoffice.duckish.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.theoffice.duckish.obj.*;
import org.theoffice.duckish.proc.CRUD;
import org.theoffice.duckish.obj.TableOrders;

public class SystemUI extends javax.swing.JFrame {

    private Employee userEmployee;
    CRUD myCRUD = new CRUD("ichi", "gc");

    DefaultTableModel tableModelDishes = new DefaultTableModel();
    DefaultTableModel tableModelDrinks = new DefaultTableModel();
    DefaultTableModel tableModelDesserts = new DefaultTableModel();
    DefaultTableModel tableModelTables = new DefaultTableModel();
    DefaultTableModel tableModelCommands = new DefaultTableModel();
    static ArrayList<TableOrders> orders = new ArrayList<TableOrders>();

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
            btnAddTableList.setEnabled(false);
        }

        tableModelDishes.addColumn("Name");
        tableModelDishes.addColumn("Price");
        tableModelDrinks.addColumn("Name");
        tableModelDrinks.addColumn("Price");
        tableModelDesserts.addColumn("Name");
        tableModelDesserts.addColumn("Price");
        tableModelTables.addColumn("Table Number");
        tableModelCommands.addColumn("Dish");
        tableModelCommands.addColumn("Prices");
        putDishesTable();
        putDrinksTable();
        putDessertsTable();
        putTableTable();
    }

    public SystemUI() {
        initComponents();
        setLocationRelativeTo(null);
        tableModelDishes.addColumn("Name");
        tableModelDishes.addColumn("Price");
        tableModelDrinks.addColumn("Name");
        tableModelDrinks.addColumn("Price");
        tableModelDesserts.addColumn("Name");
        tableModelDesserts.addColumn("Price");
        tableModelTables.addColumn("Table Number");
        tableModelCommands.addColumn("Dish");
        tableModelCommands.addColumn("Prices");
        putDishesTable();
        putDrinksTable();
        putDessertsTable();
        putTableTable();
    }

    private void cleanTableDish() {
        for (int i = 0; i < tableDishesList.getRowCount(); i++) {
            tableModelDishes.removeRow(i);
            //This smell bad
            i -= 1;
        }
    }

    private void cleanTableDrink() {
        for (int i = 0; i < tableDrinksList.getRowCount(); i++) {
            tableModelDrinks.removeRow(i);
            //This smell bad
            i -= 1;
        }
    }

    private void cleanTableDessert() {
        for (int i = 0; i < tableDessertsList.getRowCount(); i++) {
            tableModelDesserts.removeRow(i);
            //This smell bad
            i -= 1;
        }
    }

    private void cleanTableTable() {
        for (int i = 0; i < jTablesList.getRowCount(); i++) {
            tableModelTables.removeRow(i);
            //This smell bad
            i -= 1;
        }
    }

    private void putDishesTable() {
        cleanTableDish();
        ArrayList Products;
        Dish myDish;
        if (myCRUD.connect()) {
            myCRUD.useDataBase();
            String[] Data = new String[3];
            Products = myCRUD.getDishesDish();
            if (Products != null) {
                for (int i = 0; i < Products.size(); i++) {
                    myDish = (Dish) Products.get(i);
                    Data[0] = myDish.getName();
                    Data[1] = String.valueOf(myDish.getPrice());
                    tableModelDishes.addRow(Data);
                }
                this.tableDishesList.setModel(tableModelDishes);
                this.tableDishesList.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.tableDishesList.getColumnModel().getColumn(1).setPreferredWidth(100);
                myCRUD.disconnect();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty rows in the database");
        }
    }

    private void putDrinksTable() {
        cleanTableDrink();
        ArrayList Products;
        Dish myDish;
        if (myCRUD.connect()) {
            myCRUD.useDataBase();
            String[] Data = new String[3];
            Products = myCRUD.getDishesDrink();
            if (Products != null) {
                for (int i = 0; i < Products.size(); i++) {
                    myDish = (Dish) Products.get(i);
                    Data[0] = myDish.getName();
                    Data[1] = String.valueOf(myDish.getPrice());
                    tableModelDrinks.addRow(Data);
                }
                this.tableDrinksList.setModel(tableModelDrinks);
                this.tableDrinksList.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.tableDrinksList.getColumnModel().getColumn(1).setPreferredWidth(100);
                myCRUD.disconnect();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty rows in the database\nPlease add dishes to the menu");
        }
    }

    private void putDessertsTable() {
        cleanTableDessert();
        ArrayList Products;
        Dish myDish;
        if (myCRUD.connect()) {
            myCRUD.useDataBase();
            String[] Data = new String[3];
            Products = myCRUD.getDishesDesserts();
            if (Products != null) {
                for (int i = 0; i < Products.size(); i++) {
                    myDish = (Dish) Products.get(i);
                    Data[0] = myDish.getName();
                    Data[1] = String.valueOf(myDish.getPrice());
                    tableModelDesserts.addRow(Data);
                }
                this.tableDessertsList.setModel(tableModelDesserts);
                this.tableDessertsList.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.tableDessertsList.getColumnModel().getColumn(1).setPreferredWidth(100);
                myCRUD.disconnect();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty rows in the database\nPlease add dishes to the menu");
        }
    }

    private void putTableTable() {
        cleanTableTable();
        ArrayList Products;
        RestaurantTable myRestaurantTable;
        if (myCRUD.connect()) {
            myCRUD.useDataBase();
            String[] Data = new String[1];
            Products = myCRUD.getRestaurantTable();
            if (Products != null) {
                for (int i = 0; i < Products.size(); i++) {
                    myRestaurantTable = (RestaurantTable) Products.get(i);
                    Data[0] = String.valueOf(myRestaurantTable.getRestauran_table());
                    tableModelTables.addRow(Data);
                }
                this.jTablesList.setModel(tableModelTables);
                this.jTablesList.getColumnModel().getColumn(0).setPreferredWidth(10);
                myCRUD.disconnect();
            }
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
        jTablesList = new javax.swing.JTable();
        btnAddTableList = new javax.swing.JButton();
        btnDeleteTable = new javax.swing.JButton();
        PrincipalTabbed = new javax.swing.JTabbedPane();
        jPannelTables = new javax.swing.JPanel();
        btnAddCommand = new javax.swing.JButton();
        btnDeleteCommand = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableOfPrincipal = new javax.swing.JTable();
        jPanelDishes = new javax.swing.JPanel();
        btnAddDish = new javax.swing.JButton();
        btnDeleteDish = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableDishesList = new javax.swing.JTable();
        jPanelDrinks = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableDrinksList = new javax.swing.JTable();
        btnAddDrink = new javax.swing.JButton();
        btnDeleteDrink = new javax.swing.JButton();
        jPanelDesserts = new javax.swing.JPanel();
        btnAddDessert = new javax.swing.JButton();
        btnDeleteDessert = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableDessertsList = new javax.swing.JTable();
        jPanelTicketPreviwe = new javax.swing.JPanel();
        btnPrintTicket = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTicket = new javax.swing.JTable();

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
                .addContainerGap(806, Short.MAX_VALUE)
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
                .addContainerGap(88, Short.MAX_VALUE))
        );

        tablePanel.setBackground(new java.awt.Color(22, 117, 145));

        jTablesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tables"
            }
        ));
        jTablesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablesListMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTablesList);

        btnAddTableList.setBackground(new java.awt.Color(22, 117, 145));
        btnAddTableList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirm.png"))); // NOI18N
        btnAddTableList.setMaximumSize(new java.awt.Dimension(50, 45));
        btnAddTableList.setMinimumSize(new java.awt.Dimension(30, 30));
        btnAddTableList.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddTableList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTableListActionPerformed(evt);
            }
        });

        btnDeleteTable.setBackground(new java.awt.Color(22, 117, 145));
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

        jPannelTables.setBackground(new java.awt.Color(22, 117, 145));

        btnAddCommand.setBackground(new java.awt.Color(22, 117, 145));
        btnAddCommand.setForeground(new java.awt.Color(22, 117, 145));
        btnAddCommand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddCommand.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddCommand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCommandMouseClicked(evt);
            }
        });
        btnAddCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCommandActionPerformed(evt);
            }
        });

        btnDeleteCommand.setBackground(new java.awt.Color(22, 117, 145));
        btnDeleteCommand.setForeground(new java.awt.Color(22, 117, 145));
        btnDeleteCommand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N
        btnDeleteCommand.setPreferredSize(new java.awt.Dimension(50, 45));

        TableOfPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        jScrollPane7.setViewportView(TableOfPrincipal);

        javax.swing.GroupLayout jPannelTablesLayout = new javax.swing.GroupLayout(jPannelTables);
        jPannelTables.setLayout(jPannelTablesLayout);
        jPannelTablesLayout.setHorizontalGroup(
            jPannelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannelTablesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(btnDeleteCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        jPannelTablesLayout.setVerticalGroup(
            jPannelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannelTablesLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPannelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Tables", jPannelTables);

        jPanelDishes.setBackground(new java.awt.Color(22, 117, 145));
        jPanelDishes.setPreferredSize(new java.awt.Dimension(720, 500));

        btnAddDish.setBackground(new java.awt.Color(22, 117, 145));
        btnAddDish.setForeground(new java.awt.Color(22, 117, 145));
        btnAddDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddDish.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddCommand.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDishActionPerformed(evt);
            }
        });

        btnDeleteDish.setBackground(new java.awt.Color(22, 117, 145));
        btnDeleteDish.setForeground(new java.awt.Color(22, 117, 145));
        btnDeleteDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N
        btnDeleteDish.setPreferredSize(new java.awt.Dimension(50, 45));

        tableDishesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        jScrollPane9.setViewportView(tableDishesList);

        javax.swing.GroupLayout jPanelDishesLayout = new javax.swing.GroupLayout(jPanelDishes);
        jPanelDishes.setLayout(jPanelDishesLayout);
        jPanelDishesLayout.setHorizontalGroup(
            jPanelDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDishesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(btnDeleteDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addComponent(jScrollPane9)
        );
        jPanelDishesLayout.setVerticalGroup(
            jPanelDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDishesLayout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDishesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Dishes", jPanelDishes);

        jPanelDrinks.setBackground(new java.awt.Color(22, 117, 145));

        tableDrinksList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        jScrollPane6.setViewportView(tableDrinksList);

        btnAddDrink.setBackground(new java.awt.Color(22, 117, 145));
        btnAddDrink.setForeground(new java.awt.Color(22, 117, 145));
        btnAddDrink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddDrink.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDrinkActionPerformed(evt);
            }
        });

        btnDeleteDrink.setBackground(new java.awt.Color(22, 117, 145));
        btnDeleteDrink.setForeground(new java.awt.Color(22, 117, 145));
        btnDeleteDrink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N
        btnDeleteDrink.setPreferredSize(new java.awt.Dimension(50, 45));

        javax.swing.GroupLayout jPanelDrinksLayout = new javax.swing.GroupLayout(jPanelDrinks);
        jPanelDrinks.setLayout(jPanelDrinksLayout);
        jPanelDrinksLayout.setHorizontalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(btnDeleteDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
        );
        jPanelDrinksLayout.setVerticalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Drinks", jPanelDrinks);

        jPanelDesserts.setBackground(new java.awt.Color(22, 117, 145));

        btnAddDessert.setBackground(new java.awt.Color(22, 117, 145));
        btnAddDessert.setForeground(new java.awt.Color(22, 117, 145));
        btnAddDessert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAddDessert.setPreferredSize(new java.awt.Dimension(50, 45));
        btnAddDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDessertActionPerformed(evt);
            }
        });

        btnDeleteDessert.setBackground(new java.awt.Color(22, 117, 145));
        btnDeleteDessert.setForeground(new java.awt.Color(22, 117, 145));
        btnDeleteDessert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteSmall.png"))); // NOI18N
        btnDeleteDessert.setPreferredSize(new java.awt.Dimension(50, 45));

        tableDessertsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "Price", "Details"
            }
        ));
        jScrollPane8.setViewportView(tableDessertsList);

        javax.swing.GroupLayout jPanelDessertsLayout = new javax.swing.GroupLayout(jPanelDesserts);
        jPanelDesserts.setLayout(jPanelDessertsLayout);
        jPanelDessertsLayout.setHorizontalGroup(
            jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnAddDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(btnDeleteDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
        );
        jPanelDessertsLayout.setVerticalGroup(
            jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        PrincipalTabbed.addTab("Desserts", jPanelDesserts);

        jPanelTicketPreviwe.setBackground(new java.awt.Color(11, 59, 74));
        jPanelTicketPreviwe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTicketPreviwe.setMaximumSize(new java.awt.Dimension(289, 90));
        jPanelTicketPreviwe.setName(""); // NOI18N
        jPanelTicketPreviwe.setPreferredSize(new java.awt.Dimension(210, 590));

        btnPrintTicket.setBackground(new java.awt.Color(11, 59, 74));
        btnPrintTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        btnPrintTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintTicketActionPerformed(evt);
            }
        });

        jTableTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Price"
            }
        ));
        jScrollPane3.setViewportView(jTableTicket);
        if (jTableTicket.getColumnModel().getColumnCount() > 0) {
            jTableTicket.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableTicket.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanelTicketPreviweLayout = new javax.swing.GroupLayout(jPanelTicketPreviwe);
        jPanelTicketPreviwe.setLayout(jPanelTicketPreviweLayout);
        jPanelTicketPreviweLayout.setHorizontalGroup(
            jPanelTicketPreviweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTicketPreviweLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrintTicket)
                .addGap(63, 63, 63))
            .addGroup(jPanelTicketPreviweLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTicketPreviweLayout.setVerticalGroup(
            jPanelTicketPreviweLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTicketPreviweLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrintTicket)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrincipalTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelTicketPreviwe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SystemLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SystemLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PrincipalTabbed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTicketPreviwe, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
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
        myCRUD.connect();
        myCRUD.useDataBase();
        RestaurantTable myRestaurantTable = new RestaurantTable();
        myCRUD.addRestaurantTable(myRestaurantTable);
        putTableTable();
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
        int row = tableDishesList.getSelectedRow();

        if (row != -1) {
            TableOrders newOrder = new TableOrders(jTablesList.getSelectedRow(), (String)tableDishesList.getValueAt(row, 0), (String)tableDrinksList.getValueAt(row, 1));
            orders.add(newOrder);
            jTablesListMouseClicked(null);
        }
    }//GEN-LAST:event_btnAddDishActionPerformed

    private void btnAddDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDrinkActionPerformed
        int row = tableDrinksList.getSelectedRow();
        
        if (row != -1) {
            TableOrders newOrder = new TableOrders(jTablesList.getSelectedRow(), (String)tableDrinksList.getValueAt(row, 0), (String)tableDrinksList.getValueAt(row, 1));
            orders.add(newOrder);
            jTablesListMouseClicked(null);
        }
    }//GEN-LAST:event_btnAddDrinkActionPerformed

    private void btnAddDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDessertActionPerformed
        int row = tableDessertsList.getSelectedRow();
        
        if (row != -1) {
            TableOrders newOrder = new TableOrders(jTablesList.getSelectedRow(), (String) tableDessertsList.getValueAt(row, 0), (String) tableDessertsList.getValueAt(row, 1));
            orders.add(newOrder);
            jTablesListMouseClicked(null);
        }
    }//GEN-LAST:event_btnAddDessertActionPerformed

    private void jTablesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablesListMouseClicked
        JOptionPane.showMessageDialog(null, jTablesList.getSelectedRow());
        TableOrders aux;
        String[] Data = new String[2];
        tableModelCommands.setRowCount(0);
        for (int i = 0; i < orders.size(); i++) {
            aux = orders.get(i);
            if (aux.getTable() == jTablesList.getSelectedRow()) {
                System.out.println(aux.getTable());
                System.out.println(aux.getFood());
                Data[0] = aux.getFood();
                Data[1] = aux.getPrice();
                tableModelCommands.addRow(Data);
                this.TableOfPrincipal.setModel(tableModelCommands);
            }
        }
        
    }//GEN-LAST:event_jTablesListMouseClicked

    private void btnAddCommandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCommandMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCommandMouseClicked
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableTicket;
    private javax.swing.JTable jTablesList;
    private javax.swing.JTable tableDessertsList;
    private javax.swing.JTable tableDishesList;
    private javax.swing.JTable tableDrinksList;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}

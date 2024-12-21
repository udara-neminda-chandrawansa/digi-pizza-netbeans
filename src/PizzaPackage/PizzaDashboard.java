package PizzaPackage;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DashboardPackage.Dashboard;
import FeedbackPackage.Customer;
import static FeedbackPackage.CustomerForm.userList;

public class PizzaDashboard extends javax.swing.JFrame {

    // for storing made pizzas
    public static ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    public PizzaDashboard() {
        initComponents();
        setTitle("Pizza Dashboard"); // window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // app exits on close
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen

        // size buttons
        jRadioButton1.setActionCommand("Small");
        jRadioButton2.setActionCommand("Medium");
        jRadioButton3.setActionCommand("Large");

        // refresh pizza table
        refreshPizzaTable();

        // load users
        loadUsers();
    }

    @SuppressWarnings("unchecked")

    public void loadUsers() {
        for (Customer item : userList) {
            // add to cmbUserID
            cmbUserID.addItem(item.getID());
        }
    }

    private void refreshPizzaTable() {
        // get the current table model from the target table
        DefaultTableModel model = (DefaultTableModel) pizzaTable.getModel();
        // clear rows
        model.setRowCount(0);
        for (Pizza pizza : pizzaList) {
            // add a new row with new data
            model.addRow(new Object[]{"" + pizza.getID(), pizza.getName(), pizza.getCrust(), pizza.getSauce(),
                pizza.getToppings(), pizza.getCheese(), pizza.getSize(), pizza.getPrice(), pizza.getRating()});
        };
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgSize = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbCrust = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbSauce = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbToppings = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbCheese = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pizzaTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbUserID = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIGI-PIZZA");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\UNC\\Downloads\\box-arrow-left.png")); // NOI18N
        jButton3.setText("Back to Dashboard");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel2.setText("Select Crust");

        cmbCrust.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thin Crust", "Medium Crust", "Thick Crust" }));

        jLabel3.setText("Select Sauce");

        cmbSauce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tomato Sauce", "Alfredo Sauce", "Garlic Sauce" }));

        jLabel4.setText("Select Toppings");

        cmbToppings.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pepperoni", "Bell Peppers", "Pineapple" }));

        jLabel5.setText("Select Cheese");

        cmbCheese.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parmesan", "Mozzarella", "Cheddar" }));

        jButton1.setText("Make Pizza");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Name");

        rbgSize.add(jRadioButton1);
        jRadioButton1.setText("Small");

        rbgSize.add(jRadioButton2);
        jRadioButton2.setText("Medium");

        rbgSize.add(jRadioButton3);
        jRadioButton3.setText("Large");

        pizzaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Crust", "Sauce", "Toppings", "Cheese", "Size", "Price (1)", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pizzaTable);

        jLabel8.setText("ID");

        jLabel9.setText("User ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cmbCrust, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cmbSauce, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmbToppings, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cmbCheese, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jRadioButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton3))
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmbUserID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                            .addComponent(jLabel8))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCrust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSauce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbToppings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(cmbCheese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //
        // ** This is an implementation of the Builder pattern
        //
        // Variables
        String PizzaID = txtID.getText();
        String userID = cmbUserID.getSelectedItem() != null ? cmbUserID.getSelectedItem().toString() : "";
        String PizzaName = txtName.getText();
        String PizzaCrust = cmbCrust.getSelectedItem() != null ? cmbCrust.getSelectedItem().toString() : "";
        String PizzaSauce = cmbSauce.getSelectedItem() != null ? cmbSauce.getSelectedItem().toString() : "";
        String PizzaCheese = cmbCheese.getSelectedItem() != null ? cmbCheese.getSelectedItem().toString() : "";
        String PizzaTopping = cmbToppings.getSelectedItem() != null ? cmbToppings.getSelectedItem().toString() : "";
        String PizzaSize = rbgSize.getSelection() != null ? rbgSize.getSelection().getActionCommand() : "";

        // Validation
        if (PizzaID != null && !PizzaID.trim().isEmpty() && PizzaName != null && !PizzaName.trim().isEmpty() && PizzaSize != null && !PizzaSize.trim().isEmpty()) {

            // Build Pizza
            Pizza.PizzaBuilder pizzaBuilder = new Pizza.PizzaBuilder()
                    .withID(PizzaID)
                    .withUserID(userID)
                    .withName(PizzaName)
                    .withCrust(PizzaCrust)
                    .withSauce(PizzaSauce)
                    .withCheese(PizzaCheese)
                    .addTopping(PizzaTopping)
                    .withRating(1);

            // Size logic
            switch (PizzaSize) {
                case "Small":
                    pizzaBuilder.withSize(Pizza.Size.SMALL);
                    break;
                case "Medium":
                    pizzaBuilder.withSize(Pizza.Size.MEDIUM);
                    break;
                case "Large":
                    pizzaBuilder.withSize(Pizza.Size.LARGE);
                    break;
            }

            // Build & Output
            Pizza pizza = pizzaBuilder.build();

            // Add pizza to pizza list & refresh table
            pizzaList.add(pizza);
            refreshPizzaTable();

        } else {
            JOptionPane.showMessageDialog(this, "Invalid Input!",
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // go back to dashboard
        new Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PizzaDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCheese;
    private javax.swing.JComboBox<String> cmbCrust;
    private javax.swing.JComboBox<String> cmbSauce;
    private javax.swing.JComboBox<String> cmbToppings;
    private javax.swing.JComboBox<String> cmbUserID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable pizzaTable;
    private javax.swing.ButtonGroup rbgSize;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

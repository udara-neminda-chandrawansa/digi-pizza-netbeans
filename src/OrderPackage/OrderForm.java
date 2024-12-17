package OrderPackage;

import DashboardPackage.Dashboard;
import PizzaPackage.PizzaDashboard;
import PizzaPackage.Pizza;
import javax.swing.JFrame;
import OrderPackage.Order;
import static PizzaPackage.PizzaDashboard.pizzaList;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderForm extends javax.swing.JFrame {

    public OrderForm() {
        initComponents();
        setTitle("Order Form"); // window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // app exits on close
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen

        // load pizzas to cmbPizza
        getPizzas();
    }

    // short time order item list
    public static ArrayList<Pizza> itemList = new ArrayList<Pizza>();

    private void refreshOrderTable(String orderState) {
        // get the current table model from the target table
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        // Check if there are rows in the table
        if (model.getRowCount() > 0) {
            // Update the last column (orderState) of the first row
            model.setValueAt(orderState, 0, model.getColumnCount() - 1);
        } else {
            // If no rows exist, add a new row with an empty first three columns
            model.addRow(new Object[]{"", "", "", orderState});
        }
    }

    private void refreshOrderTable(String orderName, String orderType, double orderPrice, String orderState) {
        // get the current table model from the target table
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        // clear rows
        model.setRowCount(0);
        // add new row
        model.addRow(new Object[]{"" + orderName, orderType, orderPrice, orderState});
    }

    private void clearOrderTable() {
        // get the current table model from the target table
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        // clear rows
        model.setRowCount(0);
    }

    public void getPizzas() {
        // go through each pizza saved in pizzaList
        for (Pizza item : PizzaDashboard.pizzaList) {
            // add pizza names to cmbPizza
            cmbPizza.addItem(item.getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtOrderName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbOrderType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbPizza = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOrderItems = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtStateOutput = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel2.setText("Order Name");

        jLabel3.setText("Order Type");

        cmbOrderType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pickup Order", "Delivery Order" }));

        jLabel4.setText("Select Pizza");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Name", "Order Type", "Order Price", "Order State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);

        jButton1.setText("Add Pizza");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Place Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtOrderItems.setColumns(20);
        txtOrderItems.setRows(5);
        jScrollPane2.setViewportView(txtOrderItems);

        jButton4.setText("Prepare Order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Ready for Pickup");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Complete Order");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtStateOutput.setColumns(20);
        txtStateOutput.setRows(5);
        jScrollPane3.setViewportView(txtStateOutput);

        jButton7.setText("Reset Order");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(21, 21, 21)))
                            .addComponent(jLabel4))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPizza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbOrderType, 0, 166, Short.MAX_VALUE)
                            .addComponent(txtOrderName))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtOrderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cmbOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cmbPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // logout
        new Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // vars
        String orderItem = cmbPizza.getSelectedItem().toString();
        // find pizza by name
        Pizza pz = null;
        for (Pizza item : pizzaList) {
            if (item.getName() == orderItem) {
                pz = item;
            }
        }
        // add to short time array list
        if (pz != null) {
            itemList.add(pz);
        } else {
            JOptionPane.showMessageDialog(this, "No such pizza!", "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
        txtOrderItems.setText(txtOrderItems.getText().trim() + "\n" + orderItem);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // get short time list and create an order with it (command pattern)
        Order myOrder = new Order();
        OrderInvoker orderInvoker = new OrderInvoker();

        // vars
        String orderName = txtOrderName.getText();
        String orderType = cmbOrderType.getSelectedItem().toString();

        // find total price of order
        double total = 0;
        for (Pizza item : itemList) {
            total += item.getPrice();
            // while doing that, add pizza to order
            OrderCommand addItem = new AddItemCommand(myOrder, item);
            orderInvoker.setCommand(addItem);
            orderInvoker.executeCommand();
        }

        // Create a new order
        OrderCommand createOrder = new CreateOrderCommand(myOrder, orderName, total, orderType);
        orderInvoker.setCommand(createOrder);
        orderInvoker.executeCommand();

        // Set the initial state to "Placed"
        OrderCommand changeStateToPlaced = new ChangeOrderStateCommand(myOrder, new PlacedState());
        orderInvoker.setCommand(changeStateToPlaced);
        orderInvoker.executeCommand();

        // Print final order status
        txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

        // refresh table
        refreshOrderTable(orderName, orderType, total, myOrder.getOrderState().getStatus());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // create order obj and order invoker
        Order myOrder = new Order();
        OrderInvoker orderInvoker = new OrderInvoker();

        // Change the order state to "Preparing"
        OrderCommand changeStateToPreparing = new ChangeOrderStateCommand(myOrder, new PreparationState());
        orderInvoker.setCommand(changeStateToPreparing);
        orderInvoker.executeCommand();

        // Print final order status
        txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

        // refresh table
        refreshOrderTable(myOrder.getOrderState().getStatus());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // create order obj and order invoker
        Order myOrder = new Order();
        OrderInvoker orderInvoker = new OrderInvoker();

        // Change the order state to "Ready for Pickup"
        OrderCommand changeStateToPickupReady = new ChangeOrderStateCommand(myOrder, new ReadyForPickupState());
        orderInvoker.setCommand(changeStateToPickupReady);
        orderInvoker.executeCommand();

        // Print final order status
        txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

        // refresh table
        refreshOrderTable(myOrder.getOrderState().getStatus());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // create order obj and order invoker
        Order myOrder = new Order();
        OrderInvoker orderInvoker = new OrderInvoker();

        // Change the order state to "Order Complete"
        OrderCommand changeStateToCompleted = new ChangeOrderStateCommand(myOrder, new CompletedState());
        orderInvoker.setCommand(changeStateToCompleted);
        orderInvoker.executeCommand();

        // Print final order status
        txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

        // refresh table
        refreshOrderTable(myOrder.getOrderState().getStatus());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // reset all data
        clearOrderTable();
        itemList.clear();
        txtOrderName.setText("");
        txtOrderItems.setText("");
        txtStateOutput.setText("");
        cmbOrderType.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbOrderType;
    private javax.swing.JComboBox<String> cmbPizza;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextArea txtOrderItems;
    private javax.swing.JTextField txtOrderName;
    private javax.swing.JTextArea txtStateOutput;
    // End of variables declaration//GEN-END:variables
}

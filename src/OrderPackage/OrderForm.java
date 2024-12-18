package OrderPackage;

import DashboardPackage.Dashboard;
import FeedbackPackage.Customer;
import static FeedbackPackage.CustomerForm.userList;
import FeedbackPackage.StatusNotifier;
import PizzaPackage.PizzaDashboard;
import PizzaPackage.Pizza;
import javax.swing.JFrame;
import static PizzaPackage.PizzaDashboard.pizzaList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderForm extends javax.swing.JFrame {

    // short time order item list
    ArrayList<Map<Pizza, Integer>> itemList = new ArrayList<>();

    // completed order list
    public static ArrayList<Order> completedOrderList = new ArrayList<Order>();

    // create order obj and order invoker
    Order myOrder;
    OrderInvoker orderInvoker;
    // status notifier
    StatusNotifier statusNotifier;
    // current customer
    Customer cus;
    // order picked up?/delivered?
    boolean canCompleteOrder = false;

    public OrderForm() {
        initComponents();
        setTitle("Order Form"); // window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // app exits on close
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen

        // load pizzas to cmbPizza
        getPizzas();
        // load completed orders to table
        refreshOrderTable();
        // load users
        loadUsers();
    }

    public void loadUsers() {
        for (Customer item : userList) {
            // add to cmbUserID
            cmbUserID.addItem(item.getID());
        }
    }

    private void refreshOrderTable() {
        // clear table before adding items
        DefaultTableModel model = clearOrderTable();
        // go through each completed order
        for (Order item : completedOrderList) {
            // add new row
            model.addRow(new Object[]{"" + item.getOrderName(), item.getOrderType(), item.getOrderPrice(), item.getOrderState()});
        }
    }

    private void refreshOrderTable(String orderName, String orderType, double orderPrice, String orderState) {
        // get the current table model from the target table
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();

        // add new row
        model.addRow(new Object[]{"" + orderName, orderType, orderPrice, orderState});
    }

    private DefaultTableModel clearOrderTable() {
        // get the current table model from the target table
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        // clear rows
        model.setRowCount(0);
        // return model
        return model;
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
        chkExtraPackaging = new javax.swing.JCheckBox();
        chkExtraToppings = new javax.swing.JCheckBox();
        spnQty = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbUserID = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
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

        jButton7.setText("Clear Controls");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        chkExtraPackaging.setText("Extra Packaging");

        chkExtraToppings.setText("Extra Toppings");

        spnQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jLabel5.setText("Order ID");

        jLabel6.setText("User ID");

        cmbUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserIDActionPerformed(evt);
            }
        });

        jLabel7.setText("Pizza Qty");

        jButton8.setText("Pickup Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Accept Delivery");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPizza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbOrderType, 0, 166, Short.MAX_VALUE)
                            .addComponent(txtOrderName)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbUserID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkExtraToppings)
                                    .addComponent(chkExtraPackaging))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(chkExtraPackaging)
                            .addGap(18, 18, 18)
                            .addComponent(chkExtraToppings)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cmbUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtOrderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jButton1))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton4)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6)
                            .addGap(18, 18, 18)
                            .addComponent(jButton7))
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // logout
        new Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ** adding pizzas to short time list
        // vars
        String orderItem = cmbPizza.getSelectedItem().toString();
        // find pizza by name
        Pizza pz = null;
        for (Pizza item : pizzaList) {
            if (item.getName() == null ? orderItem == null : item.getName().equals(orderItem)) {
                pz = item;
            }
        }
        // hash map that stores pizza - qty
        HashMap<Pizza, Integer> pizzaWithQty = new HashMap<Pizza, Integer>();
        pizzaWithQty.put(pz, (int) spnQty.getValue());
        // add to short time array list
        if (pz != null) {
            itemList.add(pizzaWithQty);
        } else {
            JOptionPane.showMessageDialog(this, "No such pizza!", "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
        txtOrderItems.setText(txtOrderItems.getText().trim() + "\n" + orderItem + " x " + (int) spnQty.getValue());
    }//GEN-LAST:event_jButton1ActionPerformed

    public double ExtraOptions() {
        //
        // ** This is an implementation of the Decorator pattern
        //
        // get user choices
        boolean extraToppings = chkExtraToppings.isSelected();
        boolean specialPackaging = chkExtraPackaging.isSelected();

        // create a basic pizza (charge: 0)
        PizzaDecorator pd = new BasicPizza();

        // according to user choices, calculate extra charges if any
        if (extraToppings) {
            pd = new ExtraToppingDecorator(pd);
        }
        if (specialPackaging) {
            pd = new PackagingDecorator(pd);
        }

        // final message
        String finalDescription = pd.getDescription() + " added as extra options.\nExtra Fees: " + pd.getCost();

        // out
        txtStateOutput.setText(txtStateOutput.getText().trim() + "\n=============================\n" + finalDescription);
        return pd.getCost();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // ** placing the order
        // vars
        String orderID = txtID.getText();
        String userID = cmbUserID.getSelectedItem().toString();
        String orderName = txtOrderName.getText();
        String orderType = cmbOrderType.getSelectedItem().toString();

        // create an order using above vars
        if ("Pickup Order".equals(orderType)) {
            myOrder = new PickupOrder();
        } else {
            myOrder = new DeliveryOrder();
        }
        // initialize order invoker
        orderInvoker = new OrderInvoker();

        // find total price of order
        double total = 0;
        // go through each order item and calculate total
        for (Map<Pizza, Integer> item : itemList) {
            for (Map.Entry<Pizza, Integer> entry : item.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                total += (entry.getKey().getPrice() * entry.getValue());
                // while doing that, add pizza to order
                OrderCommand addItem = new AddItemCommand(myOrder, entry.getKey());
                orderInvoker.setCommand(addItem);
                orderInvoker.executeCommand();
            }
        }
        // run ExtraOptions and get the extra costs
        total += ExtraOptions();

        // update order according to recieved info
        myOrder.setOrderID(orderID);
        myOrder.setUserID(userID);
        myOrder.setOrderName(orderName);
        myOrder.setOrderType(orderType);
        myOrder.setOrderPrice(total);

        //
        // ** enable ntifications from shop to customer (observer pattern implementation)
        //
        // initialize status notifier
        statusNotifier = new StatusNotifier();

        // initialize customer
        for (Customer item : userList) {
            if (item.getID().equals(userID)) {
                cus = item;
            }
        }

        // subscribe to pizza shop
        statusNotifier.subscribe(cus);

        //
        // ** using commands to create order (command patter implementation)
        //
        // Create a new order command for changing order state
        OrderCommand createOrder = new CreateOrderCommand(myOrder, orderID, userID, orderName, total, orderType);
        orderInvoker.setCommand(createOrder);
        orderInvoker.executeCommand();

        // Set the initial state to "Placed"
        OrderCommand changeStateToPlaced = new ChangeOrderStateCommand(myOrder, new PlacedState());
        orderInvoker.setCommand(changeStateToPlaced);
        orderInvoker.executeCommand();

        // Print final order status
        txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

        // set current status (triggers notification)
        statusNotifier.setStatus(myOrder.getOrderState().getStatus(), this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // ** Change the order state to "Preparing" (only if the order is currently at `Placed` status)
        if ("Order Placed".equals(myOrder.getOrderState().getStatus())) {
            OrderCommand changeStateToPreparing = new ChangeOrderStateCommand(myOrder, new PreparationState());
            orderInvoker.setCommand(changeStateToPreparing);
            orderInvoker.executeCommand();

            // Print final order status
            txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

            // set current status (triggers notification)
            statusNotifier.setStatus(myOrder.getOrderState().getStatus(), this);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Status Detected!",
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // ** Change the order state to "Ready for Pickup" (only if the order is currently at `Preparing` status)
        if ("Preparing Pizza".equals(myOrder.getOrderState().getStatus())) {
            OrderCommand changeStateToPickupReady = new ChangeOrderStateCommand(myOrder, new ReadyForPickupState());
            orderInvoker.setCommand(changeStateToPickupReady);
            orderInvoker.executeCommand();

            // Print final order status
            txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

            // set current status (triggers notification)
            statusNotifier.setStatus(myOrder.getOrderState().getStatus(), this);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Status Detected!",
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // ** Change the order state to "Order Complete" (only if the order is currently at `Pickup/Delivery` status & canCompleteOrder)
        if ("Ready for Pickup/Delivery".equals(myOrder.getOrderState().getStatus()) && canCompleteOrder) {
            OrderCommand changeStateToCompleted = new ChangeOrderStateCommand(myOrder, new CompletedState());
            orderInvoker.setCommand(changeStateToCompleted);
            orderInvoker.executeCommand();

            // Print final order status
            txtStateOutput.setText(txtStateOutput.getText().trim() + "\nOrder Status: " + myOrder.getOrderState().getStatus());

            // set current status (triggers notification)
            statusNotifier.setStatus(myOrder.getOrderState().getStatus(), this);

            // add the order to completed order list
            completedOrderList.add(myOrder);

            // refresh table
            refreshOrderTable();
            
            // reset canCompleteOrder
            canCompleteOrder = false;
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Status Detected!",
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // ** reset all data
        itemList.clear();
        txtID.setText("");
        spnQty.setValue(1);
        txtOrderName.setText("");
        txtOrderItems.setText("");
        txtStateOutput.setText("");
        cmbOrderType.setSelectedIndex(0);
        chkExtraPackaging.setSelected(false);
        chkExtraToppings.setSelected(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cmbUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUserIDActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if("Pickup Order".equals(myOrder.getOrderType())){
            JOptionPane.showMessageDialog(this, myOrder.pickUp(), "Digi-Pizza | Best Pizzas for you!", JOptionPane.INFORMATION_MESSAGE);
            canCompleteOrder = true;
        } else {
            JOptionPane.showMessageDialog(this, "This is not a Pickup Order!",
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if("Delivery Order".equals(myOrder.getOrderType())){
            JOptionPane.showMessageDialog(this, myOrder.acceptDelivery(), "Digi-Pizza | Best Pizzas for you!", JOptionPane.INFORMATION_MESSAGE);
            canCompleteOrder = true;
        } else {
            JOptionPane.showMessageDialog(this, "This is not a Delivery Order!",
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
    private javax.swing.JCheckBox chkExtraPackaging;
    private javax.swing.JCheckBox chkExtraToppings;
    private javax.swing.JComboBox<String> cmbOrderType;
    private javax.swing.JComboBox<String> cmbPizza;
    private javax.swing.JComboBox<String> cmbUserID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtOrderItems;
    private javax.swing.JTextField txtOrderName;
    private javax.swing.JTextArea txtStateOutput;
    // End of variables declaration//GEN-END:variables
}

/*
 Sample Problem 1: Online Retail Order Management
 Description: Demonstrates multilevel inheritance using Order → ShippedOrder → DeliveredOrder
 Goal: Understand how data and behavior evolve across multiple inheritance levels
*/

public class Order {
    int orderId;
    String orderDate;

    // Constructor to initialize base order details
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to return order status at base level
    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor to initialize shipped order details
    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Method to return order status at shipped level
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor to initialize delivered order details
    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // Method to return order status at delivered level
    String getOrderStatus() {
        return "Order Delivered";
    }
}

class Ecommerce {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(501, "01-02-2026", "TRK12345", "05-02-2026");
        System.out.println("Order Status: " + order.getOrderStatus());
    }
}

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Benjamin Thompson
 * @version 2021.11.09
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Jaguar XJ"));
        stock.add(new Product(102, "Porsche Panamera"));
        stock.add(new Product(103, "Bentley Bentayga"));
        stock.add(new Product(104, "Rolls-Royce Wraith"));
        stock.add(new Product(105, "BMW 7 Series"));
        stock.add(new Product(106, "Audi A8"));
        stock.add(new Product(107, "Bentley Continental GT"));
        stock.add(new Product(108, "Rolls-Royce Phantom"));
        stock.add(new Product(109, "Range Rover"));
        stock.add(new Product(110, "Mercedes-Benz S-Class"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();
        
        stock.add(new Product(111, "Rolls-Royce Boat Tail"));
        stock.add(new Product(112, "Pagani Zonda HP Barchetta"));
        
        
        stock.buyProduct(111, 10);
        stock.buyProduct(112, 7);
        buyProducts();
        stock.print();        
        
        stock.sellProducts(111, 5);
        stock.sellProducts(112, 3);
        sellProducts();
        stock.print();
        
        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101, 7);
        stock.buyProduct(102, 11);
        stock.buyProduct(103, 4);
        stock.buyProduct(104, 6);
        stock.buyProduct(105, 14);
        stock.buyProduct(106, 2);
        stock.buyProduct(107, 8);
        stock.buyProduct(108, 9);
        stock.buyProduct(109, 3);
        stock.buyProduct(110, 5);
    }
    
    private void sellProducts()
    {
        stock.sellProducts(101, 4);
        stock.sellProducts(102, 7);
        stock.sellProducts(103, 2);
        stock.sellProducts(104, 5);
        stock.sellProducts(105, 9);
        stock.sellProducts(106, 1);
        stock.sellProducts(107, 6);
        stock.sellProducts(108, 6);
        stock.sellProducts(109, 3);
        stock.sellProducts(110, 4);
    }    
}
import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Benjamin Thompson
 * @version 2021.11.09
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        product.increaseQuantity(amount);
        System.out.println("Successfully Bought " + amount + " of " + product.getName());
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product item : stock)
        {
            int id = item.getID();
            
            if(id == productID) return item;
        }
        return null;
    }
    
    public void removeProduct(int productID){
        Product product = findProduct(productID);
        if(product != null){
            stock.remove(product);
            System.out.println("Successfully Removed " + product.getName());
            return;
        }
        else {
            System.out.println("Error: Unable to find a product with that ID Number");
            return;
        }
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0)
            {
                product.decreaseQuantity(1);
                
                // printout message
                System.out.println("Successfully Sold One " + product.getName());
                return;
            }
            else
            {
                // printout message
                System.out.println(product.getName() + "is currently out of stock");
                return;
            }
        }
        else
        {
            // printout message
            System.out.println("Error: Unable to find a product with that ID Number");
            return;
        }
    }    

    /**
     * Sells Amount of the given product.
     * Show the before and after status of the product.
     * @param productID The ID of the product being sold.
     * @param amount The amount of product being sold
     */
    public void sellProducts(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() >= amount)
            {
                product.decreaseQuantity(amount);
                
                // printout message
                System.out.println("Successfully Sold " + amount + " of " + product.getName());
                return;
            }
            else
            {
                // printout message
                System.out.println(product.getName() + "is currently out of stock or doe not have enough for that ");
                return;
            }
        }
        else
        {
            // printout message
            System.out.println("Error: Unable to find a product with that ID Number");
            return;
        }
    } 
    

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            return product.getQuantity();
        }
        else
        {
            // printout message
            System.out.println("Error: Unable to find a product with that ID Number");
            return 0;
        }
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Thompson's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
    
    public void getLowStock()
    {
        System.out.println();
        System.out.println(" Thompson's Low Stock List");
        System.out.println(" ====================");
        System.out.println();
        for(Product item : stock)
        {
             if(item.getQuantity() <= 4) {
                System.out.println(item.getName() + " - Remaining Stock: " + item.getQuantity());                
             }
        }
    }
}
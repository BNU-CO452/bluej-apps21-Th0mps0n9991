
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Benjamin Thompson
 * @version V1.0.0
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        
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
        
        buyProducts();
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        switch(choice.toLowerCase()) {
            case "quit":
                return true;
            case "print":
                stock.print();
                break;
            case "add":
                int id0 = reader.getInt("Enter the ID for the new product > ");
                String name0 = reader.getString("Enter the name for the new product > ");
                stock.add(new Product(id0, name0));
                System.out.println("Success Added " + name0 + " to the Stock list");
                break;
            case "buy":
                int id = reader.getInt("Which Product would you like to buy > ");
                int amount = reader.getInt("Amount to be bought > ");
                
                Product product = stock.findProduct(id);
                if(product == null) {
                    System.out.println("Unable to find that Product.");
                    break;
                }
                else {
                    stock.buyProduct(id, amount);
                    System.out.println("Successfully Purchased " + amount + " of " + product.getName());
                    break;
                }
            case "sell":
                int id1 = reader.getInt("Which Product would you like to sell > ");
                int amount1 = reader.getInt("Amount to be sold > ");
                
                Product product1 = stock.findProduct(id1);
                if(product1 == null) {
                    System.out.println("Unable to find that Product.");
                    break;
                }
                else {
                    stock.sellProducts(id1, amount1);
                    System.out.println("Successfully Sold " + amount1 + " of " + product1.getName());
                    break;
                }
            case "remove":
                int id2 = reader.getInt("Which Product would you like to remove > ");
                
                Product product2 = stock.findProduct(id2);
                if(product2 == null) {
                    System.out.println("Unable to find that Product.");
                    break;
                }
                else {
                    stock.removeProduct(id2);
                    System.out.println("Successfully Removed " + product2.getName());
                    break;
                }
            case "search":
                String name = reader.getString("What product would you like to search for > ");
                
                Product product3 = stock.findProductByName(name);
                if(product3 == null) {
                    System.out.println("Unable to find that Product.");
                    break;
                }
                else {
                    System.out.println("Product Found.\nID: " + product3.getID() + "\nName: " + product3.getName());
                    break;
                }
            case "lowstock":
                stock.getLowStock();
                break;
            default:
                System.out.println("Unable to find that Command.");
                break;
                
                
        }
        
        return false;
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Buy:        Buy an amount of product");
        System.out.println("    Sell:       Sell an amount of product");
        System.out.println("    Search:     For a certain product");
        System.out.println("    Lowstock:   Find all Low stock products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Benjamin Thompson");
        System.out.println("********************************");
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
}
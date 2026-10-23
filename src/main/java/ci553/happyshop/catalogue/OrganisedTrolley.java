package ci553.happyshop.catalogue;

// Inherits all properties and methods from the original Trolley class
public class OrganisedTrolley extends Trolley {

    // Replaces the parent class version of this method
    @Override
    public void addProduct(Product newProduct) {
        boolean productFound = false;

        // Step A: Loop through the existing products already in the trolley
        for (Product existingProduct : getProducts()) {

            // Step B: Check if the ID of the product that is added matches one already in the list
            if (existingProduct.getProductId().equals(newProduct.getProductId())) {

                // Step C: If it's a duplicate then don't add a new row
                // If it is a duplicate it calculates the combined quantity and updates the existing item
                int combinedQuantity = existingProduct.getOrderedQuantity() + newProduct.getOrderedQuantity();
                existingProduct.setOrderedQuantity(combinedQuantity);

                productFound = true; // Says merged it successfully
                break; // Stop looping
            }
        }

        // Step D: If the loop finishes and the product was not found then it's a new item
        if (!productFound) {
            // uses super to call the original addProduct() method from the parent Trolley class
            // so it can handle adding the new item to the end of the list normally
            super.addProduct(newProduct);
        }
    }
}
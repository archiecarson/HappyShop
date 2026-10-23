package ci553.happyshop.catalogue;

// We use "extends" to inherit all properties and methods from the original Trolley class.
public class OrganisedTrolley extends Trolley {

    // @Override tells Java that we are replacing the parent class's version of this method.
    @Override
    public void addProduct(Product newProduct) {
        boolean productFound = false;

        // Step A: Loop through the existing products already in the trolley.
        for (Product existingProduct : getProducts()) {

            // Step B: Check if the ID of the product we are adding matches one already in the list.
            if (existingProduct.getProductId().equals(newProduct.getProductId())) {

                // Step C: If it's a duplicate, we DON'T add a new row.
                // Instead, we calculate the combined quantity and update the existing item.
                int combinedQuantity = existingProduct.getOrderedQuantity() + newProduct.getOrderedQuantity();
                existingProduct.setOrderedQuantity(combinedQuantity);

                productFound = true; // Mark that we successfully merged it
                break; // Stop looping since we found our match
            }
        }

        // Step D: If the loop finishes and the product was NOT found, it's a brand new item.
        if (!productFound) {
            // We use 'super' to call the original addProduct() method from the parent Trolley class
            // so it can handle adding the new item to the end of the list normally.
            super.addProduct(newProduct);
        }
    }
}
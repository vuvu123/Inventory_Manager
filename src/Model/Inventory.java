package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static int partIDCount = 0;
    private static int productIDCount = 0;

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public static Part lookUpPart(int partID) {
        if (!allParts.isEmpty()) {
            for (Part part : allParts) {
                if (partID == part.getPartID())
                    return part;
            }
        }
        return null;
    }

    public static Product lookUpProduct(int productID) {
        if (!allProducts.isEmpty()) {
            for (Product product : allProducts) {
                if (product.getProductID() == productID)
                    return product;
            }
        }
        return null;
    }

    public static ObservableList<Part> lookUpPart(String partName) {
        String sanitizedPartName = partName.toLowerCase().trim();

        if (!allParts.isEmpty()) {
            ObservableList<Part> searchPartsList = FXCollections.observableArrayList();
            for (Part part : allParts) {
                if (part.getPartName().toLowerCase().contains(sanitizedPartName)) {
                    searchPartsList.add(part);
                }
            }
            return searchPartsList;
        }
        return null;
    }

    public static ObservableList<Product> lookUpProduct(String productName) {
        String sanitizedProductName = productName.toLowerCase().trim();

        if (!allParts.isEmpty()) {
            ObservableList<Product> searchProductsList = FXCollections.observableArrayList();
            for (Product product : allProducts) {
                if (product.getProductName().toLowerCase().contains(sanitizedProductName)) {
                    searchProductsList.add(product);
                }
            }
            return searchProductsList;
        }
        return null;
    }

    public static boolean validatePartDelete(Part part) {
        boolean isFound = false;

        for (Product product : allProducts) {
            if (product.getAllAssociatedParts().contains(part)) {
                isFound = true;
            }
        }
        return isFound;
    }

    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }

    public static boolean deletePart(Part selectedPart) {
        for (Part part : allParts) {
            if (part.getPartID() == selectedPart.getPartID()) {
                allParts.remove(part);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteProduct(Product selectedProduct) {
        for (Product product : allProducts) {
            if (product.getProductID() == selectedProduct.getProductID()) {
                allProducts.remove(product);
                return true;
            }
        }
        return false;
    }

    public static int getPartIDCount() {
        return ++partIDCount;
    }

    public static int getProductIDCount() { return ++productIDCount;
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }



}




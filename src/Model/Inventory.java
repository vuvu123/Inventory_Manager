package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static int partIDCount = 1;
    private static int productIDCount = 1;

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

    public static Part lookUpPart(String partName) {
        if (!allParts.isEmpty()) {
            for (Part part : allParts) {
                if (part.getPartName().contains(partName)) {
                    return part;
                }
            }
        }
        return null;
    }

    public static Product lookUpProduct(String partName) {
        if (!allParts.isEmpty()) {
            for (Product product : allProducts) {
                if (product.getProductName().contains(partName)) {
                    return product;
                }
            }
        }
        return null;
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
        return partIDCount++;
    }

    public static int getProductIDCount() {
        return productIDCount++;
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }



}




package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private int partID = 0;
    private int productID = 0;

    public void addPart(Part newPart) {
        this.allParts.add(newPart);
    }

    public void addProduct(Product newProduct) {
        this.allProducts.add(newProduct);
    }

    public Part lookUpPart(int partID) {
        if (!allParts.isEmpty()) {
            for (Part part : allParts) {
                if (partID == part.getPartID())
                    return part;
            }
        }
        return null;
    }

    public Product lookUpProduct(int productID) {
        if (!allProducts.isEmpty()) {
            for (Product product : allProducts) {
                if (product.getProductID() == productID)
                    return product;
            }
        }
        return null;
    }

    public void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    public void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }

    public boolean deletePart(Part selectedPart) {
        for (Part part : allParts) {
            if (part.getPartID() == selectedPart.getPartID()) {
                this.allParts.remove(part);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(Product selectedProduct) {
        for (Product product : allProducts) {
            if (product.getProductID() == selectedProduct.getProductID()) {
                this.allProducts.remove(product);
                return true;
            }
        }
        return false;
    }

    public ObservableList<Part> getAllParts() {
        return this.allParts;
    }

    public ObservableList<Product> getAllProducts() {
        return this.allProducts;
    }



}




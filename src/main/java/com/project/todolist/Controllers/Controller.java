package com.project.todolist.Controllers;

import com.project.todolist.Classes.Category;
import com.project.todolist.Classes.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    Category category = new Category();
    @FXML
    private TextField itemTextField;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private DatePicker datePick;

    @FXML
    private TreeTableView<Item> treeTableView;

    @FXML
    private TreeTableColumn<Item, String> nameColumn;

    @FXML
    private TreeTableColumn<Item, String> categoryColumn;

    @FXML
    private TreeTableColumn<Item, LocalDate> dateColumn;

    private final ObservableList<Item> itemList = FXCollections.observableArrayList();

    private TreeItem<Item> rootItem;


    @FXML
    public void initialize(){
        showListCategories();
        rootItem = new TreeItem<>(null);
        rootItem.setExpanded(true);
        treeTableView.setRoot(rootItem);

        nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("date"));
    }

    @FXML
    public void showListCategories(){
        if(categoryComboBox.getItems().isEmpty()){
            List<String> kategorije = category.getCategories();
            categoryComboBox.getItems().addAll(kategorije);
        }
    }

    @FXML
    public void addItem(){
        String name = itemTextField.getText();
        String category = categoryComboBox.getValue();
        LocalDate date = datePick.getValue();

        if(name==null || name.trim().isEmpty()){
            showWarningAlert("Name is required", "Please enter the name of the item.");
        }
        else if(category==null || category.trim().isEmpty()){
            showWarningAlert("Category is required", "Please select the category.");
        }
        else if(datePick.getValue() == null){
            showWarningAlert("Date is required", "Please pick a date.");
        }

        else {
            Item newItem = new Item(name, category, date);

            itemList.add(newItem);
            TreeItem<Item> newTreeItem = new TreeItem<>(newItem);
            treeTableView.getRoot().getChildren().add(newTreeItem);
            showConfirmationAlert("Success!", "You have added an item successfuly!");
            itemTextField.clear();
            categoryComboBox.getSelectionModel().clearSelection();
            datePick.setValue(null);
        }
    }

    public void removeItem(){
        TreeItem<Item> selectedItem = treeTableView.getSelectionModel().getSelectedItem();

        if(selectedItem == null || selectedItem.getValue() == null){
            showWarningAlert("Item doesn't exist", "There are no removable items in the table!");
            return;
        }
        else {
            selectedItem.getParent().getChildren().remove(selectedItem);
            showConfirmationAlert("Success!", "You have removed an item successfuly!");
        }
    }

    private void showWarningAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showConfirmationAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

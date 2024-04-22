package com.example.examen.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.examen.models.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_mod;

    @FXML
    private Button btn_ver;

    @FXML
    private ComboBox<String> combo_tipo;

    @FXML
    private ListView<TipoInstrumento> lista;

    @FXML
    private TextField texin_marca;

    @FXML
    private TextField texin_material;

    @FXML
    private TextField texin_name;

    @FXML
    private TextField texin_numAgujero;

    @FXML
    private TextField texin_numCuerda;

    @FXML
    private TextField texin_precio;

    @FXML
    private TextField texin_serie;
    private Tienda tienda;
    Alert alert;

    @FXML
    void btn_add(MouseEvent event) {
        String tipoSelect = combo_tipo.getValue();
        String tipo = texin_name.getText();
        String marca = texin_marca.getText();
        String precio = texin_precio.getText();
        String serie = texin_serie.getText();
        String numCuerdas = texin_numCuerda.getText();
        String material = texin_material.getText();
        String numAgujero = texin_numAgujero.getText();

        if (tipoSelect == null || !tipo.isEmpty() || !marca.isEmpty() || !precio.isEmpty() || !serie.isEmpty()) {
            switch (tipoSelect) {
                case "Cuerda":
                    if (!numCuerdas.isEmpty()) {
                        InstrumentoCuerda nuevo = new InstrumentoCuerda(tipo, marca, precio, serie, numCuerdas);
                        tienda.getInventario().add(nuevo);
                        lista.getItems().add(nuevo);
                    }else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error al guardar el Instrumento");
                        alert.setHeaderText(null);
                        alert.setContentText("Por favor, complete todos los campos.");
                        alert.showAndWait();
                    }
                    break;
                case "Percusion":
                    if (!material.isEmpty()) {
                        InstrumentoPercusion nuevo2 = new InstrumentoPercusion(tipo, marca, precio, serie, material);
                        tienda.getInventario().add(nuevo2);
                        lista.getItems().add(nuevo2);
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error al guardar el Instrumento");
                        alert.setHeaderText(null);
                        alert.setContentText("Por favor, complete todos los campos.");
                        alert.showAndWait();
                    }
                    break;
                case "Viento":
                    if (!numAgujero.isEmpty()) {
                        InstrumentoViento nuevo3 = new InstrumentoViento(tipo, marca, precio, serie, numAgujero);
                        tienda.getInventario().add(nuevo3);
                        lista.getItems().add(nuevo3);
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error al guardar el Instrumento");
                        alert.setHeaderText(null);
                        alert.setContentText("Por favor, complete todos los campos.");
                        alert.showAndWait();
                    }
                    break;
                default:
                    break;
            }
            clearTextFields();
        }else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al guardar el Instrumento");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
        }
    }

    @FXML
    void btn_delete(MouseEvent event) {
        String selectedItem = String.valueOf(lista.getSelectionModel().getSelectedItem());
        if (selectedItem != null) {
            tienda.getInventario().remove(selectedItem);
            updateListView();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Instrumento Eliminado");
            alert.showAndWait();
        }else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al eliminar");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione un instrumento");
            alert.showAndWait();
        }
    }

    @FXML
    void btn_mod(ActionEvent event) {
        int selectedIndex = lista.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1 && !isEmptyFields()) {
            TipoInstrumento selectedItem = lista.getSelectionModel().getSelectedItem();
            selectedItem.setTipo(texin_name.getText());
            selectedItem.setMarca(texin_marca.getText());
            selectedItem.setPrecio(texin_precio.getText());
            selectedItem.setSerie(texin_serie.getText());
            lista.refresh();
        }
    }
    private boolean isEmptyFields() {
        return texin_name.getText().isEmpty() && texin_marca.getText().isEmpty() &&
                texin_precio.getText().isEmpty() && texin_serie.getText().isEmpty();
    }

    private TipoInstrumento getInstrumentoFromListview() {
        int selectedIndex = lista.getSelectionModel().getSelectedIndex();
        return selectedIndex != -1 && lista.getSelectionModel().getSelectedItem() != null
                ? parseInstrumentoFromString(String.valueOf(lista.getSelectionModel().getSelectedItem()))
                : null;
    }

    private TipoInstrumento parseInstrumentoFromString(String selectedItem) {
        String[] parts = selectedItem.split(" ");
        String tipo = parts[0];
        String marca = parts[1];
        String precio = parts[2];
        String serie = parts[3];
        return new TipoInstrumento(tipo,marca,precio,serie);
    }

    @FXML
    void combo_tipo(MouseEvent event) {
        String tipoSeleccionado = combo_tipo.getValue();
        switch (tipoSeleccionado) {
            case "Cuerda":
                mostrarCamposTipoCuerda();
                break;
            case "Percusion":
                mostrarCamposTipoPercusion();
                break;
            case "Viento":
                mostrarCamposTipoViento();
                break;
            default:
                break;
        }
    }

    @FXML
    void lista(MouseEvent event) {
        if (lista.getSelectionModel().getSelectedIndex() != -1) {
            TipoInstrumento selectedStudent = getInstrumentoFromListview();
            if (selectedStudent != null) {
                texin_name.setText(selectedStudent.getTipo());
                texin_marca.setText(selectedStudent.getMarca());
                texin_precio.setText(selectedStudent.getPrecio());
                texin_serie.setText(selectedStudent.getSerie());
            }
        }
    }

    @FXML
    void initialize() {
        combo_tipo.getItems().addAll("Cuerda","Percusion","Viento");
        tienda = new Tienda(new ArrayList<TipoInstrumento>());
    }
    private void mostrarCamposTipoCuerda () {
        texin_name.setVisible(true);
        texin_marca.setVisible(true);
        texin_precio.setVisible(true);
        texin_serie.setVisible(true);
        texin_material.setVisible(false);
        texin_numAgujero.setVisible(false);
        texin_numCuerda.setVisible(true);
    }
    private void mostrarCamposTipoPercusion () {
        texin_name.setVisible(true);
        texin_marca.setVisible(true);
        texin_precio.setVisible(true);
        texin_serie.setVisible(true);
        texin_material.setVisible(true);
        texin_numAgujero.setVisible(false);
        texin_numCuerda.setVisible(false);
    }
    private void mostrarCamposTipoViento () {
        texin_name.setVisible(true);
        texin_marca.setVisible(true);
        texin_precio.setVisible(true);
        texin_serie.setVisible(true);
        texin_material.setVisible(false);
        texin_numAgujero.setVisible(true);
        texin_numCuerda.setVisible(false);
    }
    private void updateListView() {
        lista.setItems(FXCollections.observableArrayList());
    }
    private void clearTextFields() {
        texin_name.setText("");
        texin_marca.setText("");
        texin_material.setText("");
        texin_precio.setText("");
        texin_serie.setText("");
        texin_numCuerda.setText("");
        texin_numAgujero.setText("");
    }
}
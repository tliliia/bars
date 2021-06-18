package com.tronina.cs;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContractTableView<Contract> extends TableView {
    public TableColumn<Contract, Integer> contractNumberCol = new TableColumn<Contract, Integer>("№");
    public TableColumn<Contract, String> createdDateCol = new TableColumn<Contract, String>("Дата создания");
    public TableColumn<Contract, Boolean> actualCol = new TableColumn<Contract, Boolean>("Актуальность");

    public ContractTableView() {
        super();
        // Defines how to fill data for each cell.
        contractNumberCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        createdDateCol.setCellValueFactory(new PropertyValueFactory<>("created"));
        actualCol.setCellValueFactory(new PropertyValueFactory<>("isActual"));
//        actualCol.setCellFactory(CheckBoxTableCell.forTableColumn(actualCol));
        actualCol.setEditable(false);

        this.getColumns().addAll(contractNumberCol, createdDateCol, actualCol);
    }
}

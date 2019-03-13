/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model_table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.ub.government.sispdb.model.Tangkaph;

/**
 *
 * @author yhawin
 */
public class TableModelCetakInvoice extends DefaultTableModel{
    List<Tangkaph> list = new ArrayList<>();
    public TableModelCetakInvoice(List<Tangkaph> list){
        this.list = list;
        addNewColumn();
        insertNewData();
    }
    public Class<?> getColumnClass(int column){
        switch (column){
            case 0:
                return Boolean.class;
            case 1: 
                return String.class;
            case 2: 
                return Double.class;
            default:
                return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        } else if (col==0){
            return true;
        } else {
            return false;
        }
    }    
    public Tangkaph getValueAt(int rowIndex){
        return list.get(rowIndex);
    }

    public void addNewColumn(){
        addColumn("");
        addColumn("No.ORDER");
        addColumn("Tgl.ORD");
        addColumn("No.INVOICE");
        addColumn("Tgl.INV");
        addColumn("No.SJ");
        addColumn("TOP");
        addColumn("Jth.TEMPO");
        addColumn("DPP+PPN");
        addColumn("PRN");
        addColumn("CUSTOMER/OUTLET");
        addColumn("SALESMAN");
    }
    public void insertNewData(){
        try{
            for (int i=0; i<list.size(); i++){
                Tangkaph domain = new Tangkaph();
                domain = list.get(i);
                //CREATE AND FILL ENTITY
                addRow(new Object[0]);
                setValueAt(Boolean.FALSE, i, 0);
//                setValueAt(domain.getOrderno(), i, 1);
//                setValueAt(domain.getOrderdate(), i, 2);
//                setValueAt(domain.getInvoiceno(), i, 3);
//                setValueAt(domain.getInvoicedate(), i, 4);
//                setValueAt(domain.getSuratjalanno(), i, 5);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}

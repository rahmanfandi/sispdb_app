/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model_table;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.ub.government.sispdb.model.Tangkaph;

/**
 *
 * @author yhawin
 */
public class TableModelFtSalesh extends DefaultTableModel{
    List<Tangkaph> list = new ArrayList<>();
    public TableModelFtSalesh(){
         addNewColumn();
    }
    public TableModelFtSalesh(List<Tangkaph> list){
        addNewColumn();
        //Karena Pasti Error saat null
        try{
            this.list = list;
            insertNewDataFromList();
        }catch(Exception ex) {
//            ex.printStackTrace();
        }
    }
    public Class<?> getColumnClass(int column){
        switch (column){
            case 0: //OrderNo
                return String.class;
            case 1: //OrderDate
                return String.class;
            case 2: //InvoiceNo
                return String.class;
            case 3: //InvoceDate
                return Date.class;
            case 4: //Tunai Kredit
                return String.class;
            case 5: //Subtotal
                return double.class;
            case 6: //Disc Persen String
                return String.class;
            case 7: //Diskon RpJumlah
                return double.class;
            case 8: //Total
                return double.class;
            case 9: //Customer
                return String.class;
            case 10: //Salesman
                return String.class;
            default:
                return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return false;
        } else if (col==0){
            return false;
        } else {
            return false;
        }
    }    
    public Tangkaph getValueAt(int rowIndex){
        return list.get(rowIndex);
    }

    public void addNewColumn(){
        addColumn("NO.ORDER");
        addColumn("ORD.DATE");
        addColumn("NO.INVOICE");
        addColumn("INV.DATE");
        addColumn("T/K");
        addColumn("SUB TOTAL");
        addColumn("DISC %");
        addColumn("DIS RP");
        addColumn("TOTAL");
        addColumn("PRN");
        addColumn("CUSTOMER");
        addColumn("SALESMAN");
    }
    
    public void insertNewDataFromList(){
        try{
            NumberFormat nfDiskon = NumberFormat.getInstance();
            nfDiskon.setMaximumFractionDigits(2);
            
            for (int i=0; i<list.size(); i++){
                Tangkaph domain = new Tangkaph();
                domain = list.get(0);
                
                
                //CREATE AND FILL ENTITY
                addRow(new Object[0]);
//                setValueAt(domain.getOrderno(), i, 0);
//                setValueAt(domain.getOrderdate(), i, 1);
//                setValueAt(domain.getInvoiceno(), i, 2);
//                setValueAt(domain.getInvoicedate(), i, 3);
//                setValueAt(domain.getTunaikredit(), i, 4);
//                setValueAt(domain.getAmountafterppn(), i, 5);
//                
//                setValueAt(nfDiskon.format(domain.getDisc1()) + "+" + nfDiskon.format(domain.getDisc()), i, 6);
//                setValueAt(domain.getDisc1rpafterppn() + domain.getDiscrpafterppn(), i, 7);
//                setValueAt(domain.getAmountafterdiscafterppn(), i, 8);
//                
//                setValueAt(domain.getPrintcounter(), i, 9);
//                
//                setValueAt(domain.getFcustomerBean().getCustno() 
//                        + " " + domain.getFcustomerBean().getCustname(), i, 10);
//                setValueAt(domain.getFsalesmanBean().getSpcode()
//                        + " " + domain.getFsalesmanBean().getSpname(), i, 11);
                
            }
        }catch(Exception ex){
//            ex.printStackTrace();
        }
    }
    public void insertSingleRow(){
        try{
            Tangkaph domain = new Tangkaph();
            //Reset Item Before Add:: Agar Bisa Dihitung Jumlahnya
//            FtSalesdPK id = new FtSalesdPK();
//            id.setId(ftSalesdBean.getId().getId());
//            id.setRefno(ftSaleshBean.getRefno());
//            id.setId((long) 0);
//            id.setRefno((long) 0);
            //## KADANG NULL ##
//            if (id.getRefno()==null){
//                    id.setRefno((long) 0);
//            }
//            id.setFreegood(false);
//            domain.setId(id);
//            domain.setPromo(false);

//            domain.setOrderno("");
//            domain.setInvoiceno("");
//            domain.setNofakturpajak("");
//            domain.setRecapno("");
//
//            domain.setFsalesmanBean(null);
//            domain.setFwarehouseBean(null);
//            domain.setFcustomerBean(null);
//            
//            domain.setOrderdate(new Date());
//            domain.setInvoicedate(new Date());
//            domain.setDuedate(new Date());
//            domain.setTipejual("SHOP");
////            domain.setFexpedisiBean(null);
//
//            domain.setTunaikredit("T");
//            domain.setTop(0);
//
//            domain.setAmount(0.0);
           
            
            list.add(domain);
            
            //The Table
            int newPosition = list.size();
            addRow(new Object[0]);
            setValueAt("", newPosition, 0);
            setValueAt("", newPosition, 1);
            setValueAt("", newPosition, 2);
            setValueAt("", newPosition, 3);
            setValueAt("", newPosition, 4);
            setValueAt("", newPosition, 5);
            setValueAt("", newPosition, 6);
            setValueAt("", newPosition, 7);
            setValueAt("", newPosition, 8);
            setValueAt("", newPosition, 9);
            setValueAt("", newPosition, 10);
            setValueAt("", newPosition, 11);
            
            
        }catch(Exception ex){}
        
    }
    public void updateValue(Tangkaph domain, int row){
        NumberFormat nfDiskon = NumberFormat.getInstance();
        nfDiskon.setMaximumFractionDigits(2);
        
        Tangkaph newDomain = new Tangkaph();
//        newDomain = hds.getFillFtSalesh();
        newDomain = domain;
        
        //1. Update List
        list.set(row, newDomain);
        
        //2. Update Object //TABLE MODEL
        //CREATE AND FILL ENTITY
//        setValueAt(newDomain.getOrderno(), row, 0);
//        setValueAt(newDomain.getOrderdate(), row, 1);
//        setValueAt(newDomain.getInvoiceno(), row, 2);
//        setValueAt(newDomain.getInvoicedate(), row, 3);
//        setValueAt(newDomain.getTunaikredit(), row, 4);
//        setValueAt(newDomain.getAmountafterppn(), row, 5);
//
//        setValueAt(nfDiskon.format(newDomain.getDisc1()) + "+" + nfDiskon.format(newDomain.getDisc()), row, 6);
//        setValueAt(newDomain.getDisc1rpafterppn() + newDomain.getDiscrpafterppn(), row, 7);
//
//        setValueAt(newDomain.getAmountafterdiscafterppn(), row, 8);
//        setValueAt(newDomain.getPrintcounter(), row, 9);
//
//        setValueAt(newDomain.getFcustomerBean().getCustno() 
//                + " " + newDomain.getFcustomerBean().getCustname(), row, 10);
//        setValueAt(newDomain.getFsalesmanBean().getSpcode()
//                + " " + newDomain.getFsalesmanBean().getSpname(), row, 11);

    }
    
}

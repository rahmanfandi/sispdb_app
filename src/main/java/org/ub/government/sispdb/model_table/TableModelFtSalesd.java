/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model_table;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.ub.government.sispdb.model.TangkapItem;

/**
 *
 * @author yhawin
 */
public class TableModelFtSalesd extends DefaultTableModel{
    int nomorUrut = 0;
    List<TangkapItem> list = new ArrayList<>();
    public TableModelFtSalesd(){
         addNewColumn();
    }
    public TableModelFtSalesd(List<TangkapItem> list){
        //BIAR SELAU URUT nomorurut
//        try{ //Kalau mengalami salah compare ya ndak usah di compare
//            Collections.sort(list, new Comparator<TangkapItem>() {
//                @Override
//                public int compare(TangkapItem o1, TangkapItem o2) {
//                    if (o1.getNourut()==null) o1.setNourut(0);
//                    if (o2.getNourut()==null) o2.setNourut(0);
//                    
//                    return o1.getNourut().compareTo(o2.getNourut());
//                }
//            });
//        }catch(Exception ex){}
        addNewColumn();
        //Karena Pasti Error saat null
        try{
            this.list = list;
            insertNewDataFromList();
            try{
                nomorUrut = list.size();
            }catch(Exception ex){}
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public Class<?> getColumnClass(int column){
        switch (column){
            case 0: //Kode
                return String.class;
            case 1: //Nama
                return String.class;
            case 2: //Qty
                return int.class;
            case 3: //Harga
                return double.class;
            case 4: //Diskon1 persen
                return double.class;
            case 5: //Diskon2plus persen
                return double.class;
            case 6: //Total Diskon
                return double.class;
            case 7: //Sub Total
                return double.class;
            default:
                return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) { //Pcode
            return true;
        } else if (col==1){//Pname
            return false;
        } else if (col==2){//Qty
            return false;
        } else if (col==3){// Harga Kadang Boleh
            return true;
        } else if (col==4){//Disc1
            return true;
        } else if (col==5){//Disc2+
            return true;
        } else {
            return false;
        }
    }    
    public TangkapItem getValueAt(int rowIndex){
        return list.get(rowIndex);
    }

    public void addNewColumn(){
        addColumn("PCODE");
        addColumn("PRODUCT NAME");
        addColumn("Qty PCS");
        addColumn("SPRICE+PPN");
        addColumn("DISC1");
        addColumn("DISC+");
        addColumn("DISC RP");
        addColumn("SUBTOTAL");
        addColumn("QUANTITY");
    }
    
    public void insertNewDataFromList(){
        try{
            for (int i=0; i<list.size(); i++){
                TangkapItem domain = new TangkapItem();
                domain = list.get(0);
                
                
                //CREATE AND FILL ENTITY
                addRow(new Object[0]);
//                setValueAt(domain.getFproductBean().getPcode(), i, 0);
//                setValueAt(domain.getFproductBean().getPname() + " " + domain.getFproductBean().getPackaging(), i, 1);
//                setValueAt(domain.getQty(), i, 2);
//                setValueAt(domain.getSpriceKecAfterppn(), i, 3);
//                setValueAt(domain.getDisc1(), i, 4);
//                setValueAt(domain.getDisc2(), i, 5);
//
//                setValueAt(domain.getDisc1rpafterppn() + domain.getDisc2rpafterppn(), i, 6);
//                setValueAt(domain.getSubtotalafterdisc2afterppn(), i, 7);
//                
//                KonversiProductAndStock kps = new KonversiProductAndStockImpl(domain.getQty(), domain.getFproductBean());
//                setValueAt(kps.getBesSedKecStringUomHurufBesar(), i, 8);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
 public void insertNewDataFromList(List<TangkapItem> newListFtSalesd){
        try{
            list.addAll(newListFtSalesd);
            
            for (int i=0; i<newListFtSalesd.size(); i++){
                TangkapItem domain = new TangkapItem();
                domain = newListFtSalesd.get(0);
                
                
                //CREATE AND FILL ENTITY
                addRow(new Object[0]);
//                setValueAt(domain.getFproductBean().getPcode(), i, 0);
//                setValueAt(domain.getFproductBean().getPname() + " " + domain.getFproductBean().getPackaging(), i, 1);
//                setValueAt(domain.getQty(), i, 2);
//                setValueAt(domain.getSpriceKecAfterppn(), i, 3);
//                setValueAt(domain.getDisc1(), i, 4);
//                setValueAt(domain.getDisc2(), i, 5);
//
//                setValueAt(domain.getDisc1rpafterppn() + domain.getDisc2rpafterppn(), i, 6);
//                setValueAt(domain.getSubtotalafterdisc2afterppn(), i, 7);
//                
//                KonversiProductAndStock kps = new KonversiProductAndStockImpl(domain.getQty(), domain.getFproductBean());
//                setValueAt(kps.getBesSedKecStringUomHurufBesar(), i, 8);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }    
    public void insertSingleRow(){
        try{
            
            TangkapItem domain = new TangkapItem();
            //Reset Item Before Add:: Agar Bisa Dihitung Jumlahnya
//            FtSalesdPK id = new FtSalesdPK();
//            id.setId(ftSalesdBean.getId().getId());
//            id.setRefno(ftSaleshBean.getRefno());
            
//            id.setId((long) 0);
//            id.setRefno((long) 0);

            nomorUrut++;
//            domain.setNourut(nomorUrut);


            //## KADANG NULL ##
//            if (id.getRefno()==null){
//                    id.setRefno((long) 0);
//            }
//            id.setFreegood(false);
//            domain.setId(id);
//            domain.setPromo(false);
//
//            domain.setFproductBean(new FProduct());
//            domain.setFtsaleshBean(new FtSalesh());
//
//            domain.setDisc1(0.0);
//            domain.setDisc1rp(0.0);
//            domain.setDisc2(0.0);
//            domain.setDisc2rp(0.0);
//
//            domain.setNourut(0);
//            domain.setSprice(0.0);
//            domain.setSpriceSed(0.0);
//            domain.setSpriceKec(0.0);
//            domain.setSpriceafterppn(0.0);
//            domain.setSpriceSedAfterppn(0.0);
//            domain.setSpriceKecAfterppn(0.0);
//
//            domain.setQty(0);
//            domain.setQty1(0);
//            domain.setQty2(0);
//            domain.setQty3(0);
//            domain.setSubtotal(0.0);
//            domain.setSubtotalafterppn(0.0);
//
//            domain.setTprb(0.0);
//            domain.setTprudisc(0.0);
//            domain.setTprucashback(0.0);
            
            //biar tidak morat-marit
//            try{
//                domain.setNourut(list.size()+1);
//            }catch(Exception ex){}
            
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
        }catch(Exception ex){}
        
    }
    public void updateValue(TangkapItem domain, int row){
        TangkapItem newDomain = new TangkapItem();
        newDomain = domain;
        
        //1. Update List
        list.set(row, newDomain);
        
        //2. Update Object //TABLE MODEL
        //CREATE AND FILL ENTITY
//        setValueAt(newDomain.getFproductBean().getPcode(), row, 0);
//        setValueAt(newDomain.getFproductBean().getPname() + " " + domain.getFproductBean().getPackaging(), row, 1);
//        setValueAt(newDomain.getQty(), row, 2);
//        setValueAt(newDomain.getSpriceKecAfterppn(), row, 3);
//        setValueAt(newDomain.getDisc1(), row, 4);
//        setValueAt(newDomain.getDisc2(), row, 5);
//
//        setValueAt(newDomain.getDisc1rpafterppn() + newDomain.getDisc2rpafterppn(), row, 6);
//        setValueAt(newDomain.getSubtotalafterdisc2afterppn(), row, 7);
//
//        KonversiProductAndStock kps = new KonversiProductAndStockImpl(domain.getQty(), domain.getFproductBean());
//        setValueAt(kps.getBesSedKecStringUomHurufBesar(), row, 8);

    }
    public void removeRowItem(int row){
        fireTableRowsDeleted(row, row);
        list.remove(row);
        removeRow(row);
    }

    public List<TangkapItem> getList() {
        return list;
    }

    public void setList(List<TangkapItem> list) {
        this.list = list;
    }
    
    
}

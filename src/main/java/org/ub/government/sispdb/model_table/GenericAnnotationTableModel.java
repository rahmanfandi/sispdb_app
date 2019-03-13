/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ub.government.sispdb.model_table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yhawin
 */
public class GenericAnnotationTableModel<T> extends AbstractTableModel{
    private List<T> list;
    private List<Field> fields = new ArrayList<Field>();
    private List<Column> columns = new ArrayList<Column>();
    
    public GenericAnnotationTableModel(List<T> list, Class<T> class1) {
        this.list = list;
        for (Field field : class1.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            
            if (column != null) {
                fields.add(field);
                columns.add(column);
            }
        }
        //for (int i=0;i<list.size();i++){
            //listKode.add(getValueAt(i, 0).toString());
            //System.out.println(listKode);
        //}
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return fields.size();
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column).name();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       try {
            Field field = fields.get(columnIndex);
            field.setAccessible(true);
            return field.get(list.get(rowIndex));
       } catch (IllegalArgumentException ex){
           return null;
       } catch(IllegalAccessException ex){
            return null;
       }

    }
     /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

//**** TAMBAHANKU ****
    public synchronized void add(List<T> list) {
        for (T o : list) {
            list.add(o);
        }
        fireTableDataChanged();
    }
    public synchronized void add(List<T> list, Class<T> class1) {
        for (Field field : class1.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                fields.add(field);
                columns.add(column);
            }
        }
    }

    public synchronized T set(int index, T element) {
        T o = list.set(index, element);
        fireTableRowsUpdated(index, index);
        return o;
    }

    public synchronized void removeAllElements() {
        list.clear();
        fireTableDataChanged();
    }

    public synchronized T remove(int index) {
        T o = list.remove(index);
        fireTableRowsDeleted(index, index);
        return o;
    }

    public synchronized T get(int index) {
        return  list.get(index);
    }

    public synchronized boolean add(T e) {

        int index = list.size();
        boolean b = list.add(e);
        fireTableRowsInserted(index, index);
        return b;
    }
    
    public int getValueAt(T element){
        return list.indexOf(element);
    }

}

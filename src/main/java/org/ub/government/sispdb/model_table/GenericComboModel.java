/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model_table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author yhawin
 */
public class GenericComboModel<T> extends AbstractListModel<T> implements ComboBoxModel<T>{
    private List<T> list;
    private List<Field> fields = new ArrayList<Field>();
    private List<Column> columns = new ArrayList<Column>();
    
    public GenericComboModel(List<T> list, Class<T> class1) {
        this.list = list;
        for (Field field : class1.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            
            if (column != null) {
                fields.add(field);
                columns.add(column);
            }
        }
    
    }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public T getElementAt(int index) {
        return null;
    }

    @Override
    public void setSelectedItem(Object anItem) {
    }

    @Override
    public Object getSelectedItem() {
        return null;
    }
    
}

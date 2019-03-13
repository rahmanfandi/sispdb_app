package org.ub.government.sispdb.master.ikan_subkelas;

import javax.swing.event.ListSelectionEvent;

import org.ub.government.sispdb.master.ikan_subkelas.IkanSubKelasView.OnViewListener;
import org.ub.government.sispdb.model.IkanSubKelas;
import org.ub.government.sispdb.model_enum.EnumStatusOperasiForm;

public class IkanSubKelasController implements OnViewListener{
	protected IkanSubKelasModel model;
	protected IkanSubKelasView view;

	public IkanSubKelasController(IkanSubKelasView view) {
		model = new IkanSubKelasModel();
		this.view = view;
	}

	@Override
	public void aksiBtnReloadFromDb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aksiBtnNewForm() {
		model.resetNewObject_Header();
		
		view.setFormButtonAndTextState();
		model.statusOperasiForm = EnumStatusOperasiForm.ADD_NEW;
		System.out.println("Status operasi form: " + model.statusOperasiForm);
	}

	@Override
	public void aksiBtnEditForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aksiBtnDeleteForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aksiBtnSaveForm() {
		// TODO Auto-generated method stub
		view.writeBinderHeader();
		
//		model.ikanSubKelasJpaService.updateObject(model.itemHeader);
		model.saveToDatabase();

		//Update View
		view.updateDataGrid1();
		
		view.setFormButtonAndTextState();
		model.statusOperasiForm = EnumStatusOperasiForm.OPEN;

	}

	@Override
	public void aksiBtnCancelForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aksiBtnCloseForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aksiPrintForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aksiTable1_ListSelection(ListSelectionEvent event) {
		try {
			if (event !=null) {
		        try{
                    int selectedRow = view.getjTable1().getSelectedRow();
                    IkanSubKelas domainBean = new IkanSubKelas();
                    domainBean = (IkanSubKelas) model.tableModelHeader.get(selectedRow);
                    model.itemHeader = domainBean;
                    
                    view.readBinderHeader();
                    
		        }catch(Exception ex){}
			} //end if
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

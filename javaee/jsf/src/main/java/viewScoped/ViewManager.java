package viewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ViewManager implements Serializable {
	private static final long serialVersionUID = 1L;
	ArrayList<Property> cacheList = new ArrayList<Property>();
	private Property item = new Property();

	public ViewManager() {
	}

	private boolean edit;

	public void add() {
		cacheList.add(item);
		item = new Property();

	}

	public void edit(Property item) {
		this.item = item;
		edit = true;
	}

	public void save() {
		item = new Property();
		edit = false;
	}

	public void delete(Property item) {
		cacheList.remove(item);
	}

	public List<Property> getCacheList() {
		return cacheList;
	}

	public Property getItem() {
		return item;
	}

	public boolean isEdit() {
		return edit;
	}
	
}

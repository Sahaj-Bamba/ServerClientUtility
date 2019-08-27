package Request;

import Constant.Request;

import java.io.Serializable;
import java.util.ArrayList;

public class GroupList implements Serializable {

	private ArrayList<String> groups;

	public GroupList() {
		this.groups = new ArrayList<String>();
	}

	public void add(String g){
		groups.add(g);
	}

	public void remove(String g){
		groups.remove(g);
	}

	public ArrayList<String> getGroups() {
		return groups;
	}

	@Override
	public String toString() {
		return String.valueOf(Request.GROUPLIST);
	}

}

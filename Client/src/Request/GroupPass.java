package Request;

import Constant.Request;

public class GroupPass {

	private String password;
	private String groupName;

	public GroupPass(String password, String groupName){
		this.password = password;
		this.groupName = groupName;
	}

	public String getPassword() {
		return password;
	}

	public String getGroupName() {
		return groupName;
	}

	@Override
	public String toString() {
		return String.valueOf(Request.GROUPPASS);
	}

}

package Request;

import Constant.Request;

public class WhoIAm {

	private String name;

	public WhoIAm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.valueOf(Request.WHOIAM);
	}

}

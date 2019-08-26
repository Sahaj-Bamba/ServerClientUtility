package Request;

public class Response {

	private int status;
	private String errorMessage;

	public Response(int status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

}

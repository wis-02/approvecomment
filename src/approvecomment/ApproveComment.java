package approvecomment;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface ApproveComment {
	
	
	@WebMethod
	String filter(String comment, String username);
	
	@WebMethod
	int getOccurences(String username);
}

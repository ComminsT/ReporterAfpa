package verif;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.Group_list;

public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


}
public static Boolean usercheck(HttpServletRequest request,int grp) {
	HttpSession session = request.getSession(true);
	ArrayList<Group_list> group_list =(ArrayList<Group_list>)session.getAttribute("grouplist");
	Boolean allowed=false;
	for(Group_list glist : group_list) {
		if(glist.getId_groupe()==grp) {
			allowed=true;
		}
	}	
return allowed;
	}
	}

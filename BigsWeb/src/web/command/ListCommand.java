package web.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ItemDao;
import web.dto.ItemDto;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ItemDao dao = new ItemDao();
		ArrayList<ItemDto> dtos = dao.list();
		request.setAttribute("list", dtos);

	}

}

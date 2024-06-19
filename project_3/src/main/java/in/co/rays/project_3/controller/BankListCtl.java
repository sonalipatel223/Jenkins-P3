
package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.model.BankModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.model.UserModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/BankListCtl" })
public class BankListCtl extends BaseCtl {
	protected void preload(HttpServletRequest request) {
		BankModelInt model = ModelFactory.getInstance().getBankModel();
		try {
			List list1 = model.list();
			/*
			 * String key = null; String val = null; Iterator<BankDTO>it=list1.iterator();
			 * while(it.hasNext()) { BankDTO dto=it.next(); key = ((BankDTO) it).getKey();
			 * val = ((BankDTO) it).getValue();
			 * 
			 * System.out.println("priload========>>>"+key);
			 * System.out.println("priload value======>>>>>>>"+val);
			 * 
			 * }
			 */
			request.setAttribute("camount", list1);
		} catch (Exception e) {

		}
	}

	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {
		BankDTO dto = new BankDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setcName(DataUtility.getString(request.getParameter("cName")));

		System.out.println("bank list populate==============>>>>>>>>>>>>>> " + request.getParameter("cName"));

		dto.setAccount(DataUtility.getString(request.getParameter("account")));

		dto.setAmount(DataUtility.getString(request.getParameter("amount")));

		populateBean(dto, request);
		return dto;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("goget chaliiii.....");
		List list;
		List next;
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));
		BankDTO dto = (BankDTO) populateDTO(req);
		BankModelInt model = ModelFactory.getInstance().getBankModel();
		String ids = req.getParameter("id");
		if (ids != null) {
			System.out.println("delete chali.....");
			dto.setId(DataUtility.getLong(ids));
			model.delete(dto);
			ServletUtility.setSuccessMessage("Data Deleted Successfully", req);
			ServletUtility.redirect(ORSView.BANK_LIST_CTL, req, resp);
			return;
		}

		try {
			list = model.search(dto, pageNo, pageSize);

			ArrayList<BankDTO> a = (ArrayList<BankDTO>) list;

			next = model.search(dto, pageNo + 1, pageSize);
			ServletUtility.setList(list, req);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", req);
			}
			if (next == null || next.size() == 0) {
				req.setAttribute("nextListSize", 0);

			} else {
				req.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, req);
			ServletUtility.setPageNo(pageNo, req);
			ServletUtility.setPageSize(pageSize, req);
			ServletUtility.forward(getView(), req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List list = null;
		List next = null;
		int pageNo = DataUtility.getInt(req.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(req.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		BankDTO dto = (BankDTO) populateDTO(req);
		String op = DataUtility.getString(req.getParameter("operation"));
		System.out.println("op---->" + op);

		String[] ids = req.getParameterValues("ids");
		BankModelInt model = ModelFactory.getInstance().getBankModel();
		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					System.out.println("data searched hua");
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.BANK_CTL, req, resp);
				return;
			} else if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.BANK_LIST_CTL, req, resp);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					BankDTO deletedto = new BankDTO();
					for (String id : ids) {
						System.out.println("id" + id);
						deletedto.setId(DataUtility.getLong(id));
						// deletedto = populateDTO(request);
						model.delete(deletedto);
						ServletUtility.setSuccessMessage("Data Deleted Successfully", req);
					}
				} else {
					ServletUtility.setErrorMessage("Select at least one record", req);
				}
			}
			if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.BANK_LIST_CTL, req, resp);
				return;
			}
			dto = (BankDTO) populateDTO(req);
			System.out.println("y yyyyyyyyyy" + dto.getcName());

			list = model.search(dto, pageNo, pageSize);

			ServletUtility.setDto(dto, req);
			next = model.search(dto, pageNo + 1, pageSize);

			ServletUtility.setList(list, req);
			ServletUtility.setList(list, req);
			if (list == null || list.size() == 0) {
				if (!OP_DELETE.equalsIgnoreCase(op)) {
					ServletUtility.setErrorMessage("No record found ", req);
				}
			}
			if (next == null || next.size() == 0) {
				req.setAttribute("nextListSize", 0);

			} else {
				req.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, req);
			ServletUtility.setPageNo(pageNo, req);
			ServletUtility.setPageSize(pageSize, req);
			ServletUtility.forward(getView(), req, resp);

		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String getView() {
		return ORSView.BANK_LIST_VIEW;
	}
}

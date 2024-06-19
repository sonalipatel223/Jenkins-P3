package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.model.BankModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/BankCtl" })
public class BankCtl extends BaseCtl {
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("cName"))) {
			request.setAttribute("cName", PropertyReader.getValue("error.require", "name"));
			pass = false;
		}else if (!DataValidator.isName(request.getParameter("cName"))) {
			request.setAttribute("cName",  "Name must contain alphabets only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("account"))) {
			request.setAttribute("account", PropertyReader.getValue("error.require", "account"));
			pass = false;
		}else if (!DataValidator.isLong(request.getParameter("account"))) {
			request.setAttribute("account", "account must contain number only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("amount"))) {
			request.setAttribute("amount", PropertyReader.getValue("error.require", "amount"));
			pass = false;
		}else if (!DataValidator.isInteger(request.getParameter("amount"))) {
			request.setAttribute("amount", "amount must contain number only");
			pass = false;
		}
		
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		BankDTO dto=new BankDTO();
		System.out.println(request.getParameter("mobileNo"));
		
		dto.setcName(request.getParameter("cName"));
		System.out.println(request.getParameter("cName"));
		System.out.println(request.getParameter("account"));
		System.out.println(request.getParameter("amount"));
		
		dto.setAccount(request.getParameter("account"));
		dto.setAmount(request.getParameter("amount"));
		
		
		populateBean(dto,request);
		return dto;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 long id=DataUtility.getLong(req.getParameter("id"));
		System.out.println("bank ctl ki doget chaliii....!!!!!!");
		BankModelInt model=ModelFactory.getInstance().getBankModel();
		
		if(id>0) {
			BankDTO dto;
			dto=model.finfByPk(id);
			ServletUtility.setDto(dto, req);
			
		}
		ServletUtility.forward(getView(), req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost chali......");
		String op=req.getParameter("operation");
		long id=DataUtility.getLong(req.getParameter("id"));
		System.out.println(op);
		BankModelInt model=ModelFactory.getInstance().getBankModel();
		//BankDTO dto=new BankDTO();
		  if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
			 BankDTO dto=(BankDTO) populateDTO(req); 
			 
			if(id>0) {
				dto.setId(id);
				model.update(dto);
				ServletUtility.setSuccessMessage("Record Successfully Update!!!", req);
				ServletUtility.setDto(dto, req);
				
				
			}else {
				model.save(dto);
				ServletUtility.setSuccessMessage("Record Successfully Saved", req);
				ServletUtility.setDto(dto, req);
			}
			
			
		}else if(OP_RESET.equalsIgnoreCase(op)) {
			System.out.println("reset challi....");
			ServletUtility.redirect(ORSView.BANK_CTL, req, resp);
			return;
		}else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.BANK_LIST_CTL, req, resp);
			return;

		}
		ServletUtility.forward(getView(), req, resp);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.BANK_VIEW;
	}

}

package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.PaymentDTO;
import in.co.rays.project_3.model.BankModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.PaymentInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/PaymentCtl" })
public class PaymentCtl extends BaseCtl {

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("pName"))) {
			request.setAttribute("pName", PropertyReader.getValue("error.require", "name"));
			pass = false;
		}else if (!DataValidator.isName(request.getParameter("pName"))) {
			request.setAttribute("pName",  "Name must contain alphabets only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getValue("error.require", "type"));
			pass = false;
		}else if (!DataValidator.isName(request.getParameter("type"))) {
			request.setAttribute("type", "account must contain alphabets only");
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
		PaymentDTO dto=new PaymentDTO();
		
		dto.setName(request.getParameter("pName"));
		
		
		dto.setType(request.getParameter("type"));
		dto.setAmount(DataUtility.getInt(request.getParameter("amount")));
		
		
		populateBean(dto,request);
		return dto;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 long id=DataUtility.getLong(req.getParameter("id"));
		System.out.println("bank ctl ki doget chaliii....!!!!!!");
		PaymentInt model=ModelFactory.getInstance().getPaymentModel();
		
		if(id>0) {
			PaymentDTO dto;
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
		PaymentInt model=ModelFactory.getInstance().getPaymentModel();
		//PaymentDTO dto=new PaymentDTO();
		
		  if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
			 PaymentDTO dto=(PaymentDTO) populateDTO(req); 
			if(id>0) {
				dto.setId(id);
				model.update(dto);
				
				ServletUtility.setDto(dto, req);
				ServletUtility.setSuccessMessage("Record Successfully Update..", req);
				
				
			}else {
				model.save(dto);
				ServletUtility.setSuccessMessage("Record Successfully Saved", req);
				ServletUtility.setDto(dto, req);
			}
			
			
		}else if(OP_RESET.equalsIgnoreCase(op)) {
			System.out.println("reset challi....");
			ServletUtility.redirect(ORSView.PAYMENT_CTL, req, resp);
			return;
		}else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.PAYMENT_LIST_CTL, req, resp);
			return;

		}
		ServletUtility.forward(getView(), req, resp);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PAYMENT_VIEW;
	}

}

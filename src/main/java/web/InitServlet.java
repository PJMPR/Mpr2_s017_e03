package web;

import dao.TemporaryCurrencyEnumHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author L on 21.12.2016.
 */
@WebServlet("/initServlet")
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {

        TemporaryCurrencyEnumHelper temporaryCurrencyEnumHelper = new TemporaryCurrencyEnumHelper();
        temporaryCurrencyEnumHelper.insertCurrencyEnums();
    }


}

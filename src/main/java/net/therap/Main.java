package net.therap;

import net.therap.domain.Category;
import net.therap.domain.Stock;
import net.therap.domain.StockCategory;
import net.therap.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 5/14/12
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public void saveStock() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Stock stock = new Stock();
            stock.setStockCode("7052");
            stock.setStockName("PADINI");

            Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
            //new category, need save to get the id first
            session.save(category1);

            StockCategory stockCategory = new StockCategory();
            stockCategory.setStock(stock);
            stockCategory.setCategory(category1);
            stockCategory.setCreatedDate(new Date()); //extra column
            stockCategory.setCreatedBy("system"); //extra column

            stock.getStockCategories().add(stockCategory);

            session.save(stock);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }

}

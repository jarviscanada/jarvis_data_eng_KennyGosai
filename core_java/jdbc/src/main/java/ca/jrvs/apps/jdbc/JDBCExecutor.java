package ca.jrvs.apps.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {
    final Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        JDBCExecutor jdbcExecutor = new JDBCExecutor();
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "postgres", "password");
        try{
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("John");
            customer.setLastName("Adams");
            customer.setEmail("jadams.wh.gov");
            customer.setAddress("1234 Main St");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setPhone("(555) 555-9845");
            customer.setZipCode("01234");

            Customer dbCustomer = customerDAO.create(customer);
            jdbcExecutor.logger.info(dbCustomer.toString());
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            jdbcExecutor.logger.info(dbCustomer.toString());
            dbCustomer.setEmail("john.adams@wh.gov");
            dbCustomer = customerDAO.update(dbCustomer);
            jdbcExecutor.logger.info(dbCustomer.toString());
            customerDAO.delete(dbCustomer.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
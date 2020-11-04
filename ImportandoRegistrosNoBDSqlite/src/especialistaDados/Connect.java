package especialistaDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
	  private Connection conecta;
	    public Connection getConnection(){
	        //avisando que o banco q vou utilizar é sqlite
	        try {
	            DriverManager.registerDriver(new org.sqlite.JDBC());
	        } catch (SQLException e) {
	            System.err.println("Problemas na hora de registrar driver");
	            System.err.println("Saindo...");
	            System.exit(1);
	        }

	    //Conectando no BD
	    try {
	        conecta =  DriverManager.getConnection("jdbc:sqlite:estoque.sqlite");


	    } catch (SQLException e) {
	        System.out.println("Impossivel se conectar no BD");
	        System.exit(1);
	    }
	    return conecta;
	}
}


package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BouquetDao;
import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;
import model.entity.boquet.Event;
import model.entity.boquet.Freshness;
import model.entity.boquet.Size;
import model.entity.boquet.StemLength;
import model.entity.boquet.builder.BouquetBuilder;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public class BouquetDaoUsingMySqlJdbc implements BouquetDao {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/flower_shop?"
	    + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";

    public static final String SELECT_ALL_BOUQUETS = "select bouquets.*, flowers.*\r\n" +
	    "    from bouquets\r\n" +
	    "    join bouquets_flowers\r\n" +
	    "    on bouquets_flowers.id_bouquets = bouquets.id\r\n" +
	    "    join flowers\r\n" +
	    "    on flowers.id = bouquets_flowers.id_flowers;";

    static {
	try {
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	} catch (SQLException e) {
	    throw new RuntimeException("Can't register driver!");
	}
    }

    @Override
    public List<Bouquet> getAll() throws StorageSystemException, IncompleteBouquetInitialization {
	List<Bouquet> bouquets = new ArrayList<>();

	try (Connection connection = getConnection();
		PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL_BOUQUETS);
		ResultSet resultSet = pStatement.executeQuery()) {
	    while (resultSet.next()) {
		Bouquet bouquet = new BouquetBuilder()
			.setName("name")
			.setEvent(Event.valueOf(resultSet.getString("event")))
			.setFreshness(Freshness.valueOf(resultSet.getString("freshness")))
			.setSize(Size.valueOf(resultSet.getString("size")))
			.setStemLength(StemLength.valueOf(resultSet.getString("stem_length")))
			.build();
		bouquets.add(bouquet);
	    }
	} catch (SQLException e) {
	    throw new StorageSystemException();
	}

	return bouquets;
    }

    private Connection getConnection() throws StorageSystemException {
	try {
	    return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
	} catch (SQLException e) {
	    throw new StorageSystemException("Cant create connection!");
	}
    }
}

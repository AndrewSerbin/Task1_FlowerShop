package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BouquetDao;
import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;
import model.entity.boquet.Event;
import model.entity.boquet.Freshness;
import model.entity.boquet.Size;
import model.entity.boquet.StemLength;
import model.entity.boquet.builder.BouquetBuilder;
import model.entity.boquet.component.accessory.Accessory;
import model.entity.boquet.component.accessory.AccessoryType;
import model.entity.boquet.component.plant.Flower;
import model.entity.boquet.component.plant.FlowerType;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public class BouquetDaoUsingMySqlJdbc implements BouquetDao {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/flower_shop?"
	    + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";

    public static final String SELECT_ALL_BOUQUETS_AND_FLOWERS = "select bouquets.*, flowers.name as flower_name, " +
	    "flowers.price as flower_price, flowers.type as flower_type\r\n" +
	    "from bouquets\r\n" +
	    "join bouquets_flowers\r\n" +
	    "on bouquets_flowers.id_bouquets = bouquets.id\r\n" +
	    "join flowers\r\n" +
	    "on flowers.id = bouquets_flowers.id_flowers;";
    public static final String SELECT_ALL_BOUQUETS_AND_ACCESSORIES = "select bouquets.*, accessories.name as accessory_name," +
	    "accessories.price as accessory_price, accessories.type as accessory_type\r\n" +
	    "from bouquets\r\n" +
	    "join bouquets_accessories\r\n" +
	    "on bouquets_accessories.id_bouquets = bouquets.id\r\n" +
	    "join accessories\r\n" +
	    "on accessories.id = bouquets_accessories.id_accessories;";

    static {
	try {
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	} catch (SQLException e) {
	    throw new RuntimeException("Can't register driver!");
	}
    }

    @Override
    public List<Bouquet> getAll() throws StorageSystemException, IncompleteBouquetInitialization {
	Map<Integer, BouquetBuilder> builders = new HashMap<>();

	getBouquetsAndFlowers(builders);
	getBouquetsAndAccessories(builders);

	return getBouquetsFromBuildersMap(builders);
    }

    private void getBouquetsAndFlowers(Map<Integer, BouquetBuilder> builders) throws StorageSystemException {
	try (Connection connection = getConnection();
		PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL_BOUQUETS_AND_FLOWERS);
		ResultSet resultSet = pStatement.executeQuery()) {
	    BouquetBuilder builder = new BouquetBuilder();
	    while (resultSet.next()) {
		if (!builders.containsKey(resultSet.getInt("id"))) {
		    builder = new BouquetBuilder()
			    .setName(resultSet.getString("name"))
			    .setEvent(Event.valueOf(resultSet.getString("event")))
			    .setFreshness(Freshness.valueOf(resultSet.getString("freshness")))
			    .setSize(Size.valueOf(resultSet.getString("size")))
			    .setStemLength(StemLength.valueOf(resultSet.getString("stem_length")))
			    .addFlower(new Flower(resultSet.getString("flower_name"), resultSet.getInt("flower_price"),
				    FlowerType.valueOf(resultSet.getString("flower_type"))));
		    builders.put(resultSet.getInt("id"), builder);
		} else {
		    builders.get(resultSet.getInt("id"))
			    .addFlower(new Flower(resultSet.getString("flower_name"), resultSet.getInt("flower_price"),
				    FlowerType.valueOf(resultSet.getString("flower_type"))));
		}
	    }
	} catch (SQLException e) {
	    throw new StorageSystemException();
	}
    }

    private void getBouquetsAndAccessories(Map<Integer, BouquetBuilder> builders) throws StorageSystemException {
	try (Connection connection = getConnection();
		PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL_BOUQUETS_AND_ACCESSORIES);
		ResultSet resultSet = pStatement.executeQuery()) {
	    BouquetBuilder builder = new BouquetBuilder();
	    while (resultSet.next()) {
		if (!builders.containsKey(resultSet.getInt("id"))) {
		    builder = new BouquetBuilder()
			    .setName(resultSet.getString("name"))
			    .setEvent(Event.valueOf(resultSet.getString("event")))
			    .setFreshness(Freshness.valueOf(resultSet.getString("freshness")))
			    .setSize(Size.valueOf(resultSet.getString("size")))
			    .setStemLength(StemLength.valueOf(resultSet.getString("stem_length")))
			    .addAccessory(new Accessory(resultSet.getString("accessory_name"), resultSet.getInt("accessory_price"),
				    AccessoryType.valueOf(resultSet.getString("accessory_type"))));
		    builders.put(resultSet.getInt("id"), builder);
		} else {
		    builders.get(resultSet.getInt("id"))
			    .addAccessory(new Accessory(resultSet.getString("accessory_name"), resultSet.getInt("accessory_price"),
				    AccessoryType.valueOf(resultSet.getString("accessory_type"))));
		}
	    }
	} catch (SQLException e) {
	    throw new StorageSystemException();
	}
    }

    private List<Bouquet> getBouquetsFromBuildersMap(Map<Integer, BouquetBuilder> builders) throws IncompleteBouquetInitialization {
	List<Bouquet> bouquets = new ArrayList<>();
	for (BouquetBuilder builder : builders.values()) {
	    bouquets.add(builder.build());
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

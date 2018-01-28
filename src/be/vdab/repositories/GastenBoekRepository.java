package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import be.vdab.entities.GastenBoekEntry;

public class GastenBoekRepository extends AbstractRepository {
	private final static String FIND_ALL = 
		"select id, naam, datumtijd, bericht from gastenboek order by id desc";
	private final static String CREATE = 
		"insert into gastenboek(naam, datumtijd, bericht)"
		+ "values (?,?,?)";
	public List<GastenBoekEntry> findAll() {
		try (Connection connection = dataSource.getConnection();
			  Statement statement = connection.createStatement()) {
			List<GastenBoekEntry> entries = new ArrayList<>();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					entries.add(resultSetRijNaarGastenBoekEntry(resultSet));
				}
			}
			connection.commit();
			return entries;
		} catch (SQLException ex) {
			throw new RepositoryException(ex);
		}
	}
	public void create(GastenBoekEntry gastenBoekEntry) {
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement statement = connection.prepareStatement(CREATE)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setString(1, gastenBoekEntry.getNaam());
			statement.setTimestamp(2, Timestamp.valueOf(gastenBoekEntry.getDatumTijd()));
			statement.setString(3, gastenBoekEntry.getBericht());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException ex) {
			throw new RepositoryException(ex);
		}
	}
	private GastenBoekEntry resultSetRijNaarGastenBoekEntry(ResultSet resultSet) 
				throws SQLException {
		return new GastenBoekEntry(resultSet.getLong("id"), resultSet.getString("naam"), 
				resultSet.getTimestamp("datumTijd").toLocalDateTime(), resultSet.getString("bericht"));
	}
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsName {
    private static final String GET_VILLAINS_NAMES="select v.name, count( DISTINCT mv.minion_id) minions_count" +
            " from villains v" +
            " join minions_villains mv on v.id = mv.villain_id" +
            " group by mv.villain_id" +
            " having  minions_count > ?" +
            " order by minions_count";
    private static final String COLUMN_LABEL_MINIONS_COUNT="minions_count";
    private static final String PRINT_FORMAT="%s %d";
    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getSQLConnection();

       final PreparedStatement statement=connection.prepareStatement(GET_VILLAINS_NAMES);

       statement.setInt(1, 15);

       final ResultSet resultSet = statement.executeQuery();
       while (resultSet.next()){
           final String villainName=resultSet.getString(Constants.COLUMN_LABEL_NAME);
           final int minionsCount=resultSet.getInt(COLUMN_LABEL_MINIONS_COUNT);

           System.out.printf(PRINT_FORMAT, villainName, minionsCount);
       }
      connection.close();
    }
}

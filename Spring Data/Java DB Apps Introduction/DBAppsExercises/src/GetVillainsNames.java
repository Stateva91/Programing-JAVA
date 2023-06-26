import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES = "select v.name, count(distinct mv.minion_id) count_of_minions" +
            " from villains as v" +
            " join minions_villains mv on v.id = mv.villain_id" +
            " group by v.id" +
            " having count_of_minions > ?" +
            " order by count_of_minions DESC;";
    private static final  String COLUMN_LABEL_MINIONS_COUNT="count_of_minions";
    private static final  String PRINT_FORMAT="%s %d";
    public static void main(String[] args) throws SQLException {
       final Connection connection = Utils.getSQLConnection();
       final PreparedStatement statement= connection.prepareStatement(GET_VILLAINS_NAMES);
       statement.setInt(1, 15); // indeksite zapochvat ot 1
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            final String villainName=resultSet.getString(Constants.COLUMN_LABEL_NAME);
            final int minionsCount=resultSet.getInt(COLUMN_LABEL_MINIONS_COUNT);
            System.out.printf(PRINT_FORMAT, villainName, minionsCount);
        }
        connection.close();
        //resultSet.next();//vrushta cqlata informaciq,
        // koqto e chast ot zaqvkata, mesti kursora na sledvashtiq red
        // operaciq ot tip boolean
    }
}

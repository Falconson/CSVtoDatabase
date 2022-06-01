import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class CSVConsume {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/csv_to_database";
        String username = "root";
        String password = "MYSQL";
        String filePath = "C:\\Users\\Computer\\Downloads\\ABC-3xx.csv";

        int batchSize = 20;

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO register_numbering_with_city" +
                    "(abc_def, range_from, range_to, numbering_capacity," +
                    "operator, region_1, region_2, region_3, tin)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String regex = "[;\\|]";
            String lineText = null;
            int count = 0;

            lineReader.readLine();

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(regex);

                if (data.length == 7) {
                    String abc_def = data[0];
                    String range_from = data[1];
                    String range_to = data[2];
                    String numbering_capacity = data[3];
                    String operator = data[4];
                    String region_1 = data[5];
                    String region_2 = null;
                    String region_3 = null;
                    String tin = data[6];

                    statement.setInt(1, parseInt(abc_def));
                    statement.setInt(2, parseInt(range_from));
                    statement.setInt(3, parseInt(range_to));
                    statement.setInt(4, parseInt(numbering_capacity));
                    statement.setString(5, operator);
                    statement.setString(6, region_1);
                    statement.setString(7, region_2);
                    statement.setString(8, region_3);
                    statement.setLong(9, parseLong(tin));
                    statement.addBatch();
                    if (count % batchSize == 0)
                        statement.executeBatch();
                } else if (data.length == 8) {
                    String abc_def = data[0];
                    String range_from = data[1];
                    String range_to = data[2];
                    String numbering_capacity = data[3];
                    String operator = data[4];
                    String region_1 = data[5];
                    String region_2 = data[6];
                    String region_3 = null;
                    String tin = data[7];

                    statement.setInt(1, parseInt(abc_def));
                    statement.setInt(2, parseInt(range_from));
                    statement.setInt(3, parseInt(range_to));
                    statement.setInt(4, parseInt(numbering_capacity));
                    statement.setString(5, operator);
                    statement.setString(6, region_1);
                    statement.setString(7, region_2);
                    statement.setString(8, region_3);
                    statement.setLong(9, parseLong(tin));
                    statement.addBatch();
                    if (count % batchSize == 0)
                        statement.executeBatch();
                } else if (data.length == 9) {
                    String abc_def = data[0];
                    String range_from = data[1];
                    String range_to = data[2];
                    String numbering_capacity = data[3];
                    String operator = data[4];
                    String region_1 = data[5];
                    String region_2 = data[6];
                    String region_3 = data[7];
                    String tin = data[8];

                    statement.setInt(1, parseInt(abc_def));
                    statement.setInt(2, parseInt(range_from));
                    statement.setInt(3, parseInt(range_to));
                    statement.setInt(4, parseInt(numbering_capacity));
                    statement.setString(5, operator);
                    statement.setString(6, region_1);
                    statement.setString(7, region_2);
                    statement.setString(8, region_3);
                    statement.setLong(9, parseLong(tin));
                    statement.addBatch();
                    if (count % batchSize == 0)
                        statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Done");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }

    }
}

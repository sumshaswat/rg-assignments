package Q4;

public class DBConnection {
    private static DBConnection canObject = new DBConnection();

    private DBConnection() {

    }

    public static DBConnection getInstance() {
        return canObject;
    }

}

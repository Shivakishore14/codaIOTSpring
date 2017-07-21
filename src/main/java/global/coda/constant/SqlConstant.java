package global.coda.constant;

public class SqlConstant {
	public final static String LOGIN_USER_QUERY = "select id, email, firstname, lastname, phone, password from users where email = ?";
	public final static String CREATE_USER_QUERY = "insert into users(email, firstname, lastname, phone, password) values(?,?,?,?,?)";
	public final static String LIST_COMPANIES_OF_USER = "select cid , name, secret from company where cid in (select cid from user_company_mapping where userid = ?)";
	public final static String GET_COMPANY_BY_CID = "select cid , name, secret from company where cid = ?";
	public final static String GET_ADMIN_OF_COMPANY ="select id, email, firstname, lastname, phone, password from users where id in (select userid from user_company_mapping where role = 'admin' and cid = ?)";
	public final static String LIST_SENSOR_OF_COMPANY = "select id, type from sensors where cid = ?";
	public final static String LIST_USER_OF_COMPANY = "select email, firstname, lastname, phone, id from users where id in (select userid from user_company_mapping where cid = ? )";
	public final static String ADD_SENSOR = "insert into sensors(type, cid) values(?,?)";
	public final static String ADD_COMPANY = "insert into company(name, secret, addr1, addr2, city, state, country) values(?,?,?,?,?,?,?)";
	public final static String GET_SENSOR_DATA = "select timestamp, value from sensor_data where sid = ?";
	public final static String PUT_SENSOR_DATA = "insert into sensor_data(sid, timestamp, value) values(?,?,?)";
}

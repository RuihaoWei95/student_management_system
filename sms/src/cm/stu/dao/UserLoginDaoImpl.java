package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDaoImpl implements UserLoginDao{
    @Override
    public Person getLogin(Person person) {
        String sql = "select * from person where userAccount='" + person.getUserAccount() + "' and userPassword='" + person.getUserPassword() + "'";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        Person newPerson = null;
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                newPerson = new Person();
                //`userAccount``userName``userBirthday``userIdCard``userPassword``userIdentify`
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }


        return newPerson;
    }
}

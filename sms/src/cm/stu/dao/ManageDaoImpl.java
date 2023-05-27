package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageDaoImpl implements ManageDao{
    @Override
    public List<Person> getAllPerson() {
        String sql = "Select * from person where userIdentify!=2";
        return getAllPerson(sql);
    }

    private List<Person> getAllPerson(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Person> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Person newPerson = new Person();
                //`userAccount``userName``userSex``userBirthday``userIdCard``userPassword``userIdentify``userOtherName`
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
                list.add(newPerson);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;

    }
}

package org.example.crud;



import org.apache.commons.lang3.AnnotationUtils;

import java.sql.*;
import java.util.ArrayList;
import javax.security.auth.login.LoginException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.postgresql.util.MD5Digest.bytesToHex;


public class PersonDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/shop";
    static final String USER = "postgres";
    static final String PASS = "Samsung2023!";
    private String pass;
    private String name;
    private String email;
    private String country;


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Подключение прошло успешно");

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return connection;
    }

    public static int save(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into crud_example (userName,userPass,userEmail,userCountry) values(?,?,?,?)");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(person.getUserPass().getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02X", b));
                System.out.println(builder.toString());
            }
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, builder.toString());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    public static ArrayList<Person> getAllPersons() {
        ArrayList<Person> arrayList = new ArrayList<>();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                arrayList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayList;
    }

    public static int delete(Person person) {
        int status = 0;

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from crud_example where id =?");
            preparedStatement.setInt(1, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    public static Person getPersonById(int id) {
        Person person = new Person();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public static Person getPersonByName(String name) {
        Person person = new Person();
//        System.out.println("getPersonByName starts");
//        System.out.println(name);

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where username =?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("getPersonByName resultSets");
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public static int update(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update crud_example set userName=?,userPass=?,userEmail=?,userCountry=? where id=?");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(person.getUserPass().getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02X", b));
                System.out.println(builder.toString());
            }
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, builder.toString());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setInt(5, person.getId());

            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
        return status;
    }


    public static Person checkPersonIfExists(Person person) {
        int status = 0;

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where userEmail=? and userPass=?");
            preparedStatement.setString(1, person.getUserEmail());
            preparedStatement.setString(2, person.getUserPass());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                return person;
            }

            return null;
        } catch (
                SQLException e) {
            throw new RuntimeException(e);

        }}
     public void Pt(String name, String pass, String email, String country){
         this.pass = pass;
         this.name=name;
         this.email = email;
         this.country = country;
     }
        public static int update1(String name, String pass, String email, String country) {

            int status = 0;
            try {
                Connection connection = PersonDao.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("update crud_example set userName=?,userPass=?,userEmail=?,userCountry=? where userName=");

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, country);

                status = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return status;
        }
    public static int update2(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update crud_example set userName=?,userPass=?,userEmail=?,userCountry=? where id=?");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(person.getUserPass().getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02X", b));
                System.out.println(builder.toString());
            }
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, builder.toString());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setInt(5, person.getId());

            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}


